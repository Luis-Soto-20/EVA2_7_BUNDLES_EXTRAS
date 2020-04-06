package com.example.eva2_7_bundles_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
EditText txtDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtDatos = findViewById(R.id.txtDatos);

        Intent miIntentoLocal = getIntent();

        Bundle miBundle = miIntentoLocal.getExtras();
        Double v1 = miBundle.getDouble("val1");
        Double v2 = miBundle.getDouble("val2");

        Double vResult = v1 + v2;

        txtDatos.setText("Los valores recibidos son: "+"\nval1= " + v1 + "\nval2= " + v2 + "\n\nresult= " + vResult);

        miBundle.putDouble("vresult", vResult);

        miIntentoLocal.putExtras(miBundle);

        setResult(Activity.RESULT_OK,miIntentoLocal);

    }
    public void onClick(View v){
        finish();
    }
}
