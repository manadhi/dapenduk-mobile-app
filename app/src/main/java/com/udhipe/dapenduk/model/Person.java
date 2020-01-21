package com.udhipe.dapenduk.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

@Entity(indexes = {
        @Index(value = "name, id DESC", unique = true)
})

public class Person {
    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private String birthPlace;
    @NotNull
    private String birthDate;
    @NotNull
    private String gender;

    private String photoPath;
    private String profession;

    @Generated(hash = 1024547259)
    public Person() {
    }

    @Generated(hash = 181443522)
    public Person(Long id, @NotNull String name, @NotNull String address, @NotNull String birthPlace,
            @NotNull String birthDate, @NotNull String gender, String photoPath, String profession) {
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
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@NotNull String birthDate) {
        this.birthDate = birthDate;
    }

    @NotNull
    public String getGender() {
        return gender;
    }

    public void setGender(@NotNull String gender) {
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