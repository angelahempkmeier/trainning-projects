const itemInput = document.getElementById("itemInput");
const itemList = document.getElementById("itemList");

itemInput.addEventListener("keyup", function(event) {
  // Verifica se a tecla pressionada é a tecla "Enter" (código 13)
  if (event.keyCode === 13) {
    addItemToList();
  }
});

function addItemToList() {
  const newItemText = itemInput.value.trim();

  if (newItemText === "") {
    return; // Evita adicionar itens vazios à lista
  }

  const listItem = document.createElement("li");
  listItem.textContent = newItemText;

  itemList.appendChild(listItem);

  itemInput.value = ""; // Limpa o campo de entrada após adicionar o item
}
