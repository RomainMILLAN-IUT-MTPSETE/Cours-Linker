
import * as renderSystem from "./renderSystem.js";
import * as components from "./components.js";
import * as ecs from "./ecs.js";
import * as loop from "./loop.js";

// ECS instance
let _ecs ; 


// variables
// 
// The graphical context to draw to
let mGL = null;
function getGL() { return mGL; }
function get() { return mGL; }

function initWebGL(htmlCanvasID) {
    let canvas = document.getElementById(htmlCanvasID);
    mGL = canvas.getContext('webgl') || canvas.getContext('experimental-webgl');
    if (!mGL) {
        alert('WebGL not supported');
        return null;
    }
    mGL.viewport(0, 0, canvas.width, canvas.height);
    return mGL;
}

function init(htmlCanvasID){
    _ecs = new ecs.ECS();
    initWebGL(htmlCanvasID);
    // Ajouter le système de rendu WebGL à ECS
    _ecs.addSystem(entities => renderSystem.webGLRenderSystem(entities, _ecs.components, mGL));
}

function update(){
     _ecs.update();
}

// export these symbols 
export {get,getGL,ecs,update,init,components}
