/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrzeugverwaltung;

/**
 *
 * @author GYoffe
 */
public class FahrzeugverwaltungTest 
{
    public static void main(String[] args) 
    {
        // Definition von Lkw-Objekten
        Lkw lkw1 = new Lkw();
        lkw1.setKennzeichen("B-BI3456");
        lkw1.setNutzlast(2000);
        lkw1.setKmStand(34789);
        System.out.println(lkw1);
        
        Lkw lkw2 = new Lkw();
        lkw2.setKennzeichen("B-A6287");
        lkw2.setNutzlast(1500);
        lkw2.setKmStand(134678);
        System.out.println(lkw2);
        
        // Definition von Pkw-Objekten
        Pkw pkw1 = new Pkw();
        pkw1.setKennzeichen("B-MW65");
        pkw1.setKmStand(56783);
        System.out.println(pkw1);
        
        Pkw pkw2 = new Pkw();
        pkw2.setKennzeichen("B-AR39");
        pkw2.setKmStand(17567);
        System.out.println(pkw2);
        
        
        // Vermietung von LKW B-A6287
        lkw2.setVermitet(true);
        System.out.println(lkw2);
        // Rückgabe von LKW B-A6287
        double preis = lkw2.berechnenMietpreis(14, 14560);
        lkw2.setVermitet(false);
        System.out.println(lkw2 + "Preis: " + preis);
        
        // Vermietung von PKW B-AR39
        lkw2.setVermitet(true);
        System.out.println(pkw2);
        // Rückgabe von PKW B-AR39
        preis = pkw2.berechnenMietpreis(2, 845);
        lkw2.setVermitet(false);
        System.out.println(pkw2 + "Preis: " + preis);

       
    }
}
