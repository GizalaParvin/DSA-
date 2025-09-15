import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // validate rows
        for (int row = 0; row < 9; row++) {
            HashSet<Character> seen = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                if (c == '.') continue;
                if (seen.contains(c)) return false;
                seen.add(c);
            }
        }

        // validate columns
        for (int col = 0; col < 9; col++) {
            HashSet<Character> seen = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char c = board[row][col];
                if (c == '.') continue;
                if (seen.contains(c)) return false;
                seen.add(c);
            }
        }

        // validate 3x3 sub-boxes
        for (int startRow = 0; startRow < 9; startRow += 3) {
            for (int startCol = 0; startCol < 9; startCol += 3) {
                HashSet<Character> seen = new HashSet<>();
                for (int r = startRow; r < startRow + 3; r++) {
                    for (int c = startCol; c < startCol + 3; c++) {
                        char val = board[r][c];
                        if (val == '.') continue;
                        if (seen.contains(val)) return false;
                        seen.add(val);
                    }
                }
            }
        }

        return true;
    }
}
