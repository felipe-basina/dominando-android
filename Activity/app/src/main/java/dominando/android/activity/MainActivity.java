    package dominando.android.activity;

    import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.Toast;

    import dominando.android.model.Cliente;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        private EditText editTexto;

        @Override
        protected void onStart() {
            super.onStart();
            Log.i("FBSN", "Tela1::onStart");
        }

        @Override
        protected void onResume() {
            super.onResume();
            Log.i("FBSN", "Tela1::onResume");
        }

        @Override
        protected void onRestart() {
            super.onRestart();
            Log.i("FBSN", "Tela1::onRestart");
        }

        @Override
        protected void onPause() {
            super.onPause();
            Log.i("FBSN", "Tela1::onPause");
        }

        @Override
        protected void onStop() {
            super.onStop();
            Log.i("FBSN", "Tela1::onStop");
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            Log.i("FBSN", "Tela1::onDestroy");
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            editTexto = (EditText) findViewById(R.id.editText);

            Button button = (Button) findViewById(R.id.button);
            button.setOnClickListener(this);

            Button buttonTela2 = (Button) findViewById(R.id.button2);
            buttonTela2.setOnClickListener(this);

            Button buttonTela2Parcelable = (Button) findViewById(R.id.button3);
            buttonTela2Parcelable.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button:
                    String texto = editTexto.getText().toString();
                    Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.button2:
                    Intent it = new Intent(this, Tela2Activity.class);
                    it.putExtra(Tela2Activity.PARAM_NOME, "FELIPE");
                    it.putExtra(Tela2Activity.PARAM_IDADE, 31);
                    this.startActivity(it);
                    break;

                case R.id.button3:
                    Cliente cliente = new Cliente(1, "Felipe");
                    Intent intent = new Intent(this, Tela2Activity.class);
                    intent.putExtra(Tela2Activity.PARAM_CLIENTE, cliente);
                    this.startActivity(intent);
                    break;
            }
        }
    }
