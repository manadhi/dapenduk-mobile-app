package com.udhipe.dapenduk.form;

import com.udhipe.dapenduk.BaseContract;
import com.udhipe.dapenduk.model.Person;

public interface FormContract {
    interface View extends BaseContract.BaseView {
        void setPersonData(Person person);

        void showCamera();

        void showGallery();
    }

    interface Presenter extends BaseContract.BasePresenter {
        void updatePersonData(Person person);

        void savePersonData(Person person);

        void getCamera();

        void getGallery();
    }

    interface Interactor extends BaseContract.BaseInteractor {
        void loadOneData(Long id, Listener<Person> listener);

        void updateData(Person person, Listener<String> listener);

        void saveData(Person person, Listener<String> listener);
    }
}
