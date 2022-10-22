import axiosInstance from "../../axios-instance.js";

const actions = {
    buscarUnidades: async (context) => {
        const response = await axiosInstance.get("/unidades");
        if (response.sucesso) {
            context.commit("SET_UNIDADES", response.dados);
        }
        return response;
    },
    criarUnidade: async (context, unidade) => {
        const response = await axiosInstance.post("/unidades", unidade);
        return response;
    },
    editarUnidade: async (context, { unidade, unidadeId }) => {
        const response = await axiosInstance.put(`/unidades/${unidadeId}`, unidade);
        return response;
    },
    deletarUnidade: async (context, unidadeId) => {
        const response = await axiosInstance.delete(`/unidades/${unidadeId}`);
        return response;
    }
}

export default actions;
