package ru.hse.chistoapptestlib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hse.chistoapptestlib.store.BookEntity;


public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
