package com.example.appquanlynhanviencongty;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appquanlynhanviencongty.database.database;
import com.example.appquanlynhanviencongty.model.Subject;

public class ActivityAddSubject extends AppCompatActivity {

    Button buttonAddSubject;
    EditText edtSubjectTitle,edtSubjectCredit, edtSubjectTime, edtSubjectPlace;
    com.example.appquanlynhanviencongty.database.database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        buttonAddSubject = findViewById(R.id.buttonAddSubject);
        edtSubjectCredit = findViewById(R.id.EditTextSubjectCredit);
        edtSubjectPlace = findViewById(R.id.EditTextSubjectPlace);
        edtSubjectTime = findViewById(R.id.EditTextSubjectTime);
        edtSubjectTitle = findViewById(R.id.EditTextSubjectTitle);

        database = new database(this);

        buttonAddSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAdd();

            }


        });
    }
    private void DialogAdd() {
        //Tao doi tuong cua so
        Dialog dialog = new Dialog(this);
        //nap layout vao dialog
        dialog.setContentView(R.layout.dialogadd);

        //tat click ngoai la thoat
        dialog.setCanceledOnTouchOutside(false);

        Button btnYes = dialog.findViewById(R.id.btn_Yes);
        Button  btnNo = dialog.findViewById(R.id.btn_No);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  subjecttitle = edtSubjectTitle.getText().toString().trim();
                String credit = edtSubjectCredit.getText().toString().trim();
                String time = edtSubjectTime.getText().toString().trim();
                String place = edtSubjectPlace.getText().toString().trim();

                //Neu du lieu chua nhap day du
                if(subjecttitle.equals("") || credit.equals("")||time.equals("")||place.equals("")){
                    Toast.makeText(ActivityAddSubject.this,"Did not enter enough information", Toast.LENGTH_SHORT).show();
                }else {
                    //gan cho doi tuong sublect gia tri duoc nhap vao
                    Subject subject = CreatSubject();
                    //add trong database
                    database.AddSubjects(subject);
                    //add thanh cong thi chuyen qua giao dien subject
                    Intent intent = new Intent (ActivityAddSubject.this, ActivityAddSubject.class);
                    startActivity(intent);

                    Toast.makeText(ActivityAddSubject.this,"more sucess ",Toast.LENGTH_SHORT).show();
                    
                }
            }
        });
    }
    private Subject CreatSubject(){
        String  subjecttitle = edtSubjectTitle.getText().toString().trim();
        int credit = Integer.parseInt(edtSubjectCredit.getText().toString().trim());
        String time = edtSubjectTime.getText().toString().trim();
        String place = edtSubjectPlace.getText().toString().trim();

        Subject subject = new Subject(subjecttitle,credit,time,place);
        return subject;



    }
}