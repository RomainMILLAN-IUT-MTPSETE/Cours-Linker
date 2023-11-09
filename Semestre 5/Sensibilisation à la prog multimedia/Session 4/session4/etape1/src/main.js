
function createSliders(espaceVect2D) {
    let e0_base = espaceVect2D.base[0];
    let e1_base = espaceVect2D.base[1];
    const sliderContainer = document.getElementById('sliderContainer');
    createSliderWithLabel2(sliderContainer, -1, 1, e0_base.x, 0.01, 'e0.x', function (value) {
        // Callback pour le premier slider
        e0_base.x = value;
        drawScene(espaceVect2D);
    });
    sliderContainer.appendChild(document.createElement('br'));
    createSliderWithLabel2(sliderContainer, -1, 1, e0_base.y, 0.01, 'e0.y', function (value) {
        // Callback pour le deuxième slider
        e0_base.y = value;
        drawScene(espaceVect2D);

    });
    sliderContainer.appendChild(document.createElement('hr'));
    createSliderWithLabel2(sliderContainer, -1, 1, e1_base.x, 0.01, 'e1.x', function (value) {
        // Callback pour le premier slider
        e1_base.x = value;
        drawScene(espaceVect2D);

    });
    sliderContainer.appendChild(document.createElement('br'));
    createSliderWithLabel2(sliderContainer, -1, 1, e1_base.y, 0.01, 'e1.y', function (value) {
        // Callback pour le deuxième slider
        e1_base.y = value;
        drawScene(espaceVect2D);

    });
};


function configurationGL(gl) {
    // Shader sources
    var vertexShaderSource = `
                attribute vec4 a_position;
                void main() {
                    gl_Position = a_position;
                    gl_PointSize = 2.0;
                }
            `;

    var fragmentShaderSource = `
                precision mediump float;
                void main() {
                    gl_FragColor = vec4(0.8, 0.2, 0, 1);  // Orange
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

}



function getPositionsFromCoordinates(coord, espace) {
    res = [];
    for (let i = 0; i < coord.length; i+=2) {
        let x = coord[i];
        let y = coord[i+1];
        let linearCombinationRes = espace.linearCombination([x, y])
        res.push(linearCombinationRes.x);
        res.push(linearCombinationRes.y);
    }
    return res;
}
//--


function drawScene(espaceVect) {
    webglUtils.resizeCanvasToDisplaySize(gl.canvas);
    gl.viewport(0, 0, gl.canvas.width, gl.canvas.height);

    var positions = new Float32Array(
        getPositionsFromCoordinates(coordinates, espaceVect)
    );

    // 
    var positionBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
    gl.bufferData(gl.ARRAY_BUFFER, positions, gl.STATIC_DRAW);

    var position = gl.getAttribLocation(program, 'a_position');
    gl.enableVertexAttribArray(position);
    gl.vertexAttribPointer(position, 2, gl.FLOAT, false, 0, 0);

    gl.useProgram(program);
    // 
    gl.clear(gl.COLOR_BUFFER_BIT);
    gl.drawArrays(gl.TRIANGLES, 0, 3);
}

