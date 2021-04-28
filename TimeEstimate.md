COCOMO INTERMEDIATE MODEL TIME ESTIMATE:

Effort = (a(KLOC)^b)* EAF

where EAF is obtained by multiplying all the 15 values of the Cost Drivers.

The values of Cost Drivers agreed by our team are as follows:

**Product attributes**

Required software reliability= 1

Size of application database= 0.94

Complexity of the product= 0.85

**Hardware attributes**

Run-time performance constraints= 1

Memory constraints= 1

Volatility of the virtual machine environment= 1

Required turnabout time= 0.87

**Personnel attributes**

Analyst capability= 1

Applications experience= 1.13

Software engineer capability= 1

Virtual machine experience= 1

Programming language experience= 1

**Project attributes**

Application of software engineering methods= 1

Use of software tools= 1

Required development schedule= 1

**EAF**=1*0.94*0.85*1*1*1*0.87*1*1.13*1*1*1*1*1*1= **0.7854969** ~ **0.79** 

KLOC = 32 (from the c++ code given)

We agreed that our project is **Semi-Detached**, so a=2.4, b=1.05, c=2.5, d=0.38

E = (2.4*((2)^1.05))*0.79 = 2.0705298476828*2.4*0.79= **3.925722984 Person-Month**

**Time = (c*((E)^d))**

**Time** = 2.5*((3.925722984)^0.38) = 1.6814675909619*2.5= **4.20365 Months**

