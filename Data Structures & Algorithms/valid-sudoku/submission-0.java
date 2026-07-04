class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Create 9 sets for rows
        HashSet<Character>[] rows = new HashSet[9];

        // Create 9 sets for columns
        HashSet<Character>[] cols = new HashSet[9];

        // Create 9 sets for boxes
        HashSet<Character>[] boxes = new HashSet[9];

        // Initialize all sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Traverse every cell
        for (int r = 0; r < 9; r++) {

            for (int c = 0; c < 9; c++) {

                char current = board[r][c];

                // Ignore empty cells
                if (current == '.') {
                    continue;
                }

                // Find box number
                int box = (r / 3) * 3 + (c / 3);

                // Duplicate found
                if (rows[r].contains(current) ||
                    cols[c].contains(current) ||
                    boxes[box].contains(current)) {

                    return false;
                }

                // Store the number
                rows[r].add(current);
                cols[c].add(current);
                boxes[box].add(current);
            }
        }

        return true;
    }
}