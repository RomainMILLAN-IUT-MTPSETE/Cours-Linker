import * as engine from "./engine.js";

//Code exemple pour creer un point (x,y)
//a ne pas modifier
function createPoint(x,y)
{
    const gameObj1 = engine.ecs.createEntity();
    engine.ecs.addComponent(gameObj1,engine.components.Position(x,y));
}



// fonction pour dessiner la scene
function sceneSetup()
{
    //TODO
    //exemple:

    //I
    createPoint(-0.5,+0.20);
    createPoint(-0.5,+0.25);
    createPoint(-0.5,+0.30);
    createPoint(-0.5,+0.35);
    createPoint(-0.5,+0.40);
    createPoint(-0.5,+0.45);
    createPoint(-0.5,+0.5);
    createPoint(-0.5,+0.55);

    //U
    createPoint(-0.10, +0.55);
    createPoint(-0.10, +0.50);
    createPoint(-0.10, +0.45);
    createPoint(-0.10, +0.40);
    createPoint(-0.10, +0.35);
    createPoint(-0.10, +0.30);
    createPoint(-0.10, +0.25);
    createPoint(-0.10, +0.20);
    createPoint(-0.15, +0.20);
    createPoint(-0.20, +0.20);
    createPoint(-0.25,+0.20);
    createPoint(-0.25,+0.25);
    createPoint(-0.25,+0.30);
    createPoint(-0.25,+0.35);
    createPoint(-0.25,+0.40);
    createPoint(-0.25,+0.45);
    createPoint(-0.25,+0.5);
    createPoint(-0.25, +0.55);

    //T
    createPoint(0.20,+0.20);
    createPoint(0.20,+0.25);
    createPoint(0.20,+0.30);
    createPoint(0.20,+0.35);
    createPoint(0.20,+0.40);
    createPoint(0.20,+0.45);
    createPoint(0.20,+0.5);
    createPoint(0.20,+0.55);
    createPoint(0.10,+0.55);
    createPoint(0.15,+0.55);
    createPoint(0.25,+0.55);
    createPoint(0.30,+0.55);
}


//fonction qui initialise l'environnement graphique
//a ne pas modifier
window.onload = function() {
    engine.init("webglCanvas");
    sceneSetup();
    engine.update(); 
}
