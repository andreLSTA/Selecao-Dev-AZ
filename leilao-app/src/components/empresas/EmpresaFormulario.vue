<template>
    <v-form
        ref="empresaFormulario"
        lazy-validation
    >
        <v-container>
            <v-row>
                <v-col
                    cols="12"
                    sm="6"
                    md="6"
                >
                    <v-text-field
                        label="Razão social *"
                        v-model="empresa.razaoSocial"
                        :rules="razaoSocialRules"
                        :counter="64"
                        clearable
                    >
                    </v-text-field>
                </v-col>
                <v-col
                    cols="12"
                    sm="6"
                    md="6"
                >
                    <v-text-field
                        label="CNPJ *"
                        v-model="empresa.cnpj"
                        :rules="cnpjRules"
                        :counter="32"
                        clearable
                    >
                    </v-text-field>
                </v-col>
                <v-col
                    cols="12"
                    sm="6"
                    md="6"
                >
                    <v-text-field
                        label="Logradouro"
                        v-model="empresa.logradouro"
                        :rules="logradouroRules"
                        :counter="64"
                        clearable
                    >
                    </v-text-field>
                </v-col>
                <v-col
                    cols="12"
                    sm="6"
                    md="6"
                >
                    <v-text-field
                        label="Municipio"
                        v-model="empresa.municipio"
                        :rules="municipioRules"
                        :counter="64"
                        clearable
                    >
                    </v-text-field>
                </v-col>
                <v-col
                    cols="12"
                    sm="6"
                    md="6"
                >
                    <v-text-field
                        label="Numero"
                        v-model="empresa.numero"
                        :rules="numeroRules"
                        :counter="10"
                        clearable
                    >
                    </v-text-field>
                </v-col>
                <v-col
                    cols="12"
                    sm="6"
                    md="6"
                >
                    <v-text-field
                        label="Complemento"
                        v-model="empresa.complemento"
                        :rules="complementoRules"
                        :counter="64"
                        clearable
                    >
                    </v-text-field>
                </v-col>
                <v-col
                    cols="12"
                    sm="6"
                    md="6"
                >
                    <v-text-field
                        label="Bairro"
                        v-model="empresa.bairro"
                        :rules="bairroRules"
                        :counter="64"
                        clearable
                    >
                    </v-text-field>
                </v-col>
                <v-col
                    cols="12"
                    sm="6"
                    md="6"
                >
                    <v-text-field
                        label="CEP"
                        v-model="empresa.cep"
                        :rules="cepRules"
                        :counter="16"
                        clearable
                    >
                    </v-text-field>
                </v-col>
                <v-col
                    cols="12"
                    sm="6"
                    md="6"
                >
                    <v-text-field
                        label="Telefone"
                        v-model="empresa.telefone"
                        :rules="telefoneRules"
                        :counter="32"
                        clearable
                        hint="ex: (99) 99999-9999"
                    >
                    </v-text-field>
                </v-col>
                <v-col
                    cols="12"
                    sm="6"
                    md="6"
                >
                    <v-text-field
                        label="E-mail *"
                        v-model="empresa.email"
                        :rules="emailRules"
                        :counter="254"
                        clearable
                    >
                    </v-text-field>
                </v-col>
                <v-col
                    cols="12"
                    sm="6"
                    md="6"
                >
                    <v-text-field
                        label="Site"
                        v-model="empresa.site"
                        :rules="siteRules"
                        :counter="254"
                        clearable
                    >
                    </v-text-field>
                </v-col>
                <v-col
                    cols="12"
                    sm="6"
                    md="6"
                >
                    <v-text-field
                        label="Usuário *"
                        v-model="empresa.usuario"
                        :rules="usuarioRules"
                        :counter="20"
                        clearable
                    >
                    </v-text-field>
                </v-col>
                <v-col
                    cols="12"
                    sm="6"
                    md="6"
                >
                    <v-text-field
                        label="Senha"
                        v-model="empresa.senha"
                        :rules="senhaRules"
                        :counter="128"
                        clearable
                        :append-icon="mostrarSenha ? 'mdi-eye' : 'mdi-eye-off'"
                        :type="!mostrarSenha ? 'password' : 'text'"
                        @click:append="mostrarSenha = !mostrarSenha"
                    >
                    </v-text-field>
                </v-col>
            </v-row>
        </v-container>
    </v-form>
</template>
<script>
import _ from "lodash";

export default {
    name: "EmpresaFormulario",
    props: {
        value: {
            type: Object
        }
    },
    data: () => ({
        empresa: {
            razaoSocial: "",
            cnpj: "",
            logradouro: "",
            municipio: "",
            numero: "",
            complemento: "",
            bairro: "",
            cep: "",
            telefone: "",
            email: "",
            site: "",
            usuario: "",
            senha: ""
        },
        razaoSocialRules: [
            razaoSocial => !!razaoSocial || "A razão social é obrigatória.",
            razaoSocial => (razaoSocial || '').length <= 64 || "A razão social deve possuir no máx. 64 caracteres."
        ],
        cnpjRules: [
            cnpj => !!cnpj || "O CNPJ é obrigatório.",
            cnpj => (cnpj || '').length <= 32 || "O CNPJ deve possuir no máx. 32 caracteres."
        ],
        logradouroRules: [
            logradouro => (logradouro || '').length <= 64 || "A logradouro deve possuir no máx. 64 caracteres."
        ],
        municipioRules: [
            municipio => (municipio || '').length <= 64 || "O município deve possuir no máx. 64 caracteres."
        ],
        numeroRules: [
            numero => (numero || '').length <= 10 || "O número deve possuir no máx. 10 caracteres."
        ],
        complementoRules: [
            complemento => (complemento || '').length <= 64 || "O complemento deve possuir no máx. 64 caracteres."
        ],
        bairroRules: [
            bairro => (bairro || '').length <= 64 || "O bairro deve possuir no máx. 64 caracteres."
        ],
        cepRules: [
            cep => (cep || '').length <= 16 || "O CEP deve possuir no máx. 16 caracteres."
        ],
        telefoneRules: [
            telefone => (telefone || '').length <= 32 || "O telefone deve possuir no máx. 32 caracteres."
        ],
        emailRules: [
            email => !!email || "O e-mail é obrigatório.",
            email => (email || '').length <= 254 || "O e-mail deve possuir no máx. 254 caracteres."
        ],
        siteRules: [
            site => (site || '').length <= 254 || "O site deve possuir no máx. 254 caracteres."
        ],
        usuarioRules: [
            usuario => !!usuario || "O usuário é obrigatório.",
            usuario => (usuario || '').length <= 20 || "O usuário deve possuir no máx. 20 caracteres."
        ],
        senhaRules: [
            senha => (senha || '').length <= 128 || "O usuário deve possuir no máx. 128 caracteres."
        ],
        mostrarSenha: false
    }),
    watch: {
        value() {
            if (!_.isEqual(this.empresa, this.value)) {
                this.copiarDadosParaEdicao();
            }
        },
        empresa: {
            handler() {
                this.emitirEmpresaEValidacao();
            },
            deep: true
        }
    },
    methods: {
        copiarDadosParaEdicao() {
            this.empresa = _.cloneDeep(this.value);
        },
        emitirValidacao() {
            this.$emit('validar', this.$refs.empresaFormulario.validate())
        },
        emitirEmpresa() {
            this.$emit('input', this.empresa)
        },
        emitirEmpresaEValidacao() {
            this.emitirEmpresa();
            this.emitirValidacao();
        }
    }
};
</script>
