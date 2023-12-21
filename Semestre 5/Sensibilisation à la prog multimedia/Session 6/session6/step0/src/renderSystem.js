import {m4} from "./utils.js";

const webGLRenderSystem = (entities, components, gl) => {
    gl.clearColor(1.0, 1.0, 1.0, 1.0);
    gl.clear(gl.COLOR_BUFFER_BIT);

    for (const entity of entities) {
        if (
            components.RenderableTag[entity] &&
            components.GraphicsComponent[entity] &&
            components.PositionComponent[entity]
        ) {
            const position = components.PositionComponent[entity];
            const grfx = components.GraphicsComponent[entity];

            const buffer = gl.createBuffer();
            gl.bindBuffer(gl.ARRAY_BUFFER, buffer);
            const positions = [
                position.x, position.y,
                position.x + grfx.shapeInfo.w,
                position.y,
                position.x,
                position.y + grfx.shapeInfo.h,
                position.x,
                position.y + grfx.shapeInfo.h,
                position.x + grfx.shapeInfo.w,
                position.y,
                position.x + grfx.shapeInfo.w,
                position.y + grfx.shapeInfo.h
            ];
            gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(positions), gl.STATIC_DRAW);

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

            const vertexShaderSource = `
                attribute vec4 a_position;

                uniform mat4 u_matrix;
                void main(void) {
                    gl_Position = u_matrix * a_position;
                }
            `;
            const vertexShader = compileShader(vertexShaderSource, gl.VERTEX_SHADER);

            const fragmentShaderSource = `
                precision mediump float;
                uniform vec4 v_color;

                void main(void) {
                    gl_FragColor = v_color;
                }
            `;
            const fragmentShader = compileShader(fragmentShaderSource, gl.FRAGMENT_SHADER);

            const program = gl.createProgram();
            gl.attachShader(program, vertexShader);
            gl.attachShader(program, fragmentShader);
            gl.linkProgram(program);
            gl.useProgram(program);

            const positionLocation = gl.getAttribLocation(program, "a_position");
            
            const positionBuffer = gl.createBuffer();
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(positions), gl.STATIC_DRAW);

            gl.vertexAttribPointer(positionLocation, 2, gl.FLOAT, false, 0, 0);
            gl.enableVertexAttribArray(positionLocation);

            const colorLoc = gl.getUniformLocation(program, "v_color");
            gl.uniform4fv(colorLoc, new Float32Array([
                grfx.shapeInfo.color.r,
                grfx.shapeInfo.color.g,
                grfx.shapeInfo.color.b,
                1.0
            ]));

            let matrix = m4.projection(gl.canvas.clientWidth, gl.canvas.clientHeight, 1);
            const u_matrix = gl.getUniformLocation(program, "u_matrix");
            gl.uniformMatrix4fv(u_matrix, false, matrix);

            gl.drawArrays(gl.TRIANGLES, 0, 6);
        }
    }
};

export { webGLRenderSystem };
