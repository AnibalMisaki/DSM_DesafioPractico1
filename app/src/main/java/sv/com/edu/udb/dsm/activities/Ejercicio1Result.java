package sv.com.edu.udb.dsm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import sv.com.udb.dsm.R;
public class Ejercicio1Result extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvMes;
    private TextView tvCodigo;
    private TextView tvVentas;
    private TextView tvPorcentaje;
    private TextView tvComision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1_result);

        tvNombre = findViewById(R.id.viewNombre);
        tvMes = findViewById(R.id.viewMes);
        tvCodigo = findViewById(R.id.viewCodigo);
        tvVentas = findViewById(R.id.viewVentas);
        tvPorcentaje = findViewById(R.id.viewPorcentaje);
        tvComision = findViewById(R.id.viewTotal);

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("txtNombre");
        String mes = bundle.getString("txtMes");
        String codigo = bundle.getString("txtCodigo");
        String ventas = bundle.getString("txtVentas");
        String comision = bundle.getString("Comision");
        String total = bundle.getString("totComision");

        tvNombre.setText(nombre);
        tvMes.setText(mes);
        tvCodigo.setText(codigo);
        tvVentas.setText(ventas);
        tvPorcentaje.setText(comision);
        tvComision.setText(total);
    }

    public void finalizar(View view) {
        finish();
    }
}