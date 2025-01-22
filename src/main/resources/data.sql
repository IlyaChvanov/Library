INSERT INTO author (birth_date, name, surname)
VALUES ('1980-01-15', 'John', 'Doe'),
       ('1975-06-20', 'Jane', 'Smith'),
       ('1990-11-05', 'Michael', 'Brown'),
       ('1988-02-17', 'Emily', 'Davis');

INSERT INTO book (published_date, title)
VALUES ('2000-07-15', 'The Great Adventure'),
       ('2010-09-23', 'Mystery in the Fog'),
       ('2015-05-30', 'The Lost World'),
       ('2020-01-10', 'Future Horizons');

INSERT INTO author_book (author_id, book_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (1, 3);

INSERT INTO reader (birth_date, gender, name, phone_number, surname)
VALUES ('1995-03-14', 1, 'Alice', '1234567890', 'Johnson'),
       ('1982-10-01', 1, 'Bob', '9876543210', 'Williams'),
       ('2001-07-08', 0, 'Charlie', '4567891230', 'Taylor'),
       ('1998-12-25', 1, 'Diana', '3216549870', 'Wilson');

INSERT INTO transaction (transaction_type, date, client_id, book_id)
VALUES (0, '2025-01-01 10:00:00', 1, 1),
       (1, '2025-01-05 15:00:00', 1, 1),
       (0, '2025-01-02 12:00:00', 2, 2),
       (0, '2025-01-03 14:00:00', 3, 3),
       (0, '2025-01-04 16:00:00', 2, 1);