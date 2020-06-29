package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();
        initToolbar();
        setUpListView();

    }
    public void setupUIViews(){
        toolbar=(Toolbar)findViewById(R.id.ToolbarMain);
        listView=(ListView)findViewById(R.id.lvMain);


    }
    public void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TimeTable App");

    }
    private void setUpListView(){
        String[] title=getResources().getStringArray(R.array.Main);
        String[] description=getResources().getStringArray(R.array.Description);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,title,description);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: {
                        Intent intent=new Intent(MainActivity.this,WeekActivity.class);
                        startActivity(intent);
                        break;

                    }
                    case 1:{
                        Intent intent=new Intent(MainActivity.this,SubjectActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 2:{
                        Intent intent=new Intent(MainActivity.this,FacultyActivity.class);
                        startActivity(intent);
                        break;

                    }
                    case 3:{
                        Intent intent=new Intent(MainActivity.this,ResourceActivity.class);
                        startActivity(intent);
                        break;



                    }
                    case 4:{
                        break;
                    }
                    case 5:{
                        break;
                    }
                }
            }
        });



    }

    public class SimpleAdapter extends BaseAdapter{
        private Context mcontext;
        private LayoutInflater layoutInflater;
        private TextView title,description;
        private String[] titleArray;
        private String[] descriptionArray;
        private ImageView imageView;

        public SimpleAdapter(Context context,String[] title,String[] description){
            mcontext=context;
            titleArray=title;
            descriptionArray=description;
            layoutInflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int i) {
            return titleArray[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                view= (View) layoutInflater.inflate(R.layout.main_activity_single_item,null);

            }
            title=(TextView)view.findViewById(R.id.tvMain);
            description=(TextView)view.findViewById(R.id.tvdescription);
            imageView=(ImageView)view.findViewById(R.id.ivMain);
            title.setText(titleArray[i]);
            description.setText(descriptionArray[i]);
            if(titleArray[i].equalsIgnoreCase("TimeTable")){
                imageView.setImageResource(R.drawable.timetable);

            }else if(titleArray[i].equalsIgnoreCase("Subjects")){
                imageView.setImageResource(R.drawable.book);
            }
            else if (titleArray[i].equalsIgnoreCase("Faculty")){
                imageView.setImageResource(R.drawable.faculty);
            }
            else{
                imageView.setImageResource(R.drawable.resources);
            }
            return view;
        }
    }
}

