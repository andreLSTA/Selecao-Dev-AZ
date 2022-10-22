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
                            Tem certeza que deseja remover essa unidade?
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
                                @click="confirmarDeletarUnidade"
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
    name: "DialogUnidadeDeletar",
    props: {
        value: {
            type: Boolean,
            default: false
        },
        unidadeId: {
            type: Number,
            default: -1
        }
    },
    methods: {
        ...mapActions("unidades", ["deletarUnidade"]),
        ...mapActions("alertas", ["adicionarAlerta"]),
        async confirmarDeletarUnidade() {
            const response = await this.deletarUnidade(this.unidadeId);
            this.adicionarAlerta({ mensagem: response.mensagem, tipo: "success" });
            this.$emit("confirmar");
        },
        fecharDialog() {
            this.$emit('input', false)
        }
    }
};
</script>
