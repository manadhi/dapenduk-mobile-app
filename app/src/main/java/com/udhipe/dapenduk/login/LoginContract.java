package com.udhipe.dapenduk.login;

import com.udhipe.dapenduk.BaseContract;

public interface LoginContract {
    interface View extends BaseContract.BaseView {

    }

    interface Presenter {
        void checkValidAdmin(String username, String password);
    }

    interface Interactor {

    }
}
