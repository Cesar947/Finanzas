<template>
<v-layout align-start>
    <v-flex>
        <v-toolbar flat color="white">
            <v-toolbar-title>Ordenes</v-toolbar-title>
            <v-divider class="mx-2" inset vertical></v-divider>
            <v-spacer></v-spacer>

            <v-btn v-if="verNuevo==0" @click="mostrarNuevo" color="primary" dark class="mb-2">Nuevo</v-btn>

            <v-dialog v-model="verMedicamentos" max-width="1000px">
                <v-card>
                    <v-card-title>
                        <span class="headline">Seleccione un medicamento</span>
                    </v-card-title>
                    <v-card-text>
                        <v-container grid-list-md>
                            <v-layout wrap>
                                <v-flex xs12 sm12 md12 lg12 xl12>
                                    <v-text-field append-icon="search" class="text-xs-center" v-model="texto" label="Ingrese medicamento a buscar" @keyup.enter="listarMedicamento()">

                                    </v-text-field>
                                    <template>
                                        <v-data-table :headers="cabeceraMedicamentos" :items="medicamentos" class="elevation-1">
                                            <template slot="items" slot-scope="props">
                                                <td class="justify-center layout px-0">
                                                    <v-icon small class="mr-2" @click="agregarDetalle(props.item)">
                                                        add
                                                    </v-icon>
                                                </td>
                                                <td>{{props.item.id }}</td>
                                                <td>{{props.item.name }}</td>
                                                <td>{{props.item.price}}</td>
                                            </template>
                                            <template slot="no-data">
                                                <h3>No hay medicamentos para mostrar.</h3>
                                            </template>
                                        </v-data-table>
                                    </template>
                                </v-flex>
                            </v-layout>
                        </v-container>
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn @click="ocultarMedicamentos()" color="blue darken" flat>
                            Cancelar
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </v-toolbar>

        <v-data-table :headers="headers" :items="ordenes" class="elevation-1" v-if="verNuevo==0">

            <template slot="items" slot-scope="props">

                <td>{{ props.item.nombrePaciente}}</td>
                <td>{{ props.item.ordenNro }}</td>
                <td>{{ props.item.pagoMetodo }}</td>
                <td>{{ props.item.total }}</td>

            </template>
            <template slot="no-data">
                <v-btn color="primary" @click="listar">Resetear</v-btn>
            </template>

        </v-data-table>
        

        <v-container grid-list-sm class="pa-4 white" v-if="verNuevo">
            <v-layout row wrap>
                <v-flex xs12 sm4 md4 lg4 xl4>
                    <v-select v-model="metodoPago" :items="metodosPagos" label="Metodo de Pago">
                    </v-select>
                </v-flex>
                <v-flex xs12 sm4 md4 lg4 xl4>
                    <v-text-field v-model="numeroOrden" label="Numero Orden">
                    </v-text-field>
                </v-flex>

                <v-flex xs12 sm8 md8 lg8 xl8>
                    <v-select v-model="pacienteId" :items="pacientes" label="Paciente">
                    </v-select>
                </v-flex>

                <v-flex xs12 sm4 md4 lg4 xl4>
                    <v-text-field v-model="total" label="Total">
                    </v-text-field>
                </v-flex>

                <v-flex xs12 sm2 md2 lg2 xl2>
                    <v-btn @click="mostrarMedicamentos()" small fab dark color="teal">
                        <v-icon dark>list</v-icon>
                    </v-btn>
                </v-flex>

                <v-flex xs12 sm2 md2 lg2 xl2 v-if="errorMedicamento">
                    <div class="red--text" v-text="errorMedicamento">
                    </div>
                </v-flex>

                <v-flex xs12 sm12 md12 lg12 xl12>
                    <v-data-table :headers="cabeceraDetalles" :items="detalles" hide-actions class="elevation-1">
                        <template slot="items" slot-scope="props">
                            <td class="justify-center layout px-0">
                                <v-icon small class="mr-2" @click="eliminarDetalle(detalles,props.item)">
                                    delete
                                </v-icon>
                            </td>
                            <td>{{props.item.nombreMedicamento}}</td>
                            <td>
                                <v-text-field type="number" v-model="props.item.cantidad"></v-text-field>
                            </td>
                            <td>
                                <v-text-field type="number" v-model="props.item.precio"></v-text-field>
                            </td>
                            <td>$ {{props.item.cantidad * props.item.precio}}</td>
                        </template>
                        <template slot="no-data">
                            <h3>No hay medicamentos agregados al detalle.</h3>
                        </template>
                    </v-data-table>
                </v-flex>

                <v-flex xs12 sm12 md12 lg12 xl12>
                    <v-btn @click="ocultarNuevo()" color="blue darken-1" flat>Cancelar</v-btn>
                    <v-btn @click="guardar()" color="success">Guardar</v-btn>
                </v-flex>
            </v-layout>
        </v-container>
    </v-flex>
