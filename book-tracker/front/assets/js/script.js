const form = document.querySelector("form");
const button = document.querySelector("button");
const iUsername = document.querySelector("#username");
const iPassword = document.querySelector("#password");

function login(){
    fetch('http://localhost:8080/users/login', 
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
        })
        .then(function(data){
            window.location.href = 'homepage.html';
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

    login();
    clear();
});