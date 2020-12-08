
// Result.java

package com.android.javajsonapp;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class Result implements Parcelable {
    @SerializedName("title")
    private String title;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("genre_ids")
    private long[] genreIDS;
    @SerializedName("id")
    private long id;
    @SerializedName("original_language")
    private OriginalLanguage originalLanguage;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("overview")
    private String overview;

    private LocalDate releaseDate;
    @SerializedName("video")
    private boolean video;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("vote_count")
    private long voteCount;

    protected Result(Parcel in) {
        adult = in.readByte() != 0;
        backdropPath = in.readString();
        genreIDS = in.createLongArray();
        id = in.readLong();
        originalTitle = in.readString();
        overview = in.readString();
        popularity = in.readDouble();
        posterPath = in.readString();
        title = in.readString();
        video = in.readByte() != 0;
        voteAverage = in.readDouble();
        voteCount = in.readLong();
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    public boolean getAdult() { return adult; }
    public void setAdult(boolean value) { this.adult = value; }

    public String getBackdropPath() { return backdropPath; }
    public void setBackdropPath(String value) { this.backdropPath = value; }

    public long[] getGenreIDS() { return genreIDS; }
    public void setGenreIDS(long[] value) { this.genreIDS = value; }

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public OriginalLanguage getOriginalLanguage() { return originalLanguage; }
    public void setOriginalLanguage(OriginalLanguage value) { this.originalLanguage = value; }

    public String getOriginalTitle() { return originalTitle; }
    public void setOriginalTitle(String value) { this.originalTitle = value; }

    public String getOverview() { return overview; }
    public void setOverview(String value) { this.overview = value; }

    public double getPopularity() { return popularity; }
    public void setPopularity(double value) { this.popularity = value; }

    public String getPosterPath() { return posterPath; }
    public void setPosterPath(String value) { this.posterPath = value; }

    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate value) { this.releaseDate = value; }

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public boolean getVideo() { return video; }
    public void setVideo(boolean value) { this.video = value; }

    public double getVoteAverage() { return voteAverage; }
    public void setVoteAverage(double value) { this.voteAverage = value; }

    public long getVoteCount() { return voteCount; }
    public void setVoteCount(long value) { this.voteCount = value; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (adult ? 1 : 0));
        dest.writeString(backdropPath);
        dest.writeLongArray(genreIDS);
        dest.writeLong(id);
        dest.writeString(originalTitle);
        dest.writeString(overview);
        dest.writeDouble(popularity);
        dest.writeString(posterPath);
        dest.writeString(title);
        dest.writeByte((byte) (video ? 1 : 0));
        dest.writeDouble(voteAverage);
        dest.writeLong(voteCount);
    }
}
