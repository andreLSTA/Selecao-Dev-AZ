<template>
    <div>
        <v-snackbar
            v-for="(alerta, alertaIndex) in getAlertas"
            :key="alertaIndex"
            :value="!alertaIndex"
            :color="alerta.tipo"
            absolute
            bottom
            :timeout="-1"
        >
            <template v-slot:action="{ attrs }">
                <v-icon
                    @click="removerAlerta(alerta.id)"
                    v-bind="attrs"
                    class="ml-4"
                >
                    mdi-close
                </v-icon>
            </template>
            <v-alert
                :type="alerta.tipo"
                class="ma-0 pa-0"
            >
                {{ alerta.mensagem }}
            </v-alert>
        </v-snackbar>
    </div>
</template>
<script>
import { mapGetters, mapActions } from "vuex";

export default {
    name: 'AppAlerta',
    computed: {
        ...mapGetters("alertas", ["getAlertas"])
    },
    methods: {
        ...mapActions("alertas", ["removerAlerta"])
    }
};
</script>
<style scoped>
.v-snack {
    z-index: 999 !important;
}
</style>
