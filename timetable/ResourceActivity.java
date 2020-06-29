package com.example.timetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.timetable.utils.LetterImageView;

public class ResourceActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    private String[] Resources;
    public static SharedPreferences reourcePreferences;
    public static String RES_PREF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);
        setupUIViews();
        initToolbar();
        setupListView();
    }
    private void setupUIViews(){
        toolbar=(Toolbar)findViewById(R.id.ToolbarResource);
        listView=(ListView)findViewById(R.id.lvResource);
        reourcePreferences=getSharedPreferences("Resource",MODE_PRIVATE);

    }
    public void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Resources");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    private void setupListView(){
        Resources =getResources().getStringArray(R.array.Resources);
        ResourceActivity.ResourceAdapter resourceAdapter=new ResourceActivity.ResourceAdapter(this,R.layout.resource_single_item,Resources);
        listView.setAdapter(resourceAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:{
                        reourcePreferences.edit().putString(RES_PREF,"Sathyabama").apply();
                        Intent intent=new Intent(ResourceActivity.this,ResourceDetail.class);
                        startActivity(intent);
                        break;}
                    case 1:{
                        reourcePreferences.edit().putString(RES_PREF,"StackOverFlow").apply();
                        Intent intent=new Intent(ResourceActivity.this,ResourceDetail.class);
                        startActivity(intent);
                        break;}
                    case 2:{
                        reourcePreferences.edit().putString(RES_PREF,"Github").apply();
                        Intent intent=new Intent(ResourceActivity.this,ResourceDetail.class);
                        startActivity(intent);
                        break;}
                    case 3:{
                        reourcePreferences.edit().putString(RES_PREF,"Reddit").apply();
                        Intent intent=new Intent(ResourceActivity.this,ResourceDetail.class);
                        startActivity(intent);
                        break;}

                }
            }
        });

    }
    public class ResourceAdapter extends ArrayAdapter {
        private int resource ;
        private LayoutInflater layoutInflater;
        private String[] res=new String[]{};






        public ResourceAdapter(Context context, int resource, String[] objects) {
            super(context, resource,objects);
            this.resource=resource;
            this.res=objects;
            layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                holder=new ViewHolder();
                convertView=layoutInflater.inflate(resource,null);
                holder.ivLogo=(LetterImageView)convertView.findViewById(R.id.ivletterResource);
                holder.tvresources=(TextView)convertView.findViewById(R.id.tvResource );


                convertView.setTag(holder);

            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(res[position].charAt(0));
            holder.tvresources.setText(res[position]);
            return convertView;

        }
        public class ViewHolder{
            private LetterImageView ivLogo;
            private TextView tvresources;


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
