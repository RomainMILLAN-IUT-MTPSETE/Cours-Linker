//librairie pour la gestion des matrices 3x3
// code recupere de https://webglfundamentals.org/
var m4 = {


subtractVectors:   function (a, b) {
  return [a[0] - b[0], a[1] - b[1], a[2] - b[2]];
}
,
normalize: function (v) {
  var length = Math.sqrt(v[0] * v[0] + v[1] * v[1] + v[2] * v[2]);
  // make sure we don't divide by 0.
  if (length > 0.00001) {
    return [v[0] / length, v[1] / length, v[2] / length];
  } else {
    return [0, 0, 0];
  }
},

cross: function (a, b) {
  return [a[1] * b[2] - a[2] * b[1],
          a[2] * b[0] - a[0] * b[2],
          a[0] * b[1] - a[1] * b[0]];
},


    lookAt: function(cameraPosition, target, up) {
    var zAxis = m4.normalize(
        m4.subtractVectors(cameraPosition, target));
    var xAxis = m4.normalize(m4.cross(up, zAxis));
    var yAxis = m4.normalize(m4.cross(zAxis, xAxis));

    return [
       xAxis[0], xAxis[1], xAxis[2], 0,
       yAxis[0], yAxis[1], yAxis[2], 0,
       zAxis[0], zAxis[1], zAxis[2], 0,
       cameraPosition[0],
       cameraPosition[1],
       cameraPosition[2],
       1,
    ];
    },

    identity: function () {
        return [
            1, 0, 0, 0,
            0, 1, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1,
        ];
    },


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

    orthographic: function (left, right, bottom, top, near, far) {
        return [
            2 / (right - left), 0, 0, 0,
            0, 2 / (top - bottom), 0, 0,
            0, 0, 2 / (near - far), 0,

            (left + right) / (left - right),
            (bottom + top) / (bottom - top),
            (near + far) / (near - far),
            1,
        ];
    },

    createPerspectiveMatrixFromZ: function (gamma) {
        return [
            1, 0, 0, 0,
            0,1, 0, 0,
            0,0, 1, gamma,
            0,0, 0, 1,
        ];
    }
    ,

    perspective: function(fieldOfViewInRadians, aspect, near, far) {
    var f = Math.tan(Math.PI * 0.5 - 0.5 * fieldOfViewInRadians);
    var rangeInv = 1.0 / (near - far);
    return [
      f / aspect, 0, 0, 0,
      0, f, 0, 0,
      0, 0, (near + far) * rangeInv, -1,
      0, 0, near * far * rangeInv * 2, 0
    ];
  },
  inverse: function(m) {
    var m00 = m[0 * 4 + 0];
    var m01 = m[0 * 4 + 1];
    var m02 = m[0 * 4 + 2];
    var m03 = m[0 * 4 + 3];
    var m10 = m[1 * 4 + 0];
    var m11 = m[1 * 4 + 1];
    var m12 = m[1 * 4 + 2];
    var m13 = m[1 * 4 + 3];
    var m20 = m[2 * 4 + 0];
    var m21 = m[2 * 4 + 1];
    var m22 = m[2 * 4 + 2];
    var m23 = m[2 * 4 + 3];
    var m30 = m[3 * 4 + 0];
    var m31 = m[3 * 4 + 1];
    var m32 = m[3 * 4 + 2];
    var m33 = m[3 * 4 + 3];
    var tmp_0  = m22 * m33;
    var tmp_1  = m32 * m23;
    var tmp_2  = m12 * m33;
    var tmp_3  = m32 * m13;
    var tmp_4  = m12 * m23;
    var tmp_5  = m22 * m13;
    var tmp_6  = m02 * m33;
    var tmp_7  = m32 * m03;
    var tmp_8  = m02 * m23;
    var tmp_9  = m22 * m03;
    var tmp_10 = m02 * m13;
    var tmp_11 = m12 * m03;
    var tmp_12 = m20 * m31;
    var tmp_13 = m30 * m21;
    var tmp_14 = m10 * m31;
    var tmp_15 = m30 * m11;
    var tmp_16 = m10 * m21;
    var tmp_17 = m20 * m11;
    var tmp_18 = m00 * m31;
    var tmp_19 = m30 * m01;
    var tmp_20 = m00 * m21;
    var tmp_21 = m20 * m01;
    var tmp_22 = m00 * m11;
    var tmp_23 = m10 * m01;

    var t0 = (tmp_0 * m11 + tmp_3 * m21 + tmp_4 * m31) -
        (tmp_1 * m11 + tmp_2 * m21 + tmp_5 * m31);
    var t1 = (tmp_1 * m01 + tmp_6 * m21 + tmp_9 * m31) -
        (tmp_0 * m01 + tmp_7 * m21 + tmp_8 * m31);
    var t2 = (tmp_2 * m01 + tmp_7 * m11 + tmp_10 * m31) -
        (tmp_3 * m01 + tmp_6 * m11 + tmp_11 * m31);
    var t3 = (tmp_5 * m01 + tmp_8 * m11 + tmp_11 * m21) -
        (tmp_4 * m01 + tmp_9 * m11 + tmp_10 * m21);

    var d = 1.0 / (m00 * t0 + m10 * t1 + m20 * t2 + m30 * t3);

    return [
      d * t0,
      d * t1,
      d * t2,
      d * t3,
      d * ((tmp_1 * m10 + tmp_2 * m20 + tmp_5 * m30) -
            (tmp_0 * m10 + tmp_3 * m20 + tmp_4 * m30)),
      d * ((tmp_0 * m00 + tmp_7 * m20 + tmp_8 * m30) -
            (tmp_1 * m00 + tmp_6 * m20 + tmp_9 * m30)),
      d * ((tmp_3 * m00 + tmp_6 * m10 + tmp_11 * m30) -
            (tmp_2 * m00 + tmp_7 * m10 + tmp_10 * m30)),
      d * ((tmp_4 * m00 + tmp_9 * m10 + tmp_10 * m20) -
            (tmp_5 * m00 + tmp_8 * m10 + tmp_11 * m20)),
      d * ((tmp_12 * m13 + tmp_15 * m23 + tmp_16 * m33) -
            (tmp_13 * m13 + tmp_14 * m23 + tmp_17 * m33)),
      d * ((tmp_13 * m03 + tmp_18 * m23 + tmp_21 * m33) -
            (tmp_12 * m03 + tmp_19 * m23 + tmp_20 * m33)),
      d * ((tmp_14 * m03 + tmp_19 * m13 + tmp_22 * m33) -
            (tmp_15 * m03 + tmp_18 * m13 + tmp_23 * m33)),
      d * ((tmp_17 * m03 + tmp_20 * m13 + tmp_23 * m23) -
            (tmp_16 * m03 + tmp_21 * m13 + tmp_22 * m23)),
      d * ((tmp_14 * m22 + tmp_17 * m32 + tmp_13 * m12) -
            (tmp_16 * m32 + tmp_12 * m12 + tmp_15 * m22)),
      d * ((tmp_20 * m32 + tmp_12 * m02 + tmp_19 * m22) -
            (tmp_18 * m22 + tmp_21 * m32 + tmp_13 * m02)),
      d * ((tmp_18 * m12 + tmp_23 * m32 + tmp_15 * m02) -
            (tmp_22 * m32 + tmp_14 * m02 + tmp_19 * m12)),
      d * ((tmp_22 * m22 + tmp_16 * m02 + tmp_21 * m12) -
            (tmp_20 * m12 + tmp_23 * m22 + tmp_17 * m02))
    ];
  },

  vectorMultiply: function(v, m) {
    var dst = [];
    for (var i = 0; i < 4; ++i) {
      dst[i] = 0.0;
      for (var j = 0; j < 4; ++j) {
        dst[i] += v[j] * m[j * 4 + i];
      }
    }
    return dst;
  },

};



