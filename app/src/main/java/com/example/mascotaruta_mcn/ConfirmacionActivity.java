package com.example.mascotaruta_mcn;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmacionActivity extends AppCompatActivity {


    private Button btnVolver,btnconfirm;
    private TextView txtnombre,txtcomida,txtjuguete,txtraza,txtvacuna,txtsociabilidad,txtcastrado,txtseguimiento;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirmacion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        btnVolver = findViewById(R.id.btnvolver);
        btnconfirm = findViewById(R.id.btnconfirm);


        txtnombre = findViewById(R.id.txtnombre);
        txtcomida = findViewById(R.id.txtcomida);
        txtjuguete = findViewById(R.id.txtjuguete);

        txtraza = findViewById(R.id.txtraza);

        txtvacuna = findViewById(R.id.txtvacuna);

        txtsociabilidad = findViewById(R.id.txtsociabilidad);

        txtcastrado = findViewById(R.id.txtcastrado);

        txtseguimiento = findViewById(R.id.txtseguimiento);




        Intent intentrecibido = getIntent();


        txtnombre.setText(" Nombre: " + intentrecibido.getStringExtra("CLAVE_NOMBRE"));
        txtcomida.setText("Comida favorita: " + intentrecibido.getStringExtra("CLAVE_COMIDA"));
        txtjuguete.setText("Juguete favorito: " + intentrecibido.getStringExtra("CLAVE_JUGUETE"));
        txtraza.setText("Tipo de raza: " + intentrecibido.getStringExtra("CLAVE_RAZA"));
        txtvacuna.setText("Vacunas al dia : " + intentrecibido.getStringExtra("CLAVE_VACUNAS"));
        txtsociabilidad.setText("Nivel Sociabilidad: " + intentrecibido.getStringExtra("CLAVE_SOCIABILIDAD"));
        txtcastrado.setText("Castrado: " + intentrecibido.getStringExtra("CLAVE_CASTRADO"));
        txtseguimiento.setText("Seguimiento: " + intentrecibido.getStringExtra("CLAVE_SEGUIMIENTO"));











        btnVolver.setOnClickListener(v -> {

            Intent intent = new Intent(ConfirmacionActivity.this,MainActivity.class);
            intent.addFlags(intent.FLAG_ACTIVITY_SINGLE_TOP | intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();


        });






    }
}