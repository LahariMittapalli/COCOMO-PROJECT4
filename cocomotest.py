import sys
class COCOMOTest:

    def __init__(self):
        self.arreffort = []
        self.arrtime = []
        self.arrpersons = []

    # Function to calculate parameters of Basic COCOMO
    def calculate(self, table, n, mode, size):
        effort,time,staff = 0.0, 0.0, 0.0

        # Check the mode according to size
        if(size>=2 and size<=50):
            model=0        # organic
        elif(size>50 and size<=300):
            model=1        # semi-detached
        elif(size>300):
            model=2        # embedded

        # print("The mode is ", mode[model])

        # Calculate Effort
        effort = table[model][0]*pow(size,table[model][1])
        # Calculate Time
        time = table[model][2]*pow(effort,table[model][3])
        # Calculate Persons Required
        staff = effort/time

        self.arreffort.append(effort)
        self.arrtime.append(time)
        self.arrpersons.append(staff)
        

    def main(self):
        table = [[2.4,1.05,2.5,0.38],[3.0,1.12,2.5,0.35],[3.6,1.20,2.5,0.32]]
        mode_list = ["Organic","Semi-Detached","Embedded"]
        numexperiment = 741
        for k in range(2,numexperiment):
            self.calculate(table,3,mode_list,k)

        effort = time = persons = toteffort = tottime = totpersons = 0
        maxeffort = maxtime = maxpersons = 0
        mineffort = mintime = minpersons = sys.float_info.max

        for i in range(numexperiment-2):
            effort = self.arreffort[i];
            time = self.arrtime[i];
            persons = self.arrpersons[i];
            
            if(effort > maxeffort):
                maxeffort = effort
            if(time > maxtime): 
                maxtime = time
            if(persons > maxpersons):
                maxpersons = persons
            
            if(effort < mineffort):
                    mineffort = effort
            if(time < mintime):
                    mintime = time
            if(persons < minpersons):
                    minpersons = persons
            
            toteffort += effort
            tottime += time
            totpersons += persons

        print(f"Effort: max = {maxeffort:.3f}, mean = {(toteffort / numexperiment):.3f}, min = {mineffort:.3f}")
        print(f"Time: max = {maxtime:.5f}, mean = {(tottime / numexperiment):.5f}, min = {mintime:.5f}")
        print(f"Persons: max = {round(maxpersons)}, mean = {round(totpersons / numexperiment)}, min = {round(minpersons)}")
		
if __name__ == "__main__":
    cocomotest = COCOMOTest()
    cocomotest.main()
