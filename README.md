# ES-2Sem-2021-Grupo-42

## Identificação dos Elementos do Grupo

### Grupo 42

- Daniela Pedroso - Nº 87279 [Github Pessoal](https://github.com/danielapedroso)
- David Gabriel - Nº 87506 [Github Pessoal](https://github.com/davidlgabriel)
- Diogo Vale - Nº 87751 [Github Pessoal](https://github.com/diogo4vale)
- Francisco Pinto - Nº 87944 [Github Pessoal](https://github.com/FranciscoPinto12)
- Maria Carolina Pereira - Nº 87604 [Github Pessoal](https://github.com/mcarolinap)
- Rodrigo da Silva Corchana - Nº 88825 [Github Pessoal](https://github.com/rodrigo-67)

## Considerações relativamente à extração de métricas

- Para o LOC_Class considerou-se que a contabilização de linhas de uma classe começa na linha com a nomeclatura "class", ou seja,
são ignoradas linhas acima como por exemplo, linhas de imports e de indicação de package. Se existirem linhas a vazio no final
da classe (após a última chaveta), estas também não serão contabilizadas. Serão consideradas linhas de comentários e em branco que
estejam entre a linha inicial com a nomeclatura "class" e a última chaveta da classe.

- Para o LOC_Method considerou-se que a contabilização de linhas de um método começa na primeira linha do método em questão e termina
na última chaveta desse mesmo método. Entre estes dois "delimitadores" serão contabilizadas, também, linhas de comentários e em branco.

- Para o NOM_Class serão contabilizados todos os métodos de uma classe incluindo os seus contrutores.

- Segundo a nossa implemetação, se existirem classes internas, estas irão assumir como nome o nome da classe mãe.

## Considerações relativamente à utilização da Interface

- Se for utilizada a opção de "IS BETWEEN", o segundo campo para inserção de valores não pode ter um valor inferior ou igual ao primeiro campo de inserção.
- Nestes campos referidos anteriormente não podem ser inseridas letras nem espaços.
- Não pode ser criada uma nova regra com um nome igual a uma regra já existente.
- Ao ser selecionada uma regra da lista, poderão ser alterados os parâmetros da mesma.


## Outras Notas/Considerações

- Fizemos algumas alterações ao excel fornecido pelos professores uma vez que detetámos alguns erros de escrita nomeadamente na coluna com o nome dos métodos.
Estas alterações forma feitas com vista a conseguirmos testar o nosso painel de acerto.
