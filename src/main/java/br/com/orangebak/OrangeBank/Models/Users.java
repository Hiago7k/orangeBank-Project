package br.com.orangebak.OrangeBank.Models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Users(@JsonAlias("userEmail") String email,
                    @JsonAlias("userPassword") String password) {
}
