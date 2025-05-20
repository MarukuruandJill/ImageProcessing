
public class CvMain {

	static void imageProcessing1() {

		String filename1 = "itot.jpg";

		// String filename2 = "copy.jpg";
		// String[] filenames = { "copy.jpg", "binal.jpg", "gammma.jpg",
		// "smoothing1.jpg", "smoothing2.jpg", "sobel.jpg",
		// "laplacian.jpg", "sharp.jpg", "original.jpg" };
		// String[] filenames = { "harry.jpg", "cedric.jpg", "malfoy.jpg", "luna.jpg",
		// "hogwarts.jpg", "luna2.jpg" };
		// String[] Ravenclaws = { "tiara.jpg", "gold.jpg" };
		String[] filenames = { "newt.jpg", "newt2.jpg", "yellow.jpg", "cepia_yellow.jpg", "nihura.jpg",
				"old_books.jpg", "zu-oo.jpg", "hufflepuf.jpg" };

		// newt2.jpg 334*554
		// yellow.jpg 812*542
		// zu-oo.jpg 633*427
		// smaller_zu-oo.jpg 443*298

		MyImage image1, image2, image3;

		image1 = JpegFileReader.read("hufflepuf2.jpg");

		{
			// image2 = Negative.execute(image1);
			image2 = Binalization.execute(image1);
			// image2 = GammaCorrection.execute(image1);
			// image2 = SpaceFiltering.execute(image1);
			// image2 = Scale.execute(image1);
			// image2 = Rotation.execute(image1);
			// image3 = Cutting.execute(image1);
			// image2 = Inversion.execute(image1);
			// image2 = SepiaGammaCorrection.execute(image1);
			// image2 = Rotation2.execute(image1);
		}

		JpegFileWriter.write("hufflepuf2_binalized.jpg", image2);
		PrintImageSize.execute(image2);

	}

	static void imageProcessing2() {

		String filename1 = "newt2.jpg";
		String filename2 = "yellow.jpg";
		String filename3 = "nihura.jpg";
		String filename4 = "inverted_nihura.jpg";
		String filename5 = "backImage4.jpg";
		String filename6 = "hufflepuf2_binalized.jpg";
		String filename7 = "Demiguise.jpg";
		String filename8 = "backImage8.jpg";
		String filename9 = "Bowtruckle.jpg";
		String filename10 = "newt4.jpg";

		MyImage image1, image2, Newt, image0, backImage, backzuoo, backdemi;

		image1 = JpegFileReader.read(filename6);
		image2 = JpegFileReader.read(filename8);

		// image1 = JpegFileReader.read("itot.jpg");
		// image2 = JpegFileReader.read("ochatop.jpg");
		KMeans kmeans = new KMeans();
		kmeans.clustering(image1, 2);
		image0 = Chromakey.execute(image1, kmeans, 2);

		// image3 = VirtualStudio.execute(image1, image2, image0);
		// Newt = AlphaBlending.execute(image1, image2, image0);
		// image3 = Tiling.execute(image1, image2);
		// Newt = VirtualStudioLowerRight.execute(image1, image2, image0);
		// backImage = VirtualStudio.execute(image1, image2, image0);
		// backImage = VirtualStudioLowerLeft.execute(image1, image2, image0);
		// backImage = VirtualStudioRandom.execute(image1, image2, image0);
		// for (int i = 0; i < 5; i++) {
		// backImage = VirtualStudioRandom.execute(image1, backImage, image0);
		// }
		// Newt = VirtualStudioFreePosition.execute(image1, image2, image0);
		// backdemi = VirtualStudioLowerRight.execute(image1, image2, image0);
		// backImage = VirtualStudioLine.execute(image1, image2, image0);
		backImage = VirtualStudioLowerRight.execute(image1, image2, image0);
		JpegFileWriter.write("backImage9.jpg", backImage);
		// JpegFileWriter.write("hoge.jpg", hoge);

	}

	public static void main(String args[]) {

		// imageProcessing1();
		imageProcessing2();
	}
}
