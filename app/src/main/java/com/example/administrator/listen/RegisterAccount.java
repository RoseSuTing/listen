package com.example.administrator.listen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class RegisterAccount extends AppCompatActivity {

    public EditText username;
    public EditText password;
    public EditText password_again;
    public TextView check_number;
    public EditText ccknumb;
    public Button but_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);


        check_number = findViewById(R.id.text_checknum);
        ccknumb = findViewById(R.id.check_numb);
        but_register = findViewById(R.id.btnRegister);

        CheckNumber();
    }

    public void CheckNumber() {
        Random random = new Random();
        int i = random.nextInt(50) + 100;
        check_number.setText(String.valueOf(i));

    }

}
