package com.udhipe.dapenduk.form;

import com.udhipe.dapenduk.BaseContract;
import com.udhipe.dapenduk.model.Person;

import java.util.ArrayList;

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

        void savePersonData(String name, String gender, String address, String birthPlace,
                            String birthDate, String profession);
    }

    interface Interactor extends BaseContract.BaseInteractor {
        void loadOneData(Long id, Listener<Person> listener);

        void updateData(Person person, Listener<String> listener);

        void saveData(Person person, Listener<ArrayList<Person>> listener);
    }
}
