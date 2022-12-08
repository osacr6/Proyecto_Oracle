--CREAR
CREATE OR REPLACE PROCEDURE sp_crear_provincia (
    provinciaDato IN VARCHAR2 
) AS
BEGIN
    INSERT INTO T_PROVINCIA (PROVINCIA) VALUES (provinciaDato);
END;
CREATE OR REPLACE PROCEDURE sp_crear_canton (
    cantonDato IN VARCHAR2
) AS
BEGIN
    INSERT INTO T_CANTON (canton) VALUES (cantonDato);
END;

CREATE OR REPLACE PROCEDURE sp_crear_distrito (
    distritoDato IN VARCHAR2
) AS
BEGIN
    INSERT INTO T_DISTRITO (distrito) VALUES (distritoDato);
END;

CREATE OR REPLACE PROCEDURE sp_crear_direccion (
    provincia_id_Dato IN NUMBER,
    canton_id_Dato IN NUMBER,
    distrito_id_Dato IN NUMBER,
    detalles_Dato IN VARCHAR2,
    ubicacion_Dato IN VARCHAR2
) AS
BEGIN
    INSERT INTO T_DIRECCION (provincia_id,canton_id,distrito_id,detalles,ubicacion) VALUES 
    (provincia_id_Dato,canton_id_Dato,distrito_id_Dato,detalles_Dato,ubicacion_Dato);
END;

CREATE OR REPLACE PROCEDURE sp_crear_sucursal (
    numeroDato IN NUMBER,
    nombreDato IN VARCHAR2,
    telefonoDato IN VARCHAR2,
    direccion_id_Dato IN NUMBER
) AS
BEGIN
    INSERT INTO T_SUCURSAL (numero,nombre,telefono,direccion_id) VALUES (numeroDato,nombreDato,telefonoDato,direccion_id_Dato);
END;

--ACTUALIZAR

CREATE OR REPLACE PROCEDURE sp_actualizar_provincia (
    provinciaDato IN VARCHAR2,
    provincia_ID_Dato IN NUMBER 
) AS
BEGIN
    UPDATE INTO T_PROVINCIA  SET PROVINCIA = provinciaDato WHERE  PROVINICA_ID = provincia_ID_Dato;
END;

CREATE OR REPLACE PROCEDURE sp_actualizar_canton (
    cantonDato IN VARCHAR2,
    canton_ID_Dato IN NUMBER 
) AS
BEGIN
    UPDATE INTO T_CANTON SET CANTON = cantonDato WHERE  CANTON_ID = canton_ID_Dato;
END;

CREATE OR REPLACE PROCEDURE sp_actualizar_distrito (
    distritoDato IN VARCHAR2,
    distrito_id_Dato IN NUMBER
) AS
BEGIN
    UPDATE INTO T_DISTRITO SET DISTRITO = distritoDato WHERE DISTRITO_ID = distrito_id_Dato;
END;

CREATE OR REPLACE PROCEDURE sp_actualizar_direccion (
    provincia_id_Dato NUMBER,
    canton_id_Dato NUMBER,
    distrito_id_Dato NUMBER,
    detallesDato VARCHAR2,
    ubicacionDato VARCHAR2,
    direccion_id_dato NUMBER
) AS
BEGIN
update T_DIRECCION set provincia_id=provincia_id_Dato, canton_id=canton_id_Dato, distrito_id=distrito_id_Dato, detalles=detallesDato,
ubicacion=ubicacionDato where direccion_id =direccion_id_dato;
END;

CREATE OR REPLACE PROCEDURE sp_actualizar_sucursal (
    numeroDato IN NUMBER,
    nombreDato IN VARCHAR2,
    telefonoDato IN VARCHAR2,
    direccion_id_Dato IN NUMBER,
    sucursal_id_Dato IN NUMBER
) AS
BEGIN
    update T_SUCURSAL set direccion_id=direccion_id_Dato, numero=numeroDato,nombre=nombreDato, telefono=telefonoDato where sucursal_id =sucursal_id_Dato;
END;

--delete
CREATE OR REPLACE PROCEDURE sp_delete_provincia (
    provincia_ID_Dato IN NUMBER 
) AS
BEGIN
    DELETE FROM T_PROVINCIA WHERE provincia_id =provincia_ID_Dato;
END;

CREATE OR REPLACE PROCEDURE sp_delete_canton (
    canton_ID_Dato IN NUMBER 
) AS
BEGIN
    DELETE FROM T_CANTON WHERE canton_id =canton_ID_Dato;
END;

CREATE OR REPLACE PROCEDURE sp_delete_distrito (
    distrito_id_Dato IN NUMBER
) AS
BEGIN
    DELETE FROM T_DISTRITO WHERE distrito_id =distrito_id_Dato;
END;

CREATE OR REPLACE PROCEDURE sp_delete_direccion (
 direccion_id_dato IN NUMBER
) AS
BEGIN
DELETE FROM T_DIRECCION WHERE direccion_id =direccion_id_dato;
END;

CREATE OR REPLACE PROCEDURE sp_delete_sucursal (
 sucursal_id_Dato IN NUMBER
) AS
BEGIN
   DELETE FROM T_SUCURSAL WHERE sucursal_id =sucursal_id_Dato;
END;


commit