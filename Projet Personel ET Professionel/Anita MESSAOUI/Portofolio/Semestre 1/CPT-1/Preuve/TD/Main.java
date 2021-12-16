public class Main {
    public static void main(String[] args){
        Voiture v1 = new Voiture("PIERRE", 3);
        Voiture v2 = new Voiture("NADAL", 4);
        Course c = new Course(v1, v2, 100);

        System.out.println(c.courseAller());
    }
}
