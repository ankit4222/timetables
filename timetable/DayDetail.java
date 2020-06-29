package com.example.timetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.example.timetable.utils.LetterImageView;

public class DayDetail extends AppCompatActivity {

    private ListView listView;
    private Toolbar toolbar;
    public static String[] Monday;
    public static String[] Tuesday;
    public static String[] Wednesday;
    public static String[] Thursday;
    public static String[] Friday;
    public static String[] Saturday;
    public static String[] time1;
    public static String[] time2;
    public static String[] time3;
    public static String[] time4;
    public static String[] time5;
    public static String[] time6;
    private String[] preferedday;
    private String[] preferedtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_detail);
        setupUIViews();
        initToolbar();
        setUPListView();

    }

    private void setupUIViews(){
        listView=(ListView)findViewById(R.id.lvDayDetail);
        toolbar=(Toolbar)findViewById(R.id.ToolbarDayDetail);

    }
    public void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(WeekActivity.sharedPreferences.getString(WeekActivity.SEL_DAY,null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setUPListView(){
        Monday=getResources().getStringArray(R.array.Monday);
        Tuesday=getResources().getStringArray(R.array.Tuesday);
        Wednesday=getResources().getStringArray(R.array.Wednesday);
        Thursday=getResources().getStringArray(R.array.Thursday);
        Friday=getResources().getStringArray(R.array.Friday);
        Saturday=getResources().getStringArray(R.array.Saturday);

        time1=getResources().getStringArray(R.array.time1);
        time2=getResources().getStringArray(R.array.time2);
        time3=getResources().getStringArray(R.array.time3);
        time4=getResources().getStringArray(R.array.time4);
        time5=getResources().getStringArray(R.array.time5);
        time6=getResources().getStringArray(R.array.time6);

        String selected_day=WeekActivity.sharedPreferences.getString(WeekActivity.SEL_DAY,null);
        if(selected_day.equalsIgnoreCase("Monday")){
            preferedday=Monday;
            preferedtime=time1;

        }else if(selected_day.equalsIgnoreCase("Tuesday")){
            preferedday=Tuesday;
            preferedtime=time2;

        }else if (selected_day.equalsIgnoreCase("Wednesday")){
            preferedday=Wednesday;
            preferedtime=time3;
        }else if(selected_day.equalsIgnoreCase("Thursday")){
            preferedday=Thursday;
            preferedtime=time4;
        }else if(selected_day.equalsIgnoreCase("Friday")){
            preferedday=Friday;
            preferedtime=time5;
        }else if(selected_day.equalsIgnoreCase("Saturday")){
            preferedday=Saturday;
            preferedtime=time6;
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,preferedday,preferedtime);
        listView.setAdapter(simpleAdapter);



    }
    public class SimpleAdapter extends BaseAdapter {
        private Context mcontext;
        private LayoutInflater layoutInflater;
        private TextView subject,time;
        private String[] subjectArray;
        private String[] timeArray;
        private LetterImageView letterImageView;

        public SimpleAdapter(Context context,String[] subjectArray,String[] timeArray){
            mcontext=context;
            this.subjectArray=subjectArray;
            this.timeArray=timeArray;
            layoutInflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return subjectArray.length;
        }

        @Override
        public Object getItem(int i) {
            return subjectArray[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                view= (View) layoutInflater.inflate(R.layout.day_detail_single_item,null);

            }
            subject=(TextView)view.findViewById(R.id.tvDayDetail);
            time=(TextView)view.findViewById(R.id.tvTimeDayDetail);
            letterImageView=(LetterImageView)view.findViewById(R.id.ivDayDetail);
            subject.setText(subjectArray[i]);
            time.setText(timeArray[i]);
            letterImageView.setOval(true);
            letterImageView.setLetter(subjectArray[i].charAt(0));

            return view;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                onBackPressed();

            }
        }

        return super.onOptionsItemSelected(item);
    }
}
