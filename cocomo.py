#%%
print('hello world')
# %%
import math
  
# Function for rounding off float to int
def fround(x):
    x=x+0.5
    a=x
    return a
 # %% 
 # Function to calculate parameters of Basic COCOMO
def calculate(table, n, mode, size):
    effort,time,staff = 0.0, 0.0, 0.0

    # Check the mode according to size
    if(size>=2 and size<=50):
        model=0        # organic
    elif(size>50 and size<=300):
        model=1        # semi-detached
    elif(size>300):
        model=2        # embedded
  
    print("The mode is ", mode[model])
  
    # Calculate Effort
    effort = table[model][0]*pow(size,table[model][1])

    # Calculate Time
    time = table[model][2]*pow(effort,table[model][3])
    
    # Calculate Persons Required
    staff = effort/time
  
    # Output the values calculated
    print(f"Effort = {effort:.2f} Person-Month")
    print("Development Time =", time, " Months")
    print("Average Staff Required =", fround(staff), " Persons")
# %%
def main():
    in_list = [2.4,1.05,2.5,0.38,3.0,1.12,2.5,0.35,3.6,1.20,2.5,0.32]
    mode_list = ["Organic","Semi-Detached","Embedded"]
    size = 4
    table = []
    l = 0
    for i in range(3):
        array = []
        for j in range(size):
            array.append(in_list[l])
            l = l + 1
        table.append(array)
    calculate(table,3,mode_list,size)
    return 0
# %%
if __name__ == "__main__":
    main()
# %%
