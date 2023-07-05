const form = document.getElementById("form");
const username = document.getElementById("username");
const email = document.getElementById("email");
const password = document.getElementById("password");
const passwordConfirmation = document.getElementById("password-confirmation");

function errorInput(input, message){
    const formItem = input.parentElement;
    const textMessage = formItem.querySelector("a");

    textMessage.innerText = message;

    formItem.className = "form-content error";
}

function checkInputUsername(){
    const usernameValue = username.value;
    if(usernameValue === ""){
        errorInput(username, "Preencha um username!");
    }else{
        const formItem = username.parentElement;
        formItem.className = "form-content"
    }

}

function checkInputEmail(){
    const emailValue = email.value;
    if(emailValue === ""){
        errorInput(email, "O email é obrigatório!");
    }else{
        const formItem = email.parentElement;
        formItem.className = "form-content"
    }

}

function checkInputPassword(){
    const passwordValue = password.value;
    if(password === ""){
        errorInput(password, "A senha é obrigatória!");
    }else{
        const formItem = password.parentElement;
        formItem.className = "form-content"
    }

}


form.addEventListener("submit", (event) => {
    event.preventDefault();
    checkInputUsername();
});



