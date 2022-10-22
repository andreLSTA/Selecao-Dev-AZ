const DURACAO_ALERTA_MS = 5000;

const actions = {
    adicionarAlerta: (context, { mensagem, tipo }) => {
        const alertaId = (new Date).toISOString();
        const alerta = {
            id: alertaId,
            mensagem,
            tipo
        };

        context.commit("ADICIONAR_ALERTA", alerta);
        setTimeout(() => {
            context.commit("REMOVER_ALERTA", alertaId)
        }, DURACAO_ALERTA_MS);
    },
    removerAlerta: (context, alertaId) => {
        context.commit("REMOVER_ALERTA", alertaId);
    }
};

export default actions;
