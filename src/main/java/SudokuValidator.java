import java.util.*;

public class SudokuValidator {

    public static boolean isSudokuValid(int[][] sudoku) {
        return isVerticallyValid(sudoku) &&
                isHorizontallyValid(sudoku) &&
                isSquaresValid(sudoku);
    }

    private static boolean isVerticallyValid(int[][] sudoku) {
        Set<Integer> column = new HashSet<>();

        for (int i = 0; i < sudoku.length; ++i) {
            column.clear();

            for (int j = 0; j < sudoku[i].length; ++j) {
                column.add(sudoku[i][j]);
            }

            if (column.size() != 9) {
                return false;
            }
        }

        return true;
    }

    private static boolean isHorizontallyValid(int[][] sudoku) {
        Set<Integer> row = new HashSet<>();

        for (int i = 0; i < sudoku.length; ++i) {
            row.clear();

            for (int j = 0; j < sudoku[i].length; ++j) {
                row.add(sudoku[j][i]);
            }

            if (row.size() != 9) {
                return false;
            }
        }

        return true;
    }

    private static boolean isSquaresValid(int[][] sudoku) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; ++j) {
                if (!isSquareValid(3 * i, 3 * j, sudoku)){
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isSquareValid(int i_s, int j_s, int[][] sudoku) {
        Set<Integer> square = new HashSet<>();

        for (int i = i_s; i < i_s + 3; ++i) {
            for (int j = j_s; j < j_s + 3; ++j) {
                square.add(sudoku[i][j]);
            }
        }

        return (square.size() == 9);
    }

    public static void main(String[] args) {

        int[][] sudoku = {
                {8,2,5, 4,7,1, 3,9,6},
                {1,9,4, 3,2,6, 5,7,8},
                {3,7,6, 9,8,5, 2,4,1},

                {5,1,9, 7,4,3, 8,6,2},
                {6,3,2, 5,9,8, 4,1,7},
                {4,8,7, 6,1,2, 9,3,5},

                {2,6,3, 1,5,9, 7,8,4},
                {9,4,8, 2,6,7, 1,5,3},
                {7,5,1, 8,3,4, 6,2,9}
        };

        System.out.println(SudokuValidator.isSudokuValid(sudoku));
    }
}
