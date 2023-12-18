package br.edu.ifbaiano.guanambi.edutech.uiuni.service;

import java.util.List;

import br.edu.ifbaiano.guanambi.edutech.uiuni.model.Task;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TarefaApiService {

    @Headers("Content-type: application/json")
    @POST("tarefa/")
    Call<Task> criarTarefa(@Header("Authorization") String token, @Body Task task);



    @GET("tarefa/")
    Call<List<Task>> obterTarefas(@Header("Authorization") String token );


    @GET("tarefa/{id}")
    Call<Task> obterTarefa(@Header("Authorization") String token, @Path("id") String id);
}
