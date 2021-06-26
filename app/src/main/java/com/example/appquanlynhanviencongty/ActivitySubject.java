package com.example.appquanlynhanviencongty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

import com.example.appquanlynhanviencongty.adapter.adaptersubject;
import com.example.appquanlynhanviencongty.database.database;
import com.example.appquanlynhanviencongty.model.Subject;

import java.util.ArrayList;

public class ActivitySubject extends AppCompatActivity {
    Toolbar toolbar;
    ListView listViewsubject;
    ArrayList<Subject> ArrayListSubject;
    com.example.appquanlynhanviencongty.database.database database;
    com.example.appquanlynhanviencongty.adapter.adaptersubject adaptersubject;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        toolbar = findViewById(R.id.toolbarSubject);
        listViewsubject = findViewById(R.id.listviewSublect);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        database = new database(this);
        ArrayListSubject = new ArrayList<>();

        Cursor cursor = database.getDataSubject();
        while (cursor.moveToNext()){
            int id =cursor.getInt(0);
            String title = cursor.getString(1);
            int credit = cursor.getInt(2);
            String time = cursor.getString(3);
            String place = cursor.getString(4);

            ArrayListSubject.add(new Subject(id,title,credit,time,place));
        }

        adaptersubject = new adaptersubject(ActivitySubject.this,ArrayListSubject);
        listViewsubject.setAdapter(adaptersubject);
        cursor.moveToFirst();
        cursor.close();

        //Tajo su kien click vao item subject
        listViewsubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(ActivitySubject.this,ActivityStudent.class);
                int id_subject = ArrayListSubject.get(i) .getId();
                //Truyen du lieu qu activity student
                intent.putExtra("id_subject",id_subject);
                startActivity(intent);
            }
        });

    }
    //Them mot menu la add vao toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuadd,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            //neesu click vao add
            case R.id.menuadd:
                Intent intent1 = new Intent(ActivitySubject.this, ActivityAddSubject.class);
                startActivity(intent1);
                break;
                //neu click vao nut con lai thi quay lai main
            default:
                Intent intent = new Intent(ActivitySubject.this,MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //Neesu click owr back thi ve main acrivtity
    @Override
    public void onBackPressed() {
        count++;
        if(count >= 1){
            Intent intent = new Intent(ActivitySubject.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    //run
}