package com.example.kair_careforbabies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kair_careforbabies.Model.Users;
import com.example.kair_careforbabies.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    private Button joinButton, loginButton;
    private ProgressDialog pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = new ProgressDialog(this);
        joinButton =findViewById(R.id.join_now_btn);
        loginButton = findViewById(R.id.login_btn);
        Paper.init(this);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        String UserEmailKey = Paper.book().read(Prevalent.UserEmailKey);
        String UserPasswordKey = Paper.book().read(Prevalent.UserPasswordKey);

        if (UserEmailKey != "" && UserPasswordKey != "")
        {
            if (!TextUtils.isEmpty(UserEmailKey)  &&  !TextUtils.isEmpty(UserPasswordKey))
            {
                AllowAccess(UserEmailKey, UserPasswordKey);

                pb.setTitle("Already Logged in");
                pb.setMessage("Please wait.....");
                pb.setCanceledOnTouchOutside(false);
                pb.show();
            }
        }
    }



    private void AllowAccess(final String Email, final String Password)
    {
        final String uName[] = Email.split(".com");
        final DatabaseReference dbRef;
        dbRef = FirebaseDatabase.getInstance().getReference();


        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if (dataSnapshot.child("Customers").child(uName[0]).exists())
                {

                    Users usersData = dataSnapshot.child("Customers").child(uName[0]).getValue(Users.class);
                    //Toast.makeText(LoginActivity.this, "working till here", Toast.LENGTH_SHORT).show();

                    String dbUName[]= (usersData.getEmail()).split(".com");

                    if (dbUName[0].equals(uName[0]))
                    {
                        // Toast.makeText(LoginActivity.this, "working till here", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this, ""+(usersData.getPassword().equals(Password)), Toast.LENGTH_SHORT).show();
                        if (usersData.getPassword().equals(Password))
                        {
                            Toast.makeText(MainActivity.this, "Please wait, you are already logged in...", Toast.LENGTH_SHORT).show();
                            pb.dismiss();

                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            Prevalent.currentUser = usersData;
                            startActivity(intent);
                        }
                        else
                        {
                            pb.dismiss();
                            Toast.makeText(MainActivity.this, "Password is incorrect.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Account with this " + Email + " number do not exists.", Toast.LENGTH_SHORT).show();
                    pb.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    }


