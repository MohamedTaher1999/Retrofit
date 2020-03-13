package com.example.retrofit;
import com.google.gson.annotations.SerializedName;
public class movieModel {
    @SerializedName("original_title")
    private String original_title;

    @SerializedName("poster_path")
    private String poster_path;

    @SerializedName("overview")
    private String overview;



    public movieModel(String overview,String original_title,String poster_path) {
        this.overview = overview;
        this.original_title=original_title;
        this.poster_path=poster_path;
    }

    public String getPoster_path() {
        return poster_path;
    }
    public String getOverview() {
        return overview;
    }
    public String getOriginal_title() {
        return original_title;
    }


}
