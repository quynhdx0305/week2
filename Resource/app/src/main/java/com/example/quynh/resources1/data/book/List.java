
package com.example.quynh.resources1.data.book;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class List {

@SerializedName("list_id")
@Expose
private Integer listId;
@SerializedName("list_name")
@Expose
private String listName;
@SerializedName("list_name_encoded")
@Expose
private String listNameEncoded;
@SerializedName("display_name")
@Expose
private String displayName;
@SerializedName("updated")
@Expose
private String updated;
@SerializedName("list_image")
@Expose
private String listImage;
@SerializedName("list_image_width")
@Expose
private Integer listImageWidth;
@SerializedName("list_image_height")
@Expose
private Integer listImageHeight;
@SerializedName("books")
@Expose
private java.util.List<Book> books = null;

public Integer getListId() {
return listId;
}

public void setListId(Integer listId) {
this.listId = listId;
}

public String getListName() {
return listName;
}

public void setListName(String listName) {
this.listName = listName;
}

public String getListNameEncoded() {
return listNameEncoded;
}

public void setListNameEncoded(String listNameEncoded) {
this.listNameEncoded = listNameEncoded;
}

public String getDisplayName() {
return displayName;
}

public void setDisplayName(String displayName) {
this.displayName = displayName;
}

public String getUpdated() {
return updated;
}

public void setUpdated(String updated) {
this.updated = updated;
}

public String getListImage() {
return listImage;
}

public void setListImage(String listImage) {
this.listImage = listImage;
}

public Integer getListImageWidth() {
return listImageWidth;
}

public void setListImageWidth(Integer listImageWidth) {
this.listImageWidth = listImageWidth;
}

public Integer getListImageHeight() {
return listImageHeight;
}

public void setListImageHeight(Integer listImageHeight) {
this.listImageHeight = listImageHeight;
}

public java.util.List<Book> getBooks() {
return books;
}

public void setBooks(java.util.List<Book> books) {
this.books = books;
}

}