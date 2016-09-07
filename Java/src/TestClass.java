import java.io.*;
public class TestClass 
{ 
    public static int minCostPath(int[][] cost, int m, int n) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (m == 0 && n == 0) {
            return cost[m][n];
        }
        return cost[m][n] + min(minCostPath(cost, m - 1, n), minCostPath(cost, m, n - 1), minCostPath(cost, m - 1, n - 1));
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

public static int minCostPathDP(int[][] cost, int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            dp[0][0] = cost[0][0];
            for (int i = 1; i <= m; i++) {
                dp[i][0] = dp[i - 1][0] + cost[i][0];
            }
            for (int j = 1; j <= n; j++) {
                dp[0][j] = dp[0][j - 1] + cost[0][j];
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = cost[i][j] + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }

            return dp[m][n];


        }
        public static String find(int[][] cost){
            int i = 0,j = 0;
            int R = cost.length;
            String s="";
            int b=0,d=0,r=0;
            for(;i<R;){
                for(;j<R;){

                    if(i+1>=R||j>=R){
                        if(i+1>=R){
                            b=10000;
                            r = cost[i][j+1];
                            d=10000;
                        }
                        if(j>=R){
                            r = 100000;
                            b= 10000;
                        }


                    }else{
                    b = cost[i+1][j];
                     d=cost[i+1][j+1];
                    r = cost[i][j+1];
                                    }
                    int a = min(d,r,b);


                    if(a == r){
                        s+="B";
                        j++;
                    }else if(a==d){
                        s+="D";
                        i++;j++;
                    }else if(a==b){
                        s+="R";
                        i++;
                    }
                    if(i>=R-1 && j>=R-1)
                    i=j=R+1;
                }
            }
         return s;   
    }

    public static String minimumCost(String[] input1,int input2)
    {
        int[][] cost = new int[input1.length][input1.length];
        
        int j = 0;
        for(int i = 0; i<input1.length;i++){
            j=0;
            String[] p = input1[i].split("#");
            for(String a:p){
                cost[i][j] = Integer.parseInt(a);
                j++;
            }
        }
        int k = cost[0].length;
        
        int a= minCostPath(cost, k-1, k-1);
        
        String t = new StringBuffer(find(cost)).reverse().toString();
        
        return Integer.toString(a)+","+t;
    }
    public static void main(String[] args){
        String[] input1 = {"5#7#2#4#","1#8#1#3","6#2#9#5","1#6#2#8"};
        String a = minimumCost(input1,input1.length);
        System.out.println(a);
    }
}