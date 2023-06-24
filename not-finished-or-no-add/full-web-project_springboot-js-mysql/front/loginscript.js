const form = document.querySelector("form");
        const button = document.querySelector("button");
        const iEmail = document.querySelector(".email");
        const iPassword = document.querySelector(".password");


        function loginRequest(){
            e.preventDefault();

            fetch("http://localhost:8080/users/login", 
            {
                headers: {
                    "Accept": "application/json",
                    "Content-Type": "application/json"
                },
                method: "POST",
                body: JSON.stringify({
                    email: iEmail.value,
                    password: iPassword.value
                })
            })
            .then(function (res) {console.log(res)})
            .catch(function (res) {console.log(res)})

            clear();
        };



function clear(){
    iEmail.value = "";
    iPassword.value = "";
}
