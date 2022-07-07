

create table adres (
                       id bigint auto_increment,
                       city varchar(255),
                       postal_code varchar(255),
                       street_number varchar(255),
                       primary key (id)
);

create table cinema (
                        id bigint auto_increment,
                        name varchar(255),
                        adres_id bigint,
                        primary key (id)
);                 

create table cinema_hall (
                             id bigint auto_increment,
                             number integer not null,
                             seats integer not null,
                             cinema_id bigint,
                             primary key (id)
);                      

create table film_show (
                           id bigint auto_increment,
                           film_end varchar(255),
                           film_start varchar(255),
                           cinemahall_id bigint,
                           movie_id bigint,
                           primary key (id)
);           

create table movie (
                       id bigint auto_increment,
                       duration varchar(255),
                       min_client_age integer not null,
                       movie_type varchar(255),
                       title varchar(255),
                       filmdirector_id bigint,
                       primary key (id)
);

create table orders (
                        id bigint auto_increment,
                        final_price float not null,
                        client_id bigint,
                        ticket_id bigint,
                        primary key (id)
);       

create table person (
                        dtype varchar(31) not null,
                        id bigint not null,
                        day_of_birth date,
                        name varchar(255),
                        surname varchar(255),
                        gender varchar(255),
                        achievment varchar(255),
                        primary key (id)
);

create table ticket (
                        id bigint auto_increment,
                        buy_date date,
                        ticket_price float not null,
                        ticket_type varchar(255),
                        film_show_id bigint,
                        primary key (id)
);

alter table cinema
    add constraint FKiuv8yg84plf7i7s1jr9712tkh
        foreign key (adres_id)
            references adres;

alter table cinema_hall
    add constraint FKo0vku6p3nmp2txofwwyls44jq
        foreign key (cinema_id)
            references cinema;

alter table film_show
    add constraint FKofs0vkj3auevfqv9ttbyp7r5g
        foreign key (cinemahall_id)
            references cinema_hall;           

alter table film_show
    add constraint FKa7vua69nxyecq6f2a85ml9qy2
        foreign key (movie_id)
            references movie;                 

alter table movie
    add constraint FKae0juwhyh6474juprxb31bw0
        foreign key (filmdirector_id)
            references person;                   

alter table orders
    add constraint FKeeuts4tu84ulndoh4boj35y2u
        foreign key (client_id)
            references person;                   

alter table orders
    add constraint FKsesssrpdbpddyr7a4t4nyiy7p
        foreign key (ticket_id)
            references ticket;      

alter table ticket
    add constraint FKot143q2l3n21nidnr2jm3vbof
        foreign key (film_show_id)
            references film_show;