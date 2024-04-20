package com.arthursoares.goMarket.dto.ClienteDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientePostPutRequestDTO {

        @JsonProperty("nome")
        @NotBlank(message = "Nome obrigatorio")
        private String nome;

        @JsonProperty("endereco")
        @NotBlank(message = "Endereco obrigatorio")
        private String endereco;

        @JsonProperty("email")
        @NotBlank(message = "Email obrigatorio")
        private String email;

        @JsonProperty("senha")
        @NotBlank(message = "Senha obrigatorio")
        private String senha;
}
