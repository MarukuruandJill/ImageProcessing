import java.awt.Color;

public class SepiaGammaCorrection {
    public static MyImage execute(MyImage input) {
        int width = input.width;
        int height = input.height;
        MyImage output = new MyImage(width, height);
        double gamma = 2.2;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // 元のピクセルの色を取得
                Color color = input.getColor(x, y);

                // ガンマ補正
                int red = (int) (Math.pow(color.getRed() / 255.0, 1.0 / gamma) * 255);
                int green = (int) (Math.pow(color.getGreen() / 255.0, 1.0 / gamma) * 255);
                int blue = (int) (Math.pow(color.getBlue() / 255.0, 1.0 / gamma) * 255);

                // セピア調変換
                int sepiaRed = (int) Math.min(0.393 * red + 0.769 * green + 0.189 * blue, 255);
                int sepiaGreen = (int) Math.min(0.349 * red + 0.686 * green + 0.168 * blue, 255);
                int sepiaBlue = (int) Math.min(0.272 * red + 0.534 * green + 0.131 * blue, 255);

                // 新しい色を設定
                output.setColor(x, y, new Color(sepiaRed, sepiaGreen, sepiaBlue));
            }
        }

        return output;
    }
}
