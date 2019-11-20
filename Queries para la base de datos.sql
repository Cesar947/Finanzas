create DATABASE recibosdb;
USE recibosdb;

INSERT INTO Emisor (n_apellidos, t_contrasena, n_direccion,
n_dni, t_nombre_usuario, n_nombres, n_ruc, n_telefono)
VALUES("Pizarro Llanos", "TitoPuente", "Av. Siempre viva 42", 73928134, 
"Colectivo UPC S.A.C", "César Alejandro", "12345678911", 999888222 );

INSERT INTO cliente (t_nombre, n_ruc)
VALUES("TODO A UN PRECIO E.I.R.L", "20535858501");

SELECT * FROM Emisor;
select * from Cliente;
INSERT INTO tipo_tasa (t_descripcion)
VALUES ("efectiva");
INSERT INTO tipo_tasa (t_descripcion)
VALUES ("nominal");

INSERT INTO capitalizacion(t_descripcion, n_dias)
VALUES("anual", 360);
INSERT INTO capitalizacion(t_descripcion, n_dias)
VALUES("semestral", 180);
INSERT INTO capitalizacion(t_descripcion, n_dias)
VALUES("cuatrimestral", 120);
INSERT INTO capitalizacion(t_descripcion, n_dias)
VALUES("trimestral", 90);
INSERT INTO capitalizacion(t_descripcion, n_dias)
VALUES("bimestral", 60);
INSERT INTO capitalizacion(t_descripcion, n_dias)
VALUES("mensual", 30);
SELECT * FROM tipo_tasa;
SELECT * FROM capitalizacion;

INSERT INTO recibo_honorarios
values("E001-1", "2019-11-17", "2019-12-17", 1000, 1000, "SIN RETENCION", 0, "Soles", "Textileria", 1,1);

select * from recibo_honorarios;


