
const email = document.querySelector('.email');
form = document.querySelector("form");

function sendEmail(){
    fetch('http://localhost:8080/login/send-token-email',
    {
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "POST",
        body: JSON.stringify(
            {
                email: email.value
            }
        )
    })
    .then(function(response) {
        if(response.ok){
            return response.json();
        } else{
            throw new Error('Erro ao enviar dados');
        }
    })
    .then(function(data) {
        alert("Email enviado com sucesso.");
    })
    .catch(function(error) {
        console.error(error);
    })
};

form.addEventListener('submit', function(e){
    e.preventDefault();
});
