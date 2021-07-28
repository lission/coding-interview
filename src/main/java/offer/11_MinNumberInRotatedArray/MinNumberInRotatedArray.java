/**
 * 旋转数组中的最小数字
 *
 * @author lisong@cestc.cn
 * @date 2021/7/23
 */
public class MinNumberInRotatedArray {

    /**
     * TODO
     *
     * @param numbers
     * @return int
     * @throws
     * @author lisong@cestc.cn
     * @date 2021/07/26 14:12:48
     */
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            throw new RuntimeException("Invalid parameters");
        }
        int index1 = 0;
        int index2 = numbers.length - 1;
        //indexMid初始化为index1，如果数组第一个数字小于最后一个数字，表名数组是排序的，可以直接返回第一个数字
        int indexMid = index1;
        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            //如果下标为index1、index2、indexMid指向三个相等数字，只能顺序查找
            if (numbers[index1] == numbers[index2] && numbers[indexMid] == numbers[index1]) {
                int result = numbers[index1];
                for (int i = index1; i <= index2; ++i) {
                    if (result > numbers[i]) {
                        result = numbers[i];
                    }
                }
                return result;
            }
            if (numbers[indexMid] >= numbers[index1]) {
                index1 = indexMid;
            } else if (numbers[indexMid] <= numbers[index2]) {
                index2 = indexMid;
            }
        }

        return numbers[indexMid];
    }
}
