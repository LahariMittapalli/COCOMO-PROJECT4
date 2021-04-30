from typing import List, Dict
from functools import reduce

class CocomoIntermediate:
    def __init__(self, table: List[List[float]], model: List[str], default_cost_drivers: Dict[str, List[float]]):
        self.table = table
        self.model = model
        self.cost_drivers = default_cost_drivers

    def find_model(self, size: int) -> int:
        if(size>=2 and size<=50):
            return 0
        elif(size>50 and size<=300):
            return 1
        elif(size>300):
            return 2

    def calculate_kloc(self, size, model_idx: int) -> float:
        return self.table[model_idx][0]*pow(size,self.table[model_idx][1])
    
    def lookup_norm_cd(self, category: str, rating: int) -> float:
        return self.cost_drivers[category][rating]
    
    def calculate_eaf(self, size: int, cost_drivers: Dict[str, float]) -> float:
        norm_cd = [self.lookup_norm_cd(key, value) for key, value in cost_drivers.items()]
        return reduce((lambda x, y: x * y), norm_cd)
        

    def calculate_effort(self, size: int, cost_drivers: Dict[str, float], print_condition: bool = True) -> float:
        model_idx = self.find_model(size)
        effort =  self.calculate_kloc(size, model_idx) * self.calculate_eaf(size, cost_drivers)
        if print_condition:
            print(f'Model = {self.model[model_idx]}')
            print(f'Effort = {effort:.3f} Person-Month')
        
        return effort
