<template>
  <v-container
    id="grid"
    fluid
    grid-list-sm
    tag="section"
  >
    <v-layout row wrap>
      <v-flex tag="h1" class="headline">Pasos a Seguir</v-flex>
      <v-flex d-flex xs12 order-xs5>
        <v-layout column>
          <v-flex>
            <v-card flat>
              <v-card-text>Registrate : Crea una cuenta llenando el formulario con tus datos 
                personales. En Factoring Calculator nos comprometemos por tu seguridad 
                y el resguardo de tus datos, estrés free!
              </v-card-text>
            </v-card>
          </v-flex>
          <v-flex>
            <v-card flat>
              <v-card-text>Registra tus facturas : Ahora registrar tus recibos por honorarios
                con los cuales realizarás la simulación con tan solo  responder unas preguntas.
              </v-card-text>
            </v-card>
          </v-flex>
            <v-flex>
            <v-card flat>
              <v-card-text>Comienza a calcular : Luego de seleccionar los o el recibo por 
                honorarios con el que realizarás la simulación, solo hace falta llenar unos cuantos datos mas y listo!
              </v-card-text>
            </v-card>
          </v-flex>
                    <v-flex>
            <v-card flat>
              <v-card-text>¿Te quedó alguna duda? : Si te quedaste en alguno de los pasos con dudas, 
                consulta nuestra sección de preguntas frecuentes
              </v-card-text>
            </v-card>
          </v-flex>
        </v-layout>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<style>

</style>

<script>
export default {
  data() {
    return {
    }
  }
}
</script>