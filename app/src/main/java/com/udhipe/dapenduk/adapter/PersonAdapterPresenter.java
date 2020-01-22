package com.udhipe.dapenduk.adapter;

import com.udhipe.dapenduk.model.Person;

import java.util.List;

public class PersonAdapterPresenter implements PersonAdapterContract.Presenter {

    private List<Person> mListPerson;
    private PersonAdapterContract.View mView;

    @Override
    public void getPerson(int position, PersonAdapterContract.View.Holder rowView) {
        Person person = mListPerson.get(position);
        rowView.setTitle(person.getName());
        rowView.setAddress(person.getAddress());
    }

    @Override
    public void setListPerson(List<Person> listPerson) {
        this.mListPerson = listPerson;
        mView.refreshDataView();
    }

    @Override
    public int countListPersonSize() {
        return mListPerson.size();
    }

    @Override
    public void setAdapter(PersonAdapter personAdapter) {
        this.mView = personAdapter;
    }
}
