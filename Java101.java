import java.util.Arrays;

public class Java101 {
    static int countOccurences(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                count += 1;
            }
        }
        return count;
    }

    static int[] reverseArray(int[] arr) {
        int[] revArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            revArr[arr.length - (i+1)] = arr[i];
        }
        return revArr;
    }

    static int sumGrid(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
            }
        }
        return sum;
    }

    static int fib(int n)
    {
        if (n==0) {
            return 0;
        } else if(n==1 || n==2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        // Count Occurences:
        int[] arr = {1, 1, 2, 3, 2, 4, 6, 2};
        int count = countOccurences(arr, 2);
        System.out.println("--------------Count Occurences--------------");
        System.out.println("Array: " + arr);
        System.out.println("Count: " + count);
        // Reverse Array
        int[] arr2 = {6, 8, 3, 4, 2, 1, 5, 3};
        int[] revArr2 = reverseArray(arr2);
        System.out.println("--------------Reverse Array--------------");
        System.out.println("Original Array: " + Arrays.toString(arr2));
        System.out.println("Reversed Array: " + Arrays.toString(revArr2));
        // Sum Grid
        int[][] grid = {{1,2,3,8,7,6,4},{5,2,7,4,6,2,9},{1,7,4,6,2,5,4}};
        int sum = sumGrid(grid);
        System.out.println("--------------Sum Grid--------------");
        System.out.println("Grid: " + Arrays.deepToString(grid));
        System.out.println("Sum: " + sum);
        // Fibonnaci
        int n = 10;
        int fib = fib(n);
        System.out.println("--------------Sum Grid--------------");
        System.out.println("n: " + n);
        System.out.println("nth fibonacci: " + fib);
    }
}
