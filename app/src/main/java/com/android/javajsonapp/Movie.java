package com.android.javajsonapp;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("page")
    private long page;
    @SerializedName("results")
    private Result[] results;
    @SerializedName("total_pages")
    private long totalPages;
    @SerializedName("total_results")
    private long totalResults;


    public long getPage() { return page; }
    public void setPage(long value) { this.page = value; }

    public Result[] getResults() { return results; }
    public void setResults(Result[] value) { this.results = value; }

    public long getTotalPages() { return totalPages; }
    public void setTotalPages(long value) { this.totalPages = value; }

    public long getTotalResults() { return totalResults; }
    public void setTotalResults(long value) { this.totalResults = value; }
}
