<template>
    <v-form
        ref="unidadeFormulario"
        lazy-validation
    >
        <v-container>
            <v-row>
                <v-col
                    cols="12"
                    sm="6"
                    md="4"
                >
                    <v-text-field
                        label="Nome *"
                        v-model="unidade.nome"
                        :rules="nomeRules"
                        :counter="128"
                        clearable
                    >
                    </v-text-field>
                </v-col>
            </v-row>
        </v-container>
    </v-form>
</template>
<script>
import _ from "lodash";

export default {
    name: "UnidadeFormulario",
    props: {
        value: {
            type: Object
        }
    },
    data: () => ({
        unidade: {
            nome: ""
        },
        nomeRules: [
            nome => !!nome || "O nome é obrigatório.",
            nome => (nome || '').length <= 128 || "O nome deve possuir no máx. 128 caracteres."
        ]
    }),
    watch: {
        value() {
            if (!_.isEqual(this.unidade, this.value)) {
                this.copiarDadosParaEdicao();
            }
        },
        unidade: {
            handler() {
                this.emitirUnidadeEValidacao();
            },
            deep: true
        }
    },
    methods: {
        copiarDadosParaEdicao() {
            this.unidade = _.cloneDeep(this.value);
        },
        emitirValidacao() {
            this.$emit('validar', this.$refs.unidadeFormulario.validate())
        },
        emitirUnidade() {
            this.$emit('input', this.unidade)
        },
        emitirUnidadeEValidacao() {
            this.emitirUnidade();
            this.emitirValidacao();
        }
    }
};
</script>
