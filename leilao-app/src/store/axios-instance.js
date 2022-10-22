import axios from 'axios';
import store from '@/store';

const axiosInstance = axios.create({
    baseURL: "http://localhost:8081"
})

const adicionarAlerta = (mensagem, tipo) => store.dispatch("alertas/adicionarAlerta", { mensagem, tipo });

const axiosResponseConfiguration = (response) => {
    return response.data;
}

const axiosErrorConfiguration = (error) => {
    adicionarAlerta(error.response.data.mensagem, "error");
    return error.response.data;
}

axiosInstance.interceptors.response.use(axiosResponseConfiguration, axiosErrorConfiguration);

export default axiosInstance;
