package simulacro.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO {

    private String name;

    private String lastName;

    private String country;

    private String gender;

    private int age;

    private List<MovieDTO> movies;

}
