package com.example.administrator.listen;

import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class askingActivity extends AppCompatActivity {

    public ImageView img_said;
    public ImageView img_stop_said;
    public MediaRecorder myAndroidRecod;
    public String outputFile = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asking);

        img_said=findViewById(R.id.img_said);
        img_stop_said=findViewById(R.id.img_stop_said);

        img_stop_said.setEnabled(false);  //设置初始停止按钮不可见

        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath()+"/myrecording.3gp";
        myAndroidRecod = new MediaRecorder();
        myAndroidRecod.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAndroidRecod.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAndroidRecod.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAndroidRecod.setOutputFile(outputFile);
    }

    public void start(View view){
        try {
            myAndroidRecod.prepare();
            myAndroidRecod.start();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        img_said.setEnabled(false);
        img_stop_said.setEnabled(true);
        Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();

    }
    public void stop(View view){
        myAndroidRecod.stop();
        myAndroidRecod.release();
        myAndroidRecod  = null;
        img_stop_said.setEnabled(false);
        img_said.setEnabled(true);
        Toast.makeText(getApplicationContext(), "Audio recorded successfully",
                Toast.LENGTH_LONG).show();
    }

    public void save(View view)throws IllegalArgumentException,
            SecurityException, IllegalStateException, IOException {
        Intent intent = new Intent(this,hiatoryActivity.class);
        intent.putExtra("str",outputFile);
        startActivity(intent);
    }
}
