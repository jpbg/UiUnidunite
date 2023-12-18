package br.edu.ifbaiano.guanambi.edutech.uiuni.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.ifbaiano.guanambi.edutech.uiuni.R;
import br.edu.ifbaiano.guanambi.edutech.uiuni.model.User;

public class principalActivity extends AppCompatActivity {

    Button btnNovaTarefa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        SharedPreferences sp = getSharedPreferences("appUiUni", Context.MODE_PRIVATE);
        User user = new User();
        user.setPassword(sp.getString("password",""));
        user.setId(Integer.getInteger(sp.getString("id","")));
        user.setMail(sp.getString("mail",""));
        user.setUsername(sp.getString("user",""));

        btnNovaTarefa = findViewById(R.id.btn_cad_tarefa);

        btnNovaTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(principalActivity.this, cadastrarTarefaActivity.class);
                startActivity(it);
            }
        });






    }
}