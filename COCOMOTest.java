import java.util.ArrayList;
import java.util.Random;

public class COCOMOTest {
	static ArrayList<Double> arrEffort = new ArrayList<Double>();
	static ArrayList<Double> arrTime = new ArrayList<Double>();
	static ArrayList<Double> arrPersons = new ArrayList<Double>();
		
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

//		System.out.println("The mode is " + mode[model]);

		// Calculate Effort
		effort = table[model][0] * (float) Math.pow(size, table[model][1]);

		// Calculate Time
		time = table[model][2] * (float) Math.pow(effort, table[model][3]);

		// Calculate Persons Required
		staff = effort / time;

		arrEffort.add((double) effort);
		arrTime.add((double) time);
		arrPersons.add((double) fround(staff));
	}

	public static void main(String[] args) {
		float table[][] = { { 2.4f, 1.05f, 2.5f, 0.38f }, { 3.0f, 1.12f, 2.5f, 0.35f }, { 3.6f, 1.20f, 2.5f, 0.32f } };
		String mode[] = { "Organic", "Semi-Detached", "Embedded" };
//			float size = 0.032f;

//		Random rand = new Random();
		// We use 741 as the upperbound since the graph in the paper only shows up to
		// 10,000 Person-Months (roughly size 741)
//		int upperbound = 741;
//		int int_random = 0;
		int numExperiment = 741;
		for (int i = 2; i < numExperiment; i++) {
//			int_random = rand.nextInt(upperbound);
			calculate(table, 3, mode, i);
		}
		
		double effort = 0, time = 0, persons = 0;
		double totEffort = 0, totTime = 0, totPersons = 0;
		double maxEffort = 0, maxTime = 0, maxPersons = 0;
		double minEffort = Double.MAX_VALUE, minTime = Double.MAX_VALUE, minPersons = Double.MAX_VALUE;	
		for(int i = 0; i<numExperiment-2; i++) {
			effort = arrEffort.get(i);
			time = arrTime.get(i);
			persons = arrPersons.get(i);
			
			if(effort > maxEffort) maxEffort = effort;
			if(time > maxTime) maxTime = time;
			if(persons > maxPersons) maxPersons = persons;
			
			if(effort < minEffort) minEffort = effort;
			if(time < minTime) minTime = time;
			if(persons < minPersons) minPersons = persons;
			
			totEffort += effort;
			totTime += time;
			totPersons += persons;
		}
		System.out.println("Effort: max = " + maxEffort + ", mean = " + totEffort / numExperiment + ", min = " + minEffort);
		System.out.println("Time: max = " + maxTime + ", mean = " + totTime / numExperiment + ", min = " + minTime);
		System.out.println("Persons: max = " + maxPersons + ", mean = " + totPersons / numExperiment + ", min = " + minPersons);
	}
}

