package com.example.eduardopalacios.ficherosejemplo.Clases;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by oemy9 on 14/04/2018.
 */


public class FicheroME {
    boolean disponibleSD,disponibeEscrituraSD;
    String texto;
    String nombreFichero="prueba2.txt";

    public FicheroME(String texto)
    {
     this.texto=texto;
    }

    public FicheroME () {

    }

    public void crearFicheroSD(){

        comprobarMemoriaSD();
        if (disponibeEscrituraSD==true && disponibleSD==true)
        {
            try{
                File file=new File(Environment.getExternalStorageDirectory().getAbsolutePath(),nombreFichero);

                OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream(file));

                writer.write(texto);
                writer.close();



            }catch (Exception e)
            {

            }
        }
    }
    public String MostrarFicheroSD(){
        String contenido="";
        File directorio=new File(Environment.getExternalStorageDirectory().getAbsolutePath(),nombreFichero);


        try{
            BufferedReader lector=new BufferedReader(new InputStreamReader(new FileInputStream(directorio)));

            contenido=lector.readLine();
        }
            catch(Exception e){

        }
        return contenido;
    }


    public void comprobarMemoriaSD()
    {
        String estado= Environment.getExternalStorageState();

        if(estado.equalsIgnoreCase(Environment.MEDIA_MOUNTED))
        {
            disponibleSD=true;
            disponibeEscrituraSD=true;
        }
        if(estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY))
        {
            disponibleSD=true;
            disponibeEscrituraSD=false;
        }
    }
    public void eliminarFicheroSD()
    {
        File directorio=new File(Environment.getExternalStorageDirectory().getAbsolutePath(),nombreFichero);

        directorio.delete();
    }
}
