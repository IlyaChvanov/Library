package ru.hse.chistoapptestlib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hse.chistoapptestlib.store.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
}
