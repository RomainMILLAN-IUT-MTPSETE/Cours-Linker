//librairie pour la gestion des matrices 3x3
// code recupere de https://webglfundamentals.org/
var m4 = {
    translation: function (tx, ty, tz) {
        return [
            1, 0, 0, 0,
            0, 1, 0, 0,
            0, 0, 1, 0,
            tx, ty, tz, 1,
        ];
    },

    xRotation: function (angleInRadians) {
        var c = Math.cos(angleInRadians);
        var s = Math.sin(angleInRadians);

        return [
            1, 0, 0, 0,
            0, c, s, 0,
            0, -s, c, 0,
            0, 0, 0, 1,
        ];
    },

    yRotation: function (angleInRadians) {
        var c = Math.cos(angleInRadians);
        var s = Math.sin(angleInRadians);

        return [
            c, 0, -s, 0,
            0, 1, 0, 0,
            s, 0, c, 0,
            0, 0, 0, 1,
        ];
    },

    zRotation: function (angleInRadians) {
        var c = Math.cos(angleInRadians);
        var s = Math.sin(angleInRadians);

        return [
            c, s, 0, 0,
            -s, c, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1,
        ];
    },

    scaling: function (sx, sy, sz) {
        return [
            sx, 0, 0, 0,
            0, sy, 0, 0,
            0, 0, sz, 0,
            0, 0, 0, 1,
        ];
    },
    translate: function (m, tx, ty, tz) {
        return m4.multiply(m, m4.translation(tx, ty, tz));
    },

    xRotate: function (m, angleInRadians) {
        return m4.multiply(m, m4.xRotation(angleInRadians));
    },

    yRotate: function (m, angleInRadians) {
        return m4.multiply(m, m4.yRotation(angleInRadians));
    },

    zRotate: function (m, angleInRadians) {
        return m4.multiply(m, m4.zRotation(angleInRadians));
    },

    scale: function (m, sx, sy, sz) {
        return m4.multiply(m, m4.scaling(sx, sy, sz));
    },
    multiply: function (a, b) {
        var b00 = b[0 * 4 + 0];
        var b01 = b[0 * 4 + 1];
        var b02 = b[0 * 4 + 2];
        var b03 = b[0 * 4 + 3];
        var b10 = b[1 * 4 + 0];
        var b11 = b[1 * 4 + 1];
        var b12 = b[1 * 4 + 2];
        var b13 = b[1 * 4 + 3];
        var b20 = b[2 * 4 + 0];
        var b21 = b[2 * 4 + 1];
        var b22 = b[2 * 4 + 2];
        var b23 = b[2 * 4 + 3];
        var b30 = b[3 * 4 + 0];
        var b31 = b[3 * 4 + 1];
        var b32 = b[3 * 4 + 2];
        var b33 = b[3 * 4 + 3];
        var a00 = a[0 * 4 + 0];
        var a01 = a[0 * 4 + 1];
        var a02 = a[0 * 4 + 2];
        var a03 = a[0 * 4 + 3];
        var a10 = a[1 * 4 + 0];
        var a11 = a[1 * 4 + 1];
        var a12 = a[1 * 4 + 2];
        var a13 = a[1 * 4 + 3];
        var a20 = a[2 * 4 + 0];
        var a21 = a[2 * 4 + 1];
        var a22 = a[2 * 4 + 2];
        var a23 = a[2 * 4 + 3];
        var a30 = a[3 * 4 + 0];
        var a31 = a[3 * 4 + 1];
        var a32 = a[3 * 4 + 2];
        var a33 = a[3 * 4 + 3];

        return [
            b00 * a00 + b01 * a10 + b02 * a20 + b03 * a30,
            b00 * a01 + b01 * a11 + b02 * a21 + b03 * a31,
            b00 * a02 + b01 * a12 + b02 * a22 + b03 * a32,
            b00 * a03 + b01 * a13 + b02 * a23 + b03 * a33,
            b10 * a00 + b11 * a10 + b12 * a20 + b13 * a30,
            b10 * a01 + b11 * a11 + b12 * a21 + b13 * a31,
            b10 * a02 + b11 * a12 + b12 * a22 + b13 * a32,
            b10 * a03 + b11 * a13 + b12 * a23 + b13 * a33,
            b20 * a00 + b21 * a10 + b22 * a20 + b23 * a30,
            b20 * a01 + b21 * a11 + b22 * a21 + b23 * a31,
            b20 * a02 + b21 * a12 + b22 * a22 + b23 * a32,
            b20 * a03 + b21 * a13 + b22 * a23 + b23 * a33,
            b30 * a00 + b31 * a10 + b32 * a20 + b33 * a30,
            b30 * a01 + b31 * a11 + b32 * a21 + b33 * a31,
            b30 * a02 + b31 * a12 + b32 * a22 + b33 * a32,
            b30 * a03 + b31 * a13 + b32 * a23 + b33 * a33,
        ];
    },
    projection: function (width, height, depth) {
        // Note: This matrix flips the Y axis so 0 is at the top.
        return [
            2 / width, 0, 0, 0,
            0, -2 / height, 0, 0,
            0, 0, 2 / depth, 0,
            -1, 1, 0, 1,
        ];
    },
};

