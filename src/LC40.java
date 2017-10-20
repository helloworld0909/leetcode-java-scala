/**
 * Created by u8j8u on 2017/10/20.
 */
import java.util.*;
public class LC40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer> comb = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        findCombinationSum(candidates, 0, target, comb, res);
        return res;
    }

    private void findCombinationSum(int [] candidates, int start, int target, List<Integer> comb, List<List<Integer>> res){
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(comb));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i] == candidates[i-1]){
                continue;
            }

            comb.add(candidates[i]);
            findCombinationSum(candidates, i+1, target-candidates[i], comb, res);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        int [] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        LC40 solution = new LC40();
        System.out.println(solution.combinationSum2(candidates, target));
    }
}
