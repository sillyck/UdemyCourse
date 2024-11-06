INSERT INTO user_datails (id, birth_date, name)
VALUES 
    (10001, current_date(), 'Jordi'),
    (10002, current_date() - interval '5 years', 'Claudia'),
    (10003, current_date() - interval '10 years', 'Eloy'),
    (10004, current_date() - interval '15 years', 'Hector');