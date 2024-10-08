package com.diel.dev.loans_challenge.loans;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

record CustomerRequest(
        @NotNull @CPF String cpf,
        @NotBlank @Size(min = 3) String name,
        @NotNull @Range(min = 18L, max = 120L) Long age,
        @NotNull @DecimalMin(value = "1400.00") BigDecimal income,
        @NotBlank @Size(min = 2, max = 2) String location
) {
}
