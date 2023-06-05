const button = document.querySelector("button");
const emailInput = document.getElementById("email-service");

button.addEventListener('click', function(){
    const email = emailInput.value;
    sendEmail(email);
});

function sendEmail(email){
    
    fetch('http://localhost:8080/login/send-token-email', {
        headers:{
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "POST",
        body: JSON.stringify({
            recipient: email
        })
    })
    .then(function(res){
        if(res.ok){
            alert('Token enviado para o email: ' + email);
        }else{
            throw new Error('Erro na requisição.');
        }
    })
    .catch(function(error){
        console.log(error);
    });

}