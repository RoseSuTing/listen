package com.example.administrator.animal;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button button;
    public Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);

        //设置字体
        Typeface tf = Typeface.createFromAsset(getAssets(),"Fonts/ARBERKLEY.ttf");
        button.setTypeface(tf);
        button2.setTypeface(tf);

    }

    public void onClick(View view){
        if(view.getId()==R.id.button)
        {
            Intent intent = new Intent(this,game_activity.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.button2)
        {
            System.exit(0);
        }
    }
}
