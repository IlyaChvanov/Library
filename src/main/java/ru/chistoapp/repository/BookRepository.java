package ru.chistoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chistoapp.store.BookEntity;


@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
