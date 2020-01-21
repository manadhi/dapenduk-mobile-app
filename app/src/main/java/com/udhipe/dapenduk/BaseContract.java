package com.udhipe.dapenduk;

import com.udhipe.dapenduk.model.DaoSession;

public interface BaseContract {
    interface BaseView {
        void openPage();

        void showInfo(boolean state, String message);

        void initializeDaoSession();
    }

    interface BasePresenter {
        void getOnePersonData(Long id);

        void goToPage();

        void exceptionHandler(String message);

        void getDaoSession();

        void setDaoSession(DaoSession mDaoSession);
    }

    interface BaseInteractor {
        interface Listener<T> {
            void onSuccess(T data, String message);

            void onError(String message);
        }

    }
}
