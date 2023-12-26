import * as engine from "./engine.js";
import * as entitites from "./entities.js";
import * as cpn from "./components.js";
import * as gameOver from "./gameoverSystem.js";



//hard coded scene...
function sceneSetup() {

    const mure01 = entitites.Mur(0, 0, 5, 350);
    const mure02 = entitites.Mur(345, 0, 5, 350);
    const mure03 = entitites.Mur(0, 0, 350, 5);
    const mure04 = entitites.Mur(0, 350, 350, 5);


    const ball = entitites.Ball(150, 150, 10, 10, 0.1, 0.05);
    const raquette = entitites.Raquette(0, 300, 50, 10);
    let offsetx = 25;
    let offsety = 10;
    let deltax = 70;
    let deltay = 30;
    for (let i = 0; i < 5; i++)
        for (let j = 0; j < 5; j++) {
            const br = entitites.Brique(offsetx + i * deltax, offsety + j * deltay, 20, 15);
        }

    

}

window.onload = function () 
{
    engine.init("GLCanvas");
    
    const gameState = entitites.GameState();
    sceneSetup();

    engine.ecs.eventEmitter.on( 'leftDown', handleLeftDown)
    engine.ecs.eventEmitter.on( 'leftUp', handleLeftUp)
    engine.ecs.eventEmitter.on( 'rightDown', handleRightDown)
    engine.ecs.eventEmitter.on( 'rightUp', handleRightUp)
    engine.ecs.eventEmitter.on( 'hit', handleHit)
    engine.ecs.eventEmitter.on( 'life', handleLife)
    engine.ecs.eventEmitter.on( 'gameover', handleGameover)
    engine.ecs.eventEmitter.on( 'victory', handleVictory)
    
    engine.update();
}


function handleHit(event)
{
    for (const state of Object.getOwnPropertySymbols(engine.ecs.components[cpn.GameStateComponent.name]))
    {
        engine.ecs.components.GameStateComponent[state].hits += 1;
    }
}

function handleLife(event)
{
    for (const state of Object.getOwnPropertySymbols(engine.ecs.components[cpn.GameStateComponent.name]))
    {
        if(engine.ecs.components.GameStateComponent[state].life <= 1) {
            engine.ecs.eventEmitter.emit('gameover')
        }else {
            engine.ecs.components.GameStateComponent[state].life -= 1;

            for (const ball of Object.getOwnPropertySymbols(engine.ecs.components[cpn.BallTag.name])) {
                engine.ecs.components.PositionComponent[ball].y = 150;
                engine.ecs.components.PositionComponent[ball].x = 150;
            }
        }
    }
}

function handleGameover(event)
{
    for (const state of Object.getOwnPropertySymbols(engine.ecs.components[cpn.GameStateComponent.name]))
    {
    engine.ecs.components.GameStateComponent[state].state = 'gameover';
    engine.ecs.isRunning = false;    
    }
}

function handleVictory(event)
{
    for (const state of Object.getOwnPropertySymbols(engine.ecs.components[cpn.GameStateComponent.name]))
    {
        engine.ecs.components.GameStateComponent[state].state = 'victory';
        engine.ecs.isRunning = false;    
    }
}

function handleLeftDown(event)
{
    for (const state of Object.getOwnPropertySymbols(engine.ecs.components[cpn.GameStateComponent.name]))
    {
    engine.ecs.components.GameStateComponent[state].leftControl = true;
    }

}

function handleLeftUp(event)
{
    for (const state of Object.getOwnPropertySymbols(engine.ecs.components[cpn.GameStateComponent.name]))
    {
    engine.ecs.components.GameStateComponent[state].leftControl = false;
    }

}

function handleRightUp(event)
{
    for (const state of Object.getOwnPropertySymbols(engine.ecs.components[cpn.GameStateComponent.name]))
    {
    engine.ecs.components.GameStateComponent[state].rightControl = false;
    }
}

function handleRightDown(event)
{
    for (const state of Object.getOwnPropertySymbols(engine.ecs.components[cpn.GameStateComponent.name]))
    {
    engine.ecs.components.GameStateComponent[state].rightControl = true;
    }
    
}

function handleUpUp(event)
{
    for (const state of Object.getOwnPropertySymbols(engine.ecs.components[cpn.GameStateComponent.name]))
    {
    engine.ecs.components.GameStateComponent[state].upControl = false;
    }
}

function handleUpDown(event)
{
    for (const state of Object.getOwnPropertySymbols(engine.ecs.components[cpn.GameStateComponent.name]))
    {
    engine.ecs.components.GameStateComponent[state].upControl = true;
    }
    
}

function handleDownUp(event)
{
    for (const state of Object.getOwnPropertySymbols(engine.ecs.components[cpn.GameStateComponent.name]))
    {
    engine.ecs.components.GameStateComponent[state].downControl = false;
    }
}

function handleDownDown(event)
{
    for (const state of Object.getOwnPropertySymbols(engine.ecs.components[cpn.GameStateComponent.name]))
    {
    engine.ecs.components.GameStateComponent[state].downControl = true;
    }
    
}