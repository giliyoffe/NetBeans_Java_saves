package uebungen;

import Tastatur.Eingabe;

/**
 * ** Beispiel für Reguläre Ausdrucke
 * Eingabe von Personendaten und
 * felder PLZ und Geburtstag prüfen.
 * @author GYoffe
 */
public class Beispielmuster_Literale 
{
    public static void main(String[] args) 
    {
        String name     = Eingabe.readString("Name: ");
        String plz      = Eingabe.readString("PLZ: ");
        String ort      = Eingabe.readString("Ort: ");
        String gebtag   = Eingabe.readString("Geburtstag (dd.MM.jjjj): ");
        
        // PLZ prüfen.
        while(!(plz.matches("[0-9]{5}")))
        {
            System.out.println("Eingabe Fehler bei feld PLZ.");
            plz = Eingabe.readString("PLZ: ");
        }
        
        // Geburtstag prüfen.
        while(!(gebtag.matches("[0-3][0-9].[0-1][0-9].[12][0-9]{3}")))
        {
            System.out.println("Eingabe Fehler bei feld Geburtstag.");
            gebtag   = Eingabe.readString("Geburtstag (dd.MM.jjjj): ");
        }


    }
}


    // lorenz
//        while(true)
//        {
//            String gebtag   = Eingabe.readString("Geburtstag (dd.MM.jjjj): ");
//            if(gebtag.matches("[0-3][0-9].[0-1][0-9].[12][0-9]{3}"))
//            break;
//            System.out.println("Eingabe Fehler bei feld Geburtstag.");
//        }