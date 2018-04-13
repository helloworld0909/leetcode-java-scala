package com.helloworld09.leetcode.java;


public class LC43 {
    /**
     * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
     * <p>
     * Note:
     * <p>
     * The length of both num1 and num2 is < 110.
     * Both num1 and num2 contains only digits 0-9.
     * Both num1 and num2 does not contain any leading zero.
     * You must not use any built-in BigInteger library or convert the inputs to integer directly.
     */
    public String multiply(String num1, String num2) {
        String result = "0", minNum, maxNum;
        if (num1.length() > num2.length()){
            minNum = num2;
            maxNum = num1;
        } else {
            minNum = num1;
            maxNum = num2;
        }

        for (int i = minNum.length() - 1; i >=0; i--){
            String zeros = repeatZeros(minNum.length() - 1 - i);
            String r = multiply(maxNum, minNum.charAt(i)) + zeros;
            result = add(result, r);
        }
        return result;
    }

    private String repeatZeros(int n){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i<n; i++){
            result.append('0');
        }
        return result.toString();
    }

    private String add(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int plus = 0;
        for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            int idx1 = num1.length() - 1 - i;
            int idx2 = num2.length() - 1 - i;
            int a1 = idx1 >= 0 ? num1.charAt(idx1) - '0' : 0;
            int a2 = idx2 >= 0 ? num2.charAt(idx2) - '0' : 0;
            int r = a1 + a2 + plus;
            result.append(r % 10);
            plus = r / 10;
        }
        if (plus != 0)
            result.append(plus);
        return result.reverse().toString();
    }

    private String multiply(String num1, char digit) {
        int mul1 = digit - '0';
        if (mul1 == 0)
            return "0";
        StringBuilder result = new StringBuilder();
        int plus = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int mul2 = num1.charAt(i) - '0';
            int r = mul1 * mul2 + plus;
            result.append(r % 10);
            plus = r / 10;
        }
        if (plus != 0)
            result.append(plus);
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        LC43 solution = new LC43();
        System.out.println(solution.multiply("2981", '5'));
        System.out.println(solution.add("1910", "948985"));
        System.out.println(solution.multiply("123", "0"));
    }
}
