
var program;
var gl;
var translation = [100, 50];
//nouveau
var rotationAngle = 0;
//

var positionLocation;
var resolutionLocation;
var tranlsationLocation;
var rotationLocation;

var positionBuffer;
var color;

function setupUI() {
    let sliderContainer = document.getElementById("sliderContainer");
    createSliderWithLabel2(sliderContainer, -gl.canvas.width, gl.canvas.width, translation[0], 1, "tx", function (v) { translation[0] = v; updateScene(); })
    sliderContainer.appendChild(document.createElement('br'));
    createSliderWithLabel2(sliderContainer, -gl.canvas.height, gl.canvas.height, translation[1], 1, "ty", function (v) { translation[1] = v; updateScene(); })
    sliderContainer.appendChild(document.createElement('hr'));
    createSliderWithLabel2(sliderContainer, 0, 360, rotationAngle, 1, "r", function (v) { rotationAngle = v; updateScene(); })

}

// Dessiner la lettre T
function fillGeometryCoordinates(gl) {
    gl.bufferData(
        gl.ARRAY_BUFFER,
        new Float32Array([
            0, 0,
            0, 10,
            50, 0,
            0, 10,
            50, 0,
            50, 10,
            20, 10,
            30, 10,
            20, 10 + 40,
            20 + 10, 10,
            20, 10 + 40,
            20 + 10, 10 + 40



        ]),
        gl.STATIC_DRAW);
}


function updateScene() {
    webglUtils.resizeCanvasToDisplaySize(gl.canvas);
    gl.viewport(0, 0, gl.canvas.width, gl.canvas.height);
    gl.clear(gl.COLOR_BUFFER_BIT);
    gl.useProgram(program);
    gl.enableVertexAttribArray(positionLocation);
    gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
    fillGeometryCoordinates(gl);

    var size = 2;          // 2 elements par iteration
    var type = gl.FLOAT;   // type
    var normalize = false; // pas de normalisation de vecteur
    var stride = 0;        // 0 de décalage entre composants
    var offset = 0;        // 0 décalage de départ
    gl.vertexAttribPointer(
        positionLocation, size, type, normalize, stride, offset
    );
    // set the resolution
    gl.uniform2f(resolutionLocation, gl.canvas.width, gl.canvas.height);
    // set the color
    gl.uniform4fv(colorLocation, color);

    //mettre la translation
    gl.uniform2fv(tranlsationLocation, translation);

    //nouveau : mettre la rotation
    //il faut transformer les degres en radian
    let angleInRadians = -rotationAngle * Math.PI / 180
    gl.uniform2f(rotationLocation, Math.sin(angleInRadians), Math.cos(angleInRadians));



    // Draw the rectangle.
    var primitiveType = gl.TRIANGLES;
    var offset = 0;
    var count = 12;
    gl.drawArrays(primitiveType, offset, count);
}

function setupGL() {
    var canvas = document.getElementById('canvas');
    gl = canvas.getContext('webgl') || canvas.getContext('experimental-webgl');


    // Shader sources
    var vertexShaderSource = `
                attribute vec2 a_position;
                uniform vec2 u_resolution;
                uniform vec2 u_translation ;
                //nouveau
                uniform vec2 u_rotation ;
                //
                
                void main() {
                    //TODO
                    // cacluler la nouvelle position par rapport 
                    // a la rotation 
                    vec2 rotatedPos = vec2 (
                        a_position.x * u_rotation.x - a_position.y * u_rotation.y,
                        a_position.x * u_rotation.y + a_position.y * u_rotation.x
                    );
                    
                    //-------
                    
                    //phase de translation
                    vec2 position = rotatedPos + u_translation ;
                    
                    //phase de projection
                    vec2 zeroToOne = position / u_resolution;
                    vec2 zeroToTwo = zeroToOne * 2.0;
                    vec2 clipSpace = zeroToTwo - 1.0;
                    gl_Position = vec4(clipSpace * vec2(1, -1), 0, 1);
                }
            `;

    var fragmentShaderSource = `
                precision mediump float;
                uniform vec4 u_color;
                void main() {
                    gl_FragColor = u_color;
                }
            `;

    // Compile shader
    function compileShader(source, type) {
        var shader = gl.createShader(type);
        gl.shaderSource(shader, source);
        gl.compileShader(shader);
        if (!gl.getShaderParameter(shader, gl.COMPILE_STATUS)) {
            console.error('Erreur de compilation du shader: ' + gl.getShaderInfoLog(shader));
            gl.deleteShader(shader);
            return null;
        }
        return shader;
    }

    var vertexShader = compileShader(vertexShaderSource, gl.VERTEX_SHADER);
    var fragmentShader = compileShader(fragmentShaderSource, gl.FRAGMENT_SHADER);

    // Link shaders into a program
    program = gl.createProgram();
    gl.attachShader(program, vertexShader);
    gl.attachShader(program, fragmentShader);
    gl.linkProgram(program);
    //
    positionLocation = gl.getAttribLocation(program, "a_position");
    resolutionLocation = gl.getUniformLocation(program, "u_resolution");
    colorLocation = gl.getUniformLocation(program, "u_color");
    tranlsationLocation = gl.getUniformLocation(program, "u_translation");
    //Nouveau:
    rotationLocation = gl.getUniformLocation(program, "u_rotation");

    //
    color = [Math.random(), Math.random(), Math.random(), 1];

    positionBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);

}

function main() {
    setupGL();
    setupUI();
    updateScene();
}

main();