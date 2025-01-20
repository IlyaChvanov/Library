package ru.chistoapp.api.factory;

import lombok.RequiredArgsConstructor;
import ru.chistoapp.api.dto.BookDto;
import ru.chistoapp.store.BookEntity;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BookDtoFactory {
    private final LightAuthorDtoFactory lightAuthorDtoFactory;

    public BookDto createBookDto(BookEntity bookEntity) {
        return BookDto.builder()
                .id(bookEntity.getId())
                .title(bookEntity.getTitle())
                .authors(
                        bookEntity.getAuthors()
                                .stream()
                                .map(lightAuthorDtoFactory::makeLightAuthorDto)
                                .collect(Collectors.toList())
                )
                .publishedDate(bookEntity.getPublishedDate())
                .build();
    }
}
