--Les 1.1
create table MEDEWERKERS_S1 as select * from MEDEWERKERS;

alter table MEDEWERKERS_S1 add GESLACHT varchar(1) null;
alter table MEDEWERKERS_S1 add CONSTRAINT CKH_GESLACHT CHECK (GESLACHT='M' or GESLACHT='V');

update MEDEWERKERS_S1 set GESLACHT='M' where MNR=7369;

--les 1.2

CREATE SEQUENCE S_AFDELINGEN START WITH 10 INCREMENT BY 10 CACHE 10;

CREATE OR REPLACE TRIGGER T_AFDELINGEN_ID
BEFORE INSERT
ON AFDELINGEN
REFERENCING NEW AS NEW
FOR EACH ROW
BEGIN
  if(:new.ANR is null) then
  SELECT S_AFDELINGEN.nextval
  INTO :new.ANR
  FROM dual;
  end if;
END;

ALTER TRIGGER "T_AFDELINGEN_ID" ENABLE;

--les 1.3

CREATE TABLE ADRESSEN (
    POSTCODE VARCHAR(7) CONSTRAINT TABLE1_CHK1 CHECK (REGEXP_LIKE( POSTCODE, '^[1-9][0-9]{3}[\s]?[A-Za-z]{2}$', 'i')),
    HUISNUMMER VARCHAR(4) NULL,
    INGANGSDATUM DATE NOT NULL,
    EINDDATUM DATE NULL CHECK (EINDDATUM < INGANGSDATUM),
    TELEFOON INT(10) UNIQUE
);

--les 1.4

create table medewerkers
(
    mnr      NUMBER(4) constraint M_PK primary key constraint M_MNR_CHK check (mnr > 7000),
    naam     VARCHAR2(12) constraint M_NAAM_NN not null,
    voorl    VARCHAR2(5) constraint M_VOORL_NN not null,
    functie  VARCHAR2(10),
    chef     NUMBER(4) constraint M_CHEF_FK references medewerkers,
    gbdatum  DATE constraint M_GEBDAT_NN not null,
    maandsal NUMBER(6, 2) constraint M_MNDSAL_NN not null,
    comm     NUMBER(6, 2),
    afd      NUMBER(2) default 10,
    constraint M_VERK_CHK check (case
        WHEN functie = 'VERKOPER' then comm = 1 else comm = 0 end)
);


