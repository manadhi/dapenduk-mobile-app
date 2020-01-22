package com.udhipe.dapenduk.main;

import com.udhipe.dapenduk.model.DaoSession;
import com.udhipe.dapenduk.model.Person;
import com.udhipe.dapenduk.model.PersonDao;

import org.greenrobot.greendao.query.Query;

import java.util.List;

public class MainInteractor implements MainContract.Interactor {

    @Override
    public void loadData(DaoSession daoSession, String filter, Listener<List<Person>> listener) {
        try {
            PersonDao mPersonDao = daoSession.getPersonDao();
            Query<Person> personQuery = mPersonDao.queryBuilder().orderAsc(PersonDao.Properties.Name).build();
            List<Person> listPersonData = personQuery.list();
            listener.onSuccess(listPersonData, "success");
        } catch (Exception exception) {
            listener.onError(exception.getMessage());
        }
    }

    @Override
    public void deleteData(DaoSession daoSession, Long id, Listener<Boolean> listener) {

    }
}
