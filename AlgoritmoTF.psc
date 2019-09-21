Funcion TEP <- ConversionTEAaTEP (TEA, periodoEnDias)	
	TEP <- ((1 + TEA/100)^(periodoEnDias/360) - 1)*100
FinFuncion

Funcion valorEnDias <- ConversionADias(periodo)
	Si periodo == "diaria" Entonces
		valorEnDias <- 1
	FinSi
	Si periodo == "quincenal" Entonces
		valorEnDias <- 15
	FinSi
	Si periodo == "mensual" Entonces
		valorEnDias <- 30
	FinSi
	Si periodoEnDias == "bimestral" Entonces
		valorEnDias <- 60
	FinSi
	Si periodoEnDias == "trimestral" Entonces
		valorEnDias <- 90
	FinSi
	Si periodoEnDias == "cuatrimestral" Entonces
		valorEnDias <- 120
	FinSi
	Si periodoEnDias == "semestral" Entonces
		valorEnDias <- 180
	FinSi
	Si periodoEnDias == "anual" Entonces
		valorEnDias <- 360
	FinSi
FinFuncion

Funcion TEP <- ConversionTNaTEP (TNP, tipoPeriodo, capitalizacion, periodo)
    Definir m, n como Reales
	m = ConversionADias(tipoPeriodo)/ConversionADias(capitalizacion)
	n = 360/ ConversionADias(capitalizacion)
	TEA <- (1 + TN/m)^(n) - 1
	TEP <- ConversionTEAaTEP(TEA, periodo)
FinFuncion

Funcion d <- CalculoTasaDescontada (TEP)
	d <- ((TEP/100)/(1 + TEP/100))*100
FinFuncion

Funcion TCEA <- CalculoTasaCosteEfectivaAnual(valorEntregado, valorRecibido, periodoEnDias)
	TCEA <- ((valorEntregado/valorRecibido)^(360/periodoEnDias) - 1)*100
FinFuncion

Funcion DefinirTasaNominal(tipoTasa Por Referencia, tipoPeriodo Por Referencia, capitalizacion Por Referencia)
	
	
    Escribir "Ingrese el tipo de tasa (nominal/efectiva): "
	Leer tipoTasa
	Si Mayusculas(tipoTasa) = "NOMINAL" Entonces
		Escribir "Ingrese el tipo de periodo (mensual, bimestral, etc): "
		Leer tipoPeriodo
		Escribir "Ingrese el tipo de capitalización (mensual, bimestral, etc):"
		Leer capitalizacion
		
	FinSi
	
FinFuncion

Algoritmo DescuentoComercial
	
	//Datos de entrada
	Definir tipoTasa, TNc, tipoTasaNominal, TEAc, TEP, d, TEAm, TCEA como Reales
	Definir valorNominal, valorConRetencion, valorNeto, Dscto, valorRecibido, valorEntregado, retencion como Reales
	Definir periodoEnDias, tipoPeriodo, capitalizacion como Real
	
	Escribir "Se realizará el factoring con tasa nominal o efectiva?"
	
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
