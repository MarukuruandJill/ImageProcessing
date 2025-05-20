import java.awt.*;
import java.util.Random;

public class VirtualStudioRandom {
    static MyImage execute(MyImage input1, MyImage input2, MyImage input0) {

        int width1 = input1.width;
        int width2 = input2.width;
        int height1 = input1.height;
        int height2 = input2.height;

        int width = (width1 > width2) ? width1 : width2;
        int height = (height1 > height2) ? height1 : height2;

        MyImage output = new MyImage(width, height);

        System.out.println("width " + width); // width 812
        System.out.println("height " + height); // height 554

        Random randx = new Random();
        // Random randy = new Random();
        int randomX = randx.nextInt(550) + 50;
        // int randomY = randy.nextInt(20);

        int positionX = randomX;
        int positionY = -20;

        // if ((height / 4 < i) && (i < height1 + height / 4) && (width / 4 < j) && (j <
        // width1 + width / 4))
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean isProcessed = false;

                if (positionY < i && i < positionY + height1 && positionX < j && j < width1 + positionX) {

                    Color color0 = input0.getColor(j - positionX, i - positionY);
                    if (color0.getRed() > 0) {

                        Color color1 = input1.getColor(j - positionX, i - positionY);
                        output.setColor(j, i, color1);

                        isProcessed = true;
                    }

                }

                if (i < height2 && j < width2) {
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
