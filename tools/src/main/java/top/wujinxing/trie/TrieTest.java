package top.wujinxing.trie;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kingstar718
 * @date 2023/07/31
 */
public class TrieTest {

    @Test
    public void trieTest1() {
        Trie<String, String> trie = new PatriciaTrie<>();
        trie.put("Abigail", "student");
        trie.put("Abi", "doctor");
        trie.put("Annabel", "teacher");
        trie.put("Christina", "student");
        trie.put("Chris", "doctor");
        Assert.assertTrue(trie.containsKey("Abigail"));
        Assert.assertEquals("{Abi=doctor, Abigail=student}", trie.prefixMap("Abi").toString());
        Assert.assertEquals("{Chris=doctor, Christina=student}", trie.prefixMap("Chr").toString());
    }

    @Test
    public void trieTest2() {
        PatriciaTrie<Double> t = new PatriciaTrie<>();

        t.put("ronak", 100.0);
        t.put("ronald", 90.0);
        t.put("rat", 50.0);
        t.put("robert", 200.0);
        t.put("bat", 44.0);
        t.put("batman", 440.0);

        System.out.println(t.containsKey("ronak"));
        System.out.println(t.selectKey("ro"));
        System.out.println(t.prefixMap("r"));
        System.out.println(t.prefixMap("ro"));
        System.out.println(t.prefixMap("ron"));
    }

}
