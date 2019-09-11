package com.yuhan.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Integral {
    private int id;
    private int merchandise_id;

    private int need_integral;
    private String need_price;
    private int vipneed_integral;
    private String vipneed_price;
    private int sum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\"Integral\":{" +
                "\"id\":\"" + id +
                "\",\"merchandise_id\":\"" + merchandise_id +
                "\", \"need_integral\":\"" + need_integral +
                "\", \"need_price\":\"" + need_price +
                "\", \"vipneed_integral\":\"" + vipneed_integral +
                "\", \"vipneed_price\":\"" + vipneed_price +
                "\", \"sum\":\"" + sum +
                "\"}";
    }

    public Integral(int merchandise_id, int need_integral, String need_price, int vipneed_integral, String vipneed_price, int sum) {
        this.merchandise_id = merchandise_id;
        this.need_integral = need_integral;
        this.need_price = need_price;
        this.vipneed_integral = vipneed_integral;
        this.vipneed_price = vipneed_price;
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Integral integral = (Integral) o;
        return id == integral.id &&
                merchandise_id == integral.merchandise_id &&
                need_integral == integral.need_integral &&
                vipneed_integral == integral.vipneed_integral &&
                sum == integral.sum &&
                Objects.equals(need_price, integral.need_price) &&
                Objects.equals(vipneed_price, integral.vipneed_price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, merchandise_id, need_integral, need_price, vipneed_integral, vipneed_price, sum);
    }

    public int getMerchandise_id() {
        return merchandise_id;
    }

    public void setMerchandise_id(int merchandise_id) {
        this.merchandise_id = merchandise_id;
    }

    public int getNeed_integral() {
        return need_integral;
    }

    public void setNeed_integral(int need_integral) {
        this.need_integral = need_integral;
    }

    public String getNeed_price() {
        return need_price;
    }

    public void setNeed_price(String need_price) {
        this.need_price = need_price;
    }

    public int getVipneed_integral() {
        return vipneed_integral;
    }

    public void setVipneed_integral(int vipneed_integral) {
        this.vipneed_integral = vipneed_integral;
    }

    public String getVipneed_price() {
        return vipneed_price;
    }

    public void setVipneed_price(String vipneed_price) {
        this.vipneed_price = vipneed_price;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
