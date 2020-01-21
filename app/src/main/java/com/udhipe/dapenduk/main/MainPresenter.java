package com.udhipe.dapenduk.main;

public class MainPresenter implements MainContract.Presenter {

    private MainInteractor mInteractor;
    private MainContract.View mView;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        mInteractor = new MainInteractor();
    }

    @Override
    public void getPersonData(String filter) {

    }

    @Override
    public void deletePersonData(Long id) {

    }

    @Override
    public void checkIsAdmin() {

    }

    @Override
    public void getOnePersonData(Long id) {

    }

    @Override
    public void goToPage() {
        mView.openPage();
    }
}
