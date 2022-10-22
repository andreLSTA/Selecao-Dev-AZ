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
                        Leilões
                    </v-card-title>
                    <v-data-table
                        :headers="dataTableHeaders"
                        :items="dataTableItems"
                        :items-per-page="10"
                        :loading="carregandoLeiloes"
                    >
                    </v-data-table>
                </v-card>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>

import { mapActions, mapGetters } from "vuex";

export default {
    name: "Leiloes",
    data: () => ({
        carregandoLeiloes: true,
        dataTableHeaders: [
            {
                text: "Razão social",
                sortable: true,
                align: "start",
                value: "razaoSocial"
            },
            {
                text: "Início previsto",
                sortable: true,
                align: "start",
                value: "inicioPrevisto"
            },
            {
                text: "Total do leilão",
                sortable: true,
                align: "start",
                value: "totalLeilao"
            }
        ]
    }),
    methods: {
        ...mapActions("leiloes", ["buscarLeiloes"]),
        ...mapActions("alertas", ["adicionarAlerta"]),
        async carregarLeiloes() {
            this.carregandoLeiloes = true;
            const response = await this.buscarLeiloes();
            this.carregandoLeiloes = false;

            return response;
        }
    },
    computed: {
        ...mapGetters("leiloes", ["getLeiloes"]),
        dataTableItems() {
            return this.getLeiloes.map(leilao => ({
                razaoSocial: leilao.vendedor.razaoSocial,
                inicioPrevisto: leilao.inicioPrevisto,
                totalLeilao: leilao.lotes.reduce((total, lote) => total + lote.quantidade * lote.valorInicial, 0).toFixed(2).replace('.', ',')
            }));
        }
    },
    async created() {
        const response = await this.carregarLeiloes();
        this.adicionarAlerta({ mensagem: response.mensagem, tipo: "success" });
    }
};
</script>
