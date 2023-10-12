"use strict"

const iUPS = 60; // nombre de updates par seconde
const tMPF = 1000 / iUPS; // Milliseconds par cycle.
// Variables for timing gameloop.
let tPrevTime; // le dernier temps enregistré
let tLagTime; // lag: différence entre le dernier temps et maintenant
let bLoopRunning = false; // Etat pour savoir si la boucle est active.
let oCurrentScene = null; // reference vers la scène /jeu courant
let iFrameID = -1; //identifiant pour la requete retourne par requestAnimationFrame

// fonction start scene
function start(scene) 
{
    scene.init();
    oCurrentScene = scene;

    bLoopRunning = true;
    window.requestAnimationFrame(loopOnce);
}

//arret de la boucle de jeu
function stop() {
    //TODO
    bLoopRunning = false;
}

function loopOnce() {
    loopUpdate();
    loopRender();

    tLagTime = tPrevTime - performance.now();
    tPrevTime = performance.now();
   
    if(bLoopRunning == true){
        window.requestAnimationFrame(loopOnce);
    }
}

function loopRender() {
    oCurrentScene.draw();
}

function loopUpdate() {
    let nbTime = Math.abs(tLagTime / tMPF);
    for(let i=0; i<nbTime; i++) {
        oCurrentScene.update();
    }
}

export {start, stop}