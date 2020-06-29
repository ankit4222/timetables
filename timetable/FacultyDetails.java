package com.example.timetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import de.hdodenhof.circleimageview.CircleImageView;

public class FacultyDetails extends AppCompatActivity {
    private CircleImageView facultyImage;
    private Toolbar toolbar;
    private TextView facultyName;
    private TextView Department;
    private TextView Email;
    private  TextView Place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details);
        setupUIViews();
        initToolbar();
        setupDetails();

    }
    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarFacultyDetails);
        facultyImage=(CircleImageView)findViewById(R.id.ivFaculty);
        facultyName=(TextView)findViewById(R.id.tvFacultySelName);
        Department=(TextView)findViewById(R.id.tvDepartment);
        Email=(TextView)findViewById(R.id.tvEmail);
        Place=(TextView)findViewById(R.id.tvPlace);


    }
    public void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Faculty Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupDetails(){
        int faculty_pos=FacultyActivity.sharedPreferences.getInt(FacultyActivity.SEL_Faculty,0);
        String[] facultynames=getResources().getStringArray(R.array.faculty_name);
        int[] facultyImages=new int[]{R.drawable.image3,R.drawable.image4,R.drawable.image2,R.drawable.image,R.drawable.image1};
        int[] facultyArray=new int[]{R.array.faculty1,R.array.faculty2,R.array.faculty3,R.array.faculty4,R.array.faculty5};
        String[] facultyDetails=getResources().getStringArray(facultyArray[faculty_pos]);
        Department.setText(facultyDetails[0]);
        Email.setText(facultyDetails[1]);
        Place.setText(facultyDetails[2]);
        facultyImage.setImageResource(facultyImages[faculty_pos]);
        facultyName.setText(facultynames[faculty_pos]);


    } @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                onBackPressed();

            }
        }
        return super.onOptionsItemSelected(item);
    }
}
