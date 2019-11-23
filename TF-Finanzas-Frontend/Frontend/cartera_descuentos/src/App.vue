<template>
  <v-app id="app">
    <v-navigation-drawer
      fixed
      :clipped="$vuetify.breakpoint.mdAndUp"
      app
      v-model="drawer"
    >
      <v-list dense>
        <template>
          <v-list-tile :to="{name:'home'}">
            <v-list-tile-action>
              <v-icon>home</v-icon>
            </v-list-tile-action>
            <v-list-tile-title>
              Inicio
            </v-list-tile-title>
          </v-list-tile>
        </template>

        <template>
         
            
            <v-list-tile :to="{ name: 'pacientes'}">
              <v-list-tile-action>
                <v-icon>table_chart</v-icon>
              </v-list-tile-action>
              <v-list-tile-content>
                <v-list-tile-title>
                 ¿Qué es Factoring?
                </v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>
           
           
            <v-list-tile :to="{ name: 'ordenes'}">
              <v-list-tile-action>
                <v-icon>table_chart</v-icon>
              </v-list-tile-action>
              <v-list-tile-content>
                <v-list-tile-title>
                  Pasos a seguir
                </v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>


             <v-list-tile :to="{ name: 'login'}">
              <v-list-tile-action>
                <v-icon>table_chart</v-icon>
              </v-list-tile-action>
              <v-list-tile-content>
                <v-list-tile-title>
                  Ingresar a mi cuenta
                </v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>


             <v-list-tile :to="{ name: 'recibos'}">
              <v-list-tile-action>
                <v-icon>table_chart</v-icon>
              </v-list-tile-action>
              <v-list-tile-content>
                <v-list-tile-title>
                  Mis Recibos
                </v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>


             <v-list-tile :to="{ name: 'simulacion'}">
              <v-list-tile-action>
                <v-icon>table_chart</v-icon>
              </v-list-tile-action>
              <v-list-tile-content>
                <v-list-tile-title>
                  Simulacion
                </v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>


              <v-list-tile :to="{ name: 'preguntas'}">
              <v-list-tile-action>
                <v-icon>table_chart</v-icon>
              </v-list-tile-action>
              <v-list-tile-content>
                <v-list-tile-title>
                  Preguntas Frecuentes
                </v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>


     
        </template>
        
       
        
      </v-list>
    </v-navigation-drawer>
    <v-toolbar
      color="blue darken-3"
      dark
      app
      :clipped-left="$vuetify.breakpoint.mdAndUp"
      fixed
    >
      <v-toolbar-title style="width: 300px" class="ml-0 pl-3">
        <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
        <span class="hidden-sm-and-down">Cartera de descuentos</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn icon>
        <v-icon>apps</v-icon>
      </v-btn>
    </v-toolbar>
    <v-content>
      <v-container fluid fill-height>
        <v-slide-y-transition mode="out-in">
          <router-view/>
        </v-slide-y-transition>
      </v-container>
    </v-content>
    <v-footer dark height="auto">
      <v-layout justify-center>
        <v-flex text-xs-center>
          <v-card flat tile color="primary" class="white--text">
            <v-card-text class="white--text pt-0">
                Finanzas e Ingeniería Económica - Trabajo Final
            </v-card-text>
          </v-card>
        </v-flex>
      </v-layout>
    </v-footer>

  </v-app>
</template>


<script>

export default {
  name: 'App',
  data () {
    return {
      drawer: false,
     }
  }
}
</script>
