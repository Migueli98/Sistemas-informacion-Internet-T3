ALTER TABLE ACTIVIDADES DROP FOREIGN KEY FK_ACTIVIDADES_servicio
ALTER TABLE SERVICIOS DROP FOREIGN KEY FK_SERVICIOS_ong
ALTER TABLE ASIGNATURAS DROP FOREIGN KEY FK_ASIGNATURAS_centro
ALTER TABLE CURRICULUM DROP FOREIGN KEY FK_CURRICULUM_ALUMNO_EMAIL
ALTER TABLE INFORMEACTIVIDADES DROP FOREIGN KEY FK_INFORMEACTIVIDADES_alumno
ALTER TABLE INFORMEACTIVIDADES DROP FOREIGN KEY FK_INFORMEACTIVIDADES_actividades
ALTER TABLE INFORMEACTIVIDADES DROP FOREIGN KEY FK_INFORMEACTIVIDADES_profesorAsociado
ALTER TABLE INSCRIPCIONES DROP FOREIGN KEY FK_INSCRIPCIONES_usuario
ALTER TABLE INSCRIPCIONES DROP FOREIGN KEY FK_INSCRIPCIONES_actividad
ALTER TABLE SERVICIOS_ASIGNATURAS DROP FOREIGN KEY FK_SERVICIOS_ASIGNATURAS_servicios_CODIGOSERVICIO
ALTER TABLE SERVICIOS_ASIGNATURAS DROP FOREIGN KEY SERVICIOS_ASIGNATURAS_asignaturas_CODIGOASIGNATURA
ALTER TABLE USUARIO_ASIGNATURAS DROP FOREIGN KEY FK_USUARIO_ASIGNATURAS_imparte_CODIGOASIGNATURA
ALTER TABLE USUARIO_ASIGNATURAS DROP FOREIGN KEY FK_USUARIO_ASIGNATURAS_estaCursando_EMAIL
ALTER TABLE USUARIO_ASIGNATURAS DROP FOREIGN KEY FK_USUARIO_ASIGNATURAS_impartidoPor_EMAIL
ALTER TABLE USUARIO_ASIGNATURAS DROP FOREIGN KEY USUARIO_ASIGNATURAS_matriculadoEn_CODIGOASIGNATURA
ALTER TABLE CURRICULUM_ASIGNATURAS DROP FOREIGN KEY FK_CURRICULUM_ASIGNATURAS_incluidasEn_ID
ALTER TABLE CURRICULUM_ASIGNATURAS DROP FOREIGN KEY CURRICULUM_ASIGNATURAScompuestoDe_CODIGOASIGNATURA
DROP TABLE ACTIVIDADES
DROP TABLE USUARIO
DROP TABLE SERVICIOS
DROP TABLE ASIGNATURAS
DROP TABLE CENTRO
DROP TABLE CURRICULUM
DROP TABLE INFORMEACTIVIDADES
DROP TABLE INSCRIPCIONES
DROP TABLE SERVICIOS_ASIGNATURAS
DROP TABLE USUARIO_ASIGNATURAS
DROP TABLE CURRICULUM_ASIGNATURAS
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
