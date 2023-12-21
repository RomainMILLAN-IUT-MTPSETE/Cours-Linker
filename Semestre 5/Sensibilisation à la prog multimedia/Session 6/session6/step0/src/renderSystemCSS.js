
const cssRenderSystem = (entities, components, root) => {
    root.innerHTML = '';

    console.log("-----");
    console.log(entities);
    console.log(components);
    console.log("-----");
    
    for (const entity of entities) {
        if (components.RenderableTag[entity] &&
            components.GraphicsComponent[entity] &&
            components.PositionComponent[entity]
        ) {
            const position = components.PositionComponent[entity];
            const grfx = components.GraphicsComponent[entity];
            let nid = entity.description;
            let oldone = document.getElementById(nid);
            if (oldone) {
                oldone.remove();
            }
            let monRectangle = document.createElement('div');
            monRectangle.id = nid;
            root.appendChild(monRectangle);
            //document.body.appendChild(monRectangle);
            monRectangle.style.width = grfx.shapeInfo.w + 'px';
            monRectangle.style.height = grfx.shapeInfo.h + 'px';
            monRectangle.style.backgroundColor = grfx.shapeInfo.color;
            monRectangle.style.position = 'absolute';
            monRectangle.style.top = position.y + 'px';
            monRectangle.style.left = position.x + 'px';
            if (position.z) { monRectangle.style.zIndex = position.z };

        }
    }
};


export { cssRenderSystem }