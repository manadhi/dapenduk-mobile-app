package com.udhipe.dapenduk.adapter;

import com.udhipe.dapenduk.model.Person;

import java.util.List;

public interface PersonAdapterContract {
    interface View {
        void setTitle(String title);

        void setAddress(String address);
    }

    interface Presenter {
        void getPerson(int position, PersonAdapterContract.View rowView);

        void setListPerson(List<Person> listPerson);

        int countListPersonSize();
    }

    interface Model {

    }
}