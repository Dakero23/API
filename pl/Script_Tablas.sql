drop table empresa 			 	CASCADE CONSTRAINTS;
drop table TIPO_DOCUMENTO    	CASCADE CONSTRAINTS;
drop table INFORMACION_BASICA	CASCADE CONSTRAINTS;
drop table TIPO_USUARIO 		CASCADE CONSTRAINTS;
drop table USUARIO 				CASCADE CONSTRAINTS;
drop table TIPO_TARJETA 		CASCADE CONSTRAINTS;
drop table TARJETA  			CASCADE CONSTRAINTS;
drop table SERVICIOS			CASCADE CONSTRAINTS;
drop table TOKEN				CASCADE CONSTRAINTS;
drop table SERVICIOS_TOKEN		CASCADE CONSTRAINTS;
/
CREATE TABLE empresa (
    emp_id    NUMBER NOT NULL,
    tip_doc   VARCHAR2(2) NOT NULL,
    emp_doc   NUMBER NOT NULL,
    emp_nom   VARCHAR2(60) NOT NULL
);

COMMENT ON COLUMN empresa.emp_id IS  'Identificado primario tabla empresa';
COMMENT ON COLUMN empresa.tip_doc IS 'llave foranea de tipo documento';
COMMENT ON COLUMN empresa.emp_doc IS 'numero del documento nit de la empresa';
COMMENT ON COLUMN empresa.emp_nom IS 'nombre de la empresa';

ALTER TABLE empresa ADD CONSTRAINT empresa_pk PRIMARY KEY ( emp_id );

CREATE TABLE informacion_basica (
    inb_id          NUMBER NOT NULL,
    tip_doc         VARCHAR2(2) NOT NULL,
    inb_documento   NUMBER,
    inb_nombre      VARCHAR2(60),
    inb_apellido    VARCHAR2(60),
    inb_correo      VARCHAR2(120),
    inb_celular     NUMBER,
    inb_telefono    NUMBER,
    inb_direccion   VARCHAR2(60),
    aud_fecha       DATE DEFAULT SYSDATE,
    aud_usuario     VARCHAR2(60) DEFAULT USER

);

COMMENT ON COLUMN informacion_basica.inb_id        IS 'llave primaria de la tabla informacion basica';
COMMENT ON COLUMN informacion_basica.tip_doc       IS 'llave foranea de la tabla tipo documento';
COMMENT ON COLUMN informacion_basica.inb_documento IS 'numero de documento';
COMMENT ON COLUMN informacion_basica.inb_nombre    IS 'Nombre de usuario';
COMMENT ON COLUMN informacion_basica.inb_apellido  IS 'Apellido del usuario';
COMMENT ON COLUMN informacion_basica.inb_correo    IS 'correo donde llegara la actualización del token';
COMMENT ON COLUMN informacion_basica.inb_celular   IS 'Celular del usuario';
COMMENT ON COLUMN informacion_basica.inb_telefono  IS 'telefono del usuario';
COMMENT ON COLUMN informacion_basica.inb_direccion IS 'direccion residencia';
COMMENT ON COLUMN informacion_basica.aud_fecha   IS 'fecha de Auditoria en la que se ingresa el registro';
COMMENT ON COLUMN informacion_basica.aud_usuario IS 'usuario que registra la transaccion de creacion';


ALTER TABLE informacion_basica ADD CONSTRAINT informacion_basica_pk PRIMARY KEY ( inb_id );

CREATE TABLE servicios (
    srv_id            NUMBER NOT NULL,
    srv_nombre        VARCHAR2(60),
    srv_descripcion   VARCHAR2(254),
    srv_fec_vig       DATE,
    srv_version       VARCHAR2(3),
    aud_fecha         DATE DEFAULT SYSDATE,
    aud_usuario       VARCHAR2(60) DEFAULT USER
);

COMMENT ON COLUMN servicios.srv_id IS 'llave primaria de servicio';
COMMENT ON COLUMN servicios.srv_nombre IS 'Nombre del servicio desarrollado';
COMMENT ON COLUMN servicios.srv_descripcion IS'Descripción breve del funcionamiento del servicio';
COMMENT ON COLUMN servicios.srv_fec_vig IS 'Fecha de vigencia del servicio';
COMMENT ON COLUMN servicios.srv_version IS 'Versión del servicio';
COMMENT ON COLUMN servicios.aud_fecha IS 'fecha de Auditoria en la que se ingresa el registro';
COMMENT ON COLUMN servicios.aud_usuario IS 'usuario que registra la transaccion de creacion';

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( srv_id );

CREATE TABLE servicios_token (
    srt_id       NUMBER NOT NULL,
    tkn_id       NUMBER NOT NULL,
    srv_id       NUMBER NOT NULL,
    srt_estado   CHAR(1),
    aud_fecha       DATE DEFAULT SYSDATE,
    aud_usuario     VARCHAR2(60) DEFAULT USER
);

COMMENT ON COLUMN servicios_token.srt_estado IS 'valores posibles :[1]Accesible[2]Sin acceso SE CREA CHECK CONTRAINT';

