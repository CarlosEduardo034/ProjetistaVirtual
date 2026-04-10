document.getElementById("salvar").addEventListener("click", function () {

    function getNumber(value) {
        return value ? Number(value) : 0;
    }

    const dados = {
        nomeCliente: document.getElementById("nomeCliente").value,

        modulo: {
            potencia: getNumber(document.getElementById("potenciaModulo").value),
            quantidade: getNumber(document.getElementById("quantidadeModulo").value),
            area: getNumber(document.getElementById("areaArranjo").value),
            fabricante: document.getElementById("fabricanteModulo").value,
            modelo: document.getElementById("modeloModulo").value
        },

        inversor: {
            fabricante: document.getElementById("fabricanteInversor").value,
            modelo: document.getElementById("modeloInversor").value,
            potenciaNominal: getNumber(document.getElementById("potenciaInversor").value),
            tensaoOperacao: document.getElementById("tensaoOperacao").value,
            correnteNominal: getNumber(document.getElementById("correnteNominal").value),
            fatorPotencia: getNumber(document.getElementById("fatorPotencia").value),
            rendimento: getNumber(document.getElementById("rendimento").value),
            dht: getNumber(document.getElementById("dht").value)
        }
    };

    console.log("Objeto JS:", dados);
    console.log("JSON:", JSON.stringify(dados));

    fetch("http://localhost:8080/projetos", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(dados)
    })
        .then(response => response.json())
        .then(data => {
            alert("Projeto salvo com sucesso! ID: " + data.id);
        })
        .catch(error => {
            console.error("Erro:", error);
            alert("Erro ao salvar projeto");
        });
});

const voltarBtn = document.getElementById("voltar");
voltarBtn.addEventListener("click", () => {
    window.location.href = "dashboard.html";
});