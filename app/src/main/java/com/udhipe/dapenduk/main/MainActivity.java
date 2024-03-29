package com.udhipe.dapenduk.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.udhipe.dapenduk.R;
import com.udhipe.dapenduk.adapter.PersonAdapter;
import com.udhipe.dapenduk.adapter.PersonAdapterPresenter;
import com.udhipe.dapenduk.detail.DetailActivity;
import com.udhipe.dapenduk.form.FormActivity;
import com.udhipe.dapenduk.form.FormContract;
import com.udhipe.dapenduk.model.DaoSession;
import com.udhipe.dapenduk.model.Person;
import com.udhipe.dapenduk.util.App;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View, View.OnClickListener {

    private RecyclerView mRecyclerData;
    private FloatingActionButton mFabAddData;
    private ConstraintLayout mLayoutMain;

    private MainPresenter mPresenter;
    private PersonAdapterPresenter mAdapterPresenter;

    private PersonAdapter mAdapter;

    private DaoSession mDaoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUi();
    }

    private void initializeUi() {
        mRecyclerData = findViewById(R.id.recycler_data);
        mFabAddData = findViewById(R.id.fab_add_data);
        mLayoutMain = findViewById(R.id.layout_main);

        mPresenter = new MainPresenter(this);
        mPresenter.configViewForItem();

        mFabAddData.setOnClickListener(this);
    }

    @Override
    public void showItem(List<Person> item) {
        mAdapterPresenter.setListPerson(item);
    }

    @Override
    public void setupRecyclerView() {

        mRecyclerData.setHasFixedSize(true);
        mRecyclerData.setLayoutManager(new LinearLayoutManager(this));

        mAdapterPresenter = new PersonAdapterPresenter();
        mAdapter = new PersonAdapter(mAdapterPresenter);

        mAdapterPresenter.setAdapter(mAdapter);

        mRecyclerData.setAdapter(mAdapter);

        mPresenter.getDaoSession();

        mAdapter.setOnItemClickCallback(new PersonAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(int position) {
                mPresenter.goToPage("Detail");
            }

            @Override
            public void onDeleteClicked(int position) {
                mPresenter.deletePersonData(mDaoSession, position);
            }

            @Override
            public void onEditClicked(int position) {

            }
        });
    }

    @Override
    public void openPage(String page) {
        Intent intent = new Intent();
        if ("Edit".equalsIgnoreCase(page)) {
//            intent = new Intent(this, FormActivity.class);
        } else if ("Add".equalsIgnoreCase(page)) {
            intent = new Intent(this, FormActivity.class);
        } else {
            intent = new Intent(this, DetailActivity.class);
        }
        startActivity(intent);
    }

    @Override
    public void showInfo(boolean state, String message) {
        Snackbar.make(mLayoutMain, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void initializeDaoSession() {
        mDaoSession = ((App) getApplication()).getDaoSession();
        mPresenter.getPersonData(mDaoSession, "");
        mPresenter.setDaoSession(mDaoSession);
    }

    @Override
    public void endSession() {

    }

    @Override
    public void showLoginButton(boolean state) {

    }

    @Override
    public void reloadView() {
        mPresenter.getPersonData(mDaoSession, "");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_add_data:
                mPresenter.goToPage("Add");
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if ((mPresenter != null) && (mDaoSession != null)) {
            mPresenter.getPersonData(mDaoSession, "");
        }
    }
}
