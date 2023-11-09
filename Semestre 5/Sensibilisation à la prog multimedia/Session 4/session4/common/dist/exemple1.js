import * as geo from './geometrie.js';
//import * as glMatrix from '../lib/gl-matrix-min.js';
let e0 = new geo.Point2D(1, 0).getVector();
let e1 = new geo.Point2D(0, 1).getVector();
let es1 = new geo.VectorSpace([e0, e1]);
let b0 = new geo.Point2D(-2, 0).getVector();
let b1 = new geo.Point2D(0, -1).getVector();
let es2 = new geo.VectorSpace([b0, b1]);
let matricePassage = es2.changeBase(es1); // es1 => es2
let passage = glMatrix.mat2.fromValues(matricePassage[0][0], matricePassage[0][1], matricePassage[1][0], matricePassage[1][1]);
let coordonnees_es1 = glMatrix.vec2.fromValues(1, 1); // coordonnées dans es1
let coordonnees_es2 = glMatrix.vec2.create();
glMatrix.vec2.transformMat2(coordonnees_es2, coordonnees_es1, passage); // coordonnees_es2 = passage . coordonnees_es1
console.log("P = " + glMatrix.mat2.str(passage));
console.log("result" + glMatrix.vec2.str(coordonnees_es2));
