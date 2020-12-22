import java.util.Scanner;
/*
Given an integer array nums,
find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.
*/

public class maxSubArray {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int [] array =  new int[length];
        for (int i = 0; i <length ; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(subArray(array));
    }

    public static int subArray(int [] arr){
        int length = arr.length;
        if(length==0){
            return 0;
        }
        int sum = 0;
        int ans = arr[0];
        for(int num:arr){
            if(sum>0){
                sum+=num;
            }else{
                sum = num;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
/*
动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
*/