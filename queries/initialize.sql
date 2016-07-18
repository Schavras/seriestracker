INSERT INTO `stdb`.`users` (
`user_username`,
`user_password`,
`user_email`) 
VALUES (
'first_user',
AES_ENCRYPT('first_pass','klmr420'), 
'first@email.com' 
);


INSERT INTO `stdb`.`users` (
`user_username`,
`user_password`,
`user_email`) 
VALUES (
'second_user',
AES_ENCRYPT('second_pass','klmr420'), 
'second@email.com' 
);

INSERT INTO `stdb`.`users` (
`user_username`,
`user_password`,
`user_email`) 
VALUES (
'aa',
AES_ENCRYPT('aa','klmr420'), 
'aa' 
);

insert into shows values ('tt2575988','Silicon Valley');
insert into shows values ('tt0944947','Game of Thrones');

-- insert into user_show values (3 , 'tt2575988','2016-01-01'); insert into user_show values (3 , 'tt0944947','2016-01-02'); insert into user_show values (1 , 'tt0944947','2016-01-01');

insert into user_show values (3 , 'tt2575988'); insert into user_show values (3 , 'tt0944947'); insert into user_show values (1 , 'tt0944947');