var m3 = {
    identity: function () {
        return [
            1, 0, 0,
            0, 1, 0,
            0, 0, 1,
        ];
    },
    multiply: function (a, b) {
        var a00 = a[0 * 3 + 0];
        var a01 = a[0 * 3 + 1];
        var a02 = a[0 * 3 + 2];
        var a10 = a[1 * 3 + 0];
        var a11 = a[1 * 3 + 1];
        var a12 = a[1 * 3 + 2];
        var a20 = a[2 * 3 + 0];
        var a21 = a[2 * 3 + 1];
        var a22 = a[2 * 3 + 2];
        var b00 = b[0 * 3 + 0];
        var b01 = b[0 * 3 + 1];
        var b02 = b[0 * 3 + 2];
        var b10 = b[1 * 3 + 0];
        var b11 = b[1 * 3 + 1];
        var b12 = b[1 * 3 + 2];
        var b20 = b[2 * 3 + 0];
        var b21 = b[2 * 3 + 1];
        var b22 = b[2 * 3 + 2];

        return [
            b00 * a00 + b01 * a10 + b02 * a20,
            b00 * a01 + b01 * a11 + b02 * a21,
            b00 * a02 + b01 * a12 + b02 * a22,
            b10 * a00 + b11 * a10 + b12 * a20,
            b10 * a01 + b11 * a11 + b12 * a21,
            b10 * a02 + b11 * a12 + b12 * a22,
            b20 * a00 + b21 * a10 + b22 * a20,
            b20 * a01 + b21 * a11 + b22 * a21,
            b20 * a02 + b21 * a12 + b22 * a22,
        ];
    },
    translation: function (tx, ty) {
        return [
            1, 0, 0,
            0, 1, 0,
            tx, ty, 1,
        ];
    },
    rotation: function (angleInRadians) {
        var c = Math.cos(angleInRadians);
        var s = Math.sin(angleInRadians);
        return [
            c, -s, 0,
            s, c, 0,
            0, 0, 1,
        ];
    },
    scaling: function (sx, sy) {
        return [
            sx, 0, 0,
            0, sy, 0,
            0, 0, 1,
        ];
    },
    //NEW

    projection: function (w, h) {
        return [
            2 / w, 0, 0,
            0, -2 / h, 0,
            -1, 1, 1
        ];
    },

    //    
};
var program;
var gl;
var translation = [100, 50, 0];
var rotation = [0, 0, 0];
var scale = [1, 1, 1];
var color;


var positionLocation;
//var resolutionLocation;
var positionBuffer;
var matrixLocation;

