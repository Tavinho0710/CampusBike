package com.greenbelly.metraz.dto;


import com.greenbelly.metraz.model.User;

class UserDTO {

    private Long id;
    private String usuario;
    private String senha;

    public UserDTO() {
    }

    public UserDTO(Long id, String usuario, String senha) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public static UserDTO convertOneDTO(User produto) {
        return new UserDTO(
                produto.getId(),
                produto.getUsuario(),
                produto.getSenha()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
