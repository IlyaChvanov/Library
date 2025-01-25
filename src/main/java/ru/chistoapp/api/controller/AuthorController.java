package ru.chistoapp.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.chistoapp.api.dto.AuthorDto;
import ru.chistoapp.api.factory.AuthorDtoFactory;
import ru.chistoapp.repository.TransactionRepository;
import ru.chistoapp.store.AuthorEntity;
import ru.chistoapp.store.BookEntity;
import ru.chistoapp.store.TransactionEntity;
import ru.chistoapp.store.TransactionType;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Transactional
public class AuthorController {

    private final AuthorDtoFactory authorDtoFactory;
    private final TransactionRepository transactionRepository;

    private final String GET_FAMOUS_AUTHOR = "api/authors/famous";

    @GetMapping(GET_FAMOUS_AUTHOR)
    @Operation(summary = "Get the most popular author within a date range",
            description = "Fetches the most popular author based on the transactions within the specified date range.",
            parameters = {
                    @Parameter(name = "start_date",
                            description = "Start date of the range (inclusive). The date should be in 'yyyy-MM-dd' format.",
                            required = true),
                    @Parameter(name = "end_date",
                            description = "End date of the range (inclusive). The date should be in 'yyyy-MM-dd' format.",
                            required = true)
            })
    public AuthorDto getFamousAuthor(@RequestParam(value = "start_date") LocalDate startDate,
                                     @RequestParam(value = "end_date") LocalDate endDate) {

        List<TransactionEntity> transactions = transactionRepository.
                findByDateBetween(startDate.atStartOfDay(), endDate.atTime(23, 59, 59));

        Map<AuthorEntity, Long> authorPopularity = new HashMap<>();

        for (TransactionEntity transaction : transactions) {
            BookEntity book = transaction.getBook();
            List<AuthorEntity> authors = book.getAuthors();

            for (AuthorEntity author : authors) {
                if (transaction.getTransactionType().equals(TransactionType.TAKE)) {
                    authorPopularity.put(author, authorPopularity.getOrDefault(author, 0L) + 1);
                }
            }
        }

        AuthorEntity mostPopularAuthor = authorPopularity.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new RuntimeException("No authors found"));

        return authorDtoFactory.makeAuthorDto(mostPopularAuthor);
    }

}
