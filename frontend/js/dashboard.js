const criarProjetoBtn = document.getElementById("CriarNovoProjeto");
criarProjetoBtn.addEventListener("click", criarProjeto);

const historicoBtn = document.getElementById("exibirHistorico");
historicoBtn.addEventListener("click", verHistorico);

const abrirPastaBtn = document.getElementById("abrirPasta");
abrirPastaBtn.addEventListener("click", abrirPasta);

function criarProjeto() {
    window.location.href = "form.html";
}

function verHistorico() {
    alert("Abrir histórico de projetos");
    // futuramente: window.location.href = "historico.html";
}

function abrirPasta() {
    alert("Abrir pasta de projetos no sistema");
    // isso será feito pelo backend depois (Java)
}

// Simulação de dados (futuramente virá da API)
const projetos = [
    { nome: "Projeto João", data: "01/04/2026" },
    { nome: "Projeto Maria", data: "30/03/2026" },
    { nome: "Projeto Empresa X", data: "29/03/2026" }
];

// Função para carregar lista na tela
function carregarProjetos() {
    const lista = document.getElementById("listaProjetos");

projetos.forEach(projeto => {
    const item = document.createElement("li");
    item.textContent = projeto.nome + " - " + projeto.data;
    lista.appendChild(item);
});
}

// Executa ao abrir a página
window.onload = carregarProjetos;
