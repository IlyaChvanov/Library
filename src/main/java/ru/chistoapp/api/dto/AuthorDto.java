package ru.chistoapp.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class AuthorDto {
    private Long id;

    private String name;

    private String surname;

    private LocalDate birthDate;

    private List<LightBookDto> books;

}
