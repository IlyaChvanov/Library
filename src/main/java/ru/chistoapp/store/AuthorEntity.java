package ru.chistoapp.store;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private LocalDate birthDate;

    @ManyToMany
    @JoinTable(
            name = "author_book"
            , joinColumns = @JoinColumn(name = "author_id")
            , inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<BookEntity> books;

}
