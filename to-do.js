
const dateElement=document.getElementById("date");

const options = { weekday:"short",month:"long",day:"numeric"}
 const today=new Date();
 dateElement.innerHTML= today.toLocaleDateString("en-IN",options);

 /*function addTodo(toDo) {
     const item= `<li class="item">
     <i class="fa fa-circle-thin" job="complete" id="0"></i>
     <p class="text">${toDo}</p>
     <i class="fa fa-trash-o de" job="delete" id="0"></i>
     </li>`;
     const position ="beforeend";
     list.insertAdjacentHTML(position,item);
 }
document.addEventListener("keyup",function(event){
    if(event.keycode==13) {
        const toDo=input.value;
        if(toDo) {
            addTodo(toDo);
        }
    }
}) */
const container = document.querySelector('.add_to_do');
var inputValue = document.querySelector('.input');
const add = document.querySelector('.add');

if(window.localStorage.getItem("list") == undefined){
     var list = [];
     window.localStorage.setItem("list", JSON.stringify(list));
}

var listEX = window.localStorage.getItem("list");
var list = JSON.parse(listEX);


class item{
	constructor(name){
		this.createItem(name);
	}
    createItem(name){
    	var itemBox = document.createElement('div');
        itemBox.classList.add('item');

    	var input = document.createElement('input');
    	input.type = "text";
    	input.disabled = true;
    	input.value = name;
    	input.classList.add('item_input');

        var edit = document.createElement('button');
        edit.classList.add('edit');
    	edit.innerHTML = "EDIT";
    	edit.addEventListener('click', () => this.edit(input, name));

    	var remove = document.createElement('button');
    	remove.classList.add('remove');
    	remove.innerHTML = "REMOVE";
    	remove.addEventListener('click', () => this.remove(itemBox, name));

    	container.appendChild(itemBox);
       
        itemBox.appendChild(input);
        itemBox.appendChild(edit);
        itemBox.appendChild(remove);

    }

    edit(input, name){
        if(input.disabled == true){
           input.disabled = !input.disabled;
        }
    	else{
            input.disabled = !input.disabled;
            let indexof = list.indexOf(name);
            list[indexof] = input.value;
            window.localStorage.setItem("list", JSON.stringify(todos));
        }
    }

    remove(itemBox, name){
        itemBox.parentNode.removeChild(itemBox);
        let index = list.indexOf(name);
        list.splice(index, 1);
        window.localStorage.setItem("list", JSON.stringify(todos));
    }
}

add.addEventListener('click', check);
window.addEventListener('keydown', (e) => {
	if(e.which == 13){
		check();
	}
})

function check(){
	if(inputValue.value != ""){
		new item(inputValue.value);
        list.push(inputValue.value);
        window.localStorage.setItem("list", JSON.stringify(todos));
		inputValue.value = "";
	}
}

for (var v = 0 ; v < list.length ; v++){
    new item(list[v]);
}


