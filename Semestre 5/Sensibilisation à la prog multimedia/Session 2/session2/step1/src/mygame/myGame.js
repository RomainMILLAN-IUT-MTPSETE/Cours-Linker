"use strict"; 

import * as loop from "../engine/core/loop.js";
import * as engine from "../engine/index.js";




class MyGame {

    constructor()
    {
        //les carres
        this.mWhiteSq = null; 
        this.mRedSq = null;
        // The camera to view the scene
        this.mCamera = null;
    }

    init()
    {
        this.mCamera = new engine.Camera(
        vec2.fromValues(20, 60),
        20,                        // width of camera
        [20, 40, 600, 300]         // viewport (orgX, orgY, width, height)
        );

        this.mCamera.setBackgroundColor([0.8, 0.8, 0.8, 1]);
        // sets the background to gray
        // Step  B: Create the Renderable objects:
        this.mWhiteSq = new engine.Renderable();
        this.mWhiteSq.setColor([1, 1, 1, 1]);
        this.mRedSq = new engine.Renderable();
        this.mRedSq.setColor([1, 0, 0, 1]);
        // Step  C: Init the white Renderable: centered, 5x5, rotated
        this.mWhiteSq.getXform().setPosition(20, 60);
        this.mWhiteSq.getXform().setRotationInRad(0.2); // In Radians
        this.mWhiteSq.getXform().setSize(5, 5);
        // Step  D: Initialize the red Renderable object: centered 2x2
        this.mRedSq.getXform().setPosition(20, 60);
        this.mRedSq.getXform().setSize(2, 2);
        

    }

    draw() {
    // Step A: clear the canvas
    engine.clearCanvas([0.9, 0.9, 0.9, 1.0]); // clear to light gray
    // Step  B: Activate the drawing Camera
    this.mCamera.setViewAndCameraMatrix();
    // Step  C: Activate the white shader to draw
    this.mWhiteSq.draw(this.mCamera);
    // Step  D: Activate the red shader to draw
    this.mRedSq.draw(this.mCamera);
    }

    update() {
    // Simple game: move the white square and pulse the red
    let whiteXform = this.mWhiteSq.getXform();
    let deltaX = 0.05;
    
    //Animations 

    // Step A: Rotate the white square
    if (whiteXform.getXPos() > 30) // the right-bound of the window
        whiteXform.setPosition(10, 60);
    whiteXform.incXPosBy(deltaX);
    whiteXform.incRotationByDegree(1);


    // Step B: pulse the red square
    let redXform = this.mRedSq.getXform();
    if (redXform.getWidth() > 5)
        redXform.setSize(2, 2);
    redXform.incSizeBy(0.05);
    }




}


window.onload = function () {
    engine.init("GLCanvas");
    let myGame = new MyGame();
    // new begins the game
    loop.start(myGame);
}


