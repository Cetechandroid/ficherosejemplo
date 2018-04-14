package com.example.eduardopalacios.ficherosejemplo.Clases;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/**
 * Created by oemy9 on 14/04/2018.
 */

public class FicheroMI {
    String texto;
    Context context;
    String nombreFichero="prueba1.txt";

    public FicheroMI(Context context,String texto)
    {
        this.texto=texto;
        this.context=context;
    }
    public FicheroMI(Context context)
    {
        this.context=context;
    }

    public void crearFichero()
    {

        FileOutputStream outputStream;

        try {
            outputStream=context.openFileOutput(nombreFichero,Context.MODE_PRIVATE);
            outputStream.write(texto.getBytes());
            outputStream.close();



        }catch (Exception e){

        }
    }

    public String leerFichero()
    {
        FileInputStream file;
        String contenido="";
        try {

            file=context.openFileInput(nombreFichero);

            BufferedReader lector=new BufferedReader(new InputStreamReader(file));

            contenido=lector.readLine();



        }catch (Exception e){

        }
        return contenido;
    }
    public void eliminarFichero(){
        String ruta="/data/data/com.example.eduardopalacios.ficherosejemplo/files/";
        File archivo=new File(ruta,nombreFichero);

        archivo.delete();

    }
}
