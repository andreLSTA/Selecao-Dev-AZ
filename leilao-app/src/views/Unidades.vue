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
                        :loading="carregandoUnidades"
                    >
                        <template v-slot:top>
                            <v-toolbar flat>
                                <v-toolbar-title>
                                    Unidades
                                </v-toolbar-title>
                                <v-divider
                                    class="mx-4"
                                    inset
                                    vertical
                                ></v-divider>
                                <v-spacer></v-spacer>
                                <v-btn
                                    @click="abrirDialogUnidadeCriar"
                                    color="primary"
                                >
                                    Criar unidade
                                </v-btn>
                                <dialog-unidade-criar
                                    :value="mostrarDialogUnidadeCriar"
                                    @input="fecharDialogUnidadeCriar"
                                    @criar="confirmarCriarUnidade"
                                >
                                </dialog-unidade-criar>
                                <dialog-unidade-editar
                                    :value="mostrarDialogUnidadeEditar"
                                    @input="fecharDialogUnidadeEditar"
                                    :unidadeParaEditar="unidadeParaEditar"
                                    :unidadeId="unidadeParaEditar.id"
                                    @editar="confirmarEditarUnidade"
                                >
                                </dialog-unidade-editar>
                                <dialog-unidade-deletar
                                    :value="mostrarDialogUnidadeDeletar"
                                    @input="fecharDialogUnidadeDeletar"
                                    :unidadeId="unidadeIdParaDeletar"
                                    @confirmar="confirmarDeletarUnidade"
                                >
                                </dialog-unidade-deletar>
                            </v-toolbar>
                        </template>
                        <template v-slot:item.actions="{ item }">
                            <v-icon
                                small
                                class="mr-2"
                                @click="abrirDialogUnidadeEditar(item)"
                            >
                                mdi-pencil
                            </v-icon>
                            <v-icon
                                small
                                @click="abrirDialogUnidadeDeletar(item.id)"
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
import DialogUnidadeEditar from "@/components/unidades/DialogUnidadeEditar.vue"
import DialogUnidadeDeletar from "@/components/unidades/DialogUnidadeDeletar.vue"
import DialogUnidadeCriar from "@/components/unidades/DialogUnidadeCriar.vue"

export default {
    name: "Unidades",
    components: {
        DialogUnidadeEditar,
        DialogUnidadeDeletar,
        DialogUnidadeCriar
    },
    data: () => ({
        carregandoUnidades: true,
        dataTableHeaders: [
            {
                text: "Nome",
                sortable: true,
                align: "start",
                value: "nome"
            },
            {
                text: "Ações",
                sortable: false,
                align: "center",
                value: "actions"
            }
        ],
        mostrarDialogUnidadeEditar: false,
        mostrarDialogUnidadeDeletar: false,
        mostrarDialogUnidadeCriar: false,
        unidadeIdParaDeletar: -1,
        unidadeParaEditar: {}
    }),
    methods: {
        ...mapActions("unidades", ["buscarUnidades"]),
        ...mapActions("alertas", ["adicionarAlerta"]),
        abrirDialogUnidadeDeletar(unidadeId) {
            this.unidadeIdParaDeletar = unidadeId;
            this.mostrarDialogUnidadeDeletar = true;
        },
        fecharDialogUnidadeDeletar() {
            this.unidadeIdParaDeletar = -1;
            this.mostrarDialogUnidadeDeletar = false;
        },
        abrirDialogUnidadeEditar(unidade) {
            this.unidadeParaEditar = unidade;
            this.mostrarDialogUnidadeEditar = true;
        },
        fecharDialogUnidadeEditar() {
            this.unidadeParaEditar = {};
            this.mostrarDialogUnidadeEditar = false;
        },
        abrirDialogUnidadeCriar() {
            this.mostrarDialogUnidadeCriar = true;
        },
        fecharDialogUnidadeCriar() {
            this.mostrarDialogUnidadeCriar = false;
        },
        async confirmarCriarUnidade() {
            await this.carregarUnidades()
            this.fecharDialogUnidadeCriar();
        },
        async confirmarEditarUnidade() {
            await this.carregarUnidades()
            this.fecharDialogUnidadeEditar();
        },
        async confirmarDeletarUnidade() {
            await this.carregarUnidades()
            this.fecharDialogUnidadeDeletar();
        },
        async carregarUnidades() {
            this.carregandoUnidades = true;
            const response = await this.buscarUnidades();
            this.carregandoUnidades = false;

            return response;
        }
    },
    computed: {
        ...mapGetters("unidades", ["getUnidades"]),
        dataTableItems() {
            return this.getUnidades.map(unidade => ({
                id: unidade.id,
                nome: unidade.nome
            }));
        }
    },
    async created() {
        const response = await this.carregarUnidades();
        this.adicionarAlerta({ mensagem: response.mensagem, tipo: "success" });
    }
};
</script>
