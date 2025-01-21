package ru.chistoapp.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@Schema(description = "Light version of BookDto without Author list")
public class LightBookDto {
    private Long Id;

    private String title;

    private LocalDateTime publishedDate;
}
