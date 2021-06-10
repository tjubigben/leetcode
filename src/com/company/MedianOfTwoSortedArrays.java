package com.company;

/**
 * wangkai
 * 2021/6/8
 **/
public class MedianOfTwoSortedArrays {
    class Solution {
        private double findMinNum(int[] nums1, int[] nums2, int midIndex) {
            double median = 0L;
            int i = 0;
            int j = 0;
            int nums1Len = nums1.length;
            int nums2Len = nums2.length;

            while (i + j < midIndex && i < nums1Len - 1 && j < nums2Len - 1) {
                if (nums1[i] < nums2[j]) {
                    ++i;
                } else {
                    ++j;
                }
            }
            while (i + j < midIndex) {
                if (i < nums1Len - 1) {
                    ++i;
                } else if (j < nums2Len - 1) {
                    ++j;
                }
            }
            median = Math.min(nums1[i], nums2[j]);
            return median;
        }

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            double result = 0L;
            int nums1Len = nums1.length;
            int nums2Len = nums2.length;
            int midIndex = (nums1Len + nums2Len) / 2;
            int odd = 0;
            if ((nums1Len + nums2Len) % 2 == 0) {
                odd = 1; //偶数
            } else {
                odd = 0; //奇数
            }

            result = findMinNum(nums1, nums2, midIndex);
            if (odd == 1) {
                double a = findMinNum(nums1, nums2, midIndex - 1);
                result = (result + a) / 2;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}
