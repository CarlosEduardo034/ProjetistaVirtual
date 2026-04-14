const modulos = [];
const inversores = [];
const rateios = [];

// ----------------------
// FUNÇÃO AUXILIAR
// ----------------------
function getValue(id) {
    return document.getElementById(id)?.value || null;
}

function getNumber(id) {
    const value = getValue(id);
    return value ? Number(value) : 0;
}

// ----------------------
// ADICIONAR MÓDULO
// ----------------------
document.getElementById("addModulo").addEventListener("click", () => {

    const modulo = {
        potencia: getNumber("potenciaModulo"),
        quantidade: getNumber("quantidadeModulo"),
        area: getNumber("areaArranjo"),
        fabricante: getValue("fabricanteModulo"),
        modelo: getValue("modeloModulo")
    };

    modulos.push(modulo);

    console.log("Módulos:", modulos);
    alert("Módulo adicionado!");
});

// ----------------------
// ADICIONAR INVERSOR
// ----------------------
document.getElementById("addInversor").addEventListener("click", () => {

    const inversor = {
        fabricante: getValue("fabricanteInversor"),
        modelo: getValue("modeloInversor"),
        potenciaNominal: getNumber("potenciaInversor"),
        tensaoOperacao: getValue("tensaoOperacao"),
        correnteNominal: getNumber("correnteNominal"),
        fatorPotencia: getValue("fatorPotencia"),
        rendimento: getValue("rendimento"),
        dht: getValue("dht")
    };

    inversores.push(inversor);

    console.log("Inversores:", inversores);
    alert("Inversor adicionado!");
});

// ----------------------
// ADICIONAR RATEIO
// ----------------------
document.getElementById("addRateio").addEventListener("click", () => {

    const rateio = {
        percentual: getNumber("percentualRateio"),
        contaContrato: getValue("contaContratoRateio"),
        classe: getValue("classeRateio"),
        endereco: getValue("enderecoRateio")
    };

    rateios.push(rateio);

    console.log("Rateios:", rateios);
    alert("Rateio adicionado!");
});

// ----------------------
// SALVAR PROJETO
// ----------------------
document.getElementById("salvar").addEventListener("click", () => {

    const projeto = {

        cliente: {
            nome: getValue("nomeCliente"),
            cpfCnpj: getValue("cpfCnpj"),
            rg: getValue("rg"),
            endereco: getValue("endereco"),
            telefoneCelular: getValue("telefoneCelular"),
            telefoneFixo: getValue("telefoneFixo"),
            cep: getValue("cep"),
            municipio: getValue("municipio"),
            uf: getValue("uf"),
            email: getValue("email")
        },

        solicitacao: {
            tipoOrcamento: getValue("tipoOrcamento"),
            tipoSolicitacao: getValue("tipoSolicitacao"),
            potenciaExistente: getValue("potenciaExistente"),
            possuiCargasEspeciais: getValue("possuiCargas"),
            detalhamentoCargas: getValue("detalhamentoCargas"),
            ramoAtividade: getValue("ramoAtividade"),
            fontePrimaria: getValue("fontePrimaria"),
            especificacaoFonte: getValue("especificacaoFonte"),
            tipoGeracao: getValue("tipoGeracao"),
            modalidadeCompensacao: getValue("modalidadeCompensacao")
        },

        uc: {
            contaContrato: getValue("contaContrato"),
            classe: getValue("classe"),
            tipoLigacao: getValue("tipoLigacao"),
            tensao: getValue("tensao"),
            cargaDeclarada: getNumber("cargaDeclarada"),
            disjuntor: getValue("disjuntor"),
            tipoRamal: getValue("tipoRamal"),
            identificacaoPoste: getValue("identificacaoPoste"),
            coordenadaX: getValue("coordX"),
            coordenadaY: getValue("coordY"),
            possuiRateio: getValue("possuiRateio"),
            formaAlocacao: getValue("formaAlocacao"),
            destinoExcedente: getValue("destinoExcedente")
        },

        responsavel: {
            nome: getValue("nomeResp"),
            titulo: getValue("tituloResp"),
            registro: getValue("registroResp"),
            ufRegistro: getValue("ufResp"),
            email: getValue("emailResp"),
            telefoneCelular: getValue("celularResp")
        },

        modulos: modulos,
        inversores: inversores,
        rateios: rateios
    };

    console.log("JSON enviado:", JSON.stringify(projeto, null, 2));

    fetch("http://localhost:8080/projetos", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(projeto)
    })
    .then(res => res.json())
    .then(data => {
        alert("Projeto salvo com sucesso! ID: " + data.id);
    })
    .catch(err => {
        console.error(err);
        alert("Erro ao salvar");
    });

});