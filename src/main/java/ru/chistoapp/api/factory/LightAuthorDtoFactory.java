package ru.chistoapp.api.factory;

import org.springframework.stereotype.Component;
import ru.chistoapp.api.dto.LightAuthorDto;
import ru.chistoapp.store.AuthorEntity;

@Component
public class LightAuthorDtoFactory {

    public LightAuthorDto makeLightAuthorDto(AuthorEntity authorEntity) {
        return LightAuthorDto.builder()
                .Id(authorEntity.getId())
                .name(authorEntity.getName())
                .surname(authorEntity.getSurname())
                .birthDate(authorEntity.getBirthDate())
                .build();
    }
}
