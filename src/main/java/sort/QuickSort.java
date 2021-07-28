package sort;

import java.util.Arrays;

/**
 * 快速排序算法实现
 *
 * @author lisong@cestc.cn
 * @date 2021/7/23
 */
public class QuickSort {

    public QuickSort(int[] array) {
        this.array = array;
    }

    private int[] array;

    public int[] getArray() {
        return array;
    }

    public void sort(){
        quickSort(array,0,array.length-1);
    }

    public void sortAdvance(){
        quickSortAdvance(array,0,array.length-1);
    }
    /**
     * 递归快速排序
     * 首先从数列的右边开始往左边找，我们设这个下标为 j，也就是进行减减操作（j--)，找到第 1 个比基准数小的值，让它与基准值交换；
     * 接着从左边开始往右边找，设这个下标为 i，然后执行加加操作（i++），找到第 1 个比基准数大的值，让它与基准值交换；
     * 然后继续寻找，直到 i 与 j 相遇时结束，最后基准值所在的位置即 k 的位置，k 左边的值均比 k 上的值小，而 k 右边的值都比 k 上的值大。
     * @param src
     * @param begin
     * @param end
     * @return void
     * @author lisong@cestc.cn
     * @date 2021/07/23 15:59:49
     * @throws
     */
    private void quickSort(int[] src,int begin,int end){
        if (begin < end){
            int key = src[begin];
            int i = begin;
            int j = end;
            while (i < j){
                while (i < j && src[j] > key){
                    j--;
                }
                if (i < j){
                    src[i] = src[j];
                    i++;
                }
                while (i < j && src[i] < key){
                    i++;
                }
                if (i < j){
                    src[j] = src[i];
                    j--;
                }
            }
            src[i] = key;
            quickSort(src,begin,i-1);
            quickSort(src,i+1,end);
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 9, 1, 9, 5, 3, 7, 6, 1};
        QuickSort quickSort = new QuickSort(array);
//        quickSort.sort();
        quickSort.sortAdvance();
        System.out.println(Arrays.toString(quickSort.getArray()));
    }


    private void quickSortAdvance(int[] src,int begin,int end){
        if (begin == end){
            return;
        }
        int index = partition(src, begin, end);
        if (index > begin){
            quickSortAdvance(src,begin,index-1);
        }
        if (index < end){
            quickSortAdvance(src,index+1,end);
        }
    }

    /**
     * 在数组中选择一个数字，再把数组中的数字分为两部分，比选择的数字小的数字移到数组左边，比选择数字大的数字移到数组右边
     * @param src
     * @param begin
     * @param end
     * @return int
     * @author lisong@cestc.cn
     * @date 2021/07/26 11:07:30
     * @throws
     */
    private int partition(int[] src,int begin,int end){
        if (src == null || src.length <= 0 || begin <0 || end >= src.length){
            throw new RuntimeException();
        }
        int index = begin;
        int temp = src[begin];
        src[begin] = src[end];
        src[end] = temp;
        int small = begin - 1;
        for (index = begin;index<end;++index){
            if (src[index] < src[end]){
                ++small;
                if (small != index){
                    int temp1 = src[index];
                    src[index] = src[small];
                    src[small] = temp1;
                }
            }
        }
        ++small;
        int temp2 = src[small];
        src[small] = src[end];
        src[end] = temp2;
        return small;
    }


}
