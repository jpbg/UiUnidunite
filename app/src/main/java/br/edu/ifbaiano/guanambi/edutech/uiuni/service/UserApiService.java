package br.edu.ifbaiano.guanambi.edutech.uiuni.service;

import androidx.annotation.FloatRange;

import br.edu.ifbaiano.guanambi.edutech.uiuni.model.Token;
import br.edu.ifbaiano.guanambi.edutech.uiuni.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserApiService {

    @Headers("Content-type: application/json")

    @POST("user/")
    Call<User> criarUsuario(@Body User user);

    @POST("token/")
    Call<User> obterToken(@Body User user);



}
