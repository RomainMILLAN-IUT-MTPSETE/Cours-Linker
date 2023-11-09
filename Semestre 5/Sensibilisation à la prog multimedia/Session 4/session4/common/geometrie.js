"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __spreadArray = (this && this.__spreadArray) || function (to, from, pack) {
    if (pack || arguments.length === 2) for (var i = 0, l = from.length, ar; i < l; i++) {
        if (ar || !(i in from)) {
            if (!ar) ar = Array.prototype.slice.call(from, 0, i);
            ar[i] = from[i];
        }
    }
    return to.concat(ar || Array.prototype.slice.call(from));
};
exports.__esModule = true;
exports.Polygon = exports.Quadrilateral = exports.Triangle = exports.Plane = exports.Line2D = exports.Euclidean2DVector = exports.Point2D = exports.EuclideanPlane = exports.VectorSpace = exports.Vector = exports.AbstractPlane = exports.AbstractPoint = exports.solveLinearSystem = void 0;
function solveLinearSystem(A, b) {
    var n = A.length;
    var AugmentedMatrix = [];
    // Créer la matrice augmentée [A|b]
    for (var i = 0; i < n; i++) {
        AugmentedMatrix[i] = __spreadArray(__spreadArray([], A[i], true), [b[i]], false);
    }
    // Appliquer la méthode de Gauss-Jordan
    for (var i = 0; i < n; i++) {
        // Normaliser la ligne du pivot
        var factor = AugmentedMatrix[i][i];
        for (var j = 0; j < n + 1; j++) {
            AugmentedMatrix[i][j] /= factor;
        }
        // Éliminer les autres lignes
        for (var u = 0; u < n; u++) {
            if (u !== i) {
                var factor_1 = AugmentedMatrix[u][i];
                for (var j = 0; j < n + 1; j++) {
                    AugmentedMatrix[u][j] -= factor_1 * AugmentedMatrix[i][j];
                }
            }
        }
    }
    // Extraire la solution
    var x = new Array(n).fill(0);
    for (var i = 0; i < n; i++) {
        x[i] = AugmentedMatrix[i][n];
    }
    return x;
}
exports.solveLinearSystem = solveLinearSystem;
// Notion de Point Abstrait
var AbstractPoint = /** @class */ (function () {
    function AbstractPoint() {
    }
    return AbstractPoint;
}());
exports.AbstractPoint = AbstractPoint;
// Notion de Ligne Abstraite
var AbstractLine = /** @class */ (function () {
    function AbstractLine() {
    }
    return AbstractLine;
}());
// Notion de Plan Abstrait
var AbstractPlane = /** @class */ (function () {
    function AbstractPlane() {
    }
    return AbstractPlane;
}());
exports.AbstractPlane = AbstractPlane;
// Notion de Vecteur
var Vector = /** @class */ (function () {
    function Vector(coordinates) {
        this.coordinates = coordinates;
    }
    Object.defineProperty(Vector.prototype, "x", {
        get: function () {
            return this.coordinates[0];
        },
        set: function (value) {
            this.coordinates[0] = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Vector.prototype, "y", {
        get: function () {
            return this.coordinates[1];
        },
        set: function (value) {
            this.coordinates[1] = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Vector.prototype, "z", {
        get: function () {
            return this.coordinates[2];
        },
        set: function (value) {
            this.coordinates[2] = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Vector.prototype, "w", {
        get: function () {
            return this.coordinates[3];
        },
        set: function (value) {
            this.coordinates[3] = value;
        },
        enumerable: false,
        configurable: true
    });
    Vector.prototype.scalarMultiply = function (s) {
        return new Vector(this.coordinates.map(function (x) { return x * s; }));
    };
    // Addition de vecteurs
    Vector.prototype.add = function (v) {
        return new Vector(this.coordinates.map(function (value, index) { return value + v.coordinates[index]; }));
    };
    // Soustraction de vecteurs
    Vector.prototype.subtract = function (v) {
        return new Vector(this.coordinates.map(function (value, index) { return value - v.coordinates[index]; }));
    };
    return Vector;
}());
exports.Vector = Vector;
// Notion d'Espace Vectoriel
var VectorSpace = /** @class */ (function () {
    function VectorSpace(base_vectors) {
        this.base = base_vectors;
    }
    Object.defineProperty(VectorSpace.prototype, "dimension", {
        //propriété pour avoir la dimension d'un EV
        get: function () {
            return this.base.length;
        },
        enumerable: false,
        configurable: true
    });
    // Combinaison linéaire pour créer un vecteur avec la base
    VectorSpace.prototype.linearCombination = function (coefficients) {
        var result = new Vector(new Array(this.base.length).fill(0));
        for (var i = 0; i < this.dimension; i++) {
            result = result.add(this.base[i].scalarMultiply(coefficients[i]));
        }
        return result;
    };
    // Changement de base
    VectorSpace.prototype.changeBase = function (newBase) {
        var changeOfBaseMatrix = [];
        // Pour chaque vecteur de la nouvelle base
        for (var _i = 0, _a = newBase.base; _i < _a.length; _i++) {
            var newBaseVector = _a[_i];
            // Construire le vecteur b du système Ax = b
            var b = newBaseVector.coordinates;
            // Construire la matrice A du système Ax = b
            var A = this.base.map(function (u) { return u.coordinates; });
            // Résoudre le système d'équations linéaires Ax = b pour trouver x
            var x = solveLinearSystem(A, b);
            // Ajouter x comme nouvelle colonne à la matrice de changement de base
            changeOfBaseMatrix.push(x);
        }
        return changeOfBaseMatrix;
    };
    return VectorSpace;
}());
exports.VectorSpace = VectorSpace;
// Notion de Plan Euclidien
var EuclideanPlane = /** @class */ (function (_super) {
    __extends(EuclideanPlane, _super);
    function EuclideanPlane(point, normal) {
        var _this = _super.call(this) || this;
        _this.point = point;
        _this.normal = normal;
        return _this;
    }
    EuclideanPlane.prototype.isIncidentWith = function (pt) {
        throw new Error("Method not implemented.");
    };
    // Convertir un point en vecteur
    EuclideanPlane.prototype.pointToVector = function (p) {
        return new Vector(p.getCoordinates());
    };
    // Convertir un vecteur en point
    EuclideanPlane.prototype.vectorToPoint = function (v) {
        return new Point2D(v.x, v.y);
    };
    // Équation du plan : ax + by + cz + d = 0
    EuclideanPlane.prototype.equation = function () {
        return "".concat(this.normal.x, "x + ").concat(this.normal.y, "y + ").concat(this.normal.z, "z + d = 0");
    };
    return EuclideanPlane;
}(AbstractPlane));
exports.EuclideanPlane = EuclideanPlane;
// Notion de Point dans le Plan 2D
var Point2D = /** @class */ (function (_super) {
    __extends(Point2D, _super);
    function Point2D(x, y) {
        var _this = _super.call(this) || this;
        _this.x = x;
        _this.y = y;
        return _this;
    }
    Point2D.prototype.getDimensions = function () {
        return 2;
    };
    Point2D.prototype.getCoordinates = function () {
        return [this.x, this.y];
    };
    Point2D.prototype.getVector = function () {
        return new Euclidean2DVector(this);
    };
    return Point2D;
}(AbstractPoint));
exports.Point2D = Point2D;
// Vecteur sur le Plan Euclidien
var Euclidean2DVector = /** @class */ (function (_super) {
    __extends(Euclidean2DVector, _super);
    function Euclidean2DVector(point) {
        return _super.call(this, point.getCoordinates()) || this;
    }
    // Calculer la norme du vecteur
    Euclidean2DVector.prototype.norm = function () {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    };
    // Calculer le produit scalaire
    Euclidean2DVector.prototype.dotProduct = function (v) {
        return this.x * v.x + this.y * v.y;
    };
    return Euclidean2DVector;
}(Vector));
exports.Euclidean2DVector = Euclidean2DVector;
// Notion de Ligne dans le Plan 2D
var Line2D = /** @class */ (function (_super) {
    __extends(Line2D, _super);
    function Line2D(point, direction) {
        var _this = _super.call(this) || this;
        _this.point = point;
        _this.direction = direction;
        return _this;
    }
    // Équation paramétrique de la ligne
    Line2D.prototype.parametricEquation = function (t) {
        return new Point2D(this.point.x + t * this.direction.x, this.point.y + t * this.direction.y);
    };
    // Relation d'incidence avec un point 2D
    Line2D.prototype.isIncidentWith = function (point) {
        // (à implémenter selon les besoins)
        return false;
    };
    return Line2D;
}(AbstractLine));
exports.Line2D = Line2D;
// Notion de Plan (en 3D)
var Plane = /** @class */ (function () {
    function Plane(point, normal) {
        this.point = point;
        this.normal = normal;
    }
    // Équation du plan : ax + by + cz + d = 0
    Plane.prototype.equation = function () {
        return "".concat(this.normal.x, "x + ").concat(this.normal.y, "y + ").concat(this.normal.z, "z + d = 0");
    };
    return Plane;
}());
exports.Plane = Plane;
// Notion de Triangle
var Triangle = /** @class */ (function () {
    function Triangle(vertex1, vertex2, vertex3) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
    }
    return Triangle;
}());
exports.Triangle = Triangle;
// Notion de Quadrilatère
var Quadrilateral = /** @class */ (function () {
    function Quadrilateral(vertex1, vertex2, vertex3, vertex4) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
        this.vertex4 = vertex4;
    }
    return Quadrilateral;
}());
exports.Quadrilateral = Quadrilateral;
// Notion de Polygone
var Polygon = /** @class */ (function () {
    function Polygon(vertices) {
        this.vertices = vertices;
    }
    // Nombre de côtés du polygone
    Polygon.prototype.numberOfSides = function () {
        return this.vertices.length;
    };
    return Polygon;
}());
exports.Polygon = Polygon;
