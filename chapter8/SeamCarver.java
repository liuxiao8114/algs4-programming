import java.awt.Color;
import edu.princeton.cs.algs4.AcyclicSP;
import edu.princeton.cs.algs4.Picture;

public class SeamCarver {
	private Picture picture;
	private AcyclicSP sp;
	private final static double BORDER = 1000.0;
	// create a seam carver object based on the given picture
	public SeamCarver(Picture picture) {
		this.picture = picture;
		for() {
			
		}
	}

	// current picture              
	public Picture picture() {
		return this.picture;
	}   

	// width of current picture                       
	public int width() {
		return this.picture.width();
	}

	// height of current picture                            
	public int height() {
		return this.picture.height();
	}   

	// energy of pixel at column x and row y                      
	public double energy(int x, int y) {
		if(y == 0) return BORDER;
		Color left = this.picture.get(x - 1, y);
		Color right = this.picture.get(x + 1, y);
		Color top = this.picture.get(x, y - 1);
		Color bottom = this.picture.get(x, y + 1);

		return square(right.getRed() - left.getRed()) + 
		square(right.getGreen() - left.getGreen()) + 
		square(right.getBlue() - left.getBlue()) +
		square(bottom.getRed() - top.getRed()) + 
		square(bottom.getGreen() - top.getGreen()) + 
		square(bottom.getBlue() - top.getBlue());
	}

	private double square(double x) {
		return x * x;
	}
	
	// sequence of indices for horizontal seam               
	public int[] findHorizontalSeam() {

	}   

	// sequence of indices for vertical seam            
	public int[] findVerticalSeam() {

	}         

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	} 
}