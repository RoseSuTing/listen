package com.example.administrator.listen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Listening extends AppCompatActivity {

    public ImageView img_stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen);

        img_stop=findViewById(R.id.imgstop);
    }

    public void imgClick(View view) {
        img_stop.setImageResource(R.drawable.begin);
    }
}
