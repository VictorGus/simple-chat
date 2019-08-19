var webSocket = new WebSocket ('ws://' + window.location.host + '/chat' + (window.location.pathname == '/' ? '/anonimous': window.location.pathname));
console.log(webSocket)
var input = document.getElementById("inp");
var output = document.getElementById("out");

input.onkeyup = function(x) {
    if(x.ctrlKey && x.keyCode == 13) {
        console.log("Send", input.value);
        webSocket.send(input.value);
    }
}

webSocket.onmessage = function(x) {
    console.log(x.data);
    output.innerHTML += x.data;
}
