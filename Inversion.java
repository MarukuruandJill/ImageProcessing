import java.awt.Color;

public class Inversion {
    static double SCALEX = 1.0, SCALEY = 1.0;

    static MyImage execute(MyImage input) {
        int width1, height1, width2, height2, i, j;

        width1 = input.width;
        height1 = input.height;

        // 90度回転
        // width2 = (int) (input.height * SCALEX);
        // height2 = (int) (input.width * SCALEY);

        // 180度回転 回転ありなし共通
        // width2 = (int) (input.width * SCALEX);
        // height2 = (int) (input.height * SCALEY);

        // 反転
        width2 = (int) (input.width * SCALEX);
        height2 = (int) (input.height * SCALEY);

        MyImage output = new MyImage(width2, height2);

        for (i = 0; i < height2; i++) {
            for (j = 0; j < width2; j++) {
                double x1, y1, r, g, b;

                x1 = calcX(j, i, width1, height1);
                y1 = calcY(j, i, width1, height1);

                calcRGB(input, output, x1, y1, j, i);

            }
        }

        return output;

    }

    static double calcX(int x2, int y2, int width1, int height1) {
        double x = 0.0;

        // 90度回転
        // x = width1 - y2;

        // 180度回転
        // x = width1 - x2;

        // 180度回転 + 2倍に拡大
        // x = width1 - x2 / 2.0;

        // 反転
        x = width1 - x2;

        if (x < 0.0 || x > (double) width1) {
            System.out.println("EXIT! x=" + x);
            System.exit(-1);
        }

        return x;
    }

    static double calcY(int x2, int y2, int width1, int height1) {
        double y = 0.0;

        // 90度回転
        // y = x2;

        // 180度回転
        // y = height1 - y2;

        // 180度回転 + 2倍に拡大
        // y = height1 - y2 / 2.0;

        y = y2;

        if (y < 0.0 || y > (double) height1) {
            System.out.println("EXIT! y=" + y);
            System.exit(-1);
        }

        return y;
    }

    static void calcRGB(MyImage input, MyImage output, double x1, double y1, int x2, int y2) {

        int xx = (int) (x1 + 0.5);
        if (xx < 0)
            xx = 0;
        if (xx >= input.width)
            xx = input.width - 1;
        int yy = (int) (y1 + 0.5);
        if (yy < 0)
            yy = 0;
        if (yy >= input.height)
            yy = input.height - 1;

        Color color = input.getColor(xx, yy);
        int value = color.getRGB();
        output.setColor(x2, y2, color);

    }
}
