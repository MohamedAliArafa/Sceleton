package com.example.mohamedarafa.sceleton.models.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mohamed.arafa on 9/5/2017.
 */

public class BaseRequestModel extends RealmObject{
    @PrimaryKey
    @SerializedName("AlbumID")
    @Expose
    private Integer albumID;


    @SerializedName("AlbumName")
    @Expose
    private String albumName;
    @SerializedName("AlbumImage")
    @Expose
    private String albumImage;
    @SerializedName("language")
    @Expose
    private Integer language;
    @SerializedName("keyword")
    @Expose
    private String keyword;
    @SerializedName("MediaType")
    @Expose
    private Integer mediaType;
    @SerializedName("AlbumDescription")
    @Expose
    private String albumDescription;

    public Integer getAlbumID() {
        return albumID;
    }

    public void setAlbumID(Integer albumID) {
        this.albumID = albumID;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumImage() {
        return albumImage;
    }

    public void setAlbumImage(String albumImage) {
        this.albumImage = albumImage;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getMediaType() {
        return mediaType;
    }

    public void setMediaType(Integer mediaType) {
        this.mediaType = mediaType;
    }

    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription;
    }
}
