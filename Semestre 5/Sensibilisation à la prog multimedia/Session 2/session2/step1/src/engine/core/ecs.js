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


// export these symbols 
export {ECS}
