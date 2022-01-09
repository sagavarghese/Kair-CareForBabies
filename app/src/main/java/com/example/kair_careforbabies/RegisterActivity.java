package com.example.kair_careforbabies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private Button createButton;
    private EditText InputName,InputEmail,InputPassword;
    private ProgressDialog pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        createButton = findViewById(R.id.register_btn);
        InputName = findViewById(R.id.username_input);
        InputEmail = findViewById(R.id.email_input);
        InputPassword = findViewById(R.id.password_input);
        pb = new ProgressDialog(this);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createAccount();
            }
        });

    }

    public void createAccount(){
        String userName = InputName.getText().toString();
        String email = InputEmail.getText().toString();
        String password = InputPassword.getText().toString();
        Toast.makeText(RegisterActivity.this, ""+email.toString(), Toast.LENGTH_SHORT).show();
        if(TextUtils.isEmpty(userName)){
            Toast.makeText(this, "Please Enter Your User Name", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please Enter Your Email Address", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please Choose Your Password", Toast.LENGTH_SHORT).show();
        }
        else{
            pb.setTitle("Create Account");
            pb.setMessage("Checking Credentials, Please Wait....");
            pb.setCanceledOnTouchOutside(false);
            pb.show();

            validateCredentials(userName,email,password);
        }

    }

    public void validateCredentials(final String userName,final String email,final String password){
        final String uName[] = email.split(".com");
        final DatabaseReference dbRef;
        dbRef = FirebaseDatabase.getInstance().getReference();
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(!(dataSnapshot.child("Customers").child(uName[0]).exists())){
                    HashMap<String,Object> userdataMap = new HashMap<>();
                    userdataMap.put("email",email);
                    userdataMap.put("userName",userName);
                    userdataMap.put("password",password);


                    dbRef.child("Customers").child(uName[0]).updateChildren(userdataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Thank you for joining us....", Toast.LENGTH_SHORT).show();
                                pb.dismiss();
                                Intent intent =new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent);
                            }
                            else {
                                pb.dismiss();
                                Toast.makeText(RegisterActivity.this, "Please try again...", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    pb.dismiss();
                    Toast.makeText(RegisterActivity.this, "This Email ID already exist, please try again using another Email ID", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
