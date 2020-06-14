package com.example.goalalarm;

public class NewsModel {
    private String newsTitle;
    private String newsDescription;
    private String newsImage;
    private String newsPostedDate;


    public NewsModel() {
    }

    public NewsModel(String newsTitle, String newsDescription, String newsImage, String newsPostedDate) {
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
        this.newsImage = newsImage;
        this.newsPostedDate = newsPostedDate;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public String getNewsPostedDate() {
        return newsPostedDate;
    }
}
