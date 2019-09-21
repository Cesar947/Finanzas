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

Funcion d <- CalculoTasaDescontada (TEP)
	d <- ((TEP/100)/(1 + TEP/100))*100
FinFuncion

Funcion d <- CalculoTasaDescontadaConTasaNominal(TN, tipoPeriodo, capitalizacion, periodoEnDias)
	Definir m, n como Reales
	m = ConversionADias(tipoPeriodo)/ConversionADias(capitalizacion)
	n = 360/ ConversionADias(capitalizacion)
	TEA <- (1 + TN/m)^(n) - 1
	TEP <- ((1 + TEA/100)^(periodoEnDias/360) - 1)*100
	d <- CalculoTasaDescontada(TEP)
FinFuncion	

Funcion d <- CalculoTasaDescontadaConTasaEfectivaAnual(TEA, periodoEnDias)
	TEP <- ((1 + TEA/100)^(periodoEnDias/360) - 1)*100
	d <- CalculoTasaDescontada(TEP)
FinFuncion

Funcion TCEA <- CalculoTasaCosteEfectivaAnual(valorEntregado, valorRecibido, periodoEnDias)
	TCEA <- ((valorEntregado/valorRecibido)^(360/periodoEnDias) - 1)*100
FinFuncion


Funcion valorRecibido <- CalculoDelValorRecibido(valorNominal, d, Dscto Por Referencia, valorNeto Por Referencia) 
	Dscto <- (d/100)*valorNominal
	valorNeto <- valorNominal - Dscto
	Escribir "El valor descontado es:"
	Escribir trunc(Dscto*100)/100
	Escribir "El valor neto es:"
	Escribir trunc(valorNeto*100)/100
    pago = 0
	hayGastosOComisiones = "SI"
    valorRecibido <- valorNeto    
	Escribir "Quiere ingresar algun gasto o comision? (si/no): "
	Leer hayGastosOComisiones
	Mientras Mayusculas(hayGastosOComisiones) = "SI" Hacer
		Escribir "Ingrese el monto del gasto o comision: "
		Leer pago
		valorRecibido <- valorRecibido - pago
		Escribir "Quiere ingresar más gastos o comisiones? (si/no)"
		Leer hayGastosOComisiones
	Fin Mientras
FinFuncion

Funcion valorEntregado <- CalculoDelValorEntregado(valorNominal, Dscto)
	Escribir "El valor nominal que se tiene que entregar es: "
	Escribir trunc(valorNominal*100)/100
	valorEntregado = valorNominal - Dscto 
	Escribir "El valor entregado otorgando el monto descontado es: "
	Escribir trunc(valorEntregado*100)/100
	Escribir "Quiere ingresar algun gasto o comision? (si/no): "
	Leer hayGastosOComisiones
	Mientras Mayusculas(hayGastosOComisiones) = "SI" Hacer
		Escribir "Ingrese el monto del gasto o comision: "
		Leer pago
		valorEntregado <- valorEntregado - pago
		Escribir "Quiere ingresar más gastos o comisiones? (si/no)"
		Leer hayGastosOComisiones
	Fin Mientras
	valorEntregado <- valorNeto - sumGastos
FinFuncion


Funcion ProcedimientoConTasaNominal(tipoPeriodo Por Referencia, capitalizacion Por Referencia, TNc Por Referencia)
	Escribir "Ingrese el tipo de periodo (mensual, bimestral, etc): "
	Leer tipoPeriodo
	Escribir "Ingrese el tipo de capitalización (mensual, bimestral, etc):"
	Leer capitalizacion
	Escribir "Ingrese el valor de la tasa en porcentaje"
	Leer TNc
FinFuncion

Algoritmo DescuentoComercial
	
	//Datos de entrada
	Definir TNc, TEAc, d, TEAm, TCEA como Reales
	Definir valorNominal, valorNeto, Dscto, valorRecibido, valorEntregado, periodoEnDias como Reales
	Definir tipoTasa, tipoPeriodo, capitalizacion como Cadena
	
	Escribir "Ingrese el valor del monto por honorarios:"
	Leer valorNominal
	
	Si (valorNominal >= 1500) Entonces
		valorNominal <- (92/100)*valorNominal
	FinSi
	
	Escribir "Se realizará el factoring con tasa nominal o efectiva?"
	Leer tipoTasa
	Si Mayusculas(tipoTasa) = "NOMINAL" Entonces
		ProcedimientoConTasaNominal(tipoPeriodo,capitalizacion, TNc)
	SiNo
		Escribir "Ingrese el valor de la tasa en procentaje: "
		Leer TEAc
	FinSi
	
	Escribir "Ingrese el periodo pactado de vencimiento:"
	Leer periodoEnDias
	
	Si Mayusculas(tipoTasa) = "NOMINAL" Entonces
		d <- CalculoTasaDescontadaConTasaNominal(TNc, tipoPeriodo, capitalizacion, periodoEnDias)
	SiNo
		d <- CalculoTasaDescontadaConTasaEfectivaAnual(TEAc, periodoEnDias)
	FinSi
	
	Escribir "La tasa de descuento es:"
	Escribir d "%"
	
	valorRecibido <- CalculoDelValorRecibido(valorNominal, d, Dscto , valorNeto) 
	
	
	Escribir "El valor recibido con las comisiones, gastos, seguros aplicados:"
	Escribir trunc(valorRecibido*100)/100
	
	valorEntregado <- CalculoDelValorEntregado(valorNominal, Dscto)
	Escribir "El valor entregado será de: "
	Escribir trunc(valorEntregado*100)/100
	
	TCEA<-CalculoTasaCosteEfectivaAnual(valorEntregado, valorRecibido, periodoEnDias)
	Escribir "La tasa de coste efectiva anual es de: "
	Escribir TCEA "%"
	
	
FinAlgoritmo
