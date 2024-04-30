package it.epicode.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.StringJoiner;

@Entity // promuove la classe a "classe le cui istanze sono salvabili su una tabella"
@Table(name = "persone") // specifica il nome della tabella sulla quale salvare i dati di tipo persona
public class Persona {
    @Id // identifica la chiave della tabella
    private long id;
    private String nome;
    private String cognome;
    private String telefono;

    public Persona() {
    }

    public Persona(long id, String nome, String cognome, String telefono) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Persona.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nome='" + nome + "'")
                .add("cognome='" + cognome + "'")
                .add("telefono='" + telefono + "'")
                .toString();
    }
}
