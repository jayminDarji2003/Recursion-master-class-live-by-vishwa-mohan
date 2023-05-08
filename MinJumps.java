/*
    Q. Min Jumps problem
*/

public class MinJumps {
    //method definition
    public static int minJumps(int arr[] , int start, int end){
        // base case
        if(start == end){
            return 0;
        }

        // when we are in 0 value
        if(arr[start] == 0){
            return Integer.MAX_VALUE;
        }

        // now i can jump, so i will all my jumping option
        int minJumps = Integer.MIN_VALUE;

        for(int i=start+1; i<=start+arr[start] && i<=end; i++){
            int jumps = minJumps(arr, i, end);

            if(jumps != Integer.MAX_VALUE && jumps+1 < minJumps){
                minJumps = jumps+1;
            }
        }

        return minJumps;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        System.out.println(minJumps(arr, 1, 7));
    }
}
