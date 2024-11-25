if (typeof ObterDados === "undefined") {
    window.ObterDados = () => { 
        const salaryBody = document.getElementById("salaryTable").getElementsByTagName("tbody")[0];
        const expenseBody = document.getElementById("expenseTable").getElementsByTagName("tbody")[0];
    
        const endpoint = "http://localhost:8080/reports";
        fetch(endpoint)
        .then(res => res.json())
        .then(data => {
            // Limpa o corpo da tabela antes de preencher com novos dados
            salaryBody.innerHTML = "";
            const salaries = [...data.salaries];
            const expenses = [...data.expenses];

            salaries.forEach(salary => {
                const row = salaryBody.insertRow(); // Cria uma nova linha
                const cellSalary = row.insertCell(0);
                // Preenche as células com o salário
                cellSalary.textContent = salary;
            });
            expenses.forEach(expense => {
                const row = expenseBody.insertRow(); // Cria uma nova linha
                const cellExpense = row.insertCell(0);
                // Preenche as células com o valor
                cellExpense.textContent = expense;
            });
        })
        .catch(error => console.error("Erro ao obter dados:", error));
    };
}

// Chama a função diretamente
ObterDados();
