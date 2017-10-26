package personenverwaltung;
// PROJEKT FÜR IHK

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Klasse Person beschreibt ein Person-Objekt
 * Eine Person wird mit folgenden Eigenschaften beschrieben
 * <ul>
 * <li> Personennummer</li>
 * <li> Vorname </li>
 * <li> Nachname </li>
 * <li> Geburtsdatum </li>
 * </ul>
 * Diese Eigenschaften werden als SimpleIntegerProperty-Objekte definiert.
 * Damit können diese Objekte in Observer-Listen geführt werden 
 * und mit anderen Eigenschaften anderer Objekte verbunden werden.
 * (siehe Konzept "Property nd Binding")
 * @author GYoffe
 */
public class Person 
{
  // ----- Personennummer -----
  private SimpleIntegerProperty nummer;
  /**
   * Methode gibt die Objekt-Varible der Personennummer 
   * als einfache int-Wert zurück.
   * @return Personennummer - int.
   */
  public int getNummer()
  {
    return this.nummer.get();
  }
  /**
   * Methode setzt die Objekt-Variable der Personennummer.
   * @param nummer Personennummer - int
   */
  public void setNummer(int nummer)
  {
    this.nummer.set(nummer);
  }
  /**
   * Methode liefert die Objekt-Variable der Personennummer
   * als einfache Integer Eigenschaft- SimpleIntegerProperty.
   * Mittels SimpleIntegerProperty kann das
   * @return Personennummer - SimpleIntegerProperty
   */
  public SimpleIntegerProperty nummerProperty()
  {
    return this.nummer;
  }
  // ----- Vorname -----
  private SimpleStringProperty vorname;
  public String getVorname()
  {
    return this.vorname.get();
  }
  public void setVorname(String vorname)
  {
    this.vorname.set(vorname);
  }
  public SimpleStringProperty vornameProperty()
  {
    return this.vorname;
  }
  // ----- Nachname -----
  private SimpleStringProperty nachname;
  public String getNachname()
  {
    return this.nachname.get();
  }
  public void setNachname(String nachname)
  {
    this.nachname.set(nachname);
  }
  public SimpleStringProperty nachnameProperty()
  {
    return this.nachname;
  }
  // ----- Geburtstag -----
  private SimpleObjectProperty<LocalDate> geburtstag;
  public LocalDate getGeburtstag()
  {
    return this.geburtstag.get();
  }
  public void setGeburtstag(LocalDate geburtstag)
  {
    this.geburtstag.set(geburtstag);
  }
  public SimpleObjectProperty<LocalDate> geburtstagProperty()
  {
    return geburtstag;
  }

  public Person()
  {
    this.nummer = new SimpleIntegerProperty();
    this.vorname = new SimpleStringProperty();
    this.nachname = new SimpleStringProperty();
    this.geburtstag = new SimpleObjectProperty<>();
  }
  
  public Person(int nummer, String vorname, String nachname, 
                LocalDate geburtstag)
  {
    this.nummer = new SimpleIntegerProperty(nummer);
    this.vorname = new SimpleStringProperty(vorname);
    this.nachname = new SimpleStringProperty(nachname);
    this.geburtstag = new SimpleObjectProperty<>(geburtstag);
  }
  
  private DateTimeFormatter dtf = 
                    DateTimeFormatter.ofPattern("dd.MM.yyyy");
  
  @Override
  public String toString()
  {
    return getNummer() + ": " 
           + getVorname() + " " + getNachname() 
           + " (" + dtf.format(getGeburtstag()) + ")";
  }
}
