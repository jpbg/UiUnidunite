package br.edu.ifbaiano.guanambi.edutech.uiuni.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.edu.ifbaiano.guanambi.edutech.uiuni.R;

public class loginActivity extends AppCompatActivity {

    TextView tvCad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        tvCad = findViewById(R.id.txt_cadastrar);

        tvCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(loginActivity.this, cadastrarActivity.class);
                startActivity(it);
            }
        });
    }
}