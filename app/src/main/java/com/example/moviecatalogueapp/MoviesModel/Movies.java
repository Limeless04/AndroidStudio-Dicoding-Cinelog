package com.example.moviecatalogueapp.MoviesModel;

import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable {
    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlaytime() {
        return playtime;
    }

    public void setPlaytime(String playtime) {
        this.playtime = playtime;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    private int photo;
    private String video;
    private String title;
    private String description;
    private String rating;
    private String year;
    private String director, genre, playtime;
    private String writer;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeString(this.video);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.rating);
        dest.writeString(this.year);
        dest.writeString(this.director);
        dest.writeString(this.genre);
        dest.writeString(this.playtime);
        dest.writeString(this.writer);
    }

    public Movies() {
    }

    private Movies(Parcel in) {
        this.photo = in.readInt();
        this.video = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.rating = in.readString();
        this.year = in.readString();
        this.director = in.readString();
        this.genre = in.readString();
        this.playtime = in.readString();
        this.writer = in.readString();
    }

    public static final Parcelable.Creator<Movies> CREATOR = new Parcelable.Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel source) {
            return new Movies(source);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };
}
