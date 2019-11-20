package com.cadastro.desafio.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class CalcularIdadeUtils {

    public static int calcularIdade(Date dataNascimento) {

        if ((dataNascimento != null)) {
            LocalDate dataConvertida = Instant.ofEpochMilli(dataNascimento.getTime())
                                        .atZone(ZoneId.systemDefault())
                                        .toLocalDate();
            return Period.between(dataConvertida, LocalDate.now()).getYears();
        } else {
            return 0;
        }

    }

}