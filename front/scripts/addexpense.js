if (btn_addexpense && typeof window.addExpense === 'undefined') {
    console.log("Entrou no if");
    let btn_addexpense = document.getElementById('btn_addexpense');
    // window. define a função globalmente
    window.addExpense = () => {
        console.log("Entrou na função addExpense");
        const i_description = document.getElementById("description");
        const i_amount = document.getElementById("amount");
        const i_dueDay = document.getElementById("dueDay");
        const i_installmentCount = document.getElementById("installmentCount");
        const i_member = document.getElementById("member")
        const endpoint = "http://localhost:8080/expenses";

        const dados = {
            id: null,
            description: i_description.value,
            amount: parseFloat(i_amount.value),
            dueDay: parseInt(i_dueDay.value),
            installmentCount: parseInt(i_installmentCount.value),
            familyMember: i_member.value
        };
        console.log(dados);

        const cabecalho = {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(dados)
        };

        fetch(endpoint, cabecalho)
            .then(res => res.json())
            .then(ret => console.log(ret))
            .catch(err => console.error("Erro ao adicionar gasto: ", err));
    };
    // função para retornar os membros no "select"
    const getMember = ()=>{
        console.log("Entrou na função getMember")
        const selectElement = document.getElementById("member");
        const endpoint2 = "http://localhost:8080/familyMembers";

        fetch(endpoint2)
        .then(response => response.json())
        .then(membros => {
            console.log(membros)
            selectElement.innerHTML = "";
            const member = [...membros];
            member.forEach(membro => {
                const option = document.createElement("option");
                option.value = membro.id;
                option.textContent = membro.name;
                selectElement.appendChild(option);
            });
        }).catch(error => {
            console.error("Erro ao carregar membros: ", error)
        })
    };
    getMember();
    
} else if (!btn_addexpense) {
    console.error("O botão 'btn_addexpense' não foi encontrado no DOM.");
}
btn_addexpense.addEventListener("click", () => addExpense());

