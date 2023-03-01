package top.wujinxing.leetcode;

import com.google.common.collect.Lists;
import org.junit.Test;
import top.wujinxing.leetcode.hash.Ch1002FindCommonCharacters;
import top.wujinxing.leetcode.hash.Ch242ValidAnagram;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class HashTest {

    @Test
    public void isAnagram() {
        assertTrue(new Ch242ValidAnagram().isAnagram("anagram", "nagaram"));
        assertFalse(new Ch242ValidAnagram().isAnagram("rat", "car"));
    }

    @Test
    public void commonChars() {
        assertEquals(Lists.newArrayList("e", "l", "l"),
                Ch1002FindCommonCharacters.commonChars(new String[]{"bella", "label", "roller"}));
        assertEquals(Lists.newArrayList("c","o"),
                Ch1002FindCommonCharacters.commonChars(new String[]{"cool","lock","cook"}));
        assertEquals(Lists.newArrayList(),
                Ch1002FindCommonCharacters.commonChars(new String[]{}));
    }
}
