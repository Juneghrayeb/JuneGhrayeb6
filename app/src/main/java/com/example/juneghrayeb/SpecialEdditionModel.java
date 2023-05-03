package com.example.juneghrayeb;

public class SpecialEdditionModel {
    String SpecialEdditionName;
    int image ;

    public SpecialEdditionModel(String specialEdditionName,int image) {
        SpecialEdditionName = specialEdditionName;
        this.image = image;

    }
    public String getSpecialEdditionName() {
        return SpecialEdditionName;
    }
    public int getImage() {
        return image;
    }
}
