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



            }
        });


    }
}