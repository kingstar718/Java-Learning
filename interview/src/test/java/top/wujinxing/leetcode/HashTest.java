package top.wujinxing.leetcode;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import top.wujinxing.leetcode.hash.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertArrayEquals;

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
        assertEquals(Lists.newArrayList("c", "o"),
                Ch1002FindCommonCharacters.commonChars(new String[]{"cool", "lock", "cook"}));
        assertEquals(Lists.newArrayList(),
                Ch1002FindCommonCharacters.commonChars(new String[]{}));
    }

    @Test
    public void intersection() {
        assertArrayEquals(new int[]{2}, Ch349IntersectionOfTwoArrays.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        assertArrayEquals(new int[]{4, 9}, Ch349IntersectionOfTwoArrays.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
        assertArrayEquals(new int[]{}, Ch349IntersectionOfTwoArrays.intersection(new int[]{}, new int[]{}));
    }

    @Test
    public void fourSumCount() {
        assertEquals(2, Ch454FourSum2.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }

    @Test
    public void canConstruct() {
        assertTrue(Ch383RansomNote.canConstruct("aa", "aab"));
        assertFalse(Ch383RansomNote.canConstruct("aa", "ab"));
        assertFalse(Ch383RansomNote.canConstruct("a", "b"));
    }

    @Test
    public void isHappy() {
        assertTrue(Ch202HappyNumber.isHappy(19));
        assertFalse(Ch202HappyNumber.isHappy(2));
    }

}
