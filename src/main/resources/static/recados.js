function convertRecadoToTr(recado){
    return `
        <tr>
            <td>${recado.mensagem}</td>
            <td>${recado.status}</td>
            <td>
                ${recado.status == "lido" ? "" : `<button type="button" class="btn btn-warning btn-sm" onclick="marcarComoLido(${recado.id}, '${JSON.stringify(recado.mensagem).slice(1, -1)}')">Ler</button>`}
                <button type="button" class="btn btn-warning btn-sm" onclick="excluir(${recado.id})">Apagar</button>
            </td>
        </tr>

    `
}
function mostraRecados(){
    let listanaolidos = document.getElementById("listanaolidos");
    let listalidos = document.getElementById("listalidos")
    fetch("/recados")
        .then((response) => response.json())
        .then((jsonresponse) => {
            listanaolidos.innerHTML = jsonresponse
                .filter((recado) => recado.status == "não lido")
                .map(convertRecadoToTr).join("")
            listalidos.innerHTML = jsonresponse
                .filter((recado) => recado.status == "lido")
                .map(convertRecadoToTr).join("")
        
        })
        .catch((error) => "mostraRecados: " + error);
}
function adicionaRecado(){
    const mensagem = document.getElementById("mensagem").value;
    fetch("/recados", {
        method: "POST",
        body: JSON.stringify({"mensagem": mensagem}),
        headers: {"Content-Type": "application/json"}
    })
        .then(() => {
            document.getElementById("mensagem").value = "";
            mostraRecados();
        })
}
function marcarComoLido(id, mensagem){
    fetch(`/recados/${id}`, {
        method: "PUT",
        body: JSON.stringify({
            "mensagem": mensagem,
            "status": "lido"
        }),
        headers: {"Content-Type": "application/json"}
    }).then(() => {
        mostraRecados();
    })
    .catch((error) => "marcarComoLido: " + error);
}
function excluir(id){
    fetch(`/recados/${id}`, {method: "DELETE"})
        .then(() => mostraRecados())
        .catch((error) => "excluir: " + error)
}

mostraRecados();