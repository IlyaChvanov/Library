package ru.chistoapp.api.factory;

import org.springframework.stereotype.Component;
import ru.chistoapp.api.dto.LightBookDto;
import ru.chistoapp.store.BookEntity;

@Component
public class LightBookDtoFactory {

        public LightBookDto makeLightBookDto(BookEntity bookEntity) {
            return LightBookDto.builder()
                    .Id(bookEntity.getId())
                    .title(bookEntity.getTitle())
                    .publishedDate(bookEntity.getPublishedDate())
                    .build();
        }
}

