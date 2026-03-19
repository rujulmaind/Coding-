import java.util.*;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int mapped = getMappedValue(nums[i], mapping);
            list.add(new int[]{mapped, i, nums[i]});
        }

         Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = list.get(i)[2];
        }

        return result;
    }

    private int getMappedValue(int num, int[] mapping) {
        if (num == 0) return mapping[0];

        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int digit = num % 10;
            sb.append(mapping[digit]);
            num /= 10;
        }

        sb.reverse();
        return Integer.parseInt(sb.toString());
    }
}