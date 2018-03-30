package com.example.administrator.listen;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class hiatoryActivity extends AppCompatActivity {

    public Button play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        play = findViewById(R.id.but_play);
    }

    public void play(View view)throws IllegalArgumentException,
            SecurityException, IllegalStateException, IOException {
        Intent intent=getIntent();//getIntent将该项目中包含的原始intent检索出来，将检索出来的intent赋值给一个Intent类型的变量intent
        Bundle bundle=intent.getExtras();//.getExtras()得到intent所附带的额外数据
        MediaPlayer m = new MediaPlayer();
        String str=bundle.getString("str");//getString()返回指定key的值
        m.setDataSource(str);
        m.prepare();
        m.start();
        Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
    }
}
