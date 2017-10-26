package uebungen;

import Tastatur.Eingabe;

/**
 * Ersetzen eines Buchstabens
 * @author GYoffe
 */
public class Chinesisch 
{
    public static void main(String[] args) 
    {
        // Eingabe eines Satz
        String satz = Eingabe.readLine("Satz: ");
        // Ersetzen R durch L
        satz = satz.replace('R', 'L');
        satz = satz.replace("r", "l");
        //Anzeige des Satzes
        System.out.println(satz);

    }
}
