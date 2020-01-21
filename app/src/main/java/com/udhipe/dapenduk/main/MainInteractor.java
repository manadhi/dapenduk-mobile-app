package com.udhipe.dapenduk.main;

import com.udhipe.dapenduk.model.Person;

import java.util.ArrayList;

public class MainInteractor implements MainContract.Interactor {
    @Override
    public void loadData(String filter, Listener<ArrayList<Person>> listener) {

    }

    @Override
    public void deleteData(Long id, Listener<Boolean> listener) {

    }
}
