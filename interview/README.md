# LeetCode

## 1 链表

1. 合并两个有序链表

   1. 思路：双指依次比较大小，将较小的节点链接到结果链表中；注意虚拟头节点的使用
   2. [LeetCode](https://leetcode.cn/problems/merge-two-sorted-lists/)
   3. [实现代码](https://github.com/kingstar718/Java-Learning/blob/master/interview/src/main/java/top/wujinxing/leetcode/linked_list/Ch_21_MergeTwoSortedLists.java)
2. 单链表的分解

   1. 2
   2. 
3. 合并 k 个有序链表
4. 寻找单链表的倒数第 k 个节点
5. 寻找单链表的中点
6. 判断单链表是否包含环并找出环起点
7. 判断两个单链表是否相交并找出交点

## 2 数组

### 2.1 快慢指针技巧

1. [26]删除有序数组中的重复项
   1. 思路：快慢指针技巧，就是让你原地修改数组
   2. [L](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/)eetCode
   3. s
2. [83]删除山圩链表中的重复元素
   1. 思路：快慢指针，只是将数据赋值操作变为指针
3. [27]移除元素
   1. 思路：快慢指针，快指针遇到值为目标，直接跳过，否则就赋给慢指针，并让慢指针前进一步

### 2.2 左右指针的常用算法

1. 二分查找
2. [167]两数之和II
3. [344]反转数组
4. [5]回文串判断

### 2.3 前缀和数组

前缀和数组适用于快速、频繁的计算一个索引区间内的元素之和。
