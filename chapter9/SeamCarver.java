
import java.awt.Color;
import edu.princeton.cs.algs4.Picture;

public class SeamCarver {
    
    private static final int R = 16;
    private static final int G = 8;
    private static final int B = 0;
    private int[] vSeam, hSeam;
    private int[][] c;
    private double[][] energy;
    private int W, H;
    
    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (picture == null)
            throw new NullPointerException();
        W = picture.width();
        H = picture.height();
        energy = new double[H][W];
        c = new int[H][W];
        for (int j = 0; j < H; j++) 
            for (int i = 0; i < W; i++) 
                c[j][i] = picture.get(i, j).getRGB();
        for (int j = 0; j < H; j++) 
            for (int i = 0; i < W; i++)
                if (i == 0 || i == W-1 || j == 0 || j == H-1) 
                    energy[j][i] = 1000;
                else 
                    calcEnergy(j, i);
        
    }
    
    private void calcEnergy(int row, int col) {
        if (row <= 0 || row >= H-1 || col <= 0 || col >= W-1)
            return;
        int rx, gx, bx, ry, gy, by;
        rx = getColor(row, col+1, R) - getColor(row, col-1, R);
        gx = getColor(row, col+1, G) - getColor(row, col-1, G);
        bx = getColor(row, col+1, B) - getColor(row, col-1, B);
        ry = getColor((row+1), col, R) - getColor((row-1), col, R);
        gy = getColor((row+1), col, G) - getColor((row-1), col, G);
        by = getColor((row+1), col, B) - getColor((row-1), col, B);
        energy[row][col] = Math.sqrt(rx*rx + gx*gx + bx*bx 
                                         + ry*ry + gy*gy + by*by);
    }
    
    private int getColor(int row, int col, int channel) {
        return c[row][col] >> channel & 255;
    }
    
    // current picture
    public Picture picture() {
        Picture pic = new Picture(W, H);
        for (int j = 0; j < H; j++)
            for (int i = 0; i < W; i++)
                pic.set(i, j, new Color(c[j][i], true));
        return pic;
    }
    
    // current picture
    public int width() {
        return W;
    }
    
    // height of current picture
    public int height() {
        return H;
    }
    
    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        if (x < 0 || x >= W || y < 0 || y >= H)
            throw new IndexOutOfBoundsException();
        return energy[y][x];
    }
    
    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        if (hSeam != null) return hSeam.clone();
        int[] seam = new int[W];
        if (W < 3) {
            for (int i = 1; i < W; i++)
                seam[i] = 0;
            hSeam = seam;
            return seam.clone();
        }
        
        double[] distTo = new double[H*W];
        int[] edgeTo = new int[H*W];
        for (int i = 0; i < H; i++)
            for (int j = 1; j < W; j++)
                distTo[i*W+j] = Double.POSITIVE_INFINITY;
        for (int i = 1; i < W; i++) { // Main Loop
            for (int j = 0; j < H; j++) {
                if (j > 0 && distTo[(j-1)*W+i] > energy[j-1][i] + distTo[j*W+i-1]) 
                { // Up
                    distTo[(j-1)*W+i] = energy[j-1][i] + distTo[j*W+i-1];
                    edgeTo[(j-1)*W+i] = j;
                }
                if (distTo[j*W+i] > energy[j][i] + distTo[j*W+i-1]) 
                { // Middle
                    distTo[j*W+i] = energy[j][i] + distTo[j*W+i-1];
                    edgeTo[j*W+i] = j;
                }
                if (j < H-1 && distTo[(j+1)*W+i] > energy[j+1][i] + distTo[j*W+i-1])
                { // Down
                    distTo[(j+1)*W+i] = energy[j+1][i] + distTo[j*W+i-1];
                    edgeTo[(j+1)*W+i] = j;
                }
            }
        }
        for (int i = 1; i < H-1; i++)
            if (distTo[seam[W-2]*W+W-2] > distTo[i*W+W-2])
                seam[W-2] = i;
        seam[W-1] = seam[W-2];
        for (int i = W-3; i >= 0; i--)
            seam[i] = edgeTo[seam[i+1]*W+i+1];
        
        hSeam = seam;
        return seam.clone();
    }
    
    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        if (vSeam != null) return vSeam.clone();
        int[] seam = new int[H];
        if (H < 3) {
            for (int i = 1; i < H; i++)
                seam[i] = 0;
            vSeam = seam;
            return seam.clone();
        }
        
        double[] distTo = new double[H*W];
        int[] edgeTo = new int[H*W];
        for (int j = 1; j < H; j++)
            for (int i = 0; i < W; i++)
                distTo[j*W+i] = Double.POSITIVE_INFINITY;
        for (int j = 1; j < H; j++) { // Main Loop
            for (int i = 0; i < W; i++) {
                if (i > 0 && distTo[j*W+i-1] > energy[j][i-1] + distTo[(j-1)*W+i]) 
                { // Left
                    distTo[j*W+i-1] = energy[j][i-1] + distTo[(j-1)*W+i];
                    edgeTo[j*W+i-1] = i;
                }
                if (distTo[j*W+i] > energy[j][i] + distTo[(j-1)*W+i]) 
                { // Middle
                    distTo[j*W+i] = energy[j][i] + distTo[(j-1)*W+i];
                    edgeTo[j*W+i] = i;
                }
                if (i < W-1 && distTo[j*W+i+1] > energy[j][i+1] + distTo[(j-1)*W+i])
                { // Right
                    distTo[j*W+i+1] = energy[j][i+1] + distTo[(j-1)*W+i];
                    edgeTo[j*W+i+1] = i;
                }
            }
        }
        for (int i = 1; i < W-1; i++)
            if (distTo[(H-2)*W+seam[H-2]] > distTo[(H-2)*W+i])
                seam[H-2] = i;
        seam[H-1] = seam[H-2];
        for (int i = H-3; i >= 0; i--)
            seam[i] = edgeTo[(i+1)*W+seam[i+1]];
            
        vSeam = seam;
        return seam.clone();
    }
    
    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {
        if (H <= 1)
            throw new IllegalArgumentException();
        if (seam == null)
            throw new NullPointerException();
        if (seam.length != W) 
            throw new IllegalArgumentException();
        for (int i = 0; i < W; i++) {
            if (i > 0 && Math.abs(seam[i] - seam[i-1]) > 1)
                throw new IllegalArgumentException();
            if (seam[i] < 0 || seam[i] >= H)
                throw new IllegalArgumentException();
        }
        
        for (int i = 0; i < W; i++) {
            if (seam[i] == H-1) {
                energy[H-2][i] = 1000;
                continue;
            }
            for (int j = seam[i]; j < H-1; j++) {
                if (j == 0) energy[j][i] = 1000;
                else energy[j][i] = energy[j+1][i];
                c[j][i] = c[j+1][i];
            }
        }
        H--;
        vSeam = null;
        hSeam = null;
        for (int i = 1; i < W-1; i++) {
            if (seam[i] > 1) calcEnergy(seam[i]-1, i); // Up
            if (seam[i] < H-1) calcEnergy(seam[i], i); // Down
            if (i > 1) calcEnergy(seam[i], i-1); // Left
            if (i < W-2) calcEnergy(seam[i], i+1); // Right
        }
    }
    
    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {
        if (W <= 1)
            throw new IllegalArgumentException();
        if (seam == null)
            throw new NullPointerException();
        if (seam.length != H) 
            throw new IllegalArgumentException();
        for (int i = 0; i < H; i++) {
            if (i > 0 && Math.abs(seam[i] - seam[i-1]) > 1)
                throw new IllegalArgumentException();
            if (seam[i] < 0 || seam[i] >= W)
                throw new IllegalArgumentException();
        }
        
        for (int i = 0; i < H; i++) {
            if (seam[i] == W-1) {
                energy[i][W-2] = 1000;
                continue;
            }
            System.arraycopy(energy[i], seam[i]+1, energy[i], seam[i], W-seam[i]-1);
            System.arraycopy(c[i], seam[i]+1, c[i], seam[i], W-seam[i]-1);
            if (seam[i] == 0) energy[i][0] = 1000;
        }
        W--;
        vSeam = null;
        hSeam = null;
        for (int i = 1; i < H-1; i++) {
            if (seam[i] > 1) calcEnergy(i, seam[i]-1); // Left
            if (seam[i] < W-1) calcEnergy(i, seam[i]); // Right
            if (i > 1) calcEnergy(i-1, seam[i]); // Up
            if (i < H-2) calcEnergy(i+1, seam[i]); // Down
        }
    }
    
    public static void main(String[] args) {
        new SeamCarver(new Picture("seamCarving\\12x10.png"));
    }
}
