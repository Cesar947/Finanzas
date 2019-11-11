USE recibosdb;
CREATE DATABASE recibosdb;

INSERT INTO Emisor (n_apellidos, t_contrasena, n_direccion,
n_dni, t_nombre_usuario, n_nombres, n_ruc, n_telefono)
VALUES("Pizarro Llanos", "TitoPuente", "Av. Siempre viva 42", 73928134, 
"Colectivo UPC S.A.C", "César Alejandro", "12345678911", 999888222 );

SELECT * FROM Emisor;