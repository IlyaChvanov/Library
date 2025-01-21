package ru.chistoapp.api.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.chistoapp.api.dto.TransactionDto;
import ru.chistoapp.store.TransactionEntity;

@RequiredArgsConstructor
@Component
public class TransactionDtoFactory {
    private final ReaderDtoFactory readerDtoFactory;

    private final LightBookDtoFactory lightBookDtoFactory;

    public TransactionDto createTransactionDto(TransactionEntity transactionEntity) {
        return TransactionDto.builder()
                .id(transactionEntity.getId())
                .transactionType(transactionEntity.getTransactionType())
                .dateAndTime(transactionEntity.getDate())
                .client(
                        readerDtoFactory.createReaderDto(transactionEntity.getClient())
                )
                .book(
                        lightBookDtoFactory.makeLightBookDto(transactionEntity.getBook())
                )
                .build();

    }
}
