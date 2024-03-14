export default class Button extends HTMLElement {
    constructor(){
        super()
        this.innerHTML = document.createElement("button")
        this.innerText = "Submit"
    }
}