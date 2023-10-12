"use strict"; 

window.onload = function() {
    let canvas = document.getElementById("webglCanvas");
    let gl;

    try {
        gl = canvas.getContext('experimental-webgl');

        console.log("WebGL support")
    }catch(e) {
        console.log("Error");
    }

    if(gl) {
        gl.clearColor(1.0, 0.0, 0.0, 1.0);
        gl.clear(gl.COLOR_BUFFER_BIT );
    }

}