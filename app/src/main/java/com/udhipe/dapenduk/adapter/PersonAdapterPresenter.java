package com.udhipe.dapenduk.adapter;

import com.udhipe.dapenduk.model.Person;

import java.util.List;

public class PersonAdapterPresenter implements PersonAdapterContract.Presenter {

    private List<Person> mListPerson;

    @Override
    public void getPerson(int position, PersonAdapterContract.View rowView) {
        Person person = mListPerson.get(position);
        rowView.setTitle(person.getName());
        rowView.setAddress(person.getAddress());
    }

    @Override
    public void setListPerson(List<Person> listPerson) {
        this.mListPerson = listPerson;
    }

    @Override
    public int countListPersonSize() {
        return mListPerson.size();
    }
}
