<template>
  <v-layout align-start>
    <v-flex>
      <v-toolbar flat color="white">
        <v-toolbar-title>Recibos</v-toolbar-title>
        
        <v-spacer></v-spacer>
       
        <v-spacer></v-spacer>
        <v-dialog v-model="dialog" max-width="500px">
          <v-btn slot="activator" color="primary" dark class="mb-2">Nuevo</v-btn>
          <v-card>
            <v-card-title>
              <span class="headline">{{ formTitle }}</span>
            </v-card-title>
            <v-card-text>
              <v-container grid-list-md>
                <v-layout wrap>
                  <v-flex xs12 sm12 md12>
                    <v-text-field v-model="codigo" label="Código"></v-text-field>
                  </v-flex>
                  <v-flex xs6 >
                    <v-select v-model="tipoMoneda" :items="monedas" label="Tipo de moneda">
                    </v-select>
                 </v-flex>
                  <v-flex xs12 sm12 md12>
                    <v-text-field v-model="montoTotal" label="Monto total"></v-text-field>
                  </v-flex>
                  <v-flex xs12 sm12 md12>
                    <v-text-field v-model="retencionIr" label="Retención (IR)"></v-text-field>
                  </v-flex>
                  <v-flex xs12 sm12 md12>
                    <v-text-field v-model="montoNeto" label="Monto Neto"></v-text-field>
                  </v-flex>
                  <v-flex xs12 sm12 md12>
                    <v-text-field v-model="tipoServicio" label="Tipo de servicio"></v-text-field>
                  </v-flex>
                  <v-flex xs12 sm12 md12>
                    <v-text-field v-model="observacion" label="Observación"></v-text-field>
                  </v-flex>
                    <v-flex xs12 sm12 md12>
                    <v-text-field v-model="fechaEmision" label="Fecha de emisión"></v-text-field>
                  </v-flex>
                    <v-flex xs12 sm12 md12>
                    <v-text-field v-model="fechaVencimiento" label="Fecha de vencimiento"></v-text-field>
                  </v-flex>
                
                </v-layout>
              </v-container>
            </v-card-text>
            
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" flat @click.native="close">Cancelar</v-btn>
              <v-btn color="blue darken-1" flat @click.native="guardar">Guardar</v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        
        <v-dialog v-model="dialogD" max-width="500px">
          <v-btn slot="activator" color="info" dark class="mb-2">Ingresar condiciones</v-btn>
           <v-card>
            <v-card-title>
              <span class="headline">{{ conditionsTitle }}</span>
            </v-card-title>
            <v-card-text>
              <v-container grid-list-md>
                <v-layout wrap>
                  <v-flex xs12 sm12 md12>
                    <v-text-field v-model="tipoTasa" label="Tipo de tasa"></v-text-field>
                  </v-flex>
                  <v-flex xs12 sm12 md12>
                    <v-text-field v-model="capitalizacion" label="Capitalizacón"></v-text-field>
                  </v-flex>
                   <v-flex xs12 sm12 md12>
                    <v-text-field v-model="porcentajeTasaFactoring" label="Valor de la tasa"></v-text-field>
                  </v-flex>
                  <v-flex xs6 >
                    <v-select v-model="tipoMoneda" :items="monedas" label="Tipo de moneda">
                    </v-select>
                 </v-flex>
                   <v-menu
        ref="startMenu"
        v-model="startMenu"
        :close-on-content-click="false"
        :nudge-right="40"
        :return-value.sync="fechaDescuento"
        transition="scale-transition"
        min-width="290px"
        offset-y
        full-width
      >
        <template v-slot:activator="{ on }">
          <v-text-field
            v-model="fechaDescuento"
            label="Fecha de descuento"
            prepend-icon="event"
            readonly
            v-on="on"
          ></v-text-field>
        </template>
        <v-date-picker
          v-model="fechaDescuento"
          no-title
          scrollable
        >
          <v-spacer></v-spacer>
          <v-btn
            text
            color="primary"
            @click="startMenu = false"
          >
            Cancel
          </v-btn>
          <v-btn
            text
            color="primary"
            @click="$refs.startMenu.save(fechaDescuento)"
          >
            OK
          </v-btn>
        </v-date-picker>
      </v-menu>
              
                </v-layout>
              </v-container>
            </v-card-text>
            
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" flat @click.native="close">Cancelar</v-btn>
              <v-btn color="blue darken-1" flat @click.native="guardar">Guardar</v-btn>
            </v-card-actions>
          </v-card>


        </v-dialog>

      </v-toolbar>
      <v-data-table :headers="headers" :items="recibos"  class="elevation-1">
        <template slot="items" slot-scope="props">
          <td class="justify-center layout px-0">
            <v-icon small class="mr-2" @click="editItem(props.item)">edit</v-icon>
          </td>
              
          <td style=".ckbox">
             <v-checkbox v-model="seleccionado" :single-select="singleSelect" class="justify-center layout px-0"> </v-checkbox>
          </td>
          <td>{{ props.item.id }}</td>
          <td>{{props.item.emisor.nombres + props.item.emisor.apellidos}}</td>
          <td>{{props.item.cliente.nombre}}</td>
          <td>{{ props.item.tipoMoneda }}</td>
          <td>{{ props.item.montoHonorarios}}</td>
          <td>{{ props.item.retencionIR }}</td>
          <td>{{ props.item.montoNeto }}</td>
           
            <td>{{ props.item.fechaEmision }}</td>
            <td>{{ props.item.fechaVencimiento}}</td>
             <td>{{ props.item.tipoServicio }}</td>
            <td>{{ props.item.observacion }}</td>  
        
         
        </template>
        <template slot="no-data">
          <v-btn color="primary" @click="listar">Resetear</v-btn>
        </template>
      </v-data-table>
    </v-flex>
   
  </v-layout>
