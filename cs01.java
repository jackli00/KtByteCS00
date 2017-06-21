/**
 * Created by jli on 6/15/2017.
 */
public class cs01 {
    public static void main(String[] args) {
        cs01 ktb = new cs01();

        boolean bRet = false;

        int n = 7; //int n = nextInt();
        int[] array = {10, 1, 2, 3, 2, 1, 10}; //int[] array = new int[n];

        int iSize = array.length;
        int i = 0;
        boolean bContinue = true;
        int iCount = 0;

        if (n <= 1) bRet = true;

        while (bRet == false &
                (i < (int) (iSize / 2)) &&
                bContinue)

        {
            if (array[i] == array[iSize - 1 - i]) {
                if (i > 0) {
                    if (array[i] != array[i - 1]) {
                        iCount = iCount + 1;
                    } else
                        bContinue = false;
                } else
                    iCount++;

            }
            i++;
        }

        for (
                int j = 0;
                j < n; j++)

        {
            System.out.println(array[j]);
        }

        System.out.println(iCount);
    }


    //supporting functions
    static int maxNumber = 50;
    static int minNumber = 1;

    public static int nextInt() {
        int randomInt = (int) (Math.random() * maxNumber + minNumber);
        return randomInt;
    }

    public static double nextDouble() {
        double randomDouble = Math.random() * maxNumber + minNumber;
        return randomDouble;
    }

}