var program;
var gl;
var translation = [0, 0, 0];
var rotation = [0, 0,0];
var scale = [3, 3, 3];
var color;



var near = 1;
var far = 1000;

var fov = 30;

//NEW
cameraAngle = 10;


var positionLocation;
var positionBuffer;
var colorBuffer;
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


    //---
    sliderContainer.appendChild(document.createElement('hr'));
    createSliderWithLabel2(sliderContainer, 0, 1000, near, 1, "near", function (v) { near = v; updateScene(); })
    sliderContainer.appendChild(document.createElement('br'));
    createSliderWithLabel2(sliderContainer, 1, 1000, far, 1, "far", function (v) { far = v; updateScene(); })
    sliderContainer.appendChild(document.createElement('br'));

    //---
    sliderContainer.appendChild(document.createElement('hr'));
    createSliderWithLabel2(sliderContainer, 10, 60, fov, 0.1, "fov", function (v) { fov = v; updateScene(); })

        //---
    sliderContainer.appendChild(document.createElement('hr'));
    createSliderWithLabel2(sliderContainer, 0, 360, cameraAngle, 1, "Angle Caméra", function (v) { cameraAngle = v; updateScene(); })


}

// Dessiner la lettre T dans un espace 3D

function fillGeometryCoordinates(gl) {
    let depth = 10;
    //TODO
    function sideRectangle(p1, p2, direction) {
        let r = [];

        if (direction) {
            r = [
                p2[0], p2[1], p2[2],
                p1[0], p1[1], p1[2],
                p1[0], p1[1], p1[2] + depth,

                p1[0], p1[1], p1[2] + depth,
                p2[0], p2[1], p2[2] + depth,
                p2[0], p2[1], p2[2],

            ];
        }
        else {
            r = [
                p2[0], p2[1], p2[2],
                p1[0], p1[1], p1[2] + depth,
                p1[0], p1[1], p1[2],

                p1[0], p1[1], p1[2] + depth,
                p2[0], p2[1], p2[2],
                p2[0], p2[1], p2[2] + depth,

            ];

        }
        return r;
    }
    //TODO
    function getRectanglePoints(x, y, z, w, h, direction) {
        let r = [];
        if (direction) {
            r = [
                x, y, z,
                x, y + h, z,
                x + w, y, z,
                x + w, y, z,
                x, y + h, z,
                x + w, y + h, z,
            ]

        } else {
            r = [
                x, y, z,
                x + w, y, z,
                x, y + h, z,
                x + w, y, z,
                x + w, y + h, z,
                x, y + h, z,
            ]

        }

        return r;
    }


    gl.bufferData(
        gl.ARRAY_BUFFER,
        new Float32Array([
            ...getRectanglePoints(0, 0, 0, 50, 10, true),
            ...getRectanglePoints(20, 10, 0, 10, 40, true),
            ...getRectanglePoints(0, 0, depth, 50, 10, false),
            ...getRectanglePoints(20, 10, depth, 10, 40, false),

            ...sideRectangle([0, 0, 0], [0, 10, 0], true),
            ...sideRectangle([50, 0, 0], [50, 10, 0], false),
            ...sideRectangle([20, 10, 0], [20, 10 + 40, 0], true),
            ...sideRectangle([20 + 10, 10, 0], [20 + 10, 10 + 40, 0], false),

            ...sideRectangle([0, 0, 0], [50, 0, 0], false),

            ...sideRectangle([0, 10, 0], [20, 10, 0], true),
            ...sideRectangle([30, 10, 0], [50, 10, 0], true),

            //...sideRectangle([20, 10, 0], [30, 10, 0], false),
            ...sideRectangle([20, 50, 0], [30, 50, 0], true),


        ]),
        gl.STATIC_DRAW);
}


