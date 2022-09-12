import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int getFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static void permutationsWithoutRepetitions(int n){
        System.out.println(getFactorial(n));
    }

    public static void permutationsWithRepetitions(int n, int[] rep ){
        if (rep.length > n){
            System.out.println("Введены некорректные данные.");
        } else {
            double numerator = getFactorial(n);
            double denominator = 1;
            for (int i = 0; i < rep.length; i++) {
                denominator *= getFactorial(rep[i]);
            }
            System.out.println(numerator / denominator);
        }
    }

    public static void combinationsWithoutRepetitions(int n, int m ){
        double numerator = getFactorial(n);
        double denominator = getFactorial(m) * getFactorial(n - m);
        System.out.println(numerator/denominator);
    }

    public static void combinationsWithRepetitions(int n, int m){
        double numerator = getFactorial(m + n - 1);
        double denominator = getFactorial(n - 1) * getFactorial(m);
        System.out.println(numerator/denominator);
    }

    public static void placementsWithoutRepetitions(int n, int m ){
        if (m > n){
            System.out.println("Введены некорректные данные.");
        }else {
            double numerator = getFactorial(n);
            double denominator = getFactorial(n - m);
            System.out.println("Ответ: " + numerator/denominator);
        }

    }

    public static void placementsWithRepetitions(double n, double m ){

        System.out.println("Ответ: " + Math.pow(n,m));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                """
                        Что Вы хотите подсчитать? Выберите номер ответа.\s
                        1. Количество перестановок;\s
                        2. Количество сочетаний;\s
                        3. Количество размещений;""" );

        String answer1 = scanner.nextLine();

        System.out.println(
                """
                        Вы хотите выполнить подсчет с повторениями или без?\s
                        1. С повторениями;\s
                        2. Без повторений;""");

        String answer2 = scanner.nextLine();

        if(answer1.equals("1")){
            if(answer2.equals("1")){
                System.out.println(
                        """
                            Вы выбрали подсчет перестановок с повторениями.
                            Введите число n.""");
                int n = scanner.nextInt();
                System.out.println("Введите кол-во повторений каждого элемнта через запятую без пробелов.");
                String[] num = scanner.next().split(",");
                int[] rep = Arrays.stream(num).mapToInt(Integer::parseInt).toArray();
                permutationsWithRepetitions(n,rep);
            } else {
                System.out.println(
                        """
                            Вы выбрали подсчет перестановок без повторений.
                            Введте число n.""");
                int n = scanner.nextInt();
                permutationsWithoutRepetitions(n);
            }
        } else if (answer1.equals("2")) {
            if (answer2.equals("1")) {
                System.out.println(
                        """
                            Вы выбрали подсчет сочетаний с повторениями.
                            Введите <n,m> - выборку. Каждое число вводится с новой строки по порядку соответсвенно.""");
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                combinationsWithRepetitions(n, m);
            } else {
                System.out.println(
                        """
                            Вы выбрали подсчет сочетаний без повторений.\s
                            Введите <n,m> - выборку. Каждое число вводится с новой строки по порядку соответсвенно.""");
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                combinationsWithoutRepetitions(n, m);
            }
        } else {
            if (answer2.equals("1")) {
                System.out.println(
                        """
                            Вы выбрали подсчет размещений с повторениями.\s
                            Введите <n,m> - выборку. Каждое число вводится с новой строки по порядку соответсвенно.""");
                double n = scanner.nextDouble();
                double m = scanner.nextDouble();
                placementsWithRepetitions(n,m);
            } else {
                System.out.println(
                    """
                        Вы выбрали подсчет размещений без повторений.\s
                        Введите <n,m> - выборку. Каждое число вводится с новой строки по порядку соответсвенно.""");
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                placementsWithoutRepetitions( n, m);
            }
        }
    }
}
