package chapter03;

import java.security.MessageDigest;

public class LabelsClass {
    public static void main(String[] args) {
        OUTER_LOOP:
        for (int i = 0; i < 3; i++) {
            MEDDLE_LOOP:
            for (int k = 0; k < 4; k++) {
                System.out.println("Loop externo: i=" + i + ", k=" + k);

                INNER_LOOP:
                for (int j = 0; j < 4; j++) {
                    if (i == 2 && j > 1) {
                        System.out.println("Breaking out of the inner loop at i=2, j=2");
                        break INNER_LOOP; // Breaks out of the outer loop
                    }
                    if (j == 3) {
                        System.out.println("Continuing to the next iteration of the outer loop at i=1, j=1");
                        continue OUTER_LOOP; // Continues to the next iteration of the outer loop
                    }
                    if (k == 2) {
                        System.out.println("Continuing to the next iteration of the outer loop at i=1, j=1");
                        continue MEDDLE_LOOP; // Continues to the next iteration of the outer loop
                    }
                    if (k ==3) {
                        System.out.println("Returning");
                        return;
                    }
                    System.out.println("fim do loop interno");
                }
            }
            System.out.println("fim do loop externo");
        }
    }
}
