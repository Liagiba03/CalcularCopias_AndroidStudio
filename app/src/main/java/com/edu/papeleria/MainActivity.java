package com.edu.papeleria;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Spinner;

import com.edu.papeleria.model.TotalPago;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
//PASO 1: Declarar los viewa a manipular
    TextInputEditText txtCliente;
    TextInputEditText txtCantidad;
    ImageButton btnCalcular;
    ImageButton btnNuevo;
    Spinner spnTipoPago;
    String [] opPago={
      "--Seleccionar",
      "Efectivo",
            "Vales Despensa",
            "Tarjeta"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //PASO 2: Inicializar lo views, objetos, componentes con su identificador del xml
        txtCliente = findViewById(R.id.etxtCliente);
        txtCantidad = findViewById(R.id.etxtNumCopias);
        btnCalcular = findViewById(R.id.botonCalcular);
        btnNuevo = findViewById(R.id.botonNuevo);
        spnTipoPago = findViewById(R.id.spnTipoPago);
        //Creando el Adapter para el spinner
        ArrayAdapter<String> adapTipoPagos = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                opPago
        );
        adapTipoPagos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTipoPago.setAdapter(adapTipoPagos);


        //PASO 3: Crear evento clic para botón calcular y nuevo
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Los datos que se reciben tienen que ser el mismo tipo de dato que en el tds
                String nomCliente;
                int cant;
                String tPagar;

                //RECIBIR EL DATO DE LOS EDIT TEXT
                //COn las cajas de texto se pasa en un tipo de objeto Editable y se pasa a un String y despues al tipo de dato
                nomCliente = txtCliente.getText().toString();
                cant = Integer.parseInt(txtCantidad.getText().toString());
                tPagar = spnTipoPago.getSelectedItem().toString();
                TotalPago pago = new TotalPago();
                pago.setCopias(cant);
                pago.setTipoPago(tPagar);
                pago.cliente= nomCliente;
                Toast.makeText(getApplicationContext(), //Actividad donde se verá
                        pago.calcularTotal(),//Poner dato que se muestra
                        Toast.LENGTH_LONG
                ).show();
            }
        });
        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtCliente.setText(null);
                txtCantidad.setText(null);
            }
        });
    }
    //Casi no se utiliza
    public void salir (View boton){
        finish();
    }
}