package com.example.activitywithresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // define codigo de requisicao
    private static final int ITEM_REQUEST = 1;

    // define uma chave para um dado no Intent
    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String CLASS= "class";

    private TextView textNome;
    private TextView textIdade;
    private TextView textCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textNome = findViewById(R.id.name);
        textIdade = findViewById(R.id.idade);
        textCurso = findViewById(R.id.curso);

        Button buttonMain = (Button) findViewById(R.id.iniciar);

        // define um listener para o botao
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO: criar o Itent explicito para iniciar a Activity 'FormActivity'.
                // Dica: Use startActivityForResult() para passar o Intent e o codigo de requisicao
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                startActivityForResult(intent,ITEM_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // TODO: codificar a condicional:
        // se ha um resultado E ele eh o resultado esperado de acordo com o codigo de requisicao
        // Dica: quando ha um resultado, entao use RESULT_OK
        if(requestCode == ITEM_REQUEST && resultCode == RESULT_OK) {

            // TODO: extrair os dados do Intent por cada chave
            // dica: use o metodo getStringExtra(<chave>) do Intent
            textNome.setText("Nome: " + data.getStringExtra(NAME));
            textIdade.setText("Idade: " + data.getStringExtra(AGE));
            textCurso.setText("Curso: " + data.getStringExtra(CLASS));
        }
    }

}
