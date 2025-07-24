package com.summer.library.service;

import com.summer.library.models.Book;
import com.summer.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }

    public Book getBookById(int id){
        return bookRepository.findById(id).orElse(null);
    }
}
