/**
 * 斐波那契数列
 *
 * @author lisong@cestc.cn
 * @date 2021/7/23
 */
public class Fibonacci {

    /**
     * 递归实现斐波那契数列，结果取模
     * @param n
     * @return int
     * @author lisong@cestc.cn
     * @date 2021/07/23 13:54:53
     * @throws
     */
    public int fibonacciSolution(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int mod=1000000007;
        return fibonacciSolution(n-1)%mod+fibonacciSolution(n-2)%mod;
    }

    /**
     * 从下往上计算，时间复杂度O(n)
     * @param n
     * @return int
     * @author lisong@cestc.cn
     * @date 2021/07/23 14:17:47
     * @throws
     */
    public int fibonacciSolution1(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int fibNminsOne = 1;
        int fibNminsTwo = 0;
        int fibN = 0;
        for (int i = 2;i <= n;++i){
            fibN = (fibNminsOne + fibNminsTwo)%1000000007;
            fibNminsTwo = fibNminsOne;
            fibNminsOne = fibN;
        }
        return fibN;
    }

    /**
     * n = 1时，1
     * n = 2时，2
     * @param n
     * @return int
     * @author lisong@cestc.cn
     * @date 2021/07/23 15:01:46
     * @throws
     */
    public int numWays(int n){
        if (n<0){
            return 0;
        }
        int fibNminsOne = 1;
        int fibNminsTwo = 1;
        int fibN = 0;
        for (int i = 0;i<n;i++){
            fibN = (fibNminsOne+fibNminsTwo)%1000000007;
            fibNminsTwo = fibNminsOne;
            fibNminsOne = fibN;
        }
        return fibNminsTwo;
    }
}
