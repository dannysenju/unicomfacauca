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

INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('1', '7AM -9AM', 'lunes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('2', '9AM -11AM', 'lunes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('3', '11AM -1PM', 'lunes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('4', '2PM -4PM', 'lunes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('5', '4PM -6PM', 'lunes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('6', '6PM -8PM', 'lunes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('7', '8PM -10PM', 'lunes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('8', '7AM -9AM', 'martes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('9', '9AM -11AM', 'martes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('10', '11AM -1PM', 'martes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('11', '2PM -4PM', 'martes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('12', '4PM -6PM', 'martes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('13', '6PM -8PM', 'martes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('14', '8PM -10PM', 'martes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('16', '7AM -9AM', 'miercoles');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('17', '9AM -11AM', 'miercoles');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('18', '11AM -1PM', 'miercoles');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('19', '2PM -4PM', 'miercoles');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('20', '4PM -6PM', 'miercoles');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('21', '6PM -8PM', 'miercoles');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('22', '8PM -10PM', 'miercoles');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('23', '7AM -9AM', 'jueves');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('24', '9AM -11AM', 'jueves');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('25', '11AM -1PM', 'jueves');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('26', '2PM -4PM', 'jueves');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('27', '4PM -6PM', 'jueves');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('28', '6PM -8PM', 'jueves');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('29', '8PM -10PM', 'jueves');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('30', '7AM -9AM', 'viernes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('31', '9AM -11AM', 'viernes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('32', '11AM -1PM', 'viernes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('33', '2PM -4PM', 'viernes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('34', '4PM -6PM', 'viernes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('35', '6PM -8PM', 'viernes');
INSERT INTO horario (idhorario, bloque_horario, dia_semana) VALUES ('36', '8PM -10PM', 'viernes');

INSERT INTO materia (idmateria, nombre, semestre, numero_creditos, idprograma) VALUES ('1', 'fisica 1', '1', '3', '1');
INSERT INTO materia (idmateria, nombre, semestre, numero_creditos, idprograma) VALUES ('7', 'fisica 1', '1', '3', '2');
INSERT INTO materia (idmateria, nombre, semestre, numero_creditos, idprograma) VALUES ('2', 'calculo 1', '1', '3', '1');
INSERT INTO materia (idmateria, nombre, semestre, numero_creditos, idprograma) VALUES ('8', 'calculo 1', '1', '3', '2');
INSERT INTO materia (idmateria, nombre, semestre, numero_creditos, idprograma) VALUES ('5', 'fisica 2', '2', '3', '2');
INSERT INTO materia (idmateria, nombre, semestre, numero_creditos, idprograma) VALUES ('9', 'fisica 2', '2', '3', '1');
INSERT INTO materia (idmateria, nombre, semestre, numero_credito, idprogramas) VALUES ('6', 'calculo 2', '2', '3', '2');
INSERT INTO materia (idmateria, nombre, semestre, numero_credito, idprogramas) VALUES ('10', 'calculo 2', '2', '3', '1');
INSERT INTO materia (idmateria, nombre, semestre, numero_creditos, idprograma) VALUES ('3', 'finanzas', '2', '3', '3');
INSERT INTO materia (idmateria, nombre, semestre, numero_creditos, idprograma) VALUES ('11', 'finanzas', '2', '3', '4');
INSERT INTO materia (idmateria, nombre, semestre, numero_creditos, idprograma) VALUES ('12', 'economia', '1', '2', '3');
INSERT INTO materia (idmateria, nombre, semestre, numero_creditos, idprograma) VALUES ('4', 'economia', '1', '2', '4');

INSERT INTO materia_horario (idmateria, idhorario_ini, idhorario_fin) VALUES ('1', '1', '31');
INSERT INTO materia_horario (idmateria, idhorario_ini, idhorario_fin) VALUES ('1', '8', '20');
INSERT INTO materia_horario (idmateria, idhorario_ini, idhorario_fin) VALUES ('7', '10', '25');
INSERT INTO materia_horario (idmateria, idhorario_ini, idhorario_fin) VALUES ('7', '12', '21');
INSERT INTO materia_horario (idmateria, idhorario_ini, idhorario_fin) VALUES ('2', '11', '32');
INSERT INTO materia_horario (idmateria, idhorario_ini, idhorario_fin) VALUES ('2', '18', '28');
INSERT INTO materia_horario (idmateria, idhorario_ini, idhorario_fin) VALUES ('8', '13', '29');
INSERT INTO materia_horario (idmateria, idhorario_ini, idhorario_fin) VALUES ('8', '3', '24');
INSERT INTO materia_horario (idmateria, idhorario_ini, idhorario_fin) VALUES ('5', '4', '29');
INSERT INTO materia_horario (idmateria, idhorario_ini, idhorario_fin) VALUES ('5', '1', '24');
INSERT INTO materia_horario (idmateria, idhorario_ini, idhorario_fin) VALUES ('9', '11', '29');
INSERT INTO materia_horario (idmateria, idhorario_ini, idhorario_fin) VALUES ('9', '31', '2');
INSERT INTO materia_horario (idmateria, idhorario_ini, idhorario_fin) VALUES ('6', '4', '29');
INSERT INTO materia_horario (idmateria, idhorario_ini, idhorario_fin) VALUES ('6', '1', '24');
INSERT INTO materia_horario (idmateria, idhorario_ini, idhorario_fin) VALUES ('10', '11', '29');
INSERT INTO materia_horario (idmateria, idhorario_ini, idhorario_fin) VALUES ('10', '31', '2');

INSERT INTO estudiante (idestudiante, nombre, apellido, email, idprograma) VALUES ('1', 'carlos', 'perez', 'd@d.com', '1');
INSERT INTO estudiante (idestudiante, nombre, apellido, email, idprograma) VALUES ('2', 'diana', 'pasate', 'd@dd.com', '2');










