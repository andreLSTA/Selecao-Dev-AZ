<template>
    <v-container
        fluid
        class="fill-height"
    >
        <v-row
            align="start"
            justify="center"
            class="fill-height"
            no-gutters
        >
            <v-col
                cols="12"
                sm="10"
                md="8"
            >
                <v-card>
                    <v-card-title>
                        Edição de empresas
                    </v-card-title>
                    <v-card-text>
                        <empresa-formulario
                            v-model="empresa"
                            @validar="setEmpresaForValida"
                        />
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
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
</template>
<script>
import { mapActions } from "vuex";
import EmpresaFormulario from "@/components/empresas/EmpresaFormulario.vue";

export default {
    name: "EmpresaEditar",
    components: {
        EmpresaFormulario
    },
    data: () => ({
        empresa: {},
        empresaForValida: false
    }),
    watch: {
        '$route.params.empresaId': {
            async handler(empresaId) {
                console.log(empresaId)
                const response = await this.buscarEmpresaPorId(empresaId || null);
                if (!response.sucesso) {
                    return;
                }

                this.empresa = response.dados;
            },
            deep: true,
            immediate: true
        }
    },
    methods: {
        ...mapActions("empresas", ["editarEmpresa", "buscarEmpresaPorId"]),
        ...mapActions("alertas", ["adicionarAlerta"]),
        setEmpresaForValida(empresaForValida) {
            this.empresaForValida = empresaForValida;
        },
        async confirmarEditar() {
            if (!this.empresaForValida) {
                return;
            }

            const requestBody = {
                empresa: this.empresa,
                empresaId: this.empresa.id
            };
            const response = await this.editarEmpresa(requestBody);
            if (!response.sucesso) {
                return;
            }

            this.adicionarAlerta({ mensagem: response.mensagem, tipo: "success" });
        }
    }
};
</script>
