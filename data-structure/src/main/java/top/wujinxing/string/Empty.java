package top.wujinxing.string;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author wujinxing
 * @date 2022-07-18
 */
@Slf4j
public class Empty {

    public static void main(String[] args) {

        log.info("'\u00ad': {}", '\u00ad');
        String s = "fdfda发达-发达萨芬-发达发神经";
        String chs1 = chs(s);
        String  chs2 = StringUtils.remove(s, "-");
        log.info("chs1: {}", chs1);
        log.info("chs2: {}", chs2);

    }

    /**
     * 借鉴common-lang3的StringUtils.remove写法，使用时仅需替换字符串比较条件即可，
     * 注意最后生成new String时长度为pos的长度，非源字符串的长度
     */
    private static String chs(String s) {
        char[] chars = s.toCharArray();
        int pos = 0;
        for (int i = 0, len = chars.length; i < len; ++i) {
            char aChar = chars[i];
            boolean b = aChar < '\u00ad';
            if (!b) {
                chars[pos++] = chars[i];
            }
        }
        return new String(chars, 0, pos);
    }

}
