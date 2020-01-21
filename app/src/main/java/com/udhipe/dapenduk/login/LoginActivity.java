package com.udhipe.dapenduk.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.udhipe.dapenduk.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void goToPage() {

    }

    @Override
    public void showInfo(boolean state) {

    }
}
