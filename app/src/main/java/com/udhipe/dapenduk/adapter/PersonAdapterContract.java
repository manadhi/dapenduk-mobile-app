package com.udhipe.dapenduk.adapter;

import com.udhipe.dapenduk.model.Person;

import java.util.List;

public interface PersonAdapterContract {
    interface View {

        void refreshDataView();

        interface Holder {

            void setTitle(String name);

            void setAddress(String address);
        }

    }

    interface Presenter {
        void getPerson(int position, PersonAdapterContract.View.Holder rowView);

        void setListPerson(List<Person> listPerson);

        int countListPersonSize();

        void setAdapter(PersonAdapter personAdapter);
    }

    interface Model {

    }
}