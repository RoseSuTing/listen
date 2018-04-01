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

public class hiatoryActivity extends AppCompatActivity {

    public Button play,delete;
    private ListView listview;
    private TextView myTextView;
    private ArrayList<String> recordFiles= new ArrayList<String>();
    private ArrayList<String> list = new ArrayList<String>();
    private File myPlayFile;
    private String length1 = null;
    private ArrayAdapter<String> adapter;
    private  String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        play = findViewById(R.id.but_play);
        delete=findViewById(R.id.delete);
        listview.findViewById(R.id.listview);
        myTextView=findViewById(R.id.myTextView);

        play.setEnabled(false);
        delete.setEnabled(false);

        final String pathStr = Environment.getExternalStorageDirectory().getPath()+"/Listen";
        Intent intent = getIntent();
        recordFiles = intent.getStringArrayListExtra("recordFiles");
        list = intent.getStringArrayListExtra("list");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recordFiles);
        listview.setAdapter(adapter);


        //播放
        play.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (myPlayFile != null && myPlayFile.exists()) {
                    // 打开播放程序
                    openFile(myPlayFile);
                } else {
                    Toast.makeText(hiatoryActivity.this, "你选的是一个空文件", Toast.LENGTH_LONG)
                            .show();
                    Log.d("没有选择文件","没有选择文件");
                }
            }
        });

        //选择
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg, View arg1,
                                    int arg2, long arg3) {
                // TODO Auto-generated method stub
                // 当有单点击文件名时将删除按钮及播放按钮Enable
                play.setEnabled(true);
                delete.setEnabled(true);

                myPlayFile = new File(pathStr
                        + File.separator
                        + ((TextView) arg1).getText().toString());

                DecimalFormat df = new DecimalFormat("#.000");
                if (myPlayFile.length() <= 1024*1024) {
                    length1=df.format(myPlayFile.length() / 1024.0)+"K";
                } else {
                    length1=df.format(myPlayFile.length() / 1024.0/1024)+"M";
                }
                myTextView.setText("你选的是"
                        + ((TextView) arg1).getText().toString()
                        + "文件大小为：" + length1);
                Toast.makeText(hiatoryActivity.this,"你选的是" + (((TextView) arg1).getText())+ "文件大小为：" + length1,
                        Toast.LENGTH_LONG).show();
            }

        });

        //删除
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
}
