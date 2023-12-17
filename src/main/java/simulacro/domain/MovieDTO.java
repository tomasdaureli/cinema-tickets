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
public class MovieDTO {

    private String title;
    
    private int year;

    private MovieTypeDTO type;
    
    private String genre;
    
    private double duration;
    
    private List<ActorDTO> actors;
    
    private DirectorDTO director;

}
