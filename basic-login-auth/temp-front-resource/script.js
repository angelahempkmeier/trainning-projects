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
                throw new Error('Erro na requisição.');
            }
        }).then(function(data){
            alert('Token: ' + data.token);
        })
        .catch(function (error){
            console.log(error);
        })
};


function clear(){
    iUsername.value = "";
    iPassword.value = "";
}

form.addEventListener('submit', function(e) {
    e.preventDefault();

    subscribe();
    clear();
});
