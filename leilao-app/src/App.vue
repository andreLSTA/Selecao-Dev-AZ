<template>
    <v-app>
        <v-app-bar
            app
            color="primary"
            elevation="0"
        >
            <v-app-bar-nav-icon
                @click="mostrarDrawer = true"
                color="white"
            >
            </v-app-bar-nav-icon>
        </v-app-bar>
        <v-navigation-drawer
            v-model="mostrarDrawer"
            temporary
            app
        >
            <v-list>
                <v-list-item-group
                    mandatory
                    color="black"
                >
                    <router-link
                        v-for="(rota, rotaIndice) in rotas"
                        :key="rotaIndice"
                        :to="rota.caminho"
                        class="text-decoration-none"
                    >
                        <v-list-item color="primary">
                            <v-list-item-content>
                                <v-list-item-title class="font-weight-medium">
                                    {{ rota.nome }}
                                </v-list-item-title>
                            </v-list-item-content>
                        </v-list-item>
                    </router-link>
                </v-list-item-group>
            </v-list>
        </v-navigation-drawer>
        <v-main>
            <router-view/>
        </v-main>
        <app-alerta/>
    </v-app>
</template>

<script>
import AppAlerta from "@/components/app/AppAlerta.vue";

export default {
    name: 'App',
    components: {
        AppAlerta
    },
    data: () => ({
        mostrarDrawer: false,
        rotas: [
            {
                nome: "Home",
                caminho: "/"
            },
            {
                nome: "Empresas",
                caminho: "/empresas"
            },
            {
                nome: "Unidades",
                caminho: "/unidades"
            },
            {
                nome: "Leilões",
                caminho: "/leiloes"
            }
        ]
    })
};

</script>
