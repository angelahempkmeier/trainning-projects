const form = document.querySelector("form");
const button = document.querySelector("button");
const iFullname = document.querySelector(".fullname");
const iEmail = document.querySelector(".email");
const iUsername = document.querySelector(".username");
const iPassword = document.querySelector(".password");
const iPhone = document.querySelector(".phone");

function subscribe(){
    fetch("http://localhost:8080/users", 
        {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "POST",
            body: JSON.stringify({
                fullname: iFullname.value,
                email: iEmail.value,
                username: iUsername.value,
                password: iPassword.value,
                phone: iPhone.value
            })
        })
        .then(function (res) {console.log(res)})
        .catch(function (res) {console.log(res)})
};

function clear(){
    iFullname.value = "";
    iEmail.value = "";
    iUsername.value = "";
    iPassword.value = "";
    iPhone.value = "";
}

form.addEventListener('submit', function(e) {
    e.preventDefault();

    subscribe();
    clear();
});

function logon(){
    window.location.href = "logon.html";
}