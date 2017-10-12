package com.newsapp.RestClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newsapp.Interface.APIService;


import okhttp3.OkHttpClient;


/**
 * Created by server on 2/6/17.
 */

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "https://newsapi.org/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }


}
