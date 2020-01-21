package com.udhipe.dapenduk;

public interface BaseContract {
    interface BaseView {
        void openPage();

        void showInfo(boolean state);
    }

    interface BasePresenter {
        void getOnePersonData(Long id);

        void goToPage();
    }

    interface BaseInteractor {
        interface Listener<T> {
            void onSuccess(T data);

            void onError(String message);
        }

    }
}
