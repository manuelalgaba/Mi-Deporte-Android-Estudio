package com.miempresa.aplicandoestilos;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rgColor;
    private CheckBox ckbNegrita, ckbCursiva;
    private Switch swtObscuro, swtInfoLog;
    private TextView txtRespuesta;
    private RadioButton rdbRojo, rdbVerde, rdbAzul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inicializamos las vistas
        rgColor = findViewById(R.id.rgcolor);
        ckbNegrita = findViewById(R.id.ckbNegrita);
        ckbCursiva = findViewById(R.id.ckbCursiva);
        swtObscuro = findViewById(R.id.swtObscuro);
        swtInfoLog = findViewById(R.id.swtInfoLog);
        txtRespuesta = findViewById(R.id.txtRespuesta);
        rdbRojo = findViewById(R.id.rdbRojo);
        rdbVerde = findViewById(R.id.rdbVerde);
        rdbAzul = findViewById(R.id.rdbAzul);

        // Listener para el grupo de radio
        rgColor.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rdbRojo) {
                txtRespuesta.setTextColor(ContextCompat.getColor(this, R.color.rojo));
            } else if (checkedId == R.id.rdbVerde) {
                txtRespuesta.setTextColor(ContextCompat.getColor(this, R.color.verde));
            } else if (checkedId == R.id.rdbAzul) {
                txtRespuesta.setTextColor(ContextCompat.getColor(this, R.color.azul));
            }
        });

        // Listener para el checkbox de negrita y cursiva combinados
        ckbNegrita.setOnCheckedChangeListener((buttonView, isChecked) -> cambiarEstiloTexto());
        ckbCursiva.setOnCheckedChangeListener((buttonView, isChecked) -> cambiarEstiloTexto());

        // Listener para el switch oscuro
        swtObscuro.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                txtRespuesta.setTextColor(ContextCompat.getColor(this, R.color.black));
            } else {
                txtRespuesta.setTextColor(ContextCompat.getColor(this, R.color.white));
            }
        });

        // Listener para el switch info log
        swtInfoLog.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Log.d("MainActivity", "Modo info log habilitado");
            } else {
                Log.d("MainActivity", "Modo info log deshabilitado");
            }
        });
    }

    // Método para actualizar el estilo del texto (negrita y cursiva combinados)
    private void cambiarEstiloTexto() {
        if (ckbNegrita.isChecked() && ckbCursiva.isChecked()) {
            txtRespuesta.setTypeface(null, android.graphics.Typeface.BOLD_ITALIC);
        } else if (ckbNegrita.isChecked()) {
            txtRespuesta.setTypeface(null, android.graphics.Typeface.BOLD);
        } else if (ckbCursiva.isChecked()) {
            txtRespuesta.setTypeface(null, android.graphics.Typeface.ITALIC);
        } else {
            txtRespuesta.setTypeface(null, android.graphics.Typeface.NORMAL);
        }
    }
}
