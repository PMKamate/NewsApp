package com.newsapp.Entity;

/**
 * Created by server on 28/9/17.
 */

public class Category {
    String category_name;

    public Category(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
