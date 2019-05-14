package com.example.activitywithresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {
    // define chave para um dado no Intent
    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String CLASS= "class";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        final EditText textNome = (EditText) findViewById(R.id.nomeForm);
        final EditText textIdade = (EditText) findViewById(R.id.idadeForm);
        final EditText textCurso = (EditText) findViewById(R.id.cursoForm);

        Button buttonForm = (Button) findViewById(R.id.closeForm);

        // define um listener para o botao
        buttonForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO: criar o Itent e adicionar os dados, sendo cada dado relacionado com sua chave.
                // Dica: putExtra(<chave>, <valor>), sendo o valor igual a
                // <editText>.getText().toString() da <editText> correspondente.
                Intent data = new Intent();
                data.putExtra(NAME,textNome.getText().toString());
                data.putExtra(AGE,textIdade.getText().toString());
                data.putExtra(CLASS,textCurso.getText().toString());

                // definie um resultado a retornar e envia os dados pelo Intent
                FormActivity.this.setResult(RESULT_OK, data);

                // fecha a activity
                finish();
            }
        });
    }


}
