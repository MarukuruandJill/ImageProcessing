import java.awt.*;

public class AlphaBlending {
    static MyImage execute(MyImage input1, MyImage input2, MyImage input0) {

        int width1 = input1.width;
        int width2 = input2.width;
        int height1 = input1.height;
        int height2 = input2.height;

        int width = (width1 > width2) ? width1 : width2;
        int height = (height1 > height2) ? height1 : height2;
        double alpha = 1.0;

        MyImage output = new MyImage(width, height);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean isProcessed = false;

                if (i < height1 && j < width1) {

                    Color color0 = input0.getColor(j, i);

                    if (color0.getRed() > 0) {

                        if (i > height2 && j > width2) {
                            Color color1 = input1.getColor(j, i);
                            output.setColor(j, i, color1);
                            isProcessed = true;
                        }

                        else {
                            Color color1 = input1.getColor(j, i);
                            Color color2 = input2.getColor(j, i);

                            int red = (int) (alpha * color1.getRed() + (1 - alpha) * color2.getRed());
                            int green = (int) (alpha * color1.getGreen() + (1 - alpha) * color2.getGreen());
                            int blue = (int) (alpha * color1.getBlue() + (1 - alpha) * color2.getBlue());

                            // 色成分を元に新しいColorオブジェクトを作成
                            Color color = new Color(red, green, blue);
                            output.setColor(j, i, color);
                            isProcessed = true;

                        }
                    }

                }

                if (i < height2 && j < width2) { // image2の代入
                    if (isProcessed == false) {

                        Color color2 = input2.getColor(j, i);
                        output.setColor(j, i, color2);
                    }
                }
            }
        }

        return output;

    }
}
