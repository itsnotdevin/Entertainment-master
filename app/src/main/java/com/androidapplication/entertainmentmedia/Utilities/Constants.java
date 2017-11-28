package com.androidapplication.entertainmentmedia.Utilities;
/**
 * Created by ahmed on 11/7/2017.
 * Fixed/updated by devin 11/28
 */
public class Constants {

    // REST heroku links
    public static final String MOVIE_URL = "https://cop4331.herokuapp.com/api/movies";
    public static final String CREW_URL = "https://cop4331.herokuapp.com/api/crews";
    public static final String GENRE_URL = "https://cop4331.herokuapp.com/api/genres";
    public static final String TV_URL = "https://cop4331.herokuapp.com/api/tvs";
    public static final String NETWORK_URL = "https://cop4331.herokuapp.com/api/networks";

    // Crew table column names
    public static final String TAG_FIRST = "fname";
    public static final String TAG_LAST = "lname";
    public static final String TAG_BDAY = "birth_day";
    public static final String TAG_FROM_LOC = "birth_plc";
    public static final String TAG_CID = "id";
    public static final String TAG_ROLE = "known_for";
    public static final String TAG_BIO = "bio";
    public static final String TAG_MALE = "is_male";
    public static final String TAG_WORKED = "movies";

    // TV/MOVIE column names
    public static final String TAG_TITLE = "title";
    public static final String TAG_PIC = "pic_url";
    public static final String TAG_IMDB = "imdb_id";
    public static final String TAG_DESC = "description";
    public static final String TAG_GENRE = "genres";
    public static final String TAG_CREW = "crews";
    public static final String TAG_NET = "networks";
    public static final String TAG_SERIES = "series_name";
    public static final String TAG_TV_SNUM = "series_numb";
    public static final String TAG_EPIS = "series_epis";
    public static final String TAG_DATE = "air_date_time";

    // Network/User column names
    public static final String TAG_EMAIL = "email";
    public static final String TAG_USERNAME = "username";
    public static final String TAG_PASSWORD = "password";
    public static final String TAG_NETWORK = "name";
    public static final String TAG_CONF = "password_confirmation";

}
