package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    public static int caculate_row_size(int size,int row_i){
        if (row_i<size){
            return size+2*row_i;
        }
        return 3*size-2-2*(row_i-size);
    }

    public static int shift(int size,int row_i){
        if (row_i<size){
            return -row_i;
        }
        return -(size-1)+(row_i-size);
    }

    public static void draw(int size,int x,int y,TETile[][] world){
        int position_x=x;
        int position_y=y;
        for (int i=0;i<2*size;i++){
            int row_size=caculate_row_size(size,i);
            int shift = shift(size,i);
            int ture_x=position_x+shift;
            for (int j=0;j<row_size;j++){
                world[ture_x+j][position_y+i]=Tileset.WALL;

            }

        }
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(50, 50);

        TETile[][] world = new TETile[50][50];
        for (int x = 0; x < 50; x += 1) {
            for (int y = 0; y < 50; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        draw(4,25,25,world);

        ter.renderFrame(world);
    }
}
