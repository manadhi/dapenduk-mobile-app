package com.udhipe.dapenduk.util;

import com.udhipe.dapenduk.model.Person;

import org.greenrobot.greendao.converter.PropertyConverter;

public class GenderTypeConverter implements PropertyConverter<Person.Gender, String> {
    @Override
    public Person.Gender convertToEntityProperty(String databaseValue) {
        return Person.Gender.valueOf(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(Person.Gender entityProperty) {
        return entityProperty.name();
    }
}
