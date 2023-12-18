package br.edu.ifbaiano.guanambi.edutech.uiuni.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifbaiano.guanambi.edutech.uiuni.R;
import br.edu.ifbaiano.guanambi.edutech.uiuni.model.User;
import br.edu.ifbaiano.guanambi.edutech.uiuni.service.ServiceGenerator;
import br.edu.ifbaiano.guanambi.edutech.uiuni.service.UserApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class cadastrarActivity extends AppCompatActivity {


    Button btnCadastrar;
    EditText edtUser,edtPassword,edtMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        btnCadastrar = findViewById(R.id.btn_cadastrar);
        edtMail = findViewById(R.id.edt_user2);
        edtUser = findViewById(R.id.edt_descricao);
        edtPassword = findViewById(R.id.edt_senha);



        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User u = new User();
                u.setUsername(edtUser.getText().toString());
                u.setMail(edtMail.getText().toString());
                u.setPassword(edtPassword.getText().toString());

                UserApiService service = ServiceGenerator.createService(UserApiService.class);
                Call<User> call = service.criarUsuario(u);

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {

                        if (response.isSuccessful()) {


                        User user = response.body();

                        SharedPreferences sharedPref = getSharedPreferences("appUiUni", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("user",u.getUsername());
                        editor.putString("mail",u.getMail());
                        editor.putString("password",u.getPassword());
                        editor.putString("id",user.getId().toString());
                        editor.commit();

                        Toast.makeText(cadastrarActivity.this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();

                        Intent it = new Intent(cadastrarActivity.this, principalActivity.class);

                        startActivity(it);

                        }else{

                            Toast.makeText(getApplicationContext(),"Erro na chamada ao servidor", Toast.LENGTH_SHORT).show();

                        }

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                        Toast.makeText(cadastrarActivity.this, "Erro ao criar usuário.", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }
}