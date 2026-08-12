package br.com.orangebak.OrangeBank.Models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Users(@JsonAlias("emailUser") String email,
                    @JsonAlias("passwordUser") String password) {
}
