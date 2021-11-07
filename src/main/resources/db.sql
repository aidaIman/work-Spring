select * from users;
insert into users(username, name, password, email)
values ('user','Alisa','user','user@mail.com'),
       ('admin','Aida','admin','admin@mail.com');

select * from roles;
insert into roles (role)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

select * from users_roles;
insert into users_roles(users_id,roles_id)
values (1,1),
       (2,1),
       (2,2);

