package com.example.data_insert_listview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("insert.php")
    Call<Modelperson> insertperson (@Body Modelperson modelperson);

    @GET("getData.php")
    Call<List<Modelperson>> getAllData();

}
