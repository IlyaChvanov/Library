package ru.hse.chistoapptestlib.store;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Operation operation;

    private LocalDateTime dateAndTime;

    @ManyToOne
    private ReaderEntity client;

    @ManyToOne
    private BookEntity book;
}

enum Operation {
    TAKE,
    RETURN
}