import java.util.Arrays;

/**
 * 矩阵中的路径
 *
 * @author lisong@cestc.cn
 * @date 2021/7/28
 */
public class StringPathInMatrix {

    /**
     * 深度优先搜索(DFS)+剪枝
     * 深度优先搜索：暴力法遍历矩阵中所有字符串可能性。DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推
     * 剪枝：在搜索中，遇到这条路不可能和目标字符串匹配成功的情况（例如：此矩阵元素和目标字符不同、此元素已被访问），则应立即返回，称之为可行性剪枝
     * @param board
     * @param word
     * @return boolean
     * @author lisong@cestc.cn
     * @date 2021/07/28 17:02:42
     * @throws
     */
    public boolean hasPath(char[][] board,String word){
        if (board == null || board.length < 1 || board[0].length < 1 || word == null){
            return false;
        }
        char[] words = word.toCharArray();
        int rows = board.length;
        int columns = board[0].length;
        for (int i = 0;i < rows; i++){
            for (int j = 0;j < columns; j++){
                if (dfs(board,words,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 终止条件：
     * 1、返回 false ：
     *  (1) 行或列索引越界
     *  (2) 当前矩阵元素与目标字符不同
     *  (3) 当前矩阵元素已访问过
     * 2、返回 true ：
     *  k = len(word) - 1 ，即字符串 word 已全部匹配
     * @param board 矩阵
     * @param words 目标数组
     * @param i 矩阵行坐标
     * @param j 矩阵列坐标
     * @param k 目标字符串匹配位置
     * @return boolean
     * @author lisong@cestc.cn
     * @date 2021/07/28 17:18:35
     */
    private boolean dfs(char[][] board,char[] words,int i,int j,int k){
        if (i >= board.length || i <0 || j >= board[0].length || j < 0 || board[i][j] != words[k]){
            return false;
        }
        if (k == words.length - 1){
            return true;
        }
        //标记当前矩阵元素：将board[i][j] 修改为空字符 '' ，代表此元素已访问过，防止之后搜索时重复访问
        board[i][j] = '\0';
        boolean result = dfs(board, words, i+1, j, k+1) ||
                dfs(board, words, i, j+1, k+1) ||
                dfs(board, words, i-1, j, k+1) ||
                dfs(board, words, i, j-1, k+1);
        //原当前矩阵元素：将board[i][j]元素还原至初始值，即 word[k]
        board[i][j] = words[k];

        return result;
    }

}
