<template>
    <v-layout align-center>
      <v-content>
      <v-container fill-height>
           <v-layout align-start>
            <v-flex class='login-form text-xs-center'>
    <v-tabs
      v-model="tab"
      background-color="deep-purple accent-4"
      class="elevation-2"
      dark
     
      :right="right"
      :prev-icon="prevIcon ? 'mdi-arrow-left-bold-box-outline' : undefined"
      :next-icon="nextIcon ? 'mdi-arrow-right-bold-box-outline' : undefined"
      :icons-and-text="icons"
    >
      <v-tabs-slider></v-tabs-slider>

      <v-tab>
        RUC
      </v-tab>
      <v-tab>
        DNI
      </v-tab>

      <v-tab-item >
             <v-card light>
                <v-card-title>
                    <span class="headline">Inicio de sesión</span>
                </v-card-title>
                <v-card-text>
                 <v-container>
                     <v-layout wrap>
                       <v-flex xs12 sm12 md12>
                            <v-text-field v-model="nRuc" label="RUC"></v-text-field>
                       </v-flex>
                       <v-flex xs12 sm12 md12>
                            <v-text-field v-model="userName" label="Usuario"></v-text-field>
                       </v-flex>
                       <v-flex xs12 sm12 md12>
                            <v-text-field v-model="contrasena" label="Contraseña"></v-text-field>
                       </v-flex>
                       <v-spacer></v-spacer>
                       <v-flex>
                           <v-btn to="/recibos/" color="primary" dark class="mb-2" @click.native="iniciarSesion">Iniciar Sesión</v-btn>
                       </v-flex>
                     </v-layout>
                 </v-container>
              </v-card-text>
             </v-card>
      </v-tab-item>
      <v-tab-item>
          <v-card light>
                <v-card-title>
                    <span class="headline">Inicio de sesión</span>
                </v-card-title>
                <v-card-text>
                 <v-container>
                     <v-layout wrap>
                       <v-flex xs12 sm12 md12>
                            <v-text-field v-model="dni" label="DNI"></v-text-field>
                       </v-flex>
                       <v-flex xs12 sm12 md12>
                            <v-text-field v-model="userName" label="Usuario"></v-text-field>
                       </v-flex>
                       <v-flex xs12 sm12 md12>
                            <v-text-field v-model="contrasena" label="Contraseña"></v-text-field>
                       </v-flex>
                        <v-spacer></v-spacer>
                       <v-flex>
                        
                        <v-btn  color="primary" dark class="mb-2" @click.native="iniciarSesion">Iniciar Sesión</v-btn>
                       </v-flex>
                     </v-layout>
                 </v-container>
              </v-card-text>
             </v-card>
      </v-tab-item>
    </v-tabs> 
        </v-flex>
    </v-layout>
      </v-container>
      </v-content>
    </v-layout>
</template>


<script>
import axios from "axios"
export default{
   
data(){
  return{
   dni: "",
   nRuc:"",
   userName:"",
   contrasena:"",
   emisorId: ""
  }
 
},

iniciarSesionPorRuc(){
  let me = this;

  axios.post("emisor/iniciarRUC", {
      nRuc: me.nRuc,
      userName: me.userName,
      contrasena: me.contrasena
  }).then(function(response){
      me.emisorId = response
  })
},
iniciarSesionPorDNI(){
  let me = this;
  axios.post("emisor/iniciarDNI", {
    dni: me.dni,
    userName: me.userName,
    contrasena: me.contrasena
  }).then(function(response){
    me.emisorId = response
  })
}
    

}

</script>