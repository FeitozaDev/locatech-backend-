package br.com.fiap.locatech.locatech.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AluguelRequestDTO(

        @Schema(description = "Id da pessoa que está alugando o veículo")

        @NotNull (message = " o Id da pessoa não pode ser Nulo.")
        Long pessoaId,

        @NotNull (message = " o Id do veiculo não pode ser Nulo.")
        Long veiculoId,

        LocalDate dataInicio,
        LocalDate dataFim) {
}
