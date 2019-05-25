# Dama
Trabalho de jogo de cartas sobre lista duplamente encadeada para a facul, segue a descrição:

O trabalho consiste num jogo que funciona da seguinte maneira: O jogo começa com 10 jogadores sentados numa roda, e um baralho no meio da roda contendo apenas as cartas 1, 3, 9 e 12 (que seria a Dama). 
Assuma um número ilimitado de cartas. A princípio o jogo segue no sentido horário e o primeiro jogador (qualquer um que você escolher na lista) começa o jogo tirando uma carta do baralho. Cada carta tem um significado, explicado abaixo:

1 – Pula o próximo jogador e passa a vez para o seguinte. 
3 – Elimina o terceiro jogador contado a partir do jogador atual. 
9 – Elimina o jogador anterior na roda. 
12 – Inverte o sentido do jogo.

Depois que é executado o que a carta tirada pede, o jogo segue passando a vez para o próximo jogador, no sentido em que estiver o jogo na rodada atual.

O jogo termina quando só restar apenas 1 jogador.

OBS: 
- As cartas selecionadas pelo jogador devem ter escolha aleatória e não ser digitada (SEM MOLEZA AGORA).
- Os jogadores devem ser dispostos na roda pelo nome (nó com string destinada ao nome do jogador; endereço para o próximo e anterior).
- A jogada inicia com a inserção dos jogadores (nome) na roda.
- Você pode alterar o jogo não fixando em 10 jogadores. Você pode solicitar o número de jogadores no início da partida. Porém, jogar com menos de 5 pessoas não tem graça.

DESAFIOS EXTRA:
- Implemente uma modificação do Jogo anterior incluindo uma carta (carta 0, que equivale ao As) que, caso o jogador a tire, fica impossibilitado de jogar por 3 rodadas. 
- Outra possibilidade é, caso o jogador tire a carta 13 (equivalente ao Rei), ele pode escolher quantos jogadores devem ser pulados para selecionar o novo jogador da rodada. Caso seja um jogador impedido de joga, pega-se o próximo no sentido atual da roda.
