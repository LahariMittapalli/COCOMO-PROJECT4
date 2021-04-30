import java.util.Scanner;

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
		float effort = 0f, time = 0f, staff = 0f;
		int model = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.print("Program size (Kilo Lines Of Code - KLOC): ");
		String SIZE = in.nextLine();
		size = Integer.valueOf(SIZE);		

		// Check the mode according to size
		if (size >= 2 && size <= 50)
			model = 0; // organic
		else if (size > 50 && size <= 300)
			model = 1; // semi-detached
		else if (size > 300)
			model = 2; // embedded

		System.out.println("\nThe mode is " + mode[model]);

		if (model == 0) {
			// Calculate Effort
			effort = table[model][0] * (float) Math.pow(size, table[model][1]);
			// Calculate Time
			time = table[model][2] * (float) Math.pow(effort, table[model][3]);
			// Calculate Persons Required
			staff = effort / time;
		}
		else if (model == 1) {
			double EAF = 1;
			System.out.print("Required software reliability (Very Low (0), Low(1), Nominal(2), High(3), Very High(4)): ");
			String RELY = in.nextLine();
			System.out.print("Database size (Low(0), Nominal(1), High(2), Very High(3)): ");
			String DATA = in.nextLine();
			System.out.print("Product complexity (Very Low (0), Low(1), Nominal(2), High(3), Very High(4), Extra High(5)): ");
			String CPLX = in.nextLine();
			System.out.print("Execution time constraint (Nominal(0), High(1), Very High(2), Extra High(3)): ");
			String TIME = in.nextLine();
			System.out.print("Main storage constraint (Nominal(0), High(1), Very High(2), Extra High(3)): ");
			String STOR = in.nextLine();
			System.out.print("Virtual machine volatility (Low(0), Nominal(1), High(2), Very High(3)): ");
			String VIRT = in.nextLine();
			System.out.print("Computer turnaround time (Low(0), Nominal(1), High(2), Very High(3)): ");
			String TURN = in.nextLine();
			System.out.print("Analyst capability (Very Low (0), Low(1), Nominal(2), High(3), Very High(4)): ");
			String ACAP = in.nextLine();
			System.out.print("Applications experience (Very Low (0), Low(1), Nominal(2), High(3), Very High(4)): ");
			String AEXP = in.nextLine();
			System.out.print("Programmer capability (Very Low (0), Low(1), Nominal(2), High(3), Very High(4)): ");
			String PCAP = in.nextLine();
			System.out.print("Virtual machine experience (Very Low (0), Low(1), Nominal(2), High(3)): ");
			String VEXP = in.nextLine();
			System.out.print("Programming language experience (Very Low (0), Low(1), Nominal(2), High(3)): ");
			String LEXP = in.nextLine();
			System.out.print("Use of modern programming practices (Very Low (0), Low(1), Nominal(2), High(3), Very High(4)): ");
			String MODP = in.nextLine();
			System.out.print("Use of software tools (Very Low (0), Low(1), Nominal(2), High(3), Very High(4)): ");
			String TOOL = in.nextLine();
			System.out.print("Required development schedule (Very Low (0), Low(1), Nominal(2), High(3), Very High(4)): ");
			String SCED = in.nextLine();
			
			int x = Integer.parseInt(RELY);
			if (x == 0) EAF *= 0.75;
			else if (x == 1) EAF *= 0.88;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 1.15;
			else if (x == 4) EAF *= 1.4;
			x = Integer.parseInt(DATA);
			if (x == 0) EAF *= 0.94;
			else if (x == 1) EAF *= 1;
			else if (x == 2) EAF *= 1.08;
			else if (x == 3) EAF *= 1.16;
			x = Integer.parseInt(CPLX);
			if (x == 0) EAF *= 0.7;
			else if (x == 1) EAF *= 0.85;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 1.15;
			else if (x == 4) EAF *= 1.3;
			else if (x == 5) EAF *= 1.65;
			x = Integer.parseInt(TIME);
			if (x == 0) EAF *= 1;
			else if (x == 1) EAF *= 1.11;
			else if (x == 2) EAF *= 1.3;
			else if (x == 3) EAF *= 1.66;
			x = Integer.parseInt(STOR);
			if (x == 0) EAF *= 1;
			else if (x == 1) EAF *= 1.06;
			else if (x == 2) EAF *= 1.21;
			else if (x == 3) EAF *= 1.56;
			x = Integer.parseInt(VIRT);
			if (x == 0) EAF *= 0.87;
			else if (x == 1) EAF *= 1;
			else if (x == 2) EAF *= 1.15;
			else if (x == 3) EAF *= 1.3;
			x = Integer.parseInt(TURN);
			if (x == 0) EAF *= 0.87;
			else if (x == 1) EAF *= 1;
			else if (x == 2) EAF *= 1.07;
			else if (x == 3) EAF *= 1.15;
			x = Integer.parseInt(ACAP);
			if (x == 0) EAF *= 1.46;
			else if (x == 1) EAF *= 1.19;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 0.86;
			else if (x == 4) EAF *= 0.71;
			x = Integer.parseInt(AEXP);
			if (x == 0) EAF *= 1.29;
			else if (x == 1) EAF *= 1.13;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 0.91;
			else if (x == 4) EAF *= 0.82;
			x = Integer.parseInt(PCAP);
			if (x == 0) EAF *= 1.42;
			else if (x == 1) EAF *= 1.17;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 0.86;
			else if (x == 4) EAF *= 0.70;
			x = Integer.parseInt(VEXP);
			if (x == 0) EAF *= 1.21;
			else if (x == 1) EAF *= 1.1;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 0.9;
			x = Integer.parseInt(LEXP);
			if (x == 0) EAF *= 1.14;
			else if (x == 1) EAF *= 1.07;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 0.95;
			x = Integer.parseInt(MODP);
			if (x == 0) EAF *= 1.24;
			else if (x == 1) EAF *= 1.1;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 0.91;
			else if (x == 4) EAF *= 0.82;
			x = Integer.parseInt(TOOL);
			if (x == 0) EAF *= 1.24;
			else if (x == 1) EAF *= 1.1;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 0.91;
			else if (x == 4) EAF *= 0.83;
			x = Integer.parseInt(SCED);
			if (x == 0) EAF *= 1.23;
			else if (x == 1) EAF *= 1.08;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 1.04;
			else if (x == 4) EAF *= 1.10;
			
			effort = (table[model][0] * (float) Math.pow(size, table[model][1])) * (float)EAF;
			time = table[model][2] * (float) Math.pow(effort, table[model][3]);
			staff = effort / time;
		}

		// Output the values calculated
		System.out.println("\nEffort = " + effort + " Person-Month");
		System.out.println("Development Time = " + time + " Months");
		System.out.println("Average Staff Required = " + fround(staff) + " Persons");
		
		in.close();
	}

	public static void main(String[] args) {
		float table[][] = { { 2.4f, 1.05f, 2.5f, 0.38f }, { 3.0f, 1.12f, 2.5f, 0.35f }, { 3.6f, 1.20f, 2.5f, 0.32f } };
		String mode[] = { "Organic", "Semi-Detached", "Embedded" };
		float size = 2;
		calculate(table, 3, mode, size);
	}

}
