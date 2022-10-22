import axiosInstance from "../../axios-instance.js";

const actions = {
    buscarLeiloes: async (context) => {
        const response = await axiosInstance.get("/leiloes");
        context.commit("SET_LEILOES", response.dados);
        return response;
    }
};

export default actions;