function updateScene() {
    webglUtils.resizeCanvasToDisplaySize(gl.canvas);
    gl.viewport(0, 0, gl.canvas.width, gl.canvas.height);
    gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
    gl.enable(gl.CULL_FACE);
    gl.enable(gl.DEPTH_TEST);

    gl.useProgram(program);

    gl.enableVertexAttribArray(positionLocation);
    gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);

    var size = 3;          // 3 elements par iteration
    var type = gl.FLOAT;   // type
    var normalize = false; // pas de normalisation de vecteur
    var stride = 0;        // 0 de décalage entre composants
    var offset = 0;        // 0 décalage de départ
    gl.vertexAttribPointer(
        positionLocation, size, type, normalize, stride, offset
    );

    gl.enableVertexAttribArray(colorLocation);
    gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);

    var size = 3;                 // 3 components per iteration
    var type = gl.UNSIGNED_BYTE;  // the data is 8bit unsigned values
    var normalize = true;         // normalize the data (convert from 0-255 to 0-1)
    var stride = 0;               // 0 = move forward size * sizeof(type) each iteration to get the next position
    var offset = 0;               // start at the beginning of the buffer
    gl.vertexAttribPointer(
        colorLocation, size, type, normalize, stride, offset);

    
    let radius = 100;
    
    var aspect = gl.canvas.clientWidth / gl.canvas.clientHeight;
    var projectionMatrix = m4.perspective(fov, aspect, near, far);

    //---
    projectionMatrix = m4.translate(projectionMatrix, translation[0], translation[1], translation[2]);
    projectionMatrix = m4.xRotate(projectionMatrix, rotation[0] * Math.PI / 180);
    projectionMatrix = m4.yRotate(projectionMatrix, rotation[1] * Math.PI / 180);
    projectionMatrix = m4.zRotate(projectionMatrix, rotation[2] * Math.PI / 180);
    projectionMatrix = m4.scale(projectionMatrix, scale[0], scale[1], scale[2]);
    

    //New position de la premiere lettre
    var target = [radius, 0, 0];

    var cameraAngleRadians = cameraAngle * Math.PI /180;
    var cameraMatrix = m4.yRotation(cameraAngleRadians);
    //--------- 
    cameraMatrix = m4.translate(cameraMatrix, 0, 0, radius * 1.5);

    var cameraPosition = [
      cameraMatrix[12],
      cameraMatrix[13],
      cameraMatrix[14],
    ];
    var up = [0, 1, 0];
    //New: changer la camera avec la méthode de lookAt
    cameraMatrix = m4.lookAt(cameraPosition, target, up);


    //Inversion du monde par rapport à la position de la caméra
    var viewMatrix = m4.inverse(cameraMatrix);
    var viewProjectionMatrix = m4.multiply(projectionMatrix, viewMatrix);
    //nombre de lettre
    let num = 5;
    for (let i = 0; i < num; ++i) {
      var angle = i * Math.PI * 2 / num;
      var x = Math.cos(angle) * radius;
      var y = Math.sin(angle) * radius
      //une translation par rapport à la caméra
      var matrix = m4.translate(viewProjectionMatrix, x, 0, y);     
      gl.uniformMatrix4fv(matrixLocation, false, matrix);
      var primitiveType = gl.TRIANGLES;
      var offset = 0;
      var count = 12 * 2 * 3;
      gl.drawArrays(primitiveType, offset, count);
    }
}


