package uebungen;

import Tastatur.Eingabe;

/**
 * Vokale Buchstaben in einer Satz Zaelen
 * @author GYoffe
 */
public class VokaleZaelen 
{
    public static void main(String[] args) 
    { // Eingabe eines Satz
        String satz = Eingabe.readLine("Satz: ");
        int a=0, e=0, i=0, o=0, u=0;
        satz = satz.toLowerCase();
        for( int index = 0; index < satz.length(); index++ ) 
        {
            switch (satz.charAt(index))
            {
                case 'a': a++; break;
                case 'e': e++; break;
                case 'i': i++; break;
                case 'o': o++; break;
                case 'u': u++; break;

            }
        }
        
        //Anzeige der Zählergebnisse
        System.out.println("a: " + a + " mal");
        System.out.println("e: " + e + " mal");
        System.out.println("i: " + i + " mal");
        System.out.println("o: " + o + " mal");
        System.out.println("u: " + u + " mal");


    }
        
}


//        // me
//        // Eingabe eines Satz
//        String satz = Eingabe.readLine("Satz: ");
//        
//        int aCounter = 0;
//        for( int i=0; i<satz.length(); i++ ) 
//        {
//            if(satz.charAt(i) == 'a')            //  || 'i' || 'o' || 'u' || 'A' || 'E' || 'I' || 'O' || 'U' 
//            {
//                aCounter++;
//            }
//            else if(satz.charAt(i) == 'A')            
//            {
//                aCounter++;
//            }
//        } 
//        
//        
//        
//        
//        
//        System.out.println("Es gibt " + aCounter + " Vokale Buchstaben in diese Satz." );
