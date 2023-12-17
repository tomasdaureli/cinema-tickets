package simulacro.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private String title;
    
    private int year;

    private MovieType type;
    
    private String genre;
    
    private double duration;
    
    private List<Actor> actors;
    
    private Director director;

}
