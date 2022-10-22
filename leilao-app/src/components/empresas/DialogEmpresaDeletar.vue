<template>
    <v-dialog
        :value="value"
        @input="fecharDialog"
        content-class="elevation-0"
    >
        <v-container
            fluid
            class="fill-height"
        >
            <v-row
                align="center"
                justify="center"
                no-gutters
            >
                <v-col
                    cols="12"
                    sm="10"
                    md="8"
                >
                    <v-card>
                        <v-card-title>
                            Tem certeza que deseja remover essa empresa?
                        </v-card-title>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn
                                @click="fecharDialog"
                                color="primary"
                                elevation="0"
                                text
                            >
                                Cancelar
                            </v-btn>
                            <v-btn
                                @click="confirmarDeletarEmpresa"
                                color="primary"
                            >
                                Confirmar
                            </v-btn>
                        </v-card-actions>
                    </v-card>
                </v-col>
            </v-row>
        </v-container>
    </v-dialog>
</template>
<script>
import { mapActions } from "vuex";

export default {
    name: "DialogEmpresaDeletar",
    props: {
        value: {
            type: Boolean,
            default: false
        },
        empresaId: {
            type: Number,
            default: -1
        }
    },
    methods: {
        ...mapActions("empresas", ["deletarEmpresa"]),
        ...mapActions("alertas", ["adicionarAlerta"]),
        async confirmarDeletarEmpresa() {
            const response = await this.deletarEmpresa(this.empresaId);
            this.adicionarAlerta({ mensagem: response.mensagem, tipo: "success" });
            this.$emit("confirmar");
        },
        fecharDialog() {
            this.$emit('input', false)
        }
    }
};
</script>
