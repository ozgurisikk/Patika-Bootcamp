function myFunction() {
    let text;
    let person = prompt("Please enter your name:", "Harry Potter");
    if (person == null || person == "") {
      text = "User cancelled the prompt.";
    } else {
      text = "Hello " + person + "! How are you today?";
    }
    document.getElementById("demo").innerHTML = text;
  }


function updateTime(){
    let now = new Date();
    let weekday = ["Pazar","Pazartesi","Sali","Carsamba","Persembe","Cuma","Cumartesi"];

    let hours = now.getHours();
    let minutes = now.getMinutes();
    let seconds = now.getSeconds();

    let day = weekday[now.getDay()];

    document.getElementById("myClock").innerHTML = hours + ":" + minutes + ":" + seconds + " " + day; 
}

setInterval(updateTime, 1000);