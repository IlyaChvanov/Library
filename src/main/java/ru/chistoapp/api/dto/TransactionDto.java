package ru.chistoapp.api.dto;

import lombok.Builder;
import lombok.Data;
import ru.chistoapp.store.TransactionType;

import java.time.LocalDateTime;

@Data
@Builder
public class TransactionDto {
    private Long id;

    private TransactionType transactionType;

    private LocalDateTime dateAndTime;

    private ReaderDto client;

    private LightBookDto book;
}
