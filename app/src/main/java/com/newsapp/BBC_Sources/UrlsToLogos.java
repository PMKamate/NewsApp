
package com.newsapp.BBC_Sources;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UrlsToLogos {

    @SerializedName("small")
    @Expose
    public String small;
    @SerializedName("medium")
    @Expose
    public String medium;
    @SerializedName("large")
    @Expose
    public String large;

}
