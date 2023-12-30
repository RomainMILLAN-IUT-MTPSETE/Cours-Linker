import * as cpn from "./components.js";

const hudSystem = (entities, components, root) => {
    root.innerHTML = '';
    for (const stateEntity of Object.getOwnPropertySymbols(components[cpn.GameStateComponent.name])) {
        {
            let hits = components.GameStateComponent[stateEntity].hits ;
            let life = components.GameStateComponent[stateEntity].life ;
            let score = hits * 10 ; 
            if(components.GameStateComponent[stateEntity].state == 'running')
            {
              root.innerHTML = '<div id="score"> Votre score :  <span class="easvhs-font">'+ score +'</span></div> <br/> <div id="score"> Nombre de vie : <span class="easvhs-font">' + life + '</span></div>';
            } 
            else if(components.GameStateComponent[stateEntity].state == 'gameover')
            {
                root.innerHTML = '<div id="gameHUD"> <div id="score"> Fin de partie (votre score : <span class="easvhs-font">'+score+'</span>)</div> <div class="game_state" id="gameOver">❌ Game Over ❌</div> </div>';
            } else if(components.GameStateComponent[stateEntity].state == 'victory')
            {
                root.innerHTML = '<div id="gameHUD"> <div id="score"> Fin de partie (votre score : <span class="easvhs-font">'+score+'</span>)</div> <div class="game_state" id="victory">Victoire 🎉</div> </div>';
            }
        }
    }
};


export { hudSystem }