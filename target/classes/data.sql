INSERT INTO user_details (id, birth_date, name) VALUES
    (10001, current_date(), 'Jordi'),
    (10002, current_date(), 'Claudia'),
    (10003, current_date(), 'Eloy'),
    (10004, current_date(), 'Hector');

INSERT INTO post (id, description, user_id) VALUES
    (20001, 'I want to work', 10001),
    (20002, 'I want to learn AWS', 10002),
    (20003, 'I want to learn DevOps', 10003);
