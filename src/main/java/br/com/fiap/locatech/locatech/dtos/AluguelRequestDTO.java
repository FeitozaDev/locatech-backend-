package br.com.fiap.locatech.locatech.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AluguelRequestDTO(

        @NotNull (message = " o Id da pessoa não pode ser Nulo.")
        Long pessoaId,

        @NotNull (message = " o Id do veiculo não pode ser Nulo.")
        Long veiculoId,

        LocalDate dataInicio,
        LocalDate dataFim) {
}
