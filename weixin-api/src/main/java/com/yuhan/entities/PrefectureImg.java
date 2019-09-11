package com.yuhan.entities;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Objects;

@Data
/*@AllArgsConstructor
@NoArgsConstructor*/
@Accessors(chain = true)
public class PrefectureImg {
    private int id;
    private String name;
    private String img_url;
    private String type;

    public PrefectureImg(int id, String name, String img_url, String type) {
        this.id = id;
        this.name = name;
        this.img_url = img_url;
        this.type = type;
    }

    @Override
    public String toString() {
        return "\"PrefectureImg\":{" +
                "\"id\":\"" + id +
                "\",\"name\":\"" + name +
                "\",\"img_url\":\"" + img_url +
                "\",\"type\":\"" + type +
                "\"}";
    }

    public PrefectureImg(String name, String img_url, String type) {
        this.name = name;
        this.img_url = img_url;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrefectureImg that = (PrefectureImg) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(img_url, that.img_url) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, img_url, type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PrefectureImg() {
    }
}
