package mg.studio.weatherappdesign;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //定义控件变量
    public TextView tv_date; //定义年月日
    public TextView new_date; //定义星期几（最顶端）
    public ImageView img_weather_condition;  //定义年月日上的图标
    //天气图标
    public ImageView imag1;
    public ImageView imag2;
    public ImageView imag3;
    public ImageView imag4;
    //日期文本
    public TextView date_week1;
    public TextView date_week2;
    public TextView date_week3;
    public TextView date_week4;
    //文本圈圈
    public ImageView imag_week1;
    public ImageView imag_week2;
    public ImageView imag_week3;
    public ImageView imag_week4;
    private TextView temperature_of_the_day;
    private Button button;
    public LinearLayout notification_background;
    public int i=1;
    //定义数组存放温度信息
    public ArrayList list=new ArrayList();
    public ArrayList high=new ArrayList();
    public ArrayList type=new ArrayList();

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        public void handleMessage(Message message)
        {
            switch(message.what){
                case 1:
                    updateTemperature((Temperature)message.obj);
                    break;
                default:
                    break;
            }
        }
    };

Temperature temperature = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定控件
        tv_date=(TextView)findViewById(R.id.tv_date);
        new_date=(TextView)findViewById(R.id.new_date);
        temperature_of_the_day=(TextView)findViewById(R.id.temperature_of_the_day);      //温度显示控件
        img_weather_condition=(ImageView)findViewById(R.id.img_weather_condition);

        //将下部天气图标绑定控件
        imag1=(ImageView)findViewById(R.id.imag1);
        imag2=(ImageView)findViewById(R.id.imag2);
        imag3=(ImageView)findViewById(R.id.imag3);
        imag4=(ImageView)findViewById(R.id.imag4);

        //绑定天气图标下的文本控件
        date_week1=(TextView) findViewById(R.id.date_week1);
        date_week2=(TextView) findViewById(R.id.date_week2);
        date_week3=(TextView) findViewById(R.id.date_week3);
        date_week4=(TextView) findViewById(R.id.date_week4);
        //绑定星期的蓝色圈圈
        imag_week1=(ImageView)findViewById(R.id.imag_week1);
        imag_week2=(ImageView)findViewById(R.id.imag_week2);
        imag_week3=(ImageView)findViewById(R.id.imag_week3);
        imag_week4=(ImageView)findViewById(R.id.imag_week4);

        notification_background=(LinearLayout) findViewById(R.id.notification_background);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        //检查网络
        if (CheckNet.getNetState(this) == CheckNet.NET_NONE) {
            Log.d("MWeather", "网络不通");
            Toast.makeText(MainActivity.this, "网络不通", Toast.LENGTH_LONG).show();
        } else {
            Log.d("MWeather", "网络ok");
            Toast.makeText(MainActivity.this, "网络ok", Toast.LENGTH_LONG).show();

        }
    }


    //刷新时间响应函数
    public void onClick(View v) {

        long time = System.currentTimeMillis();
        Date date = new Date(time);
        Calendar calendar =Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat format1 = new SimpleDateFormat("EEEE");

        if(v.getId()==R.id.imag1) i=1;
        if(v.getId()==R.id.imag2) i=2;
        if(v.getId()==R.id.imag3) i=3;
        if(v.getId()==R.id.imag4) i=4;
        switch(i)
        {
            case 1:
                if(hasWindowFocus())
                {
                    i=1;
                    getWeatherDateformNet();//更新温度信息
                    date_week1.setText(format1.format(calendar.getTime()));
                    tv_date.setText(format.format(calendar.getTime()));
                    new_date.setText(format1.format(calendar.getTime()));
                    imag_week1.setImageResource(R.drawable.blue);
                    imag_week2.setImageResource(R.drawable.white);
                    imag_week3.setImageResource(R.drawable.white);
                    imag_week4.setImageResource(R.drawable.white);
                }
                break;
            case 2:
                if(hasWindowFocus()) {
                    i=2;
                    getWeatherDateformNet();
                    imag_week2.setImageResource(R.drawable.blue);
                    imag_week1.setImageResource(R.drawable.white);
                    imag_week3.setImageResource(R.drawable.white);
                    imag_week4.setImageResource(R.drawable.white);
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                    date_week2.setText(format1.format(calendar.getTime()));
                    tv_date.setText(format.format(calendar.getTime()));
                    new_date.setText(format1.format(calendar.getTime()));
                }
                break;
            case 3:
                if(hasWindowFocus()){
                    i=3;
                    getWeatherDateformNet();
                    imag_week3.setImageResource(R.drawable.blue);
                    imag_week1.setImageResource(R.drawable.white);
                    imag_week2.setImageResource(R.drawable.white);
                    imag_week4.setImageResource(R.drawable.white);
                    calendar.add(Calendar.DAY_OF_MONTH, 2);
                    date_week3.setText(format1.format(calendar.getTime()));
                    tv_date.setText(format.format(calendar.getTime()));
                    new_date.setText(format1.format(calendar.getTime()));
                }
                break;
            case 4:
                if(hasWindowFocus())
                {
                    i=4;
                    getWeatherDateformNet();
                    imag_week4.setImageResource(R.drawable.blue);
                    imag_week1.setImageResource(R.drawable.white);
                    imag_week2.setImageResource(R.drawable.white);
                    imag_week3.setImageResource(R.drawable.white);
                    calendar.add(Calendar.DAY_OF_MONTH, 3);
                    date_week4.setText(format1.format(calendar.getTime()));
                    tv_date.setText(format.format(calendar.getTime()));
                    new_date.setText(format1.format(calendar.getTime()));
                }
                break;
        }
    }

    //定义连接网络的类
    public static class CheckNet {
         final static int NET_NONE = 0;
         final static int NET_WIFI = 1;
         final static int NET_MOBILE = 2;

         static int getNetState(Context context) {

            ConnectivityManager connectivityManager =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo == null)
                return NET_NONE;
            int type = networkInfo.getType();
            if (type == ConnectivityManager.TYPE_MOBILE)
                return NET_MOBILE;
            else if (type == ConnectivityManager.TYPE_WIFI)
                return NET_WIFI;
            return NET_MOBILE;
        }
    }

    //获取数据的函数
    private void getWeatherDateformNet() {
        final String address = "http://wthrcdn.etouch.cn/WeatherApi?citykey=" + "101043700";
        Log.d("Address:", address);
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection urlConnection = null;
                try {
                    URL url = new URL(address);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setConnectTimeout(8000);
                    urlConnection.setReadTimeout(8000);
                    InputStream in = urlConnection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuffer sb = new StringBuffer();
                    String str;
                    while ((str = reader.readLine()) != null) {
                        sb.append(str);
                        Log.d("date from url", str);
                    }
                    String response = sb.toString();
                    Log.d("response", response);
                    //调用函数获取数据
                    temperature = parseXML(response);
                    if(temperature != null)
                    {
                        Message message = new Message();
                        message.what = 1;
                        message.obj = temperature;
                        mHandler.sendMessage(message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private Temperature parseXML(String xmlData) {
        Temperature temperature = null;
        int lowCount = 1;
        int highCount = 1;
        int dateCount = 1;
        int typeCount = 1;
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));

            int eventType = xmlPullParser.getEventType();
            Log.d("MWeather", "start parse xml");

            while (XmlPullParser.END_DOCUMENT != eventType) {

                switch (eventType) {
                    //文档开始位置
                    case XmlPullParser.START_DOCUMENT:
                        Log.d("parse", "start doc");
                        break;
                    //标签元素开始位置
                    case XmlPullParser.START_TAG:
                        if(xmlPullParser.getName().equals("resp"))
                        {
                            temperature = new Temperature();
                        }
                        if(temperature!=null) {
                            if (xmlPullParser.getName().equals("low")&&lowCount<=4) {
                                eventType = xmlPullParser.next();
                                Log.d("low", xmlPullParser.getText());
                                temperature.setTemp(xmlPullParser.getText());
                                list.add(temperature.getTemp());
                                lowCount++;
                            }else if (xmlPullParser.getName().equals("high") && highCount <= 4) {
                                eventType = xmlPullParser.next();
                                Log.d("high", xmlPullParser.getText());
                                temperature.setHightemp(xmlPullParser.getText());
                                high.add(temperature.getHightemp());
                                highCount++;
                            }else if (xmlPullParser.getName().equals("city")){
                                eventType = xmlPullParser.next();
                                Log.d("city", xmlPullParser.getText());
                                temperature.setCity(xmlPullParser.getText());
                                dateCount++;
                            }else if (xmlPullParser.getName().equals("type") && typeCount <= 4) {
                                eventType = xmlPullParser.next();
                                Log.d("type", xmlPullParser.getText());
                                temperature.setType(xmlPullParser.getText());
                                type.add(temperature.getType());
                                typeCount++;
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                eventType = xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temperature;
    }

    //跟新组件
    void updateTemperature(Temperature temperature){
        temperature_of_the_day.setText(list.get(i)+"-"+high.get(i));
        button.setText(temperature.getCity());
        //根据天气情况加载对应的图片
        if(temperature.getType()!=null)
        {
            Log.d("type", temperature.getType());
            if(type.get(i).equals("晴"))
            {

                img_weather_condition.setImageResource(R.drawable.sunny_small);
                notification_background.setBackgroundColor(Color.parseColor("#99FF99"));
            }else if(type.get(i).equals("阵雨"))
            {
                img_weather_condition.setImageResource(R.drawable.rainy_small);
                notification_background.setBackgroundColor(Color.parseColor("#FFC0CB"));
            }else if(type.get(i).equals("阴"))
            {
                img_weather_condition.setImageResource(R.drawable.partly_sunny_small);
                notification_background.setBackgroundColor(Color.parseColor("#708090"));
            }else if(type.get(i).equals("多云"))
            {
                img_weather_condition.setImageResource(R.drawable.windy_small);
                notification_background.setBackgroundColor(Color.parseColor("#FFDAB9"));
            }

        }//end of if
        Toast.makeText(MainActivity.this,"更新成功",Toast.LENGTH_SHORT).show();
    }//end of updateTemperature
}//end of mainactivity
