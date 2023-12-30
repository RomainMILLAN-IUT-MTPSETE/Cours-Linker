import * as engine from "./engine.js";

//Ball : Position,Velocity, BallTag,PhysicsTag, CollisionTag.
function Ball(x, y, w, h, dx = 0, dy = 0) {
  const gameObj1 = engine.ecs.createEntity();
  engine.ecs.addComponent(gameObj1, engine.components.BallTag());
  engine.ecs.addComponent(gameObj1, engine.components.PhysicsTag());
  engine.ecs.addComponent(
    gameObj1,
    engine.components.PositionComponent(x, y, 1)
  );
  engine.ecs.addComponent(
    gameObj1,
    engine.components.VelocityComponent(dx * 1.2, dy * 1.2)
  );
  engine.ecs.addComponent(gameObj1, engine.components.RenderableTag());
  engine.ecs.addComponent(
    gameObj1,
    engine.components.GraphicsComponent("rectangle", {
      w: w,
      h: h,
      color: {
        r: 0.5,
        g: 0.5,
        b: 0.5,
      },
    })
  );
  engine.ecs.addComponent(gameObj1, engine.components.CollisionTag());
  engine.ecs.addComponent(
    gameObj1,
    engine.components.CollisionBoxComponent(w * 0.4, h * 0.4)
  );
  return gameObj1;
}

function Raquette(x, y, w, h) {
  const gameObj1 = engine.ecs.createEntity();
  engine.ecs.addComponent(gameObj1, engine.components.RaquetteTag());
  engine.ecs.addComponent(gameObj1, engine.components.PhysicsTag());
  engine.ecs.addComponent(
    gameObj1,
    engine.components.PositionComponent(x, y, 0)
  );
  engine.ecs.addComponent(gameObj1, engine.components.RenderableTag());
  engine.ecs.addComponent(
    gameObj1,
    engine.components.GraphicsComponent("rectangle", {
      w: w,
      h: h,
      color: {
        r: 0.75,
        g: 0.75,
        b: 0.5,
      },
    })
  );
  engine.ecs.addComponent(gameObj1, engine.components.CollisionTag());
  engine.ecs.addComponent(
    gameObj1,
    engine.components.CollisionBoxComponent(w, h)
  );
  return gameObj1;
}

function Brique(x, y, w, h) {
  const gameObj1 = engine.ecs.createEntity();
  engine.ecs.addComponent(gameObj1, engine.components.BriqueTag());
  engine.ecs.addComponent(
    gameObj1,
    engine.components.PositionComponent(x, y, 0)
  );
  engine.ecs.addComponent(gameObj1, engine.components.RenderableTag());
  engine.ecs.addComponent(
    gameObj1,
    engine.components.GraphicsComponent("rectangle", {
      w: w,
      h: h,
      color: randomColor(),
    })
  );
  engine.ecs.addComponent(gameObj1, engine.components.CollisionTag());
  engine.ecs.addComponent(
    gameObj1,
    engine.components.CollisionBoxComponent(w, h)
  );
  return gameObj1;
}

function Mur(x, y, w, h) {
  const gameObj1 = engine.ecs.createEntity();
  engine.ecs.addComponent(gameObj1, engine.components.MurTag());
  engine.ecs.addComponent(
    gameObj1,
    engine.components.PositionComponent(x, y, 0)
  );
  engine.ecs.addComponent(gameObj1, engine.components.RenderableTag());
  engine.ecs.addComponent(
    gameObj1,
    engine.components.GraphicsComponent("rectangle", {
      w: w,
      h: h,
      color: "#E1ABAE",
    })
  );
  engine.ecs.addComponent(gameObj1, engine.components.CollisionTag());
  engine.ecs.addComponent(
    gameObj1,
    engine.components.CollisionBoxComponent(w, h)
  );
  return gameObj1;
}

function GameState() {
  const gameObj1 = engine.ecs.createEntity();
  engine.ecs.addComponent(gameObj1, engine.components.GameStateComponent());
  return gameObj1;
}

function randomColor() {
  return {
    r: Math.random(),
    g: Math.random(),
    b: Math.random(),
  };
}

export { Ball, Raquette, Brique, Mur, GameState };
