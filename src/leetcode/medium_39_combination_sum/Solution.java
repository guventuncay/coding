package leetcode.medium_39_combination_sum;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        track(0, new ArrayList<>(), 0, candidates, target, res);

        return res;
    }


    private void track(int i, List<Integer> crr, int total, int[] candidates, int target, List<List<Integer>> result) {
        if (total == target) {
            result.add(new ArrayList<>(crr));
            return;
        }
        if (i >= candidates.length || total > target) {
            return;
        }

        ArrayList<Integer> newCrr = new ArrayList<>(crr);
        newCrr.add(candidates[i]);
        track(i, newCrr, total + candidates[i], candidates, target, result);
        track(i + 1, crr, total, candidates, target, result);
    }
}