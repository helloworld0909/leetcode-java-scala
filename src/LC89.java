/**
 * Created by u8j8u on 2017/10/19.
 */
import java.util.*;
public class LC89 {
    public List<Integer> grayCode(int n) {
        List<String> binaryList = binaryGrayCode(n);
        List<Integer> returnList = new ArrayList<>();
        for(String code: binaryList){
            returnList.add(Integer.parseInt(code, 2));
        }
        return returnList;
    }

    private List<String> binaryGrayCode(int n){
        if(n==0){
            return new ArrayList<>(Arrays.asList("0"));
        }
        else if(n==1) {
            return new ArrayList<>(Arrays.asList("0", "1"));
        }
        else{
            ArrayList<String> codeList = new ArrayList<>();

            List<String> leftBinaryList = binaryGrayCode(n / 2);
            List<String> rightBinaryList = binaryGrayCode(n - n/2);
            boolean reverse=false;
            for(String leftCode:leftBinaryList){
                if(!reverse) {
                    for (String rightCode : rightBinaryList) {
                        codeList.add(leftCode + rightCode);
                    }
                }
                else{
                    for(int idx=rightBinaryList.size()-1;idx>=0;idx--){
                        codeList.add(leftCode + rightBinaryList.get(idx));
                    }
                }
                reverse = !reverse;
            }
            return codeList;
        }
    }

    public static void main(String[] args) {
        LC89 solution = new LC89();
        System.out.println(solution.grayCode(0));
        System.out.println(solution.grayCode(2));
        System.out.println(solution.grayCode(5));
    }


}
