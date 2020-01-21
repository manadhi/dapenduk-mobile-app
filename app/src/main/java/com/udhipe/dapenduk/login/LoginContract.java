package com.udhipe.dapenduk.login;

import com.udhipe.dapenduk.BaseContract;

import java.util.Map;

public interface LoginContract {
    interface View extends BaseContract.BaseView {

    }

    interface Presenter {
        void checkValidAdmin(String username, String password);
    }

    interface Interactor extends BaseContract.BaseInteractor {
        void getCredential(String username, String password, Listener<Map<Integer, String>> listener);
    }
}