ALTER TABLE SERVICIOS_TOKEN ADD CONSTRAINT SERVICIOS_TOKEN_PK PRIMARY KEY (SRT_ID) ENABLE;
ALTER TABLE SERVICIOS_TOKEN ADD CONSTRAINT SERVICIOS_TOKEN_CHK1 CHECK (SRT_ESTADO IN (1,2)) ENABLE;

CREATE TABLE tarjeta (
    tar_id        NUMBER NOT NULL,
    ttj_id        NUMBER NOT NULL,
    usu_id        NUMBER NOT NULL,
    tar_numero    NUMBER,
    tar_nombre    VARCHAR2(60),
    tar_fec_exp   VARCHAR2(4), 
    tar_cod_seg   NUMBER(3),
    aud_fecha     DATE DEFAULT SYSDATE,
    aud_usuario   VARCHAR2(60) DEFAULT USER
);
COMMENT ON COLUMN tarjeta.tar_id      IS 'llave primaria de la tabla tarjeta';
COMMENT ON COLUMN tarjeta.ttj_id      IS 'llave foranea perteneciente a la tabla tipo_tarjeta ';
COMMENT ON COLUMN tarjeta.usu_id      IS 'llave foranea perteneciente a la tabla usuario';
COMMENT ON COLUMN tarjeta.tar_numero  IS 'numero de la tarjeta';
COMMENT ON COLUMN tarjeta.tar_nombre  IS 'nombre del titular de la tarjeta';
COMMENT ON COLUMN tarjeta.tar_fec_exp IS 'fecha de expedicion de la tarjeta';
COMMENT ON COLUMN tarjeta.tar_cod_seg IS 'Codigo de seguridad encontrado en la parte de atras de la tarjeta';
COMMENT ON COLUMN tarjeta.aud_usuario IS 'usuario o aplicacion  que crea registro auditoria';
COMMENT ON COLUMN tarjeta.aud_fecha   IS 'sysdate de creacion del registro';

ALTER TABLE tarjeta ADD CONSTRAINT tarjeta_pk PRIMARY KEY ( tar_id );

CREATE TABLE tipo_documento (
    tip_doc      VARCHAR2(2) NOT NULL,
    tip_nombre   VARCHAR2(60)
);

COMMENT ON COLUMN tipo_documento.tip_doc IS 'TIPO DOCUMENTO';
COMMENT ON COLUMN tipo_documento.tip_nombre IS 'NOMBRE DEL DOCUMENTO';

ALTER TABLE tipo_documento ADD CONSTRAINT tipo_documento_pk PRIMARY KEY ( tip_doc );

CREATE TABLE tipo_tarjeta (
    ttj_id        NUMBER NOT NULL,
    ttj_nombre    VARCHAR2(30),
    aud_fecha       DATE DEFAULT SYSDATE,
    aud_usuario     VARCHAR2(60) DEFAULT USER
);

COMMENT ON COLUMN tipo_tarjeta.ttj_id      IS 'llave primaria la ttj_id';
COMMENT ON COLUMN tipo_tarjeta.ttj_nombre  IS 'tipo de tarjeta ejmeplo [Debito ò Credito]';
COMMENT ON COLUMN tipo_tarjeta.aud_usuario IS 'usuario o aplicacion  que crea registro auditoria';
COMMENT ON COLUMN tipo_tarjeta.aud_fecha   IS 'sysdate de creacion del registro';



ALTER TABLE tipo_tarjeta ADD CONSTRAINT tipo_tarjeta_pk PRIMARY KEY ( ttj_id );

CREATE TABLE tipo_usuario (
    tpu_id            NUMBER NOT NULL,
    tpu_descripcion   VARCHAR2(60)
);
COMMENT ON COLUMN tipo_usuario.tpu_id IS 'llave primaria la tabla tipo_usuario';;
COMMENT ON COLUMN tipo_usuario.tpu_descripcion IS 'TIPO DE USUARIO';

ALTER TABLE tipo_usuario ADD CONSTRAINT tipo_usuario_pk PRIMARY KEY ( tpu_id );

CREATE TABLE token (
    tkn_id        NUMBER NOT NULL,
    usu_id        NUMBER NOT NULL,
    tkn_token     VARCHAR2(254),
    tkn_fec_vig   DATE,
    aud_fecha       DATE DEFAULT SYSDATE,
    aud_usuario     VARCHAR2(60) DEFAULT USER
);

COMMENT ON COLUMN token.tkn_id      IS 'llave primaria de la tabla token';
COMMENT ON COLUMN token.usu_id      IS 'llave foranea de la tabla credenciales';
COMMENT ON COLUMN token.tkn_token   IS 'token designado a unas credenciales en especifico';
COMMENT ON COLUMN token.tkn_fec_vig IS 'Fecha de vigencia hasta cuando estara habilitado dicho token';
COMMENT ON COLUMN token.aud_usuario IS 'usuario o aplicacion  que crea registro auditoria';
COMMENT ON COLUMN token.aud_fecha   IS  'sysdate de creacion del registro';

ALTER TABLE token ADD CONSTRAINT token_pk PRIMARY KEY ( tkn_id );

