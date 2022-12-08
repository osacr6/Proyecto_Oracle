-- USANDO SQL PLUS PERMITIR AL USUARIO USAR LA BD
-- usuario: conn /as sysdba
-- SQL > GRAND ALL PRIVILEGES TO HR;

--- T_PROVINCIA
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_PROVINCIA CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_PROVINCIA (
    provincia_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    provincia VARCHAR2(128) NOT NULL
);
/
--- T_CANTON
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_CANTON CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_CANTON (
    canton_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    canton VARCHAR2(128) NOT NULL
);
/
--- T_DISTRITO
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_DISTRITO CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_DISTRITO (
    distrito_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    distrito VARCHAR2(128) NOT NULL
);
/
--- T_DIRECCION
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_DIRECCION CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_DIRECCION (
    direccion_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    provincia_id NUMBER NOT NULL,
    canton_id NUMBER NOT NULL,
    distrito_id NUMBER,
    detalles VARCHAR2(256),
    ubicacion VARCHAR2(256),
    CONSTRAINT FK_DIRECCION_PROVINCIA
        FOREIGN KEY (provincia_id)
        REFERENCES T_PROVINCIA (provincia_id),
    CONSTRAINT FK_DIRECCION_CANTON
        FOREIGN KEY (canton_id)
        REFERENCES T_CANTON (canton_id),
    CONSTRAINT FK_DIRECCION_DISTRITO
        FOREIGN KEY (distrito_id)
        REFERENCES T_DISTRITO (distrito_id)
);
/
--- T_SUCURSAL
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_SUCURSAL CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_SUCURSAL (
    sucursal_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    numero NUMBER,
    nombre VARCHAR2(128) NOT NULL,
    telefono VARCHAR2(128),
    direccion_id NUMBER,
    CONSTRAINT FK_SUCURSAL_DIRECCION
        FOREIGN KEY (direccion_id)
        REFERENCES T_DIRECCION (direccion_id)
);
/
--- T_MARCA
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_MARCA CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_MARCA (
    marca_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    marca VARCHAR2(128) NOT NULL
);
/
--- T_TRANSMISION
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_TRANSMISION CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_TRANSMISION (
    transmision_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    transmision VARCHAR2(128) NOT NULL
);
/
--- T_MOTOR
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_MOTOR CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_MOTOR (
    motor_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    cilindraje NUMBER NOT NULL,
    marca_id NUMBER NOT NULL,
    CONSTRAINT FK_MOTOR_MARCA
        FOREIGN KEY (marca_id)
        REFERENCES T_MARCA (marca_id)
);
/
--- T_TRIM
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_TRIM CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_TRIM (
    trim_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    codigo VARCHAR2(128) NOT NULL,
    motor_id NUMBER NOT NULL,
    transmision_id NUMBER NOT NULL,
    numero_puertas NUMBER NOT NULL,
    CONSTRAINT FK_TRIM_MOTOR
        FOREIGN KEY (motor_id)
        REFERENCES T_MOTOR (motor_id),
    CONSTRAINT FK_TRIM_TRANSMISION
        FOREIGN KEY (transmision_id)
        REFERENCES T_TRANSMISION (transmision_id)
);
/
--- T_MODELO
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_MODELO CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_MODELO (
    modelo_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    modelo VARCHAR2(128) NOT NULL
);
/
--- T_COLOR
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_COLOR CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_COLOR (
    color_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    color VARCHAR2(128) NOT NULL
);
/
--- T_ESTADO
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_ESTADO CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_ESTADO (
    estado_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    estado VARCHAR2(128) NOT NULL
);
/
--- T_EQUIPAMIENTO
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_EQUIPAMIENTO CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_EQUIPAMIENTO (
    equipamiendo_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    equipamiendo VARCHAR2(128) NOT NULL
);
/
--- T_SERVICIO
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_SERVICIO CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_SERVICIO (
    servicio_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    servicio VARCHAR2(128) NOT NULL
);
/
--- T_CARRO
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_CARRO CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_CARRO (
    carro_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    placa VARCHAR2(128),
    marca_id NUMBER NOT NULL,
    modelo_id NUMBER NOT NULL,
    trim_id NUMBER NOT NULL,
    color_interior NUMBER,
    color_exterior NUMBER NOT NULL,
    sucursal_id NUMBER,
    estado_id NUMBER,
    kilometraje NUMBER,
    precio NUMBER,
    vin VARCHAR2(128) UNIQUE,
    CONSTRAINT FK_CARRO_MARCA
        FOREIGN KEY (marca_id)
        REFERENCES T_MARCA (marca_id),
    CONSTRAINT FK_CARRO_MODELO
        FOREIGN KEY (modelo_id)
        REFERENCES T_MODELO (modelo_id),
    CONSTRAINT FK_CARRO_TRIM
        FOREIGN KEY (trim_id)
        REFERENCES T_TRIM (trim_id),
    CONSTRAINT FK_CARRO_SUCURSAL
        FOREIGN KEY (sucursal_id)
        REFERENCES T_SUCURSAL (sucursal_id),
    CONSTRAINT FK_CARRO_ESTADO
        FOREIGN KEY (estado_id)
        REFERENCES T_ESTADO (estado_id)
);
/
--- T_CARRO_EQUIPAMIENTOS
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_CARRO_EQUIPAMIENTOS CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_CARRO_EQUIPAMIENTOS (
    id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    carro_id NUMBER NOT NULL,
    equipamiendo_id NUMBER NOT NULL,
    CONSTRAINT FK_CARRO_EQUIPAMIENTOS__CARRO
        FOREIGN KEY (carro_id)
        REFERENCES T_CARRO (carro_id),
    CONSTRAINT FK_CARRO_EQUIPAMIENTOS__EQUIPAMIENTO
        FOREIGN KEY (equipamiendo_id)
        REFERENCES T_EQUIPAMIENTO (equipamiendo_id)
);
/
--- T_CARRO_SERVICIOS
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_CARRO_SERVICIOS CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_CARRO_SERVICIOS (
    id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    carro_id NUMBER NOT NULL,
    servicio_id NUMBER NOT NULL,
    CONSTRAINT FK_CARRO_SERVICIOS__CARRO
        FOREIGN KEY (carro_id)
        REFERENCES T_CARRO (carro_id),
    CONSTRAINT FK_CARRO_SERVICIOS__SERVICIO
        FOREIGN KEY (servicio_id)
        REFERENCES T_SERVICIO (servicio_id)
);
/
--- T_GALERIA
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_GALERIA CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_GALERIA (
    galeria_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    carro_id NUMBER NOT NULL,
    media_url VARCHAR2(512) NOT NULL,
    CONSTRAINT FK_GALERIA_CARRO
        FOREIGN KEY (carro_id)
        REFERENCES T_CARRO (carro_id)
);
/
--- T_ROL
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_ROL CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_ROL (
    rol_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    rol VARCHAR2(128) NOT NULL
);
/
INSERT ALL
    INTO T_ROL(rol_id, rol) VALUES ('1', 'ADMIN')
    INTO T_ROL(rol_id, rol) VALUES ('2', 'VENDEDOR')
    INTO T_ROL(rol_id, rol) VALUES ('3', 'USER')
