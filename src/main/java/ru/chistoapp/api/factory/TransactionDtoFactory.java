package ru.chistoapp.api.factory;

import lombok.RequiredArgsConstructor;
import ru.chistoapp.api.dto.TransactionDto;
import ru.chistoapp.store.TransactionEntity;

@RequiredArgsConstructor
public class TransactionDtoFactory {
    private final ReaderDtoFactory readerDtoFactory;

    private final LightBookDtoFactory lightBookDtoFactory;

    public TransactionDto createTransactionDto(TransactionEntity transactionEntity) {
        return TransactionDto.builder()
                .id(transactionEntity.getId())
                .operation(transactionEntity.getOperation())
                .dateAndTime(transactionEntity.getDateAndTime())
                .client(
                        readerDtoFactory.createReaderDto(transactionEntity.getClient())
                )
                .book(
                        lightBookDtoFactory.makeLightBookDto(transactionEntity.getBook())
                )
                .build();

    }
}
