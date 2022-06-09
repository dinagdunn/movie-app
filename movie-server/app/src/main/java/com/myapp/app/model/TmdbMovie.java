package com.myapp.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;


public class TmdbMovie {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("imdb_id")
    private String ibdmId;

    @JsonProperty("backdrop_path")
    private String backdropPath;

    @JsonProperty("original_language")
    private String originalLanguage;

    @JsonProperty("revenue")
    private Integer revenue;

    @JsonProperty("original_title")
    private String originalTitle;

    @JsonProperty(value = "video")
    private String video;

    @JsonProperty("title")
    private String title;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("genre_ids")
    private List<Integer> genreIds;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("vote_average")
    private BigDecimal voteAverage;

    @JsonProperty("popularity")
    private BigDecimal popularity;

    @JsonProperty("adult")
    private Boolean adult;

    @JsonProperty("tagline")
    private String tagline;

    @JsonProperty("homepage")
    private String homepage;

    @JsonProperty("belongs_to_collection")
    private Object belongsToCollection;

    @JsonProperty("budget")
    private Integer budget;

    @JsonProperty("runtime")
    private Integer runtime;

    @JsonProperty("vote_count")
    private Integer voteCount;

    @JsonProperty("status")
    private String status;

    public TmdbMovie() {

    }


}
