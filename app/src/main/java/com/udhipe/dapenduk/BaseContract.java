package com.udhipe.dapenduk;

public interface BaseContract {
    interface BaseView {
        void openPage();

        void showInfo(boolean state, String message);
    }

    interface BasePresenter {
        void getOnePersonData(Long id);

        void goToPage();

        void exceptionHandler(String message);
    }

    interface BaseInteractor {
        interface Listener<T> {
            void onSuccess(T data);

            void onError(String message);
        }

    }
}
