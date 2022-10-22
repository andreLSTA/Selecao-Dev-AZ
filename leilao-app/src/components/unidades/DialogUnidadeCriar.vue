<template>
    <v-dialog
        :value="value"
        @input="$emit('input', false)"
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
                            Criação de unidades
                        </v-card-title>
                        <v-card-text>
                            <unidade-formulario
                                v-model="unidade"
                                @validar="setUnidadeForValida"
                            />
                        </v-card-text>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn
                                @click="$emit('input', false)"
                                color="primary"
                                elevation="0"
                                text
                            >
                                Cancelar
                            </v-btn>
                            <v-btn
                                @click="confirmarCriar"
                                color="primary"
                            >
                                Salvar
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
import UnidadeFormulario from "@/components/unidades/UnidadeFormulario.vue";

export default {
    name: "DialogUnidadeCriar",
    components: {
        UnidadeFormulario
    },
    props: {
        value: {
            type: Boolean,
            default: false
        }
    },
    data: () => ({
        unidade: {},
        unidadeForValida: false
    }),
    methods: {
        ...mapActions("unidades", ["criarUnidade"]),
        ...mapActions("alertas", ["adicionarAlerta"]),
        setUnidadeForValida(unidadeForValida) {
            this.unidadeForValida = unidadeForValida;
        },
        async confirmarCriar() {
            if (!this.unidadeForValida) {
                return;
            }

            const requestBody = this.unidade;
            const response = await this.criarUnidade(requestBody);
            if (!response.sucesso) {
                return;
            }

            this.adicionarAlerta({ mensagem: response.mensagem, tipo: "success" });
            this.$emit("criar");
        }
    }
};
</script>
