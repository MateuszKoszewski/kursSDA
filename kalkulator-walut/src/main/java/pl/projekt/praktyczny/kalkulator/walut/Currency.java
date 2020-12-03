package pl.projekt.praktyczny.kalkulator.walut;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer Id;
    @Column(name = "base")
    private String base;
    @Column(name="toCurrency")
    private String toCurrency;
    @Column(name="rate")
    private double rate;
    @Column(name="date")
    private String date;
}
