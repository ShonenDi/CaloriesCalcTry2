package com.shonen.ukr.caloriescalculatorapp;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private String userName;
    private int userAge;
    private boolean genderMale = false;
    private boolean genderFemale=false;
    private double userHeight;
    private double userWeight;
    private double userActivityCoef;
    private double caloriesPerDay;

    public User(String userName, int userAge, double userHeight, double userWeight, double userActivityCoef, double caloriesPerDay) {
        this.userName = userName;
        this.userAge = userAge;
        this.userHeight = userHeight;
        this.userWeight = userWeight;
        this.userActivityCoef = userActivityCoef;
        this.caloriesPerDay = caloriesPerDay;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public boolean isGenderMale() {
        return genderMale;
    }

    public void setGenderMale(boolean genderMale) {
        this.genderMale = genderMale;
    }

    public boolean isGenderFemale() {
        return genderFemale;
    }

    public void setGenderFemale(boolean genderFemale) {
        this.genderFemale = genderFemale;
    }

    public double getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(double userHeight) {
        this.userHeight = userHeight;
    }

    public double getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(double userWeight) {
        this.userWeight = userWeight;
    }

    public double getUserActivityCoef() {
        return userActivityCoef;
    }

    public void setUserActivityCoef(double userActivityCoef) {
        this.userActivityCoef = userActivityCoef;
    }
    public double getCaloriesPerDay() {
        return caloriesPerDay;
    }

    public void setCaloriesPerDay(double caloriesPerDay) {
        this.caloriesPerDay = caloriesPerDay;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return userAge == user.userAge &&
                genderMale == user.genderMale &&
                genderFemale == user.genderFemale &&
                Double.compare(user.userHeight, userHeight) == 0 &&
                Double.compare(user.userWeight, userWeight) == 0 &&
                Double.compare(user.userActivityCoef, userActivityCoef) == 0 &&
                Double.compare(user.caloriesPerDay, caloriesPerDay) == 0 &&
                Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userAge, genderMale, genderFemale, userHeight, userWeight, userActivityCoef, caloriesPerDay);
    }


}
