package com.summer.library.models;

import java.util.Scanner;

public class User {
    private int userID;
    private String name;
    private String username;
    private int contact;


    public User(int userID, String name,String username, int contact) {
        this.userID = userID;
        this.name = name;
        this.username = username;
        this.contact = contact;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    //TODO -> check is registered , borrow, return
    public void isRegistered(){
        System.out.println("need to work on checking registered.");
    }

    public void borrowBook(User user, Book book){
        if(book.getBookQuantity() > 0){
            BookRecord record = new BookRecord(user, book);
            book.decreaseQuantity();
        }
        else {
            System.out.println("models.Book not available.");
        }
    }

    public void returnBook(){
        System.out.println("need to work in return");
    }
}
