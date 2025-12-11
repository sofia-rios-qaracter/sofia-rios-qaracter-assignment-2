package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int selector = 0;
        Scanner sc = new Scanner(System.in);
        String mensaje = "Selecciona el ejercicio al que quieres acceder:\n1. Reverse And Search Array\n2. StringBuilderManipulation";


        selector = ReverseAndSearchArray.readInt(sc, mensaje, "Debes de dar un numero entero");

        if(selector == 1){
            ReverseAndSearchArray.ReverseAndSearchArray();
        } else if(selector == 2){
            StringBuilderManipulation.StringBuilderManipulation();
        } else{
            System.out.println("No has seleccionado ninguna opción");
        }

        sc.close();
    }
}