package com.udhipe.dapenduk.form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.udhipe.dapenduk.R;
import com.udhipe.dapenduk.model.Person;

public class FormActivity extends AppCompatActivity implements FormContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }

    @Override
    public void setPersonData(Person person) {

    }

    @Override
    public void showCamera() {

    }

    @Override
    public void showGallery() {

    }

    @Override
    public void openPage() {

    }

    @Override
    public void showInfo(boolean state) {

    }
}
