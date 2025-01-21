package ru.chistoapp.api.factory;

import org.springframework.stereotype.Component;
import ru.chistoapp.api.dto.ReaderDto;
import ru.chistoapp.store.ReaderEntity;

@Component
public class ReaderDtoFactory {

    public ReaderDto createReaderDto(ReaderEntity readerEntity) {
        return ReaderDto.builder()
                .id(readerEntity.getId())
                .phoneNumber(readerEntity.getPhoneNumber())
                .name(readerEntity.getName())
                .surname(readerEntity.getSurname())
                .gender(readerEntity.getGender())
                .birthDate(readerEntity.getBirthDate())
                .build();
    }

}
