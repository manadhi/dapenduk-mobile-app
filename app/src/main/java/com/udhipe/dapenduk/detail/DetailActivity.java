package com.udhipe.dapenduk.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.udhipe.dapenduk.R;
import com.udhipe.dapenduk.model.Person;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    @Override
    public void showDetailPerson(Person person) {

    }

    @Override
    public void openPage() {

    }

    @Override
    public void showInfo(boolean state, String message) {

    }
}
