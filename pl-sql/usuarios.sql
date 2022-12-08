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
/
CREATE OR REPLACE PROCEDURE sp_update_usuario (
    V_ID NUMBER,
    V_USERNAME VARCHAR2,
    V_PASSWORD VARCHAR2,
    V_ROL_ID NUMBER,
    V_ACTIVE	NUMBER
) AS
BEGIN 
    UPDATE T_USUARIO SET
        USERNAME = V_USERNAME,
        PASSWORD = V_PASSWORD,
        ROL_ID = V_ROL_ID,
        ACTIVE = V_ACTIVE
    WHERE
        usuario_id = V_ID;
        
END;
/
CALL sp_update_usuario('21', 'test', 'update', '1', '1');
/
SELECT * FROM T_USUARIO;
/
CREATE OR REPLACE PROCEDURE sp_delete_usuario (
    V_ID NUMBER
) AS
BEGIN 
    DELETE FROM T_USUARIO 
    WHERE
        usuario_id = V_ID;
        
END;
/
CALL sp_delete_usuario('21');
/
SELECT * FROM T_USUARIO;