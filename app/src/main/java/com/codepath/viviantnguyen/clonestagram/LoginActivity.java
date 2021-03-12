package com.codepath.viviantnguyen.clonestagram;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG = "LoginActivity";

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (ParseUser.getCurrentUser() != null) {
            travelMainAct();
        }

        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick login button");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username, password);
            }
        });
    }

    private void loginUser(String username, String password) {
        Log.i(TAG, "Attempting to login user " + username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e!= null) {
                    //better error handling soon
                    Toast.makeText(LoginActivity.this, "Error logging in.",Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "Issue with login: ",e);
                    return;
                }
                //if user signs in properly, navigate to main activity
                travelMainAct();
                Toast.makeText(LoginActivity.this, "Success!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void travelMainAct() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
