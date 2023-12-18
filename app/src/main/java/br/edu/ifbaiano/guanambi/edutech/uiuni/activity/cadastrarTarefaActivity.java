package br.edu.ifbaiano.guanambi.edutech.uiuni.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import br.edu.ifbaiano.guanambi.edutech.uiuni.R;
import br.edu.ifbaiano.guanambi.edutech.uiuni.model.Task;
import br.edu.ifbaiano.guanambi.edutech.uiuni.model.Token;
import br.edu.ifbaiano.guanambi.edutech.uiuni.model.User;
import br.edu.ifbaiano.guanambi.edutech.uiuni.service.ServiceGenerator;
import br.edu.ifbaiano.guanambi.edutech.uiuni.service.TarefaApiService;
import br.edu.ifbaiano.guanambi.edutech.uiuni.service.UserApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class cadastrarTarefaActivity extends AppCompatActivity {

    Button btnCad;
    EditText edtDescricao;
    Switch urgente, importante;
    User user;
    User userAux;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_tarefa);

        btnCad = findViewById(R.id.btn_cad_tarefa);
        edtDescricao = findViewById(R.id.edt_descricao);
        urgente = findViewById(R.id.switch1);
        importante = findViewById(R.id.switch2);

        SharedPreferences sp = getSharedPreferences("appUiUni", Context.MODE_PRIVATE);
        user = new User();
        user.setId(6);
        user.setUsername(sp.getString("user",""));
        user.setPassword(sp.getString("password",""));
        user.setMail(sp.getString("mail",""));

        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Task task = new Task();
                task.setDescricao(edtDescricao.getText().toString());
                task.isUrgente(urgente.isChecked());
                task.isImporante(importante.isChecked());
                task.setUsuario(user.getId());


                UserApiService service = ServiceGenerator.createService(UserApiService.class);
                Call<User> callToken = service.obterToken(user);

                callToken.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        userAux = response.body();
                        TarefaApiService tarefaApiService = ServiceGenerator.createService(TarefaApiService.class);
                        Call<Task> call1 = tarefaApiService.criarTarefa("Bearer "+userAux.getAccess(),task);

                        call1.enqueue(new Callback<Task>() {
                            @Override
                            public void onResponse(Call<Task> call, Response<Task> response) {
                                Toast.makeText(cadastrarTarefaActivity.this, "Tarefa criada com sucesso", Toast.LENGTH_SHORT).show();

                                Intent it = new Intent(cadastrarTarefaActivity.this, principalActivity.class);
                                startActivity(it);


                            }

                            @Override
                            public void onFailure(Call<Task> call, Throwable t) {

                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });






            }
        });




    }
}