function setupGL() {
    var canvas = document.getElementById('canvas');
    gl = canvas.getContext('webgl');



    // Shader sources
    var vertexShaderSource = `
                attribute vec4 a_position;
                attribute vec4 a_color;
                
                varying vec4 v_color;

                uniform mat4 u_matrix;
                void main() {
                // Transformation & Project
                    vec4 position = u_matrix * a_position;
                    gl_Position = position;
                    v_color = a_color;
                //---
                }
            `;

    var fragmentShaderSource = `
                precision mediump float;
                varying vec4 v_color;

                void main() {
                    gl_FragColor = v_color;
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
    colorLocation = gl.getAttribLocation(program, "a_color");
    matrixLocation = gl.getUniformLocation(program, "u_matrix");
    

    positionBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
    fillGeometryCoordinates(gl);

    // Create a buffer for colors.
    colorBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
    // Put the colors in the buffer.
    setColors(gl);

    gl.enable(gl.DEPTH_TEST);

}

const colors = [
    { r: 255, g: 0, b: 0 },    // Rouge
    { r: 0, g: 255, b: 0 },    // Vert
    { r: 0, g: 0, b: 255 },    // Bleu
    { r: 255, g: 255, b: 0 },  // Jaune
    { r: 0, g: 255, b: 255 },  // Cyan
    { r: 255, g: 0, b: 255 },  // Magenta
    { r: 192, g: 192, b: 192 },// Gris
    { r: 128, g: 0, b: 0 },    // Marron
    { r: 128, g: 128, b: 0 },  // Olive
    { r: 0, g: 128, b: 0 },    // Vert foncé
    { r: 128, g: 0, b: 128 },  // Pourpre
    { r: 0, g: 128, b: 128 }   // Sarcelle
];

function colorForRectangle(colorIndex) {
    let r = [];
    for (let i = 0; i < 6; i++) {
        r.push(colors[colorIndex].r, colors[colorIndex].g, colors[colorIndex].b);
    }
    return r;
}
function setColors(gl) {
    gl.bufferData(
        gl.ARRAY_BUFFER,
        new Uint8Array([
            ...colorForRectangle(0),
            ...colorForRectangle(1),
            ...colorForRectangle(2),
            ...colorForRectangle(3),
            ...colorForRectangle(4),
            ...colorForRectangle(5),
            ...colorForRectangle(6),
            ...colorForRectangle(7),
            ...colorForRectangle(8),
            ...colorForRectangle(9),
            ...colorForRectangle(10),
            ...colorForRectangle(11)
        ])
        ,
        gl.STATIC_DRAW);
}


function main() {
    setupGL();
    setupUI();
    updateScene();
}

main();



