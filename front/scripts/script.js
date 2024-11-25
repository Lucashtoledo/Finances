// Seleciona os links de navegação
const navLinks = document.querySelectorAll('nav a');
// Seleciona o contêiner onde o conteúdo será alterado
const contentDiv = document.getElementById('content');

// Adiciona o evento de clique aos links
navLinks.forEach(link => {
    link.addEventListener('click', event =>{
        event.preventDefault();// Evita o comportamento padrão do link
        const page = link.getAttribute('data-page');// Obtém o valor do atributo data-page

        fetch(`${page}.html`)
            .then(response =>{
                if(!response.ok) throw new Error('Erro ao carregar a página'); 
                return response.text();
            })
            .then(html =>{
                contentDiv.innerHTML = html;
                loadPageScript(page);
            })
            .catch(error => {
                contentDiv.innerHTML = `<p>Erro: não foi possível carregar a página.</p>`;
                console.error(error);
            });
    });
});

function loadPageScript(page) {
    const script = document.createElement('script');
    script.src = `scripts/${page}.js`; // Define o caminho do script
    script.defer = true; // Garante que o script será executado após o HTML
    // Adiciona o script ao documento
    document.body.appendChild(script);
}


