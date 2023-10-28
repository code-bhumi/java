public class array1 {
    public static void main(String[] args) {
        int[][] mynumbers = {{2,4,6,8}, {10,12,14,16}};
        for (int i = 0; i < mynumbers.length; ++i) {
            for(int j = 0; j < mynumbers[i].length; ++j) {
                System.out.println(mynumbers[i][j]);
            }
        }
    }
}