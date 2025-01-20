package ru.chistoapp.api.factory;

import ru.chistoapp.api.dto.ReaderDto;
import ru.chistoapp.store.ReaderEntity;

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
