package ru.chistoapp.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.chistoapp.api.dto.ReaderDto;
import ru.chistoapp.api.factory.ReaderDtoFactory;
import ru.chistoapp.repository.TransactionRepository;
import ru.chistoapp.store.ReaderEntity;
import ru.chistoapp.store.TransactionEntity;
import ru.chistoapp.store.TransactionType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@Transactional
public class ReaderController {

    private final TransactionRepository transactionRepository;
    private final ReaderDtoFactory readerDtoFactory;

    private final String GET_MOST_ACTIVE_READER = "/api/readers/most_active";
    private final String GET_READERS_SORTED_BY_UNRETURNED_BOOKS = "api/readers/sorted_by_unreturned_books";


    @GetMapping(GET_MOST_ACTIVE_READER)
    @Operation(summary = "Get the most active client", description = "Returns the client who has taken the most books.")
    public ReaderDto getMostActiveClient() {

        List<TransactionEntity> transactions = transactionRepository.findAll();
        Map<ReaderEntity, Long> clientActivity = new HashMap<>();
        for (TransactionEntity transaction : transactions) {
            if (transaction.getTransactionType().equals(TransactionType.TAKE)) {
                ReaderEntity client = transaction.getClient();
                clientActivity.put(client, clientActivity.getOrDefault(client, 0L) + 1);
            }
        }
        ReaderEntity mostActiveClient = clientActivity.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new RuntimeException("No clients found"));

        return readerDtoFactory.createReaderDto(mostActiveClient);
    }

    @GetMapping(GET_READERS_SORTED_BY_UNRETURNED_BOOKS)
    @Operation(summary = "Get readers sorted by the number of unreturned books ",
            description = "Returns a list of all readers sorted by the number of unreturned books in descending order.")
    public List<ReaderDto> getReadersSortedByUnreturnedBooks() {

        List<TransactionEntity> transactions = transactionRepository.findAll();
        Map<ReaderEntity, Long> unreturnedBooksCount = new HashMap<>();
        for (TransactionEntity transaction : transactions) {
            if (transaction.getTransactionType().equals(TransactionType.TAKE)) {
                ReaderEntity client = transaction.getClient();
                unreturnedBooksCount.put(client, unreturnedBooksCount.getOrDefault(client, 0L) + 1);
            } else if (transaction.getTransactionType().equals(TransactionType.RETURN)) {
                ReaderEntity client = transaction.getClient();
                unreturnedBooksCount.put(client, unreturnedBooksCount.getOrDefault(client, 0L) - 1);
            }
        }
        return unreturnedBooksCount.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .map(Map.Entry::getKey)
                .map(readerDtoFactory::createReaderDto)
                .collect(Collectors.toList());
    }
}
