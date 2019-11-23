<template>
    
    <layout align-start>
       
       <v-data-table :headers="headers" :items="detalles" class="elevation-1">
        <template slot="items" slot-scope="props">
       
          
          <td>{{ props.item.reciboHonorarios.id }}</td>
          <td>{{props.item.reciboHonorarios.montoNeto}}</td>
          <td>{{props.item.numeroPeriodoDias}}</td>
          <td>{{ props.item.porcentajeTasaDescontada }}</td>
          <td>{{ props.item.montoDescontado}}</td>
          <td>{{ props.item.montoValorNeto }}</td>
          <td>{{ props.item.montoValorRecibido }}</td>
           <td>{{ props.item.montoValorEntregado }}</td>
            <td>{{ props.item.tcea }}</td>

        </template>
        <template slot="no-data">
          <v-btn color="primary" @click="listar">Resetear</v-btn>
        </template>
      </v-data-table>
         


    </layout>
</template>>


<script>
export default {
 
   data(){

        return{
             detalles: [],
             resultado,
             headers: [
        { text: "Campos", value: "campos", sortable: false },
        {text: "Selección", value: "seleccion",sortable: false},
        { text: "Código de recibo", value: "codigo" },
        { text: "Valor Nominal", value: "valorNominal" },
        { text: "Periodo en días", value: "numDias" },
        { text: "Tasa de descuento", value: "tasaDescuento"},
        { text: "Descuento", value: "montoDescontado" },
        { text: "Valor Neto", value: "valorNeto" },
        { text: "Valor Recibido", value: "valorRecibido" },
        { text: "Valor Entregado", value: "valorEntregado" },
        { text: "TCEA", value: "tcea" }
         ]
        };
    },
    


}
</script>