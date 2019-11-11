create DATABASE recibosdb;
USE recibosdb;

INSERT INTO Emisor (n_apellidos, t_contrasena, n_direccion,
n_dni, t_nombre_usuario, n_nombres, n_ruc, n_telefono)
VALUES("Pizarro Llanos", "TitoPuente", "Av. Siempre viva 42", 73928134, 
"Colectivo UPC S.A.C", "César Alejandro", "12345678911", 999888222 );

SELECT * FROM Emisor;
INSERT INTO tipo_tasa (t_descripcion)
VALUES ("efectiva");
INSERT INTO tipo_tasa (t_descripcion, t_capitalizacion)
VALUES ("nominal", "anual");
INSERT INTO tipo_tasa (t_descripcion, t_capitalizacion)
VALUES ("nominal", "semestral");
INSERT INTO tipo_tasa (t_descripcion, t_capitalizacion)
VALUES ("nominal", "cuatrimestral");
INSERT INTO tipo_tasa (t_descripcion, t_capitalizacion)
VALUES ("nominal", "trimestral");
INSERT INTO tipo_tasa (t_descripcion, t_capitalizacion)
VALUES ("nominal", "bimestral");
INSERT INTO tipo_tasa (t_descripcion, t_capitalizacion)
VALUES ("nominal", "mensual");
INSERT INTO tipo_tasa (t_descripcion, t_capitalizacion)
VALUES ("nominal", "diaria");
DELETE FROM tipo_tasa WHERE id_tipo_tasa = 2;
Select * From tipo_tasa;