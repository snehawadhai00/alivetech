package com.alivetech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private MaterialButton register,login;
    private TextInputLayout username,password;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        intialise();

        //lamba expression
        this.login.setOnClickListener(this::loginMethod);
    }

    private void loginMethod(View view) {

        String user = username.getEditText().getText().toString();
        String pass = password.getEditText().getText().toString();
        //validation
        if (user.isEmpty()){
            username.setError("Please Fill Username");
            username.requestFocus();
            return;
        }
        if (pass.isEmpty()){
            password.setError("Please fill Password");
            password.requestFocus();
            return;
        }
        if (user.equals("alivetech") && pass.equals("alive@123")){
            progressBar.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
                    startActivity(intent);
                    username.getEditText().setText("");
                    password.getEditText().setText("");
                    username.requestFocus();
                    progressBar.setVisibility(View.GONE);
                }
            },5000);

        }else{
            Toast.makeText(this, "Username & password Mismatch", Toast.LENGTH_LONG).show();
        }

    }

    private void intialise() {
        register = findViewById(R.id.btnLoginRegister);
        login = findViewById(R.id.btnLogin);
        username = findViewById(R.id.tilLoginUsername);
        password = findViewById(R.id.tilLoginpassword);
        progressBar = findViewById(R.id.LoginprogressBar);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //business logic
                Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}