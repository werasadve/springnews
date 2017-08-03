window.onload = poll();

function poll(){
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			document.getElementById("main").innerHTML = this.responseText;
			poll();
		}
	}
	xhr.open("GET", "/pollnews", true);
	xhr.timeout = 30000;
	xhr.ontimeout = function(){
		poll();
	}
	xhr.send();
}