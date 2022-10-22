const mutations = {
    ADICIONAR_ALERTA: (state, alerta) => state.alertas =  [ ...state.alertas, alerta ],
    REMOVER_ALERTA: (state, alertaId) => state.alertas = state.alertas.filter(alerta => alerta.id !== alertaId)
};

export default mutations;
