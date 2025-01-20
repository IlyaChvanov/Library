package ru.hse.chistoapptestlib.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class LightAuthorDto {
    private Long Id;

    private String name;

    private String surname;

    private LocalDateTime birthDate;
}

