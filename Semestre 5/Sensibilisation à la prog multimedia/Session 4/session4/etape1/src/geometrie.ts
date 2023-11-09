function solveLinearSystem(A: number[][], b: number[]): number[] {
  const n = A.length;
  let AugmentedMatrix: number[][] = [];

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
abstract class AbstractPoint {
    abstract getCoordinates(): number[];
}

// Notion de Ligne Abstraite
abstract class AbstractLine {
    // Relation d'incidence avec un point abstrait
    abstract isIncidentWith(point: AbstractPoint): boolean;
}

// Notion de Plan Abstrait
abstract class AbstractPlane {
    // Relation d'incidence avec une ligne abstraite
    abstract isIncidentWith(line: AbstractLine): boolean;
    // Relation d'incidence avec une ligne abstraite
    abstract isIncidentWith(pt: AbstractPoint): boolean;
}

// Interface pour une transformation géométrique
interface GeometricTransformation {
    transform(point: AbstractPoint): AbstractPoint;
}


// Notion de Vecteur
class Vector {
    constructor(public coordinates: number[]) { }

    get x(): number {
        return this.coordinates[0];
    }
    set x(value: number) {
        this.coordinates[0] = value;
    }
    get y(): number {
        return this.coordinates[1];
    }
    set y(value: number) {
        this.coordinates[1] = value;
    }
    get z(): number {
        return this.coordinates[2];
    }
    set z(value: number) {
        this.coordinates[2] = value;
    }
    get w(): number {
        return this.coordinates[3];
    }
    set w(value: number) {
        this.coordinates[3] = value;
    }
    scalarMultiply(s: number): Vector {
        return new Vector(this.coordinates.map(x => x * s));
    }
    // Addition de vecteurs
    add(v: Vector): Vector {
        return new Vector(this.coordinates.map((value, index) => value + v.coordinates[index]));
    }

    // Soustraction de vecteurs
    subtract(v: Vector): Vector {
        return new Vector(this.coordinates.map((value, index) => value - v.coordinates[index]));
    }

}

// Notion d'Espace Vectoriel
class VectorSpace {
    base: Vector[];

    constructor(base_vectors: Vector[]) {
        this.base = base_vectors;
    }
    //propriété pour avoir la dimension d'un EV
    get dimension(): number {
        return this.base.length;
    }
    // Combinaison linéaire pour créer un vecteur avec la base
    linearCombination(coefficients: number[]): Vector {
        let result = new Vector(new Array(this.base.length).fill(0));
        for (let i = 0; i < this.dimension; i++) {
            result = result.add(this.base[i].scalarMultiply(coefficients[i]));
        }
        return result;
    }

    // Changement de base
    changeBase(newBase: VectorSpace): number[][] {
        const changeOfBaseMatrix: number[][] = [];

        // Pour chaque vecteur de la nouvelle base
        for (const newBaseVector of newBase.base) {
            // Construire le vecteur b du système Ax = b
            const b: number[] = newBaseVector.coordinates;

            // Construire la matrice A du système Ax = b
            const A: number[][] = this.base.map(u => u.coordinates);

            // Résoudre le système d'équations linéaires Ax = b pour trouver x
            const x: number[] = solveLinearSystem(A, b);

            // Ajouter x comme nouvelle colonne à la matrice de changement de base
            changeOfBaseMatrix.push(x);
        }

        return changeOfBaseMatrix;
    }
}




// Notion de Plan Euclidien
class EuclideanPlane extends AbstractPlane {
    isIncidentWith(line: AbstractLine): boolean;
    isIncidentWith(pt: AbstractPoint): boolean;

    isIncidentWith(pt: unknown): boolean {
        throw new Error("Method not implemented.");
    }

    constructor(public point: Point2D, public normal: Vector) {
        super();
    }

    // Convertir un point en vecteur
    pointToVector(p: AbstractPoint): Vector {
        return new Vector(p.getCoordinates());
    }

    // Convertir un vecteur en point
    vectorToPoint(v: Vector): Point2D {
        return new Point2D(v.x, v.y);
    }

    // Équation du plan : ax + by + cz + d = 0
    equation(): string {
        return `${this.normal.x}x + ${this.normal.y}y + ${this.normal.z}z + d = 0`;
    }

}


// Notion de Point dans le Plan 2D
class Point2D extends AbstractPoint {
    constructor(public x: number, public y: number) {
        super();
    }
    getDimensions(): number {
        return 2;
    }
    getCoordinates(): number[] {
        return [this.x, this.y];
    }
    getVector() : Euclidean2DVector
    {
        return new Euclidean2DVector(this);
    }
}

// Vecteur sur le Plan Euclidien
class Euclidean2DVector extends Vector {
    
    constructor(point: Point2D) 
    {
        super(point.getCoordinates());
    }
    // Calculer la norme du vecteur
    norm(): number {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    // Calculer le produit scalaire
    dotProduct(v: Euclidean2DVector): number {
        return this.x * v.x + this.y * v.y;
    }
}


// Notion de Ligne dans le Plan 2D
class Line2D extends AbstractLine {
    constructor(public point: Point2D, public direction: Vector) {
        super();
    }

    // Équation paramétrique de la ligne
    parametricEquation(t: number): Point2D {
        return new Point2D(
            this.point.x + t * this.direction.x,
            this.point.y + t * this.direction.y
        );
    }

    // Relation d'incidence avec un point 2D
    isIncidentWith(point: Point2D): boolean {
        // (à implémenter selon les besoins)
        return false;
    }
}




// Notion de Plan (en 3D)
class Plane {
    constructor(public point: AbstractPoint, public normal: Vector) { }

    // Équation du plan : ax + by + cz + d = 0
    equation(): string {
        return `${this.normal.x}x + ${this.normal.y}y + ${this.normal.z}z + d = 0`;
    }
}

interface GeometricObject {
    getVertexesFlat() : number [];
    getVertexes() : AbstractPoint [];
} 

// Notion de Triangle
class Triangle implements GeometricObject{
    constructor(public vertex1: AbstractPoint, public vertex2: AbstractPoint, public vertex3: AbstractPoint) { }
    
    getVertexesFlat(): number[] {
        return [...this.vertex1.getCoordinates(),...this.vertex2.getCoordinates(),...this.vertex3.getCoordinates()];
    }

    getVertexes():AbstractPoint[]{
        return [this.vertex1,this.vertex2,this.vertex3];
    }
}

// Notion de Quadrilatère
class Quadrilateral {
    constructor(public vertex1: AbstractPoint, public vertex2: AbstractPoint, public vertex3: AbstractPoint, public vertex4: AbstractPoint) { }
}

// Notion de Polygone
class Polygon {
    constructor(public vertices: AbstractPoint[]) { }

    // Nombre de côtés du polygone
    numberOfSides(): number {
        return this.vertices.length;
    }
}
