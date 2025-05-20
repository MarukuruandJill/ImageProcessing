import java.awt.Color;

public class VirtualStudioFreePosition {
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

        int positionX = 200;
        int positionY = 0;

        for (int k = 0; k < 15; k++) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    boolean isProcessed = false;

                    if (i >= positionY && i < positionY + height1 && j >= positionX && j < positionX + width1) {

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
            positionX += 50;
        }

        return output;
    }
}
