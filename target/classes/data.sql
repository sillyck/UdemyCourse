INSERT INTO user_details (birth_date, name)
VALUES 
    (current_date(), 'Jordi'),
    (current_date(), 'Claudia'),
    (current_date(), 'Eloy'),
    (current_date(), 'Hector');

	
INSERT INTO post (id, description, user_id)
VALUES 
	(20001, 'I want to work', 10001),
	(20002, 'I want to learn AWS', 10002),
	(20003, 'I want to learn DevOps', 10003);