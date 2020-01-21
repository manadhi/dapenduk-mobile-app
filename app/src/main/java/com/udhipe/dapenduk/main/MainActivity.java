package com.udhipe.dapenduk.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.udhipe.dapenduk.R;
import com.udhipe.dapenduk.form.FormActivity;
import com.udhipe.dapenduk.model.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainContract.View, View.OnClickListener {

    private RecyclerView mRecyclerData;
    private FloatingActionButton mFabAddData;

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUi();
    }

    private void initializeUi() {
        mRecyclerData = findViewById(R.id.recycler_data);
        mFabAddData = findViewById(R.id.fab_add_data);

        mPresenter = new MainPresenter(this);

        mFabAddData.setOnClickListener(this);
    }

    @Override
    public void showItem(ArrayList<Person> item) {

    }

    @Override
    public void openPage() {
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }

    @Override
    public void showInfo(boolean state, String message) {

    }

    @Override
    public void endSession() {

    }

    @Override
    public void showLoginButton(boolean state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_add_data:
                mPresenter.goToPage();
                break;
        }
    }
}
