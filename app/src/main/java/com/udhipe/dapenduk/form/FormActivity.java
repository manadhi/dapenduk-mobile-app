package com.udhipe.dapenduk.form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.udhipe.dapenduk.R;
import com.udhipe.dapenduk.model.DaoSession;
import com.udhipe.dapenduk.model.Person;
import com.udhipe.dapenduk.util.App;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FormActivity extends AppCompatActivity implements FormContract.View, View.OnClickListener {

    private TextInputEditText mEdtName;
    private TextInputEditText mEdtGender;
    private TextInputEditText mEdtAddress;
    private TextInputEditText mEdtBirthPlace;
    private TextInputEditText mEdtBirthDate;
    private TextInputEditText mEdtProfession;
    private MaterialButton mBtnSaveData;
    private ConstraintLayout mLayoutEditForm;

    private FormContract.Presenter mPresenter;

    private SimpleDateFormat mDateFormatter = new SimpleDateFormat("yyyy-MM-dd");

    private DaoSession mDaoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        initializeUi();
    }

    private void initializeUi() {
        mEdtName = findViewById(R.id.edt_name);
        mEdtGender = findViewById(R.id.edt_gender);
        mEdtAddress = findViewById(R.id.edt_address);
        mEdtBirthPlace = findViewById(R.id.edt_birth_place);
        mEdtBirthDate = findViewById(R.id.edt_birth_date);
        mEdtProfession = findViewById(R.id.edt_profession);
        mBtnSaveData = findViewById(R.id.btn_save_data);
        mLayoutEditForm = findViewById(R.id.layout_edit_form);

        mPresenter = new FormPresenter(this);
        mPresenter.getDaoSession();

        mBtnSaveData.setOnClickListener(this);
    }

    @Override
    public void setPersonData(ArrayList<Person> person) {

    }

    @Override
    public void showCamera() {

    }

    @Override
    public void showGallery() {

    }

    @Override
    public void getInputDataFromUser() {
        try {
            String name = mEdtName.getText().toString();
            Person.Gender gender = Person.Gender.MALE;
            String address = mEdtAddress.getText().toString();
            String birthPlace = mEdtBirthPlace.getText().toString();
            Date birthDate = new Date(System.currentTimeMillis());
            String profession = mEdtProfession.getText().toString();

            mPresenter.savePersonData(name, gender, address, birthPlace, birthDate, profession);

        } catch (NullPointerException exception) {
            mPresenter.exceptionHandler(exception.getMessage());
        }
    }

    @Override
    public void openPage(String page) {

    }

    @Override
    public void showInfo(boolean state, String message) {
        if (state) {
            Snackbar.make(mLayoutEditForm, getString(R.string.save_success), Snackbar.LENGTH_LONG).show();
        } else {
            Snackbar.make(mLayoutEditForm, getString(R.string.save_fail), Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void initializeDaoSession() {
        mDaoSession = ((App) getApplication()).getDaoSession();
        mPresenter.setDaoSession(mDaoSession);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save_data:
                mPresenter.getInputData();
                break;
        }
    }
}
