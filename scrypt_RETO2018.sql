







DROP TABLE duenyo CASCADE CONSTRAINTS;
/
DROP TABLE equipo CASCADE CONSTRAINTS;
/
DROP TABLE jugador CASCADE CONSTRAINTS;
/
DROP TABLE partido CASCADE CONSTRAINTS;
/
DROP TABLE clasificacion2 CASCADE CONSTRAINTS;
/
DROP TABLE usuarios CASCADE CONSTRAINTS;
/
DROP TABLE administradores CASCADE CONSTRAINTS;
/
DROP TABLE superusuario CASCADE CONSTRAINTS;
/
drop table borrar;
/
drop table tablaTriggerEquipo;
/
drop table tablaTriggerDuenyo;
/
drop table tablaTriggerJugador;
/
drop table tablaTriggerUsuario;
/
drop table tablaTriggerPartido;
/
drop sequence seq;
/
drop sequence seq2;
/
drop sequence seq3;
/



create sequence seq
start with 1
increment by 1
minvalue 1
maxvalue 8
cache 2
cycle;
/
create sequence seq2
start with 1
increment by 1
minvalue 1
maxvalue 8
cache 4
cycle;
/
create sequence seq3
start with 1
increment by 1;

/
create table borrar(
administrador varchar2(30));

/
create table Jugador (
NombreJug varchar2(10) constraint nom_jug_nn not null,
Nick varchar2(10) constraint nic_jug_uk unique,
Sueldo integer constraint sue_jug_nn not null,
DniJug varchar2(9) constraint dni_jug_pk primary key,
Caracteristicas varchar2(10),
CodigoEquiJug varchar2(10),
administradoroduenyo varchar2(30),
numaccion number
);

/
create table Duenyo (
NombreDue varchar2(10) constraint nom_due_pk primary key,
PasswordDue varchar2(30) constraint pas_due_nn not null,
EquiDue varchar2(10) constraint equ_due_nn not null,
ordenInsertar number,
nombre varchar2(10),
edad number(3),
profesion varchar2(10),
administradoroduenyo varchar2(30),
numaccion number
);
/
create table Equipo (
NombreEqui varchar2(10) constraint nom_equi_nn not null primary key,
fundacion number(4),
ciudad varchar2(10),
estadio varchar2(10),
capacidad number(7),
titulos number(3),
ordenInsertar number,
administradoroduenyo varchar2(30),
numaccion number);
/

create table Partido (
Fecha varchar2(10) constraint fec_par_nn not null,
Jornada number,
Resultado1 number,
Resultado2 number,
nombreequiloc varchar2(10),
nombreequivis varchar2(10),
numaccion number,
administradoroduenyo varchar2(30),
ordenInsercion number
);
/
create table clasificacion2 (
equipo varchar2(10),
jornada number(2),
puntos number(2),
ganados number(2),
empatados number(2),
perdidos number(2)
);
/
create table usuarios (
nombre varchar2(10),
email varchar2(30) primary key,
password2 varchar2(30),
numaccion number,
administradoroduenyo varchar2(30)
);
/
create table administradores(
nombre varchar2(30),
usuario varchar2(30),
password2 varchar2(30));
/
create table superusuario(
usuario varchar2(30),
password2 varchar2(30));
/


create table tablaTriggerEquipo(
equipo varchar2(10),
accion varchar2(30),
fecha TIMESTAMP WITH TIME ZONE,
administrador varchar2(30));
/
create table tablaTriggerDuenyo(
duenyo varchar2(10),
accion varchar2(30),
fecha TIMESTAMP WITH TIME ZONE,
administrador varchar2(30));
/
create table tablaTriggerJugador(
jugador varchar2(10),
accion varchar2(30),
fecha TIMESTAMP WITH TIME ZONE,
administrador varchar2(30));
/

create table tablaTriggerUsuario(
usuario varchar2(10),
accion varchar2(30),
fecha TIMESTAMP WITH TIME ZONE,
administrador varchar2(30));
/
create table tablaTriggerPartido(
equipoloc varchar2(10),
equipovis varchar2(10),
accion varchar2(30),
fecha TIMESTAMP WITH TIME ZONE,
administrador varchar2(30));



/




alter table equipo add constraint equ_nom_ck check (nombreequi!='0');
/
alter table clasificacion2 add constraint equ_cla_pk primary key (equipo, jornada);
/
alter table partido add constraint nom_par_pk primary key (nombreequiloc,jornada);
/
alter table Jugador add constraint sal_equi_ck check (sueldo>=10302.60);

/





insert into equipo(nombreequi,ordeninsertar) values('equipo1',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo2',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo3',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo4',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo5',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo6',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo7',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo8',seq.nextval);

insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo1','duenyo1','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo2','duenyo2','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo3','duenyo3','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo4','duenyo4','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo5','duenyo5','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo6','duenyo6','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo7','duenyo7','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo8','duenyo8','0',seq2.nextval);

insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador1','jug1', 20000,'1','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador2','jug2', 20000,'2','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador3','jug3', 20000,'3','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador4','jug4', 30000,'4','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador5','jug5',30000,'5','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador6','jug6',30000,'6','nadie',seq3.nextval,'equipo1');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador7','jug7',40000,'7','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador8','jug8',40000,'8','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador9','jug9',40000,'9','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador10','jug10',40000,'10','nadie',seq3.nextval,'equipo1');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador11','jug11',20000,'11','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador12','jug12',20000,'12','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador13','jug13',20000,'13','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador14','jug14',50000,'14','nadie',seq3.nextval,'equipo1');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador15','jug15',50000,'15','nadie',seq3.nextval,'equipo1');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador16','jug16',60000,'16','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador17','jug17',70000,'17','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador18','jug18', 80000,'18','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador19','jug19',90000,'19','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador20','jug20', 100000,'20','nadie',seq3.nextval,'0');

insert into administradores values('admin1','admin1','admin1');
insert into administradores values('admin2','admin2','admin2');
insert into administradores values('admin3','admin3','admin3');
insert into administradores values('admin4','admin4','admin4');
insert into administradores values('admin5','admin5','admin5');
insert into administradores values('admin6','admin6','admin6');
insert into administradores values('admin7','admin7','admin7');
insert into administradores values('admin8','admin8','admin8');
insert into administradores values('admin9','admin9','admin9');



insert into usuarios values ('usuario1', 'usuario1@email.com','usuario1',seq3.nextval,'nadie');
insert into usuarios values ('usuario2', 'usuario2@email.com','usuario2',seq3.nextval,'nadie');
insert into usuarios values ('usuario3', 'usuario3@email.com','usuario3',seq3.nextval,'nadie');
insert into usuarios values ('usuario4', 'usuario4@email.com','usuario4',seq3.nextval,'nadie');
insert into usuarios values ('usuario5', 'usuario5@email.com','usuario5',seq3.nextval,'nadie');
insert into usuarios values ('usuario6', 'usuario6@email.com','usuario6',seq3.nextval,'nadie');
insert into usuarios values ('usuario7', 'usuario7@email.com','usuario7',seq3.nextval,'nadie');
insert into usuarios values ('usuario8', 'usuario8@email.com','usuario8',seq3.nextval,'nadie');
insert into usuarios values ('usuario9', 'usuario9@email.com','usuario9',seq3.nextval,'nadie');

