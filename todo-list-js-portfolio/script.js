const inputBox = document.getElementById("input-box");
const listContainer = document.getElementById("list-container");

function addTask() {
    if(inputBox.value === ''){
        alert("You must write something!");
    }else{
        let li = document.createElement("li");
        li.innerHTML = inputBox.value;
        listContainer.appendChild(li);

        let span = document.createElement("span");
        span.innerHTML = "\u00d7";
        li.appendChild(span);
    }

    inputBox.value = "";
    saveData();
}

listContainer.addEventListener("click", function(e){
    if(e.target.tagName === "LI"){
        e.target.classList.toggle("checked");
        saveData();
    }else if(e.target.tagName === "SPAN"){
        e.target.parentElement.remove();
        saveData();
    }

}, false);

function saveData(){
    localStorage.setItem("data", listContainer.innerHTML);
}

function showTask(){
    listContainer.innerHTML = localStorage.getItem("data");
}

showTask();

//dark theme

const videoSource = document.querySelector("#bgvid source");
let isNightMode = false;


const changeThemeBtn = document.querySelector("#change-theme");
changeThemeBtn.addEventListener("change", function() {
    if (isNightMode) {
        document.body.classList.remove("dark");
        videoSource.src = "day.mp4";
      } else {
        document.body.classList.add("dark");
        videoSource.src = "night.mp4";
      }
      
      var video = document.querySelector('#bgvid');
      video.load();
      video.play();
      
      isNightMode = !isNightMode;
});