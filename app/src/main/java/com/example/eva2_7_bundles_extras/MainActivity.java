package com.example.eva2_7_bundles_extras;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText txtValor1;
EditText txtValor2;
TextView txtResultado;
Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtValor1 = findViewById(R.id.txtValor1);
        txtValor2 = findViewById(R.id.txtValor2);
        txtResultado = findViewById(R.id.txtResultado);



    }

    public void onClick(View v){

        //Obtener los valores
        Double v1 = Double.parseDouble(txtValor1.getText().toString());
        Double v2 = Double.parseDouble(txtValor2.getText().toString());

        //Crear el intento
        Intent main2 = new Intent(this,Main2Activity.class);

        //Crear el bundle
        Bundle miBundle = new Bundle();

        miBundle.putDouble("val1",v1);
        miBundle.putDouble("val2",v2);

        main2.putExtras(miBundle);

       startActivityForResult(main2,101);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if ((requestCode == 101) && (resultCode == Activity.RESULT_OK)){
                Bundle miBlundleResultado = data.getExtras();
                Double miResultado = miBlundleResultado.getDouble("vresult");
                txtResultado.setText("La suma es " + miResultado);
            }
        }
        catch (Exception e){
            txtResultado.setText("Problemas - " + requestCode + "" +resultCode);
        }
    }
}
