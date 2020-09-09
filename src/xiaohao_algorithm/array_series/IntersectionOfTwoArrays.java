package xiaohao_algorithm.array_series;

import java.util.*;

/**
 * 第350题：两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * <p>
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * <p>
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 进阶:
 * 如果给定的数组已经排好序呢？将如何优化你的算法呢？
 * <p>
 * 思路：设定两个为0的指针，比较两个指针的元素是否相等。如果指针的元素相等，我们将两个指针一起向后移动，并且将相等的元素放入空白数组。
 *
 * @author 190503
 */
public class IntersectionOfTwoArrays {

    /**
     * 计算两个数组的交集
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 返回两个数组的交集
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map0 = new HashMap<>(16);
        for (int v : nums1) {
            //遍历 nums1，初始化 map
            if (!map0.keySet().contains(v)) {
                map0.put(v, 1);
            } else {
                map0.put(v, map0.get(v).intValue() + 1);
            }
        }
        int k = 0;
        for (int v : nums2) {
            //如果元素相同，将其存入Nums2中，并将出现次数减1
            if (map0.keySet().contains(v)) {
                if (map0.get(v).intValue() > 0) {
                    map0.put(v, map0.get(v).intValue() - 1);
                    nums2[k] = v;
                    k++;
                }
            }
        }
        return Arrays.copyOfRange(nums2, 0, k);
    }

    /**
     * 计算两个数组的交集---list存储交集再转换为数组
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 返回两个数组的交集
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map0 = new HashMap<>(16);
        for (int v : nums1) {
            //遍历 nums1，初始化 map
            if (!map0.keySet().contains(v)) {
                map0.put(v, 1);
            } else {
                map0.put(v, map0.get(v).intValue() + 1);
            }
        }
        List<Integer> interSectionList = new ArrayList<>();
        for (int v : nums2) {
            //如果元素相同，将其存入intersectionNums中，并将出现次数减1
            if (map0.keySet().contains(v)) {
                if (map0.get(v).intValue() > 0) {
                    interSectionList.add(v);
                    map0.put(v, map0.get(v).intValue() - 1);
                }
            }
        }
        return interSectionList.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 计算两个数组的交集---升级版（先排序后计算交集）
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 返回两个数组的交集
     */
    public int[] intersectPro(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length;
        int length2 = nums2.length;
        while (i < length1 && j < length2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] == nums2[j]) {
                nums1[k] = nums1[i];
                i++;
                j++;
                k++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    /**
     * 计算两个数组的交集---升级版（先排序后计算交集）---list存储交集再转换为数组
     * @param nums1 数组1
     * @param nums2 数组2
     * @return  返回两个数组的交集
     */
    public int[] intersectPro2(int[] nums1, int[] nums2) {
        ArrayList<Integer> interSectList = new ArrayList<>();
        int i = 0, j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length;
        int length2 = nums2.length;
        for (i = 0, j = 0; i < length1 && j < length2;) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                interSectList.add(nums1[i]);
                i++;
                j++;
            }
        }
        return interSectList.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2, 3, 4};
        int[] nums3 = {4, 9, 5, 4};
        int[] nums4 = {5, 9, 4, 9, 8, 4, 0};

        IntersectionOfTwoArrays intersection = new IntersectionOfTwoArrays();
        int[] interSectionNums1 = intersection.intersect(nums1, nums2);
        int[] interSectionNums2 = intersection.intersect2(nums3, nums4);
        intersection.printlnArray(interSectionNums1);
        intersection.printlnArray(interSectionNums2);

        int[] intersectionNums3 = intersection.intersectPro(nums3, nums4);
        intersection.printlnArray(intersectionNums3);
        int[] intersectionNums4 = intersection.intersectPro2(nums3, nums4);
        intersection.printlnArray(intersectionNums4);
    }

    /**
     * 打印输出数组
     *
     * @param array 数组
     */
    public void printlnArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
            if (i == array.length - 1) {
                System.out.print("]");
            }
        }
        System.out.println();
    }
}
