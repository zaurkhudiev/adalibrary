package com.ada.adalibrary.services;

import com.ada.adalibrary.domain.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class BookService {

    public List<Book> getBooks(){
        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("1","1984","Novel","George Orwell"));
        listOfBooks.add(new Book("2","Crime and Punishment","Novel","Fyodor Dostoyevski"));
        listOfBooks.add(new Book("3","The Stranger","Novel","Albert Camus"));
        listOfBooks.add(new Book("4","The Trial","Novel","Franz Kafka"));


        return listOfBooks;

    }

    public Book getBookByName(String name){
        Predicate<Book> byName = p -> p.getName().equals(name);
        return filterBooks(byName);

    }
    private Book filterBooks(Predicate<Book> st){
        return  getBooks().stream().filter(st).findFirst().orElse(null);

    }
    public Book addBook(Book newBook){
        newBook.setId("5");
        return newBook;

    }
}
