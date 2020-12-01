package com.example.temp;

public class PlayerData {
    String email, contactDetails, password, name, address, noOfMatches, locality, gender, age;

    public PlayerData() {
    }

    public PlayerData(String email, String contactDetails, String password, String name, String address, String noOfMatches, String locality, String gender, String age) {
        this.email = email;
        this.contactDetails = contactDetails;
        this.password = password;
        this.name = name;
        this.address = address;
        this.noOfMatches = noOfMatches;
        this.locality = locality;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNoOfMatches() {
        return noOfMatches;
    }

    public void setNoOfMatches(String noOfMatches) {
        this.noOfMatches = noOfMatches;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
