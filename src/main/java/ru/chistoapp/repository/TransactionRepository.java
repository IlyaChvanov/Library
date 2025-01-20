package ru.chistoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chistoapp.store.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
