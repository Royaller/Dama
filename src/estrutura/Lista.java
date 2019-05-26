package estrutura;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Lista {
		
	private JogoDeCartas inicio;
	
	public Lista() {
		this.inicio = null;
	}
	
     //Método para verificar se está vazia
	public boolean isEmpty() {
		return (this.inicio == null);
	}
	
	//Método para verificar se resta apenas um elemento na lista
	public boolean resta1() {
		JogoDeCartas tmp, tmp2;
		tmp = inicio;
		tmp2 = tmp.getProximo();	
		return(tmp.getElemento() == tmp2.getElemento());		
	}

	//Método para inserir elemento na lista
	public void inserirJogador(Object elemento) {
		JogoDeCartas novo = new JogoDeCartas();
		novo.setElemento(elemento);
		novo.setBanido(0);
		
		//Caso especial em que a lista está vazia e ambos anterior e próximo apontam o próprio elemento
		if(isEmpty()) {
			novo.setAnterior(novo);
			novo.setProximo(novo);
			inicio = novo;
		}else {
			
       JogoDeCartas tmp = inicio;
       while(tmp.getProximo() != inicio) {
    	   tmp = tmp.getProximo();
       }
       inicio.setAnterior(novo);
       tmp.setProximo(novo);
       novo.setAnterior(tmp);
       novo.setProximo(inicio);
			
		}
		
	}
	
	//Método para remover elemento
	public void removerJogador(Object elemento) {
		
		JogoDeCartas tmp, tmp_ant, tmp_pro;
		tmp = inicio;
		
		do {
		
		if(tmp.getElemento() == elemento) {
		
			if(inicio.getElemento() == elemento) {
 			inicio = inicio.getProximo();
			}
					
			tmp_ant = tmp.getAnterior();
			tmp_pro = tmp.getProximo();
			
			tmp_ant.setProximo(tmp_pro);
			tmp_pro.setAnterior(tmp_ant);
			
			System.out.println("\nJogador eliminado:" +tmp.getElemento());
			}
     
		tmp = tmp.getProximo();	
		
	}while(tmp.getProximo() != inicio.getProximo());
		
		}
		
	
	//Método para exibir elementos
	public void exibirJogadores() {
		
		JogoDeCartas tmp;
		tmp = inicio;
		
		System.out.print("\nJogadores da rodada: ");
		do {
			System.out.print(" ["+tmp.getElemento()+"] ");
			tmp = tmp.getProximo();
		}while(tmp != inicio);
		
	}
	
	
	//Método para rodar em todo fim de rodada para remover 1 de tempo de banimento
	public void JogadoresBanidos() {
		JogoDeCartas tmp;
		tmp = inicio;
		
		do {
			//Verifica se o jogador está banido 
			if(tmp.getBanido() > 0) {
			int att = tmp.getBanido() - 1;
			tmp.setBanido(att);
			}
				
		}while(tmp != inicio);

	}
	
	
	public void AttBan(JogoDeCartas player) {
		
		if(player.getBanido() > 0) {
		int att = player.getBanido() - 1;
		player.setBanido(att);
		}
		
	}

	
	//Método para jogar uma partida
public void Jogar() {

	
	//Lista para gerar carta aleatória
    List<Integer> givenList = Arrays.asList(1, 3, 9, 12, 0, 13);

		JogoDeCartas tmp, tmp2;
		tmp = inicio;
		int sentido = 0;
	
		
		while(!resta1()) {
			
			//Gerando uma carta aleatória tirada da lista
		    Random rand = new Random();
		    int carta = givenList.get(rand.nextInt(givenList.size()));		 
			
	        //Jogadores ainda no jogo
		    System.out.println("----------------------------------------------------------/----------------------------------------------------------");
		    exibirJogadores();
		    //IF pra verificar o sentido da lista
			if(sentido == 0) {
				System.out.print(" Sentido da roda ---> ");
				
				/*
				//Ultimo jogada antes de acabar a rodada e atualiza os jogadores banidos
				if(tmp.getProximo().getElemento() == inicio.getElemento()) {
					JogadoresBanidos();
				}
				*/
				
			}else {
				System.out.print(" Sentido da roda <--- ");
				
				/*
				//Ultimo jogada antes de acabar a rodada e atualiza os jogadores banidos
				if(tmp.getElemento() == inicio.getElemento()) {
					JogadoresBanidos();
				}
				*/
			}
			
		    
		    //Se o jogador não tiver banido da rodada ele joga
		    if(tmp.getBanido() == 0) {
		    
		    System.out.print("\n \nJogando agora: "+tmp.getElemento());
		    	
		    	
		    switch (carta) {
		    
		    //(carta 0, que equivale ao As) que, caso o jogador a tire fica impossibilitado de jogar por 3 rodadas.
		    case 0:
		    		   
		    tmp.setBanido(3);	
		    System.out.println("\n\n"+tmp.getElemento()+" tirou a carta 0, e foi banido por 3 rodadas!");
		   
		    break;
		    
	        //CARTA 1 - Pula o próximo jogador e passa a vez para o seguinte. 
			case 1:
			    	
				System.out.println("\n\n"+tmp.getElemento()+" tirou a carta 1, pula o próximo jogador a pessa a vez para o seguinte!");
				//IF pra verificar o sentido da roda
			    if(sentido == 0) {
				tmp = tmp.getProximo();
				AttBan(tmp);
			    }else {
			    tmp = tmp.getAnterior();	
			    AttBan(tmp);
			    }
			  
			    break;
			    
		    //CARTA 13 - caso o jogador tire a carta 13 (equivalente ao Rei), ele pode escolher quantos jogadores devem ser pulados para selecionar o novo jogador da rodada.
			case 13:
			
				Random ran = new Random();
				int random = ran.nextInt(10) + 1;
				System.out.println("\n\n"+tmp.getElemento()+" tirou a carta 13 e decidiu pular "+random+" jogadores!");
				int i = 0;
				while(i < random) {
				if(sentido == 0) {
				tmp = tmp.getProximo();	
				AttBan(tmp);
				}else {
				tmp = tmp.getAnterior();
				AttBan(tmp);
				}
				i++;
				}				
			  
				
			   break;
			   
            
             //CARTA 12 - Inverte o sentido do jogo.
		     case 12:
		    		 
			 System.out.println("\n\n"+tmp.getElemento()+" tirou a carta 12, inverteu o sentido do jogo!");
			 if(sentido == 0) {
				sentido = 1;
			 }else if(sentido == 1) {
				sentido = 0;
			 }
	         break;
	        
            //Remove o terceiro jogador contado a partir do atual
		    case 3:
		    
			System.out.println("\n\n"+tmp.getElemento()+" tirou a carta 3, remove o terceiro jogador contado a partir do atual!");
		   
			if(sentido == 0) {
				
		    tmp2 = tmp.getProximo();
		    AttBan(tmp2);
		    tmp2 = tmp2.getProximo();
		    AttBan(tmp2);
		    tmp2 = tmp2.getProximo();
		    AttBan(tmp2);
		    
			}else {
				
			tmp2 = tmp.getAnterior();
			AttBan(tmp2);
			tmp2 = tmp2.getAnterior();
			AttBan(tmp2);
			tmp2 = tmp2.getAnterior();
			AttBan(tmp2);
			}
		    	    	
		    removerJogador(tmp2.getElemento());
	        break;
	        
            //Elimina o jogador anterior na roda. 
		    case 9:
		    		
	    	 System.out.println("\n\n"+tmp.getElemento()+" tirou a carta 9, elimina o jogador anterior na roda!");
		 
	    	 
	    	 //IF para verificar o sentido da roda
	    	 if(sentido == 0) {
				
			    tmp2 = tmp.getAnterior();
			    
				}else {
					
				tmp2 = tmp.getProximo();

				}
		    removerJogador(tmp2.getElemento());
	 		

	        break;
	        
		    default:
		        System.out.println("Carta invalida!");
 
		  }
		    //Fim do SWITCH
		   
		    //Avisa que o usuário está banido e atualiza o ban
		    }else {
		        System.out.println("\n\nJogador "+tmp.getElemento()+" está banido por mais "+tmp.getBanido()+" rodada(s), passou a vez para o próximo!");
		        AttBan(tmp);
		    }
		    
			//Passa o turno para o próximo jogador 
		    //if para verificar o sentido da turma
		    if(sentido == 0) {
			tmp = tmp.getProximo();
		    }else {
		    tmp = tmp.getAnterior();	
		    }
		
		  //Verifica se há um ganhador
			if(resta1()) {
				 System.out.println("\n\n----------------------------------------------------------/FIM DE JOGO/----------------------------------------------------------");				
				System.out.println("\n ["+tmp.getElemento()+"] É O VENCEDOR(A)!");
				 System.out.println("----------------------------------------------------------/FIM DE JOGO/----------------------------------------------------------\n\n\n");
				
	     		}	

		}		
	}
		
	public static void main(String[] args) {

		Lista lista = new Lista();
	
		//Adiciona os 10 jogadores
		lista.inserirJogador("Thiago");
		lista.inserirJogador("Amanda");
		lista.inserirJogador("Gabriel");
		lista.inserirJogador("Jeronimo");
		lista.inserirJogador("Lorran");
		lista.inserirJogador("Zaiko");
		lista.inserirJogador("Rafael");
		lista.inserirJogador("Kenji");
		lista.inserirJogador("Joeh");
		lista.inserirJogador("Luciene");
        //Jogar a partida
		lista.Jogar();
				
	}
 }