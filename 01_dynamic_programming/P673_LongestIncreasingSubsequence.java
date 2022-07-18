public class P673_LongestIncreasingSubsequence {

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n], cnt = new int[n]; // max length from i & count for such lengths from i
        int maxLen = 0, res = 0;
        for (int i = 0; i < n; i++) {
            len[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j]+1) cnt[i] += cnt[j];
                    if (len[i] < len[j]+1) {
                        len[i] = len[j]+1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (maxLen == len[i]) res += cnt[i];
            if (maxLen < len[i]) {
                maxLen = len[i];
                res = cnt[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] probs = {
            {1,3,5,4,7},
            {2,2,2,2,2}
        };
        for (int[] prob: probs) {
            System.out.println(findNumberOfLIS(prob));
        }
    }
}