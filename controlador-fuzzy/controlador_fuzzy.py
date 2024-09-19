# Ambiente utilizado:
# Ubuntu 22.04 LTS

# Dependências
#   Numpy - pip install numpy
#   skfuzzy - pip install scikit-fuzzy
#   Matplotlib - pip install matplotlib

import numpy as np
import skfuzzy as fuzz
from skfuzzy import control as ctrl
import matplotlib.pyplot as plt

# Variáveis de entrada
temperatura = ctrl.Antecedent(np.arange(0, 61, 1), 'temperatura')
umidade = ctrl.Antecedent(np.arange(0, 81, 1), 'umidade')

# Variável de saída
alerta = ctrl.Consequent(np.arange(0, 101, 1), 'alerta')

# Funções de pertinência para a temperatura
temperatura['frio'] = fuzz.trimf(temperatura.universe, [0, 0, 20])
temperatura['medio'] = fuzz.trimf(temperatura.universe, [10, 30, 50])
temperatura['quente'] = fuzz.trimf(temperatura.universe, [30, 60, 60])

# Funções de pertinência para a umidade
umidade['baixa'] = fuzz.trimf(umidade.universe, [0, 0, 20])
umidade['media'] = fuzz.trimf(umidade.universe, [10, 25, 50])
umidade['alta'] = fuzz.trimf(umidade.universe, [40, 80, 80])

# Funções de pertinência para o alerta
alerta['ruim'] = fuzz.trimf(alerta.universe, [0, 0, 30])
alerta['bom'] = fuzz.trimf(alerta.universe, [20, 35, 50])
alerta['otimo'] = fuzz.trimf(alerta.universe, [40, 100, 100])

# Regras fuzzy
regra1 = ctrl.Rule(temperatura['quente'] & umidade['alta'], alerta['ruim'])
regra2 = ctrl.Rule(temperatura['medio'] | umidade['media'], alerta['bom'])
regra3 = ctrl.Rule(temperatura['frio'] & umidade['baixa'], alerta['otimo'])

# Sistema de controle fuzzy
sistema_ctrl = ctrl.ControlSystem([regra1, regra2, regra3])
sistema = ctrl.ControlSystemSimulation(sistema_ctrl)

# Entrada de exemplo
sistema.input['temperatura'] = 40
sistema.input['umidade'] = 60

# Computação do sistema de controle fuzzy
sistema.compute()

# Visualizando Resultado
print(sistema.output['alerta'])

# Salvando o gráfico em um arquivo PNG
fig, ax = plt.subplots()
alerta.view(sim=sistema, ax=ax)
plt.savefig('saida_fuzzy.png')
plt.close()
