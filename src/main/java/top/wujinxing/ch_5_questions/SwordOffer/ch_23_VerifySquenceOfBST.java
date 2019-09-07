package top.wujinxing.ch_5_questions.SwordOffer;

/**
 * @author wujinxing
 * date 2019 2019/9/7 21:30
 * description 二叉搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class ch_23_VerifySquenceOfBST {

    /**
     * 思路:
     * 后序遍历最后一个元素为根root.前面的元素分为两类,前一堆是左子树,后一堆为左子树
     * 且前一堆的最后一个元素为左子树的根,元素都小于root, 后一堆的最后一个元素为右子树的根 元素都大于root
     *
     * @param sequence 二叉搜索树后序遍历数组
     * @return 是否为二叉搜索树
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return rec(sequence, 0, sequence.length - 1);
    }

    private boolean rec(int[] seq, int L, int R) {
        if (L >= R) //前面的都已满足条件
            return true;
        int root = seq[R];
        int i = L;
        //找到左子树-->左右子树的分界
        while (i <= R - 1 && seq[i] < root)
            i++;
        int mid = i; //seq[mid] > root 从mid开始是右子树,必须都>root
        while (i <= R - 1) {
            if (seq[i] < root)
                return false;
            i++;
        }
        return rec(seq, L, mid - 1) && rec(seq, mid, R - 1);

    }
}
