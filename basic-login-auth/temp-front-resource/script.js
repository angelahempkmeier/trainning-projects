const form = document.querySelector("form");
const button = document.querySelector("button");
const iUsername = document.querySelector(".username");
const iPassword = document.querySelector(".password");

function login(){
    fetch('http://localhost:8080/login/authenticate', 
        {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "POST",
            body: JSON.stringify({
                username: iUsername.value,
                password: iPassword.value
            })
        })
        .then(function (res) {
            if(res.ok){
                return res.json();
            }else {
                alert("Your username or password is incorrect. Please try again.");
                throw new Error('Erro na requisição.');
            }
        }).then(function(data){
            alert('Token: ' + data.token);
        })
        .catch(function (error){
            console.log(error);
        })
};

function copyToken() {
    fetch('http://localhost:8080/login/token', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: iUsername.value,
            password: iPassword.value
        })
    })
    .then((res) => {
        if (res.ok) {
            return res.text(); // Alterado para res.text() para obter o token como texto
        } else {
            throw new Error('Erro na requisição');
        }
    })
    .then((token) => {
        if (navigator.clipboard) {
            navigator.clipboard.writeText(token)
            .then(function() {
                alert("Token copiado para área de transferência.");
            })
            .catch(function(error) {
                console.error("Erro ao copiar o token: ", error);
            });
        } else {
            console.error('Problema na API clipboard.');
        }
    })
    .catch((error) => {
        console.log('Error: ' + error);
    });
};


function clear(){
    iUsername.value = "";
    iPassword.value = "";
}

form.addEventListener('submit', function(e) {
    e.preventDefault();

    login();
    clear();
});
