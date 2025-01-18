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
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "/posts")
    public List<PostDTO> index() {
        return postRepository.findAll().stream().
                map(this::postDTO).toList();
    }

    @GetMapping(path = "/posts/{id}")
    public PostDTO show(@PathVariable Long id) {
        var post = postRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found."));
        return postDTO(post);
    }

    private PostDTO postDTO(Post post) {
        var result = new PostDTO();
        result.setId(post.getId());
        result.setTitle(post.getTitle());
        result.setBody(post.getBody());
        var listComments = commentRepository.findAll().stream()
                .filter(comment -> comment.getPostId() == post.getId())
                .map(this::commentDTO).toList();
        result.setComments(listComments);
        return result;
    }

    private CommentDTO commentDTO(Comment comment) {
        var result = new CommentDTO();
        result.setId(comment.getId());
        result.setBody(comment.getBody());
        return result;
    }
}
// END
