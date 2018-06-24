package com.example.quynh.resources1.recyclerview.main;

public class MainView {
    private String web_url;
    private String snippet;
    private String url_hinh;

    public MainView(String web_url, String snippet, String url_hinh) {
        this.web_url = web_url;
        this.snippet = snippet;
        this.url_hinh = url_hinh;
    }

    public String getWeb_url() {
        return web_url;
    }
    public String getSnippet() {
        return snippet;
    }
    public String getUrl_hinh() {
        return url_hinh;
    }
}
