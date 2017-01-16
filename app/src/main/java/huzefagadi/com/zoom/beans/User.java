package huzefagadi.com.zoom.beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rashida on 15/01/17.
 */

public class User {

    @SerializedName("firstname")
    private String firstName;
    @SerializedName("lastname")
    private String lastName;
    private String gender;
    private String email;
    @SerializedName("mobile_no")
    private String mobileNumber;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
