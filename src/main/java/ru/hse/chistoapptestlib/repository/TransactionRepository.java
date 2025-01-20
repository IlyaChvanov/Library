package ru.hse.chistoapptestlib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hse.chistoapptestlib.store.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
