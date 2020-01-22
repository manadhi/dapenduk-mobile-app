package com.udhipe.dapenduk.main;

import com.udhipe.dapenduk.model.DaoSession;
import com.udhipe.dapenduk.model.Person;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private MainInteractor mInteractor;
    private MainContract.View mView;
    private DaoSession mDaosession;
    private List<Person> mListPerson;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        mInteractor = new MainInteractor();
    }

    @Override
    public void getPersonData(DaoSession daoSession, String filter) {
        mInteractor.loadData(daoSession, filter, new MainInteractor.Listener<List<Person>>() {
            @Override
            public void onSuccess(List<Person> data, String message) {
                mListPerson = data;
                mView.showItem(data);
                mView.showInfo(true, message);
            }

            @Override
            public void onError(String message) {
                mView.showInfo(false, message);
            }
        });
    }

    @Override
    public void configViewForItem() {
        mView.setupRecyclerView();
    }

    @Override
    public void deletePersonData(DaoSession daoSession, int id) {
        Person person = mListPerson.get(id);
        Long idPerson = person.getId();
        mInteractor.deleteData(daoSession, idPerson, new MainInteractor.Listener<Boolean>() {
            @Override
            public void onSuccess(Boolean state, String message) {
                mView.reloadView();
                mView.showInfo(state, message);
            }

            @Override
            public void onError(String message) {
                mView.showInfo(false, message);
            }
        });
    }

    @Override
    public void checkIsAdmin() {

    }

    @Override
    public void getOnePersonData(Long id) {

    }

    @Override
    public void goToPage(String page) {
        mView.openPage(page);
    }

    @Override
    public void exceptionHandler(String message) {

    }

    @Override
    public void getDaoSession() {
        mView.initializeDaoSession();
    }

    @Override
    public void setDaoSession(DaoSession mDaoSession) {
        this.mDaosession = mDaoSession;
        mView.reloadView();
    }

}
