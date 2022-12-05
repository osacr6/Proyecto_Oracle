INSERT ALL
    INTO T_ROL(rol_id, rol) VALUES ('1', 'ADMIN')
    INTO T_ROL(rol_id, rol) VALUES ('2', 'VENDEDOR')
    INTO T_ROL(rol_id, rol) VALUES ('3', 'USER')
SELECT 1 FROM DUAL;
/
SELECT * FROM T_ROL;
/
CREATE OR REPLACE PROCEDURE sp_crear_usuario (
    USERNAME VARCHAR2,
    PASSWORD VARCHAR2,
    ROL_ID NUMBER,
    ACTIVE	NUMBER
) AS
BEGIN 
    INSERT INTO 
        T_USUARIO (
            USERNAME,
            PASSWORD,
            ROL_ID,
            ACTIVE
        ) VALUES (
            USERNAME,
            PASSWORD,
            ROL_ID,
            ACTIVE
        );
END;
/
CALL sp_crear_usuario('test', 'test', '1', '1');
/
SELECT * FROM T_USUARIO;