CREATE TABLE usuario (
    usu_id        NUMBER NOT NULL,
    inb_id        NUMBER NOT NULL,
    tpu_id        NUMBER NOT NULL,
    emp_id        NUMBER NOT NULL,
    usu_user      VARCHAR2(60),
    usu_pass      VARCHAR2(255),
    aud_fecha     DATE DEFAULT SYSDATE,
    aud_usuario   VARCHAR2(60) DEFAULT USER
);

COMMENT ON COLUMN usuario.usu_id      IS 'llave primaria de la tabla usuario';
COMMENT ON COLUMN usuario.inb_id      IS 'llave foranea perteneciente a la tabla informacion_basica';
COMMENT ON COLUMN usuario.tpu_id      IS 'llave foranea perteneciente a la tabla tipo_usuario';
COMMENT ON COLUMN usuario.emp_id      IS 'llave foranea perteneciente a la tabla empresa';
COMMENT ON COLUMN usuario.usu_user    IS 'usuario con el cual se valida el ingreso';
COMMENT ON COLUMN usuario.usu_pass    IS 'contraseña para comprobar ingreso';
COMMENT ON COLUMN usuario.aud_fecha   IS 'sysdate de creacion del registro';
COMMENT ON COLUMN usuario.aud_usuario IS 'usuario o aplicacion  que crea registro auditoria';



ALTER TABLE usuario ADD CONSTRAINT credenciales_pk PRIMARY KEY ( usu_id );
usuario

ALTER TABLE usuario
    ADD CONSTRAINT usu_informacion_basica_fk FOREIGN KEY ( inb_id )
        REFERENCES informacion_basica ( inb_id );

ALTER TABLE usuario
    ADD CONSTRAINT credenciales_tipo_usuario_fk FOREIGN KEY ( tpu_id )
        REFERENCES tipo_usuario ( tpu_id );

ALTER TABLE empresa
    ADD CONSTRAINT empresa_tipo_documento_fk FOREIGN KEY ( tip_doc )
        REFERENCES tipo_documento ( tip_doc );

ALTER TABLE informacion_basica
    ADD CONSTRAINT inb_tipo_documento_fk FOREIGN KEY ( tip_doc )
        REFERENCES tipo_documento ( tip_doc );

ALTER TABLE servicios_token
    ADD CONSTRAINT servicios_token_servicios_fk FOREIGN KEY ( srv_id )
        REFERENCES servicios ( srv_id );

ALTER TABLE servicios_token
    ADD CONSTRAINT servicios_token_token_fk FOREIGN KEY ( tkn_id )
        REFERENCES token ( tkn_id );

ALTER TABLE tarjeta
    ADD CONSTRAINT tarjeta_tipo_tarjeta_fk FOREIGN KEY ( ttj_id )
        REFERENCES tipo_tarjeta ( ttj_id );

ALTER TABLE tarjeta
    ADD CONSTRAINT tarjeta_usuario_fk FOREIGN KEY ( usu_id )
        REFERENCES usuario ( usu_id );

ALTER TABLE token
    ADD CONSTRAINT token_credenciales_fk FOREIGN KEY ( usu_id )
        REFERENCES usuario ( usu_id );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_empresa_fk FOREIGN KEY ( emp_id )
        REFERENCES empresa ( emp_id );
/*
********************************************************************************
********************************************************************************
Disparadores para simular el auto incrementable
********************************************************************************
********************************************************************************
*/
/
create or replace TRIGGER db_INS_TTJ
  BEFORE
    INSERT ON TIPO_TARJETA REFERENCING OLD AS OLD NEW AS NEW FOR EACH ROW
DECLARE
	-- Autor   	: DAKERO
	-- Objetivo	: Auto incrementable de la tabla tipo_tarjeta
    nmttj_id   NUMBER;
BEGIN
  BEGIN
    SELECT MAX(NVL(ttj_id,0))
      INTO nmttj_id
      FROM TIPO_TARJETA;
  EXCEPTION
  WHEN OTHERS THEN
    nmttj_id := 0;
  END;
  :new.TTJ_ID :=  nvl(nmttj_id,0)+1;
END;
/*
********************************************************************************
********************************************************************************
Disparadores para simular el auto incrementable
********************************************************************************
********************************************************************************
*/
/
INSERT INTO "DAKERO"."TIPO_DOCUMENTO" (TIP_DOC, TIP_NOMBRE) VALUES ('CC', 'Cedula Ciudadania') ;
INSERT INTO "DAKERO"."TIPO_DOCUMENTO" (TIP_DOC, TIP_NOMBRE) VALUES ('CE', 'Cedula Extranjeria');
INSERT INTO "DAKERO"."TIPO_DOCUMENTO" (TIP_DOC, TIP_NOMBRE) VALUES ('NI', 'Numero de Identificacion Tributaria');
/
INSERT INTO "DAKERO"."TIPO_TARJETA" (TTJ_NOMBRE) VALUES ('Credito');
INSERT INTO "DAKERO"."TIPO_TARJETA" (TTJ_NOMBRE) VALUES ('Debito');
/

