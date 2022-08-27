package top.wujinxing.sword_offer;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/9/4 16:32
 * description 数值的整数次方
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 *
 *
 */
public class ch_12_Power {
    /**
     * 这个题目和普通的求幂不同的是:
     * 其中x(底数)是double类型的，且n是范围是Integer范围的(可正可负) :
     * 要注意的就是当n为负数的时候，我们可以转换成求 1.0 / pow(x,-n)；
     * 还一个很重要的地方就是当n = Integer.MIN_VALUE的时候要特殊处理，因为整形范围是-231到231-1，
     * 所以或者我们使用long来存转换的数，或者特殊判断一下；
     */

    public double Power(double x, int n){
        if (n == 0){
            return 1.0;
        }
        if (n < 0){
            if (n == Integer.MIN_VALUE){
                return 1.0 / (Power(x, Integer.MAX_VALUE) * x);
            }else {
                return 1.0 / Power(x, -n);
            }
        }
        double res = 1.0;
        while (n > 0){
            if ((n & 1) != 0){
                res *= x;
            }
            x = x * x;
            n >>= 1;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(Power(2.00000, 10));
        System.out.println(Power(2.10000, 3));
        System.out.println(Power(2.00000, -2));
    }
}

