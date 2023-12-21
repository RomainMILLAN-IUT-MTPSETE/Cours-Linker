import * as cpn from "./components.js";

const gameoverSystem = (entities, components, ecs,max) => {
    for (const stateEntity of Object.getOwnPropertySymbols(components[cpn.GameStateComponent.name])) {
        {
            if(components.GameStateComponent[stateEntity].hits >= max){
                ecs.eventEmitter.emit('gameover');
            }
        }
    }
};

const ballUnderRaquetteSystem = (entities, components, ecs) => {
    for (const ball of Object.getOwnPropertySymbols(components[cpn.BallTag.name])) {
        for(const raquette of Object.getOwnPropertySymbols(components[cpn.RaquetteTag.name])) {
            if(components.PositionComponent[ball].y > components.PositionComponent[raquette].y+15){
                ecs.eventEmitter.emit('life');
            }
        }
    }
};

export { gameoverSystem, ballUnderRaquetteSystem }
