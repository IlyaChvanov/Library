package ru.chistoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chistoapp.store.ReaderEntity;

@Repository
public interface ReaderRepository extends JpaRepository<ReaderEntity, Long> {
}
