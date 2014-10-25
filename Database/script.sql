CREATE DATABASE citasmedicas;
USE citasmedicas;

CREATE TABLE PERSONA(
IDPER int(8) NOT NULL,
NOM varchar(20) NOT NULL,
APEPAT varchar(40) NOT NULL,
APEMAT varchar(40) NOT NULL,
DNI int(8),
CONSTRAINT pk_Persona PRIMARY KEY (IDPER)
);

CREATE TABLE TRABAJADOR(
IDTRAB int(8),
CODE varchar(15),
PASS varchar(20),
TIPTRAB int(2),
FECNAC date,
TELF1 int(10),
DIREC varchar(160),
CONSTRAINT pk_TRABAJADOR PRIMARY KEY (IDTRAB),
CONSTRAINT fk_TRABAJADORXPERSONA FOREIGN KEY (IDTRAB) REFERENCES PERSONA(IDPER)
);

CREATE TABLE DEPARTAMENTO(
IDDEPART int(2),
NOMDEPART varchar(60),
CONSTRAINT PK_DEPARTAMETO PRIMARY KEY (IDDEPART)
);

CREATE TABLE PROVINCIA(
IDDEPART int(2),
IDPROV int(2),
NOMPROV varchar(60),
CONSTRAINT PK_PROVINCIA PRIMARY KEY (IDDEPART,IDPROV),
CONSTRAINT FK_PROVXDEP FOREIGN KEY (IDDEPART)  REFERENCES DEPARTAMENTO(IDDEPART)
);

CREATE TABLE DISTRITO(
IDDIST int(2),
IDPROV int(2),
IDDEPART int(3),
NOMDIST varchar(60),
CONSTRAINT PK_DISTRITO PRIMARY KEY (IDDEPART,IDPROV,IDDIST),
CONSTRAINT FK_DISTXPROVXDEP FOREIGN KEY (IDDEPART,IDPROV) REFERENCES PROVINCIA (IDDEPART,IDPROV)
);

CREATE TABLE PACIENTE(
IDPAC int(8),
HUELLA blob,
FECNAC date,
ESTCIVIL varchar(20),
OCUPAC varchar(40),
LUGTRAB varchar(120),
SALDO float(8,2),
DIREC varchar(160),
TELF1 int(10),
TELF2 int(10),
CONTP int(10),
CONTM int(10),
IDDIST int(3),
IDPROV int(2),
IDDEPART int(2),
CONSTRAINT pk_PACIENTE PRIMARY KEY (IDPAC),
CONSTRAINT fk_PACIENTEXPERSONA FOREIGN KEY (IDPAC) REFERENCES PERSONA (IDPER),
CONSTRAINT fk_PACIENTEXDIST FOREIGN KEY(IDDEPART,IDPROV,IDDIST) REFERENCES DISTRITO(IDDEPART,IDPROV,IDDIST)
);

CREATE TABLE CARGO(
IDCARGO int(3),
NOMCARGO varchar(60),
CONSTRAINT PK_CARGO PRIMARY KEY (IDCARGO)
);

CREATE TABLE ESPECIALIDAD(
IDESP int(3),
NOMESP varchar(120),
DESCR varchar(250),
CONSTRAINT PK_ESPECIALIDAD PRIMARY KEY (IDESP)
);


CREATE TABLE MEDICO(
IDMED int(8),
FECESPEC date,
CODMED int(8),
FACMEDIC varchar(120),
TELF2 int(10),
IDCARGO int(3),
IDESP int(3),
CONSTRAINT PK_MEDICO PRIMARY KEY (IDMED),
CONSTRAINT FK_MEDICOXTRABAJADOR FOREIGN KEY (IDMED) REFERENCES TRABAJADOR(IDTRAB)
);

CREATE TABLE SERVICIO (
IDSERV int(10),
NOMSERV varchar(60),
COSTO float(8,2),
DESCR varchar(180),
CONSTRAINT PK_SERVICIO PRIMARY KEY (IDSERV)
);

CREATE TABLE ATENCION(
IDMED int(8),
IDSERV int(10),
HORAINI time,
HORAFIN time,
NROPISO int(2),
NROCONS int(5),
CAPATEN int(3),
CONSTRAINT PK_ATENCION PRIMARY KEY (IDMED,IDSERV),
CONSTRAINT FK_ATENCIONXSERVICIO FOREIGN KEY (IDSERV) REFERENCES SERVICIO(IDSERV),
CONSTRAINT FK_ATENCIONXMEDICO FOREIGN KEY (IDMED) REFERENCES MEDICO(IDMED)
);

CREATE TABLE HISTORIAMEDICA(
IDHISTORIA int(10),
FECAFIL date,
IDPAC int(8),
CONSTRAINT PK_HISTORIAMEDICA PRIMARY KEY (IDHISTORIA),
CONSTRAINT FK_HISTORIAMEDICAXPACIENTE FOREIGN KEY (IDPAC) REFERENCES PACIENTE(IDPAC)
);

CREATE TABLE OBSMEDICA(
IDOM int(10),
IDHISTORIA int(10),
FECOM date,
MOTV varchar(120),
DGNOS varchar(500),
IDMED int(8),
IDSERV int(20),
CONSTRAINT PK_OBSMEDICA PRIMARY KEY (IDOM,IDHISTORIA),
CONSTRAINT FK_OBSMEDICAXATENCION FOREIGN KEY (IDMED, IDSERV) REFERENCES ATENCION(IDMED, IDSERV)
);

CREATE TABLE CITAMEDICA(
IDCITA int(10),
ESTADO int(2),
IDMED int(8),
IDSERV int(10),
IDPAC int(8),
CONSTRAINT PK_CITAMEDICA PRIMARY KEY (IDCITA),
CONSTRAINT FK_CITAMEDICAXATENCION FOREIGN KEY (IDMED, IDSERV) REFERENCES ATENCION(IDMED,IDSERV),
CONSTRAINT FK_CITAMEDICAXPACIENTE FOREIGN KEY (IDPAC) REFERENCES PACIENTE(IDPAC)
);


INSERT INTO PERSONA (IDPER, NOM, APEPAT,APEMAT,DNI) VALUES (00000001,"Belgica","de la Torre","Guevara",29394959);
INSERT INTO PERSONA (IDPER, NOM, APEPAT,APEMAT,DNI) VALUES (00000002,"Rocio","Cordova","Aparicio",29394959);

INSERT INTO PACIENTE (IDPAC) VALUES (00000001);

INSERT INTO TRABAJADOR (IDTRAB) VALUES(00000002);

INSERT INTO CARGO (IDCARGO, NOMCARGO) VALUES (1,"Medico supervisor");
INSERT INTO ESPECIALIDAD (IDESP,NOMESP,DESCR) VALUES (1, "Medicina General", "Consultas rapidas");  

INSERT INTO MEDICO(IDMED, IDCARGO, IDESP) VALUES (2, 1, 1);

INSERT INTO SERVICIO VALUES(1, "Medicina General", 10.00, "Atencón de enfermedades recurrentes");

INSERT INTO ATENCION VALUES(2,1, '8:00:00', '15:00', 2, 2, 2);

INSERT INTO CITAMEDICA VALUES(1, 1, 2,1,1);




