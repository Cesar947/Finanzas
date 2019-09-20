Funcion TEP <- ConversionTEAaTEP (TEA, periodoEnDias)	
	TEP <- ((1 + TEA/100)^(periodoEnDias/360) - 1)*100
FinFuncion

Funcion d <- CalculoTasaDescontada (TEP)
	d <- ((TEP/100)/(1 + TEP/100))*100
FinFuncion

Funcion TCEA <- CalculoTasaCosteEfectivaAnual(valorEntregado, valorRecibido, periodoEnDias)
	TCEA <- ((valorEntregado/valorRecibido)^(360/periodoEnDias) - 1)*100
FinFuncion

Algoritmo DescuentoComercial
	
	//Datos de entrada
	Definir TEAc, TEP, d, TEAm, TCEA como Reales
	Definir valorNominal, valorConRetencion, valorNeto, Dscto, valorRecibido, valorEntregado, retencion como Reales
	Definir periodoEnDias como Real
	
	Escribir "Ingrese la tasa efectiva anual compensatoria:"
	Leer TEAc
	Escribir "Ingrese el periodo pactado de vencimiento:"
	Leer periodoEnDias
	TEP <- ConversionTEAaTEP(TEAc, periodoEnDias)
	
	Escribir "El valor de la tasa efectiva en el periodo es:"
	Escribir TEP "%"
	
	d <- CalculoTasaDescontada(TEP)
	Escribir "La tasa de descuento es:"
	Escribir d "%"
	Escribir "Ingrese el valor nominal:"
	Leer valorNominal
	Si valorNominal >= 1500 Entonces
		valorConRetencion = (92/100)*valorNominal
	Sino
		valorConRetencion = valorNominal
	FinSi
    Escribir "El valor con retencion del 8% es:"
	Escribir valorConRetencion
	
	Dscto <- (d/100)*valorConRetencion
	valorNeto <- valorConRetencion - Dscto
	
	valorRecibido <- valorNeto - 3.50
	Escribir "El valor descontado es:"
	Escribir  Dscto
	Escribir "El valor neto es:"
	Escribir valorNeto
	Escribir "El valor recibido con las comisiones, gastos, seguros aplicados:"
	Escribir valorRecibido
	
	valorEntregado = valorNominal - Dscto 
	Escribir "El valor entregado será de: "
	Escribir valorEntregado
	
	TCEA<-CalculoTasaCosteEfectivaAnual(valorEntregado, valorRecibido, periodoEnDias)
	Escribir "La tasa de coste efectiva anual es de: "
	Escribir TCEA "%"
	
	
FinAlgoritmo
