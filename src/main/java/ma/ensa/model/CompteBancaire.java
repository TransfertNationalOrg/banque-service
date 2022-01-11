package ma.ensa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class CompteBancaire {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

    protected Long RIB;
    protected double solde;
    protected Date date;
    @ManyToOne
    @JoinColumn(name = "client_id")
    protected Client client;
}
