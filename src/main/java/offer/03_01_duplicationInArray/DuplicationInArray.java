/**
 * TODO
 *
 * @author lisong@cestc.cn
 * @date 2021/7/6
 */
public class DuplicationInArray {

    /**
     * 数组中的数字都在0~n-1范围内，如果数组中没有重复数字，当数组排序后数字i将出现在下标为i的位置。
     * <br>处理过程：</br>
     * <ul>
     * <li>依次扫描到下标为i的数字时，首先比较这个数字(m)是不是等于i。</li>
     * <ul>
     * <li>如果是，接着扫描下一个数字；</li>
     * <li>如果不是，拿它和第m个数字进行比较。</li>
     * <ul>
     * <li>如果它和第m个数字相等，就找到了第一个重复数字（该数字在下标为i和m的位置都出现了）</li>
     * <li>如果它和第m个数字不相等，把第i个数字和第m个数字交换。</li>
     * </ul>
     * </ul>
     * <li>重复比较-交换过程，直到发现一个重复数字
     * </ul>
     *
     * @param numbers
     * @return int
     * @throws
     * @author lisong@cestc.cn
     * @date 2021/07/06 17:49:34
     */
    public int duplication(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return -1;
        }
        //传参合法性校验
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1) {
                return -1;
            }
        }
        /*
         * 双循环，每个数字最多只要交换两次就能找到属于它的位置，总的时间复杂度为O(n)。
         * 所有的操作都是在输入数组进行的，不需要额外分配内存，空间复杂度O(1)
         *
         */
        for (int i = 0;i<numbers.length;i++){
            while (numbers[i] != i){
                int m = numbers[i];
                if (numbers[i] == numbers[m]){
                    return numbers[i];
                }
                numbers[i] = numbers[m];
                numbers[m] = m;
            }
        }
        return -1;
    }
}
