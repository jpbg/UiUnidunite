package br.edu.ifbaiano.guanambi.edutech.uiuni.service;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    public static final String API_URL = "https://api.hostmain.com.br/";

    public static <S> S createService(Class<S> serviceClass){

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder().readTimeout(15, TimeUnit.SECONDS);
        httpClient.addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson())).client(httpClient.build()).build();
        return retrofit.create(serviceClass);

    }
}
