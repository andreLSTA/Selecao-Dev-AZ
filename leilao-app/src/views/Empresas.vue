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
                    <v-data-table
                        :headers="dataTableHeaders"
                        :items="dataTableItems"
                        :items-per-page="10"
                        :loading="carregandoEmpresas"
                    >
                        <template v-slot:top>
                            <v-toolbar flat>
                                <v-toolbar-title>
                                    Empresas
                                </v-toolbar-title>
                                <v-divider
                                    class="mx-4"
                                    inset
                                    vertical
                                ></v-divider>
                                <v-spacer></v-spacer>
                                <v-btn
                                    @click="$router.push('/empresa')"
                                    color="primary"
                                >
                                    Criar empresa
                                </v-btn>
                                <dialog-empresa-deletar
                                    :value="mostrarDialogEmpresaDeletar"
                                    @input="fecharDialogEmpresaDeletar"
                                    :empresaId="empresaIdParaDeletar"
                                    @confirmar="confirmarDeletarEmpresa"
                                >
                                </dialog-empresa-deletar>
                            </v-toolbar>
                        </template>
                        <template v-slot:item.actions="{ item }">
                            <v-icon
                                small
                                class="mr-2"
                                @click="$router.push(`/empresa/${item.id}`)"
                            >
                                mdi-pencil
                            </v-icon>
                            <v-icon
                                small
                                @click="abrirDialogEmpresaDeletar(item.id)"
                            >
                                mdi-delete
                            </v-icon>
                        </template>
                    </v-data-table>
                </v-card>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
import DialogEmpresaDeletar from "@/components/empresas/DialogEmpresaDeletar.vue"

export default {
    name: "Empresas",
    components: {
        DialogEmpresaDeletar
    },
    data: () => ({
        carregandoEmpresas: true,
        dataTableHeaders: [
            {
                text: "CNPJ",
                sortable: true,
                align: "start",
                value: "cnpj"
            },
            {
                text: "Razão social",
                sortable: true,
                align: "start",
                value: "razaoSocial"
            },
            {
                text: "Telefone",
                sortable: true,
                align: "start",
                value: "telefone"
            },
            {
                text: "E-mail",
                sortable: true,
                align: "start",
                value: "email"
            },
            {
                text: "Ações",
                sortable: false,
                align: "center",
                value: "actions",
                width: "100px"
            }
        ],
        mostrarDialogEmpresaDeletar: false,
        empresaIdParaDeletar: -1
    }),
    methods: {
        ...mapActions("empresas", ["buscarEmpresas"]),
        ...mapActions("alertas", ["adicionarAlerta"]),
        abrirDialogEmpresaDeletar(empresaId) {
            this.empresaIdParaDeletar = empresaId;
            this.mostrarDialogEmpresaDeletar = true;
        },
        fecharDialogEmpresaDeletar() {
            this.empresaIdParaDeletar = -1;
            this.mostrarDialogEmpresaDeletar = false;
        },
        async confirmarDeletarEmpresa() {
            await this.carregarEmpresas()
            this.fecharDialogEmpresaDeletar();
        },
        async carregarEmpresas() {
            this.carregandoEmpresas = true;
            const response = await this.buscarEmpresas();
            this.carregandoEmpresas = false;

            return response;
        }
    },
    computed: {
        ...mapGetters("empresas", ["getEmpresas"]),
        dataTableItems() {
            return this.getEmpresas.map(empresa => ({
                id: empresa.id,
                cnpj: empresa.cnpj,
                razaoSocial: empresa.razaoSocial,
                telefone: empresa.telefone,
                email: empresa.email
            }));
        }
    },
    async created() {
        const response = await this.carregarEmpresas();
        this.adicionarAlerta({ mensagem: response.mensagem, tipo: "success" });
    }
};
</script>
