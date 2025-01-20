package ru.chistoapp.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class LightAuthorDto {
    private Long Id;

    private String name;

    private String surname;

    private LocalDate birthDate;
}

