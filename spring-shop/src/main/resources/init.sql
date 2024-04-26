drop table if exists shop;
create table shop(
                     id int generated always as identity primary key,
                     name varchar(255) not null,
                     address varchar(255) not null,
                     phone_number varchar(255) not null,
                     email varchar(255) not null,
                     url varchar(255),
                     category varchar(255) not null,
                     description varchar(255)
);
insert into shop(name, address, phone_number, email, url, category, description)
values ('Magnit', 'Krasny prospekt, 100','+7 383 1111111', 'magnit@mail.ru', 'magnit.ru', 'grocery store', 'Grocery store near your home!'),
       ('FixPrice', 'Dachnaya, 23', '+7 383 2222222', 'fixPrice@mail.ru', 'fix-price.ru', 'hardware store', 'Everything for your household!');
select * from shop;