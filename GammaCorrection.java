import java.awt.Color;

public class GammaCorrection {
    public static MyImage execute(MyImage input) {
        MyImage output = new MyImage(input.width, input.height);
        double cr = 2.0;
        double cg = 0.5;
        double cb = 2.0;

        for (int i = 0; i < input.height; i++) {
            for (int j = 0; j < input.width; j++) {

                Color color1 = input.getColor(j, i);

                double r = 255 * Math.pow((double) color1.getRed() / 255, 1 / cr);
                double g = 255 * Math.pow((double) color1.getGreen() / 255, 1 / cg);
                double b = 255 * Math.pow((double) color1.getBlue() / 255, 1 / cb);

                Color color2 = new Color((int) r, (int) g, (int) b);

                output.setColor(j, i, color2);
            }
        }

        return output;
    }
}
