package simulacro.domain;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FunctionDTO {

    private RoomDTO room;

    private MovieDTO movie;

    private LocalTime time;

}
