INSERT ALL
    INTO T_ROL(rol_id, rol) VALUES ('1', 'ADMIN')
    INTO T_ROL(rol_id, rol) VALUES ('2', 'VENDEDOR')
    INTO T_ROL(rol_id, rol) VALUES ('3', 'USER')
SELECT 1 FROM DUAL;
/
SELECT * FROM T_ROL;
/
-- password 123
INSERT ALL
    INTO T_USUARIO(username, password, rol_id, active) VALUES ('Daniel', '$2a$10$hhORrVpu6gxjIRUQFXzvFO766psJfDGJgIT1J1BvLHkInEPJsEm8a', '1', '1')
SELECT 1 FROM DUAL;
/
SELECT * FROM T_USUARIO;