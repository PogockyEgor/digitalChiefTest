create table owners
(
    id        serial
        constraint owners_pk
            primary key,
    fio       varchar(50) not null,
    telephone varchar(13) not null,
    address   varchar(100),
    email     varchar(100)
);

alter table owners
    owner to postgres;

create unique index owners_id_uindex
    on owners (id);

create unique index owners_telephone_uindex
    on owners (telephone);

create table pets
(
    id            serial
        constraint pets_pk
            primary key,
    pet_name      varchar(30) not null,
    animal_type   varchar(30) not null,
    age_in_months integer     not null,
    owner_id      integer     not null
        constraint pets_owners_id_fk
            references owners
            on update cascade on delete cascade
            deferrable
);

alter table pets
    owner to postgres;

create unique index pets_id_uindex
    on pets (id);
