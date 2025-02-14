package reverseInteger;

public class Question {
  public static int reverse(int number) {

    StringBuilder numString = new StringBuilder(Integer.toString(number));

    String reversedString = numString.reverse().toString();

    int reversedNumber = Integer.parseInt(reversedString);

    return reversedNumber;
  }

  public static void main(String[] args) {
    int number = 12345;
    int reversedNumber = reverse(number);
    System.out.println("Original number: " + number);
    System.out.println("Reversed number: " + reversedNumber);
  }
}

