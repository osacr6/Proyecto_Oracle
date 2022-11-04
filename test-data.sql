
SELECT * FROM USUARIO;
 
INSERT INTO USUARIO (
    NOMBRE,
    APELLIDO1,
    APELLIDO2,
    EMAIL,
    PASSWORD,
    TELEFONO,
    ROLES,
    PERMISSIONS,
    ACTIVE
) VALUES (
    'Daniel',
    'Murillo',
    'Porras',
    'test@test.com',
    '123',
    '11223344',
    'ADMIN',
    'ROLE_ADMIN',
    1
);