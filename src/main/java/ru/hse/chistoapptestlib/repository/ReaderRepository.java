package ru.hse.chistoapptestlib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hse.chistoapptestlib.store.ReaderEntity;

public interface ReaderRepository extends JpaRepository<ReaderEntity, Long> {
}
