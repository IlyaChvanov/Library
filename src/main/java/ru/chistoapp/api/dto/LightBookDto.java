package ru.chistoapp.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class LightBookDto {
    private Long Id;

    private String title;

    private LocalDateTime publishedDate;
}
