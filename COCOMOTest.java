import java.util.ArrayList;
import java.util.Random;

public class COCOMOTest {
	static ArrayList<Double> arrEffort = new ArrayList<Double>();
	static ArrayList<Double> arrTime = new ArrayList<Double>();
	static ArrayList<Double> arrPersons = new ArrayList<Double>();
	static Random rand = new Random();
	
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

		// Check the mode according to size
		if (size >= 2 && size <= 50)
			model = 0; // organic
		else if (size > 50 && size <= 300)
			model = 1; // semi-detached
		else if (size > 300)
			model = 2; // embedded


		if (model == 0) {
			effort = table[model][0] * (float) Math.pow(size, table[model][1]);
			time = table[model][2] * (float) Math.pow(effort, table[model][3]);
			staff = effort / time;
		}
		else if (model == 1) {
			double EAF = 1;
			
			int x = rand.nextInt(5);
			if (x == 0) EAF *= 0.75;
			else if (x == 1) EAF *= 0.88;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 1.15;
			else if (x == 4) EAF *= 1.4;
			x = rand.nextInt(4);
			if (x == 0) EAF *= 0.94;
			else if (x == 1) EAF *= 1;
			else if (x == 2) EAF *= 1.08;
			else if (x == 3) EAF *= 1.16;
			x = rand.nextInt(6);
			if (x == 0) EAF *= 0.7;
			else if (x == 1) EAF *= 0.85;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 1.15;
			else if (x == 4) EAF *= 1.3;
			else if (x == 5) EAF *= 1.65;
			x = rand.nextInt(4);
			if (x == 0) EAF *= 1;
			else if (x == 1) EAF *= 1.11;
			else if (x == 2) EAF *= 1.3;
			else if (x == 3) EAF *= 1.66;
			x = rand.nextInt(4);
			if (x == 0) EAF *= 1;
			else if (x == 1) EAF *= 1.06;
			else if (x == 2) EAF *= 1.21;
			else if (x == 3) EAF *= 1.56;
			x = rand.nextInt(4);
			if (x == 0) EAF *= 0.87;
			else if (x == 1) EAF *= 1;
			else if (x == 2) EAF *= 1.15;
			else if (x == 3) EAF *= 1.3;
			x = rand.nextInt(4);
			if (x == 0) EAF *= 0.87;
			else if (x == 1) EAF *= 1;
			else if (x == 2) EAF *= 1.07;
			else if (x == 3) EAF *= 1.15;
			x = rand.nextInt(5);
			if (x == 0) EAF *= 1.46;
			else if (x == 1) EAF *= 1.19;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 0.86;
			else if (x == 4) EAF *= 0.71;
			x = rand.nextInt(5);
			if (x == 0) EAF *= 1.29;
			else if (x == 1) EAF *= 1.13;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 0.91;
			else if (x == 4) EAF *= 0.82;
			x = rand.nextInt(5);
			if (x == 0) EAF *= 1.42;
			else if (x == 1) EAF *= 1.17;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 0.86;
			else if (x == 4) EAF *= 0.70;
			x = rand.nextInt(4);
			if (x == 0) EAF *= 1.21;
			else if (x == 1) EAF *= 1.1;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 0.9;
			x = rand.nextInt(4);
			if (x == 0) EAF *= 1.14;
			else if (x == 1) EAF *= 1.07;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 0.95;
			x = rand.nextInt(5);
			if (x == 0) EAF *= 1.24;
			else if (x == 1) EAF *= 1.1;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 0.91;
			else if (x == 4) EAF *= 0.82;
			x = rand.nextInt(5);
			if (x == 0) EAF *= 1.24;
			else if (x == 1) EAF *= 1.1;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 0.91;
			else if (x == 4) EAF *= 0.83;
			x = rand.nextInt(5);
			if (x == 0) EAF *= 1.23;
			else if (x == 1) EAF *= 1.08;
			else if (x == 2) EAF *= 1;
			else if (x == 3) EAF *= 1.04;
			else if (x == 4) EAF *= 1.10;
			
			effort = (table[model][0] * (float) Math.pow(size, table[model][1])) * (float)EAF;
			time = table[model][2] * (float) Math.pow(effort, table[model][3]);
			staff = effort / time;
		}
		else if (model == 2) {
			System.out.println("We have not implemented the Embeded version.");
			return;
		}
		arrEffort.add((double) effort);
		arrTime.add((double) time);
		arrPersons.add((double) fround(staff));
	}

	public static void main(String[] args) {
		float table[][] = { { 2.4f, 1.05f, 2.5f, 0.38f }, { 3.0f, 1.12f, 2.5f, 0.35f }, { 3.6f, 1.20f, 2.5f, 0.32f } };
		String mode[] = { "Organic", "Semi-Detached", "Embedded" };

		// We use 741 as the upperbound since the graph in the paper only shows up to
		// 10,000 Person-Months (roughly size 741)
		int upperbound = 300 - 2;
		int int_random = 2;
		int numExperiment = 20000;
		for (int i = 0; i < numExperiment; i++) {
			int_random = rand.nextInt(upperbound) ;
			calculate(table, 3, mode, int_random + 2);
		}
		
		double effort = 0, time = 0, persons = 0;
		double totEffort = 0, totTime = 0, totPersons = 0;
		double maxEffort = 0, maxTime = 0, maxPersons = 0;
		double minEffort = Double.MAX_VALUE, minTime = Double.MAX_VALUE, minPersons = Double.MAX_VALUE;	
		for(int i = 0; i<numExperiment; i++) {
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
		System.out.println("Effort: max = " + maxEffort + ", mean = " + totEffort / arrEffort.size() + ", min = " + minEffort);
		System.out.println("Time: max = " + maxTime + ", mean = " + totTime / arrTime.size() + ", min = " + minTime);
		System.out.println("Persons: max = " + maxPersons + ", mean = " + totPersons / arrPersons.size() + ", min = " + minPersons);
	}
}
