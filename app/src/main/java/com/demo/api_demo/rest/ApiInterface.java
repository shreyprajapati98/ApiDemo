package com.demo.api_demo.rest;

import com.demo.api_demo.Model.MessageResponse;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.GET;

public interface ApiInterface {
    @GET("posts")
    Call<List<MessageResponse>> getMessageDetails();
    // atle list of msgresponse che

    @GET("comments")
    Call<List<MessageResponse>> getDetails();


}
