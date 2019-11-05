import numpy as np
import matplotlib.pyplot as plt


x= []
y= []

dataset = open ('medias.txt', 'r')

for linha in dataset:
    linha = linha.strip()
    X, Y = linha.split(':')
    x.append(float(X))
    y.append(float(Y))

dataset.close()

plt.grid(True )
plt.plot(x,y,label = "Selection Sort")
plt.legend()

plt.title('Médias de Tempo em Função da Quantidade')
plt.xlabel('Quantidade de Amostras')
plt.ylabel('Tempo')

fig= plt.gcf()
plt.show()
fig.savefig('gráfico.png', format ='png')
