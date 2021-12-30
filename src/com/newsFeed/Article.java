package com.newsFeed;

public class Article {

    private String title;
    private String content;
    private String imageURL1;
    private String imageURL2;
    private int id;

    public Article() { }

    public Article (String title, String content, String imageURL1, String imageURL2) {

        this.title = title;
        this.content = content;
        this.imageURL1 = imageURL1;
        this.imageURL2 = imageURL2;

    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public String getImageURL1() { return imageURL1; }

    public void setImageURL1(String imageURL1) { this.imageURL1 = imageURL1; }

    public String getImageURL2() { return imageURL2; }

    public void setImageURL2(String imageURL2) { this.imageURL2 = imageURL2; }

    public int getId() { return id; }

    public void setId (int id) { this.id = id; }

}

