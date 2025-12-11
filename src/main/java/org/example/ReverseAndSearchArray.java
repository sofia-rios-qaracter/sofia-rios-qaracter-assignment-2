package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReverseAndSearchArray {
    public static void ReverseAndSearchArray(){
        Scanner sc = new Scanner(System.in);
        int arrayLength = 0;
        int searchedNumber = 0;
        int[] array;
        int[] arrayReversed;
        StringBuilder sb = new StringBuilder();
        boolean searchedNumberFindIt = false;

        do {
            arrayLength = readInt(sc, "¿Cual quieres que sea la longitud del array?", "La longitud debe ser un número entero.");
            if (arrayLength < 0 ){
                System.out.println("La longitud debe ser mayor que 0.");
            }
        }while(arrayLength < 0);

        array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++){
            sb.setLength(0);
            sb.append("Introduce un numero para la posicion ").append(i).append(":");
            array[i] = readInt(sc, sb.toString(), "Debe de ser un número entero.");
        }
        System.out.println("El array es el siguiente:");
        System.out.println(arrayToString(array));

        arrayReversed = reverseArray(array);

        System.out.println("El array invertido es el siguiente:");
        System.out.println(arrayToString(arrayReversed));

        searchedNumber = readInt(sc, "Ahora da un numero dentro del array a buscar.", "Debes de dar un número entero.");

        for (int i = 0; i < array.length; i++){
            if(array[i] == searchedNumber){
                sb.setLength(0);
                sb.append("Se ha encontrado el número en la posición ").append(i).append(".");
                System.out.println(sb.toString());
                searchedNumberFindIt = true;
            }
        }
        if(!searchedNumberFindIt){
            System.out.println("No hay apariciones del número indicado.");
        }
    }

    public static String arrayToString(int[] array){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        for (int i = 0; i < array.length; i++){
            sb.append(array[i]);

            if(i != array.length-1){
                sb.append(", ");
            } else {
                sb.append(" ]");
            }
        }

        return sb.toString();
    }

    public static int[] reverseArray(int[] array){
        int length = array.length;
        int[] reversedArray = new int[length];

        for (int i = 0; i < length; i++){
            reversedArray[i] = array[length-i-1];
        }

        return reversedArray;
    }

    public static int readInt(Scanner sc, String message, String errorMessage){
        int readedNumber = 0;
        boolean repeatQuestion = false;

        do {
            repeatQuestion = false;
            try{
                System.out.println(message);
                readedNumber = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                repeatQuestion = true;
                System.out.println(errorMessage);
            }
        }while (repeatQuestion);

        return readedNumber;
    }
}
