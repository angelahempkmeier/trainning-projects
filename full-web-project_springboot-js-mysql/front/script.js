const form = document.querySelector("form");
const iName = document.querySelector(".name");
const iEmail = document.querySelector(".email");
const iPassword = document.querySelector(".password");
const iPhone = document.querySelector(".phone");

function subscribe(){
    fetch("http://localhost:8080/cadastrar", 
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({
                name: iName.value,
                email: iEmail.value,
                password: iPassword.value,
                phone: iPhone.value
            })
        })
        .then(function (res) {console.log(res)})
        .catch(function (res) {console.log(res)})
};

function clear(){
    iName.value = "";
    iEmail.value = "";
    iPassword.value = "";
    iPhone.value = "";
}

form.addEventListener('submit', function(e) {
    e.preventDefault();

    subscribe();
    clear();
});