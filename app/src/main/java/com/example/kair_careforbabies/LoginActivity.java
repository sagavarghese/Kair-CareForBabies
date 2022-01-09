package com.example.kair_careforbabies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kair_careforbabies.Admin.CategoryAdminActivity;
import com.example.kair_careforbabies.Model.Users;
import com.example.kair_careforbabies.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity {
    private EditText InputEmail, InputPassword;
    private Button LoginButton;
    private ProgressDialog pb;
    private TextView AdminLink, ForgetPasswordLink,NotAdminLink;
    private String dbName = "Customers";
    private CheckBox chkBoxRememberMe;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String Email = "emailKey";
    public static final String Password = "passKey";
    public static final String UName = "UnameKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Paper.init(this);
        LoginButton = (Button) findViewById(R.id.login_btn);
        InputEmail = (EditText) findViewById(R.id.login_email);
        InputPassword = (EditText) findViewById(R.id.login_password);
        AdminLink = (TextView) findViewById(R.id.admin_panel_link);
        NotAdminLink = (TextView)findViewById(R.id.not_admin_panel_link);
        ForgetPasswordLink = findViewById(R.id.forget_password_link);
        pb = new ProgressDialog(this);
        chkBoxRememberMe = (CheckBox) findViewById(R.id.remember_me_chkb);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                userLogin();
            }
        });

//        ForgetPasswordLink.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
//                intent.putExtra("check", "login");
//                startActivity(intent);
//            }
//        });

        AdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                LoginButton.setText("Admin Login");
                AdminLink.setVisibility(View.INVISIBLE);
                NotAdminLink.setVisibility(View.VISIBLE);
                chkBoxRememberMe.setVisibility(View.INVISIBLE);
                dbName = "Admins";
            }
        });

        NotAdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                LoginButton.setText("Login");
                AdminLink.setVisibility(View.VISIBLE);
                NotAdminLink.setVisibility(View.INVISIBLE);
                dbName = "Users";
            }
        });
    }



    private void userLogin()
    {
        String Email = InputEmail.getText().toString().trim();
        String Password = InputPassword.getText().toString();

        if (TextUtils.isEmpty(Email))
        {
            Toast.makeText(this, "Please Enter Your Email ", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Password))
        {
            Toast.makeText(this, "Please enter your Password", Toast.LENGTH_SHORT).show();
        }
        else
        {
            pb.setTitle("Login Account");
            pb.setMessage("Please wait, while we are checking the credentials.");
            pb.setCanceledOnTouchOutside(false);
            pb.show();


            AllowAccessToAccount(Email, Password);
        }
    }



    private void AllowAccessToAccount(final String Email, final String Password)
    {

        final String uName[] = Email.split(".com");
       // Toast.makeText(this, ""+uName[0], Toast.LENGTH_SHORT).show();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Email, Email);
        editor.putString(Password, Password);
        editor.commit();
        if(chkBoxRememberMe.isChecked())
        {
//             editor = sharedpreferences.edit();
//            editor.putString(Email, Email);
//            editor.putString(Password, Password);
//            editor.commit();
            Paper.book().write(Prevalent.UserEmailKey,Email );
            Paper.book().write(Prevalent.UserPasswordKey, Password);
        }


        final DatabaseReference dbRef;
        dbRef = FirebaseDatabase.getInstance().getReference();


        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if (dataSnapshot.child(dbName).child(uName[0]).exists())
                {

                    Users usersData = dataSnapshot.child(dbName).child(uName[0]).getValue(Users.class);
                    //Toast.makeText(LoginActivity.this, "working till here", Toast.LENGTH_SHORT).show();

                    String dbUName[]= (usersData.getEmail()).split(".com");

                    if (dbUName[0].equals(uName[0]))
                    {
                       // Toast.makeText(LoginActivity.this, "working till here", Toast.LENGTH_SHORT).show();
                        Toast.makeText(LoginActivity.this, ""+(usersData.getPassword().equals(Password)), Toast.LENGTH_SHORT).show();
                        if (usersData.getPassword().equals(Password))
                        {
                            if (dbName.equals("Admins"))
                            {
                                Toast.makeText(LoginActivity.this, "Welcome Admin, you are logged in Successfully...", Toast.LENGTH_SHORT).show();
                                pb.dismiss();

                                Intent intent = new Intent(LoginActivity.this, CategoryAdminActivity.class);
                                startActivity(intent);
                            }
                            if  (dbName.equals("Customers"))
                            {
                                Toast.makeText(LoginActivity.this, "logged in Successfully...", Toast.LENGTH_SHORT).show();
                                pb.dismiss();

                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                Prevalent.currentUser = usersData;
                                startActivity(intent);
                            }
                        }
                        else
                        {
                            pb.dismiss();
                            Toast.makeText(LoginActivity.this, "Password is incorrect.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Account with this " + Email + " number do not exists.", Toast.LENGTH_SHORT).show();
                    pb.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        editor.putString(UName, uName[0]);
    }
}



