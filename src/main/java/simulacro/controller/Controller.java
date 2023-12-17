package simulacro.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import simulacro.model.*;
import simulacro.domain.*;
import simulacro.mapper.DtoMapper;

public class Controller {

    private List<Movie> movies;
    private List<Ticket> tickets;
    private List<Room> rooms;
    private List<Function> functions;

    private DtoMapper mapper;

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public MovieDTO addMovie(String title, double duration, String genre, String type, int year, List<ActorDTO> actors, DirectorDTO director) {

        if (getMovieByTitle(title) != null) {
            throw new RuntimeException("Movie already exists");
        }

        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDuration(duration);
        movie.setGenre(genre);
        movie.setType(MovieType.valueOf(type));
        movie.setYear(year);
        movie.setActors(mapper.toActorsList(actors));
        movie.setDirector(mapper.toDirector(director));

        movies.add(movie);

        return mapper.toMovieDTO(movie);
    }

    public FunctionDTO addFunction(MovieDTO movie, RoomDTO room, LocalTime time) {

        Function function = new Function();
        
        function.setMovie(mapper.toMovie(movie));
        function.setRoom(mapper.toRoom(room));
        function.setTime(time);

        functions.add(function);

        return mapper.toFunctionDTO(function);
    }

    private Movie getMovieByTitle(String title) {
        return movies.stream().filter(m -> m.getTitle().equals(title)).findFirst().orElse(null);
    }

    public List<MovieDTO> getMoviesByType(MovieType type) {
    
        List<MovieDTO> moviesByType = new ArrayList<>();

        movies.forEach(m -> {
            if (m.getType().equals(type)) {
                moviesByType.add(mapper.toMovieDTO(m));
            }
        });

        return moviesByType;
    }

    public List<FunctionDTO> getMovieFunctions(MovieDTO movie) {

        List<FunctionDTO> movieFunctions = new ArrayList<>();

        functions.forEach(f -> {
            if (f.getMovie().equals(mapper.toMovie(movie))) {
                movieFunctions.add(mapper.toFunctionDTO(f));
            }
        });

        return movieFunctions;
    }

    public TicketDTO buyTicket(MovieDTO movie, FunctionDTO function, List<SeatDTO> seats) {

        Ticket ticket = new Ticket();
        ticket.setDate(LocalDate.now());
        ticket.setFunction(mapper.toFunction(function));
        ticket.setSeats(mapper.toSeatsList(seats));

        blockSeats(mapper.toSeatsList(seats));

        ticket.setTotalPrice(function.getMovie().getType().getPrice());

        DayOfWeek day = LocalDate.now().getDayOfWeek();
        if (DayOfWeek.MONDAY.equals(day) || DayOfWeek.TUESDAY.equals(day) || DayOfWeek.WEDNESDAY.equals(day)) {
            ticket.setDiscount(0.5);
            ticket.setFinalPrice(ticket.getTotalPrice() * ticket.getDiscount());
        }

        tickets.add(ticket);

        return mapper.toTicketDTO(ticket);
    }

    public List<SeatDTO> getAvailableSeats(RoomDTO room) {

        List<SeatDTO> availableSeats = new ArrayList<>();

        mapper.toRoom(room).getSeats().forEach(s -> {
            if (s.isAvailable()) {
                availableSeats.add(mapper.toSeatDTO(s));
            }
        });

        return availableSeats;
    }

    private void blockSeats(List<Seat> seats) {
        seats.forEach(s -> {
            s.setAvailable(false);
        });
    }

    public RoomDTO createRoom(int number, List<SeatDTO> seats) {
        Room room = new Room(number, mapper.toSeatsList(seats));
        rooms.add(room);
        return mapper.toRoomDTO(room);
    }

}
