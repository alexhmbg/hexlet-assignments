package exercise.controller;

import java.util.List;

import exercise.dto.*;
import exercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    // BEGIN
    @GetMapping()
    public List<BookDTO> index() {
        var books = bookService.getAll();
        return books;
    }

    @GetMapping("/{id}")
    public BookDTO show(@PathVariable Long id) {
        var book = bookService.findById(id);
        return book;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@RequestBody BookCreateDTO data) {
        var book = bookService.create(data);
        return book;
    }

    @PutMapping("/{id}")
    public BookDTO update(@RequestBody BookUpdateDTO data, @PathVariable Long id) {
        var book = bookService.update(data, id);
        return book;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
    // END
}
