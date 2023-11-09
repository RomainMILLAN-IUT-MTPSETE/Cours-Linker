"use strict";
function solveLinearSystem(A, b) {
    const n = A.length;
    let AugmentedMatrix = [];
    // Créer la matrice augmentée [A|b]
    for (let i = 0; i < n; i++) {
        AugmentedMatrix[i] = [...A[i], b[i]];
    }
    // Appliquer la méthode de Gauss-Jordan
    for (let i = 0; i < n; i++) {
        // Normaliser la ligne du pivot
        const factor = AugmentedMatrix[i][i];
        for (let j = 0; j < n + 1; j++) {
            AugmentedMatrix[i][j] /= factor;
        }
        // Éliminer les autres lignes
        for (let u = 0; u < n; u++) {
            if (u !== i) {
                const factor = AugmentedMatrix[u][i];
                for (let j = 0; j < n + 1; j++) {
                    AugmentedMatrix[u][j] -= factor * AugmentedMatrix[i][j];
                }
            }
        }
    }
    // Extraire la solution
    const x = new Array(n).fill(0);
    for (let i = 0; i < n; i++) {
        x[i] = AugmentedMatrix[i][n];
    }
    return x;
}
// Notion de Point Abstrait
class AbstractPoint {
}
// Notion de Ligne Abstraite
class AbstractLine {
}
// Notion de Plan Abstrait
class AbstractPlane {
}
// Notion de Vecteur
class Vector {
    constructor(coordinates) {
        this.coordinates = coordinates;
    }
    get x() {
        return this.coordinates[0];
    }
    set x(value) {
        this.coordinates[0] = value;
    }
    get y() {
        return this.coordinates[1];
    }
    set y(value) {
        this.coordinates[1] = value;
    }
    get z() {
        return this.coordinates[2];
    }
    set z(value) {
        this.coordinates[2] = value;
    }
    get w() {
        return this.coordinates[3];
    }
    set w(value) {
        this.coordinates[3] = value;
    }
    scalarMultiply(s) {
        return new Vector(this.coordinates.map(x => x * s));
    }
    // Addition de vecteurs
    add(v) {
        return new Vector(this.coordinates.map((value, index) => value + v.coordinates[index]));
    }
    // Soustraction de vecteurs
    subtract(v) {
        return new Vector(this.coordinates.map((value, index) => value - v.coordinates[index]));
    }
}
// Notion d'Espace Vectoriel
class VectorSpace {
    constructor(base_vectors) {
        this.base = base_vectors;
    }
    //propriété pour avoir la dimension d'un EV
    get dimension() {
        return this.base.length;
    }
    // Combinaison linéaire pour créer un vecteur avec la base
    linearCombination(coefficients) {
        let result = new Vector(new Array(this.base.length).fill(0));
        for (let i = 0; i < this.dimension; i++) {
            result = result.add(this.base[i].scalarMultiply(coefficients[i]));
        }
        return result;
    }
    // Changement de base
    changeBase(newBase) {
        const changeOfBaseMatrix = [];
        // Pour chaque vecteur de la nouvelle base
        for (const newBaseVector of newBase.base) {
            // Construire le vecteur b du système Ax = b
            const b = newBaseVector.coordinates;
            // Construire la matrice A du système Ax = b
            const A = this.base.map(u => u.coordinates);
            // Résoudre le système d'équations linéaires Ax = b pour trouver x
            const x = solveLinearSystem(A, b);
            // Ajouter x comme nouvelle colonne à la matrice de changement de base
            changeOfBaseMatrix.push(x);
        }
        return changeOfBaseMatrix;
    }
}
// Notion de Plan Euclidien
class EuclideanPlane extends AbstractPlane {
    constructor(point, normal) {
        super();
        this.point = point;
        this.normal = normal;
    }
    isIncidentWith(pt) {
        throw new Error("Method not implemented.");
    }
    // Convertir un point en vecteur
    pointToVector(p) {
        return new Vector(p.getCoordinates());
    }
    // Convertir un vecteur en point
    vectorToPoint(v) {
        return new Point2D(v.x, v.y);
    }
    // Équation du plan : ax + by + cz + d = 0
    equation() {
        return `${this.normal.x}x + ${this.normal.y}y + ${this.normal.z}z + d = 0`;
    }
}
// Notion de Point dans le Plan 2D
class Point2D extends AbstractPoint {
    constructor(x, y) {
        super();
        this.x = x;
        this.y = y;
    }
    getDimensions() {
        return 2;
    }
    getCoordinates() {
        return [this.x, this.y];
    }
    getVector() {
        return new Euclidean2DVector(this);
    }
}
// Vecteur sur le Plan Euclidien
class Euclidean2DVector extends Vector {
    constructor(point) {
        super(point.getCoordinates());
    }
    // Calculer la norme du vecteur
    norm() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    // Calculer le produit scalaire
    dotProduct(v) {
        return this.x * v.x + this.y * v.y;
    }
}
// Notion de Ligne dans le Plan 2D
class Line2D extends AbstractLine {
    constructor(point, direction) {
        super();
        this.point = point;
        this.direction = direction;
    }
    // Équation paramétrique de la ligne
    parametricEquation(t) {
        return new Point2D(this.point.x + t * this.direction.x, this.point.y + t * this.direction.y);
    }
    // Relation d'incidence avec un point 2D
    isIncidentWith(point) {
        // (à implémenter selon les besoins)
        return false;
    }
}
// Notion de Plan (en 3D)
class Plane {
    constructor(point, normal) {
        this.point = point;
        this.normal = normal;
    }
    // Équation du plan : ax + by + cz + d = 0
    equation() {
        return `${this.normal.x}x + ${this.normal.y}y + ${this.normal.z}z + d = 0`;
    }
}
// Notion de Triangle
class Triangle {
    constructor(vertex1, vertex2, vertex3) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
    }
    getVertexesFlat() {
        return [...this.vertex1.getCoordinates(), ...this.vertex2.getCoordinates(), ...this.vertex3.getCoordinates()];
    }
    getVertexes() {
        return [this.vertex1, this.vertex2, this.vertex3];
    }
}
// Notion de Quadrilatère
class Quadrilateral {
    constructor(vertex1, vertex2, vertex3, vertex4) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
        this.vertex4 = vertex4;
    }
}
// Notion de Polygone
class Polygon {
    constructor(vertices) {
        this.vertices = vertices;
    }
    // Nombre de côtés du polygone
    numberOfSides() {
        return this.vertices.length;
    }
}
