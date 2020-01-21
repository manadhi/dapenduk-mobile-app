package com.udhipe.dapenduk.detail;

import com.udhipe.dapenduk.BaseContract;
import com.udhipe.dapenduk.model.Person;

public interface DetailContract {
    interface View extends BaseContract.BaseView {
        void showDetailPerson(Person person);
    }

    interface Presenter {
        void getPersonData(Long id);
    }

    interface Interactor extends BaseContract.BaseInteractor {
        void loadOneData(Long id, Listener<Person> listener);
    }
}