</v-layout>
</template>

<script>
import axios from 'axios'

export default {
    data() {
        return {

            dialog: false,
            headers: [{
                    text: 'Paciente',
                    value: 'paciente'
                },
                {
                    text: 'Orden Nro',
                    value: 'ordennro'
                },
                {
                    text: 'Metodo Pago',
                    value: 'pagometodo',
                    sortable: false
                },
                {
                    text: 'Total',
                    value: 'total',
                    sortable: false
                }
            ],
            cabeceraDetalles: [{
                    text: 'Borrar',
                    value: 'borrar',
                    sortable: false
                },
                {
                    text: 'Medicamento',
                    value: 'nombreMedicamento',
                    sortable: false
                },
                {
                    text: 'Precio',
                    value: 'precio',
                    sortable: false
                },
                {
                    text: 'Cantidad',
                    value: 'cantidad',
                    sortable: false
                }
            ],
            verNuevo: 0,
            verMedicamentos: 0,

            errorMedicamento: '',
            texto: '',

            detalles: [],
            medicamentos: [],
            pacientes: [],
            ordenes: [],

            
            pacienteId: '',
            metodosPagos: ['Tarjeta', 'Efectivo'],
            metodoPago: '',
            numeroOrden: '',
            total: 0,

            cabeceraMedicamentos: [{
                    text: 'Seleccionar',
                    value: 'seleccionar',
                    sortable: false
                },
                {
                    text: 'Codigo',
                    value: 'codigo'
                },
                {
                    text: 'Medicamento',
                    value: 'medicamento'
                },
                {
                    text: 'Precio',
                    value: 'precio',
                    sortable: false
                }
            ]
        }
    },

    watch: {
        dialog(val) {
            val || this.close()
        }
    },

    created() {
        this.listar();
        this.listarPacientes();
        this.listarMedicamento();
    },

    methods: {
        mostrarNuevo() {
            this.verNuevo = 1;
        },
        ocultarNuevo() {
            this.verNuevo = 0;
            this.limpiar();
        },

        mostrarMedicamentos() {
            this.verMedicamentos = 1;
        },
        ocultarMedicamentos() {
            this.verMedicamentos = 0;
        },

        listarMedicamento() {
            let me = this;

            axios.get('api/medicamento/' + me.texto).then(function (response) {
                console.log(response);
                me.medicamentos = response.data;
            }).catch(function (error) {
                console.log(error);
            });
        },

        listar() {
            let me = this;

            axios.get('api/orden').then(function (response) {
                //console.log(response);
                me.ordenes = response.data;
            }).catch(function (error) {
                console.log(error);
            });
        },

        listarPacientes() {
            let me = this;
            var pacientesArray = [];
            axios.get('api/paciente').then(function (response) {
                // console.log(response.data);
                pacientesArray = response.data;
                pacientesArray.map((p) => {
                    me.pacientes.push({
                        text: p.nombres,
                        value: p.id
                    });
                });
            }).catch(function (error) {
                console.log(error);
            });
        },

        agregarDetalle(data = []) {

            console.log(data);
            this.errorMedicamento = null;
            if (this.encuentra(data['id'])) {
                this.errorMedicamento = "El medicamento ya ha sido agregado."
            } else {
                this.detalles.push({
                    medicamentoId: data['id'],
                    nombreMedicamento: data['name'],
                    cantidad: 1,
                    precio: data['price']
                });
            }
        },

        encuentra(id) {
            var sw = 0;
            for (var i = 0; i < this.detalles.length; i++) {
                if (this.detalles[i].medicamentoId == id) {
                    sw = 1;
                }
            }
            return sw;
        },

        eliminarDetalle(arr, item) {
            var i = arr.indexOf(item);
            if (i !== -1) {
                arr.splice(i, 1);
            }
        },

        guardar() {

            let me = this;

            axios
                .post("api/orden", {
                    pacienteId: me.pacienteId,
                    ordenNro: me.numeroOrden,
                    pagoMetodo: me.metodoPago,
                    total: me.total,
                    detalleOrden: me.detalles
                })
                .then(function (response) {
                    me.ocultarNuevo();
                    me.listar();
                    me.limpiar();
                })
                .catch(function (error) {
                    console.log(error);
                    console.log(me.detalles)
                });
        },

        limpiar() {

            this.pacienteId = '';
            this.metodoPago = '';
            this.numeroOrden='';
            this.detalles = [];
            this.total = 0;
        },

    },

}
</script>