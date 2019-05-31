package pl.biblioteka.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Ksiazki")
@Table
public class Book  {

    @Id
    @Column(name = "id_ksiazka")
    private int id;
    @Column(name = "tytul")
    private String tytul;
    @Column(name = "isbn")
    private String ISBN;
    @Column(name = "kategoria")
    private String kategoria;
    @Column(name = "opis")
    private String opis;
    @Column(name = "autor")
    private String autor;
    @Column(name = "wydawnictwo")
    private String wydawnictwo;
    @Column(name = "rok_wydania")
    private Integer rokWydania;
    @Column(name = "status")
    private String status;

/*    boolean borrowed;*/

    public Book() {

    }
/*    public String getTitle(){
        return tytul;
    }

    public boolean isBorrowing (){
        return borrowed;
    }*/


    public Book(int id, String tytul, String ISBN, String kategoria, String opis, String autor,
                String wydawnictwo, Integer rokWydania, String status) {
        this.id = id;
        this.tytul = tytul;
        this.ISBN = ISBN;
        this.kategoria = kategoria;
        this.opis = opis;
        this.autor = autor;
        this.wydawnictwo = wydawnictwo;
        this.rokWydania = rokWydania;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getWydawnictwo() {
        return wydawnictwo;
    }

    public void setWydawnictwo(String wydawnictwo) {
        this.wydawnictwo = wydawnictwo;
    }

    public Integer getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(Integer rokWydania) {
        this.rokWydania = rokWydania;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(tytul, book.tytul) &&
                Objects.equals(ISBN, book.ISBN) &&
                Objects.equals(kategoria, book.kategoria) &&
                Objects.equals(opis, book.opis) &&
                Objects.equals(autor, book.autor) &&
                Objects.equals(wydawnictwo, book.wydawnictwo) &&
                Objects.equals(rokWydania, book.rokWydania) &&
                Objects.equals(status, book.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tytul, ISBN, kategoria, opis, autor, wydawnictwo, rokWydania, status);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", tytul='" + tytul + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", kategoria='" + kategoria + '\'' +
                ", opis='" + opis + '\'' +
                ", autor='" + autor + '\'' +
                ", wydawnictwo='" + wydawnictwo + '\'' +
                ", rokWydania=" + rokWydania +
                ", status=" + status +
                '}';
    }
}

