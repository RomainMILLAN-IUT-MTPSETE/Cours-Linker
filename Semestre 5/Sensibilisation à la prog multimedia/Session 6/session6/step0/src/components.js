
const PositionComponent = (x, y, z,min_x=0,min_y=0,min_z=0,max_x=300,max_y=300,max_z=10) => ({ name: 'PositionComponent', x, y, z,min_x,min_y,min_z,max_x,max_y,max_z });
const GraphicsComponent = (shape, shapeInfo) => ({ name: 'GraphicsComponent', shape, shapeInfo });
const LifeComponent = (maxLife) => ({ name: "LifeComponent", maxLife, life });
const ScoreComponent = () => ({ name: "ScoreComponent", socre: 0 });

const GameStateComponent = (state) => ({ name: "GameStateComponent", state:'running', hits:0, life: 3, leftControl: false, rightControl: false });

const CollisionBoxComponent = (width, height) => ({ name: 'CollisionBoxComponent', width, height , hit:false});
const VelocityComponent = (dx, dy) => ({ name: 'VelocityComponent', dx, dy });

const PhysicsTag = () => ({ name: 'PhysicsTag' });
const CollisionTag = () => ({ name: 'CollisionTag' });
const RenderableTag = () => ({ name: 'RenderableTag' });

const BallTag = () => ({ name: 'BallTag' });
const RaquetteTag = () => ({ name: 'RaquetteTag' });
const BriqueTag = () => ({ name: 'BriqueTag' });
const MurTag = () => ({ name: 'MurTag' });

export { MurTag, BriqueTag, RaquetteTag, BallTag, PositionComponent, CollisionBoxComponent, VelocityComponent, PhysicsTag, CollisionTag, RenderableTag, GraphicsComponent, LifeComponent, ScoreComponent, GameStateComponent }