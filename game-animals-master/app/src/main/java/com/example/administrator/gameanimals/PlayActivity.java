package com.example.administrator.gameanimals;

/**
 * Created by Administrator on 2018\3\23 0023.
 */

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {

    int x1=0,x2=1,x3=2,x4=3;
    String str[]={"bear","bird","cat","elephant","fish","flower","giraffe","honey","house",
            "hypo","kangaroo","leo","lion","pig","rhino","sun","tiger","wolf"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }
    public void btnClick1(View view) {
        //判断是否是对的图片
        TextView t1=(TextView)findViewById(R.id.text1);
        //如果是对的图片，就替换四个图片和文字
        if((t1.getText().toString()).equals(str[x1])){
            //生成四个随机数
            x1=0+(int)(Math.random()*19);
            do{
                x2=0+(int)(Math.random()*19);
            }while(x2==x1);
            do{
                x3 = 0 + (int) (Math.random() * 19);
            }while(x3==x1 ||x3==x2);
            do {
                x4 = 0 + (int) (Math.random() * 19);
            }while(x4==x1 || x4==x3 ||x4==x2);
            int[] str2= new int[]{x1, x2, x3, x4};
            int y=0+(int)(Math.random()*3);
            ((TextView)findViewById(R.id.text1)).setText(str[str2[y]]);
            Button bt1=(Button)findViewById(R.id.button1);
            Button bt2=(Button)findViewById(R.id.button2);
            Button bt3=(Button)findViewById(R.id.button3);
            Button bt4=(Button)findViewById(R.id.button4);
            switch(x1){
                case 0: bt1.setBackgroundResource(R.drawable.bear);break;
                case 1: bt1.setBackgroundResource(R.drawable.bird);break;
                case 2: bt1.setBackgroundResource(R.drawable.cat);break;
                case 3: bt1.setBackgroundResource(R.drawable.elephant);break;
                case 4: bt1.setBackgroundResource(R.drawable.fish);break;
                case 5: bt1.setBackgroundResource(R.drawable.flower);break;
                case 6: bt1.setBackgroundResource(R.drawable.giraffe);break;
                case 7: bt1.setBackgroundResource(R.drawable.honey);break;
                case 8: bt1.setBackgroundResource(R.drawable.house);break;
                case 9: bt1.setBackgroundResource(R.drawable.hypo);break;
                case 10: bt1.setBackgroundResource(R.drawable.kangaroo);break;
                case 11: bt1.setBackgroundResource(R.drawable.leo);break;
                case 12: bt1.setBackgroundResource(R.drawable.lion);break;
                case 13: bt1.setBackgroundResource(R.drawable.pig);break;
                case 14: bt1.setBackgroundResource(R.drawable.rhino);break;
                case 15: bt1.setBackgroundResource(R.drawable.sun);break;
                case 16: bt1.setBackgroundResource(R.drawable.tiger);break;
                case 17: bt1.setBackgroundResource(R.drawable.wolf);break;
            }
            switch(x2){
                case 0: bt2.setBackgroundResource(R.drawable.bear);break;
                case 1: bt2.setBackgroundResource(R.drawable.bird);break;
                case 2: bt2.setBackgroundResource(R.drawable.cat);break;
                case 3: bt2.setBackgroundResource(R.drawable.elephant);break;
                case 4: bt2.setBackgroundResource(R.drawable.fish);break;
                case 5: bt2.setBackgroundResource(R.drawable.flower);break;
                case 6: bt2.setBackgroundResource(R.drawable.giraffe);break;
                case 7: bt2.setBackgroundResource(R.drawable.honey);break;
                case 8: bt2.setBackgroundResource(R.drawable.house);break;
                case 9: bt2.setBackgroundResource(R.drawable.hypo);break;
                case 10: bt2.setBackgroundResource(R.drawable.kangaroo);break;
                case 11: bt2.setBackgroundResource(R.drawable.leo);break;
                case 12: bt2.setBackgroundResource(R.drawable.lion);break;
                case 13: bt2.setBackgroundResource(R.drawable.pig);break;
                case 14: bt2.setBackgroundResource(R.drawable.rhino);break;
                case 15: bt2.setBackgroundResource(R.drawable.sun);break;
                case 16: bt2.setBackgroundResource(R.drawable.tiger);break;
                case 17: bt2.setBackgroundResource(R.drawable.wolf);break;
            }
            switch(x3){
                case 0: bt3.setBackgroundResource(R.drawable.bear);break;
                case 1: bt3.setBackgroundResource(R.drawable.bird);break;
                case 2: bt3.setBackgroundResource(R.drawable.cat);break;
                case 3: bt3.setBackgroundResource(R.drawable.elephant);break;
                case 4: bt3.setBackgroundResource(R.drawable.fish);break;
                case 5: bt3.setBackgroundResource(R.drawable.flower);break;
                case 6: bt3.setBackgroundResource(R.drawable.giraffe);break;
                case 7: bt3.setBackgroundResource(R.drawable.honey);break;
                case 8: bt3.setBackgroundResource(R.drawable.house);break;
                case 9: bt3.setBackgroundResource(R.drawable.hypo);break;
                case 10: bt3.setBackgroundResource(R.drawable.kangaroo);break;
                case 11: bt3.setBackgroundResource(R.drawable.leo);break;
                case 12: bt3.setBackgroundResource(R.drawable.lion);break;
                case 13: bt3.setBackgroundResource(R.drawable.pig);break;
                case 14: bt3.setBackgroundResource(R.drawable.rhino);break;
                case 15: bt3.setBackgroundResource(R.drawable.sun);break;
                case 16: bt3.setBackgroundResource(R.drawable.tiger);break;
                case 17: bt3.setBackgroundResource(R.drawable.wolf);break;
            }
            switch(x4){
                case 0: bt4.setBackgroundResource(R.drawable.bear);break;
                case 1: bt4.setBackgroundResource(R.drawable.bird);break;
                case 2: bt4.setBackgroundResource(R.drawable.cat);break;
                case 3: bt4.setBackgroundResource(R.drawable.elephant);break;
                case 4: bt4.setBackgroundResource(R.drawable.fish);break;
                case 5: bt4.setBackgroundResource(R.drawable.flower);break;
                case 6: bt4.setBackgroundResource(R.drawable.giraffe);break;
                case 7: bt4.setBackgroundResource(R.drawable.honey);break;
                case 8: bt4.setBackgroundResource(R.drawable.house);break;
                case 9: bt4.setBackgroundResource(R.drawable.hypo);break;
                case 10: bt4.setBackgroundResource(R.drawable.kangaroo);break;
                case 11: bt4.setBackgroundResource(R.drawable.leo);break;
                case 12: bt4.setBackgroundResource(R.drawable.lion);break;
                case 13: bt4.setBackgroundResource(R.drawable.pig);break;
                case 14: bt4.setBackgroundResource(R.drawable.rhino);break;
                case 15: bt4.setBackgroundResource(R.drawable.sun);break;
                case 16: bt4.setBackgroundResource(R.drawable.tiger);break;
                case 17: bt4.setBackgroundResource(R.drawable.wolf);break;
            }
        }else{
            Toast.makeText(PlayActivity.this,"you are wrong",Toast.LENGTH_LONG).show();
        }
    }

    public void btnClick2(View view) {
        //判断是否是对的图片

        String str[]={"bear","bird","cat","elephant","fish","flower","giraffe","honey","house",
                "hypo","kangaroo","leo","lion","pig","rhino","sun","tiger","wolf"};
        TextView t1=(TextView)findViewById(R.id.text1);
        //如果是对的图片，就替换四个图片和文字
        if((t1.getText().toString()).equals(str[x2])){
            x1=0+(int)(Math.random()*19);
            do{
                x2=0+(int)(Math.random()*19);
            }while(x2==x1);
            do{
                x3 = 0 + (int) (Math.random() * 19);
            }while(x3==x1 ||x3==x2);
            do {
                x4 = 0 + (int) (Math.random() * 19);
            }while(x4==x1 || x4==x3 ||x4==x2);
            int[] str2= new int[]{x1, x2, x3, x4};
            int y=0+(int)(Math.random()*3);
            ((TextView)findViewById(R.id.text1)).setText(str[str2[y]]);
            Button bt1=(Button)findViewById(R.id.button1);
            Button bt2=(Button)findViewById(R.id.button2);
            Button bt3=(Button)findViewById(R.id.button3);
            Button bt4=(Button)findViewById(R.id.button4);
            switch(x1){
                case 0: bt1.setBackgroundResource(R.drawable.bear);break;
                case 1: bt1.setBackgroundResource(R.drawable.bird);break;
                case 2: bt1.setBackgroundResource(R.drawable.cat);break;
                case 3: bt1.setBackgroundResource(R.drawable.elephant);break;
                case 4: bt1.setBackgroundResource(R.drawable.fish);break;
                case 5: bt1.setBackgroundResource(R.drawable.flower);break;
                case 6: bt1.setBackgroundResource(R.drawable.giraffe);break;
                case 7: bt1.setBackgroundResource(R.drawable.honey);break;
                case 8: bt1.setBackgroundResource(R.drawable.house);break;
                case 9: bt1.setBackgroundResource(R.drawable.hypo);break;
                case 10: bt1.setBackgroundResource(R.drawable.kangaroo);break;
                case 11: bt1.setBackgroundResource(R.drawable.leo);break;
                case 12: bt1.setBackgroundResource(R.drawable.lion);break;
                case 13: bt1.setBackgroundResource(R.drawable.pig);break;
                case 14: bt1.setBackgroundResource(R.drawable.rhino);break;
                case 15: bt1.setBackgroundResource(R.drawable.sun);break;
                case 16: bt1.setBackgroundResource(R.drawable.tiger);break;
                case 17: bt1.setBackgroundResource(R.drawable.wolf);break;
            }
            switch(x2){
                case 0: bt2.setBackgroundResource(R.drawable.bear);break;
                case 1: bt2.setBackgroundResource(R.drawable.bird);break;
                case 2: bt2.setBackgroundResource(R.drawable.cat);break;
                case 3: bt2.setBackgroundResource(R.drawable.elephant);break;
                case 4: bt2.setBackgroundResource(R.drawable.fish);break;
                case 5: bt2.setBackgroundResource(R.drawable.flower);break;
                case 6: bt2.setBackgroundResource(R.drawable.giraffe);break;
                case 7: bt2.setBackgroundResource(R.drawable.honey);break;
                case 8: bt2.setBackgroundResource(R.drawable.house);break;
                case 9: bt2.setBackgroundResource(R.drawable.hypo);break;
                case 10: bt2.setBackgroundResource(R.drawable.kangaroo);break;
                case 11: bt2.setBackgroundResource(R.drawable.leo);break;
                case 12: bt2.setBackgroundResource(R.drawable.lion);break;
                case 13: bt2.setBackgroundResource(R.drawable.pig);break;
                case 14: bt2.setBackgroundResource(R.drawable.rhino);break;
                case 15: bt2.setBackgroundResource(R.drawable.sun);break;
                case 16: bt2.setBackgroundResource(R.drawable.tiger);break;
                case 17: bt2.setBackgroundResource(R.drawable.wolf);break;
            }
            switch(x3){
                case 0: bt3.setBackgroundResource(R.drawable.bear);break;
                case 1: bt3.setBackgroundResource(R.drawable.bird);break;
                case 2: bt3.setBackgroundResource(R.drawable.cat);break;
                case 3: bt3.setBackgroundResource(R.drawable.elephant);break;
                case 4: bt3.setBackgroundResource(R.drawable.fish);break;
                case 5: bt3.setBackgroundResource(R.drawable.flower);break;
                case 6: bt3.setBackgroundResource(R.drawable.giraffe);break;
                case 7: bt3.setBackgroundResource(R.drawable.honey);break;
                case 8: bt3.setBackgroundResource(R.drawable.house);break;
                case 9: bt3.setBackgroundResource(R.drawable.hypo);break;
                case 10: bt3.setBackgroundResource(R.drawable.kangaroo);break;
                case 11: bt3.setBackgroundResource(R.drawable.leo);break;
                case 12: bt3.setBackgroundResource(R.drawable.lion);break;
                case 13: bt3.setBackgroundResource(R.drawable.pig);break;
                case 14: bt3.setBackgroundResource(R.drawable.rhino);break;
                case 15: bt3.setBackgroundResource(R.drawable.sun);break;
                case 16: bt3.setBackgroundResource(R.drawable.tiger);break;
                case 17: bt3.setBackgroundResource(R.drawable.wolf);break;
            }
            switch(x4){
                case 0: bt4.setBackgroundResource(R.drawable.bear);break;
                case 1: bt4.setBackgroundResource(R.drawable.bird);break;
                case 2: bt4.setBackgroundResource(R.drawable.cat);break;
                case 3: bt4.setBackgroundResource(R.drawable.elephant);break;
                case 4: bt4.setBackgroundResource(R.drawable.fish);break;
                case 5: bt4.setBackgroundResource(R.drawable.flower);break;
                case 6: bt4.setBackgroundResource(R.drawable.giraffe);break;
                case 7: bt4.setBackgroundResource(R.drawable.honey);break;
                case 8: bt4.setBackgroundResource(R.drawable.house);break;
                case 9: bt4.setBackgroundResource(R.drawable.hypo);break;
                case 10: bt4.setBackgroundResource(R.drawable.kangaroo);break;
                case 11: bt4.setBackgroundResource(R.drawable.leo);break;
                case 12: bt4.setBackgroundResource(R.drawable.lion);break;
                case 13: bt4.setBackgroundResource(R.drawable.pig);break;
                case 14: bt4.setBackgroundResource(R.drawable.rhino);break;
                case 15: bt4.setBackgroundResource(R.drawable.sun);break;
                case 16: bt4.setBackgroundResource(R.drawable.tiger);break;
                case 17: bt4.setBackgroundResource(R.drawable.wolf);break;
            }
        }else{
            Toast.makeText(PlayActivity.this,"you are wrong",Toast.LENGTH_LONG).show();
        }
    }

    public void btnClick3(View view) {
        //判断是否是对的图片

        String str[]={"bear","bird","cat","elephant","fish","flower","giraffe","honey","house",
                "hypo","kangaroo","leo","lion","pig","rhino","sun","tiger","wolf"};
        TextView t1=(TextView)findViewById(R.id.text1);
        //如果是对的图片，就替换四个图片和文字
        if((t1.getText().toString()).equals(str[x3])){
            x1=0+(int)(Math.random()*19);
            do{
                x2=0+(int)(Math.random()*19);
            }while(x2==x1);
            do{
                x3 = 0 + (int) (Math.random() * 19);
            }while(x3==x1 ||x3==x2);
            do {
                x4 = 0 + (int) (Math.random() * 19);
            }while(x4==x1 || x4==x3 ||x4==x2);
            int[] str2= new int[]{x1, x2, x3, x4};
            int y=0+(int)(Math.random()*3);
            ((TextView)findViewById(R.id.text1)).setText(str[str2[y]]);
            Button bt1=(Button)findViewById(R.id.button1);
            Button bt2=(Button)findViewById(R.id.button2);
            Button bt3=(Button)findViewById(R.id.button3);
            Button bt4=(Button)findViewById(R.id.button4);
            switch(x1){
                case 0: bt1.setBackgroundResource(R.drawable.bear);break;
                case 1: bt1.setBackgroundResource(R.drawable.bird);break;
                case 2: bt1.setBackgroundResource(R.drawable.cat);break;
                case 3: bt1.setBackgroundResource(R.drawable.elephant);break;
                case 4: bt1.setBackgroundResource(R.drawable.fish);break;
                case 5: bt1.setBackgroundResource(R.drawable.flower);break;
                case 6: bt1.setBackgroundResource(R.drawable.giraffe);break;
                case 7: bt1.setBackgroundResource(R.drawable.honey);break;
                case 8: bt1.setBackgroundResource(R.drawable.house);break;
                case 9: bt1.setBackgroundResource(R.drawable.hypo);break;
                case 10: bt1.setBackgroundResource(R.drawable.kangaroo);break;
                case 11: bt1.setBackgroundResource(R.drawable.leo);break;
                case 12: bt1.setBackgroundResource(R.drawable.lion);break;
                case 13: bt1.setBackgroundResource(R.drawable.pig);break;
                case 14: bt1.setBackgroundResource(R.drawable.rhino);break;
                case 15: bt1.setBackgroundResource(R.drawable.sun);break;
                case 16: bt1.setBackgroundResource(R.drawable.tiger);break;
                case 17: bt1.setBackgroundResource(R.drawable.wolf);break;
            }
            switch(x2){
                case 0: bt2.setBackgroundResource(R.drawable.bear);break;
                case 1: bt2.setBackgroundResource(R.drawable.bird);break;
                case 2: bt2.setBackgroundResource(R.drawable.cat);break;
                case 3: bt2.setBackgroundResource(R.drawable.elephant);break;
                case 4: bt2.setBackgroundResource(R.drawable.fish);break;
                case 5: bt2.setBackgroundResource(R.drawable.flower);break;
                case 6: bt2.setBackgroundResource(R.drawable.giraffe);break;
                case 7: bt2.setBackgroundResource(R.drawable.honey);break;
                case 8: bt2.setBackgroundResource(R.drawable.house);break;
                case 9: bt2.setBackgroundResource(R.drawable.hypo);break;
                case 10: bt2.setBackgroundResource(R.drawable.kangaroo);break;
                case 11: bt2.setBackgroundResource(R.drawable.leo);break;
                case 12: bt2.setBackgroundResource(R.drawable.lion);break;
                case 13: bt2.setBackgroundResource(R.drawable.pig);break;
                case 14: bt2.setBackgroundResource(R.drawable.rhino);break;
                case 15: bt2.setBackgroundResource(R.drawable.sun);break;
                case 16: bt2.setBackgroundResource(R.drawable.tiger);break;
                case 17: bt2.setBackgroundResource(R.drawable.wolf);break;
            }
            switch(x3){
                case 0: bt3.setBackgroundResource(R.drawable.bear);break;
                case 1: bt3.setBackgroundResource(R.drawable.bird);break;
                case 2: bt3.setBackgroundResource(R.drawable.cat);break;
                case 3: bt3.setBackgroundResource(R.drawable.elephant);break;
                case 4: bt3.setBackgroundResource(R.drawable.fish);break;
                case 5: bt3.setBackgroundResource(R.drawable.flower);break;
                case 6: bt3.setBackgroundResource(R.drawable.giraffe);break;
                case 7: bt3.setBackgroundResource(R.drawable.honey);break;
                case 8: bt3.setBackgroundResource(R.drawable.house);break;
                case 9: bt3.setBackgroundResource(R.drawable.hypo);break;
                case 10: bt3.setBackgroundResource(R.drawable.kangaroo);break;
                case 11: bt3.setBackgroundResource(R.drawable.leo);break;
                case 12: bt3.setBackgroundResource(R.drawable.lion);break;
                case 13: bt3.setBackgroundResource(R.drawable.pig);break;
                case 14: bt3.setBackgroundResource(R.drawable.rhino);break;
                case 15: bt3.setBackgroundResource(R.drawable.sun);break;
                case 16: bt3.setBackgroundResource(R.drawable.tiger);break;
                case 17: bt3.setBackgroundResource(R.drawable.wolf);break;
            }
            switch(x4){
                case 0: bt4.setBackgroundResource(R.drawable.bear);break;
                case 1: bt4.setBackgroundResource(R.drawable.bird);break;
                case 2: bt4.setBackgroundResource(R.drawable.cat);break;
                case 3: bt4.setBackgroundResource(R.drawable.elephant);break;
                case 4: bt4.setBackgroundResource(R.drawable.fish);break;
                case 5: bt4.setBackgroundResource(R.drawable.flower);break;
                case 6: bt4.setBackgroundResource(R.drawable.giraffe);break;
                case 7: bt4.setBackgroundResource(R.drawable.honey);break;
                case 8: bt4.setBackgroundResource(R.drawable.house);break;
                case 9: bt4.setBackgroundResource(R.drawable.hypo);break;
                case 10: bt4.setBackgroundResource(R.drawable.kangaroo);break;
                case 11: bt4.setBackgroundResource(R.drawable.leo);break;
                case 12: bt4.setBackgroundResource(R.drawable.lion);break;
                case 13: bt4.setBackgroundResource(R.drawable.pig);break;
                case 14: bt4.setBackgroundResource(R.drawable.rhino);break;
                case 15: bt4.setBackgroundResource(R.drawable.sun);break;
                case 16: bt4.setBackgroundResource(R.drawable.tiger);break;
                case 17: bt4.setBackgroundResource(R.drawable.wolf);break;
            }
        }else{
            Toast.makeText(PlayActivity.this,"you are wrong",Toast.LENGTH_LONG).show();
        }
    }

    public void btnClick4(View view) {
        //判断是否是对的图片

        String str[]={"bear","bird","cat","elephant","fish","flower","giraffe","honey","house",
                "hypo","kangaroo","leo","lion","pig","rhino","sun","tiger","wolf"};
        TextView t1=(TextView)findViewById(R.id.text1);
        //如果是对的图片，就替换四个图片和文字
        if((t1.getText().toString()).equals(str[x4])){
            x1=0+(int)(Math.random()*19);
            do{
                x2=0+(int)(Math.random()*19);
            }while(x2==x1);
            do{
                x3 = 0 + (int) (Math.random() * 19);
            }while(x3==x1 ||x3==x2);
            do {
                x4 = 0 + (int) (Math.random() * 19);
            }while(x4==x1 || x4==x3 ||x4==x2);
            int[] str2= new int[]{x1, x2, x3, x4};
            int y=0+(int)(Math.random()*3);
            ((TextView)findViewById(R.id.text1)).setText(str[str2[y]]);
            Button bt1=(Button)findViewById(R.id.button1);
            Button bt2=(Button)findViewById(R.id.button2);
            Button bt3=(Button)findViewById(R.id.button3);
            Button bt4=(Button)findViewById(R.id.button4);
            switch(x1){
                case 0: bt1.setBackgroundResource(R.drawable.bear);break;
                case 1: bt1.setBackgroundResource(R.drawable.bird);break;
                case 2: bt1.setBackgroundResource(R.drawable.cat);break;
                case 3: bt1.setBackgroundResource(R.drawable.elephant);break;
                case 4: bt1.setBackgroundResource(R.drawable.fish);break;
                case 5: bt1.setBackgroundResource(R.drawable.flower);break;
                case 6: bt1.setBackgroundResource(R.drawable.giraffe);break;
                case 7: bt1.setBackgroundResource(R.drawable.honey);break;
                case 8: bt1.setBackgroundResource(R.drawable.house);break;
                case 9: bt1.setBackgroundResource(R.drawable.hypo);break;
                case 10: bt1.setBackgroundResource(R.drawable.kangaroo);break;
                case 11: bt1.setBackgroundResource(R.drawable.leo);break;
                case 12: bt1.setBackgroundResource(R.drawable.lion);break;
                case 13: bt1.setBackgroundResource(R.drawable.pig);break;
                case 14: bt1.setBackgroundResource(R.drawable.rhino);break;
                case 15: bt1.setBackgroundResource(R.drawable.sun);break;
                case 16: bt1.setBackgroundResource(R.drawable.tiger);break;
                case 17: bt1.setBackgroundResource(R.drawable.wolf);break;
            }
            switch(x2){
                case 0: bt2.setBackgroundResource(R.drawable.bear);break;
                case 1: bt2.setBackgroundResource(R.drawable.bird);break;
                case 2: bt2.setBackgroundResource(R.drawable.cat);break;
                case 3: bt2.setBackgroundResource(R.drawable.elephant);break;
                case 4: bt2.setBackgroundResource(R.drawable.fish);break;
                case 5: bt2.setBackgroundResource(R.drawable.flower);break;
                case 6: bt2.setBackgroundResource(R.drawable.giraffe);break;
                case 7: bt2.setBackgroundResource(R.drawable.honey);break;
                case 8: bt2.setBackgroundResource(R.drawable.house);break;
                case 9: bt2.setBackgroundResource(R.drawable.hypo);break;
                case 10: bt2.setBackgroundResource(R.drawable.kangaroo);break;
                case 11: bt2.setBackgroundResource(R.drawable.leo);break;
                case 12: bt2.setBackgroundResource(R.drawable.lion);break;
                case 13: bt2.setBackgroundResource(R.drawable.pig);break;
                case 14: bt2.setBackgroundResource(R.drawable.rhino);break;
                case 15: bt2.setBackgroundResource(R.drawable.sun);break;
                case 16: bt2.setBackgroundResource(R.drawable.tiger);break;
                case 17: bt2.setBackgroundResource(R.drawable.wolf);break;
            }
            switch(x3){
                case 0: bt3.setBackgroundResource(R.drawable.bear);break;
                case 1: bt3.setBackgroundResource(R.drawable.bird);break;
                case 2: bt3.setBackgroundResource(R.drawable.cat);break;
                case 3: bt3.setBackgroundResource(R.drawable.elephant);break;
                case 4: bt3.setBackgroundResource(R.drawable.fish);break;
                case 5: bt3.setBackgroundResource(R.drawable.flower);break;
                case 6: bt3.setBackgroundResource(R.drawable.giraffe);break;
                case 7: bt3.setBackgroundResource(R.drawable.honey);break;
                case 8: bt3.setBackgroundResource(R.drawable.house);break;
                case 9: bt3.setBackgroundResource(R.drawable.hypo);break;
                case 10: bt3.setBackgroundResource(R.drawable.kangaroo);break;
                case 11: bt3.setBackgroundResource(R.drawable.leo);break;
                case 12: bt3.setBackgroundResource(R.drawable.lion);break;
                case 13: bt3.setBackgroundResource(R.drawable.pig);break;
                case 14: bt3.setBackgroundResource(R.drawable.rhino);break;
                case 15: bt3.setBackgroundResource(R.drawable.sun);break;
                case 16: bt3.setBackgroundResource(R.drawable.tiger);break;
                case 17: bt3.setBackgroundResource(R.drawable.wolf);break;
            }
            switch(x4){
                case 0: bt4.setBackgroundResource(R.drawable.bear);break;
                case 1: bt4.setBackgroundResource(R.drawable.bird);break;
                case 2: bt4.setBackgroundResource(R.drawable.cat);break;
                case 3: bt4.setBackgroundResource(R.drawable.elephant);break;
                case 4: bt4.setBackgroundResource(R.drawable.fish);break;
                case 5: bt4.setBackgroundResource(R.drawable.flower);break;
                case 6: bt4.setBackgroundResource(R.drawable.giraffe);break;
                case 7: bt4.setBackgroundResource(R.drawable.honey);break;
                case 8: bt4.setBackgroundResource(R.drawable.house);break;
                case 9: bt4.setBackgroundResource(R.drawable.hypo);break;
                case 10: bt4.setBackgroundResource(R.drawable.kangaroo);break;
                case 11: bt4.setBackgroundResource(R.drawable.leo);break;
                case 12: bt4.setBackgroundResource(R.drawable.lion);break;
                case 13: bt4.setBackgroundResource(R.drawable.pig);break;
                case 14: bt4.setBackgroundResource(R.drawable.rhino);break;
                case 15: bt4.setBackgroundResource(R.drawable.sun);break;
                case 16: bt4.setBackgroundResource(R.drawable.tiger);break;
                case 17: bt4.setBackgroundResource(R.drawable.wolf);break;
            }
        }else{
            Toast.makeText(PlayActivity.this,"you are wrong",Toast.LENGTH_LONG).show();
        }
    }
}