</template>

<script>
import axios from "axios";
import recibos from "./../assets/recibos.css";

export default {

  data() {
    return {
    
      recibos: [],
      dialog: false,
      dialogD: false,
      startMenu: false,
      singleSelect: true,
      headers: [
        { text: "Campos", value: "campos", sortable: false },
        {text: "Selección", value: "seleccion",sortable: false},
        { text: "Código", value: "codigo" },
        { text: "Emisor", value: "emisor" },
        { text: "Cliente", value: "cliente" },
        { text: "Moneda", value: "tipoMoneda"},
        { text: "Monto Total", value: "montoTota" },
        { text: "Retención (IR)", value: "retencionIr" },
        { text: "Monto Neto", value: "montoNeto" },
        { text: "Fecha de emisión", value: "montoNeto" },
        { text: "Fecha de vencimiento", value: "montoNeto" },
        { text: "Tipo de servicio", value: "montoNeto" },
        { text: "Observación", value: "montoNeto" }
      ],
      search: "",
      editedIndex: -1,
      editarEdicion: -1,
      //Model Recibo
      codigo: "",
      tipoMoneda: "",
      montoTotal: "",
      retencionIr: "",
      montoNeto: "",
      tipoServicio: "",
      observacion: "",
      fechaEmision: "",
      fechaVencimiento: "",
      emisor: "",
      cliente: "",

      //Model Factoring
      tipoTasa: "",
      capitalizacion: "",
      tipoMoneda: "",
      porcentajeTasaFactoring: "",
      fechaDescuento: "",

     recibo: "",

      monedas: [
        "Soles", "Dólares"
      ],
      seleccionado: false
    };
  },
  computed: {
    formTitle() {
      return this.editedIndex === -1 ? "Nuevo Recibo" : "Actualizar Recibo";
    },

    conditionsTitle(){
      return this.editarEdicion === -1 ? "Datos de Factoring" : "Edición de datos de Factoring"
    }
  },

  /*watch: {
    dialog(val) {
      val || this.close();
    }
  },*/

  created() {
    this.listar();
  },
  methods: {
    listar() {
      let me = this;
      axios
        .get("recibosHonorarios")
        .then(function(response) {
          //
          me.recibos = response.data;
         

        })
        .then(function(response){
          console.log("oli");
        })
        .catch(function(error) {
          console.log(error);
        });
    },



    
    editItem(item) {
      this.codigo = "",
      this.tipoMoneda = "",
      this.montoTotal = "",
      this.retencionIr = "",
      this.montoNeto = "",
      this.tipoServicio = "",
      this.observacion = "",
      this.fechaEmision = "",
      this.fechaVencimiento = "",
      this.emisor = "",
      this.cliente = ""
      this.editedIndex = 1;
      this.dialog = true;
    },

  

    close() {
      this.dialog = false;
      this.dialogD = false;
    },
    limpiar() {
            this.codigo = "",
            this.tipoMoneda = "",
            this.montoTotal = "",
            this.retencionIr = "",
            this.montoNeto = "",
            this.tipoServicio = "",
            this.observacion = "",
            this.fechaEmision = "",
            this.fechaVencimiento = "",
            this.emisor = "",
            this.cliente = ""
    },
    guardar() {
      if (this.editedIndex > -1) {
        //Código para editar

        let me = this;
      /*  axios 
          .put("api/paciente", {
            id: me.id,
            nombres: me.nombres,
            apellidos: me.apellidos,
            dni: me.dni,
            direccion: me.direccion,
            telefono: me.telefono
          })
          .then(function(response) {
            me.close();
            me.listar();
            me.limpiar();
          })
          .catch(function(error) {
            console.log(error);
          });
      } else {*/
        //Código para guardar
       // let me = this;
        axios
          .post("recibosHonorarios/registro", {
            codigo: me.codigo,
            tipoMoneda: me.tipoMoneda,
            montoTotal: me.montoTotal,
            retencionIr: me.retencionIr,
            montoNeto: me.montoNeto,
            tipoServicio: me.tipoServicio,
            observacion: me.observacion,
            fechaEmision: me.fechaEmision,
            fechaVencimiento: me.fechaVencimiento,
            emisor: me.emisor,
            cliente: me.cliente,
          })
          .then(function(response) {
            me.recibo = response.data
            me.close();
            me.listar();
            me.limpiar();
          })
          .catch(function(error) {
            console.log(error);
          });
      }
    }
  }
};
</script>