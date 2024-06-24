package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping()
    public List<PostDTO> index() {
        List<PostDTO> result = postRepository.findAll()
                .stream()
                .map(this::postToDTO)
                .toList();
        return result;
    }

    @GetMapping("/{id}")
    public PostDTO show(@PathVariable Long id) {
        var post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        var postDTO = postToDTO(post);
        return postDTO;
    }

    private PostDTO postToDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setBody(post.getBody());
        dto.setTitle(post.getTitle());

        var comments = commentRepository.findByPostId(post.getId())
                .stream()
                .map(this::commentToDTO)
                .toList();
        dto.setComments(comments);

        return dto;
    }

    private CommentDTO commentToDTO(Comment comment) {
        var dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setBody(comment.getBody());

        return dto;
    }
}
// END
//Добавьте контроллер и реализуйте в нем два маршрута для сущности Post. Необходимо реализовать следующие маршруты:
//
//GET /posts — cписок всех постов
//GET /posts/{id} — просмотр конкретного поста
//Каждый пост содержит данные о привязанных к нему комментариях. Пример возвращаемого поста:
//
//{
//    "id": 3,
//    "title": "Post Title 3",
//    "body": "Post Body 3",
//    "comments": [
//        {
//            "id": 6,
//            "body": "Comment Body 6"
//        }
//    ]
//}
