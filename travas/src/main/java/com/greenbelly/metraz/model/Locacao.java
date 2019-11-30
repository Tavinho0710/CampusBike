package com.greenbelly.metraz.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LOCACOES")
public class Locacao implements Serializable {

    public Locacao() {
    }

    public Locacao(Long id, User usuario, Bike bike, Trava travaRetirada, Trava travaDevolucao, Date dataLocacao, Date dataDevolucao, @NotNull Boolean emAberto) {
        this.id = id;
        this.usuario = usuario;
        this.bike = bike;
        this.travaRetirada = travaRetirada;
        this.travaDevolucao = travaDevolucao;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.emAberto = emAberto;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotNull(message = "Informe o usuario.")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "I_USUARIO")
    private User usuario;

//    @NotNull(message = "Informe a bicicleta.")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "I_BIKE")
    private Bike bike;

//    @NotNull(message = "Informe a travaRetirada.")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "I_TRAVA_RETIRADA")
    private Trava travaRetirada;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "I_TRAVA_DEVOLUCAO")
    private Trava travaDevolucao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_LOCACAO")
    private Date dataLocacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_DEVOLUCAO")
    private Date dataDevolucao;

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @NotNull
    private Boolean emAberto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public Trava getTravaRetirada() {
        return travaRetirada;
    }

    public void setTravaRetirada(Trava travaRetirada) {
        this.travaRetirada = travaRetirada;
    }

    public Trava getTravaDevolucao() {
        return travaDevolucao;
    }

    public void setTravaDevolucao(Trava travaDevolucao) {
        this.travaDevolucao = travaDevolucao;
    }

    public Boolean getEmAberto() {
        return emAberto;
    }

    public void setEmAberto(Boolean emAberto) {
        this.emAberto = emAberto;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", bike=" + bike +
                ", travaRetirada=" + travaRetirada +
                '}';
    }
}
