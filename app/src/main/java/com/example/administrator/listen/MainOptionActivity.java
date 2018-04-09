package com.example.administrator.listen;

        import android.app.FragmentManager;
        import android.app.FragmentTransaction;
        import android.content.ClipData;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.design.widget.BottomNavigationView;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
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
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainOptionActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public TextView mTextView;
    public ImageView second_back,img_log;
    private BottomNavigationView mNavigationView;
    public ClipData.Item nav_history;
    public ClipData.Item nav_style;
    public ClipData.Item nav_collection;
public ImageView imgview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
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
    }

    public void init(){

        imgview = findViewById(R.id.img);
        img_log = findViewById(R.id.image_log);
        second_back =findViewById(R.id.second_back);
        Intent intent =  getIntent();
        int position = intent.getIntExtra("postion",-1);
        if(position == 0)
        {
            second_back.setImageResource(R.drawable.cat);
            img_log.setImageResource(R.drawable.dog);}
        else  if(position == 1)
            second_back.setImageResource(R.drawable.dog);
        else if(position == 2)
            second_back.setImageResource(R.drawable.bear);
        else if(position == 3)
            second_back.setImageResource(R.drawable.mouse);
        else if(position == 4)
            second_back.setImageResource(R.drawable.panda);

        SharedPreferences sharedPreferences= getSharedPreferences("data",
                MainOptionActivity.MODE_PRIVATE);
        int log = sharedPreferences.getInt("log",MODE_PRIVATE);
        Toast.makeText(MainOptionActivity.this,"点击了:"+ log, Toast.LENGTH_LONG).show();
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
            return true;
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

}
