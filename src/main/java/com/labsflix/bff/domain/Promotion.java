package com.labsflix.bff.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "promotions")
public class Promotion {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String category;

    @NotNull
    private String content;

    @NotNull
    private int promotionMonth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPromotionMonth() {
        return promotionMonth;
    }

    public void setPromotionMonth(int promotionMonth) {
        this.promotionMonth = promotionMonth;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", content='" + content + '\'' +
                ", promotionMonth=" + promotionMonth +
                '}';
    }

}