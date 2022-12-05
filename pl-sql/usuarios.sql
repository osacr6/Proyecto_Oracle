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