function setupUI() {
    let sliderContainer = document.getElementById("sliderContainer");
    createSliderWithLabel2(sliderContainer, -gl.canvas.width, gl.canvas.width, translation[0], 1, "tx", function (v) { translation[0] = v; updateScene(); })
    sliderContainer.appendChild(document.createElement('br'));
    createSliderWithLabel2(sliderContainer, -gl.canvas.height, gl.canvas.height, translation[1], 1, "ty", function (v) { translation[1] = v; updateScene(); })
    sliderContainer.appendChild(document.createElement('br'));
    createSliderWithLabel2(sliderContainer, -gl.canvas.height, gl.canvas.height, translation[2], 1, "tz", function (v) { translation[2] = v; updateScene(); })


    sliderContainer.appendChild(document.createElement('hr'));
    createSliderWithLabel2(sliderContainer, 0, 360, rotation[0], 1, "rx", function (v) { rotation[0] = v; updateScene(); })
    sliderContainer.appendChild(document.createElement('br'));
    createSliderWithLabel2(sliderContainer, 0, 360, rotation[1], 1, "ry", function (v) { rotation[1] = v; updateScene(); })
    sliderContainer.appendChild(document.createElement('br'));
    createSliderWithLabel2(sliderContainer, 0, 360, rotation[2], 1, "rz", function (v) { rotation[2] = v; updateScene(); })

    sliderContainer.appendChild(document.createElement('hr'));
    createSliderWithLabel2(sliderContainer, 0, 5, scale[0], 0.2, "sx", function (v) { scale[0] = v; updateScene(); })
    sliderContainer.appendChild(document.createElement('br'));
    createSliderWithLabel2(sliderContainer, 0, 5, scale[1], 0.2, "sy", function (v) { scale[1] = v; updateScene(); })
    sliderContainer.appendChild(document.createElement('br'));
    createSliderWithLabel2(sliderContainer, 0, 5, scale[2], 0.2, "sz", function (v) { scale[2] = v; updateScene(); })


}

// Dessiner la lettre T dans un espace 3D
function fillGeometryCoordinates(gl) {
    gl.bufferData(
        gl.ARRAY_BUFFER,
        new Float32Array([
            0, 0, 0,
            0, 10, 0,
            50, 0, 0,
            0, 10, 0,
            50, 0, 0,
            50, 10, 0,
            20, 10, 0,
            30, 10, 0,
            20, 10 + 40, 0,
            20 + 10, 10, 0,
            20, 10 + 40, 0,
            20 + 10, 10 + 40, 0



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

    var size = 3;          // 3 elements par iteration
    var type = gl.FLOAT;   // type
    var normalize = false; // pas de normalisation de vecteur
    var stride = 0;        // 0 de décalage entre composants
    var offset = 0;        // 0 décalage de départ
    gl.vertexAttribPointer(
        positionLocation, size, type, normalize, stride, offset
    );
    // set the color
    gl.uniform4fv(colorLocation, color);






    // Compute the matrix
    let matrix = m4.projection(gl.canvas.clientWidth, gl.canvas.clientHeight, 400);
    matrix = m4.translate(matrix, translation[0], translation[1], translation[2]);
    matrix = m4.xRotate(matrix, -rotation[0] * Math.PI / 180);
    matrix = m4.yRotate(matrix, -rotation[1] * Math.PI / 180);
    matrix = m4.zRotate(matrix, -rotation[2] * Math.PI / 180);
    matrix = m4.scale(matrix, scale[0], scale[1], scale[2]);

    // Set the matrix.
    gl.uniformMatrix4fv(matrixLocation, false, matrix);


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
                attribute vec4 a_position;
                uniform mat4 u_matrix;
                void main() {
                // Transformation & Project
                    vec4 position = u_matrix * a_position;
                    gl_Position = position;
                //---
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
    positionLocation = gl.getAttribLocation(program, "a_position");
    colorLocation = gl.getUniformLocation(program, "u_color");
    matrixLocation = gl.getUniformLocation(program, "u_matrix");
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



