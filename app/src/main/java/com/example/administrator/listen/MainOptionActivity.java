package com.example.administrator.listen;

import android.content.ClipData;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.net.Uri;
        import android.os.Bundle;
        import android.os.Environment;
        import android.support.design.widget.BottomNavigationView;
        import android.util.Log;
        import android.view.View;
        import android.support.design.widget.NavigationView;
        import android.support.v4.view.GravityCompat;
        import android.support.v4.widget.DrawerLayout;
        import android.support.v7.app.ActionBarDrawerToggle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.io.File;
        import java.text.DecimalFormat;
        import java.util.ArrayList;

public class MainOptionActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public TextView mTextView,textView;
    public ImageView second_back,img_log;
    private BottomNavigationView mNavigationView;
    public ClipData.Item nav_history;
    public ClipData.Item nav_style;
    public ClipData.Item nav_collection;
    public ImageView imgview;
    private SessionManager session;
     private String userName;

    public ListView listView_sec;
    private boolean sdcardExit;
    private File myRecAudioDir;
    private File myPlayFile;
    private ArrayList<String> recordFiles = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imgview = findViewById(R.id.img);
        second_back =findViewById(R.id.second_back);
        imgview.setImageResource(R.drawable.style_s);

        //退出登陆
        session = new SessionManager(getApplicationContext());
        if (!session.isLoggedIn()) {
            logout();
        }


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        init();

        // 判断sd Card是否插入
        sdcardExit = Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED);
        // 取得sd card路径作为录音文件的位置
        if (sdcardExit) {
            String pathStr = Environment.getExternalStorageDirectory().getPath() + "/Share";
            myRecAudioDir = new File(pathStr);
            Log.d("TAG", pathStr);
        }
        //Todo: The following is just for a demo purpose
        myPlayFile=null;
        // 取得sd card 目录里的.arm文件
        getRecordFiles();

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recordFiles);
        //The last step is to connect the listView and the Java class and to populate the list View using the ArrayAdapter
        listView_sec = findViewById(R.id.listView_second);
        listView_sec.setAdapter(adapter1);


        listView_sec.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg, View arg1,
                                    int arg2, long arg3) {
                // TODO Auto-generated method stub
                myPlayFile = new File(myRecAudioDir.getAbsolutePath() + File.separator + ((TextView) arg1).getText().toString());
                DecimalFormat df = new DecimalFormat("#.000");
                Toast.makeText(MainOptionActivity.this,"你选的是" + (((TextView) arg1).getText()),
                        Toast.LENGTH_LONG).show();
                if (myPlayFile != null && myPlayFile.exists()) {
                    // 打开播放程序
                    openFile(myPlayFile);
                } else {
                    Toast.makeText(MainOptionActivity.this, "你选的是一个空文件", Toast.LENGTH_LONG)
                            .show();
                    Log.d("没有选择文件","没有选择文件");
                }
            }

        });
    }

    public void logout() {
        // Updating the session
        session.setLogin(false);
        // Redirect the user to the login activity
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    public void init(){

        Intent intent =  getIntent();
        int position = intent.getIntExtra("postion",-1);
        if(position == 0) {
            second_back.setImageResource(R.drawable.style_b);
            imgview.setImageResource(R.drawable.style_s);
        }
        else  if(position == 1){
            second_back.setImageResource(R.drawable.style1_b);
            imgview.setImageResource(R.drawable.style1_s);}
        else if(position == 2){
            second_back.setImageResource(R.drawable.style2_b);
            imgview.setImageResource(R.drawable.style2_s);}
        else if(position == 3){
            second_back.setImageResource(R.drawable.style3_b);
            imgview.setImageResource(R.drawable.style3_s);}
        else if(position == 4){
            second_back.setImageResource(R.drawable.style4_b);
            imgview.setImageResource(R.drawable.style4_s);}
    }

public void butClick(View view)
{
    Intent intent = new Intent(this,Asking.class);
    startActivity(intent);
}
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
          getMenuInflater().inflate(R.menu.second, menu);

        img_log = findViewById(R.id.image_log);
        textView=findViewById(R.id.user_textView);
        SharedPreferences sharedPreferences= getSharedPreferences("data", MainOptionActivity.MODE_PRIVATE);
        int log = sharedPreferences.getInt("log",MODE_PRIVATE);

        SharedPreferences sharedPreferences1= getSharedPreferences("text", MainOptionActivity.MODE_PRIVATE);
        String email = sharedPreferences1.getString("email", "");
        if(log == 0)
            img_log.setImageResource(R.drawable.ba);
        else if(log == 1)
            img_log.setImageResource(R.drawable.log1);
        else if(log == 2)
            img_log.setImageResource(R.drawable.log2);
        else if(log == 3)
            img_log.setImageResource(R.drawable.log3);
        else if(log == 4)
            img_log.setImageResource(R.drawable.log4);

        textView.setText(email);

        Toast.makeText(MainOptionActivity.this,"点击了:"+ log, Toast.LENGTH_LONG).show();

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            logout();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(this, History.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(this, Style.class);
            startActivity(intent);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
}
