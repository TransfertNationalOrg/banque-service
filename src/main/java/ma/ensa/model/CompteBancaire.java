package ma.ensa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class CompteBancaire {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long RIB;
    private double solde;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
