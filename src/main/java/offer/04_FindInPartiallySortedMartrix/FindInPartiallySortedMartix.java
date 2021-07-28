/**
 * TODO
 *
 * @author lisong@cestc.cn
 * @date 2021/7/7
 */
public class FindInPartiallySortedMartix {

    /*
     * 首先选取数组中右上角的数字。如果该数字等于要查找的数字，则查找过程结束；
     * 如果该数字大于要查找的数字，则剔除这个数字所在的列；
     * 如果该数字小于要查找的数字，则剔除这个数字所在的行。
     * 即，如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围中剔除一行或一列，
     * 每一步都可以缩小查找的范围，直到找到要查找的数字，或查找范围为空。
     */

    public boolean find(int[][] matrix, int number) {
        boolean found = false;
        if (matrix == null) {
            return found;
        }
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return found;
        }
        //从右上角开始遍历矩阵
        int row = 0;
        int column = matrix[0].length - 1;
        while (row <= matrix.length - 1 && column >= 0) {
            if (matrix[row][column] == number) {
                found = true;
                break;
            } else if (matrix[row][column] > number) {
                --column;
            } else {
                ++row;
            }
        }
        return found;
    }
}
