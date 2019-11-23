<template>
  <v-layout align-start>
    <v-flex>
      <v-toolbar flat color="white">
        <v-toolbar-title>Simulación</v-toolbar-title>
        
        <v-spacer></v-spacer>
        <v-text-field
          class="text-xs-center"
          v-model="search"
          append-icon="search"
          label="Búsqueda"
          single-line
          hide-details
        ></v-text-field>
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
        
        <v-dialog>
          <v-btn slot="activator" color="info" dark class="mb-2">Ingresar condiciones</v-btn>
           <v-card>
            <v-card-title>
              <span class="headline">{{ conditionsTitle }}</span>
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

      </v-toolbar>
      <v-data-table :headers="headers" :items="detalles" :search="search" class="elevation-1">
        <template slot="items" slot-scope="props">
         <!-- <td class="justify-center layout px-0">
            <v-icon small class="mr-2" @click="editItem(props.item)">edit</v-icon>
          </td>-->
              
         
           <td>{{ props.item.reciboHonorarios.id }}</td>
          <td>{{parseFloat(Math.round(props.item.reciboHonorarios.montoNeto * 100) / 100).toFixed(2)}}</td>
          <td>{{props.item.numeroPeriodoDias}}</td>
          <td>{{ props.item.porcentajeTasaDescontada }}</td>
          <td>{{ parseFloat(Math.round(props.item.montoDescontado* 100) / 100).toFixed(2)}}</td>
          <td>{{parseFloat(Math.round(props.item.montoValorNeto* 100) / 100).toFixed(2)  }}</td>
          <td>{{ parseFloat(Math.round(props.item.montoValorRecibido * 100) / 100).toFixed(2)}}</td>
           <td>{{ parseFloat(Math.round(props.item.montoValorEntregado* 100) / 100).toFixed(2) }}</td>
            <td>{{ props.item.tcea }}</td>

        
         
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
export default {
  data() {
    return {
      detalles: [],
      dialog: false,
      headers: [
        { text: "Codigo", value: "campos", sortable: false },
        { text: "Valor Nominal", value: "seleccion",sortable: false},
        { text: "Días", value: "codigo" },
        { text: "D%", value: "emisor" },
        { text: "Descuento", value: "cliente" },
        { text: "Valor Neto", value: "tipoMoneda"},
        { text: "Valor Recibido", value: "montoTota" },
        { text: "Valor entregado", value: "retencionIr" },
        { text: "TCEA %", value: "montoNeto" }
      
      ],
      search: "",
      editedIndex: -1,
      editarEdicion: -1,
      //Model
      codigo: "",
      tipoMoneda: "",
      montoTotal: "",
      retencionIr: "",
      montoNeto: "",
      tipoServicio: "",
      observacion: "",
      fechaEmision: "",
      fechaVencimiento: "",
      factId: 1,
      //Factoring




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

  watch: {
    dialog(val) {
      val || this.close();
    }
  },

  created() {
    this.listar();
  },
  methods: {
    listar() {
      let me = this;
      axios
        .get("/detallefactoring?factId=" + 1)
        .then(function(response) {
          //
          me.detalles = response.data;
          

        })
        .then(function(response){
          console.log("oli");
        })
        .catch(function(error) {
          console.log(error);
        });
    },



    /*
    editItem(item) {
      this.id = item.id;
      this.nombres = item.nombres;
      this.apellidos = item.apellidos;
      this.dni = item.dni;
      this.direccion = item.direccion;
      this.telefono = item.telefono;

      this.editedIndex = 1;
      this.dialog = true;
    },

  

    close() {
      this.dialog = false;
    },
    limpiar() {
      this.id = "";
      this.nombres = "";
      this.apellidos = "";
      this.dni = "";
      this.direccion = "";
      this.telefono = "";
    },
    guardar() {
      if (this.editedIndex > -1) {
        //Código para editar

        let me = this;
        axios 
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
      } else {
        //Código para guardar
        let me = this;
        axios
          .post("api/paciente", {
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
      }
    }*/
  }
};
</script>