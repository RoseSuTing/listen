package com.example.administrator.listen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {

    public Button play, delete;
    private TextView myTextView;
    //The arrayList to populate the listView
    private boolean sdcardExit;
    private File myRecAudioDir;
    private File myPlayFile;
    public ListView listView;
    /**按钮背景图片的标志位**/
    private boolean sigle = false;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> recordFiles = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_history);

        play = findViewById(R.id.btnPlay);
        delete = findViewById(R.id.delete);

        myTextView = findViewById(R.id.myTextView);

        play.setEnabled(true);
        delete.setEnabled(true);
        // 判断sd Card是否插入
        sdcardExit = Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED);
        // 取得sd card路径作为录音文件的位置
        if (sdcardExit) {
            String pathStr = Environment.getExternalStorageDirectory().getPath() + "/Listen";
            myRecAudioDir = new File(pathStr);
            Log.d("TAG", pathStr);
        }
            //Todo: The following is just for a demo purpose

            //Generate the dummy date to populate the listView
        /*
            Create a custom array adapter which  maps the strings to the views in the layout
            The default ArrayAdapter is too limited as we can only map a string to a view in the layout.
            In order to populate multiple views with different content, we need to create a custom Adapter.
         */
        myPlayFile=null;
            // 取得sd card 目录里的.arm文件
            getRecordFiles();

            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recordFiles);

            //The last step is to connect the listView and the Java class and to populate the list View using the ArrayAdapter
            listView = findViewById(R.id.listView_history);
            listView.setAdapter(adapter);

        // 删除
        delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sigle = true;
                // TODO Auto-generated method stub

                if (myPlayFile != null) {
                    // 先将Adapter删除文件名
                    adapter.remove(myPlayFile.getName());
                    // 删除文件
                    if (myPlayFile.exists())
                        myPlayFile.delete();
                    myTextView.setText("完成删除！");
                }
            }
        });

        // 播放
        play.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                sigle = true;
                // TODO Auto-generated method stub
                if (myPlayFile != null && myPlayFile.exists()) {
                    // 打开播放程序
                    openFile(myPlayFile);
                } else {
                    Toast.makeText(History.this, "你选的是一个空文件", Toast.LENGTH_LONG)
                            .show();
                    Log.d("没有选择文件","没有选择文件");
                }
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg, View arg1,
                                    int arg2, long arg3) {
                // TODO Auto-generated method stub
                // 当有单点击文件名时将删除按钮及播放按钮Enable
                play.setEnabled(true);
                delete.setEnabled(true);
                myPlayFile = new File(myRecAudioDir.getAbsolutePath() + File.separator + ((TextView) arg1).getText().toString());
                DecimalFormat df = new DecimalFormat("#.000");

                myTextView.setText("你选的是" + ((TextView) arg1).getText().toString());
                Toast.makeText(History.this,"你选的是" + (((TextView) arg1).getText()),
                        Toast.LENGTH_LONG).show();
            }

        });
    }

    private void openFile(File f) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(android.content.Intent.ACTION_VIEW);
        String type = getMIMEType(f);
        intent.setDataAndType(Uri.fromFile(f), type);
        startActivity(intent);
    }

    private String getMIMEType(File f) {
        String end = f.getName().substring(f.getName().lastIndexOf(".") + 1,
                f.getName().length()).toLowerCase();
        String type = "";
        if (end.equals("mp3") || end.equals("aac") || end.equals("amr")
                || end.equals("mpeg") || end.equals("mp4")) {
            type = "audio";
        } else if (end.equals("jpg") || end.equals("gif") || end.equals("png")
                || end.equals("jpeg")) {
            type = "image";
        } else {
            type = "*";
        }
        type += "/";
        return type;
    }

    //获取文件
    private void getRecordFiles() {
        // TODO Auto-generated method stub
        recordFiles = new ArrayList<String>();
        if (sdcardExit) {
            File files[] = myRecAudioDir.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].getName().indexOf(".") >= 0) { // 只取.amr 文件
                        String fileS = files[i].getName().substring(
                                files[i].getName().indexOf("."));
                        if (fileS.toLowerCase().equals(".mp3")
                                || fileS.toLowerCase().equals(".amr")
                                || fileS.toLowerCase().equals(".mp4"))
                            recordFiles.add(files[i].getName());
                    }
                }
            }
        }
    }
    /* Buttons */

    public void btnPlay(View view) {
        Toast.makeText(this, " Play", Toast.LENGTH_SHORT).show();
    }
    public void btnDelete(View view) {
        Toast.makeText(this, " Delete", Toast.LENGTH_SHORT).show();
    }
}
