

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // Create a HashMap to store: number → its index
        // Think of it as a "phone book": name (number) → phone number (index)
        HashMap<Integer, Integer> seen = new HashMap<>();
        //       ^key type  ^value type
        //       (the number) (its index)

        // Loop through every element in the array
        // 'i' is the current index (position), goes from 0 to nums.length - 1
        for (int i = 0; i < nums.length; i++) {

            // Get the current number at position i
            int currentNum = nums[i];

            // Calculate what number we NEED to find (the complement)
            // If currentNum + complement = target, then complement = target - currentNum
            int complement = target - currentNum;

            // Check if we have already seen the complement in our HashMap
            // containsKey() returns true if the key exists in the map
            if (seen.containsKey(complement)) {

                // We found our pair!
                // seen.get(complement) gives us the INDEX where complement was stored
                // i is the current index
                return new int[] { seen.get(complement), i };
                //   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                //   This creates and returns a new int array with 2 elements
            }

            // If complement not found, store the current number and its index
            // put(key, value) adds an entry to the HashMap
            seen.put(currentNum, i);
        }

        // This line should never be reached (problem guarantees one solution)
        // But Java requires a return statement outside the loop
        return new int[] {};
    }
}