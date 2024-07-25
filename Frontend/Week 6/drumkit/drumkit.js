var boom = document.getElementById("boom"); 
var clap = document.getElementById("clap"); 
var hihat = document.getElementById("hihat"); 
var kick = document.getElementById("kick"); 
var openhat = document.getElementById("openhat"); 
var ride = document.getElementById("ride"); 
var snare = document.getElementById("snare"); 
var tink = document.getElementById("tink"); 
var tom = document.getElementById("tom"); 

function playBoom() { 
  boom.play(); 
} 
function playClap() { 
  clap.play(); 
} 
function playHihat() { 
  hihat.play(); 
} 
function playKick() { 
  kick.play(); 
} 
function playOpenhat() { 
  openhat.play(); 
} 
function playRide() { 
  ride.play(); 
} 
function playSnare() { 
  snare.play(); 
} 
function playTink() { 
  tink.play(); 
} 
function playTom() { 
  tom.play(); 
} 

document.addEventListener('keydown',function(info){
    if(info.code=="KeyA"){
        boom.play();
    }
})
document.addEventListener('keydown',function(info){
    if(info.code=="KeyS"){
        clap.play();
    }
})
document.addEventListener('keydown',function(info){
    if(info.code=="KeyD"){
        hihat.play();
    }
})
document.addEventListener('keydown',function(info){
    if(info.code=="KeyF"){
        kick.play();
    }
})
document.addEventListener('keydown',function(info){
    if(info.code=="KeyG"){
        openhat.play();
    }
})
document.addEventListener('keydown',function(info){
    if(info.code=="KeyH"){
        ride.play();
    }
})
document.addEventListener('keydown',function(info){
    if(info.code=="KeyJ"){
        snare.play();
    }
})
document.addEventListener('keydown',function(info){
    if(info.code=="KeyK"){
        tink.play();
    }
})
document.addEventListener('keydown',function(info){
    if(info.code=="KeyL"){
        tom.play();
    }
})