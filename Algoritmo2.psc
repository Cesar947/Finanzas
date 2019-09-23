Algoritmo TIR
	
	//Numero de pagos a realizar en este caso
	Leer NumeroFlujosDePago
	
	Dimension d(NumeroFlujosDePago,3)
	fila <- 0
	columna <- 0
	F <- 1
	Para fila <- 1 Hasta NumeroFlujosDePago Con paso 1 Hacer
		Para columna <- 1 Hasta 3 Con paso 1 Hacer
			Leer num
			d(fila, columna) <- num
		FinPara
	FinPara
	I <- 0
	
	Para x <- 1 Hasta NumeroFlujosDePago Con Paso 1 Hacer
		I <- I + d(x, 1)
	FinPara
	
	
	a <- 0
	b <- 0.5
	
	Para h<-1 Hasta 1000 Con Paso 1 Hacer
		val <- 0
		c <- (a + b)/2
		Para m <- 1 Hasta NumeroFlujosDePago Con Paso 1 Hacer
			val <- val + d(m,2)/((1 + c)^d(m,3))
		FinPara
		
		Si val < I Entonces
			b <- c
		SiNo
			a <- c
		FinSi
		
		Si abs(val - I) < 0.001 Entonces 
			TIR_P = c
			TIR_A = TIR_P*360/F
			
			TCEA = (1 + TIR_A*(F/360))^360/F - 1
		FinSi
		
	Fin Para
	
	Escribir "La tasa de coste efectiva es: " TCEA*100
	
FinAlgoritmo
