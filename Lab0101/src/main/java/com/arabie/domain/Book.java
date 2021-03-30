package com.arabie.domain;

import javax.persistence.*;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "book")
public class Book {
    /**
     *
     */


    @XmlAttribute
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // @Size(min = 6, max = 10, message = "Must be between {min} and {max} characters long")
    @Column(name = "title")
    private String title;

    @Column(name = "total_pages")
    private int totalPAges;

    @Column(name = "rating")
    private double rating;
    // @NotNull
    @Column(name = "type")
    private String type;
        
    @XmlTransient
    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(String title, int totalPAges, double rating, String type) {
        this.title = title;
        this.totalPAges = totalPAges;
        this.rating = rating;
        this.type = type;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalPAges() {
        return totalPAges;
    }

    public void setTotalPAges(int totalPAges) {
        this.totalPAges = totalPAges;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
