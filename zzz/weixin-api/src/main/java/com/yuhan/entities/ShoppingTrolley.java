package com.yuhan.entities;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Objects;

@Data
/*@AllArgsConstructor
@NoArgsConstructor*/
@Accessors(chain = true)
public class ShoppingTrolley {
    private int id;
    private int user_id;
    private int merchandise_id;
    private int merchandise_sum;

    public ShoppingTrolley(int id, int user_id, int merchandise_id, int merchandise_sum) {
        this.id = id;
        this.user_id = user_id;
        this.merchandise_id = merchandise_id;
        this.merchandise_sum = merchandise_sum;
    }

    public ShoppingTrolley(int user_id, int merchandise_id, int merchandise_sum) {
        this.user_id = user_id;
        this.merchandise_id = merchandise_id;
        this.merchandise_sum = merchandise_sum;
    }

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

    public int getMerchandise_id() {
        return merchandise_id;
    }

    public void setMerchandise_id(int merchandise_id) {
        this.merchandise_id = merchandise_id;
    }

    public int getMerchandise_sum() {
        return merchandise_sum;
    }

    public void setMerchandise_sum(int merchandise_sum) {
        this.merchandise_sum = merchandise_sum;
    }

    public ShoppingTrolley() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingTrolley that = (ShoppingTrolley) o;
        return id == that.id &&
                user_id == that.user_id &&
                merchandise_id == that.merchandise_id &&
                merchandise_sum == that.merchandise_sum;
    }

    @Override
    public String toString() {
        return "Shopping_trolley{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", merchandise_id=" + merchandise_id +
                ", merchandise_sum=" + merchandise_sum +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, merchandise_id, merchandise_sum);
    }

}
