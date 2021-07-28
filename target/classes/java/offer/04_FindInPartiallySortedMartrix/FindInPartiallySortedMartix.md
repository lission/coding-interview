## 二位数组中的查找
### 题目：
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下的递增
顺序排列。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该
整数。

### 解法：
* 首先选取数组中右上角的数字。如果该数字等于要查找的数字，则查找过程结束；
* 如果该数字大于要查找的数字，则剔除这个数字所在的列；
* 如果该数字小于要查找的数字，则剔除这个数字所在的行。
* 即，如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围中剔除一行或一列， 
  每一步都可以缩小查找的范围，直到找到要查找的数字，或查找范围为空。
  
### 总结：
当问题比较复杂时，通过具体的例子找出其中规律