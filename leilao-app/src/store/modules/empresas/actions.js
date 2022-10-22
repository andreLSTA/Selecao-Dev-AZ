import axiosInstance from "../../axios-instance.js";

const actions = {
    buscarEmpresas: async (context) => {
        const response = await axiosInstance.get("/empresas");
        context.commit("SET_EMPRESAS", response.dados);
        return response;
    },
    buscarEmpresaPorId: async (context, empresaId) => {
        const response = await axiosInstance.get(`/empresas/${empresaId}`);
        return response;
    },
    criarEmpresa: async (context, empresa) => {
        const response = await axiosInstance.post("/empresas", empresa);
        return response;
    },
    editarEmpresa: async (context, { empresa, empresaId }) => {
        const response = await axiosInstance.put(`/empresas/${empresaId}`, empresa);
        return response;
    },
    deletarEmpresa: async (context, empresaId) => {
        const response = await axiosInstance.delete(`/empresas/${empresaId}`);
        return response;
    }
};

export default actions;
