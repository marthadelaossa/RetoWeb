package com.exito.www.utils;

public class ObtenerValor {


    public static String precio;

    public static String precio (String texto) {
        texto=texto.replaceAll("\\.","");
        texto=texto.replaceAll("\\$","");
        texto=texto.replaceAll(" ","");
        return texto;
    }
    public static String cantidad (String texto) {
        String[] parts = texto.split("\\.");
        texto= parts[0];
        return texto;
    }


}
