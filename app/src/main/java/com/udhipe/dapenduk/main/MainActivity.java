package com.udhipe.dapenduk.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.udhipe.dapenduk.R;
import com.udhipe.dapenduk.model.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showItem(ArrayList<Person> item) {

    }

    @Override
    public void goToPage() {

    }

    @Override
    public void showInfo(boolean state) {

    }

    @Override
    public void endSession() {

    }

    @Override
    public void showLoginButton(boolean state) {

    }
}
