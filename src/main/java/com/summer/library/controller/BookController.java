package com.summer.library.controller;

import com.summer.library.models.Book;
import com.summer.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bookApi")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBook(){
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public Book storeBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteABook(@PathVariable int id){
        bookService.deleteBook(id);
        return "Book deleted";
    }

//    @GetMapping("/book/{bookId}")
//    public Book oneBook(@PathVariable("bookId") int bookID){
//        return bookService.getBookInfo(bookID);
//    }
//
//    @PutMapping("/updateBook")
//    public String updateBook(@RequestParam int bookID, @RequestParam int bookNumber) {
//        bookService.updateBookDetail(bookID, bookNumber);
//        return "Updated";
//    }
//
//    @DeleteMapping("/{bookID}")
//    public String deleteBook(@PathVariable int bookID){
//        if(bookService.deleteBookDetail(bookID)){
//            return "deleted";
//        }
//        else {
//            return "failed to delete";
//        }
//    }
}
