package com.example.mascotaruta_mcn;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrarMascotaActivity extends AppCompatActivity {



    private Button btnVolver2,btnRegistrar;
    private EditText etNombre,etComidaFav,etJugueteFav;
    private RadioGroup radioGroup;
    private Switch swVacunas;

    private Integer botonid;
    private RatingBar rBsociabilidad;
    private CheckBox chbCastrado,chbSeguimiento;

    private String nombre,comida,juguete,raza,vacunas,sociabilidad,castrado,seguimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar_mascota);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        btnVolver2 = findViewById(R.id.btnvolver2);



        btnVolver2.setOnClickListener(v -> {

            Intent intent = new Intent(RegistrarMascotaActivity.this,MainActivity.class);
            intent.addFlags(intent.FLAG_ACTIVITY_SINGLE_TOP | intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();


        });


        btnRegistrar = findViewById(R.id.btnRegistrar);

        //EDITTEXTS
        etNombre = findViewById(R.id.etNombre);
        etComidaFav = findViewById(R.id.etComidaFav);
        etJugueteFav = findViewById(R.id.etJugueteFav);

        //RADIO
        radioGroup = findViewById(R.id.radioGroup);

        // SWITCH
        swVacunas =findViewById(R.id.swVacunas);

        // RATING BAR
        rBsociabilidad = findViewById(R.id.rBsociabilidad);

        //Checkboxs
        chbCastrado = findViewById(R.id.chbCastrado);
        chbSeguimiento = findViewById(R.id.chbSeguimiento);




        btnRegistrar.setOnClickListener(v -> {

            nombre = etNombre.getEditableText().toString().trim();
            comida = etComidaFav.getEditableText().toString().trim();
            juguete = etJugueteFav.getEditableText().toString().trim();

            if (nombre.isEmpty() || comida.isEmpty() || juguete.isEmpty()){

                btnRegistrar.setError("Ningun Campo de texto debe estar vacio");
            }

            botonid = radioGroup.getCheckedRadioButtonId();

            if (botonid != -1){

                raza = botonid.toString();

            }else {
                btnRegistrar.setError("Seleccione la categoria de raza.");
            }

            if (swVacunas.isActivated()){

                vacunas = "Si";
            }else{
                vacunas = "No";
            }


            sociabilidad = String.valueOf(rBsociabilidad.getRating());


            if (chbCastrado.isChecked())  {castrado = "si" ;} else { castrado = "no";}
            if (chbSeguimiento.isChecked())  {seguimiento = "si" ;} else { seguimiento = "no";}

            Intent intentenviar = new Intent(RegistrarMascotaActivity.this, ConfirmacionActivity.class);
            intentenviar.addFlags(intentenviar.FLAG_ACTIVITY_CLEAR_TOP | intentenviar.FLAG_ACTIVITY_SINGLE_TOP);



            intentenviar.putExtra("CLAVE_NOMBRE",nombre);
            intentenviar.putExtra("CLAVE_COMIDA",comida);
            intentenviar.putExtra("CLAVE_JUGUETE",juguete);
            intentenviar.putExtra("CLAVE_RAZA",raza);
            intentenviar.putExtra("CLAVE_VACUNAS",vacunas);
            intentenviar.putExtra("CLAVE_SOCIABILIDAD",sociabilidad);
            intentenviar.putExtra("CLAVE_CASTRADO",castrado);
            intentenviar.putExtra("CLAVE_SEGUIMIENTO",seguimiento);









            startActivity(intentenviar);
            finish();


        });






    }








}