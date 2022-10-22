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
                        Criação de empresas
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
</template>
<script>
import { mapActions } from "vuex";
import EmpresaFormulario from "@/components/empresas/EmpresaFormulario.vue";

export default {
    name: "EmpresaCriar",
    components: {
        EmpresaFormulario
    },
    data: () => ({
        empresa: {},
        empresaForValida: false
    }),
    methods: {
        ...mapActions("empresas", ["criarEmpresa"]),
        ...mapActions("alertas", ["adicionarAlerta"]),
        setEmpresaForValida(empresaForValida) {
            this.empresaForValida = empresaForValida;
        },
        async confirmarCriar() {
            if (!this.empresaForValida) {
                return;
            }

            const requestBody = this.empresa;
            const response = await this.criarEmpresa(requestBody);
            if (!response.sucesso) {
                return;
            }

            this.adicionarAlerta({ mensagem: response.mensagem, tipo: "success" });
        }
    }
};
</script>
