package ru.chistoapp.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.chistoapp.api.dto.TransactionDto;
import ru.chistoapp.api.factory.TransactionDtoFactory;
import ru.chistoapp.repository.BookRepository;
import ru.chistoapp.repository.ReaderRepository;
import ru.chistoapp.repository.TransactionRepository;
import ru.chistoapp.store.BookEntity;
import ru.chistoapp.store.ReaderEntity;
import ru.chistoapp.store.TransactionEntity;
import ru.chistoapp.store.TransactionType;


@AllArgsConstructor
@RestController
@Transactional
public class TransactionController {

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionDtoFactory transactionDtoFactory;

    private final String TRANSACTION = "api/transactions";

    @PostMapping(TRANSACTION)
    @Operation(summary = "Transaction",
            description = "Allows the reader to take or return the book",
            parameters = {@Parameter(name = "transaction_type",
                    description = "Type of transaction (TAKE or RETURN)", required = true)}
    )
    public TransactionDto transaction(@RequestParam(value = "book_id") Long bookId,
                                      @RequestParam(value = "reader_id") Long readerId,
                                      @RequestParam(value = "transaction_type") String transactionType) {

        BookEntity book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book does not exist"));

        ReaderEntity reader = readerRepository.findById(readerId)
                .orElseThrow(() -> new RuntimeException("Reader does not exist"));

        TransactionEntity transaction = new TransactionEntity();
        transaction.setBook(book);
        transaction.setClient(reader);

        if ("TAKE".equalsIgnoreCase(transactionType)) {
            transaction.setTransactionType(TransactionType.TAKE);
        } else if ("RETURN".equalsIgnoreCase(transactionType)) {
            transaction.setTransactionType(TransactionType.RETURN);
        } else {
            throw new RuntimeException("Invalid transaction type");
        }

        transactionRepository.save(transaction);

        return transactionDtoFactory.createTransactionDto(transaction);
    }
}
