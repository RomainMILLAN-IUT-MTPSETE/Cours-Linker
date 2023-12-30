import * as cpn from "./components.js";

function collision(components, obj1, obj2) {
  // Simple AABB collision detection
  if (
    components.PositionComponent[obj1].x +
      components.CollisionBoxComponent[obj1].width >
      components.PositionComponent[obj2].x &&
    components.PositionComponent[obj1].x -
      components.CollisionBoxComponent[obj1].width <
      components.PositionComponent[obj2].x +
        components.CollisionBoxComponent[obj2].width &&
    components.PositionComponent[obj1].y +
      components.CollisionBoxComponent[obj1].height >
      components.PositionComponent[obj2].y &&
    components.PositionComponent[obj1].y -
      components.CollisionBoxComponent[obj1].width <
      components.PositionComponent[obj2].y +
        components.CollisionBoxComponent[obj2].height
  ) {
    return true;
  }
  return false;
}

function detectCollisionAxis(boxA, boxB) {
  let overlapX = Math.min(
    boxA.x + boxA.width - boxB.x,
    boxB.x + boxB.width - boxA.x
  );
  let overlapY = Math.min(
    boxA.y + boxA.height - boxB.y,
    boxB.y + boxB.height - boxA.y
  );

  if (overlapX < overlapY) {
    return "X"; // Collision plus probable sur l'axe X
  } else {
    return "Y"; // Collision plus probable sur l'axe Y
  }
}

const collisionSystem = (entities, components, ecs) => {
  const dict = components[cpn.BallTag.name];
  for (const ball of Object.getOwnPropertySymbols(
    components[cpn.BallTag.name]
  )) {
    {
      for (const obj of Object.getOwnPropertySymbols(
        components[cpn.CollisionTag.name]
      )) {
        if (!components.BallTag[obj]) {
          components.CollisionBoxComponent[obj].hit = false;

          if (ball != obj) {
            if (collision(components, ball, obj)) {
              const breakSong = new Audio("./utils/break.mp3");
              breakSong.volume = 0.1;
              breakSong.play();

              components.CollisionBoxComponent[obj].hit = true;
              //Traitement des cas de collision
              //
              let ballobj = {
                x: components.PositionComponent[ball].x,
                y: components.PositionComponent[ball].y,
                width: components.CollisionBoxComponent[ball].width,
                height: components.CollisionBoxComponent[ball].height,
              };
              let otherobj = {
                x: components.PositionComponent[obj].x,
                y: components.PositionComponent[obj].y,
                width: components.CollisionBoxComponent[obj].width,
                height: components.CollisionBoxComponent[obj].height,
              };
              let axe = detectCollisionAxis(ballobj, otherobj);

              if (axe == "X") {
                components.VelocityComponent[ball].dx =
                  -components.VelocityComponent[ball].dx;
              } else {
                components.VelocityComponent[ball].dy =
                  -components.VelocityComponent[ball].dy;
              }
              if (components.BriqueTag[obj]) {
                ecs.removeEntity(obj);
                ecs.eventEmitter.emit("hit");
              }
            }
          }
        }
      }
    }
  }
};

export { collisionSystem };
