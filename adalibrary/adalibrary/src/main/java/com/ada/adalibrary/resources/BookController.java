package com.ada.adalibrary.resources;


import com.ada.adalibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {


    @Autowired
    private BookService bookService;
    @GetMapping("/all")
    public String getBooks(Model model){
        model.addAttribute("books", bookService.getBooks());
        return "book_all";

    }

    @GetMapping("/{bookName}")
    public String getBookById(Model model, @PathVariable("bookName") String bookName){

        model.addAttribute("book", bookService.getBookByName(bookName));
        return "book";

    }

}
