package dominando.android.activityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_ESTADO = 1;
    private static final String STATE_ESTADO = "estado";

    private Button botaoEstado;

    private String estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoEstado = (Button) this.findViewById(R.id.btnState);
        botaoEstado.setOnClickListener(this);

        if (savedInstanceState != null) {
            estado = savedInstanceState.getString(STATE_ESTADO);
            if (estado != null) {
                botaoEstado.setText(estado);
            }
        }
    }

    @Override
    public void onClick(View view) {
        Intent it = new Intent(this, TelaSelecaoActivity.class);
        it.putExtra(TelaSelecaoActivity.EXTRA_ESTADO, estado);
        this.startActivityForResult(it, REQUEST_ESTADO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUEST_ESTADO) {
            estado = data.getStringExtra(TelaSelecaoActivity.EXTRA_RESULTADO);
            if (estado != null) {
                botaoEstado.setText(estado);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_ESTADO, estado);
    }
}
