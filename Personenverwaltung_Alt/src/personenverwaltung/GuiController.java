package personenverwaltung;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

/**
 * FXML Controller stellt die Verbindung zwischen FXML-Obeerfläche
 * und der Applikation her. Diese Klasse enthält alle Ereignisroutinen.
 *
 * @author GYoffe
 */
public class GuiController
{
    @FXML private TextField tfNummer;
    @FXML private TextField tfVorname;
    @FXML private TextField tfNachname;
    @FXML private DatePicker dpGeburtsdatum;
    @FXML private Button btnNeu;
    @FXML private Tooltip tipNeu;
    @FXML private Button btnAendern;
    @FXML private Tooltip tipAendern;
    @FXML private Button btnLoeschen;
    @FXML private Tooltip tipLoeschen;
    @FXML private Button btnBeenden;
    @FXML private Tooltip tipBeenden;
    @FXML private Label lblStatus;
    @FXML private TableView<Person> tblPerson;
    @FXML private TableColumn<Person, Integer> colNummer;
    @FXML private TableColumn<Person, String> colVorname;
    @FXML private TableColumn<Person, String> colNachname;
    @FXML private TableColumn<Person, LocalDate> colGeburtsdatum;
    

    // Referenzvariablen zum Aufbau der Verbindungen zwischen den Klassen
    private Personenverwaltung verwaltung;
    private Personenliste liste;
    /**
     * Methode setzt die Referenz zur Personenverwaltung
     * @param verwaltung 
     */
    public void setVerwaltung(Personenverwaltung verwaltung)
    {
        this.verwaltung = verwaltung;
    }

    /**
     * Methode dient zum Setzen der Referemz auf die Personenliste.
     * Außerdem wird die erste Person in der Liste angezeigt und
     * die Liste mit der Tabellenanzeige verbunden.
     * @param liste 
     */
    public void setListe(Personenliste liste)
    {
        this.liste = liste;
        // Verbinden Tabelle mit Liste
        this.tblPerson.setItems(liste.getListe());
        // Falls Liste nicht leer
        if (!liste.getListe().isEmpty())
        {  // Anzeige der ersten Person in Liste
            this.anzeigenPerson(liste.getListe().get(0));
            int anzahl = liste.getListe().size();
            this.lblStatus.setText(anzahl + " Personen in Liste");
            this.tblPerson.getSelectionModel().select(0);
        }
    }
    /**
     * Methode setzt den Statusanzeige
     * @param text String
     */
    public void setStatus(String text)
    {
        lblStatus.setText(text);
    }
    /**
     * Methode dienst zum Person anzeugen
     * @param person Person
     */
    public void anzeigenPerson(Person person)
    {
        if ( person != null )
        {
            tfNummer.setText(Integer.toString(person.getNummer()));
            tfVorname.setText(person.getVorname());
            tfNachname.setText(person.getNachname());
            dpGeburtsdatum.setValue(person.getGeburtstag());
        }
    }
   
