class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: count how many times each number appears
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: buckets[i] = list of numbers that appear exactly i times
        // max possible frequency is nums.length, so size it n+1
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);
            buckets[freq].add(num);
        }

        // Step 3: walk buckets from highest frequency to lowest, collect k numbers
        int[] result = new int[k];
        int index = 0;
        for (int freq = nums.length; freq >= 0 && index < k; freq--) {
            for (int num : buckets[freq]) {
                result[index++] = num;
                if (index == k) break;
            }
        }
        return result;
    }
}