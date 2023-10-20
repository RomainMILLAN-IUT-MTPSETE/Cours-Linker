let canvas = document.querySelector("#canvas");
let gl = canvas.getContext("webgl") || canvas.getContext("experimental-webgl");

if (!gl) alert("WebGL non supporté par votre navigateur");

let vertexShaderSource = `
    attribute vec4 a_position;
    void main() {
        gl_Position = a_position;
        gl_PointSize = 10.0;
    }
`;

let fragmentShaderSource = `
    precision mediump float;
    void main() {
        gl_FragColor = vec4(0.8, 0.2, 0, 1);
    }
`;

function compileShader(source, type) {
  let shader = gl.createShader(type);
  gl.shaderSource(shader, source);
  gl.compileShader(shader);
  if (!gl.getShaderParameter(shader, gl.COMPILE_STATUS)) {
    console.error(
      `Erreur de compilation du shader: ${gl.getShaderInfoLog(shader)}`
    );
    gl.deleteShader(shader);
    return null;
  }
  return shader;
}

let vertexShader = compileShader(vertexShaderSource, gl.VERTEX_SHADER);
let fragmentShader = compileShader(fragmentShaderSource, gl.FRAGMENT_SHADER);

let program = gl.createProgram();
gl.attachShader(program, vertexShader);
gl.attachShader(program, fragmentShader);
gl.linkProgram(program);
gl.useProgram(program);

let positions = new Float32Array([-0.5, -0.5, 0.5, -0.5, -0.5, 0.5, 0.5, 0.5]);

let positionBuffer = gl.createBuffer();
gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
gl.bufferData(gl.ARRAY_BUFFER, positions, gl.STATIC_DRAW);

let position = gl.getAttribLocation(program, "a_position");
gl.enableVertexAttribArray(position);
gl.vertexAttribPointer(position, 2, gl.FLOAT, false, 0, 0);

gl.useProgram(program);
gl.clear(gl.COLOR_BUFFER_BIT);
gl.drawArrays(gl.TRIANGLE_STRIP, 0, 4);