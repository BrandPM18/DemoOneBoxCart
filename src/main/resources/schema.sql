drop sequence if exists product_id_seq;
drop table cart if exists;
drop table product if exists;

CREATE SEQUENCE product_id_seq START WITH 2 INCREMENT BY 1;

create table product(
    id integer default nextval('product_id_seq') not null
        constraint product_pk primary key,
    description varchar(50),
    amount REAL
);

create table cart(
    id uuid constraint cart_pk primary key,
    final_amount REAL,
    products JSON not null,
    creation_date timestamp not null,
    modification_date timestamp not null,
    creation_user varchar(20) not null,
    modification_user varchar(20)
);