SELECT 1 FROM DUAL;
/
SELECT * FROM T_ROL;
/
--- T_USUARIO
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_USUARIO CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_USUARIO (
    usuario_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    username VARCHAR2(128) NOT NULL,
    password VARCHAR2(128) NOT NULL,
    rol_id NUMBER NOT NULL,
    active NUMBER NOT NULL,
    persona_id NUMBER,
    CONSTRAINT FK_USUARIO_ROL
        FOREIGN KEY (rol_id)
        REFERENCES T_ROL (rol_id),
    CONSTRAINT FK_USUARIO_PERSONA
        FOREIGN KEY (persona_id)
        REFERENCES T_PERSONA (persona_id)
);
/
--- T_PERSONA
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_PERSONA CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_PERSONA (
    persona_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    identificacion VARCHAR2(64) NOT NULL,
    nombre VARCHAR2(128) NOT NULL,
    apellidos VARCHAR2(128),
    email VARCHAR2(128) UNIQUE,
    telefono VARCHAR2(128) NOT NULL,
    direccion_id NUMBER,
    CONSTRAINT FK_PERSONA_DIRECCION
        FOREIGN KEY (direccion_id)
        REFERENCES T_DIRECCION (direccion_id)
);
/
--- T_TIPO_FACTURA
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_TIPO_FACTURA CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_TIPO_FACTURA (
    tipo_factura_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    tipo_factura VARCHAR2(128) NOT NULL UNIQUE
);
/
--- T_TIPO_PAGO
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_TIPO_PAGO CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_TIPO_PAGO (
    tipo_pago_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    tipo_pago VARCHAR2(128) NOT NULL UNIQUE
);
/
--- T_MONEDA
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_MONEDA CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_MONEDA (
    moneda_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    moneda VARCHAR2(128) NOT NULL UNIQUE
);
/
--- T_FACTURA
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_FACTURA CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_FACTURA (
    factura_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    consecutivo NUMBER UNIQUE,
    sucursal_id NUMBER NOT NULL,
    emisor_id NUMBER NOT NULL,
    receptor_id NUMBER NOT NULL,
    fecha DATE NOT NULL,
    tipo_factura_id NUMBER NOT NULL,
    tipo_pago_id NUMBER NOT NULL,
    moneda_id NUMBER NOT NULL,
    subtotal NUMBER NOT NULL,
    impuestos NUMBER DEFAULT 0,
    descuentos NUMBER DEFAULT 0,
    total  NUMBER NOT NULL,
    CONSTRAINT FK_FACTURA_SUCURSAL
        FOREIGN KEY (sucursal_id)
        REFERENCES T_SUCURSAL (sucursal_id),
    CONSTRAINT FK_FACTURA_PERSONA__EMISOR
        FOREIGN KEY (emisor_id)
        REFERENCES T_PERSONA (persona_id),
    CONSTRAINT FK_FACTURA_PERSONA__RECEPTOR
        FOREIGN KEY (receptor_id)
        REFERENCES T_PERSONA (persona_id),
    CONSTRAINT FK_FACTURA_TIPO_FACTURA
        FOREIGN KEY (tipo_factura_id)
        REFERENCES T_TIPO_FACTURA (tipo_factura_id),
    CONSTRAINT FK_FACTURA_TIPO_PAGO
        FOREIGN KEY (tipo_pago_id)
        REFERENCES T_TIPO_PAGO (tipo_pago_id),
    CONSTRAINT FK_FACTURA_MONEDA
        FOREIGN KEY (moneda_id)
        REFERENCES T_MONEDA (moneda_id)
);
/
--- T_DETALLE
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_DETALLE CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_DETALLE (
    detalle_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    equipamiendo_id NUMBER,
    servicio_id NUMBER,
    detalle VARCHAR2(512),
    cantidad NUMBER NOT NULL,
    impuesto NUMBER DEFAULT 0,
    CONSTRAINT FK_DETALLE_EQUIPAMIENTO
        FOREIGN KEY (equipamiendo_id)
        REFERENCES T_EQUIPAMIENTO (equipamiendo_id),
    CONSTRAINT FK_DETALLE_SERVICIO
        FOREIGN KEY (servicio_id)
        REFERENCES T_SERVICIO (servicio_id)
);
/
--- T_FACTURA_DETALLE
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_FACTURA_DETALLE CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_FACTURA_DETALLE (
    factura_detalle_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    factura_id NUMBER NOT NULL,
    detalle_id NUMBER NOT NULL,
    CONSTRAINT FK_FACTURA_DETALLE__FACTURA
        FOREIGN KEY (factura_id)
        REFERENCES T_FACTURA (factura_id),
    CONSTRAINT FK_FACTURA_DETALLE__DETALLE
        FOREIGN KEY (detalle_id)
        REFERENCES T_DETALLE (detalle_id)
);
/
--- T_BANCO
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_BANCO CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_BANCO (
    banco_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    banco VARCHAR2(128) NOT NULL,
    tasa DECIMAL NOT NULL
);
/
--- T_BANCO
--
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE T_COTIZACION CASCADE CONSTRAINTS PURGE';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/
CREATE TABLE T_COTIZACION (
    cotizacion_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    factura_id NUMBER NOT NULL,
    banco_id NUMBER NOT NULL,
    prima NUMBER DEFAULT 0,
    CONSTRAINT FK_COTIZACION_FACTURA
        FOREIGN KEY (factura_id)
        REFERENCES T_FACTURA (factura_id),
    CONSTRAINT FK_COTIZACION_BANCO
        FOREIGN KEY (banco_id)
        REFERENCES T_BANCO (banco_id)
);