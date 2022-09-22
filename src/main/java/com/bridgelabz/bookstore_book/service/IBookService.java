package com.bridgelabz.bookstore_book.service;

import com.bridgelabz.bookstore_book.dto.BookDTO;
import com.bridgelabz.bookstore_book.model.Book;

import java.util.List;

public interface IBookService {
    Book insertBook(String token, BookDTO bookDTO);
    List<Book> getAllBooks();
    Book getBookById(String token, Long bookId);
    String deleteBookById(String token, Long bookId);
    Book updateBookById(String token, Long bookId, BookDTO bookDTO);
    List<Book> getBookByName(String token, String name);
    Book updateQuantity(String token, long bookId, long quantity);
    List<Book> sortBooksAscending();
    List<Book> sortBooksDescending();

}
