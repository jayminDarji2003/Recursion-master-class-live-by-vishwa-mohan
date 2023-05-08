/*
    Q :- Tower of hanoi problem
*/

public class TowerOfHanoi {
    // count steps(moves) fnx
    public static int moves(int n,char s, char d, char a){
        // termination condition (base case)
        if(n==1 || n==0){
            return n;
        }

        int step1 = moves(n-1, s, a, d);
        int step2 = 1; //move the big coin from S to D
        int step3 = moves(n-1, a, d, s);

        return step1 + step2 + step3;
    }

    public static void main(String[] args) {
        System.out.println(moves(5,'S','D','A'));
    }
}