package com.example.timetable;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.timetable.utils.LetterImageView;

public class WeekActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    public static SharedPreferences sharedPreferences;
    public static String SEL_DAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);
        setupUIViews();
        initToolbar();
        setupListview();
    }
    private void setupUIViews(){
        toolbar=(Toolbar)findViewById(R.id.ToolbarWeek);
        listView=(ListView)findViewById(R.id.lvWeek);
        sharedPreferences=getSharedPreferences("My_day",MODE_PRIVATE);
    }
    public void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Week");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    private void setupListview(){
        String[] week=getResources().getStringArray(R.array.Week);
        WeekAdapter adapter=new WeekAdapter(this,R.layout.activity_week_single_item,week);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:{
                        startActivity(new Intent(WeekActivity.this,DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY,"Monday").apply();
                        break;}
                    case 1:{
                        startActivity(new Intent(WeekActivity.this,DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY,"Tuesday").apply();
                        break;}
                    case 2:{
                        startActivity(new Intent(WeekActivity.this,DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY,"Wednesday").apply();
                        break;}
                    case 3:{
                        startActivity(new Intent(WeekActivity.this,DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY,"Thursday").apply();
                        break;}
                    case 4:{
                        startActivity(new Intent(WeekActivity.this,DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY,"Friday").apply();
                        break;}
                    case 5:{
                        startActivity(new Intent(WeekActivity.this,DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY,"Saturday").apply();
                        break;}
                    default:break;


                }
            }
        });


    }
    public class WeekAdapter extends ArrayAdapter{
        private int resource ;
        private LayoutInflater layoutInflater;
        private String[] week=new String[]{};






        public WeekAdapter(Context context, int resource,String[] objects) {
            super(context, resource,objects);
            this.resource=resource;
            this.week=objects;
            layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                holder=new ViewHolder();
                convertView=layoutInflater.inflate(resource,null);
                holder.ivLogo=(LetterImageView)convertView.findViewById(R.id.ivletter);
                holder.tvweek=(TextView)convertView.findViewById(R.id.tvweek);


                convertView.setTag(holder);

            }else {
                holder = (ViewHolder) convertView.getTag();
            }
             holder.ivLogo.setOval(true);
             holder.ivLogo.setLetter(week[position].charAt(0));
             holder.tvweek.setText(week[position]);
            return convertView;

        }
         public class ViewHolder{
            private LetterImageView ivLogo;
            private TextView tvweek;


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

