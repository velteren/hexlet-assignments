package exercise;

// BEGIN
public class App {
    public static final void printSquare(Circle circle) {
        try {
            var result = (int) Math.ceil(circle.getSquare());
            System.out.println(result);
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END
