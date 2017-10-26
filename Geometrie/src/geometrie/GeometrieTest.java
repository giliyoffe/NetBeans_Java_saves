package geometrie;
import java.util.Arrays;
import java.util.Random;
import werkzeug.Sammlung;
import Tastatur.Eingabe;

/**
 * Klasse GeometrieTest dient zum Testen der
 * Objekte, welche durch Klassen in Projekt GeometrieTest
 * beschreiben sind.
 * 
 * @author GYoffe
 */
public class GeometrieTest 
{
    public static void main(String[] args) 
    {
//       /* Definieren eines Objectes(--> Arbeitspeicher)
//        rEck ist die Referenz-Variable auf das Objekt
//        Rechteck(12,7) - Aufruf der Konstruktur-Methode 
//        Merke: 
//        - dem new-Operator folgt IMMER der aufruf des Konstrukturs
//        - der new Operator liefert IMMER die Referenz auf das Objekt
//        */
//        Rechteck rEck = new Rechteck(12, 7);   //Definition eines Objektes
//        int flaeche = rEck.berecheFlaeche();  // Methodenaufruf
//        int umfang = rEck.berecheUmfang();    // Methodenaufruf
//        
//        // Konsolenanzeige
//        System.out.println("Fläche von rEck: " + flaeche);
//        System.out.println("Umfang von rEck: " + umfang);
//        
//        // Änderung von Werten über Zugriffsmethoden
//        rEck.setGrundkante(9);
//        rEck.setSeitenkante(23);
//        System.out.println("Neue Grundkante: " + rEck.getGrundkante());
//        System.out.println("Neue Seitenkante: " + rEck.getSeitenkante());
//        System.out.println(rEck);
//        
//        // *** Test Klasse Kreis ***
//        // Definieren eines Objectes
//        Kreis kReis = new Kreis(3.0);   //Definition eines Objektes
//        double kreisFlaeche = kReis.berechnenFlaeche();  // Methodenaufruf
//        double kreisUmfang = kReis.berechnenUmfang();    // Methodenaufruf
//        // Konsolenanzeige
//        System.out.println("\nKreis mit Radius " + kReis.getRadius()
//                            + "\nKreisflaeche: " + kreisFlaeche
//                            + "\nKreisumfang: " + kreisUmfang);
//        // Änderung von Werten über Zugriffsmethoden
//        kReis.setRadius(23.56);
//        System.out.println("Neue Kreis: " + kReis.getRadius());
//        System.out.println(kReis);
//        
//        //Test Klasse Parallelogramm
//        System.out.println("\n*** Test Parallelogramm ***\n");
//        Parallelogramm para = new Parallelogramm(15, 9, 6);
//        System.out.println(para);
//        System.out.println("Umfang von para: " + para.berecheUmfang());                
//        System.out.println("Flaeche von para: " + para.berecheFlaeche());
//        
//        Parallelogramm para2 = new Parallelogramm();
//        System.out.println("para2: " + para2);
//        para2.setGrundkante(23);
//        para2.setSeitenkante(29);
//        para2.setHoehe(20);
//        System.out.println("para2: " + para2);
//        System.out.println("Umfang von para: " + para2.berecheUmfang());                
//        System.out.println("Flaeche von para: " + para2.berecheFlaeche());
//
//        //Test Klasse Kugel
//        System.out.println("\n*** Test Kugel ***\n");  
//        Kugel kugel1 = new Kugel();
//        System.out.println(kugel1);
//        kugel1.setRadius(5.0);
//        System.out.println(kugel1);
//       
//        //Test Klasse Laenge
//        System.out.println("\n*** Test Laenge ***\n");
//        Laenge laengeMeter = new Laenge(0.0254,'m');
//        Laenge laengeInch = new Laenge(1,'i');
//        Laenge laengeFoot = new Laenge(1,'f');
//        Laenge laengeYard = new Laenge(1,'y');
//       
//        System.out.println("Meter Länge umrechnung: " + laengeMeter +
//                          "\nInch Länge umrechnung: " + laengeInch +
//                          "\nFoot Länge umrechnung: " + laengeFoot +
//                          "\nYard Länge umrechnung: " + laengeYard );
//        
//        Rechteck rEck11 = new Rechteck(6,15);
//        Rechteck rEck12 = new Rechteck(6,15);
//        
//        if ( rEck11 == rEck12 )
//            System.out.println("Sind gleich");
//        else
//            System.out.println("Nicht gleich");
        
//        if ( rEck11.equals(rEck12) )
//             System.out.println("Sind gleich");
//        else
//            System.out.println("Nicht gleich");
//        
//        // Array mit 10 Rechtecken
//        int[] zahlen = new int[10];
//        // Definition eines Zufalls-Objektes
//        Random random = new Random();
//        
//        // Definition des Objekt - Arrays
//        Rechteck[] feld = new Rechteck[10];
//        // Anzeigen an der Konsole
//        for ( int i = 0; i < feld.length; i++)
//        {   // Definition der einzelnen Objekte
//            feld[i] = new Rechteck();
//            feld[i].setGrundkante(random.nextInt(100) + 1);        //does the same function as the next row. info in http://docs.oracle.com/javase/8/docs/api/
//            feld[i].setSeitenkante((int) (Math.random() * 100)+1);
//            System.out.println(feld[i].toString() + 
//                    ", " + feld[i].berecheFlaeche());
//        }
//        
//     //   Arrays.sort(feld); // Array sortieren
//        
//        Sammlung.bubblesort(feld);
//        System.out.println("sortieren");
//        for ( int i = 0; i < feld.length; i++) // Anzeigen
//        {
//            System.out.println(feld[i].toString() + 
//                    ", " + feld[i].berecheFlaeche());
//        }
        
        
//        // Test Dreieck
//        Dreieck dreieck1 = null;
//        Dreieck dreieck2 = new Dreieck();
//        int a = Eingabe.readInteger("Dreieck-Seite A: ");
//        int b = Eingabe.readInteger("Dreieck-Seite B: ");
//        int c = Eingabe.readInteger("Dreieck-Seite C: ");
//
//        if ( Dreieck.isDreieck(a, b, c))
//        {
//            dreieck1 = new Dreieck(a,b,c);
//            System.out.println(dreieck1);
//        }
//        else
//        {
//            System.out.println(a + " und " + b + " und " + c 
//                               + "sind kein Dreieck.");
//        }
//        if ( dreieck1.equals(dreieck2))
//            System.out.println(dreieck1 + " und " 
//                               + dreieck2 + "Dreiecke sind gleich");
//        else
//            System.out.println(dreieck1 + " und " 
//                               + dreieck2 + "Dreiecke sind NICHT gleich");

        
        // Array mit 10 Dreiecken anlegen
        // ( mit zufälligen Werten für Seitenkanten )
        
        Dreieck[] feld = new Dreieck[10]; // Definieren eines Arrays
        // Zuweisen von 10 zufälligen Werten
        for ( int i = 0; i < feld.length; i++)
        { 
           int a = (int) (Math.random() * 100);
           int b = (int) (Math.random() * 100);
           int c = (int) (Math.random() * 100);
           try 
           { 
               feld[i] = new Dreieck(a,b,c); 
           } catch (IllegalArgumentException iae ) // iae = name of variable
           {
               i--; // Schleifenzähler zurücksetzen
               continue; // Sprung zum Sleifenanfang
           }

           // Anzeige des Arrays
           System.out.println(feld[i]);
        }
        
        // Array sortieren
        werkzeug.Sammlung.bubblesort(feld);        
        // Anzeige des sortiren Arrays
        System.out.println("Sortiert");
        for ( int i = 0; i < feld.length; i++)
        {
            System.out.println(feld[i] + " " + feld[i].berecheFlaeche());
        }
        
           
    } // Ende main()
    
} // Ende class
