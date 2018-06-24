package com.example.quynh.resources1.recyclerview.book;

import com.example.quynh.resources1.data.book.Book;

public class BookListOverView {
    private Integer list_id;
    private String list_name;
    private String list_name_encoded;
    private String display_name;
    private String updated;
    private String list_image;
    private Integer list_image_width;
    private Integer list_image_height;
    private Book books;

    //contractor
    public BookListOverView(Integer list_id, String list_name, String list_name_encoded, String display_name, String updated, String list_image, Integer list_image_width, Integer list_image_height, Book books) {
        this.list_id = list_id;
        this.list_name = list_name;
        this.list_name_encoded = list_name_encoded;
        this.display_name = display_name;
        this.updated = updated;
        this.list_image = list_image;
        this.list_image_width = list_image_width;
        this.list_image_height = list_image_height;
        this.books = books;
    }
    //geter seter

    public Integer getList_id() {
        return list_id;
    }
    public void setList_id(Integer list_id) {
        this.list_id = list_id;
    }

    public String getList_name() {
        return list_name;
    }
    public void setList_name(String list_name) {
        this.list_name = list_name;
    }

    public String getList_name_encoded() {
        return list_name_encoded;
    }
    public void setList_name_encoded(String list_name_encoded) {
        this.list_name_encoded = list_name_encoded;
    }

    public String getDisplay_name() {
        return display_name;
    }
    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getUpdated() {
        return updated;
    }
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getList_image() {
        return list_image;
    }
    public void setList_image(String list_image) {
        this.list_image = list_image;
    }

    public Integer getList_image_width() {
        return list_image_width;
    }
    public void setList_image_width(Integer list_image_width) {
        this.list_image_width = list_image_width;
    }

    public Integer getList_image_height() {
        return list_image_height;
    }
    public void setList_image_height(Integer list_image_height) {
        this.list_image_height = list_image_height;
    }

    public Book getBooks() {
        return books;
    }
    public void setBooks(Book books) {
        this.books = books;
    }
}
