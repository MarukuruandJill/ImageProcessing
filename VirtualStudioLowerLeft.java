import java.awt.Color;

public class VirtualStudioLowerLeft {
    static MyImage execute(MyImage input1, MyImage input2, MyImage input0) {

        int width1 = input1.width;
        int height1 = input1.height;

        int width2 = input2.width;
        int height2 = input2.height;

        // 出力画像の幅と高さは input2 と同じ
        int width = width2;
        int height = height2;

        MyImage output = new MyImage(width, height);

        // 合成する位置 (左下に配置する)
        int positionX = 300;
        int positionY = height2 - height1;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean isProcessed = false;

                // 左下に input1 を合成
                if (i >= positionY && i < positionY + height1 && j >= positionX && j < positionX + width1) {
                    // input0 のマスクを取得
                    Color maskColor = input0.getColor(j - positionX, i - positionY);

                    // マスクの赤成分が0より大きい場合のみ合成
                    if (maskColor.getRed() > 0) {
                        Color color1 = input1.getColor(j - positionX, i - positionY);
                        output.setColor(j, i, color1);
                        isProcessed = true;
                    }
                }

                // isProcessed が false の場合、元の input2 のピクセルをコピー
                if (!isProcessed) {
                    if (i < height2 && j < width2) {
                        Color color2 = input2.getColor(j, i);
                        output.setColor(j, i, color2);
                    }
                }
            }
        }

        return output;
    }
}
