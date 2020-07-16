package app.shijin.shijinnewsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsInfo {

    public static final int NEWS_IMAGE_TYPE = 0;
    public static final int NEWS_NO_IMAGE_TYPE = 1;
    @SerializedName("title")
    @Expose
    private String newstitle;
    @SerializedName("url")
    @Expose
    private String newsUrl;
    @SerializedName("urlToImage")
    @Expose
    private String newsUrlToImage;
    private int type;


    public NewsInfo(String newstitle, String newsUrl, String newsUrlToImage, int type) {
        this.newstitle = newstitle;
        this.newsUrl = newsUrl;
        this.newsUrlToImage = newsUrlToImage;
        this.type = type;
    }

    public String getNewstitle() {

        return newstitle.replace("/<(.*?)\\>", "");
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public String getNewsUrlToImage() {

        if (newsUrlToImage.equals("")) {
            return newsUrlToImage = null;
        } else {
            return newsUrlToImage;
        }

    }


    public int getType() {
        if (newsUrlToImage == null) {
            return NEWS_NO_IMAGE_TYPE;
        } else {
            return NEWS_IMAGE_TYPE;
        }

    }
}
