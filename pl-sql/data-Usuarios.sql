INSERT ALL
    INTO T_ROL(rol_id, rol) VALUES ('1', 'ADMIN')
    INTO T_ROL(rol_id, rol) VALUES ('2', 'VENDEDOR')
    INTO T_ROL(rol_id, rol) VALUES ('3', 'USER')
SELECT 1 FROM DUAL;
/
SELECT * FROM T_ROL;
/
INSERT ALL
    INTO T_USUARIO(username, password, rol_id, active) VALUES ('Daniel', '123', '1', '1')
SELECT 1 FROM DUAL;
/
SELECT * FROM T_USUARIO;
/
SELECT * FROM T_USUARIO WHERE username = Daniel;
