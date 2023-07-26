const keyword = document.getElementById("keyword");
const itemList = document.getElementById("itemList");
const images = ["slides1.jpg", "slides2.jpg", "slides3.jpg", "slides4.jpg"];
let currentSlide = 0;
const intervalTime = 5000; 


keyword.addEventListener("keyup", function(event) {
  // Verifica se a tecla pressionada é a tecla "Enter" (código 13)
  if (event.keyCode === 13) {
    addItemToList();
  }
});

function addItemToList() {
  const newItemText = keyword.value.trim();

  if (newItemText === "") {
    return; // Evita adicionar itens vazios à lista
  }

  const listItem = document.createElement("li");
  listItem.textContent = newItemText;

  itemList.appendChild(listItem);

  keyword.value = ""; // Limpa o campo de entrada após adicionar o item
}

function changeBackground(imageName) {
    const home = document.querySelector(".home");
    home.style.transition = "background-image 0.5s ease-in-out";
    home.style.backgroundImage = `url(assets/images/${imageName})`;
    home.style.backgroundPosition = "center center";
    home.style.opacity = 0.8; 
}

function startSlideShow() {
    setInterval(() => {
        currentSlide = (currentSlide + 1) % images.length;
        changeBackground(images[currentSlide]);
    }, intervalTime);
}

changeBackground(images[0]);
startSlideShow();
