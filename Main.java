import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        short[] a = new short[8];
        short tmp = 2;
        for (int i = 0; i < 8; i++) {
            a[i] = tmp;
            tmp += 2;
        }
        float[] x = new float[14];
        for (int i = 0; i < 14; i++) {
            x[i] = (float) Rand(Math.random());
        }
        double[][] arr = new double[8][14];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 14; j++) {
                if (a[i] == 14) {
                    arr[i][j] = Math.pow(Math.cbrt(Math.cbrt(x[j])) / 6, 3);
                } else if (a[i] == 4 || a[i] == 6 || a[i] == 10) {
                    arr[i][j] = Math.pow(Math.E, Math.cbrt(x[j]) / (0.25 + Math.pow((x[j] - 1) / x[j], 3)));
                } else {
                    arr[i][j] = Math.cbrt(Math.sin(x[j] / (1 - x[j])));
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 14; j++) {
                System.out.printf("%.3f", arr[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }

    }

    public static double Rand(double r) {
        return (r - 0.5) * 18;
    }

}
