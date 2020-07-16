package app.shijin.shijinnewsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsArticles {
    @SerializedName("articles")
    @Expose
    private ArrayList<NewsInfo> articles;

    public ArrayList<NewsInfo> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<NewsInfo> news) {
        this.articles = news;
    }
}
