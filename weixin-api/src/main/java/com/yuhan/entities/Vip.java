package com.yuhan.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.Objects;

@Data
/*@AllArgsConstructor
@NoArgsConstructor*/
@Accessors(chain = true)
public class Vip {
    private int id;
    private int user_id;
    private String name;
    private String id_number;
    private String tel;
    private Timestamp first_time;
    private Timestamp end_time;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Timestamp getFirst_time() {
        return first_time;
    }

    public void setFirst_time(Timestamp first_time) {
        this.first_time = first_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", name='" + name + '\'' +
                ", id_number='" + id_number + '\'' +
                ", tel='" + tel + '\'' +
                ", first_time=" + first_time +
                ", end_time=" + end_time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vip vip = (Vip) o;
        return id == vip.id &&
                user_id == vip.user_id &&
                Objects.equals(name, vip.name) &&
                Objects.equals(id_number, vip.id_number) &&
                Objects.equals(tel, vip.tel) &&
                Objects.equals(first_time, vip.first_time) &&
                Objects.equals(end_time, vip.end_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, name, id_number, tel, first_time, end_time);
    }

    public Vip(int id, int user_id, String name, String id_number, String tel, Timestamp first_time, Timestamp end_time) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.id_number = id_number;
        this.tel = tel;
        this.first_time = first_time;
        this.end_time = end_time;
    }

    public Vip() {
    }

    public Vip(int user_id, String name, String id_number, String tel, Timestamp first_time, Timestamp end_time) {
        this.user_id = user_id;
        this.name = name;
        this.id_number = id_number;
        this.tel = tel;
        this.first_time = first_time;
        this.end_time = end_time;
    }
}
