import java.awt.*;

public class Rotation2 {
    static double SCALEX = 1.0, SCALEY = 1.0;

    static MyImage execute(MyImage input) {
        int width1, height1, width2, height2, i, j;

        width1 = input.width;
        height1 = input.height;

        // 出力画像のサイズを入力画像の対角線長さに合わせる（回転後に収まるように）
        width2 = (int) (Math.sqrt(width1 * width1 + height1 * height1) * SCALEX);
        height2 = (int) (Math.sqrt(width1 * width1 + height1 * height1) * SCALEY);

        MyImage output = new MyImage(width2, height2);

        for (i = 0; i < height2; i++) {
            for (j = 0; j < width2; j++) {
                double x1, y1;

                x1 = calcX(j, i, width1, height1, width2, height2);
                y1 = calcY(j, i, width1, height1, width2, height2);

                calcRGB(input, output, x1, y1, j, i);
            }
        }

        return output;
    }

    static double calcX(int x2, int y2, int width1, int height1, int width2, int height2) {
        double angle = Math.toRadians(-30); // 時計回りなので負の角度
        double centerX1 = width1 / 2.0; // 元画像の中心
        double centerY1 = height1 / 2.0; // 元画像の中心
        double centerX2 = width2 / 2.0; // 出力画像の中心
        double centerY2 = height2 / 2.0; // 出力画像の中心

        double x = (x2 - centerX2) * Math.cos(angle) - (y2 - centerY2) * Math.sin(angle) + centerX1;

        if (x < 0.0 || x >= width1) {
            x = Math.max(0, Math.min(x, width1 - 1));
        }
        return x;
    }

    static double calcY(int x2, int y2, int width1, int height1, int width2, int height2) {
        double angle = Math.toRadians(-30); // 時計回りなので負の角度
        double centerX1 = width1 / 2.0; // 元画像の中心
        double centerY1 = height1 / 2.0; // 元画像の中心
        double centerX2 = width2 / 2.0; // 出力画像の中心
        double centerY2 = height2 / 2.0; // 出力画像の中心

        double y = (x2 - centerX2) * Math.sin(angle) + (y2 - centerY2) * Math.cos(angle) + centerY1;

        if (y < 0.0 || y >= height1) {
            y = Math.max(0, Math.min(y, height1 - 1));
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
        output.setColor(x2, y2, color);
    }
}
