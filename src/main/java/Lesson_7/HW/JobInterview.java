package Lesson_7.HW;

public class JobInterview {
    public static void main(String[] args) {
        int raz = 4;
        int strok = 0;
        int stolb = 0;
        int increm = 0;
        int i = 0;
        int mass[][] = new int[raz][raz];
        for (int z = 0; i < raz * raz - 1; z++) {

            for (int j = 0; j < raz - increm; j++) {
                mass[strok][stolb++] = ++i;
            }
            stolb--;
            ++increm;

            for (int k = 0; k < raz - increm; k++) {
                mass[++strok][stolb] = ++i;
            }

            for (int l = 0; l < raz - increm; l++) {
                mass[strok][--stolb] = ++i;
            }
            ++increm;

            for (int m = 0; m < raz - increm; m++) {
                mass[--strok][stolb] = ++i;
            }
            stolb++;
        }

        for (int d = 0; d < raz; d++) {
            for (int s = 0; s < raz; s++) {
                System.out.print(mass[d][s] + "\t");
            }
            System.out.println();
        }
    }
}
