import java.util.Arrays;

class Solution {
    int lend = 0;
    boolean[] isBorrower;
    boolean[] isLender;

    protected int solution(int n, int[] lost, int[] reserve) {
        /**
         * 총 학생 수 - (옷을 잃어버린 학생 수 - 옷 빌려받은 학생 수) = 수업에 참여할 수 있는 학생 수
         */
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int lostStudentsCount = lost.length;
        isBorrower = new boolean[n + 1];
        isLender = new boolean[n + 1];
        int reserveStudent;
        int lostStudent;

        for (int i = 0; i < reserve.length; i++) {
            reserveStudent = reserve[i];
            for (int j = 0; j < lost.length; j++) {
                lostStudent = lost[j];
                if (iLostToo(lostStudent, reserveStudent)) {
                    lend(lostStudent, reserveStudent);
                    break;
                }
            }
        }

        for (int i = 0; i < reserve.length; i++) {
            reserveStudent = reserve[i];
            for (int j = 0; j < lost.length; j++) {
                lostStudent = lost[j];
                System.out.println("lostStudent : " + lostStudent + " reserveStudent : " + reserveStudent);
                if (alreadyBorrowed(lostStudent, reserveStudent)) continue;
                if (isFrontNumberStudent(lostStudent, reserveStudent) || isBackNumberStudent(lostStudent, reserveStudent)) {
                    lend(lostStudent, reserveStudent);
                    break;
                }
            }
        }
        return n - (lostStudentsCount - lend);
    }

    private boolean alreadyBorrowed(int lostStudent, int reserveStudent) {
        return isBorrower[lostStudent] || isLender[reserveStudent];
    }

    private boolean isFrontNumberStudent(int lostStudent, int reserveStudent) {
        return lostStudent == reserveStudent - 1;
    }

    private boolean iLostToo(int nextLostStudent, int reserveStudent) {
        return nextLostStudent == reserveStudent;
    }

    private boolean isBackNumberStudent(int lostStudent, int reserveStudent) {
        return lostStudent == reserveStudent + 1;
    }

    private void lend(int lostStudent, int reserveStudent) {
        lend++;
        isBorrower[lostStudent] = true;
        isLender[reserveStudent] = true;
        System.out.println(Arrays.toString(isBorrower));
    }
}