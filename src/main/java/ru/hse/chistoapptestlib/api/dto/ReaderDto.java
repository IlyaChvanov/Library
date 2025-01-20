package ru.hse.chistoapptestlib.api.dto;

import lombok.Builder;
import lombok.Data;
import ru.hse.chistoapptestlib.store.Gender;

import java.time.LocalDate;

@Data
@Builder
public class ReaderDto {
    private Long id;

    private String phoneNumber;

    private String name;

    private String surname;

    private Gender gender;

    private LocalDate birthDate;
}
