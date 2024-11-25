if (btn_addmember && typeof window.addMember === 'undefined') {
    console.log("Entrou no if");
    let btn_addmember = document.getElementById('btn_addmember');
    // Define a função globalmente
    window.addMember = () => {
        console.log("Entrou na função");
        const i_name = document.getElementById("name");
        const i_email = document.getElementById("email");
        const i_salary = document.getElementById("salary");
        const endpoint = "http://localhost:8080/familyMembers";

        const dados = {
            id: null,
            name: i_name.value,
            email: i_email.value,
            salary: parseFloat(i_salary.value)
        };

        const cabecalho = {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(dados)
        };

        fetch(endpoint, cabecalho)
            .then(res => res.json())
            .then(ret => console.log(ret))
            .catch(err => console.error("Erro ao adicionar membro: ", err));
    };
    
} else if (!btn_addmember) {
    console.error("O botão 'btn_addmember' não foi encontrado no DOM.");
}
btn_addmember.addEventListener("click", () => addMember());
