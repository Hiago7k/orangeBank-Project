package br.com.orangebak.OrangeBank.Models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Users( String email,
                     String password) {
}
