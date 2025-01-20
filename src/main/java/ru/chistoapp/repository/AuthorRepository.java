package ru.chistoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chistoapp.store.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
}
