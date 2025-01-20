package ru.chistoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chistoapp.store.ReaderEntity;

public interface ReaderRepository extends JpaRepository<ReaderEntity, Long> {
}
