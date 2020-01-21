package com.udhipe.dapenduk.form;

import com.udhipe.dapenduk.model.DaoSession;
import com.udhipe.dapenduk.model.Person;
import com.udhipe.dapenduk.model.PersonDao;

import java.util.ArrayList;

public class FormInteractor implements FormContract.Interactor {

    private PersonDao mPersonDao;
    public static final String SUCCESS = "success";

    @Override
    public void loadOneData(Long id, Listener<Person> listener) {

    }

    @Override
    public void updateData(Person person, Listener<String> listener) {

    }

    @Override
    public void saveData(DaoSession daoSession, Person person, Listener<ArrayList<Person>> listener) {
        try {
            mPersonDao = daoSession.getPersonDao();
            mPersonDao.insert(person);
            listener.onSuccess(new ArrayList<Person>(), SUCCESS);
        } catch (Exception exception) {
            listener.onError(exception.getMessage());
        }
    }

}
