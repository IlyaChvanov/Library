package ru.hse.chistoapptestlib.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class BookDto {
    private Long id;

    private String title;

    private List<LightAuthorDto> authors;

    private LocalDateTime publishedDate;
}
