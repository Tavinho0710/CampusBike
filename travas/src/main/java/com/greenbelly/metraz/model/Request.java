package com.greenbelly.metraz.model;

public class Request {

    public Request(Long idUser, Long idTrava) {
        this.idUser = idUser;
        this.idTrava = idTrava;
    }

    private Long idUser;

    private Long idTrava;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdTrava() {
        return idTrava;
    }

    public void setIdTrava(Long idTrava) {
        this.idTrava = idTrava;
    }
}
