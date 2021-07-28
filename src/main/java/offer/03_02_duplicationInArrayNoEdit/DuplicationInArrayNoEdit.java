/**
 * TODO
 *
 * @author lisong@cestc.cn
 * @date 2021/7/7
 */
public class DuplicationInArrayNoEdit {

    /*
      ①不能修改输入的数组，创建一个长度为n+1的辅助数组。逐一把原数组的每个数字
      复制到辅助数组。如果原数组被复制的数字为m，则把它复制到辅助数组中下标为m的
      位置。
      该方案需要O(n)的辅助空间
     */

    /*
      ②把从1~n数字从中间数字m分为两部分，前面一半为1~m,后面一半为m+1~n。如果1~m的数字数目
      超过m，那么这一半的区间一定包含重复数字；否则另一半m+1~n的区间一定包含重复数字。继续把
      包含重复数字的区间一分为二，直到找到一个重复数字。
      该过程与二分查找法类似，多了一步统计区间数字数目
      时间复杂度 O(nlogn),空间复杂度O(1)
     */

    /**
     * @param numbers
     * @return int
     * @throws
     * @author lisong@cestc.cn
     * @date 2021/07/07 11:16:40
     */
    public int getDuplication(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return -1;
        }
        for (int number : numbers) {
            if (number < 1 || number > numbers.length - 1) {
                return -1;
            }
        }
        int start = 1;
        int end = numbers.length;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(numbers, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        return -1;
    }

    private int countRange(int[] numbers, int start, int end) {
        if (numbers == null){
            return 0;
        }
        int count = 0;
        for (int number : numbers) {
            if (number >= start && number <= end) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {2,3,1,4,2,5,3};
        DuplicationInArrayNoEdit duplication = new DuplicationInArrayNoEdit();
        int result = duplication.getDuplication(numbers);
        System.out.println(result);
    }
}
