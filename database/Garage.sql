create user garage by password garage;
create database garage;
\c garage ;

drop table employe_specialite;
drop table employe;
drop table specialite;


create sequence  employe_id_seq START WITH 1 INCREMENT BY 1;
create sequence specialite_id_seq  START WITH 1 INCREMENT BY 1;
create sequence niveau_etude_id_seq  START WITH 1 INCREMENT BY 1;
create sequence  genre_id_seq START WITH 1 INCREMENT BY 1;
create sequence  employe_specialite_id_seq START WITH 1 INCREMENT BY 1;
create sequence  main_oeuvre_id_seq START WITH 1 INCREMENT BY 1;
create sequence  type_service_id_seq START WITH 1 INCREMENT BY 1;
create sequence  service_id_seq START WITH 1 INCREMENT BY 1;


create table genre(
       id integer default nextval('genre_id_seq'::regclass) NOT NULL PRIMARY KEY,
       nom VARCHAR(50)
);
create table niveau_etude(
    id integer default nextval('niveau_etude_id_seq'::regclass) NOT NULL PRIMARY KEY,
    nom VARCHAR(50)
);

create table specialite(
    id  integer default nextval('specialite_id_seq'::regclass) NOT NULL PRIMARY KEY,
    nom VARCHAR(50),
    taux_horaire DEC(7,2)
);
insert into genre values (default , 'Masculin');
insert into genre values (default , 'Feminin');

insert into specialite values (default,'videur',02000.00);
insert into specialite values (default,'nettoyeur',05000.00);
insert into specialite values (default,'mecanicien',10000.00);
insert into specialite values (default,'garagiste',08000.00);


create table type_service(
     id  integer default nextval('type_service_id_seq'::regclass) NOT NULL PRIMARY KEY,
     nom VARCHAR(50),
     description text
);
insert into type_service values(default,'reparation','reparation des dommages');
insert into type_service values(default,'entretient','vidange');
insert into type_service values(default,'nettoyage','nettoyage de voiture');
insert into type_service values(default,'depanage','depanage exterieur');
insert into type_service values(default,'vulca','tous sur les pneus');
insert into type_service values(default,'entretient moteur','entretient moteur');



create table service(
    id  integer default nextval('service_id_seq'::regclass) NOT NULL PRIMARY KEY,
    date_service date,
    nom_client VARCHAR(50),
    type_service_id int,
    FOREIGN KEY(type_service_id) REFERENCES type_service(id)
);

create table main_oeuvre(
     id integer default nextval('main_oeuvre_id_seq'::regclass) NOT NULL PRIMARY KEY,
     specialite_id int,
     temps_fournis DEC(3,2),
     type_service_id int,
     quantite int,
     FOREIGN KEY(specialite_id) REFERENCES specialite(id),
     FOREIGN KEY(type_service_id) REFERENCES type_service(id) 
);
insert into main_oeuvre values (default,1,1.00,2,1);
insert into main_oeuvre values (default,1,2.00,6,1);
insert into main_oeuvre values (default,2,2.00,3,1);
insert into main_oeuvre values (default,3,2.00,4,1);
insert into main_oeuvre values (default,3,1.00,1,1);
insert into main_oeuvre values (default,4,0.25,5,1);
insert into main_oeuvre values (default,3,1.00,6,1);
insert into main_oeuvre values (default,2,0.50,5,1);




create table employe(
    id integer default nextval('employe_id_seq'::regclass) NOT NULL PRIMARY KEY,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    date_naissance DATE NOT NULL,
    genre_id int,
    niveau_etude_id int,
    salaire DEC(7,2),
    date_embauche DATE NOT NULL,
    FOREIGN KEY(genre_id) REFERENCES genre(id),
    FOREIGN KEY(niveau_etude_id) REFERENCES niveau_etude(id)
);

create table employe_specialite(
    employe_id int,
    specialite_id int,
    FOREIGN KEY(employe_id) REFERENCES employe(id),
    FOREIGN KEY(specialite_id) REFERENCES specialite(id)
);

INSERT INTO niveau_etude VALUES (default,'Bac');
INSERT INTO niveau_etude VALUES (default,'Bac+2');
INSERT INTO niveau_etude VALUES (default,'Bac+3');
INSERT INTO niveau_etude VALUES (default,'Bac+5');
INSERT INTO niveau_etude VALUES (default,'Bac+8');
-- select * from main_oeuvre join specialite on main_oeuvre.specialite_id = specialite.id join type_service on main_oeuvre.type_service_id = type_service.id;


-- select * from main_oeuvre join specialite on main_oeuvre.specialite_id = specialite.id join type_service on main_oeuvre.type_service_id = type_service.id;


-- select type_service.id, type_service.nom from main_oeuvre join specialite on main_oeuvre.specialite_id = specialite.id join type_service on main_oeuvre.type_service_id = type_service.id;

-- view aaa;

-- select specialite.taux_horaire*main_oeuvre.temps_fournis*main_oeuvre.quantite as cout from main_oeuvre join specialite on main_oeuvre.specialite_id = specialite.id join type_service on main_oeuvre.type_service_id = type_service.id;

-- select specialite.taux_horaire*main_oeuvre.temps_fournis*main_oeuvre.quantite as montant,type_service.id, type_service.nom,type_service.description from main_oeuvre join specialite on main_oeuvre.specialite_id = specialite.id join type_service on main_oeuvre.type_service_id = type_service.id;


create view v_cout_service as
(select specialite.taux_horaire*main_oeuvre.temps_fournis*main_oeuvre.quantite::DOUBLE PRECISION as montant,
type_service.id, type_service.nom,type_service.description from main_oeuvre join specialite on main_oeuvre.specialite_id = specialite.id 
join type_service on main_oeuvre.type_service_id = type_service.id);



