package simulacro.domain;

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
public class TicketDTO {

    private LocalDate date;

    private FunctionDTO function;

    private List<SeatDTO> seats;

    private double totalPrice;

    private double discount;

    private double finalPrice;

}
