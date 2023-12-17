package simulacro.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import simulacro.domain.*;
import simulacro.model.*;

@Mapper
public interface DtoMapper {

    Actor toActor(ActorDTO source);

    ActorDTO toActorDTO(Actor source);
    
    Branch toBranch(BranchDTO source);
    
    BranchDTO toBranchDTO(Branch source);

    Combo toCombo(ComboDTO source);

    ComboDTO toComboDTO(Combo source);

    Director toDirector(DirectorDTO source);

    DirectorDTO toDirectorDTO(Director source);

    Function toFunction(FunctionDTO source);

    FunctionDTO toFunctionDTO(Function source);

    Movie toMovie(MovieDTO source);

    MovieDTO toMovieDTO(Movie source);

    Room toRoom(RoomDTO source);

    RoomDTO toRoomDTO(Room source);

    Seat toSeat(SeatDTO source);

    SeatDTO toSeatDTO(Seat source);

    Ticket toTicket(TicketDTO source);

    TicketDTO toTicketDTO(Ticket source);

    List<Actor> toActorsList(List<ActorDTO> source);

    List<Seat> toSeatsList(List<SeatDTO> source);
    
}
