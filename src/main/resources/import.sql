INSERT INTO usuario (idusuario, nombre_completo, username, password, rol, activo, email) VALUES (1, 'Super Admin', 'ADMIN', 'ba71596f5265b217fb889dc2f71693ea796fb590788ac4644c39db67ba06bbc13b7440b1a01c6a500f3f5868ba1430cc2a4a4a91c4a9d986b7c90634a0993877', 'ADMIN', 1, 'dannysenju@gmail.com');
INSERT INTO usuario (idusuario, nombre_completo, username, password, rol, activo, email) VALUES (2, 'Usuario de Test', 'TEST', 'ba71596f5265b217fb889dc2f71693ea796fb590788ac4644c39db67ba06bbc13b7440b1a01c6a500f3f5868ba1430cc2a4a4a91c4a9d986b7c90634a0993877', 'FUNC', 1, 'dannysenju@gmail.com');
INSERT INTO usuario (idusuario, nombre_completo, username, password, rol, activo, email) VALUES (-1, 'Jhon Snow', 'JHON', 'ba71596f5265b217fb889dc2f71693ea796fb590788ac4644c39db67ba06bbc13b7440b1a01c6a500f3f5868ba1430cc2a4a4a91c4a9d986b7c90634a0993877', 'FUNC', 0, 'dannysenju@gmail.com');

INSERT INTO modulo (idmodulo, nombre, descripcion, activo, url, icono) VALUES (1, 'matriculas', 'Información de compras', 1, '/views/matricula/matricula.xhtml', 'fa fa-edit');


INSERT INTO modulo_usuario (id_modulo, id_usuario) VALUES (1, 1);
INSERT INTO modulo_usuario (id_modulo, id_usuario) VALUES (1, 2);
INSERT INTO modulo_usuario (id_modulo, id_usuario) VALUES (1, -1);

INSERT INTO tipo_semestre (idtipo_semestre, numero_creditos, activo) VALUES ('1', '9', '1');
INSERT INTO tipo_semestre (idtipo_semestre, numero_creditos, activo) VALUES ('2', '10', '1');

INSERT INTO programa (idprograma, nombre, idtipo_semestre) VALUES ('1', 'sistemas', '1');
INSERT INTO programa (idprograma, nombre, idtipo_semestre) VALUES ('2', 'sistemas', '2');
INSERT INTO programa (idprograma, nombre, idtipo_semestre) VALUES ('3', 'contaduria', '1');
INSERT INTO programa (idprograma, nombre, idtipo_semestre) VALUES ('4', 'contaduria', '2');

INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('1', '7 AM - 12M', 'lunes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('2', '7AM - 12M', 'martes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('3', '7AM - 12M', 'miercoles');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('4', '7AM - 12M', 'jueves');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('5', '7AM - 12M', 'viernes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('7', '2PM-6PM', 'lunes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('8', '2PM-6PM', 'martes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('9', '2PM-6PM', 'miercoles');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('10', '2PM-6PM', 'jueves');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('11', '2PM-6PM', 'viernes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('12', '6PM-10PM', 'lunes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('13', '6PM-10PM', 'martes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('14', '6PM-10PM', 'miercoles');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('15','6PM-10PM', 'jueves');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('16','6PM-10PM', 'viernes');


INSERT INTO materia (idmateria, nombre, semestre, numero_creditos, idprograma) VALUES ('1', 'fisica 1', '1', '3', '1');
INSERT INTO materia (idmateria, nombre, semestre, numero_creditos, idprograma) VALUES ('2', 'calculo 1', '1', '3', '1');
INSERT INTO materia (idmateria, nombre, semestre, numero_creditos, idprograma) VALUES ('5', 'fisica 2', '2', '3', '2');
INSERT INTO materia (idmateria, nombre, semestre, numero_credito, idprogramas) VALUES ('6', 'calculo 2', '2', '3', '2');
INSERT INTO materia (idmateria, nombre, semestre, numero_creditos, idprograma) VALUES ('3', 'finanzas', '2', '3', '3');
INSERT INTO materia (idmateria, nombre, semestre, numero_creditos, idprograma) VALUES ('4', 'economia', '1', '2', '3');

INSERT INTO materia_horario (idmateria, idhorario) VALUES ('2', '3');
INSERT INTO materia_horario (idmateria, idhorario) VALUES ('2', '4');
INSERT INTO materia_horario (idmateria, idhorario) VALUES ('1', '1');
INSERT INTO materia_horario (idmateria, idhorario) VALUES ('1', '2');
INSERT INTO materia_horario (idmateria, idhorario) VALUES ('3', '7');
INSERT INTO materia_horario (idmateria, idhorario) VALUES ('3', '9');

INSERT INTO estudiante (idestudiante, nombre, apellido, email, idprograma) VALUES ('1', 'carlos', 'perez', 'd@d.com', '1');
INSERT INTO estudiante (idestudiante, nombre, apellido, email, idprograma) VALUES ('2', 'diana', 'pasate', 'd@dd.com', '2');










