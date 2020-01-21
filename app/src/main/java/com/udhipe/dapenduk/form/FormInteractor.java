package com.udhipe.dapenduk.form;

import com.udhipe.dapenduk.model.Person;

public class FormInteractor implements FormContract.Interactor {
    @Override
    public void loadOneData(Long id, Listener<Person> listener) {
        
    }

    @Override
    public void updateData(Person person, Listener<String> listener) {

    }

    @Override
    public void saveData(Person person, Listener<String> listener) {

    }
}
