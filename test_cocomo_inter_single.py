from configparser import ConfigParser
from cocomo_inter import CocomoIntermediate

cfg = ConfigParser()
cfg.read('./cocomo_inter.cfg')

if __name__ == '__main__':
    default_cost_drivers = {key:eval(value) for key, value in cfg['CD'].items()}
    cocomo_inter = CocomoIntermediate(eval(cfg['INTER']['TABLE']),
                                eval(cfg['INTER']['MODEL_LIST']),
                                    default_cost_drivers)

    with open('./test_inter_single.csv' ,'r') as file:
        cocomo_single_values = [int(number) for number in file.readlines()[1].split(",")]

    user_cost_driver = {key: cocomo_single_values[i] for i, key in enumerate(default_cost_drivers.keys())}
    cocomo_inter.calculate_effort(4, user_cost_driver)
