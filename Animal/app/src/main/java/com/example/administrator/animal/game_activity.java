package com.example.administrator.animal;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class game_activity extends AppCompatActivity {

    public TextView text;
    public TextView textView;
    public ImageView image;
    public ImageView image1;
    public ImageView image2;
    public ImageView image3;
    public ImageView image4;
    public ImageView image5;
    public int m = 0;
    public int Score =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_activity);

        text=(TextView)findViewById(R.id.text);
        textView=(TextView)findViewById(R.id.textView);
        image=(ImageView)findViewById(R.id.image);
        image1=(ImageView)findViewById(R.id.image1);
        image2=(ImageView)findViewById(R.id.image2);
        image3=(ImageView)findViewById(R.id.image3);
        image4=(ImageView)findViewById(R.id.image4);
        image5=(ImageView)findViewById(R.id.image5);

        //字体
        Typeface tf = Typeface.createFromAsset(getAssets(),"Fonts/ARBERKLEY.ttf");
        textView.setTypeface(tf);
        Random();
    }

    public void Random(){

        if(Score<=6) {
            Random random=new Random();
            int i = random.nextInt(6);
            switch (i) {
                case 0:
                    text.setText("Like tiger than small tiger,work in the night.love catch mouse,said miao");
                    m = 0;
                    break;
                case 1:
                    text.setText("A long nose, a fan on the head, four thick pillars, a little braid.");
                    m = 1;
                    break;
                case 2:
                    text.setText("Life is always busy, love one hundred Linghai, come back to offer a thing, sweet over sugar");
                    m = 2;
                    break;
                case 3:
                    text.setText("This home in Africa, and strength greater than cattle, mouth with a roar, the animals are trembling");
                    m = 3;
                    break;
                case 4:
                    text.setText("Big fat feet, like a big fool, short and thick limbs, love to wear white gown");
                    m = 4;
                    break;
                case 5:
                    text.setText("Long born neck, wearing a spotted dress. Want to eat tender leaves, no effort.");
                    m = 5;
                    break;
            }// end of switch
        }
        if(Score>6)
        {
            Random random=new Random();
            int j=random.nextInt(6)+6;
            switch(j)
            {
                case 6:
                    text.setText("Feet jump, noisy, eating insects eat too little power.");
                    m=6;
                    break;
                case 7:
                    text.setText("A knife, floating along. There are eyes, no eyebrows.");
                    m=7;
                    break;
                case 8:
                    text.setText("Go east early to the west, laugh at the sun");
                    m=8;
                    break;
                case 9:
                    text.setText("a place to live for ours");
                    m=9;
                    break;
                case 10:
                    text.setText("Small feet, small fur, large size love to roll mud");
                    m=10;
                    break;
                case 11:
                    text.setText("The baby has a long pocket under his belly. The child eats and sleeps in the bag. It can't run fast.");
                    m=11;
                    break;
            }// end of switch
        }
    }//end of Random

    public void onClick(View view)
    {

        if(Score<=6) {
            switch(view.getId())
            {
                case R.id.image:
                    if(m==0)
                    {
                        Random();
                        Score++;
                    }
                    else Toast.makeText(this,"find again",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.image1:
                    if(m==1)
                    {
                        Random();
                        Score++;
                    }
                    else Toast.makeText(this,"find again",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.image2:
                    if(m==2)
                    {
                        Random();
                        Score++;
                    }
                    else Toast.makeText(this,"find again",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.image3:
                    if(m==3)
                    {
                        Random();
                        Score++;
                    }
                    else Toast.makeText(this,"find again",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.image4:
                    if(m==4)
                    {
                        Random();
                        Score++;
                    }
                    else Toast.makeText(this,"find again",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.image5:
                    if(m==5)
                    {
                        Random();
                        Score++;
                    }
                    else Toast.makeText(this,"find again",Toast.LENGTH_SHORT).show();
                    break;
            }
            textView.setText("SCORE:"+Score);
        }
        else if(Score == 7) {
            image.setImageResource(R.drawable.bird);
            image1.setImageResource(R.drawable.fish);
            image2.setImageResource(R.drawable.flower);
            image3.setImageResource(R.drawable.house);
            image4.setImageResource(R.drawable.hypo);
            image5.setImageResource(R.drawable.kangaroo);
            Random();
            Score++;
        }
        else if(Score>7 && Score<=12)
        {
            switch(view.getId())
        {
            case R.id.image:
                if(m==6)
                {
                    Random();
                    Score++;
                }
                else Toast.makeText(this,"find again",Toast.LENGTH_SHORT).show();
                break;
            case R.id.image1:
                if(m==7)
                {
                    Random();
                    Score++;
                }
                else Toast.makeText(this,"find again",Toast.LENGTH_SHORT).show();
                break;
            case R.id.image2:
                if(m==8)
                {
                    Random();
                    Score++;
                }
                else Toast.makeText(this,"find again",Toast.LENGTH_SHORT).show();
                break;
            case R.id.image3:
                if(m==9)
                {
                    Random();
                    Score++;
                }
                else Toast.makeText(this,"find again",Toast.LENGTH_SHORT).show();
                break;
            case R.id.image4:
                if(m==10)
                {
                    Random();
                    Score++;
                }
                else Toast.makeText(this,"find again",Toast.LENGTH_SHORT).show();
                break;
            case R.id.image5:
                if(m==11)
                {
                    Random();
                    Score++;
                }
                else Toast.makeText(this,"find again",Toast.LENGTH_SHORT).show();
                break;
        }
            textView.setText("SCORE:"+Score);
        }
        else if (Score>12)
        {
            text.setText("Well  you had finish the game");
        }
    }

}
