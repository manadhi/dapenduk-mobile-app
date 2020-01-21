package com.udhipe.dapenduk.main;

import com.udhipe.dapenduk.BaseContract;
import com.udhipe.dapenduk.model.Person;

import java.util.ArrayList;

public interface MainContract {
    interface View extends BaseContract.BaseView {
        void showItem(ArrayList<Person> item);

        void endSession();

        void showLoginButton(boolean state);
    }

    interface Presenter extends BaseContract.BasePresenter {
        void getPersonData(String filter);

        void deletePersonData(Long id);

        void checkIsAdmin();
    }

    interface Interactor extends BaseContract.BaseInteractor {
        void loadData(String filter, Listener<ArrayList<Person>> listener);

        void deleteData(Long id, Listener<Boolean> listener);
    }
}
