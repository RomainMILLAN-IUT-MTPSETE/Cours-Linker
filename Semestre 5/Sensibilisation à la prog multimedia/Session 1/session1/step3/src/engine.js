//Ne pas modifier ce fichier
import * as renderSystem from "./renderSystem.js";
import * as components from "./components.js";

class ECS {
    constructor() {
        this.entities = new Set();
        this.components = {};
        this.systems = [];
    }

    createEntity() {
        const entity = Symbol();
        this.entities.add(entity);
        return entity;
    }

    addComponent(entity, component) {
        if (!this.components[component.name]) 
        {
            this.components[component.name] = {};
        }
        this.components[component.name][entity] = component;
    }

    getComponent(entity, componentName) {
        return this.components[componentName] ? this.components[componentName][entity] : null;
    }

    addSystem(system) {
        this.systems.push(system);
    }

    update() {
        for (const system of this.systems) {
            system(this.entities, this.components);
        }
    }
}

// Create ECS instance
let ecs ; //= new ECS();


// variables
// 
// The graphical context to draw to
let mGL = null;
        // Convention: variable in a module: mName
function getGL() { return mGL; }

function initWebGL(htmlCanvasID) {
    let canvas = document.getElementById(htmlCanvasID);
    mGL = canvas.getContext('webgl') || canvas.getContext('experimental-webgl');
    if (!mGL) {
        alert('WebGL not supported');
        return null;
    }
    mGL.viewport(0, 0, canvas.width, canvas.height);
    console.log(canvas.width);
    console.log(canvas.height);
    
    return mGL;
}

function init(htmlCanvasID){

    ecs = new ECS();
    initWebGL(htmlCanvasID);
    // Ajouter le système de rendu WebGL à ECS
    ecs.addSystem(entities => renderSystem.webGLRenderSystem(entities, ecs.components, mGL));
    // Mettre à jour l'ECS
    //ecs.update();
}

function update(){
     ecs.update();
}

// export this symbol 
export {getGL,ecs,update,init,components}
