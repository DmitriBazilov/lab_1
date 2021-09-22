import java.lang.Math;

public class Main {

    final static int aLength = 8;
    final static short aStart = 2;
    final static short aFinish = 16;
    final static int xLength = 14;
    final static int arrLength = 14;
    final static int arrHeight = 8;

    public static void main(String[] args) {

        short[] a = new short[aLength];
        initFirstArray(a);

        float[] x = new float[xLength];
        initSecondArray(x);

        double[][] arr = new double[arrHeight][arrLength];

        for (int i = 0; i < arrHeight; i++) {
            for (int j = 0; j < arrLength; j++) {
                if (a[i] == 14) {
                    arr[i][j] = formula1(x[j]);
                } else if (a[i] == 2 || a[i] == 8 || a[i] == 12 || a[i] == 16) {
                    arr[i][j] = formula2(x[j]);
                } else {
                    arr[i][j] = formula3(x[j]);
                }
            }
        }

        printAnswer(arr);

    }


    // Инициализация массива a
    public static void initFirstArray(short[] arr) {
        int idx = 0;
        for (short i = aStart; i < aFinish; i += 2) {
            arr[idx] = i;
            idx++;
        }
    }

    // Инициализация массива a
    public static void initSecondArray(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) rand(Math.random());
        }
    } 

    // Формула для a[i] = 14
    public static double formula1(float x) {
        return Math.pow(Math.cbrt(Math.cbrt(x)) / 6, 3);
    }

    // Формула для a[i] = 2, 8, 12, 16
    public static double formula2(float x) {
        return Math.cbrt(Math.sin(x / (1 - x)));
    }

    // Формула для остальных значений a[i]
    public static double formula3(float x) {
        return Math.pow(Math.E, Math.cbrt(x) / (0.25 + Math.pow((x - 1) / x, 3)));
    }

    // Метод вывода двумерного массива arr
    public static void printAnswer(double[][] ansArr) {
        for (int i = 0; i < arrHeight; i++) {
            for (int j = 0; j < arrLength; j++) {
                System.out.printf("%6.3f ", ansArr[i][j]);
            }
            System.out.println();
        }
    }

    // Метод расширящий промежуток рандомного числа с [0, 1] до [-9, 9];
    public static double rand(double randomDouble) {
        return (randomDouble - 0.5) * 18;
    }

}