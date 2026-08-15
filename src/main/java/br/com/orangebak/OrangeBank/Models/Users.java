package br.com.orangebak.OrangeBank.Models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Users(@JsonAlias({"emailUser", "emailUser2"}) String email,
                    @JsonAlias({"passwordUser", "passwordUser2"}) String password) {
}
