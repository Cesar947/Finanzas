 <template>
 <v-layout align-start>
     <v-flex>
          <v-card>
            <v-card-title>
              <span class="headline">{{ formTitle }}</span>
            </v-card-title>
            <v-card-text>
              <v-container grid-list-md>
                <v-layout wrap>
                  <v-flex xs12 sm12 md12>
                    <v-text-field v-model="emisor.dni" label="DNI"></v-text-field>
                  </v-flex>
                  <v-flex xs6 >
                    <v-text-field v-model="emisor.nombres" label="Nombres">
                    </v-text-field>
                 </v-flex>
                  <v-flex xs12 sm12 md12>
                    <v-text-field v-model="emisor.apellidos" label="Apellidos"></v-text-field>
                  </v-flex>
                  <v-flex xs12 sm12 md12>
                    <v-text-field v-model="emisor.nRuc" label="Nro. RUC"></v-text-field>
                  </v-flex>
                  <v-flex xs12 sm12 md12>
                    <v-text-field v-model="emisor.direccion" label="Dirección"></v-text-field>
                  </v-flex>
                  <v-flex xs12 sm12 md12>
                    <v-text-field v-model="emisor.telefono" label="Teléfono"></v-text-field>
                  </v-flex>
                  <v-flex xs12 sm12 md12>
                    <v-text-field v-model="emisor.nombreUsuario" label="Nombre de usuario"></v-text-field>
                  </v-flex>
                    <v-flex xs12 sm12 md12>
                     <v-text-field
                     :append-icon="mostrarContrasena ? 'mdi-eye' : 'mdi-eye-off'"
                     :rules="[rules.required, rules.min]"
                     :type="mostrarContrasena ? 'text' : 'password'"
            
                     label="Contraseña"
                     hint="Mínimo de 8 caractéres"
                     v-model="emisor.contrasena"
                  
                     @click:append="mostrarContrasena = !mostrarContrasena"
                     ></v-text-field>
                  </v-flex>
                  
                
                </v-layout>
              </v-container>
            </v-card-text>
            
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" flat @click.native="close">Cancelar</v-btn>
              <v-btn color="blue darken-1" flat @click.native="guardar">Registrar</v-btn>
            </v-card-actions>
          </v-card>

          </v-flex>
        </v-layout>
</template>

<script>
export default {
    data(){
        return{

         emisor:{
             dni: "",
             nombres: "",
             apellidos: "",
             nRuc: "",
             direccion: "",
             telefono: "",
             nombreUsuario: "",
             contrasena: ""
         },


          mostrarContrasena: false,
          reglas: {
              required: value => !!value || 'Requerido',
              min: v => v.length >= 8 || 'Mínimo 8 caractéres',
              emailMatch: () => ('La contraseña no coincice')
          }

        }
    }
}
</script>>