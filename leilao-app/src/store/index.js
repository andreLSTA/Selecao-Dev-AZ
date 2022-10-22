import Vue from 'vue';
import Vuex from 'vuex';

import empresas from "./modules/empresas";
import leiloes from "./modules/leiloes";
import unidades from "./modules/unidades";
import alertas from "./modules/alertas";

Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        empresas,
        leiloes,
        unidades,
        alertas
    }
})
