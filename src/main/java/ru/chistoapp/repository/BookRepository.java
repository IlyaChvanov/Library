package ru.chistoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chistoapp.store.BookEntity;


public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
