// 2303. Calculate Amount Paid in Taxes
// Solution - Iterate over brackets and calculate tax for each bracket until remaining amount is less than 0.
// TC - O(n) - iterate over brackets once.
// SC - O(1) - no extra space used. 
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int remainingAmount = income;
        int n = brackets.length;
        double res = 0.0;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int upper = brackets[i][0];
            double percent = brackets[i][1] / 100.0;
            int taxable = upper - prev;

            res += Math.min(taxable, remainingAmount) * percent;

            prev = upper;
            remainingAmount -= taxable;
            if (remainingAmount < 0)
                break;
        }
        return res;

    }
}