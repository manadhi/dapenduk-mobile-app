package com.udhipe.dapenduk.main;

import com.udhipe.dapenduk.BaseContract;
import com.udhipe.dapenduk.model.DaoSession;
import com.udhipe.dapenduk.model.Person;

import java.util.List;

public interface MainContract {
    interface View extends BaseContract.BaseView {
        void showItem(List<Person> item);

        void setupRecyclerView();

        void endSession();

        void showLoginButton(boolean state);

        void reloadView();
    }

    interface Presenter extends BaseContract.BasePresenter {
        void getPersonData(DaoSession daoSession, String filter);

        void configViewForItem();

        void deletePersonData(DaoSession daoSession, int position);

        void checkIsAdmin();
    }

    interface Interactor extends BaseContract.BaseInteractor {
        void loadData(DaoSession daoSession, String filter, Listener<List<Person>> listener);

        void deleteData(DaoSession daoSession, Long id, Listener<Boolean> listener);
    }
}
