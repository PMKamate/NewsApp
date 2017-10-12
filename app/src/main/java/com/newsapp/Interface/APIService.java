package com.newsapp.Interface;



import com.newsapp.BBC_Sources.BBCSources;
import com.newsapp.BBC_Sources.Source;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


/**
 * Created by server on 2/6/17.
 */

public interface APIService {

    /*//practitioner_payment_details
    @FormUrlEncoded
    @POST("v1/sources?")
    Call<BBCSources> BBCSources(
            @Field("practitioner_id") String practitioner_id);
*/

    @GET("v1/sources?")
    Call<BBCSources> BBCSources(@Query("language") String language,
                    @Query("id") String id,
                    @Query("category") String category);

}
