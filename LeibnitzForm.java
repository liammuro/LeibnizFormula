public class LeibnitzForm {
    public static float nextThingRec(float currentApprox, int lastOdd, boolean sign, int itersRem){
        if (itersRem == 0) {return currentApprox; }

        System.out.println(currentApprox);

        int tempSign = -1;
        lastOdd += 2;

        if (sign) { tempSign = 1; }

        currentApprox = currentApprox + (tempSign * (float)(4.0/lastOdd));
    
        return nextThingRec(currentApprox, lastOdd, !sign, itersRem-1);
    }
    public static float nextThingItr(int numIrts){

        float currentApprox = (float)4.0;
        int lastOdd = 1;
        int sign = 1;

        for (int i = 0; i < numIrts; i++) {
            sign *= -1;
            lastOdd += 2;

            currentApprox = currentApprox + (sign * (float)(4.0/lastOdd));
        }

        
        return currentApprox;
    }
    public static void main(String[] args) {
        // Recursive call results in stack overflow error w/ larger numbers
        // System.out.println(nextThingRec((4/1), 1, false, 10000000));

        // Iterative method has no issue w/ larger numbers
        System.out.println(nextThingItr(10000000));


    }
}
