package br.com.orangebak.OrangeBank.Models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Users(@JsonAlias("email") String email,
                    @JsonAlias("psswd") String password) {
}