insert into partido values('1/1/2018',1,4,0,'equipo1','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('1/1/2018',1,3,3,'equipo3','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('1/1/2018',1,4,2,'equipo4','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('1/1/2018',1,3,3,'equipo5','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('8/1/2018',2,2,1,'equipo1','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('8/1/2018',2,3,2,'equipo2','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('8/1/2018',2,2,3,'equipo4','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('8/1/2018',2,2,4,'equipo5','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('15/1/2018',3,1,2,'equipo1','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('15/1/2018',3,0,3,'equipo2','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('15/1/2018',3,0,0,'equipo5','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('15/1/2018',3,2,0,'equipo6','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('22/1/2018',4,3,2,'equipo1','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('22/1/2018',4,4,2,'equipo2','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('22/1/2018',4,2,1,'equipo3','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('22/1/2018',4,2,3,'equipo6','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('29/1/2018',5,3,2,'equipo1','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('29/1/2018',5,1,0,'equipo2','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('29/1/2018',5,0,0,'equipo3','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('29/1/2018',5,0,2,'equipo7','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/2/2018',6,1,3,'equipo1','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/2/2018',6,2,2,'equipo2','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/2/2018',6,0,1,'equipo3','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/2/2018',6,4,3,'equipo4','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/2/2018',7,2,3,'equipo1','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/2/2018',7,3,2,'equipo2','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/2/2018',7,4,2,'equipo3','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/2/2018',7,3,0,'equipo4','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/2/2018',8,0,3,'equipo2','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/2/2018',8,2,4,'equipo8','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/2/2018',8,1,0,'equipo7','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/2/2018',8,3,3,'equipo6','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/2/2018',9,2,2,'equipo6','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/2/2018',9,0,2,'equipo3','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/2/2018',9,3,4,'equipo8','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/2/2018',9,4,2,'equipo7','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/3/2018',10,3,2,'equipo3','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/3/2018',10,6,0,'equipo4','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/3/2018',10,3,3,'equipo8','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/3/2018',10,2,1,'equipo7','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/3/2018',11,3,2,'equipo7','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/3/2018',11,4,1,'equipo5','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/3/2018',11,1,1,'equipo4','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/3/2018',11,2,2,'equipo8','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/3/2018',12,3,2,'equipo4','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/3/2018',12,4,1,'equipo6','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/3/2018',12,3,2,'equipo5','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/3/2018',12,2,3,'equipo8','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/3/2018',13,3,2,'equipo8','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/3/2018',13,0,1,'equipo7','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/3/2018',13,4,1,'equipo6','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/3/2018',13,3,2,'equipo5','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('2/4/2018',14,0,3,'equipo5','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('2/4/2018',14,2,4,'equipo8','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('2/4/2018',14,3,2,'equipo7','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('2/4/2018',14,2,0,'equipo6','equipo4',seq3.nextval,'nadie', seq3.nextval);


insert into clasificacion2 values('equipo1',1,3,1,0,0);
insert into clasificacion2 values('equipo1',2,1,0,1,0);
insert into clasificacion2 values('equipo1',3,3,1,0,0);
insert into clasificacion2 values('equipo1',4,0,0,1,0);
insert into clasificacion2 values('equipo1',5,1,0,1,0);
insert into clasificacion2 values('equipo1',6,3,1,0,0);
insert into clasificacion2 values('equipo1',7,0,0,0,1);
insert into clasificacion2 values('equipo1',8,1,0,1,0);
insert into clasificacion2 values('equipo1',9,0,0,0,1);
insert into clasificacion2 values('equipo1',10,1,0,1,0);
insert into clasificacion2 values('equipo1',11,3,1,0,0);
insert into clasificacion2 values('equipo1',12,1,0,1,0);
insert into clasificacion2 values('equipo1',13,3,1,0,0);
insert into clasificacion2 values('equipo1',14,3,1,0,0);

insert into clasificacion2 values('equipo2',1,3,1,0,0);
insert into clasificacion2 values('equipo2',2,3,1,0,0);
insert into clasificacion2 values('equipo2',3,0,0,1,0);
insert into clasificacion2 values('equipo2',4,3,1,0,0);
insert into clasificacion2 values('equipo2',5,1,0,1,0);
insert into clasificacion2 values('equipo2',6,1,0,1,0);
insert into clasificacion2 values('equipo2',7,3,1,0,0);
insert into clasificacion2 values('equipo2',8,3,1,0,0);
insert into clasificacion2 values('equipo2',9,3,1,0,0);
insert into clasificacion2 values('equipo2',10,3,1,0,0);
insert into clasificacion2 values('equipo2',11,3,1,0,0);
insert into clasificacion2 values('equipo2',12,3,1,0,0);
insert into clasificacion2 values('equipo2',13,3,1,0,0);
insert into clasificacion2 values('equipo2',14,3,1,0,0);

insert into clasificacion2 values('equipo3',1,3,1,0,0);
insert into clasificacion2 values('equipo3',2,3,1,0,0);
insert into clasificacion2 values('equipo3',3,0,1,0,0);
insert into clasificacion2 values('equipo3',4,3,1,0,0);
insert into clasificacion2 values('equipo3',5,0,1,0,0);
insert into clasificacion2 values('equipo3',6,3,1,0,0);
insert into clasificacion2 values('equipo3',7,0,1,0,0);
insert into clasificacion2 values('equipo3',8,3,1,0,0);
insert into clasificacion2 values('equipo3',9,3,1,0,0);
insert into clasificacion2 values('equipo3',10,3,1,0,0);
insert into clasificacion2 values('equipo3',11,3,1,0,0);
insert into clasificacion2 values('equipo3',12,1,1,0,0);
insert into clasificacion2 values('equipo3',13,3,1,0,0);
insert into clasificacion2 values('equipo3',14,3,1,0,0);

insert into clasificacion2 values('equipo4',1,1,1,0,0);
insert into clasificacion2 values('equipo4',2,3,1,0,0);
insert into clasificacion2 values('equipo4',3,1,1,0,0);
insert into clasificacion2 values('equipo4',4,3,1,0,0);
insert into clasificacion2 values('equipo4',5,1,1,0,0);
insert into clasificacion2 values('equipo4',6,3,1,0,0);
insert into clasificacion2 values('equipo4',7,1,1,0,0);
insert into clasificacion2 values('equipo4',8,3,1,0,0);
insert into clasificacion2 values('equipo4',9,1,1,0,0);
insert into clasificacion2 values('equipo4',10,0,1,0,0);
insert into clasificacion2 values('equipo4',11,3,1,0,0);
insert into clasificacion2 values('equipo4',12,3,1,0,0);
insert into clasificacion2 values('equipo4',13,0,1,0,0);
insert into clasificacion2 values('equipo4',14,3,1,0,0);

insert into clasificacion2 values('equipo5',1,3,1,0,0);
insert into clasificacion2 values('equipo5',2,1,1,0,0);
insert into clasificacion2 values('equipo5',3,1,1,0,0);
insert into clasificacion2 values('equipo5',4,3,1,0,0);
insert into clasificacion2 values('equipo5',5,3,1,0,0);
insert into clasificacion2 values('equipo5',6,3,1,0,0);
insert into clasificacion2 values('equipo5',7,1,1,0,0);
insert into clasificacion2 values('equipo5',8,3,1,0,0);
insert into clasificacion2 values('equipo5',9,1,1,0,0);
insert into clasificacion2 values('equipo5',10,3,1,0,0);
insert into clasificacion2 values('equipo5',11,1,1,0,0);
insert into clasificacion2 values('equipo5',12,0,1,0,0);
insert into clasificacion2 values('equipo5',13,0,1,0,0);
insert into clasificacion2 values('equipo5',14,0,1,0,0);

insert into clasificacion2 values('equipo6',1,3,1,0,0);
insert into clasificacion2 values('equipo6',2,1,1,0,0);
insert into clasificacion2 values('equipo6',3,1,1,0,0);
insert into clasificacion2 values('equipo6',4,1,1,0,0);
insert into clasificacion2 values('equipo6',5,1,1,0,0);
insert into clasificacion2 values('equipo6',6,0,1,0,0);
insert into clasificacion2 values('equipo6',7,3,1,0,0);
insert into clasificacion2 values('equipo6',8,1,1,0,0);
insert into clasificacion2 values('equipo6',9,3,1,0,0);
insert into clasificacion2 values('equipo6',10,3,1,0,0);
insert into clasificacion2 values('equipo6',11,0,1,0,0);
insert into clasificacion2 values('equipo6',12,3,1,0,0);
insert into clasificacion2 values('equipo6',13,0,1,0,0);
insert into clasificacion2 values('equipo6',14,1,1,0,0);

insert into clasificacion2 values('equipo7',1,1,1,0,0);
insert into clasificacion2 values('equipo7',2,3,1,0,0);
insert into clasificacion2 values('equipo7',3,0,1,0,0);
insert into clasificacion2 values('equipo7',4,3,1,0,0);
insert into clasificacion2 values('equipo7',5,3,1,0,0);
insert into clasificacion2 values('equipo7',6,3,1,0,0);
insert into clasificacion2 values('equipo7',7,1,1,0,0);
insert into clasificacion2 values('equipo7',8,3,1,0,0);
insert into clasificacion2 values('equipo7',9,1,1,0,0);
insert into clasificacion2 values('equipo7',10,1,1,0,0);
insert into clasificacion2 values('equipo7',11,0,1,0,0);
insert into clasificacion2 values('equipo7',12,0,1,0,0);
insert into clasificacion2 values('equipo7',13,0,1,0,0);
insert into clasificacion2 values('equipo7',14,0,1,0,0);

insert into clasificacion2 values('equipo8',1,1,1,0,0);
insert into clasificacion2 values('equipo8',2,3,1,0,0);
insert into clasificacion2 values('equipo8',3,1,1,0,0);
insert into clasificacion2 values('equipo8',4,3,1,0,0);
insert into clasificacion2 values('equipo8',5,0,1,0,0);
insert into clasificacion2 values('equipo8',6,3,1,0,0);
insert into clasificacion2 values('equipo8',7,1,1,0,0);
insert into clasificacion2 values('equipo8',8,3,1,0,0);
insert into clasificacion2 values('equipo8',9,0,1,0,0);
insert into clasificacion2 values('equipo8',10,1,1,0,0);
insert into clasificacion2 values('equipo8',11,3,1,0,0);
insert into clasificacion2 values('equipo8',12,0,1,0,0);
insert into clasificacion2 values('equipo8',13,3,1,0,0);
insert into clasificacion2 values('equipo8',14,1,1,0,0);



insert into superusuario values('root','root');

insert into borrar values('nadie');



/

create or replace trigger triggerEquipo after insert or update on equipo
declare
v varchar2(30);
v_1 varchar2 (10);
v_2 varchar2 (30);
v_3 number;
begin
if inserting then v:='insertar';
elsif updating then v:='actualizar';
end if;
select max(numaccion) into v_3 from equipo;
select nombreequi into v_1 from equipo where numaccion= v_3;
select administradoroduenyo into v_2 from equipo where numaccion= v_3;
insert into tablaTriggerEquipo values(v_1,v,sysdate,v_2);
end;

/

create or replace trigger triggerEquipo2 before delete on equipo
declare
v varchar2(30):='deleting';
v_2 varchar2 (30);
begin
select administrador into v_2 from borrar;
insert into tablaTriggerEquipo values(null,v,current_timestamp,v_2);
end;

/




create or replace trigger triggerDuenyo after insert or update on duenyo
declare
v varchar2(30);
v_1 varchar2 (10);
v_2 varchar2 (30);
v_3 number;
begin
if inserting then v:='insertar';
elsif updating then v:='actualizar';
end if;
select max(numaccion) into v_3 from duenyo;
select nombredue into v_1 from duenyo where numaccion= v_3;
select administradoroduenyo into v_2 from duenyo where numaccion= v_3;
insert into tablaTriggerDuenyo values(v_1,v,sysdate,v_2);
end;

/

create or replace trigger triggerDuenyo2 before delete on duenyo
declare
v varchar2(30):='deleting';
v_1 varchar2 (10);
v_2 varchar2 (30);
v_3 number;
begin
select max(numaccion) into v_3 from duenyo;
select nombredue into v_1 from duenyo where numaccion= v_3;
select administrador into v_2 from borrar;
insert into tablaTriggerDuenyo values(null,v,current_timestamp,v_2);
end;

/

create or replace trigger triggerPartido3 after insert or update on partido
declare
v varchar2(30);
v_1 varchar2 (10);
v_2 varchar2 (30);
v_3 number;
v_4 varchar2 (10);
begin
if inserting then v:='insertar';
elsif updating then v:='actualizar';
end if;
select max(numaccion) into v_3 from partido;
select nombreequiloc into v_1 from partido where numaccion= v_3;
select nombreequivis into v_4 from partido where numaccion= v_3;
select administradoroduenyo into v_2 from partido where numaccion= v_3;
insert into tablaTriggerPartido values(v_1,v_4,v,sysdate,v_2);
end;

/

create or replace trigger triggerPartido4 before delete on partido
declare
v varchar2(30):='deleting';
v_2 varchar2 (30);
v_3 number;
begin
select max(numaccion) into v_3 from partido;
select administrador into v_2 from borrar;
insert into tablaTriggerPartido values('todos','todos',v,sysdate,v_2);
end;

/

create or replace trigger triggerJugador after insert or update on jugador
declare
v varchar2(30);
v_1 varchar2 (10);
v_2 varchar2 (30);
v_3 number;
begin
if inserting then v:='insertar';
elsif updating then v:='actualizar';
end if;
select max(numaccion) into v_3 from jugador;
select nombrejug into v_1 from jugador where numaccion= v_3;
select administradoroduenyo into v_2 from jugador where numaccion= v_3;
insert into tablaTriggerJugador values(v_1,v,sysdate,v_2);
end;

/

create or replace trigger triggerJugador2 before delete on jugador
declare
v varchar2(30):='deleting';
v_1 varchar2 (10);
v_2 varchar2 (30);
v_3 number;
begin
select max(numaccion) into v_3 from jugador;
select nombrejug into v_1 from jugador where numaccion= v_3;
select administrador into v_2 from borrar;
insert into tablaTriggerJugador values(v_1,v,current_timestamp,v_2);
end;

/

create or replace trigger triggerUsuario after insert or update on usuarios
declare
v varchar2(30);
v_1 varchar2 (10);
v_2 varchar2 (30);
v_3 number;
begin
if inserting then v:='insertar';
elsif updating then v:='actualizar';
end if;
select max(numaccion) into v_3 from usuarios;
select email into v_1 from usuarios where numaccion= v_3;
select administradoroduenyo into v_2 from usuarios where numaccion= v_3;
insert into tablaTriggerUsuario values(v_1,v,sysdate,v_2);
end;

/

create or replace trigger triggerUsuario2 before delete on usuarios
declare
v varchar2(30):='deleting';
v_1 varchar2 (10);
v_2 varchar2 (30);
v_3 number;
begin
select max(numaccion) into v_3 from usuarios;
select email into v_1 from usuarios where numaccion= v_3;
select administrador into v_2 from borrar;
insert into tablaTriggerUsuario values(v_1,v,current_timestamp,v_2);
end;

/


create or replace trigger numJug before update on jugador
declare
v number:=0;
begin
select max(count(CodigoEquiJug)) into v from jugador where CodigoEquiJug!='0' group by CodigoEquiJug;
if  v=6 then
raise_application_error(-20600,'error'||'no se puede modificar mas de 6');
end if;
end;

/

create or replace trigger salJug after update on jugador
declare
v2 number;
begin
select max(sum(sueldo)) into v2 from jugador where CodigoEquiJug!='0' group by CodigoEquiJug;
if v2>200000 then
update jugador set CodigoEquiJug='0' where numaccion=(select max(numaccion) from jugador);
end if;
end;

/




















CREATE OR REPLACE PACKAGE calendario 
IS
type tcursor1 is ref cursor;
PROCEDURE crearCalendario (equipo1 in varchar2,equipo2 in varchar2,equipo3 in varchar2,equipo4 in varchar2,
equipo5 in varchar2,equipo6 in varchar2,equipo7 in varchar2,equipo8 in varchar2, jornada in number,
v_1 out varchar2,v_2 out varchar2,v_3 out varchar2,v_4 out varchar2,v_5 out varchar2,v_6 out varchar2,
v_7 out varchar2,v_8 out varchar2);
PROCEDURE verResultados (jornada1 in number,
cursor1 out tcursor1);
PROCEDURE grafico (equipoa in varchar2, puntos1 out number,puntos2 out number,puntos3 out number,puntos4 out number,puntos5 out number,
puntos6 out number,puntos7 out number,puntos8 out number,puntos9 out number,puntos10 out number,puntos11 out number,
puntos12 out number,puntos13 out number,puntos14 out number);
PROCEDURE verEquipos (cursor1 out tcursor1);
PROCEDURE verDuenyos (cursor1 out tcursor1);
PROCEDURE insertarDatos;
PROCEDURE eliminarDatos;

end;

/

CREATE OR REPLACE PACKAGE BODY calendario 
IS

PROCEDURE crearCalendario (equipo1 in varchar2,equipo2 in varchar2,equipo3 in varchar2,equipo4 in varchar2,
equipo5 in varchar2,equipo6 in varchar2,equipo7 in varchar2,equipo8 in varchar2, jornada in number,
v_1 out varchar2,v_2 out varchar2,v_3 out varchar2,v_4 out varchar2,v_5 out varchar2,v_6 out varchar2,
v_7 out varchar2,v_8 out varchar2)
IS

type array_equipos1 is varray(8) of varchar2(10);
   array1 array_equipos1 := array_equipos1(equipo1, equipo2, equipo3,equipo4, equipo5, equipo6,equipo7, equipo8);

BEGIN

if jornada=1 then

v_1:=array1(1);
v_2:=array1(2);
v_3:=array1(3);
v_4:=array1(8);
v_5:=array1(4);
v_6:=array1(7);
v_7:=array1(5);
v_8:=array1(6);

dbms_output.put_line(array1(1)|| ' vs ' ||array1(2)); 
dbms_output.put_line(array1(3)|| ' vs ' ||array1(8)); 
dbms_output.put_line(array1(4)|| ' vs ' ||array1(7)); 
dbms_output.put_line(array1(5)|| ' vs ' ||array1(6)); 

end if;

if jornada=2 then

v_1:=array1(1);
v_2:=array1(6);
v_3:=array1(2);
v_4:=array1(3);
v_5:=array1(4);
v_6:=array1(8);
v_7:=array1(5);
v_8:=array1(7);

dbms_output.put_line(array1(1)|| ' vs ' ||array1(6)); 
dbms_output.put_line(array1(2)|| ' vs ' ||array1(3)); 
dbms_output.put_line(array1(4)|| ' vs ' ||array1(8)); 
dbms_output.put_line(array1(5)|| ' vs ' ||array1(7)); 

end if;

if jornada=3 then

v_1:=array1(1);
v_2:=array1(3);
v_3:=array1(2);
v_4:=array1(4);
v_5:=array1(5);
v_6:=array1(8);
v_7:=array1(6);
v_8:=array1(7);

dbms_output.put_line(array1(1)|| ' vs ' ||array1(3)); 
dbms_output.put_line(array1(2)|| ' vs ' ||array1(4)); 
dbms_output.put_line(array1(5)|| ' vs ' ||array1(8)); 
dbms_output.put_line(array1(6)|| ' vs ' ||array1(7)); 

end if;

if jornada=4 then

v_1:=array1(1);
v_2:=array1(7);
v_3:=array1(2);
v_4:=array1(5);
v_5:=array1(3);
v_6:=array1(4);
v_7:=array1(6);
v_8:=array1(8);

dbms_output.put_line(array1(1)|| ' vs ' ||array1(7)); 
dbms_output.put_line(array1(2)|| ' vs ' ||array1(5)); 
dbms_output.put_line(array1(3)|| ' vs ' ||array1(4)); 
dbms_output.put_line(array1(6)|| ' vs ' ||array1(8)); 

end if;

if jornada=5 then

v_1:=array1(1);
v_2:=array1(4);
v_3:=array1(2);
v_4:=array1(6);
v_5:=array1(3);
v_6:=array1(5);
v_7:=array1(7);
v_8:=array1(8);

dbms_output.put_line(array1(1)|| ' vs ' ||array1(4)); 
dbms_output.put_line(array1(2)|| ' vs ' ||array1(6)); 
dbms_output.put_line(array1(3)|| ' vs ' ||array1(5)); 
dbms_output.put_line(array1(7)|| ' vs ' ||array1(8)); 

end if;

if jornada=6 then

v_1:=array1(1);
v_2:=array1(8);
v_3:=array1(2);
v_4:=array1(7);
v_5:=array1(3);
v_6:=array1(6);
v_7:=array1(4);
v_8:=array1(5);

dbms_output.put_line(array1(1)|| ' vs ' ||array1(8)); 
dbms_output.put_line(array1(2)|| ' vs ' ||array1(7)); 
dbms_output.put_line(array1(3)|| ' vs ' ||array1(6)); 
dbms_output.put_line(array1(4)|| ' vs ' ||array1(5)); 

end if;

if jornada=7 then

v_1:=array1(1);
v_2:=array1(5);
v_3:=array1(2);
v_4:=array1(8);
v_5:=array1(3);
v_6:=array1(7);
v_7:=array1(4);
v_8:=array1(6);

dbms_output.put_line(array1(1)|| ' vs ' ||array1(5)); 
dbms_output.put_line(array1(2)|| ' vs ' ||array1(8)); 
dbms_output.put_line(array1(3)|| ' vs ' ||array1(7)); 
dbms_output.put_line(array1(4)|| ' vs ' ||array1(6)); 

end if;

if jornada=8 then

v_1:=array1(2);
v_2:=array1(1);
v_3:=array1(8);
v_4:=array1(3);
v_5:=array1(7);
v_6:=array1(4);
v_7:=array1(6);
v_8:=array1(5); 

end if;

if jornada=9 then

v_1:=array1(6);
v_2:=array1(1);
v_3:=array1(3);
v_4:=array1(2);
v_5:=array1(8);
v_6:=array1(4);
v_7:=array1(7);
v_8:=array1(5);

end if;

if jornada=10 then

v_1:=array1(3);
v_2:=array1(1);
v_3:=array1(4);
v_4:=array1(2);
v_5:=array1(8);
v_6:=array1(5);
v_7:=array1(7);
v_8:=array1(6);

end if;

if jornada=11 then

v_1:=array1(7);
v_2:=array1(1);
v_3:=array1(5);
v_4:=array1(2);
v_5:=array1(4);
v_6:=array1(3);
v_7:=array1(8);
v_8:=array1(6);

end if;

if jornada=12 then

v_1:=array1(4);
v_2:=array1(1);
v_3:=array1(6);
v_4:=array1(2);
v_5:=array1(5);
v_6:=array1(3);
v_7:=array1(8);
v_8:=array1(7);

end if;

if jornada=13 then

v_1:=array1(8);
v_2:=array1(1);
v_3:=array1(7);
v_4:=array1(2);
v_5:=array1(6);
v_6:=array1(3);
v_7:=array1(5);
v_8:=array1(4);

end if;

if jornada=14 then

v_1:=array1(5);
v_2:=array1(1);
v_3:=array1(8);
v_4:=array1(2);
v_5:=array1(7);
v_6:=array1(3);
v_7:=array1(6);
v_8:=array1(4);

end if;

end;
PROCEDURE verResultados (jornada1 in number,
cursor1 out tcursor1)
IS
BEGIN
 open cursor1 for
SELECT resultado1, resultado2,fecha FROM partido where jornada=jornada1 order by ordenInsercion;

END;

PROCEDURE grafico (equipoa in varchar2, puntos1 out number,puntos2 out number,puntos3 out number,puntos4 out number,puntos5 out number,
puntos6 out number,puntos7 out number,puntos8 out number,puntos9 out number,puntos10 out number,puntos11 out number,
puntos12 out number,puntos13 out number,puntos14 out number)
is


begin

select sum(puntos) into puntos1 from clasificacion2 where jornada=1 group by equipo having equipo=equipoa;

select sum(puntos) into puntos2 from clasificacion2 where jornada=1 or jornada=2 group by equipo having equipo=equipoa;

select sum(puntos) into puntos3 from clasificacion2 where jornada=1 or jornada=2 or 
jornada=3 group by equipo having equipo=equipoa;

select sum(puntos) into puntos4 from clasificacion2 where jornada=1 or jornada=2 or 
jornada=3 or jornada=4 group by equipo having equipo=equipoa;

select sum(puntos) into puntos5 from clasificacion2 where  jornada=1 or jornada=2 or 
jornada=3 or jornada=4 or jornada=5 group by equipo having equipo=equipoa;

select sum(puntos) into puntos6 from clasificacion2 where  jornada=1 or jornada=2 or 
jornada=3 or jornada=4 or jornada=5 or jornada=6 group by equipo having equipo=equipoa;

select sum(puntos) into puntos7 from clasificacion2 where  jornada=1 or jornada=2 or 
jornada=3 or jornada=4 or jornada=5 or jornada=6 or jornada=7 group by equipo having equipo=equipoa;

select sum(puntos) into puntos8 from clasificacion2 where jornada=1 or jornada=2 or 
jornada=3 or jornada=4 or jornada=5 or jornada=6 or jornada=7 or jornada=8 group by equipo having equipo=equipoa;

select sum(puntos) into puntos9 from clasificacion2 where jornada=1 or jornada=2 or 
jornada=3 or jornada=4 or jornada=5 or jornada=6 or jornada=7 or jornada=8 
or jornada=9 group by equipo having equipo=equipoa;

select sum(puntos) into puntos10 from clasificacion2 where  jornada=1 or jornada=2 or 
jornada=3 or jornada=4 or jornada=5 or jornada=6 or jornada=7 or jornada=8 
or jornada=9 or jornada=10 group by equipo having equipo=equipoa;

select sum(puntos) into puntos11 from clasificacion2 where  jornada=1 or jornada=2 or 
jornada=3 or jornada=4 or jornada=5 or jornada=6 or jornada=7 or jornada=8 
or jornada=9 or jornada=10 or jornada=11 group by equipo having equipo=equipoa;

select sum(puntos) into puntos12 from clasificacion2 where jornada=1 or jornada=2 or 
jornada=3 or jornada=4 or jornada=5 or jornada=6 or jornada=7 or jornada=8 
or jornada=9 or jornada=10 or jornada=11 or jornada=12 group by equipo having equipo=equipoa;

select sum(puntos) into puntos13 from clasificacion2 where jornada=1 or jornada=2 or 
jornada=3 or jornada=4 or jornada=5 or jornada=6 or jornada=7 or jornada=8 
or jornada=9 or jornada=10 or jornada=11 or jornada=12 or jornada=13 group by equipo having equipo=equipoa;

select sum(puntos) into puntos14 from clasificacion2 where  jornada=1 or jornada=2 or 
jornada=3 or jornada=4 or jornada=5 or jornada=6 or jornada=7 or jornada=8 
or jornada=9 or jornada=10 or jornada=11 or jornada=12 or jornada=13 or jornada=14 group by equipo having equipo=equipoa;

end;
PROCEDURE verEquipos (cursor1 out tcursor1)
is
begin
 open cursor1 for
SELECT nombreequi FROM equipo order by ordenInsertar;

end;

PROCEDURE verDuenyos (cursor1 out tcursor1)
is
begin
 open cursor1 for
SELECT nombreDue,passwordDue FROM duenyo order by ordenInsertar;

end;

PROCEDURE insertarDatos
is
begin

execute immediate' alter trigger triggerEquipo disable';
execute immediate' alter  trigger triggerEquipo2 disable';
execute immediate' alter  trigger triggerDuenyo disable';
execute immediate' alter  trigger triggerDuenyo2 disable';
execute immediate' alter  trigger triggerPartido3 disable';
execute immediate' alter  trigger triggerPartido4 disable';
execute immediate' alter  trigger triggerJugador disable';
execute immediate' alter  trigger triggerJugador2 disable';
execute immediate' alter  trigger triggerUsuario disable';
execute immediate' alter  trigger triggerUsuario2 disable';



delete from equipo;
delete from duenyo;
delete from partido;
delete from jugador;
delete from usuarios;
delete from administradores;
 

insert into equipo(nombreequi,ordeninsertar) values('equipo1',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo2',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo3',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo4',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo5',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo6',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo7',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo8',seq.nextval);

insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo1','duenyo1','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo2','duenyo2','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo3','duenyo3','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo4','duenyo4','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo5','duenyo5','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo6','duenyo6','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo7','duenyo7','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo8','duenyo8','0',seq2.nextval);

insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador1','jug1', 20000,'1','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador2','jug2', 20000,'2','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador3','jug3', 20000,'3','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador4','jug4', 30000,'4','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador5','jug5',30000,'5','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador6','jug6',30000,'6','nadie',seq3.nextval,'equipo1');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador7','jug7',40000,'7','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador8','jug8',40000,'8','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador9','jug9',40000,'9','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador10','jug10',40000,'10','nadie',seq3.nextval,'equipo1');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador11','jug11',20000,'11','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador12','jug12',20000,'12','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador13','jug13',20000,'13','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador14','jug14',50000,'14','nadie',seq3.nextval,'equipo1');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador15','jug15',50000,'15','nadie',seq3.nextval,'equipo1');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador16','jug16',60000,'16','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador17','jug17',70000,'17','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador18','jug18', 80000,'18','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador19','jug19',90000,'19','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador20','jug20', 100000,'20','nadie',seq3.nextval,'0');


insert into administradores values('admin1','admin1','admin1');
insert into administradores values('admin2','admin2','admin2');
insert into administradores values('admin3','admin3','admin3');
insert into administradores values('admin4','admin4','admin4');
insert into administradores values('admin5','admin5','admin5');
insert into administradores values('admin6','admin6','admin6');
insert into administradores values('admin7','admin7','admin7');
insert into administradores values('admin8','admin8','admin8');
insert into administradores values('admin9','admin9','admin9');

insert into usuarios values ('usuario1', 'usuario1@email.com','usuario1',seq3.nextval,'nadie');
insert into usuarios values ('usuario2', 'usuario2@email.com','usuario2',seq3.nextval,'nadie');
insert into usuarios values ('usuario3', 'usuario3@email.com','usuario3',seq3.nextval,'nadie');
insert into usuarios values ('usuario4', 'usuario4@email.com','usuario4',seq3.nextval,'nadie');
insert into usuarios values ('usuario5', 'usuario5@email.com','usuario5',seq3.nextval,'nadie');
insert into usuarios values ('usuario6', 'usuario6@email.com','usuario6',seq3.nextval,'nadie');
insert into usuarios values ('usuario7', 'usuario7@email.com','usuario7',seq3.nextval,'nadie');
insert into usuarios values ('usuario8', 'usuario8@email.com','usuario8',seq3.nextval,'nadie');
insert into usuarios values ('usuario9', 'usuario9@email.com','usuario9',seq3.nextval,'nadie');

insert into partido values('1/1/2018',1,4,0,'equipo1','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('1/1/2018',1,3,3,'equipo3','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('1/1/2018',1,4,2,'equipo4','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('1/1/2018',1,3,3,'equipo5','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('8/1/2018',2,2,1,'equipo1','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('8/1/2018',2,3,2,'equipo2','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('8/1/2018',2,2,3,'equipo4','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('8/1/2018',2,2,4,'equipo5','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('15/1/2018',3,1,2,'equipo1','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('15/1/2018',3,0,3,'equipo2','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('15/1/2018',3,0,0,'equipo5','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('15/1/2018',3,2,0,'equipo6','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('22/1/2018',4,3,2,'equipo1','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('22/1/2018',4,4,2,'equipo2','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('22/1/2018',4,2,1,'equipo3','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('22/1/2018',4,2,3,'equipo6','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('29/1/2018',5,3,2,'equipo1','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('29/1/2018',5,1,0,'equipo2','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('29/1/2018',5,0,0,'equipo3','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('29/1/2018',5,0,2,'equipo7','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/2/2018',6,1,3,'equipo1','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/2/2018',6,2,2,'equipo2','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/2/2018',6,0,1,'equipo3','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/2/2018',6,4,3,'equipo4','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/2/2018',7,2,3,'equipo1','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/2/2018',7,3,2,'equipo2','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/2/2018',7,4,2,'equipo3','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/2/2018',7,3,0,'equipo4','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/2/2018',8,0,3,'equipo2','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/2/2018',8,2,4,'equipo8','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/2/2018',8,1,0,'equipo7','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/2/2018',8,3,3,'equipo6','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/2/2018',9,2,2,'equipo6','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/2/2018',9,0,2,'equipo3','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/2/2018',9,3,4,'equipo8','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/2/2018',9,4,2,'equipo7','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/3/2018',10,3,2,'equipo3','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/3/2018',10,6,0,'equipo4','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/3/2018',10,3,3,'equipo8','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/3/2018',10,2,1,'equipo7','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/3/2018',11,3,2,'equipo7','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/3/2018',11,4,1,'equipo5','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/3/2018',11,1,1,'equipo4','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/3/2018',11,2,2,'equipo8','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/3/2018',12,3,2,'equipo4','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/3/2018',12,4,1,'equipo6','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/3/2018',12,3,2,'equipo5','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/3/2018',12,2,3,'equipo8','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/3/2018',13,3,2,'equipo8','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/3/2018',13,0,1,'equipo7','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/3/2018',13,4,1,'equipo6','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/3/2018',13,3,2,'equipo5','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('2/4/2018',14,0,3,'equipo5','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('2/4/2018',14,2,4,'equipo8','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('2/4/2018',14,3,2,'equipo7','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('2/4/2018',14,2,0,'equipo6','equipo4',seq3.nextval,'nadie', seq3.nextval);



insert into clasificacion2 values('equipo1',1,3,1,0,0);
insert into clasificacion2 values('equipo1',2,1,0,1,0);
insert into clasificacion2 values('equipo1',3,3,1,0,0);
insert into clasificacion2 values('equipo1',4,0,0,1,0);
insert into clasificacion2 values('equipo1',5,1,0,1,0);
insert into clasificacion2 values('equipo1',6,3,1,0,0);
insert into clasificacion2 values('equipo1',7,0,0,0,1);
insert into clasificacion2 values('equipo1',8,1,0,1,0);
insert into clasificacion2 values('equipo1',9,0,0,0,1);
insert into clasificacion2 values('equipo1',10,1,0,1,0);
insert into clasificacion2 values('equipo1',11,3,1,0,0);
insert into clasificacion2 values('equipo1',12,1,0,1,0);
insert into clasificacion2 values('equipo1',13,3,1,0,0);
insert into clasificacion2 values('equipo1',14,3,1,0,0);

insert into clasificacion2 values('equipo2',1,3,1,0,0);
insert into clasificacion2 values('equipo2',2,3,1,0,0);
insert into clasificacion2 values('equipo2',3,0,0,1,0);
insert into clasificacion2 values('equipo2',4,3,1,0,0);
insert into clasificacion2 values('equipo2',5,1,0,1,0);
insert into clasificacion2 values('equipo2',6,1,0,1,0);
insert into clasificacion2 values('equipo2',7,3,1,0,0);
insert into clasificacion2 values('equipo2',8,3,1,0,0);
insert into clasificacion2 values('equipo2',9,3,1,0,0);
insert into clasificacion2 values('equipo2',10,3,1,0,0);
insert into clasificacion2 values('equipo2',11,3,1,0,0);
insert into clasificacion2 values('equipo2',12,3,1,0,0);
insert into clasificacion2 values('equipo2',13,3,1,0,0);
insert into clasificacion2 values('equipo2',14,3,1,0,0);

insert into clasificacion2 values('equipo3',1,3,1,0,0);
insert into clasificacion2 values('equipo3',2,3,1,0,0);
insert into clasificacion2 values('equipo3',3,0,1,0,0);
insert into clasificacion2 values('equipo3',4,3,1,0,0);
insert into clasificacion2 values('equipo3',5,0,1,0,0);
insert into clasificacion2 values('equipo3',6,3,1,0,0);
insert into clasificacion2 values('equipo3',7,0,1,0,0);
insert into clasificacion2 values('equipo3',8,3,1,0,0);
insert into clasificacion2 values('equipo3',9,3,1,0,0);
insert into clasificacion2 values('equipo3',10,3,1,0,0);
insert into clasificacion2 values('equipo3',11,3,1,0,0);
insert into clasificacion2 values('equipo3',12,1,1,0,0);
insert into clasificacion2 values('equipo3',13,3,1,0,0);
insert into clasificacion2 values('equipo3',14,3,1,0,0);

insert into clasificacion2 values('equipo4',1,1,1,0,0);
insert into clasificacion2 values('equipo4',2,3,1,0,0);
insert into clasificacion2 values('equipo4',3,1,1,0,0);
insert into clasificacion2 values('equipo4',4,3,1,0,0);
insert into clasificacion2 values('equipo4',5,1,1,0,0);
insert into clasificacion2 values('equipo4',6,3,1,0,0);
insert into clasificacion2 values('equipo4',7,1,1,0,0);
insert into clasificacion2 values('equipo4',8,3,1,0,0);
insert into clasificacion2 values('equipo4',9,1,1,0,0);
insert into clasificacion2 values('equipo4',10,0,1,0,0);
insert into clasificacion2 values('equipo4',11,3,1,0,0);
insert into clasificacion2 values('equipo4',12,3,1,0,0);
insert into clasificacion2 values('equipo4',13,0,1,0,0);
insert into clasificacion2 values('equipo4',14,3,1,0,0);

insert into clasificacion2 values('equipo5',1,3,1,0,0);
insert into clasificacion2 values('equipo5',2,1,1,0,0);
insert into clasificacion2 values('equipo5',3,1,1,0,0);
insert into clasificacion2 values('equipo5',4,3,1,0,0);
insert into clasificacion2 values('equipo5',5,3,1,0,0);
insert into clasificacion2 values('equipo5',6,3,1,0,0);
insert into clasificacion2 values('equipo5',7,1,1,0,0);
insert into clasificacion2 values('equipo5',8,3,1,0,0);
insert into clasificacion2 values('equipo5',9,1,1,0,0);
insert into clasificacion2 values('equipo5',10,3,1,0,0);
insert into clasificacion2 values('equipo5',11,1,1,0,0);
insert into clasificacion2 values('equipo5',12,0,1,0,0);
insert into clasificacion2 values('equipo5',13,0,1,0,0);
insert into clasificacion2 values('equipo5',14,0,1,0,0);

insert into clasificacion2 values('equipo6',1,3,1,0,0);
insert into clasificacion2 values('equipo6',2,1,1,0,0);
insert into clasificacion2 values('equipo6',3,1,1,0,0);
insert into clasificacion2 values('equipo6',4,1,1,0,0);
insert into clasificacion2 values('equipo6',5,1,1,0,0);
insert into clasificacion2 values('equipo6',6,0,1,0,0);
insert into clasificacion2 values('equipo6',7,3,1,0,0);
insert into clasificacion2 values('equipo6',8,1,1,0,0);
insert into clasificacion2 values('equipo6',9,3,1,0,0);
insert into clasificacion2 values('equipo6',10,3,1,0,0);
insert into clasificacion2 values('equipo6',11,0,1,0,0);
insert into clasificacion2 values('equipo6',12,3,1,0,0);
insert into clasificacion2 values('equipo6',13,0,1,0,0);
insert into clasificacion2 values('equipo6',14,1,1,0,0);

insert into clasificacion2 values('equipo7',1,1,1,0,0);
insert into clasificacion2 values('equipo7',2,3,1,0,0);
insert into clasificacion2 values('equipo7',3,0,1,0,0);
insert into clasificacion2 values('equipo7',4,3,1,0,0);
insert into clasificacion2 values('equipo7',5,3,1,0,0);
insert into clasificacion2 values('equipo7',6,3,1,0,0);
insert into clasificacion2 values('equipo7',7,1,1,0,0);
insert into clasificacion2 values('equipo7',8,3,1,0,0);
insert into clasificacion2 values('equipo7',9,1,1,0,0);
insert into clasificacion2 values('equipo7',10,1,1,0,0);
insert into clasificacion2 values('equipo7',11,0,1,0,0);
insert into clasificacion2 values('equipo7',12,0,1,0,0);
insert into clasificacion2 values('equipo7',13,0,1,0,0);
insert into clasificacion2 values('equipo7',14,0,1,0,0);

insert into clasificacion2 values('equipo8',1,1,1,0,0);
insert into clasificacion2 values('equipo8',2,3,1,0,0);
insert into clasificacion2 values('equipo8',3,1,1,0,0);
insert into clasificacion2 values('equipo8',4,3,1,0,0);
insert into clasificacion2 values('equipo8',5,0,1,0,0);
insert into clasificacion2 values('equipo8',6,3,1,0,0);
insert into clasificacion2 values('equipo8',7,1,1,0,0);
insert into clasificacion2 values('equipo8',8,3,1,0,0);
insert into clasificacion2 values('equipo8',9,0,1,0,0);
insert into clasificacion2 values('equipo8',10,1,1,0,0);
insert into clasificacion2 values('equipo8',11,3,1,0,0);
insert into clasificacion2 values('equipo8',12,0,1,0,0);
insert into clasificacion2 values('equipo8',13,3,1,0,0);
insert into clasificacion2 values('equipo8',14,1,1,0,0);



execute immediate' alter  trigger triggerEquipo enable';
execute immediate' alter  trigger triggerEquipo2 enable';
execute immediate' alter  trigger triggerDuenyo enable';
execute immediate' alter  trigger triggerDuenyo2 enable';
execute immediate' alter  trigger triggerPartido3 enable';
execute immediate' alter  trigger triggerPartido4 enable';
execute immediate' alter  trigger triggerJugador enable';
execute immediate' alter  trigger triggerJugador2 enable';
execute immediate' alter  trigger triggerUsuario enable';
execute immediate' alter  trigger triggerUsuario2 enable';

commit;


end;

PROCEDURE eliminarDatos
is
begin
 
execute immediate' alter  trigger triggerEquipo disable';
execute immediate' alter  trigger triggerEquipo2 disable';
execute immediate' alter  trigger triggerDuenyo disable';
execute immediate' alter  trigger triggerDuenyo2 disable';
execute immediate' alter  trigger triggerPartido3 disable';
execute immediate' alter  trigger triggerPartido4 disable';
execute immediate' alter  trigger triggerJugador disable';
execute immediate' alter  trigger triggerJugador2 disable';
execute immediate' alter  trigger triggerUsuario disable';
execute immediate' alter  trigger triggerUsuario2 disable';



insert into equipo(nombreequi,ordeninsertar) values('equipo1',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo2',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo3',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo4',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo5',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo6',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo7',seq.nextval);
insert into equipo(nombreequi,ordeninsertar) values('equipo8',seq.nextval);

insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo1','duenyo1','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo2','duenyo2','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo3','duenyo3','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo4','duenyo4','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo5','duenyo5','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo6','duenyo6','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo7','duenyo7','0',seq2.nextval);
insert into duenyo(nombredue,passworddue,equidue,ordeninsertar) values('duenyo8','duenyo8','0',seq2.nextval);

insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador1','jug1', 20000,'1','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador2','jug2', 20000,'2','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador3','jug3', 20000,'3','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador4','jug4', 30000,'4','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador5','jug5',30000,'5','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador6','jug6',30000,'6','nadie',seq3.nextval,'equipo1');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador7','jug7',40000,'7','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador8','jug8',40000,'8','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador9','jug9',40000,'9','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador10','jug10',40000,'10','nadie',seq3.nextval,'equipo1');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador11','jug11',20000,'11','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador12','jug12',20000,'12','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador13','jug13',20000,'13','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador14','jug14',50000,'14','nadie',seq3.nextval,'equipo1');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador15','jug15',50000,'15','nadie',seq3.nextval,'equipo1');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador16','jug16',60000,'16','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador17','jug17',70000,'17','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador18','jug18', 80000,'18','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador19','jug19',90000,'19','nadie',seq3.nextval,'0');
insert into jugador (nombrejug, nick,sueldo,dnijug, administradoroduenyo,numaccion,CodigoEquiJug) values ('jugador20','jug20', 100000,'20','nadie',seq3.nextval,'0');

insert into partido values('1/1/2018','1','2','1','equipo1','equipo2',seq3.nextval, 'nadie',seq3.nextval);
insert into partido values('1/1/2018','1','4','2','equipo3','equipo8',seq3.nextval, 'nadie',seq3.nextval);
insert into partido values('1/1/2018','1','1','1','equipo4','equipo7',seq3.nextval, 'nadie',seq3.nextval);
insert into partido values('1/1/2018','1','0','1','equipo5','equipo6',seq3.nextval, 'nadie',seq3.nextval);
insert into partido values('8/1/2018','2','1','1','','',seq3.nextval, 'nadie',seq3.nextval);
insert into partido values('8/1/2018','2','1','1','','',seq3.nextval, 'nadie',seq3.nextval);
insert into partido values('8/1/2018','2','1','1','','',seq3.nextval, 'nadie',seq3.nextval);
insert into partido values('8/1/2018','2','1','1','','',seq3.nextval, 'nadie',seq3.nextval);
insert into partido values('15/1/2018','3','1','1','','',seq3.nextval, 'nadie',seq3.nextval);
insert into partido values('15/1/2018','3','1','1','','',seq3.nextval, 'nadie',seq3.nextval);
insert into partido values('15/1/2018','3','1','1','','',seq3.nextval, 'nadie',seq3.nextval);
insert into partido values('15/1/2018','3','1','1','','',seq3.nextval, 'nadie',seq3.nextval);

insert into administradores values('admin1','admin1','admin1');
insert into administradores values('admin2','admin2','admin2');
insert into administradores values('admin3','admin3','admin3');
insert into administradores values('admin4','admin4','admin4');
insert into administradores values('admin5','admin5','admin5');
insert into administradores values('admin6','admin6','admin6');
insert into administradores values('admin7','admin7','admin7');
insert into administradores values('admin8','admin8','admin8');
insert into administradores values('admin9','admin9','admin9');



insert into usuarios values ('usuario1', 'usuario1@email.com','usuario1',seq3.nextval,'nadie');
insert into usuarios values ('usuario2', 'usuario2@email.com','usuario2',seq3.nextval,'nadie');
insert into usuarios values ('usuario3', 'usuario3@email.com','usuario3',seq3.nextval,'nadie');
insert into usuarios values ('usuario4', 'usuario4@email.com','usuario4',seq3.nextval,'nadie');
insert into usuarios values ('usuario5', 'usuario5@email.com','usuario5',seq3.nextval,'nadie');
insert into usuarios values ('usuario6', 'usuario6@email.com','usuario6',seq3.nextval,'nadie');
insert into usuarios values ('usuario7', 'usuario7@email.com','usuario7',seq3.nextval,'nadie');
insert into usuarios values ('usuario8', 'usuario8@email.com','usuario8',seq3.nextval,'nadie');
insert into usuarios values ('usuario9', 'usuario9@email.com','usuario9',seq3.nextval,'nadie');


insert into partido values('1/1/2018',1,4,0,'equipo1','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('1/1/2018',1,3,3,'equipo3','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('1/1/2018',1,4,2,'equipo4','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('1/1/2018',1,3,3,'equipo5','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('8/1/2018',2,2,1,'equipo1','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('8/1/2018',2,3,2,'equipo2','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('8/1/2018',2,2,3,'equipo4','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('8/1/2018',2,2,4,'equipo5','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('15/1/2018',3,1,2,'equipo1','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('15/1/2018',3,0,3,'equipo2','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('15/1/2018',3,0,0,'equipo5','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('15/1/2018',3,2,0,'equipo6','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('22/1/2018',4,3,2,'equipo1','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('22/1/2018',4,4,2,'equipo2','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('22/1/2018',4,2,1,'equipo3','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('22/1/2018',4,2,3,'equipo6','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('29/1/2018',5,3,2,'equipo1','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('29/1/2018',5,1,0,'equipo2','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('29/1/2018',5,0,0,'equipo3','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('29/1/2018',5,0,2,'equipo7','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/2/2018',6,1,3,'equipo1','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/2/2018',6,2,2,'equipo2','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/2/2018',6,0,1,'equipo3','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/2/2018',6,4,3,'equipo4','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/2/2018',7,2,3,'equipo1','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/2/2018',7,3,2,'equipo2','equipo8',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/2/2018',7,4,2,'equipo3','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/2/2018',7,3,0,'equipo4','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/2/2018',8,0,3,'equipo2','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/2/2018',8,2,4,'equipo8','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/2/2018',8,1,0,'equipo7','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/2/2018',8,3,3,'equipo6','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/2/2018',9,2,2,'equipo6','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/2/2018',9,0,2,'equipo3','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/2/2018',9,3,4,'equipo8','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/2/2018',9,4,2,'equipo7','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/3/2018',10,3,2,'equipo3','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/3/2018',10,6,0,'equipo4','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/3/2018',10,3,3,'equipo8','equipo5',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('5/3/2018',10,2,1,'equipo7','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/3/2018',11,3,2,'equipo7','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/3/2018',11,4,1,'equipo5','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/3/2018',11,1,1,'equipo4','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('12/3/2018',11,2,2,'equipo8','equipo6',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/3/2018',12,3,2,'equipo4','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/3/2018',12,4,1,'equipo6','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/3/2018',12,3,2,'equipo5','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('19/3/2018',12,2,3,'equipo8','equipo7',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/3/2018',13,3,2,'equipo8','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/3/2018',13,0,1,'equipo7','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/3/2018',13,4,1,'equipo6','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('26/3/2018',13,3,2,'equipo5','equipo4',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('2/4/2018',14,0,3,'equipo5','equipo1',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('2/4/2018',14,2,4,'equipo8','equipo2',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('2/4/2018',14,3,2,'equipo7','equipo3',seq3.nextval,'nadie', seq3.nextval);
insert into partido values('2/4/2018',14,2,0,'equipo6','equipo4',seq3.nextval,'nadie', seq3.nextval);


insert into clasificacion2 values('equipo1',1,3,1,0,0);
insert into clasificacion2 values('equipo1',2,1,0,1,0);
insert into clasificacion2 values('equipo1',3,3,1,0,0);
insert into clasificacion2 values('equipo1',4,0,0,1,0);
insert into clasificacion2 values('equipo1',5,1,0,1,0);
insert into clasificacion2 values('equipo1',6,3,1,0,0);
insert into clasificacion2 values('equipo1',7,0,0,0,1);
insert into clasificacion2 values('equipo1',8,1,0,1,0);
insert into clasificacion2 values('equipo1',9,0,0,0,1);
insert into clasificacion2 values('equipo1',10,1,0,1,0);
insert into clasificacion2 values('equipo1',11,3,1,0,0);
insert into clasificacion2 values('equipo1',12,1,0,1,0);
insert into clasificacion2 values('equipo1',13,3,1,0,0);
insert into clasificacion2 values('equipo1',14,3,1,0,0);

insert into clasificacion2 values('equipo2',1,3,1,0,0);
insert into clasificacion2 values('equipo2',2,3,1,0,0);
insert into clasificacion2 values('equipo2',3,0,0,1,0);
insert into clasificacion2 values('equipo2',4,3,1,0,0);
insert into clasificacion2 values('equipo2',5,1,0,1,0);
insert into clasificacion2 values('equipo2',6,1,0,1,0);
insert into clasificacion2 values('equipo2',7,3,1,0,0);
insert into clasificacion2 values('equipo2',8,3,1,0,0);
insert into clasificacion2 values('equipo2',9,3,1,0,0);
insert into clasificacion2 values('equipo2',10,3,1,0,0);
insert into clasificacion2 values('equipo2',11,3,1,0,0);
insert into clasificacion2 values('equipo2',12,3,1,0,0);
insert into clasificacion2 values('equipo2',13,3,1,0,0);
insert into clasificacion2 values('equipo2',14,3,1,0,0);

insert into clasificacion2 values('equipo3',1,3,1,0,0);
insert into clasificacion2 values('equipo3',2,3,1,0,0);
insert into clasificacion2 values('equipo3',3,0,1,0,0);
insert into clasificacion2 values('equipo3',4,3,1,0,0);
insert into clasificacion2 values('equipo3',5,0,1,0,0);
insert into clasificacion2 values('equipo3',6,3,1,0,0);
insert into clasificacion2 values('equipo3',7,0,1,0,0);
insert into clasificacion2 values('equipo3',8,3,1,0,0);
insert into clasificacion2 values('equipo3',9,3,1,0,0);
insert into clasificacion2 values('equipo3',10,3,1,0,0);
insert into clasificacion2 values('equipo3',11,3,1,0,0);
insert into clasificacion2 values('equipo3',12,1,1,0,0);
insert into clasificacion2 values('equipo3',13,3,1,0,0);
insert into clasificacion2 values('equipo3',14,3,1,0,0);

insert into clasificacion2 values('equipo4',1,1,1,0,0);
insert into clasificacion2 values('equipo4',2,3,1,0,0);
insert into clasificacion2 values('equipo4',3,1,1,0,0);
insert into clasificacion2 values('equipo4',4,3,1,0,0);
insert into clasificacion2 values('equipo4',5,1,1,0,0);
insert into clasificacion2 values('equipo4',6,3,1,0,0);
insert into clasificacion2 values('equipo4',7,1,1,0,0);
insert into clasificacion2 values('equipo4',8,3,1,0,0);
insert into clasificacion2 values('equipo4',9,1,1,0,0);
insert into clasificacion2 values('equipo4',10,0,1,0,0);
insert into clasificacion2 values('equipo4',11,3,1,0,0);
insert into clasificacion2 values('equipo4',12,3,1,0,0);
insert into clasificacion2 values('equipo4',13,0,1,0,0);
insert into clasificacion2 values('equipo4',14,3,1,0,0);

insert into clasificacion2 values('equipo5',1,3,1,0,0);
insert into clasificacion2 values('equipo5',2,1,1,0,0);
insert into clasificacion2 values('equipo5',3,1,1,0,0);
insert into clasificacion2 values('equipo5',4,3,1,0,0);
insert into clasificacion2 values('equipo5',5,3,1,0,0);
insert into clasificacion2 values('equipo5',6,3,1,0,0);
insert into clasificacion2 values('equipo5',7,1,1,0,0);
insert into clasificacion2 values('equipo5',8,3,1,0,0);
insert into clasificacion2 values('equipo5',9,1,1,0,0);
insert into clasificacion2 values('equipo5',10,3,1,0,0);
insert into clasificacion2 values('equipo5',11,1,1,0,0);
insert into clasificacion2 values('equipo5',12,0,1,0,0);
insert into clasificacion2 values('equipo5',13,0,1,0,0);
insert into clasificacion2 values('equipo5',14,0,1,0,0);

insert into clasificacion2 values('equipo6',1,3,1,0,0);
insert into clasificacion2 values('equipo6',2,1,1,0,0);
insert into clasificacion2 values('equipo6',3,1,1,0,0);
insert into clasificacion2 values('equipo6',4,1,1,0,0);
insert into clasificacion2 values('equipo6',5,1,1,0,0);
insert into clasificacion2 values('equipo6',6,0,1,0,0);
insert into clasificacion2 values('equipo6',7,3,1,0,0);
insert into clasificacion2 values('equipo6',8,1,1,0,0);
insert into clasificacion2 values('equipo6',9,3,1,0,0);
insert into clasificacion2 values('equipo6',10,3,1,0,0);
insert into clasificacion2 values('equipo6',11,0,1,0,0);
insert into clasificacion2 values('equipo6',12,3,1,0,0);
insert into clasificacion2 values('equipo6',13,0,1,0,0);
insert into clasificacion2 values('equipo6',14,1,1,0,0);

insert into clasificacion2 values('equipo7',1,1,1,0,0);
insert into clasificacion2 values('equipo7',2,3,1,0,0);
insert into clasificacion2 values('equipo7',3,0,1,0,0);
insert into clasificacion2 values('equipo7',4,3,1,0,0);
insert into clasificacion2 values('equipo7',5,3,1,0,0);
insert into clasificacion2 values('equipo7',6,3,1,0,0);
insert into clasificacion2 values('equipo7',7,1,1,0,0);
insert into clasificacion2 values('equipo7',8,3,1,0,0);
insert into clasificacion2 values('equipo7',9,1,1,0,0);
insert into clasificacion2 values('equipo7',10,1,1,0,0);
insert into clasificacion2 values('equipo7',11,0,1,0,0);
insert into clasificacion2 values('equipo7',12,0,1,0,0);
insert into clasificacion2 values('equipo7',13,0,1,0,0);
insert into clasificacion2 values('equipo7',14,0,1,0,0);

insert into clasificacion2 values('equipo8',1,1,1,0,0);
insert into clasificacion2 values('equipo8',2,3,1,0,0);
insert into clasificacion2 values('equipo8',3,1,1,0,0);
insert into clasificacion2 values('equipo8',4,3,1,0,0);
insert into clasificacion2 values('equipo8',5,0,1,0,0);
insert into clasificacion2 values('equipo8',6,3,1,0,0);
insert into clasificacion2 values('equipo8',7,1,1,0,0);
insert into clasificacion2 values('equipo8',8,3,1,0,0);
insert into clasificacion2 values('equipo8',9,0,1,0,0);
insert into clasificacion2 values('equipo8',10,1,1,0,0);
insert into clasificacion2 values('equipo8',11,3,1,0,0);
insert into clasificacion2 values('equipo8',12,0,1,0,0);
insert into clasificacion2 values('equipo8',13,3,1,0,0);
insert into clasificacion2 values('equipo8',14,1,1,0,0);




execute immediate' alter  trigger triggerEquipo enable';
execute immediate' alter  trigger triggerEquipo2 enable';
execute immediate' alter  trigger triggerDuenyo enable';
execute immediate' alter  trigger triggerDuenyo2 enable';
execute immediate' alter  trigger triggerPartido3 enable';
execute immediate' alter  trigger triggerPartido4 enable';
execute immediate' alter  trigger triggerJugador enable';
execute immediate' alter  trigger triggerJugador2 enable';
execute immediate' alter  trigger triggerUsuario enable';
execute immediate' alter  trigger triggerUsuario2 enable';

commit;

end;
end;
/
commit;


select * from clasificacion2;
