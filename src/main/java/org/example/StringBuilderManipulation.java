package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringBuilderManipulation {
    public static void StringBuilderManipulation(){
        repeater();
    }

    public static void repeater(){
        Scanner sc = new Scanner(System.in);
        int totalWords= 0;
        int repetitionWords = 0;
        String[] words;
        StringBuilder sb = new StringBuilder();

        totalWords = ReverseAndSearchArray.readInt(sc, "¿Cuantas palabras quieres introducir?", "Tienen que ser palabras");
        words = new String[totalWords];

        for (int i = 0; i<totalWords; i++){
            sb.setLength(0);
            sb.append("Palabra en la posición ").append(i+1).append(":");
            words[i] = readWord(sc, sb.toString(), "Debe de ser una palabra");
        }

        sb.setLength(0);
        repetitionWords = ReverseAndSearchArray.readInt(sc, "Cuantas veces quieres repetir esas palabras", "Tienes que dar un número entero");

        if(repetitionWords < 1){
            System.out.println("Invalid input");
        } else{
            for (int i = 0; i < totalWords; i++){
                for(int j = 0; j < repetitionWords; j++){
                    sb.append(words[i]);
                    if (!(i == totalWords-1 && j == repetitionWords-1)){
                        sb.append(" ");
                    }
                }
            }
        }
        System.out.println(sb.toString());

        sc.close();
    }

    public static String readWord(Scanner sc, String message, String errorMessage){
        String readedNumber = "";
        boolean repeatQuestion = false;

        do {
            repeatQuestion = false;
            try{
                System.out.println(message);
                readedNumber = sc.next();
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
