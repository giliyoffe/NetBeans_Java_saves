package personenverwaltung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Klasse Personenliste beschreibt eine ObservableList
 * für Personendaten. 
 * @author GYoffe
 */
public class Personenliste 
{
  private ObservableList<Person> liste;
  public ObservableList<Person> getListe()
  {
      return liste;
  }
  
  /**
   * In der Kontruktor-Methode wird ein Objekt vom Typ
   * einer zu berwachenden ArrayList (ObservbleLit<Person>) für 
   * Personen-Objekte angelegt.
   */
  public Personenliste()
  {
    liste = FXCollections.observableArrayList();
//    testdaten();
//    for ( Person p : liste ) // Testanzeige
//      System.out.println(p.toString());
  }
  
  /**
   * Methode speichert die Personenliste in eine CSV-Datei. Eine Person wird
   * in folgender Zeilenstruktur gespeichert: <br>
   * {@code nummer; nachname; vorname; geburtsdatum}
   * @param file vollständige Pfad und Dateiname zur CSV-Datei
   * @throws IOException falls Daten nicht schreibbar
   */
  public void speichernListeInDatei(File file) throws IOException
  {
      // Datum-Formatierung
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
      // (1) Öffnen Stream
      BufferedWriter stream = new BufferedWriter(new FileWriter(file));
      
      // (2) Daten schreiben
      for(Person p : liste)
      {
          String zeile = p.getNummer() + ";" + 
                         p.getNachname() + ";" +
                         p.getVorname() + ";" + 
                         p.getGeburtstag().format(dtf) + "\r\n";
          stream.write(zeile);
      }
      
      // (3) Scließen Stream
      stream.close();
      
  }
  
  public void einlesenListeAusDatei(File file) throws IOException
  {
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
      // (1) Stream öffnen
      BufferedReader stream = new BufferedReader(new FileReader (file));
      // (2) Daten schreiben
      while(stream.ready())
      {
          String[] zeile = stream.readLine().split(";");
          int nr = Integer.parseInt(zeile[0]);
          LocalDate gd = LocalDate.parse(zeile[3], dtf);
          liste.add(new Person(nr, zeile[2], zeile[1], gd));
      }
      // (3) Scließen Stream
       stream.close();
  }
  
  /* Nur zum testen */  
  private void testdaten()
  {
    liste.add(new Person(105,"Petra", "Meyer", LocalDate.of(1992, 9, 27)));
    liste.add(new Person(125,"Peter", "Maier", LocalDate.of(1989, 12, 18)));
    liste.add(new Person(45,"Maria", "Meyer", LocalDate.of(1998, 4, 19)));
    liste.add(new Person(47,"Mario", "Bros", LocalDate.of(1992, 10, 16)));
    liste.add(new Person(12,"Paul", "Schmidt", LocalDate.of(1990, 7, 26)));
    liste.add(new Person(13,"Patrik", "Schneider", LocalDate.of(1990, 10, 10)));
    liste.add(new Person(33,"Anna", "Meyer", LocalDate.of(1985, 5, 27)));
    liste.add(new Person(48,"Mila", "Müller", LocalDate.of(1992, 7, 25)));
     // -- hier weitere Personen ergänzen ---
  }
}
