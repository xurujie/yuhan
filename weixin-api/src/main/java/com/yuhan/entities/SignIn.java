package com.yuhan.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SignIn {

    private  int id;
    private  int user_id;
    private  String monday;
    private  String tuesday;
    private  String wednesday;
    private String thursday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public Timestamp getSign_time() {
        return sign_time;
    }

    public void setSign_time(Timestamp sign_time) {
        this.sign_time = sign_time;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    private  String friday;
    private String saturday;
    private String sunday;
    private Timestamp sign_time;
    private String integral;

    @Override
    public String toString() {
        return "\"SignIn\":{" +
                "\"id\":\"" + id +
                "\", \"user_id\":\"" + user_id +
                "\", \"monday\":\"" + monday +
                "\",\" tuesday\":\"" + tuesday +
                "\",\" wednesday\":\"" + wednesday +
                "\",\" thursday\":\"" + thursday +
                "\",\" friday\":\"" + friday +
                "\",\" saturday\":\"" + saturday +
                "\",\" sunday\":\"" + sunday +
                "\",\" sign_time\":\"" + sign_time +
                "\",\" integral\":\"" + integral +
                "\"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignIn signIn = (SignIn) o;
        return id == signIn.id &&
                user_id == signIn.user_id &&
                Objects.equals(monday, signIn.monday) &&
                Objects.equals(tuesday, signIn.tuesday) &&
                Objects.equals(wednesday, signIn.wednesday) &&
                Objects.equals(thursday, signIn.thursday) &&
                Objects.equals(friday, signIn.friday) &&
                Objects.equals(saturday, signIn.saturday) &&
                Objects.equals(sunday, signIn.sunday) &&
                Objects.equals(sign_time, signIn.sign_time) &&
                Objects.equals(integral, signIn.integral);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, monday, tuesday, wednesday, thursday, friday, saturday, sunday, sign_time, integral);
    }

    public SignIn(int user_id, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday, Timestamp sign_time, String integral) {
        this.user_id = user_id;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
        this.sign_time = sign_time;
        this.integral = integral;
    }
}
