import java.awt.*;

public class Tiling {
    static MyImage execute(MyImage input1, MyImage input2) {

        int width1 = input1.width;
        int width2 = input2.width;
        int height1 = input1.height;
        int height2 = input2.height;

        // int width = (width1 > width2) ? width1 : width2;
        // int height = (height1 > height2) ? height1 : height2;
        int width = width1 + width2;
        int height = (height1 > height2) ? height1 : height2;

        MyImage output = new MyImage(width, height);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean isProcessed = false;

                if (i < height1 && j < width1) {
                    Color color1 = input1.getColor(j, i);
                    output.setColor(j, i, color1);

                    isProcessed = true;
                }

                else if (i < height2 && width1 <= j && j < width) {
                    if (isProcessed == false) {
                        Color color2 = input2.getColor(j - width1, i);
                        output.setColor(j, i, color2);
                    }
                }

                else {
                    if (isProcessed == false) {
                        Color color3 = new Color(0, 0, 0);
                        output.setColor(j, i, color3);
                    }
                }
            }
        }

        return output;

    }
}
