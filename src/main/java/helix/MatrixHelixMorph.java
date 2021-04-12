package helix;

public class MatrixHelixMorph {

    /**
     * @param inMatrix
     * @return a matrix that is morphed into a helix version of inMatrix
     */
    public static int[][] helix( int[][] inMatrix) {
        if(inMatrix==null || inMatrix.length==0)
            return null;

        int rows = inMatrix.length,columns = 0;
        if (rows > 0){
            columns = inMatrix[0].length;
            for (int i = 1; i < inMatrix.length; i++) {
                if (columns != inMatrix[i].length){
                    return null;
                }
            }
        }
        int[][] expected = new int[rows][columns];
        int expectedRowIndex = 0, expectedColumnIndex = 0,inMatrixRowIndex = 0, inMatrixColumnIndex = 0;

        while(expectedRowIndex<rows && expectedColumnIndex<columns){
            for (int i = expectedColumnIndex; i < columns; ++i) {
                expected[expectedRowIndex][i] = inMatrix[inMatrixRowIndex][inMatrixColumnIndex];

                if (inMatrixColumnIndex == inMatrix[0].length - 1) {
                    inMatrixRowIndex++;
                    inMatrixColumnIndex = 0;
                } else {
                    inMatrixColumnIndex++;
                }
            }
            expectedRowIndex++;

            for (int i = expectedRowIndex; i < rows; ++i) {
                expected[i][columns - 1] = inMatrix[inMatrixRowIndex][inMatrixColumnIndex];

                if (inMatrixColumnIndex == inMatrix[0].length - 1) {
                    inMatrixRowIndex++;
                    inMatrixColumnIndex = 0;
                } else {
                    inMatrixColumnIndex++;
                }
            }
            columns--;

            if (expectedRowIndex < rows) {
                for (int i = columns - 1; i >= expectedColumnIndex; --i) {
                    expected[rows - 1][i] = inMatrix[inMatrixRowIndex][inMatrixColumnIndex];

                    if (inMatrixColumnIndex == inMatrix[0].length - 1) {
                        inMatrixRowIndex++;
                        inMatrixColumnIndex = 0;
                    } else {
                        inMatrixColumnIndex++;
                    }
                }
                rows--;

            }

            if (expectedColumnIndex < columns) {
                for (int i = rows - 1; i >= expectedRowIndex; --i) {
                    expected[i][expectedColumnIndex] = inMatrix[inMatrixRowIndex][inMatrixColumnIndex];

                    if (inMatrixColumnIndex == inMatrix[0].length - 1) {
                        inMatrixRowIndex++;
                        inMatrixColumnIndex = 0;
                    } else {
                        inMatrixColumnIndex++;
                    }
                }
                expectedColumnIndex++;

            }
        }

        for (int i = 0; i < expected.length; i++)
        {
            for (int j = 0; j < expected[0].length; j++)
            {
                System.out.print(expected[i][j]+ "\t");
            }

            System.out.println();
        }

        return expected;
        }
    }