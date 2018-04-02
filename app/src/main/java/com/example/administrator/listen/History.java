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
    private ArrayList<Student> studentsList = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_history);

        play = findViewById(R.id.btnPlay);
        delete = findViewById(R.id.delete);

        myTextView = findViewById(R.id.myTextView);

        play.setEnabled(true);
        delete.setEnabled(true);

        final String pathStr = Environment.getExternalStorageDirectory().getPath() + "/Listen";
        Log.d("TAG", pathStr);

        //Todo: The following is just for a demo purpose

        //Generate the dummy date to populate the listView
        generateDummyContent();

        /*
            Create a custom array adapter which  maps the strings to the views in the layout
            The default ArrayAdapter is too limited as we can only map a string to a view in the layout.
            In order to populate multiple views with different content, we need to create a custom Adapter.
         */
        StudentArrayAdapter studentArrayAdapter =
                new StudentArrayAdapter(
                        getBaseContext(), // Current context
                        R.layout.item_layout, // the layout for each item in the list
                        studentsList); // the arrayList to feed the arrayAdapter

        //The last step is to connect the listView and the Java class and to populate the list View using the ArrayAdapter
        ListView listView = findViewById(R.id.listView_history);
        listView.setAdapter(studentArrayAdapter);


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


    /* Buttons */

    public void btnPlay(View view) {
        Toast.makeText(this, " Play", Toast.LENGTH_SHORT).show();
    }

    public void btnDelete(View view) {
        Toast.makeText(this, " Delete", Toast.LENGTH_SHORT).show();
    }

    /*Dummy content */

    private void generateDummyContent() {
        final String[] nameDummy = {"20012001梁国辉Jack", "20012003吴尚泽Roland", "20012004程淼Elic", "20012005吴歌扬Remus", "20012006缪鹏飞mahon", "20012007刘峥Jerry", "20012009赵文杰Sam", "20012010桑明月bruce sand", "20012013秦帆Sail Chin", "20012014方岩simple", "20012016刘雨果Hugo", "20012017杨孝辉Paul", "20012018李宁Lee", "20012019杨译绗Yori", "20012020万芳维Arno", "20012021黄春霖Pinky", "20012022王丹zoy", "20012023王瀚哲orange", "20012025向微Jhon", "20012026邓炯尧dengjiongyao", "20012027裴凯强Joshua", "20012028刘毅frank", "20012029文愉舒Joshua", "20012030夏月Summon", "20012031WuTianyuRyan", "20012032薛景智Shawn", "20012033何宇River", "20012034彭小双Daniel", "20012035陶友玮Ronon", "20012038秦郡鸿Join", "20012039程金Alan", "20012041苏婷Rose", "20012042李昕Cyn", "20012043陈静Lottie", "20012044张健华Lancer", "20012046向鹏Alan", "20012047徐佩荃Jake", "20012048马浚豪Gattuso", "20012049周渝jerry", "20012050段张奇Monster", "20012052郭华钰Ben", "20012053邓慧迪Amber", "20012008John", "20012036ELI"};
        for (String element : nameDummy) {
            String studentId = element.substring(0, 7);
            String studentName = element.substring(8);

            studentsList.add(new Student(studentName, Integer.valueOf(studentId)));

        }
    }
}
