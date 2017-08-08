package dominando.android.orientacao;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edit;
    private ArrayList<String> nomes;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            nomes = savedInstanceState.getStringArrayList("nomes");
        } else {
            nomes = new ArrayList<String>();
        }

        edit = (EditText) findViewById(R.id.editText1);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes);

        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);
    }

    public void meuBotaoClick(View v) {
        nomes.add(edit.getText().toString());
        edit.setText(""); // Limpa o campo de texto
        adapter.notifyDataSetChanged(); // Atualiza automaticamente o ListView
    }

    /**
     * Método responsável por salvar o estado da activity para que não se perca
     * os dados definidos quando o aparelho for rotacionado
     *
     * @param outState
     * @param outPersistentState
     */
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putStringArrayList("nomes", nomes);
    }
}
