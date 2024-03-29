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

- Fizemos algumas alterações ao excel fornecido pelos professores, CodeSmells.xlsx, uma vez que detetámos alguns erros de escrita nomeadamente na coluna com o nome dos métodos.
Estas alterações forma feitas com vista a conseguirmos testar o nosso painel de acerto.

- A classe Linha serve para representar um objeto onde cada um dos seus atributos representa uma coluna das presentes no ficheiro excel. Asiim conseguimos
trabalhar qualquer linha do ficheiro excel como sendo um objeto, sendo mais facil aceder a cada um dos campos da mesma.

- A classe Ficheiro serve para representar, em objeto, um ficheiro excel. Este tem como atributos uma String com indicação do nome do ficheiro
(esse nome tem de ter já incluída a extensão do ficheiro), e ainda uma Lista de objetos Linha que contém informação sobre todas as linhas do respetivo ficheiro excel.

- A classe LerFicheiro é utilizada pela classe Ficheiro e serve para que, baseados no nome do ficheiro excel, consigamos extrair para um Lista de objetos
Linha, toda a informação de linhas do ficheiro excel em questão.

- A classe EscreverMétricasParaExcel recebe um ArrayList que contém na sua primeira posição o nome do projeto sobre o qual queremos aplicar a extração de métricas
e contém, nas seguintes posições do ArrayList, Strings para o caminho de cada um dos ficheiros .java (classes) do projeto em questão. Esta classe estará assim
encarregue de criar um ficheiro excel que será nomeado com o nome do projeto, e está ainda encarregue de extrair as métricas das classes do projeto e dos métodos
dessas mesmas classes escrevendo depois toda essa informação no excel. Existem métodos que extraiem a informação a ser colocada em cada coluna do excel, guardando
essa informação em ArrayLists. Ou seja, teremos um ArrayList para colecionar a informação a colocar em cada coluna do ficheiro. Estes ArrayList serão depois
percorridos, posição a posição, conforme formos escrevendo em cada linha do excel.

- A classe Regra serve para representar, em objeto, uma regra. Os atributos representam as características de uma regra criada pelo utilizador. O nome, a expressão com as métricas e valores, o valor boolean que estará visível caso se verifique a expressão da regra e o tipo da regra que indica se é para o code smell Long Method ou God Class.

- A classe CodeSmellMetodo representa uma linha do ficheiro CodeSmells.xlsx, que contém o pacote, classe e metodo numa string e os valores boolean que se encontram nas colunas is_Long_Method e is_God_Class para comparação com os valores nas mesmas colunas do ficheiro excel criado a partir do projeto escolhido.

- A classe VerificacaoCodeSmells serve para que, após criado o excel com as métricas para um determinado projeto escolhido, possamos fazer a verificação dos code smells ,Long Method e God Class, para cada método existente e colocar nas colunas is_Long_Method e is_God_Class o valor true ou false conforme se verifique ou não a existência do mesmo. Serve também esta classe para verificar os verdadeiros positivos, falsos positivos, verdadeiros negativos e falsos negativos em comparação com o ficheiro CodeSmells.xlsx.

- A classe Interface contém a GUI com todos os elementos necessários para:
  - a criação das regras e alteração das mesmas, tanto para o code smell Long Method como God Class;
  - a opção para escolher o diretório onde se encontra o projeto;
  - criar e visualizar o ficheiro excel com os valores das métricas;
  - escolher as regras para cada code smell e aplicá-las ao ficheiro, com a visualização do efeito das mesmas;
  - painel com as estatísticas sobre os pacotes, classes, métodos e linhas de código do projeto;
  - painel com os verdadeiros positivos, falsos positivos, verdadeiros negativos e falsos negativos.
  
  - Esta classe contém também:
    - a funcionalidade de carregar as regras que se encontrem no ficheiro se este já existir;
    - quando a janela é fechada as regras são todas guardadas num ficheiro .txt;
    - tem métodos que servem para auxiliar nas funcionalidades especificadas acima.
