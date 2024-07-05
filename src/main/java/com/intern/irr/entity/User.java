package com.intern.irr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Collection;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name="CPF")
    private String cpf;
    @Column(name="password")
    private String password;

    public User() {
    }

    public User(String cpf, String password) {
        this.cpf = cpf;
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }
    public String getPassword() {
        return password;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
