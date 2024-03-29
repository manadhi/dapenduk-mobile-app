package com.udhipe.dapenduk.form;

import com.udhipe.dapenduk.BaseContract;
import com.udhipe.dapenduk.model.DaoSession;
import com.udhipe.dapenduk.model.Person;

import java.util.ArrayList;
import java.util.Date;

public interface FormContract {
    interface View extends BaseContract.BaseView {
        void setPersonData(ArrayList<Person> person);

        void showCamera();

        void showGallery();

        void getInputDataFromUser();

    }

    interface Presenter extends BaseContract.BasePresenter {
        void updatePersonData(Person person);

        void getCamera();

        void getGallery();

        void getInputData();

        void savePersonData(String name, Person.Gender gender, String address, String birthPlace,
                            Date birthDate, String profession);
    }

    interface Interactor extends BaseContract.BaseInteractor {

        void loadOneData(Long id, Listener<Person> listener);

        void updateData(Person person, Listener<String> listener);

        void saveData(DaoSession daoSession, Person person, Listener<ArrayList<Person>> listener);
    }
}
