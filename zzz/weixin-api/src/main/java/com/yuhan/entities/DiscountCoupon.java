package com.yuhan.entities;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Objects;

/*
* 优惠券列表
* */
@Data
/*@AllArgsConstructor
@NoArgsConstructor*/
@Accessors(chain = true)
public class DiscountCoupon {
    private int id;
    private String discountcoding;
    private String full;
    private String minus;
    private int validtime;//有效天数

    public DiscountCoupon(int id, String discountcoding, String full, String minus, int validtime, int get_number, String img_url) {
        this.id = id;
        this.discountcoding = discountcoding;
        this.full = full;
        this.minus = minus;
        this.validtime = validtime;
        this.get_number = get_number;
        this.img_url = img_url;
    }

    public DiscountCoupon() {
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCoupon that = (DiscountCoupon) o;
        return id == that.id &&
                validtime == that.validtime &&
                get_number == that.get_number &&
                Objects.equals(discountcoding, that.discountcoding) &&
                Objects.equals(full, that.full) &&
                Objects.equals(minus, that.minus) &&
                Objects.equals(img_url, that.img_url);
    }

    @Override
    public String toString() {
        return "\"discountCoupon\":{" +
                "\"id\":\"" + id +
                "\", \"discountcoding\":\"" + discountcoding +
                "\", \"full\":\"" + full +
                "\", \"minus\":\"" + minus +
                "\", \"validtime\":\"" + validtime +
                "\", \"get_number\":\"" + get_number +
                "\", \"img_url\":\"" + img_url +
               "\"}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discountcoding, full, minus, validtime, get_number, img_url);
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getDiscountcoding() {
        return discountcoding;
    }

    public void setDiscountcoding(String discountcoding) {
        this.discountcoding = discountcoding;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getMinus() {
        return minus;
    }

    public void setMinus(String minus) {
        this.minus = minus;
    }

    public int getValidtime() {
        return validtime;
    }

    public void setValidtime(int validtime) {
        this.validtime = validtime;
    }

    public int getGet_number() {
        return get_number;
    }

    public void setGet_number(int get_number) {
        this.get_number = get_number;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public DiscountCoupon(String discountcoding, String full, String minus, int validtime, int get_number, String img_url) {
        this.discountcoding = discountcoding;
        this.full = full;
        this.minus = minus;
        this.validtime = validtime;
        this.get_number = get_number;
        this.img_url = img_url;
    }

    private int get_number;
    private String img_url;
}
