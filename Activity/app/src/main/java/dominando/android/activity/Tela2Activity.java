package dominando.android.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import dominando.android.model.Cliente;

public class Tela2Activity extends AppCompatActivity {

    public static String PARAM_NOME = "nome";
    public static String PARAM_IDADE = "idade";
    public static String PARAM_CLIENTE = "cliente";

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("FBSN", "Tela2::onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("FBSN", "Tela2::onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("FBSN", "Tela2::onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("FBSN", "Tela2::onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("FBSN", "Tela2::onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("FBSN", "Tela2::onDestroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        TextView txt = (TextView) findViewById(R.id.txtTexto);

        Intent it = this.getIntent();

        Cliente cliente = it.getParcelableExtra(PARAM_CLIENTE);

        if (cliente != null) {

            String texto = String.format("Nome = %s / Código = %d", cliente.nome, cliente.codigo);
            txt.setText(texto);

        } else {

            String nome = it.getStringExtra(PARAM_NOME);
            int idade = it.getIntExtra(PARAM_IDADE, -1);
            txt.setText(String.format("Nome = %s / Idade = %d", nome, idade));

        }
    }
}
