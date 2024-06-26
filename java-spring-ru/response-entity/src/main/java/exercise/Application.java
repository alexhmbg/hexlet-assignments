package exercise;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> index() {
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(posts.size()))
                .body(posts);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> show(@PathVariable String id) {
        Optional<Post> maybePost = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return ResponseEntity.of(maybePost);
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> create(@RequestBody Post post) {
        posts.add(post);
        URI location = URI.create("/posts");
        return ResponseEntity.created(location).body(post);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> update(@PathVariable String id, @RequestBody Post data) {
        Optional<Post> maybePost = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        var status = HttpStatus.NO_CONTENT;
        if (maybePost.isPresent()) {
            Post post = maybePost.get();
            post.setTitle(data.getTitle());
            post.setId(data.getId());
            post.setBody(data.getBody());
            status = HttpStatus.OK;
        }
        return ResponseEntity.status(status).body(data);
    }

    // Реализуйте полный CRUD сущности Post по аналогии с тем, как мы делали это в в прошлом уроке.
    // На этот раз вам необходимо реализовать маршруты с использованием ResponseEntity и с помощью него модифицировать статусы ответов и заголовки:
    //GET /posts — список всех постов. Должен возвращаться статус 200 и заголовок X-Total-Count, в котором содержится количество постов
    //GET /posts/{id} – просмотр конкретного поста. Если пост найден, должен возвращаться статус 200, если нет — статус 404
    //POST /posts – создание нового поста. Должен возвращаться статус 201
    //PUT /posts/{id} – Обновление поста. Должен возвращаться статус 200. Если пост уже не существует, то должен возвращаться 204
    // END

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
}
