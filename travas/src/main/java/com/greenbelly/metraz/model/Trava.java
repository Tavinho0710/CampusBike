package com.greenbelly.metraz.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TRAVAS")
public class Trava implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numeroTrava;

    private Boolean travaFechada;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "I_BIKE")
    private Bike bike;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroTrava() {
        return numeroTrava;
    }

    public void setNumeroTrava(int numeroTrava) {
        this.numeroTrava = numeroTrava;
    }

    public Boolean getTravaFechada() {
        return travaFechada;
    }

    public void setTravaFechada(Boolean travaFechada) {
        this.travaFechada = travaFechada;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }
}
