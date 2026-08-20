class Solution {
    Boolean[] dp;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;

        // Even using all numbers cannot reach target
        if (sum < desiredTotal) {
            return false;
        }

        // Target already achieved
        if (desiredTotal <= 0) {
            return true;
        }

        dp = new Boolean[1 << maxChoosableInteger];

        return dfs(0, desiredTotal, maxChoosableInteger);
    }

    private boolean dfs(int mask, int target, int max) {

        if (dp[mask] != null) {
            return dp[mask];
        }

        for (int i = 1; i <= max; i++) {

            int bit = 1 << (i - 1);

            // Number already used
            if ((mask & bit) != 0) {
                continue;
            }

            // We can win immediately
            if (i >= target) {
                return dp[mask] = true;
            }

            // Choose i and make opponent lose
            if (!dfs(mask | bit, target - i, max)) {
                return dp[mask] = true;
            }
        }

        return dp[mask] = false;
    }
}