package com.example.appquanlynhanviencongty.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.appquanlynhanviencongty.ActivitySubject;
import com.example.appquanlynhanviencongty.R;
import com.example.appquanlynhanviencongty.model.Subject;

import java.util.ArrayList;

public class adaptersubject extends BaseAdapter {

    private ActivitySubject context;

    private ArrayList<Subject> ArrayListSubject;

    public adaptersubject(ActivitySubject context, ArrayList<Subject> arrayListSubject){
        this.context = context;
        ArrayListSubject = arrayListSubject;
    }

    @Override
    public int getCount() {

        return ArrayListSubject.size();

    }

    @Override
    public Object getItem(int i) {
        return ArrayListSubject.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(R.layout.listsubject, null);

        TextView TextViewSubjectTitle = view.findViewById(R.id.txtview_SubjectTitle);
        TextView TextViewCredit = view.findViewById(R.id.txtview_Credit);
        ImageButton imageDelete = view.findViewById(R.id.subjectdelete);
        ImageButton imageInForMaTion = view.findViewById(R.id.subjectinformation);
        ImageButton imageUpdate = view.findViewById(R.id.subjectupdate);

        Subject subject = ArrayListSubject.get(i);

        TextViewCredit.setText(subject.getNumber_of_credit());
        TextViewSubjectTitle.setText(subject.getSubject_title());

        int id  = subject.getId();

        imageInForMaTion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imageUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return null;
    }
}
