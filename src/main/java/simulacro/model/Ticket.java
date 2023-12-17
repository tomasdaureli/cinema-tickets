package simulacro.model;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    private LocalDate date;

    private Function function;

    private List<Seat> seats;

    private double totalPrice;

    private double discount;

    private double finalPrice;

}
