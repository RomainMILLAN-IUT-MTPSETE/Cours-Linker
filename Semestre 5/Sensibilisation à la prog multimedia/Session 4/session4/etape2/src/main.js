
function createSliders(espaceVect2D) {
    let e0 = espaceVect2D.base[0];
    let e1 = espaceVect2D.base[1];
    const sliderContainer = document.getElementById('sliderContainer');
    createSliderWithLabel2(sliderContainer, -1, 1, e0.x, 0.01, 'e0.x', function (value) {
        // Callback pour le premier slider
        e0.x = value;
        updateScene();
    });
    sliderContainer.appendChild(document.createElement('br'));
    createSliderWithLabel2(sliderContainer, -1, 1, e0.y, 0.01, 'e0.y', function (value) {
        // Callback pour le deuxième slider
        e0.y = value;
        updateScene();

    });
    sliderContainer.appendChild(document.createElement('hr'));
    createSliderWithLabel2(sliderContainer, -1, 1, e1.x, 0.01, 'e1.x', function (value) {
        // Callback pour le premier slider
        e1.x = value;
        updateScene();

    });
    sliderContainer.appendChild(document.createElement('br'));
    createSliderWithLabel2(sliderContainer, -1, 1, e1.y, 0.01, 'e1.y', function (value) {
        // Callback pour le deuxième slider
        e1.y = value;
        updateScene();

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

    // 
    program = gl.createProgram();
    gl.attachShader(program, vertexShader);
    gl.attachShader(program, fragmentShader);
    gl.linkProgram(program);

}



function getPositionsFromCoordinates(coord, espace) {
    res = [];
    for (let i = 0; i < coord.length; i = i + 2) {
        let x = coord[i];
        let y = coord[i + 1];
        let p = espace.linearCombination([x, y]);
        res.push(p.x);
        res.push(p.y);
    }
    return res;
}


function drawScene(espaceVect, coordinates) {
    webglUtils.resizeCanvasToDisplaySize(gl.canvas);
    gl.viewport(0, 0, gl.canvas.width, gl.canvas.height);
    var positions = new Float32Array(
        getPositionsFromCoordinates(coordinates, espaceVect)
    );

    // Create a buffer
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

// TODO: changement de coordonnees
function transformation_coordonnee(espace_vectoriel_origine, espace_vectoriel_nouveau, coordonees_origine) {
   return coordonees_origine;
}
//----


function updateCell(cellId, newValue) {
    const cell = document.getElementById(cellId);
    if (cell) {
        cell.textContent = newValue;
    }
}

//TODO
function updateScene() {
    var coordinates = transformation_coordonnee(espace_vectoriel_base, espace_vectoriel_nouveau, coordonees_base_canonique);
    drawScene(espace_vectoriel_nouveau, coordinates);
    for (let i = 0; i < coordinates.length; i = i + 2) {
        updateCell("cx" + (i / 2), coordinates[i]);
        updateCell("cy" + (i / 2), coordinates[i + 1]);
    }
}