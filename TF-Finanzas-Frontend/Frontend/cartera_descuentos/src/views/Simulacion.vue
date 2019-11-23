<template>
    <layout align-start>
       <v-data-table :items="detalles" class="elevation-1">
        <template slot="items" slot-scope="props">
          <!--<td class="justify-center layout px-0">
            <v-icon small class="mr-2" @click="editItem(props.item)">edit</v-icon>
          </td>-->
              
          <td style=".ckbox">
             <v-checkbox v-model="seleccionado" > </v-checkbox>
          </td>
          <td>{{ props.item.id }}</td>
          <td>{{props.item.emisor.nombres + props.item.emisor.apellidos}}</td>
          <td>{{props.item.cliente.nombre}}</td>
          <td>{{ props.item.tipoMoneda }}</td>
          <td>{{ props.item.montoHonorarios}}</td>
          <td>{{ props.item.retencionIR }}</td>
          <td>{{ props.item.montoNeto }}</td>
           <td>{{ props.item.tipoServicio }}</td>
            <td>{{ props.item.observacion }}</td>
            <td>{{ props.item.fechaEmision }}</td>
            <td>{{ props.item.fechaVencimiento}}</td>

        
         
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
             resultado
        };
    },
    


}
</script>>