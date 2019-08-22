package com.example.fiba.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "find_child_table")
public class FindChild {

    @PrimaryKey(autoGenerate = true)
    private int childId;

    private int childPhoto;

    private String childName;
    private String childSex;
    private String childPlace;
    private String childAge;
    private String childWeight;
    private String childHeight;
    private String findChildProtecter;
    private String detailContents;

    public FindChild(int childPhoto, String childName, String childSex, String childPlace,
                     String childAge, String childHeight, String childWeight, String findChildProtecter, String detailContents) {

        this.childPhoto = childPhoto;
        this.childName = childName;
        this.childSex = childSex;
        this.childAge = childAge;
        this.childPlace = childPlace;
        this.childHeight = childHeight;
        this.childWeight = childWeight;
        this.findChildProtecter = findChildProtecter;
        this.detailContents = detailContents;
    }

    public int getChildId() {

        return childId;
    }

    public void setChildId(int childId) {

        this.childId = childId;
    }

    public int getChildPhoto() {

        return childPhoto;
    }

    public void setChildPhoto(int childPhoto) {

        this.childPhoto = childPhoto;
    }

    public String getChildHeight() {

        return childHeight;
    }

    public void setChildHeight(String childHeight) {

        this.childHeight = childHeight;
    }

    public String getChildWeight() {

        return childWeight;
    }

    public void setChildWeight(String childWeight) {

        this.childWeight = childWeight;
    }

    public String getChildName() {

        return childName;
    }

    public void setChildName(String childName) {

        this.childName = childName;
    }

    public String getChildSex() {

        return childSex;
    }

    public void setChildSex(String childSex) {

        this.childSex = childSex;
    }

    public String getChildPlace() {

        return childPlace;
    }

    public void setChildPlace(String childPlace) {

        this.childPlace = childPlace;
    }

    public String getChildAge() {

        return childAge;
    }

    public void setChildAge(String childAge) {

        this.childAge = childAge;
    }

    public String getFindChildProtecter() {

        return findChildProtecter;
    }

    public void setFindChildProtecter(String findChildProtecter) {

        this.findChildProtecter = findChildProtecter;
    }

    public String getDetailContents() {

        return detailContents;
    }

    public void setDetailContents(String detailContents) {

        this.detailContents = detailContents;
    }
}
