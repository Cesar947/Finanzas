<template>
    <layout align-start>
       <v-data-table :headers="headers" :items="detalles" class="elevation-1">
        <template slot="items" slot-scope="props">
          <!--<td class="justify-center layout px-0">
            <v-icon small class="mr-2" @click="editItem(props.item)">edit</v-icon>

          </td>   
          
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

               /*   <td>{{ props.item.reciboHonorarios.id }}</td>
          <td>{{props.item.reciboHonorarios.montoNeto}}</td>
          <td>{{props.item.numeroPeriodoDias}}</td>
          <td>{{ props.item.porcentajeTasaDescontada }}</td>
          <td>{{ props.item.montoDescontado}}</td>
          <td>{{ props.item.montoValorNeto }}</td>
          <td>{{ props.item.montoValorRecibido }}</td>
           <td>{{ props.item.montoValorEntregado }}</td>
            <td>{{ props.item.tcea }}</td>*/ 
        { text: "Campos", value: "campos", sortable: false },
        {text: "Selección", value: "seleccion",sortable: false},
        { text: "Código", value: "codigo" },
        { text: "Emisor", value: "emisor" },
        { text: "Cliente", value: "cliente" },
        { text: "Moneda", value: "tipoMoneda"},
        { text: "Monto Total", value: "montoTota" },
        { text: "Retención (IR)", value: "retencionIr" },
        { text: "Monto Neto", value: "montoNeto" },
        { text: "Tipo de servicio", value: "montoNeto" },
        { text: "Observación", value: "montoNeto" },
        { text: "Fecha de emisión", value: "montoNeto" },
        { text: "Fecha de vencimiento", value: "montoNeto" }
             ]
        };
    },
    


}
</script>>