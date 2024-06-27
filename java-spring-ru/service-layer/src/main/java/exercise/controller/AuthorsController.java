package exercise.controller;

import exercise.dto.AuthorDTO;
import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    // BEGIN
    @GetMapping()
    public List<AuthorDTO> index() {
        var authors = authorService.getAll();
        return authors;
    }

    @GetMapping("/{id}")
    public AuthorDTO show(@PathVariable Long id) {
        var author = authorService.findById(id);
        return author;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDTO create(@RequestBody AuthorCreateDTO data) {
        var author = authorService.create(data);
        return author;
    }

    @PutMapping("/{id}")
    public AuthorDTO update(@RequestBody AuthorUpdateDTO data, @PathVariable Long id) {
        var author = authorService.update(data, id);
        return author;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }
    // END
}
//    Реализуйте полный CRUD сущности автора.
//    Создайте обработчики для просмотра списка всех авторов и конкретного автора, создания, обновления и удаления автора:
//
//    * *GET /authors* – просмотр списка всех авторов
//    * *GET /authors/{id}* – просмотр конкретного автора
//    * *POST /authors* – добавление нового автора
//    * *PUT /authors/{id}* – редактирование автора. При редактировании мы должны иметь возможность поменять имя и фамилию
//    * *DELETE /authors* – удаление автора