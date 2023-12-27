public class MaxElementInMatrixThread extends Thread{
    private int[][] matrix;

    private int maxElem;

    public MaxElementInMatrixThread(int[][] matrix){
        this.matrix = matrix;
    }

    @Override
    public void run() {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                maxElem = Math.max(maxElem, matrix[i][j]);
            }
        }
    }

    public int GetMaxElem(){
        return maxElem;
    }
}
