package dominando.android.orientacao;

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

        nomes = new ArrayList<String>();
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
}