    /**
     * Methode initialisiert die Tabelle und verbindet die einzelnen
     * Tabellenspalten mit den Eigenschaftswerten in der Liste.
     * Methode wird beim Erstellen des Controller-Objektes aufgerufen.
     */
    public void initialize()
    {   // Verbinden der Tabellenzellen mit den Wertern in der Liste
        colNummer.setCellValueFactory(cellData
                -> cellData.getValue().nummerProperty().asObject());
        colVorname.setCellValueFactory(cellData
                -> cellData.getValue().vornameProperty());
        colNachname.setCellValueFactory(cellData
                -> cellData.getValue().nachnameProperty());
        colGeburtsdatum.setCellValueFactory(cellData
                -> cellData.getValue().geburtstagProperty());
        // Ereignis: Klick auf Tabellenanzeige -> Anzeige Person
        tblPerson.getSelectionModel().selectedItemProperty()
                .addListener( (observable, oldValue, newValue) 
                    -> anzeigenPerson(newValue));
    }    
    // **** Methoden der Ereignissteuerung (Klick Button) *******
    /**
     * Ereignismethode wird aufgerufen bei dem Klick auf dem Button Neu
     * Methode dienst zum Handlung beim drücken auf dem Neu Knopf
     */
    public void handleNeu() 
    {
        if ( this.zustand == Konstanten.BASIS || this.zustand == Konstanten.LEER)
        {
            this.setZustand(Konstanten.NEU);
        }
        else
        {
            // ---- Eingabeprüfung
            try
            { // Person aus den Eingabefeldern holen und prüfen
                Person person = getEingabPerson(); 
                // Übernahme Person in Liste(am indexposition 0)
                this.liste.getListe().add(0, person);
                this.tblPerson.getSelectionModel().select(person);
                // Auswahl der Person in der Tabelle
                this.setStatus(person.toString()+ " in Liste übernommen!");
                // Änderung an Verwaltung melden
                verwaltung.setGeaendert(true);
                this.setZustand(Konstanten.BASIS);
            }catch(Exception e)
            {
                setStatus(e.getMessage());
            }
        }
    } // Ende handleNeu() 
    /**
     * Ereignismethode wird aufgerufen bei dem Klick auf dem Button Ändern
     * Methode dienst zum Handlung beim drücken auf dem Ändern Knopf
     */
    public void handleAendern()
    {
        if (this.zustand == Konstanten.BASIS)
        {
            this.setZustand(Konstanten.AENDERN);
        } else
        {
            try
            {
                Person person = getEingabPerson(); // Eingabeprüfung
                int index = tblPerson.getSelectionModel().getSelectedIndex();
                // Übernahme in Liste
                this.liste.getListe().set(index, person);
                this.setStatus(person.toString() + " wurde geändert!");
                this.tblPerson.getSelectionModel().select(person);
                // Änderung an Verwaltung melden
                this.verwaltung.setGeaendert(true);
                this.setZustand(Konstanten.BASIS);// f shina po --- ********************
            } catch (Exception e)
            {
                setStatus(e.getMessage());
            }
            if (this.zustand == Konstanten.AENDERN) // f shina po --- *****************
            {
                this.setZustand(Konstanten.BASIS); // f shina po --- *****************
            }
        }
    } // Ende handleAendern()
    /**
     * Ereignismethode wird aufgerufen bei dem Klick auf dem Button Löschen
    * Methode dienst zum Handlung beim drücken auf dem Löschen Knopf
    */
    public void handleLoeschen()
    {
        int index = tblPerson.getSelectionModel().getSelectedIndex();
        Person person = liste.getListe().get(index);
        String text = "Wollen Sie " + person.toString() + " wirklich löschen? ";
        if ( verwaltung.frage("Löschabfrage", text))
        {
            liste.getListe().remove(person);
            verwaltung.setGeaendert(true);
            setStatus(person.toString() + " wurde gelöscht!");
        }
        if ( liste.getListe().isEmpty())
        {
            this.setZustand(Konstanten.LEER);
        }
    } // Ende handleLoeschen()
    /**
     * Ereignismethode wird aufgerufen bei dem Klick auf dem Button Beenden
    * Methode dienst zum Handlung beim drücken auf dem Beenden Knopf
    */
    public void handleBeenden() throws Exception
    {
        if ( this.zustand == Konstanten.NEU || this.zustand == Konstanten.AENDERN )
        {
            this.setStatus("Abbrechen geklickt!");
            // Falls liste nicht leer ist
            if( ! this.liste.getListe().isEmpty())
            {   // ausgewählte Person wieder anzeigen
                int index = tblPerson.getSelectionModel().getSelectedIndex();
                this.anzeigenPerson(liste.getListe().get(index));
                this.setZustand(Konstanten.BASIS);
            }else
            {
                this.setZustand(Konstanten.LEER);
            }
        }
        else if ( this.zustand == Konstanten.BASIS || this.zustand == Konstanten.LEER )
        {
            // Anwendung beenden
            verwaltung.stop();
        }
    } // Ende handleBeenden()
    
