// 1041. Robot Bounded In Circle

// Solution 1 - Iterate over instructions once and check if robot is back to origin or not.
// If robot is back to origin then it is bounded in circle.
// If robot is not back to origin and facing north then it is not bounded in circle.
// If robot is not back to origin and not facing north then it is bounded in circle 
// because it will eventually come back to origin after 4 iterations because 
// it will be facing the same direction as it was in the beginning after 4 iterations.
// TC - O(n) - iterate over instructions once.
// SC - O(1) - only 4 directions are stored in dir array. No extra space used.
class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dir = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
        int idx = 0;
        int count = 1;
        int n = instructions.length();
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            Character ch = instructions.charAt(i);

            if (ch == 'G') {
                x += dir[idx][0];
                y += dir[idx][1];

            } else if (ch == 'L') {
                idx = (idx + 1) % 4;
            } else {
                idx = (idx + 3) % 4;
            }
        }
        if (x == 0 && y == 0) {
            return true;
        } else if (idx == 0) {
            return false;
        }

        return true;

    }
}

// Solution 2 - Iterate over instructions 4 times at max and check if robot is
// back to origin or not.
// If robot is back to origin then it is bounded in circle.
// If robot is not back to origin after 4 iterations then it is not bounded in
// circle.
// We need to iterate over instructions 4 times because after 4 iterations robot
// will be facing the same direction as it was in the beginning.
// So if robot is not back to origin after 4 iterations then it will never be
// back to origin.

// TC - O(n) - iterate over instructions 4 times at max.
// SC - O(1) - only 4 directions are stored in dir array. No extra space used.
// class Solution {
// public boolean isRobotBounded(String instructions) {
// int[][] dir = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}};
// int idx =0;
// int count = 1;
// int n = instructions.length();
// int x = 0;
// int y = 0;
// while(count <5) {
// for(int i =0; i< n; i++) {
// Character ch = instructions.charAt(i);

// if(ch == 'G') {
// x += dir[idx][0];
// y += dir[idx][1];

// } else if(ch == 'L') {
// idx = (idx+1)%4;
// } else {
// idx = (idx+3)%4;
// }
// }
// if(x ==0 && y == 0) {
// return true;
// }
// count ++;

// }
// return false;

// }
// }