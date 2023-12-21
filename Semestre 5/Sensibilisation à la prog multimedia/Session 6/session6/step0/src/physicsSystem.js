

let mPrevTime;
let mLagTime;



const physicsSystem = (entities, components) => {
    let currentTime = performance.now();
    let elapsedTime = mPrevTime ? currentTime - mPrevTime : 0;
    mPrevTime = currentTime;
    mLagTime += elapsedTime;

    for (const entity of entities) {
        if (components.PhysicsTag[entity] &&
            components.PositionComponent[entity] &&
            components.VelocityComponent[entity]
        ) {
            const position = components.PositionComponent[entity];
            components.PositionComponent[entity].x += components.VelocityComponent[entity].dx * elapsedTime;
            components.PositionComponent[entity].y += components.VelocityComponent[entity].dy * elapsedTime;
        }
    }
};


export { physicsSystem }