package com.kush.studyplan.seventyfive.arraystring;
class FlowerPlanting {
    public static void main(String[] args) {
        // Sample flowerbed array and number of flowers to plant
        int[] flowers = {1, 0, 0, 0, 1};
        int n = 1;

        // Check if flowers can be placed and print the result
        boolean result = canPlaceFlowers(flowers, n);
        System.out.println("Can place flowers: " + result);
    }

    /*
    Problem:
    Determine if a certain number of flowers 'n' can be planted in a flowerbed represented by 'flowers'.

    Logic Explanation:
    - Check special cases: if 'n' is 0 or flowerbed length is 1.
    - Iterate through the flowerbed array and check each position.
    - If the current position is suitable for planting a flower:
        - Set the current position to 1 (indicating the flower is planted).
        - Decrease the count of remaining flowers 'n'.
    - If 'n' becomes 0, return true as all flowers are planted.
    - Return false if it's not possible to plant 'n' flowers in the flowerbed.

    Key Points:
    - Handles special cases when 'n' is 0 or flowerbed length is 1.
    - Checks each position in the flowerbed for planting flowers.
    - Returns true if it's possible to plant all 'n' flowers; otherwise, returns false.
    */

    public static boolean canPlaceFlowers(int[] flowers, int n) {
        int length = flowers.length;
        if (n == 0) return true; // No flowers to plant

        if (length == 1) {
            // Special case: Check if one flower can be planted in a single cell flowerbed
            return flowers[0] == 0 && n == 1;
        }

        for (int i = 0; i < length; i++) {
            // Check if the current position can be planted with a flower
            if (flowers[i] == 0 && (i == 0 || flowers[i - 1] == 0)
                    && (i == length - 1 || flowers[i + 1] == 0)) {
                flowers[i] = 1; // Plant a flower
                n--; // Decrease the count of remaining flowers
            }

            if (n == 0) {
                return true; // All flowers are planted
            }
        }

        return false; // Unable to plant all 'n' flowers in the flowerbed
    }
}
