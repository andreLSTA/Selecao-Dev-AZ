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
                            Edição de unidades
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
                                @click="confirmarEditar"
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
import _ from "lodash";
import { mapActions } from "vuex";
import UnidadeFormulario from "@/components/unidades/UnidadeFormulario.vue";

export default {
    name: "DialogUnidadeEditar",
    components: {
        UnidadeFormulario
    },
    props: {
        value: {
            type: Boolean,
            default: false
        },
        unidadeId: {
            type: Number,
            default: -1
        },
        unidadeParaEditar: {
            type: Object,
            default: () => ({}),
            required: true
        }
    },
    data: () => ({
        unidade: {},
        unidadeForValida: false
    }),
    watch: {
        unidadeParaEditar() {
            this.unidade = _.cloneDeep(this.unidadeParaEditar)
        }
    },
    methods: {
        ...mapActions("unidades", ["editarUnidade"]),
        ...mapActions("alertas", ["adicionarAlerta"]),
        setUnidadeForValida(unidadeForValida) {
            this.unidadeForValida = unidadeForValida;
        },
        async confirmarEditar() {
            if (!this.unidadeForValida) {
                return;
            }

            const requestBody = {
                unidade: this.unidade,
                unidadeId: this.unidadeId
            };

            const response = await this.editarUnidade(requestBody);
            if (!response.sucesso) {
                return;
            }

            this.adicionarAlerta({ mensagem: response.mensagem, tipo: "success" });
            this.$emit("editar");
        }
    }
};
</script>
