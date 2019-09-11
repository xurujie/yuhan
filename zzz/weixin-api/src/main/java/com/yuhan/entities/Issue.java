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
public class Issue {
    private  int id;
    private String title;
    private String answer;
    private String type;

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id +
                "\", \"title\":\"" + title +
                "\", \"answer\":\"" + answer +
                "\", \"type\":\"" + type +
                "\"}";
    }

    public Issue(String title, String answer, String type) {
        this.title = title;
        this.answer = answer;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return id == issue.id &&
                Objects.equals(title, issue.title) &&
                Objects.equals(answer, issue.answer) &&
                Objects.equals(type, issue.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, answer, type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

