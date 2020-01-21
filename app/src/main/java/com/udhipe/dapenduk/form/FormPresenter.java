package com.udhipe.dapenduk.form;

import com.udhipe.dapenduk.model.DaoSession;
import com.udhipe.dapenduk.model.Person;

import java.util.ArrayList;
import java.util.Date;

public class FormPresenter implements FormContract.Presenter {

    private FormContract.Interactor mInteractor;
    private FormContract.View mView;
    private DaoSession mDaosession;

    public FormPresenter(FormContract.View mView) {
        this.mView = mView;
        mInteractor = new FormInteractor();
    }

    @Override
    public void updatePersonData(Person person) {

    }

    @Override
    public void getCamera() {

    }

    @Override
    public void getGallery() {

    }

    @Override
    public void getInputData() {
        mView.getInputDataFromUser();
    }

    @Override
    public void savePersonData(String name, Person.Gender gender, String address, String birthPlace,
                               Date birthDate, String profession) {
        Long id = null;
        Person person = new Person(id, name, address, birthPlace, birthDate, gender, "", profession);

        mInteractor.saveData(mDaosession, person, new FormInteractor.Listener<ArrayList<Person>>() {
            @Override
            public void onSuccess(ArrayList<Person> data, String message) {
                mView.setPersonData(data);
                mView.showInfo(true, "");
            }

            @Override
            public void onError(String message) {
                mView.showInfo(false, message);
            }
        });
    }

    @Override
    public void getOnePersonData(Long id) {

    }

    @Override
    public void goToPage() {

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
    }

}
