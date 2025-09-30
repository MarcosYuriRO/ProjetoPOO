# 🎮 Atributos Principais (Classe Jogo)

----

## Guia para Moisés e Gabares
Este guia é para ajudar vocês a estruturar a classe Jogo, qualquer coisa chamem ❤️

------

## Como prosseguir com o _timer_ ⏱️

- **saldo (int):** Nosso recurso principal. *Acumula o dinheiro que é ganho.* 💵


- **acertos e erros (int):** *Contadores que serão zerados a cada novo dia, mas usados para calcular o pagamento do dia.* ✅/❌


- **diaAtual (int):** *Usar um int para contar de 1 a 10 e um LocalDate para o carimbo de data.* ☁️


- **dataAtual (LocalDate):** *O carimbo de data que avançará a cada dia e será usado para checar a validade dos documentos.* 📅

- **tempoLimite (long):** *Guarda o valor de 60.000 (60 segundos da vida real)* 📅

--------
## _Regras_ a serem mantidas 📝
- ### Constantes
    - **META_DINHEIRO (final int):** *Valor a ser arrecadado ($1500).*
    - **PAGAMENTO_POR_ACERTO (final int):** *Valor pago por acerto ($50).*
    - **CUSTO_POR_ERRO (final int):** *Valor de custo por cada erro cometido ($80).*
    - **CUSTO_DIARIO_FIXO (final int):** *Valor a ser pago todos os dias como luz, água, comida e aluguel ($100).*



-------------
## Como prosseguir com a _lógica_ 🧠

A classe Jogo precisa uns 4/5 métodos, aí vocês podem ver o que fazem e como prosseguem.

----

- ### Método _iniciarDia()_ (Ciclo de 60s)
Esse método vai lidar com a parte principal do tempo com o loop **do-while**

- ***tempoLimite*** -- hora atual + 60.000ms;


- ***while (System.currentTimeMillis() < tempoLimite)*** -- System.currentTimeMillis() mostra o tempo atual em milissegundos pra rodar um dia de jogo;


- ***proximoImigrante()*** -- dentro do loop, chamar esse método garante que tenhamos um imigrante assim que a analise do anterior for concluida;


- ***tempoRestanteMS*** -- calcula o tempo que resta, de 10s em 10s pra não ficar demais;


- ***finalizarDia()*** -- quando o do-while acabar, chamar esse método para fechar o dia.

--------------------

- ### Método _proximoImigrante()_
Principal parte para a interação do jogador, lida com a netrada do usuário e inspeciona oq foi dito/escolhido

- ***geradorDeImigrantes.gerarImigranteAleatorio()*** -- para obter o imigrante;


- ***decisaoCorreta*** -- a verdade do sistema (pode ser um random de true ou false);


- ***while*** -- dentro desse loop teremos um menu, pensei em fazer ele com um switch case, ai cada case é [A]Aceitar, [R]Rejeitar, [I]Identidade e [P]Passaporte (Aceitar seria true, Rejeitar seria false, e inspecionar os docs é só usar o método que cuida inspeção juntamente de cada doc);


- ***decisaoJogador*** -- Acerto adiciona PAGAMENTO_POR_ACERTO ao saldo e incrementa os acertos. Erro vem dps.

--------------------

- ### Método _finalizarDia()_
Principal parte para a interação do jogador, lida com a netrada do usuário e inspeciona oq foi dito/escolhido

- ***penalidadeTotal(erros * CUSTO_POR_ERRO) - saldo*** -- Erro incrementa os erros e desconta do saldo;


- ***saldo - CUSTO_DIARIO_FIXO*** -- subtrai o custo diario do saldo;


- ***System.out.println(acertos, erros, saldo)*** -- dserve pra mostrar o que tivemos de acerto/ganhos, de erros/perdas, quanto que falta pra meta e o saldo atual;


- ***avancarProximoDia()*** -- tentar compararr o saldo com a meta para saber se já chegamos lá, pq dai encerraria automaticamente. tentar ver se o dia tual é igual à quantidade de dias máximos (10 dias) e iterar o dia atual tipo: "diaAtual++" ou "diaAtual = diaAtual.plusDay(1)" e usar um iniciarDia() ou algo assim;

----------------------

- ### Método _avancarProximoDia()_
Aqui controlamos basicamente td

- ***if (saldo >= META_DINHEIRO)*** -- gg fml;


- ***if (diaAtual >= DIAS_MAXIMOS)*** -- perdeu, se o dia atual for 11, acabou o tempo do usuario e usar um finalizarJogo(false);


- ***diaAtual++; dataAtual = dataAtual.plusDay(1) e iniciarDia()*** -- dserve pra mostrar o que tivemos de acerto/ganhos, de erros/perdas, quanto que falta pra meta e o saldo atual;


- ***avancarProximoDia()*** -- tentar compararr o saldo com a meta para saber se já chegamos lá, pq dai encerraria automaticamente. tentar ver se o dia tual é igual à quantidade de dias máximos (10 dias) e iterar o dia atual tipo: "diaAtual++" ou "diaAtual = diaAtual.plusDay(1)" e usar um iniciarDia() ou algo assim;

----------------------

- ### Método _finalizarJogo()_
Aqui fechamo

- ***if (vitoria)*** -- ganhou, sout com vitoria e um "vc atingiu sua meta e um vc salvou sua mãe";


- ***else*** -- perdeu, sout com uma mensagem de gameover e o seu saldo final;


------------

# O.B.S.:
Só coloquei umas ideias que testei aqui, mas não consegui terminar, então confio em vcs pra issooo.
Precisamos terminar os métodos (proximoImigrante(), finalizarDia(), avancarProximoDia(), finalizarJogo()), adicionar alguns textos de dialogos e tambem o sistema de dinheiro(ganhar ou perder de acordo com seu desempenho do dia).