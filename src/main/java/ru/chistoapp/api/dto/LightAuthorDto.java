package ru.chistoapp.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@Schema(description = "Light version of AuthorDto without book list")
public class LightAuthorDto {
    private Long Id;

    private String name;

    private String surname;

    private LocalDate birthDate;
}

