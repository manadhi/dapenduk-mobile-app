package com.udhipe.dapenduk.form;

import com.udhipe.dapenduk.model.Person;

import java.util.ArrayList;

public class FormPresenter implements FormContract.Presenter {

    private FormContract.Interactor mInteractor;
    private FormContract.View mView;

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
    public void savePersonData(String name, String gender, String address, String birthPlace,
                               String birthDate, String profession) {
        Long id = null;
        Person person = new Person(id, name, address, birthPlace, birthDate, gender, "", profession);
        mInteractor.saveData(person, new FormInteractor.Listener<ArrayList<Person>>() {
            @Override
            public void onSuccess(ArrayList<Person> data) {
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

}
