public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        int row = mat.length,col=mat[0].length;
        if(r*c != row*col) return mat;
        int[][] res = new int[r][c];
        for(int i=0;i<r*c;i++){
            res[i/c][i%c] = mat[i/col][i%col];
        }
        return res;
    }
