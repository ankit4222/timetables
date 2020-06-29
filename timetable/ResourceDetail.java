package com.example.timetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ResourceDetail extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_detail);
        setupUIViews();
        initToolbar();
        setupListView();
    }
    private void setupUIViews(){
        toolbar=(Toolbar)findViewById(R.id.ToolbarResourceDetails);
        listView=(ListView)findViewById(R.id.lvResourceDetails);

    }
    public void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Resources");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListView(){
        String resource_selected=ResourceActivity.reourcePreferences.getString(ResourceActivity.RES_PREF,null);
        String[] ress=new String[]{};
        String[] titles=getResources().getStringArray(R.array.Titles);
        if(resource_selected.equalsIgnoreCase("Sathyabama")){
            ress=getResources().getStringArray(R.array.Sathyabama);
        }else if(resource_selected.equalsIgnoreCase("StackOverFlow")){
            ress=getResources().getStringArray(R.array.StackOverFlow);
        }else if(resource_selected.equalsIgnoreCase("Github")){
            ress=getResources().getStringArray(R.array.Github);
        }else if(resource_selected.equalsIgnoreCase("Reddit")){
            ress=getResources().getStringArray(R.array.Reddit);

        }
        ResourceDetail.ResourceDetailsAdapter subjectDetailsAdapter=new ResourceDetail.ResourceDetailsAdapter(this,titles,ress);
        listView.setAdapter(subjectDetailsAdapter);

    }
    public class ResourceDetailsAdapter extends BaseAdapter {
        private Context mcontext;
        private LayoutInflater layoutInflater;
        private TextView title,resources;
        private String[] titleArray;
        private String[] resourcesArray;


        public ResourceDetailsAdapter(Context context,String[] title,String[] resources){
            mcontext=context;
            titleArray=title;
            resourcesArray=resources;
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
                view= (View) layoutInflater.inflate(R.layout.resource_detail_single_item,null);

            }
            title=(TextView)view.findViewById(R.id.tvResourceTitle);
            resources=(TextView)view.findViewById(R.id.tvresource);

            title.setText(titleArray[i]);
            resources.setText(resourcesArray[i]);

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