    // **** Eingabeprüfung *******
    /**
     * Methode dienst zum Eingaben von einem Person ins dem Tabelle.
     * @return person
     * @throws Exception String
     */
    private Person getEingabPerson() throws Exception
    {
        Person person = new Person();
        // --- Eingabeprüfung Nummer
        String strNr = tfNummer.getText().trim();
        if ( ! strNr.matches("[0-9]+"))  // wenn nicht OK
        {
            tfNummer.selectAll(); // alles markieren
            tfNummer.requestFocus(); // Cursor setzen
            throw new Exception ("Bitte nur ganze Zahlen eingeben!");
        }
        person.setNummer(Integer.parseInt(strNr));
        // --- Eingabeprüfung Nachname
        String strNachname = tfNachname.getText().trim();
        if (strNachname.isEmpty())
        {
            tfNachname.requestFocus();
            throw new Exception ("Bitte einen Nachnamen eingeben!");
        }
        person.setNachname(strNachname);
        // --- Eingabeprüfung Vorname
        String strVorname = tfVorname.getText().trim();
        if (strVorname.isEmpty())
        {
            tfVorname.requestFocus();
            throw new Exception ("Bitte einen Vornamen eingeben!");
        }
        person.setVorname(strVorname);
        // --- Eingabeprüfung Geburtsdatum
        LocalDate gebDate = dpGeburtsdatum.getValue();
        if (gebDate.isAfter(LocalDate.now()) || gebDate.isEqual(LocalDate.now()))
        {
            dpGeburtsdatum.requestFocus();
            throw new Exception ("Bitte ein Geburtstag in der vergangenheit wählen!");
        }
        person.setGeburtstag(gebDate);
        return person;
    }
    
    
    // **** Methoden zum Einstellen der Gui - Zustände ******
    private int zustand = Konstanten.BASIS;
    /**
     * Methode setzt den Zustand der Benutzeroberfläche und stellt alle    *** soll es hier sein ? es ist nicht für setZustand ????   ****
     * Steuerelemente entsprechend ein.
     * @return zustand int-Wert
     */
    public int getZustand()
    {
        return zustand;
    }
    /**
     * Methode setzt den Zustand der Benutzeroberfläche und stellt alle 
     * Steuerelemente entsprechend ein.
     * @param zustand int-Wert
     */
    public void setZustand(int zustand)
    {
        this.zustand = zustand;
        switch(zustand)
        {
            case Konstanten.BASIS:
                this.btnNeu.setDisable(false); // Button aktivieren
                this.btnNeu.setText("Neu");
                this.btnNeu.setTooltip(new Tooltip("Erstelen eines neuen Datensatzes"));
                this.btnAendern.setDisable(false);
                this.btnAendern.setText("Ändern");
                btnAendern.setTooltip(new Tooltip("Ändern des gewählten Datensatzes"));
                this.btnLoeschen.setDisable(false);
                this.btnBeenden.setText("Beenden");
                this.btnBeenden.setTooltip(new Tooltip("Beenden der Anwendung"));
                this.eingabeEnabled(false);
                this.tblPerson.setDisable(false);
                this.btnNeu.requestFocus();
                break;
            case Konstanten.NEU:
                this.btnNeu.setText("Speichern");
                this.btnNeu.setTooltip(new Tooltip("Speichern des Datensatzes"));
                this.btnAendern.setDisable(true);
                this.btnLoeschen.setDisable(true);
                this.btnBeenden.setText("Abbrechen");
                this.btnBeenden.setTooltip(new Tooltip("Abbrechen des Eingabe"));
                this.eingabeEnabled(true);
                this.leerenTextfelder();
                this.tblPerson.setDisable(true);
                break;
            case Konstanten.AENDERN:
                this.btnNeu.setDisable(true);
                this.btnAendern.setText("Speichern");
                this.btnNeu.setTooltip(new Tooltip("Speichern dee Änderung"));
                this.btnLoeschen.setDisable(true);
                this.btnBeenden.setText("Abbrechen");
                btnBeenden.setTooltip(new Tooltip("Abbrechen des Eingabe"));
                this.eingabeEnabled(true);
                this.tblPerson.setDisable(true);
                break;
            case Konstanten.LEER:
                this.btnNeu.setDisable(false);
                this.btnAendern.setDisable(true);
                this.btnLoeschen.setDisable(true);
                this.leerenTextfelder();
                this.eingabeEnabled(false);
                this.tblPerson.setDisable(false);
                this.btnNeu.requestFocus();
        } // Ende switch
    } // Ende Methode setZustand()
    private void leerenTextfelder()
    {
        this.tfNummer.setText("");
        this.tfVorname.setText("");
        this.tfNachname.setText("");
        this.dpGeburtsdatum.setValue(LocalDate.now());
        this.tfNummer.requestFocus(); // Cursor setzen
    }
    /**
     * Methode diesnt zum Felderneingabe 
     * @param bool 
     */
    private void eingabeEnabled(boolean bool)
    {
        this.tfNummer.setEditable(bool);
        this.tfVorname.setEditable(bool);
        this.tfNachname.setEditable(bool);
        this.dpGeburtsdatum.setDisable(! bool);
    }
} // Ende der Klasse GuiController
