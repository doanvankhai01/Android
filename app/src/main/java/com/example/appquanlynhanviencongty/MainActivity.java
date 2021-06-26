package com.example.appquanlynhanviencongty;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnSubject, btnAuthor,btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAuthor = findViewById(R.id.btn_Author);
        btnSubject = findViewById(R.id.btn_Subject);
        btnExit = findViewById(R.id.btn_Exit);
        //click tác giả
        btnAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAuthor();
            }


        });
        //click sublect
        btnSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyển qua activity sublect
                Intent intent = new Intent(MainActivity.this, ActivitySubject.class);
                startActivity(intent);
            }
        });
        //click exit app
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogExit();
            }


        });
    }
    //hàm hien thi cua so dialog exit
    private void DialogExit() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogexit);

        //Tắt click ngoài là thoát
        dialog.setCanceledOnTouchOutside(false);

        Button btnYes = dialog.findViewById(R.id.btn_Yes);
        Button btnNo = dialog.findViewById(R.id.btn_No);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);

                //Thoat
                Intent intent1 = new Intent(Intent.ACTION_MAIN);
                intent1.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent1);
            }
        });
        //Nếu đã click NO thì đóng cửa sổ
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
    //hiển thị thông tin tác giả
    private void DialogAuthor() {
        //Tạo đối tượng cửa số dialog
        Dialog dialog = new Dialog(this);

        //nap layout vào dialog
        dialog.setContentView(R.layout.dialoginformation);
        dialog.show();
    }
}