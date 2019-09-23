Algoritmo TIR
	
	//Numero de pagos a realizar en este caso
	Leer NumeroFlujos
	
	Dimension d(NumeroFlujos,3)
	fila <- 0
	columna <- 0
	F <- 1
	Para fila <- 1 Hasta NumeroFlujos Con paso 1 Hacer
		Para columna <- 1 Hasta 3 Con paso 1 Hacer
			Leer num
			d(fila, columna) <- num
		FinPara
	FinPara
	I <- 0

	I <- I + d(1, 1) + d(2,1)
	
	a <- 0
	b <- 0.5
	
	Para h<-1 Hasta 1000 Con Paso 1 Hacer
		valc <- 0
		c <- (a + b)/2
		Para m <- 1 Hasta NumeroFlujos Con Paso 1 Hacer
			valc <- valc + d(m,2)/((1 + c)^d(m,3))
		FinPara
		
		Si valc < I Entonces
			b <- c
		SiNo
			a <- c
		FinSi
		
		Si abs(valc - I) < 0.001 Entonces 
			TIR_P = c
			TIR_A = TIR_P*360/F
			
			TCEA = (1 + TIR_A*(F/360))^360/F - 1
		FinSi
		
	Fin Para
	
	Escribir "La tasa de coste efectiva es: " TCEA
	
FinAlgoritmo
