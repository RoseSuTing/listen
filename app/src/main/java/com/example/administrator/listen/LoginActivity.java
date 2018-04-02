package com.example.administrator.listen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

    }

    public void logClick(View view) {
        if (username.getText().toString().equals("") &&
                password.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainOptionActivity.class);
            startActivity(intent);
        }//end if
        else {
            Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
            counter--;
            Intent intent = new Intent(this, RegisterAccount.class);
            startActivity(intent);
            if (counter == 0) {
                login.setEnabled(false);
            }
        }//end logClick
    }

}//end class
