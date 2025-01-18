package exercise.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

// BEGIN
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
public class PostDTO {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String title;

    String body;

    List<CommentDTO> comments;
}
// END
