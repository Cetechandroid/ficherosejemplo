package com.example.eduardopalacios.ficherosejemplo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduardopalacios.ficherosejemplo.Clases.FicheroME;
import com.example.eduardopalacios.ficherosejemplo.Clases.FicheroMI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnGuardar,btnEliminar,btnGuardarSD,btnEliminarSD,btnMostrarFI,btnMostrarME;
    EditText editText;

    private int requestCode;
    private int grantResults[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGuardar=findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(this);

        btnGuardarSD=findViewById(R.id.btnGuardarSD);
        btnGuardarSD.setOnClickListener(this);

        btnEliminar=findViewById(R.id.btnEliminar);
        btnEliminar.setOnClickListener(this);

        btnEliminarSD=findViewById(R.id.btnEliminarSD);
        btnEliminarSD.setOnClickListener(this);

        btnMostrarFI=findViewById(R.id.btnMostrar);
        btnMostrarFI.setOnClickListener(this);

        btnMostrarME=findViewById(R.id.mostrar2);
        btnMostrarME.setOnClickListener(this);

        editText=findViewById(R.id.EtArchivo);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            //if you dont have required permissions ask for it (only required for API 23+)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, requestCode);


            onRequestPermissionsResult(requestCode, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, grantResults);


        }
    }


    @Override
    public void onClick (View view) {
        switch (view.getId())
        {
            case R.id.btnGuardar:
                FicheroMI guardar=new FicheroMI(this,editText.getText().toString());
                guardar.crearFichero();

                break;

            case R.id.btnMostrar:

                FicheroMI leer=new FicheroMI(this);
                Toast.makeText(getApplication(),leer.leerFichero(),Toast.LENGTH_SHORT).show();

                break;

            case R.id.btnEliminar:

                FicheroMI eliminar=new FicheroMI(this);
                eliminar.eliminarFichero();

                break;

            case R.id.btnGuardarSD:

                FicheroME guardarSD =new FicheroME(editText.getText().toString());
                guardarSD.crearFicheroSD();
                break;

            case R.id.btnEliminarSD:

                FicheroME eliminarSD=new FicheroME();
                eliminarSD.eliminarFicheroSD();
                break;


            case R.id.mostrar2:
                FicheroME mostrarSD =new FicheroME();
                Toast.makeText(getApplication(),mostrarSD.MostrarFicheroSD(),Toast.LENGTH_SHORT).show();
                break;

                default:
                    break;
        }
    }

    @Override // android recommended class to handle permissions
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Log.d("permission", "granted");
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.uujm
                    Toast.makeText(MainActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();

                    //app cannot function without this permission for now so close it...
                    onDestroy();
                }
                return;
            }

            // other 'case' line to check fosr other
            // permissions this app might request
        }
    }
}
