package com.summer.library.models;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

@Entity
@Table(name = "book")
public class Book {
    // attributes -> book number, name, quantity, author
    // create the attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookID;
    private int bookNumber;
    private String bookName;
    private int bookQuantity;
    private String bookAuthor;

    public Book(){

    }
    public Book(int bookID, String bookName, int bookNumber, String bookAuthor, int bookQuantity) {
        this.bookID = bookID;
        this.bookQuantity = bookQuantity;
        this.bookName = bookName;
        this.bookNumber = bookNumber;
        this.bookAuthor = bookAuthor;
    }

    public int getBookID() {
        return bookID;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int quantity) {
        this.bookQuantity = quantity;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String author) {
        this.bookAuthor = author;
    }

    // behaviour -> increase quantity, decrease quantity
    public void increaseQuantity(){
        this.bookQuantity++;
        System.out.println("need to work in increase");
    }
    public void decreaseQuantity(){
        this.bookQuantity--;
        System.out.println("need to work in decrease");
    }
}
