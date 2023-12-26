
import * as cssRenderSystem from "./renderSystemCSS.js";
import * as renderSystem from "./renderSystem.js";


import * as components from "./components.js";
import * as physicsSystem from "./physicsSystem.js";
import * as collisionSystem from "./collisionSystem.js";
import * as inputSystem from "./inputSystem.js";
import * as hudSystem from "./hudSystem.js";
import * as gameoverSystem from "./gameoverSystem.js";

function generateUUID() { // Public Domain/MIT
    var d = new Date().getTime();//Timestamp
    var d2 = ((typeof performance !== 'undefined') && performance.now && (performance.now() * 1000)) || 0;//Time in microseconds since page-load or 0 if unsupported
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        var r = Math.random() * 16;//random number between 0 and 16
        if (d > 0) {//Use timestamp until depleted
            r = (d + r) % 16 | 0;
            d = Math.floor(d / 16);
        } else {//Use microseconds since page-load if supported
            r = (d2 + r) % 16 | 0;
            d2 = Math.floor(d2 / 16);
        }
        return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
    });
}

class EventEmitter {
    constructor() {
        this.events = {};
    }

    // S'abonner à un événement
    on(eventName, listener) {
        if (!this.events[eventName]) {
            this.events[eventName] = [];
        }
        this.events[eventName].push(listener);
    }

    // Se désabonner d'un événement
    off(eventName, listener) {
        if (!this.events[eventName]) {
            return;
        }
        this.events[eventName] = this.events[eventName].filter(l => l !== listener);
    }

    // Déclencher un événement
    emit(eventName, ...args) {
        if (!this.events[eventName]) {
            return;
        }
        this.events[eventName].forEach(listener => {
            listener.apply(this, args);
        });
    }
}


class ECS {
    constructor() {
        this.entities = new Set();
        this.components = {};
        this.entitiesToComponents = {};
        this.systems = [];
        this.entitiesToRemove = []; 
        this.eventEmitter = new EventEmitter();
        this.isRunning = true;
    }

    createEntity() {
        const entity = Symbol(generateUUID());
        this.entities.add(entity);
        return entity;
    }
    removeEntity(entity){
        console.log( "removeEntity:");
        console.log( entity);

        this.entitiesToRemove.push(entity);
    }

    addComponent(entity, component) {
        if (!this.components[component.name]) {
            this.components[component.name] = {};
        }
        this.components[component.name][entity] = component;

        if( ! this.entitiesToComponents[entity] ) 
        {
            this.entitiesToComponents[entity] = []
        }
        this.entitiesToComponents[entity].push(component);
    }

    getComponent(entity, componentName) {
        return this.components[componentName] ? this.components[componentName][entity] : null;
    }

    addSystem(system) {
        this.systems.push(system);
    }

    update() {
        this.entitiesToRemove = [];

        for (const system of this.systems) {
            system(this.entities, this.components);
        }
        
        //delete all entities
        
        for(const entity of this.entitiesToRemove){
            
            for(const c of this.entitiesToComponents[entity])
            {
                console.log("delete this component" + c.name);
                delete (this.components[c.name])[entity]
            }
            this.entities.delete(entity)
        }
    }
}
// ECS instance
let ecs;



// variables
// The graphical context to draw to
let mGL = null;
function getGL() { return mGL; }

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

function init(htmlCanvasID) {
    ecs = new ECS();
    initWebGL(htmlCanvasID);
    let canvas = document.getElementById(htmlCanvasID);
    let gameContainer = document.getElementById("game__container");
    
    let gameContainerHUD = document.getElementById("game__container_hud")
    gameContainer.appendChild(gameContainerHUD);
    
    // Ajouter le système de rendu WebGL à ECS
    ecs.addSystem(entities => inputSystem.inputSystem(entities, ecs.components));
    ecs.addSystem(entities => physicsSystem.physicsSystem(entities, ecs.components));
    ecs.addSystem(entities => collisionSystem.collisionSystem(entities, ecs.components,ecs));
    //TODO
    //ecs.addSystem(entities => cssRenderSystem.cssRenderSystem(entities, ecs.components, gameContainer));
    ecs.addSystem(entities => renderSystem.webGLRenderSystem(entities, ecs.components, mGL));
    //---
    ecs.addSystem(entities => gameoverSystem.gameoverSystem(entities, ecs.components, ecs,25));
    ecs.addSystem(entities => gameoverSystem.ballUnderRaquetteSystem(entities, ecs.components, ecs));
    ecs.addSystem(entities => hudSystem.hudSystem(entities, ecs.components,gameContainerHUD));
    

    document.addEventListener('keydown', function(event) {
    if ( event.key === 'ArrowLeft') {
        ecs.eventEmitter.emit('leftDown');
        // Add your logic for left arrow key press here
    } else if ( event.key === 'ArrowRight') {
        ecs.eventEmitter.emit('rightDown');
    }
    });

    document.addEventListener('keyup', function(event) {
    if (event.key === 'ArrowLeft') {
        ecs.eventEmitter.emit('leftUp');
        // Add your logic for left arrow key press here
    } else if (event.key === 'ArrowRight') {
        console.log('Right arrow key up');
        ecs.eventEmitter.emit('rightUp');
    }
    });
    
}

function update() {
    ecs.update();
    if(ecs.isRunning){
        requestAnimationFrame(update);
    }
}

// export these symbols 
export { getGL, ecs, update, init, components }
