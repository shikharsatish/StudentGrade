package com.innovect.git;

public class StudentUtil {

  public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
    int sum=0, count = 1;
    double avg = 0;
    double[] gpa=new double[studentIdList.length];
    for (int i = 0; i < studentsGrades.length; i++) {
      for (int j = 0; j < studentsGrades[i].length; j++) {
        if (studentsGrades[i][j] == 'A') {
          sum += 4;
        } else if (studentsGrades[i][j] == 'B') {
          sum += 3;
        } else if (studentsGrades[i][j] == 'C') {
          sum += 2;
        }
      }
      avg=(double) sum/studentsGrades[i].length;
      gpa[i]=avg;
      sum=0;
    }
//    for (int i = 0; i < studentsGrades.length; i++) {
   /*   for (int j = 0; j < i; j++) {
        sum = sum + studentsGrades[i][j];
        count++;
      }
    }*/
    // avg = sum / count;

    return gpa;
  }

  public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
    // perform parameter validation. Return null if passed parameters are not valid
    if (lower < 0 && higher < 0 && lower > higher) {
      return null;
    }
    else {
      double gpa[] = calculateGPA(studentIdList, studentsGrades);
      int arr[] = new int[studentIdList.length];
      for (int i = 0; i < studentIdList.length; i++) {
        if (lower <= gpa[i] && gpa[i] <= higher) {
          arr[i] = studentIdList[i];
        }
      }
      // invoke calculateGPA
      return arr;
    }
    // construct the result array and return it. You would need an extra for loop to compute the size of the resulting array
  }

  public static void main(String[] args) {
    int[] studentIdList = new int[]{1001, 1002};
    char[][] studentGrades = new char[][]{{'A', 'A', 'A', 'B'}, {'A', 'A', 'B'}};
    int[] a = getStudentsByGPA(3.2, 4.5, studentIdList, studentGrades);
    for (int i = 0; i < studentIdList.length; i++) {
      System.out.println("GPA: " +a[i]);
    }
  }
}
