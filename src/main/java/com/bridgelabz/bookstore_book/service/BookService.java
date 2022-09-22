package com.bridgelabz.bookstore_book.service;

import com.bridgelabz.bookstore_book.dto.BookDTO;
import com.bridgelabz.bookstore_book.email.EmailService;
import com.bridgelabz.bookstore_book.exception.CustomException;
import com.bridgelabz.bookstore_book.model.Book;
import com.bridgelabz.bookstore_book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookService implements IBookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    EmailService emailService;

    public Book insertBook(String token, BookDTO bookDTO) {
            Book book =  bookRepository.save(new Book(bookDTO));
            return book;
    }

    public List<Book> getAllBooks() {
        if (!bookRepository.findAll().isEmpty()) {
            return bookRepository.findAll();
        } else throw new CustomException("Books Table is Empty!");
    }
    public List<Book> sortBooksAscending() {
        if (!bookRepository.findAll().isEmpty()) {
            return bookRepository.sortBooksAscending();
        } else throw new CustomException("Books Table is Empty!");
    }

    public List<Book> sortBooksDescending() {
        if (!bookRepository.findAll().isEmpty()) {
            return bookRepository.sortBooksDescending();
        } else throw new CustomException("Books Table is Empty!");
    }

    public Book getBookById(String token, Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new CustomException("Books id " + bookId + " not found!"));
    }

    public String deleteBookById(String token, Long bookId) {

        bookRepository.findById(bookId).orElseThrow(() -> new CustomException("Books id " + bookId + " not found!"));
            bookRepository.deleteById(bookId);
            return "Book id: " + bookId;
    }

    public Book updateBookById(String token, Long bookId, BookDTO bookDTO) {
        bookRepository.findById(bookId).orElseThrow(() -> new CustomException("Books id " + bookId + " not found!"));
        Book book = new Book(bookDTO);
        book.setBookId(bookId);
        return bookRepository.save(book);
    }

    public List<Book> getBookByName(String token, String name) {
          if (!bookRepository.findBookByName(name).isEmpty()) {
            return bookRepository.findBookByName(name);
        } else throw new CustomException("Books name " + name + " not found!");
    }

    public Book updateQuantity(String token, long bookId, long quantity) {
        bookRepository.findById(bookId).orElseThrow(() -> new CustomException("Books id " + bookId + " not found!"));
        Book book = bookRepository.findBookById(bookId);
        book.setQuantity(quantity);
        return bookRepository.save(book);
    }
}
