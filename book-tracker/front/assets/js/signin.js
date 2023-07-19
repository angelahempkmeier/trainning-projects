const form = document.querySelector("form");
const button = document.querySelector("button");
const ifullname = document.querySelector("#fullname");
const iEmail = document.querySelector("#email");
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
                fullname: ifullname.value,
                email: iEmail.value,
                username: iUsername.value,
                password: iPassword.value
            })
        })
        .then(function (res) {
            if(res.ok){
                return res.json();
                alert("You are now a part of Bokie's community!");
            }else {
                alert("Something is wrong. Please try again.");
                throw new Error('Erro na requisição.');
            }
        })
        .then(function(data){
            window.location.href = 'index.html';
        })
        .catch(function (error){
            console.log(error);
        })
};


function clear(){
    ifullname.value = "";
    iEmail.value = "";
    iUsername.value = "";
    iPassword.value = "";
}

form.addEventListener('submit', function(e) {
    e.preventDefault();

    login();
    clear();
});