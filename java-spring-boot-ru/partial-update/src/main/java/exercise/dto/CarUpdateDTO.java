package exercise.dto;

import org.openapitools.jackson.nullable.JsonNullable;

import lombok.Getter;
import lombok.Setter;

// BEGIN
@Getter
@Setter
public class CarUpdateDTO {

    JsonNullable<String> model;

    JsonNullable<String> manufacturer;

    JsonNullable<Integer> enginePower;
}
// END
