
public class COCOMO {
	// Function for rounding off float to int
	static int fround(float x) {
		int a;
		x = x + 0.5f;
		a = (int) x;
		return (a);
	}

	// Function to calculate parameters of Basic COCOMO
	static void calculate(float table[][], int n, String[] mode, float size) {
		float effort, time, staff;
		int model = 0;

		// Check the mode according to size
		if (size >= 2 && size <= 50)
			model = 0; // organic

		else if (size > 50 && size <= 300)
			model = 1; // semi-detached

		else if (size > 300)
			model = 2; // embedded

		System.out.println("The mode is " + mode[model]);

		// Calculate Effort
		effort = table[model][0] * (float) Math.pow(size, table[model][1]);

		// Calculate Time
		time = table[model][2] * (float) Math.pow(effort, table[model][3]);

		// Calculate Persons Required
		staff = effort / time;

		// Output the values calculated
		System.out.println("Effort = " + effort + " Person-Month");
		System.out.println("Development Time = " + time + " Months");
		System.out.println("Average Staff Required = " + fround(staff) + " Persons");

	}

	public static void main(String[] args) {
		float table[][] = { { 2.4f, 1.05f, 2.5f, 0.38f }, { 3.0f, 1.12f, 2.5f, 0.35f }, { 3.6f, 1.20f, 2.5f, 0.32f } };
		String mode[] = { "Organic", "Semi-Detached", "Embedded" };
		float size = 1;

		calculate(table, 3, mode, size);

	}
}
