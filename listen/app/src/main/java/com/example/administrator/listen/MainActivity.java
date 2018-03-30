package com.example.administrator.listen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);

    }
    public void logClick(View view) {
        if (username.getText().toString().equals("admin") &&
                password.getText().toString().equals("0000")) {
            Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
            Intent inter = new Intent(this,SecondActivity.class);
            startActivity(inter);
        }//end if
        else {
            Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
            counter--;
            Intent inter = new Intent(this,resigerActivity.class);
            startActivity(inter);
            if (counter == 0) {
                login.setEnabled(false);
            }
        }//end logClick
    }

}//end class
