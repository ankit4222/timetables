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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SubjectDetails extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_details);
        setupUIViews();
        initToolbar();
        setupListView();
    }
    private void setupUIViews(){
        toolbar=(Toolbar)findViewById(R.id.ToolbarSubjectDetails);
        listView=(ListView)findViewById(R.id.lvSubjectDetails);

    }
    public void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Syllabus");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListView(){
        String subject_selected=SubjectActivity.subjectPreferences.getString(SubjectActivity.SUB_PREF,null);
        String[] syllabus=new String[]{};
        String[] titles=getResources().getStringArray(R.array.titles);
        if(subject_selected.equalsIgnoreCase("CompilerDesign")){
            syllabus=getResources().getStringArray(R.array.CompilerDesign);
        }else if(subject_selected.equalsIgnoreCase("SoftwareEngineering")){
            syllabus=getResources().getStringArray(R.array.SoftwareEngineering);
        }else if(subject_selected.equalsIgnoreCase("ComputerGraphics")){
            syllabus=getResources().getStringArray(R.array.ComputerGraphics);
        }else if(subject_selected.equalsIgnoreCase("OperatingSystem")){
            syllabus=getResources().getStringArray(R.array.OperatingSystem);
        }else if(subject_selected.equalsIgnoreCase("ComputerNetworks")){
            syllabus=getResources().getStringArray(R.array.ComputerNetworks);
        }
        SubjectDetailsAdapter subjectDetailsAdapter=new SubjectDetailsAdapter(this,titles,syllabus);
        listView.setAdapter(subjectDetailsAdapter);

    }
    public class SubjectDetailsAdapter extends BaseAdapter {
        private Context mcontext;
        private LayoutInflater layoutInflater;
        private TextView title,syllabus;
        private String[] titleArray;
        private String[] syllabusArray;


        public SubjectDetailsAdapter(Context context,String[] title,String[] syllabus){
            mcontext=context;
            titleArray=title;
            syllabusArray=syllabus;
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
                view= (View) layoutInflater.inflate(R.layout.subject_details_single_item,null);

            }
            title=(TextView)view.findViewById(R.id.tvSubjectTitle);
            syllabus=(TextView)view.findViewById(R.id.tvSyllabus);

            title.setText(titleArray[i]);
            syllabus.setText(syllabusArray[i]);

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
