package xiaohao_algorithm.array_series;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * 题目14: 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
 * <p>
 * 示例1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * <p>
 * 解释:
 * 输入不存在公共前缀。
 * <p>
 * 说明：
 * 所有输入只包含小写字母 a-z
 *
 * @author Simon
 * @date 2020-09-10
 * @time 11:27
 */
public class LongestCommonPrefix {

    /**
     * 查询字符串数组中的最长公共前缀
     *
     * @param strs 字符串数组
     * @return 返回字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
     */
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length < 1) {
            return "";
        }
        String prefix = strs[0];
        for (String compareStr : strs) {
            while (compareStr.indexOf(prefix) != 0) {
                if (prefix.length() == 0) {
                    return "";
                }
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    /**
     * 查询字符串数组中的最长公共前缀---用索引的方法，比较每个元素与基准元素x0的第i个字符是否相等
     *
     * @param strs 字符串数组
     * @return 返回字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
     */
    public String longestCommonPrefix2(String[] strs) {
        // 获取长度最小的字符串，作为基准元素x0
        String prefix = Arrays.stream(strs).min(Comparator.comparingInt(String::length)).orElse("");
        System.out.println("shortStr: " + prefix);
        if (prefix.length() == 0) {
            System.out.println(prefix);
            return prefix;
        } else {
            for (String s1 : strs) {
                if (Objects.equals(prefix, s1)) {
                    continue;
                }
                char[] shortS = prefix.toCharArray();
                // 比较每个元素的第i个字符是否相等
                for (int i = 0; i < shortS.length; i++) {
                    char aShort = shortS[i];
                    // 若元素的第i个字符不相等，则截取基准元素x0前i个字符
                    if (s1.toCharArray()[i] != aShort) {
                        prefix = prefix.substring(0, i);
                        break;
                    }
                }
            }
        }
        System.out.println("success: " + prefix);
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight", "fly", "fen"};
        String[] strs2 = new String[]{"transport", "trance", "train", "transcript", "tren"};

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        String lcprefix = longestCommonPrefix.longestCommonPrefix(strs);
        System.out.println(lcprefix);

        longestCommonPrefix.longestCommonPrefix2(strs2);
    }
}
