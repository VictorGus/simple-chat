var location = window.location;
var webSocket = new WebSocket ('ws://' + location.host + (location.pathname == '/' ? '/anonimous': location.pathname));
var input = document.getElementById("inp");
var output = document.getElementById("out");

input.onkeyup = function(x) {
    if(x.ctrlKey && x.keyCode == 13) {
        console.log("Send", input.value);
        webSocket.send(input.value);
    }
}

webSocket.onmessage = function(x) {
    output.innerHTML += x.data;
}
