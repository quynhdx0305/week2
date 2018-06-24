package com.example.quynh.resources1.data.book;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//NewYorkTime->Results->List->Book->Buylink
public class NewYorkTime {

@SerializedName("status")
@Expose
private String status;
@SerializedName("copyright")
@Expose
private String copyright;
@SerializedName("num_results")
@Expose
private Integer numResults;
@SerializedName("results")
@Expose
private Results results;

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getCopyright() {
return copyright;
}

public void setCopyright(String copyright) {
this.copyright = copyright;
}

public Integer getNumResults() {
return numResults;
}

public void setNumResults(Integer numResults) {
this.numResults = numResults;
}

public Results getResults() {
return results;
}

public void setResults(Results results) {
this.results = results;
}

}