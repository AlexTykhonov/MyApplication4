package com.tae.myapplication.entity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRetrofit {

    @GET("api/moto")
    Call<List<MotoPojo>> getMotos();
}


// создать ресайкл вью и вывести все на экран.