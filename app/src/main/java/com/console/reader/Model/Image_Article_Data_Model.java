package com.console.reader.Model;

public class Image_Article_Data_Model {
    public final int id;
    public final String name;
    public final String htmlUrl;
    public final String description;
    public final String thumb_Url;
    public final int stargazersCount;

    public Image_Article_Data_Model(int id, String name, String htmlUrl, String description, String thumb_Url, int stargazersCount) {
        this.id = id;
        this.name = name;
        this.htmlUrl = htmlUrl;
        this.description = description;
        this.thumb_Url = thumb_Url;
        this.stargazersCount = stargazersCount;
    }
}

