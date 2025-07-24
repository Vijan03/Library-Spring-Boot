package com.summer.library.dao;

import com.summer.library.models.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {
    private Connection conn;
    public boolean  insertBook(Book book){
        try {
            Connection conn = com.summer.library.dao.DatabaseConnection.connect();
            String query = "INSERT INTO book(bookNumber, bookName, bookAuthor, bookQuantity) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, book.getBookNumber());
            ps.setString(2, book.getBookName());
            ps.setString(3, book.getBookAuthor());
            ps.setInt(4, book.getBookQuantity());

            if (ps.executeUpdate() > 0){
                return true;
            }
            else {
                return false;
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Book> getBook(){
        ArrayList<Book> bookList = new ArrayList<>();
        try{
            Connection conn = com.summer.library.dao.DatabaseConnection.connect();
            String query = "SELECT  bookID, bookNumber, bookName, bookAuthor, bookQuantity FROM book";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet bookSet = ps.executeQuery();  //
            while(bookSet.next()){
                Book book = new Book(
                        bookSet.getInt("bookID"),
                        bookSet.getString("bookName"),
                        bookSet.getInt("bookNumber"),
                        bookSet.getString("bookAuthor"),
                        bookSet.getInt("bookQuantity"));
                bookList.add(book);
            }
            return bookList;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateBookDetail(int bookid, int bookNumber) {
            try {
                Connection conn = com.summer.library.dao.DatabaseConnection.connect();
                String query = "UPDATE book SET bookNumber = ? WHERE bookID = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1,bookNumber);
                ps.setInt(2, bookid);
                if(ps.executeUpdate() > 0){
                    System.out.println("book updated");
                }else{
                    System.out.println("Failed to update");
                }
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        return false;
    }

    public boolean deleteBookDetail(int bookid){
        try {
            Connection conn = com.summer.library.dao.DatabaseConnection.connect();
            String query = "DELETE FROM book WHERE bookID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,bookid);
            if(ps.executeUpdate() > 0){
                System.out.println("book deleted");
                return true;
            }else{
                System.out.println("Failed to delete");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public Book getBookInfo(int bookID){
        Book book = null;
        try{
            Connection conn = com.summer.library.dao.DatabaseConnection.connect();
            String query = "SELECT * FROM book WHERE bookID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, bookID);
            ResultSet bookSet = ps.executeQuery();
            while (bookSet.next()){
                book = new Book(
                        bookSet.getInt("bookID"),
                        bookSet.getString("bookName"),
                        bookSet.getInt("bookNumber"),
                        bookSet.getString("bookAuthor"),
                        bookSet.getInt("bookQuantity"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

}
