package ru.chistoapp.api.factory;

import lombok.RequiredArgsConstructor;
import ru.chistoapp.api.dto.AuthorDto;
import ru.chistoapp.store.AuthorEntity;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AuthorDtoFactory {
    private final LightBookDtoFactory lightBookDtoFactory;

    public AuthorDto makeAuthorDto(AuthorEntity authorEntity) {
        return AuthorDto.builder()
                .id(authorEntity.getId())
                .name(authorEntity.getName())
                .surname(authorEntity.getSurname())
                .birthDate(authorEntity.getBirthDate())
                .books(
                        authorEntity.getBooks().stream()
                                .map(lightBookDtoFactory::makeLightBookDto)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
