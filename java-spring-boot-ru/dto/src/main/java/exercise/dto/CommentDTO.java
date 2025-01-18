package exercise.dto;

import lombok.Getter;
import lombok.Setter;

// BEGIN
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
public class CommentDTO {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String body;

}
// END
