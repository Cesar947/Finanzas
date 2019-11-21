create DATABASE recibosdb;
USE recibosdb;

INSERT INTO Emisor (n_apellidos, t_contrasena, n_direccion,
n_dni, t_nombre_usuario, n_nombres, n_ruc, n_telefono)
VALUES("Pizarro Llanos", "TitoPuente", "Av. Siempre viva 42", 73928134, 
"Colectivo UPC S.A.C", "César Alejandro", "12345678911", 999888222 );

INSERT INTO Emisor (n_apellidos, t_contrasena, n_direccion,
n_dni, t_nombre_usuario, n_nombres, n_ruc, n_telefono)
VALUES("Lopez Martinez", "JaimePuentes", "Av. Peru cdra 42", 768386367, 
"Sepsicos UPC S.A.C", "Jayme Puentes", "23564588696", 948350258 );

INSERT INTO Emisor (n_apellidos, t_contrasena, n_direccion,
n_dni, t_nombre_usuario, n_nombres, n_ruc, n_telefono)
VALUES("Marchena Berrocal", "TitoCaceres", "Av. Marina cdra 12", 76838347, 
"ENERGÍA PLUS", "Roberto Caceres", "25426625632", 994865381 );

INSERT INTO cliente (t_nombre, n_ruc)
VALUES("MEJORANDO EL MUNDO E.I.R.L", "20375858501");

INSERT INTO cliente (t_nombre, n_ruc)
VALUES("INNOVANDO INDUSTRIAS E.I.R.L", "20577658501");

SELECT * FROM Emisor;

INSERT INTO cliente (t_nombre, n_ruc)
VALUES("TODO A UN PRECIO E.I.R.L", "20535858501");

SELECT * FROM Emisor;
select * from Cliente;
INSERT INTO tipo_tasa (t_descripcion)
VALUES ("EFECTIVA");
INSERT INTO tipo_tasa (t_descripcion)
VALUES ("NOMINAL");
SELECT * FROM tipo_tasa;
INSERT INTO capitalizacion(t_descripcion, n_dias)
VALUES("ANUAL", 360);
INSERT INTO capitalizacion(t_descripcion, n_dias)
VALUES("SEMESTRAL", 180);
INSERT INTO capitalizacion(t_descripcion, n_dias)
VALUES("CUATRIMESTRAL", 120);
INSERT INTO capitalizacion(t_descripcion, n_dias)
VALUES("TRIMESTRAL", 90);
INSERT INTO capitalizacion(t_descripcion, n_dias)
VALUES("BIMESTRAL", 60);
INSERT INTO capitalizacion(t_descripcion, n_dias)
VALUES("MENSUAL", 30);
SELECT * FROM tipo_tasa;
SELECT * FROM capitalizacion;


INSERT INTO recibo_honorarios
values("E001-1", "2019-11-17", "2019-12-17", 1000, 1000, "SIN RETENCIÓN", 0, "Soles", "Reparación de autos", 1,1);

INSERT INTO recibo_honorarios
values("E001-2", "2019-11-17", "2019-12-17", 1000, 1000, "SIN RETENCIÓN", 0, "Soles", "Reparación de autos", 2,1);

/**/
/*
LOS DE ANIBAL
*/
INSERT INTO recibo_honorarios
values("E001-3", "2019-11-20", "2020-01-18", 2000, 2000, "SIN RETENCIÓN", 0, "Soles", "Venta de carburador", 3, 1);
/*
INSERT INTO recibo_honorarios
values("E001-4", "2019-11-14", "2019-12-14", 3000, 3000, "SIN RETENCIÓN", 0, "Soles", "Ayudando a la administración de bienes en la empresa", 1,1);
*/
/**/

select * from recibo_honorarios;

SELECT d.id_detalle FROM detalle_factoring d JOIN resultado_factoring rf 
ON d.id_resultado_factoring = rf.id_resultado_factoring JOIN Factoring f
 ON f.id_factoring = rf.id_factoring WHERE f.id_factoring = 1;

SELECT * FROM Factoring;

INSERT INTO Factoring (d_descuento,m_itf ,m_portes , p_desgravamen, p_tasa_factoring,t_tipo_moneda, id_capitalizacion, id_tipo_tasa)
values("2019-11-18", 5.00 ,2.50, 0.09, 15.00, "Soles", null , 1) ;

DELETE FROM Factoring WHERE id_factoring > 1;

SELECT * FROM Detalle_Factoring;