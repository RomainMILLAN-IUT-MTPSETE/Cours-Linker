import * as cpn from "./components.js";

let mPrevTime;
let mLagTime;

const inputSystem = (entities, components,ecs) => {
    let currentTime = performance.now();
    let elapsedTime = mPrevTime ? currentTime - mPrevTime : 0;
    mPrevTime = currentTime;
    mLagTime += elapsedTime;

    for (const gameState of Object.getOwnPropertySymbols(components[cpn.GameStateComponent.name])) {
        {
            if( components.GameStateComponent[gameState].leftControl )
            {
                for (const avatar of Object.getOwnPropertySymbols(components[cpn.RaquetteTag.name]))
                {
                    if(components.PositionComponent[avatar]){
                        components.PositionComponent[avatar].x -= 8;
                        components.PositionComponent[avatar].x = components.PositionComponent[avatar].x < 0 ? components.PositionComponent[avatar].min_x :components.PositionComponent[avatar].x;  
                    }

                }
            }
            
            if( components.GameStateComponent[gameState].rightControl )
            {
                for (const avatar of Object.getOwnPropertySymbols(components[cpn.RaquetteTag.name]))
                {
                    if(components.PositionComponent[avatar]){
                        components.PositionComponent[avatar].x += 8;
                        components.PositionComponent[avatar].x = components.PositionComponent[avatar].x > components.PositionComponent[avatar].max_x ? components.PositionComponent[avatar].max_x :components.PositionComponent[avatar].x;  
                    }

                }
            }

        }
    };
}

export { inputSystem }