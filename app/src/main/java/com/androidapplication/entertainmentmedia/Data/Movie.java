package com.androidapplication.entertainmentmedia.Data;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ahmed on 11/7/2017.
 * fixed/uated by devin 11/28
 */

public class Movie implements Serializable {
    private String title;
    private String pic_url;
    private String description;
    private String network;
    private String series_name;
    private String air_date;
    private Integer imdb_id, series_episode;
    private String crew_member;
    private String genre;

    public Movie(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getSeries_name() {
        return series_name;
    }

    public void setSeries_name(String series_name) {
        this.series_name = series_name;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public Integer getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(Integer imdb_id) {
        this.imdb_id = imdb_id;
    }

    public int getSeries_episode() {
        return series_episode;
    }

    public void setSeries_episode(int series_episode) {
        this.series_episode = series_episode;
    }

    public String getCrew_members() {
        return crew_member;
    }

    public void setCrewMember(String crew_member) {
        this.crew_member = crew_member;
    }
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
