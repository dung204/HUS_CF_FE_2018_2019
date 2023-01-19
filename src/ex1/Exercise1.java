package ex1;

import java.util.Scanner;

public class Exercise1 {
	public static void solve() {
		System.out.println("Exercise 1:");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = createArray(n);
		double x = in.nextDouble();
		System.out.println(calculate(arr, x));
		System.out.println("----------------------------------------");
	}

	public static int[] createArray(int numberOfElements) {
		Scanner in = new Scanner(System.in);
		int[] arr = new int[numberOfElements];
		for (int i = 0; i < numberOfElements; i++) {
			arr[i] = in.nextInt();
		}
		return arr;
	}

	public static double calculate(int[] arr, double x) {
		double sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += Math.pow(-1, i) * arr[i] * Math.pow(x, 2*i);
		}

		return sum;
	}
}
