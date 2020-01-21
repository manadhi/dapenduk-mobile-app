package com.udhipe.dapenduk.model;

import com.udhipe.dapenduk.util.GenderTypeConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;

@Entity(indexes = {
        @Index(value = "name, id DESC", unique = true)
})

public class Person {

    public enum Gender {
        MALE, FEMALE
    }

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private String birthPlace;
    @NotNull
    private Date birthDate;

    @NotNull
    @Convert(converter = GenderTypeConverter.class, columnType = String.class)
    private Gender gender;

    private String photoPath;
    private String profession;

    @Generated(hash = 1024547259)
    public Person() {
    }

    @Generated(hash = 954449568)
    public Person(Long id, @NotNull String name, @NotNull String address, @NotNull String birthPlace,
            @NotNull Date birthDate, @NotNull Gender gender, String photoPath, String profession) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
        this.gender = gender;
        this.photoPath = photoPath;
        this.profession = profession;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    public String getAddress() {
        return address;
    }

    public void setAddress(@NotNull String address) {
        this.address = address;
    }

    @NotNull
    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(@NotNull String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @NotNull
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@NotNull Date birthDate) {
        this.birthDate = birthDate;
    }

    @NotNull
    public Gender getGender() {
        return gender;
    }

    public void setGender(@NotNull Gender gender) {
        this.gender = gender;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}