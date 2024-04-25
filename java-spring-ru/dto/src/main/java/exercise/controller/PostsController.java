package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        var result = posts.stream()
                .map(this::postDTO)
                .toList();
        return result;
    }

    @GetMapping("/{id}")
    public PostDTO show(@PathVariable long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        var dto = postDTO(post);
        return dto;
    }

    public PostDTO postDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setBody(post.getBody());
        dto.setTitle(post.getTitle());
        dto.setComments(commentListDTO(post.getId()));
        return dto;
    }

    public List<CommentDTO> commentListDTO(long postId) {
        var comments = commentRepository.findByPostId(postId);
        var commentsListDTO = comments.stream()
                .map(this::commentDTO)
                .collect(Collectors.toList());
        return commentsListDTO;
    }

    public CommentDTO commentDTO (Comment comment) {
        var dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setBody(comment.getBody());
        return dto;
    }

}
// END
