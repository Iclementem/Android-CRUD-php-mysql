package com.example.crud_android_php_mysql;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText edtID, edtMAC, edtTotal, edtParcial, edtOffset;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relacionamosVistas();

        //Creamos el evento onClick para el botón agregar
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio("http://192.168.1.4:8080/ejemplocrud/insertar.php");
            }
        });

    }
    public void relacionamosVistas() {  //Vinculamos con nuestros controles del layout.
        edtID=(EditText)findViewById(R.id.ID);
        edtMAC=(EditText)findViewById(R.id.MAC);
        edtTotal=(EditText)findViewById(R.id.Total);
        edtParcial=(EditText)findViewById(R.id.Parcial);
        edtOffset=(EditText)findViewById(R.id.Offset);

        btnAgregar=(Button)findViewById(R.id.Agregar);
    }
    //Método que enviará las peticiones al servidor
    private void ejecutarServicio(String URL) {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() { //mandamos petición
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "OPERACIÓN EXITOSA", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() { //En caso de error
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError { //Utilizamos el método POST por lo que hay qye indicar los parametros que enviamos al servidor
                Map<String,String> parametros= new HashMap<String, String>();
                parametros.put("ID",edtID.getText().toString());
                parametros.put("MAC",edtMAC.getText().toString());
                parametros.put("total",edtTotal.getText().toString());
                parametros.put("parcial",edtParcial.getText().toString());
                parametros.put("offset",edtOffset.getText().toString());
                return parametros;
            }
        };
        //procesamos las peticiones para que la librería se encarge de ejecutarlas
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}