// Obtendo os elementos html pelo id
const btn_addmember = document.getElementById("btn_addmember")
const i_name = document.getElementById("name")
const i_email = document.getElementById("email")
const i_salary = document.getElementById("salary")


// Função para adicionar membro
const addMember=()=>{
    const endpoint = "http://localhost:8080/familyMembers"

    const dados={
        id: null,
        name: i_name.value,
        email: i_email.value,
        salary:parseFloat(i_salary.value)// Convertendo o valor digitado no campo "salary" para float
    }
    
    const cabecalho={
        method:"POST",
        // Configurando o cabeçalho da requisição, especificando que o corpo será um JSON
        headers: {
            "Content-Type": "application/json"
        },
        body:JSON.stringify(dados)// Convertendo o objeto 'dados' em uma string JSON para enviar no corpo da requisição
    }

    // Enviando a requisição para o servidor com os dados e cabeçalhos definidos
    fetch(endpoint, cabecalho)
    .then(res=>res.json())// Após a requisição, convertendo a resposta para JSON
    .then(ret=>{ // Quando a resposta chegar com sucess
        console.log(ret)
    }).catch(err => {
        console.error("Erro ao adicionar membro: ", err)
    })
}

// Adicionando um ouvinte de evento para o botão, que chama a função 'addMember' quando o botão é clicado
btn_addmember.addEventListener("click", (evt)=>{
    addMember()
})

