CREATE OR REPLACE FUNCTION f_factura_impuesto_descuento (
    monto     NUMBER,
    descuento NUMBER,
    impuesto  NUMBER
) RETURN DECIMAL IS
    total DECIMAL;
BEGIN
    total := monto + ( monto / 100 * impuesto - monto / 100 * descuento );

    RETURN total;
END;

SELECT F_FACTURA_IMPUESTO_DESCUENTO(2000,3,7)FROM T_FACTURA;


CREATE OR REPLACE FUNCTION f_cotizacion_prima (
    monto NUMBER,
    prima NUMBER
) RETURN DECIMAL IS
    total DECIMAL;
BEGIN
    total := prima - monto;
    RETURN total;
END;

SELECT F_COTIZACION_PRIMA(6000,10000)FROM T_COTIZACION;


CREATE OR REPLACE FUNCTION f_banco_tasa (
    monto NUMBER,
    tasa  NUMBER
) RETURN DECIMAL IS
    total DECIMAL;
BEGIN
    total := monto + ( monto / 100 * tasa );
    RETURN total;
END;

SELECT F_BANCO_TASA(5000000,5)FROM DUAL;

CREATE OR REPLACE FUNCTION F_TELEFONO_USUARIO(NOMBRE VARCHAR2)
RETURN SYS_REFCURSOR
IS
MI_CURSOR SYS_REFCURSOR;
BEGIN
OPEN MI_CURSOR FOR
SELECT PHONE_NUMBER FROM EMPLOYEES WHERE FIRST_NAME = NOMBRE;
RETURN MI_CURSOR;
END;

SELECT  F_TELEFONO_USUARIO(Steven)FROM EMPLOYEES;

VAR MI_CURSOR REFCURSOR;
EXECUTE  F_TELEFONO_USUARIO(Steven);
PRINT MI_CURSOR;



CREATE OR REPLACE PROCEDURE sp_crear_usuario (
    p_rol_id         NUMBER,
    p_identificacion VARCHAR2,
    p_nombre         VARCHAR2,
    p_apellidos      VARCHAR2,
    p_email          VARCHAR2,
    p_telefono       VARCHAR2,
    p_direccion_id   NUMBER
) AS
BEGIN
    INSERT INTO t_usuario (
        rol_id,
        identificacion,
        nombre,
        apellidos,
        email,
        telefono,
        direccion_id
    ) VALUES (
        p_rol_id,
        p_identificacion,
        p_nombre,
        p_apellidos,
        p_email,
        p_telefono,
        p_direccion_id
    );

END;



CREATE OR REPLACE PROCEDURE sp_actualizar_persona (
    p_persona_id     NUMBER,
    p_rol_id         NUMBER,
    p_identificacion VARCHAR2,
    p_nombre         VARCHAR2,
    p_apellidos      VARCHAR2,
    p_email          VARCHAR2,
    p_telefono       VARCHAR2,
    p_direccion_id   NUMBER
) AS
BEGIN
    UPDATE t_persona
    SET
        rol_id = p_rol_id,
        identificacion = p_identificacion,
        nombre = p_nombre,
        apellidos = p_apellidos,
        email = p_email,
        telefono = p_telefono,
        direccion_id = p_direccion_id
    WHERE
        persona_id = p_persona_id;

END;



CREATE OR REPLACE PROCEDURE sp_consultar_usuario AS
BEGIN
    SELECT*FROM t_usuario;
END;

CREATE OR REPLACE PROCEDURE sp_eliminar_usuario (
    p_usuario_id NUMBER
) AS
BEGIN
    DELETE FROM t_usuario
    WHERE
        usuario_id = p_usuario_id;
END;

CREATE OR REPLACE PROCEDURE SP_CREAR_CARRO(
    P_placa          VARCHAR2,
    P_marca_id       NUMBER,
    P_modelo_id      NUMBER,
    P_trim_id        NUMBER,
    P_color_interior NUMBER,
    P_color_exterior NUMBER,
    P_sucursal_id    NUMBER,
    P_estado_id      NUMBER,
    P_kilometraje    NUMBER,
    P_precio         NUMBER,
    P_vin            VARCHAR2 )
AS
BEGIN
  INSERT
  INTO T_CARRO
    (
      placa ,
      marca_id,
      modelo_id,
      trim_id ,
      color_interior,
      color_exterior ,
      sucursal_id ,
      estado_id ,
      kilometraje,
      precio ,
      vin
    )
    VALUES
    (
      P_placa ,
      P_marca_id ,
      P_modelo_id ,
      P_trim_id ,
      P_color_interior ,
      P_color_exterior ,
      P_sucursal_id ,
      P_estado_id ,
      P_kilometraje ,
      P_precio ,
      P_vin
    );
END;
BEGIN
  SP_CREAR_CARRO();
END;
CREATE OR REPLACE PROCEDURE SP_ACTUALIZAR_CARRO
  (
    P_placa          VARCHAR2,
    P_marca_id       NUMBER,
    P_modelo_id      NUMBER,
    P_trim_id        NUMBER,
    P_color_interior NUMBER,
    P_color_exterior NUMBER,
    P_sucursal_id    NUMBER,
    P_estado_id      NUMBER,
    P_kilometraje    NUMBER,
    P_precio         NUMBER,
    P_vin            VARCHAR2
  )
AS
BEGIN
  UPDATE T_CARRO
  SET placa        = P_placa ,
    marca_id       = P_marca_id,
    modelo_id      = P_modelo_id,
    trim_id        = P_trim_id,
    color_interior = P_color_interior,
    color_exterior = P_color_exterior,
    sucursal_id    = P_sucursal_id,
    estado_id      = P_estado_id,
    kilometraje    = P_kilometraje,
    precio         = P_precio,
    vin            = P_vin
  WHERE carro_id   = P_carro_id;
END;


CREATE OR REPLACE PROCEDURE SP_COSNSULTAR_CARRO
AS
BEGIN
  SELECT * FROM T_CARRO;
END;

CREATE OR REPLACE PROCEDURE SP_COSNSULTAR_CARRO(
    P_CARRO_ID NUMBER)
AS
BEGIN
  DELETE FROM T_CARRO WHERE CARRO_ID = P_CARRO_ID;
END;



CREATE OR REPLACE PROCEDURE sp_cantidad_carros AS
BEGIN
    SELECT
        t_modelo.modelo,
        t_marca.marca
    FROM
             t_carro
        INNER JOIN t_modelo ON t_modelo.modelo_id = t_carro.modelo_id
        INNER JOIN t_marca ON t_marca.marca_id = t_carro.marca_id;

END;

CREATE OR REPLACE PROCEDURE sp_validar_cotizacion AS
BEGIN
    SELECT
        t_cotizacion.cotizacion_id
    FROM
             t_cotizacion
        INNER JOIN t_factura ON t_cotizacion.factura_id = t_factura.factura_id;
END;


CREATE OR REPLACE PROCEDURE sp_disponibilidad_carros AS
BEGIN
    SELECT
        precio,
        t_marca.marca
    FROM
             t_carro
        INNER JOIN t_marca ON t_marca.marca_id = t_carro.marca_id;

END;

