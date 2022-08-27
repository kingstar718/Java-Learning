package top.wujinxing.offer;

import org.junit.Test;


/**
 * @author wujinxing
 * date 2019 2019/7/1 11:25
 * description 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 */
public class _51_InversePairs {

    @Test
    public void test(){
        //Scanner sc = new Scanner(System.in);
        //System.out.print("请输入数字：");
        int[] nums = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(nums));
    }


    private long cnt = 0;
    private int[] tmp;   // 在这里声明辅助数组，而不是在 merge() 递归函数中声明

    public int InversePairs(int[] nums){
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length-1);
        return (int) (cnt%1000000007);
    }
    private void mergeSort(int[] nums, int l, int h){
        if (h-l < 1) return;
        int m = l+(h-l)/2;
        mergeSort(nums, l, m);
        mergeSort(nums, m+1, h);
        merge(nums, l, m, h);
    }
    private void merge(int[] nums, int l, int m, int h){
        int i=l, j=m+1, k=l;
        while (i<=m || j<=h){
            if (i>m)
                tmp[k] = nums[j++];
            else if (j>h)
                tmp[k] = nums[i++];
            else if (nums[i]<nums[j])
                tmp[k] = nums[i++];
            else
                tmp[k] = nums[j++];
                this.cnt += m-i+1;
            k++;
        }
        for (k=l; k<=h; k++){
            nums[k] = tmp[k];
        }

    }

}
