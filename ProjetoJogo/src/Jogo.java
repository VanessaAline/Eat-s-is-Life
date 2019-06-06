import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Jogo extends JFrame{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	//personagem
	private Personagem persona;
	//botoes
	private JButton btninicio = new JButton();
	private JButton btnsair = new JButton();
	private JButton btntuto = new JButton();
	private JButton btnvolta = new JButton();
	//frames
	private JFrame tela1 = new JFrame();
	private JFrame telaInicial = new JFrame();
	//icons
	private ImageIcon iconBoard = new ImageIcon(getClass().getResource("Imagens/Board.png"));
	private ImageIcon iconCenario = new ImageIcon(getClass().getResource("Imagens/Cenario.jpg"));
	private ImageIcon iconTela3 = new ImageIcon(getClass().getResource("Imagens/Tela-3.png"));
	private ImageIcon iconTela1 = new ImageIcon(getClass().getResource("Imagens/Tela-1.png"));
	//labels
	private JLabel lbBoard = new JLabel(iconBoard);
	private JLabel lbCenario = new JLabel(iconCenario);
	private JLabel lbtela1 = new JLabel(iconTela1);
	private JLabel lbtela3 = new JLabel(iconTela3);
	private JLabel lbPronto = new JLabel();
	private JLabel lbVai = new JLabel();
	//comidas
	JLabel lbComida1 = new JLabel(new ImageIcon(getClass().getResource("Imagens/Laranja.png")));
	JLabel lbComida2 = new JLabel(new ImageIcon(getClass().getResource("Imagens/Fritas.png")));
	JLabel lbComida3 = new JLabel(new ImageIcon(getClass().getResource("Imagens/Banana.png")));
	JLabel lbComida4 = new JLabel(new ImageIcon(getClass().getResource("Imagens/Melancia.png")));
	JLabel lbComida5 = new JLabel(new ImageIcon(getClass().getResource("Imagens/Pizza.png")));
	JLabel lbComida6 = new JLabel(new ImageIcon(getClass().getResource("Imagens/Uva.png")));
	JLabel lbComida7 = new JLabel(new ImageIcon(getClass().getResource("Imagens/Hamburguer.png")));
	JLabel lbComida8 = new JLabel(new ImageIcon(getClass().getResource("Imagens/Maca.png")));
	JLabel lbComida9 = new JLabel(new ImageIcon(getClass().getResource("Imagens/HotDog.png")));
	JLabel lbComida10 = new JLabel(new ImageIcon(getClass().getResource("Imagens/Morango.png")));
	JLabel lbComida11 = new JLabel(new ImageIcon(getClass().getResource("Imagens/Rosquinha.png")));
	JLabel lbComida12 = new JLabel(new ImageIcon(getClass().getResource("Imagens/Sorvete.png")));
	//pontos	
	private JLabel lbpontos = new JLabel();
	private JLabel lbtextoPontos = new JLabel();
	private int pontos;
	
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	//vidas
	private JLabel lbVidas1 = new JLabel(new ImageIcon(getClass().getResource("Imagens/Coracao.png")));
	private JLabel lbVidas2 = new JLabel(new ImageIcon(getClass().getResource("Imagens/Coracao.png")));
	private JLabel lbVidas3 = new JLabel(new ImageIcon(getClass().getResource("Imagens/Coracao.png")));
	private JLabel lbvidas = new JLabel();
	
	
	//Música de fundo
	public void tocar(String nomeDoAudio) {
		java.net.URL url = Jogo.class.getResource(nomeDoAudio+".wav"); //acessando a classe
		AudioClip audio = Applet.newAudioClip(url); //criando objeto de audio acessando a classe Applet
		audio.play();
		audio.loop();
		
	}
	//Thread que mantem a musica tocando
	public class Musica extends Thread{
		
		public Musica() {
			
		}
		public void run() {

			for(;;) {
				tocar("audio");
				try {
					Musica.sleep(2000);
				} catch (InterruptedException erro) {}
			}
		}
	}
	//Construtor
	public Jogo() {
		this.pontos = 0;
	}
	
	//startar o jogo
	public void start() {
		this.telaInicial();
	}
	
	//tela incicial do jogo
	public void telaInicial() {
		//configuracoes de tela
		tela1.setLayout(null);
		tela1.setSize(1000, 700);
		tela1.setLocationRelativeTo(null);
		tela1.setResizable(false);
		tela1.setVisible(true);
		tela1.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//botao inicio
		this.btninicio.setFont(new Font("Tahoma", 1, 18));
		this.btninicio.setForeground(new Color(0, 100, 0 ));
		this.btninicio.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 100, 0), 3));
	    
		this.btninicio.setText("INICIAR JOGO");
		this.btninicio.setVisible(true);
		this.btninicio.setSize(150, 50);
		this.btninicio.setBounds(225, 500, 150, 50);
		tela1.add(this.btninicio);
		//botao sair
		this.btnsair.setFont(new Font("Tahoma", 1, 18));
		this.btnsair.setForeground(new Color(0, 100, 0 ));
		this.btnsair.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 100, 0), 3));
		
		this.btnsair.setText("SAIR");
		this.btnsair.setVisible(true);
		this.btnsair.setSize(150, 50);
		this.btnsair.setBounds(425, 500, 150, 50);
		tela1.add(this.btnsair);
		tela1.add(lbtela1);
		//botao tuto
		this.btntuto.setFont(new Font("Tahoma", 1, 18));
		this.btntuto.setForeground(new Color(0, 100, 0 ));
		this.btntuto.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 100, 0), 3));
		
		this.btntuto.setText("TUTORIAL");
		this.btntuto.setVisible(true);
		this.btntuto.setSize(150, 50);
		this.btntuto.setBounds(630, 500, 150, 50);
		tela1.add(this.btntuto);
		//tela inicial
		tela1.add(lbtela1);
		this.lbtela1.setVisible(true);
		this.lbtela1.setBounds(0,0, 1000, 700);
		
		//acao do botao iniciar
		this.btninicio.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent iniciar) {
				tela1.setVisible(false);
				Jogo.this.janelaJogo();
				Jogo.this.adicionarMovimento();
				tocar("Musicas/THEME-SONG");
				new MotorJogo().start();
			}
		});
		//acao do botao tuto
		this.btntuto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent tutorial) {
				tela1.setVisible(false);
				telaInicial.setLayout(null);
				telaInicial.setSize(1000, 700);
				telaInicial.setLocationRelativeTo(null);
				telaInicial.setResizable(false);
				telaInicial.setVisible(true);
				telaInicial.setDefaultCloseOperation(EXIT_ON_CLOSE);
				
				lbtela3.setVisible(true);
				lbtela3.setBounds(0,0, 1000, 700);
				telaInicial.add(lbtela3);
				
				btnvolta.setText("VOLTAR");
				telaInicial.add(btnvolta);
				btnvolta.setBounds(400, 490, 150, 50);
				btnvolta.setVisible(true);
				
				btnvolta.setFont(new Font("Tahoma", 1, 18));
				btnvolta.setForeground(new Color(0, 100, 0 ));
				btnvolta.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 100, 0), 3));
			}
		});
		//acao do botao sair
		this.btnsair.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent sair) {
				System.exit(0);
			}
		});
		//acao do botao voltar
		this.btnvolta.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent volta) {
				telaInicial.setVisible(false);
				tela1.setVisible(true);
				
			}
		});
		
	}
	
	//definindo a tela do jogo
	public void janelaJogo() {
		
		setLayout(null);
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Adicionando o Personagem na Tela
		this.persona = new Personagem();
		this.persona.setX(350);
		this.persona.setY(380);
		this.persona.setBounds(this.persona.getX(), this.persona.getY(), this.persona.getH(), this.persona.getW());
		this.persona.setVisible(true);
		this.add(this.persona);
		
		//adicionando as labels dos pontos e vidas
		this.lbpontos.setFont(new Font("Tahoma", 1, 25));
		this.lbpontos.setForeground(new Color(0, 100, 0 ));
		this.lbpontos.setText("0");
		this.add(lbpontos);
		
		this.add(lbtextoPontos);
		this.lbtextoPontos.setText("PONTUAÇÃO");
		this.lbtextoPontos.setFont(new Font("Tahoma", 1, 25));
		
		this.lbtextoPontos.setBounds(265, 30, 170, 30);
		this.lbpontos.setBounds(430, 20, 150, 50);
		this.lbtextoPontos.setVisible(true);
		this.lbpontos.setVisible(true);
		
		this.add(lbvidas);  this.add(lbVidas1);
		this.add(lbVidas2); this.add(lbVidas3);
		this.lbvidas.setText("VIDAS ");
		this.lbvidas.setVisible(true);
		
		this.lbvidas.setFont(new Font("Tahoma", 1, 25));
		this.lbvidas.setBounds(520, 30, 130, 30);
		this.lbVidas1.setBounds(560, 17, 150, 60);
		this.lbVidas1.setVisible(true);
		this.lbVidas2.setBounds(590, 17, 150, 60);
		this.lbVidas2.setVisible(true);
		this.lbVidas3.setBounds(620, 17, 150, 60);
		this.lbVidas3.setVisible(true);
		
		this.lbBoard.setVisible(true);
		this.add(this.lbBoard);
		this.lbBoard.setBounds(240, 8, 500, 80);
		
		//adicionando as labels das comidas
		this.add(lbComida1); this.add(lbComida2); this.add(lbComida3);
		this.add(lbComida4); this.add(lbComida5); this.add(lbComida6);
		this.add(lbComida7); this.add(lbComida8); this.add(lbComida9);
		this.add(lbComida10); this.add(lbComida11); this.add(lbComida12);
		this.lbComida1.setVisible(true); this.lbComida2.setVisible(true);
		this.lbComida3.setVisible(true); this.lbComida4.setVisible(true);
		this.lbComida5.setVisible(true); this.lbComida6.setVisible(true);
		this.lbComida7.setVisible(true); this.lbComida8.setVisible(true);
		this.lbComida9.setVisible(true); this.lbComida10.setVisible(true);
		this.lbComida11.setVisible(true); this.lbComida12.setVisible(true);
		
		this.lbPronto.setVisible(true);
		this.lbPronto.setFont(new Font("Tahoma", 1, 70));
		this.lbPronto.setForeground(new Color(255, 255, 255));
		this.lbPronto.setText("PRONTO?");
		add(this.lbPronto);
		
		this.lbVai.setVisible(true);
		this.lbVai.setFont(new Font("Tahoma", 1, 70));
		this.lbVai.setForeground(new Color(255, 255, 255));
		this.lbVai.setText("VAI!!!");
		add(this.lbVai);
		
		//adicionando o background a tela
		add(lbCenario);
		this.lbCenario.setBounds(0, 0, 1000, 700);
	}
	
	//metodo que adiciona movimento ao personagem
	public void adicionarMovimento() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 37) {
					persona.setIcon(persona.getPersonaLeft());
					persona.setX(persona.getX()-30);
					if(persona.getX() < -80) {
						persona.setX(-80);
					}
				}
				if(e.getKeyCode() == 39) {
					persona.setIcon(persona.getPersonaRight());
					persona.setX(persona.getX()+30);
					if(persona.getX() > 760) {
						persona.setX(760);
					}
				}
				persona.setLocation(persona.getX(), persona.getY());
			}
		});
	}
	
	//thread principal do jogo
	class MotorJogo extends Thread {
		
		//objeto Random utilizado para gerar um numero aleatorio
		Random aleatorio = new Random();
		
		//variavel usada para servir como o 'Y' inicial
		int y = -150;
		//para auxiliar na velocidade
		int v1, v2, v3, v4, v5, v6, v7, v8, v9, v10;
		
		//metodo usado para sortear a posicao 'X' das comidas
		private int geraX() {
			int x = aleatorio.nextInt(860);
			
			return x;
		}
		
		//metodo para realizar o respaw da comida
		private void respaw(JLabel comida) {
			comida.setVisible(false);
			
			if(Jogo.this.getPontos() > 150 && Jogo.this.getPontos() < 300)
				this.geraVelocidade();
			else if(Jogo.this.getPontos() > 300 && Jogo.this.getPontos() < 600)
				this.geraVelocidade();
			else if(Jogo.this.getPontos() > 600)
				this.geraVelocidade();
			
			comida.setVisible(true);
			comida.setBounds(this.geraX(), y, 100, 100);
		}
		
		//metodo para contar as vidas do personagem
		private void contaVida() {	
			if(Jogo.this.lbVidas3.isVisible()) {
				Jogo.this.lbVidas3.setVisible(false);
				Jogo.this.persona.setVidas(Jogo.this.persona.getVidas()-1);
			}else if(Jogo.this.lbVidas2.isVisible()) {
				Jogo.this.lbVidas2.setVisible(false);
				Jogo.this.persona.setVidas(Jogo.this.persona.getVidas()-1);
			}else {
				Jogo.this.lbVidas1.setVisible(false);
				Jogo.this.persona.setVidas(Jogo.this.persona.getVidas()-1);
			}
		}
		
		//metodos para calcular a velocidade de queda das comidas
		private void geraVelocidade() {
			this.v1 = this.velocidade(); this.v2 = this.velocidade(); this.v3 = this.velocidade(); this.v4 = this.velocidade();
			this.v5 = this.velocidade(); this.v6 = this.velocidade(); this.v7 = this.velocidade(); this.v8 = this.velocidade();
			this.v9 = this.velocidade(); this.v10 = this.velocidade();
		}
		private int velocidade() {
			int vel = aleatorio.nextInt(2) + 1;
			
			if(Jogo.this.getPontos() < 150)
				vel += 0;
			else if(Jogo.this.getPontos() > 150 && Jogo.this.getPontos() < 300)
				vel += 1;
			else if(Jogo.this.getPontos() > 300 && Jogo.this.getPontos() < 600)
				vel += 2;
			else if(Jogo.this.getPontos() > 600)
				vel += 5;
			
			return vel;
		}
		
		//metodo run da thread principal
		public void run() {
			//adicionando as comidas no topo
			Jogo.this.lbComida1.setBounds(this.geraX(), y, 100, 100); Jogo.this.lbComida2.setBounds(this.geraX(), y, 100, 100);
			Jogo.this.lbComida3.setBounds(this.geraX(), y, 100, 100); Jogo.this.lbComida4.setBounds(this.geraX(), y, 100, 100);
			Jogo.this.lbComida5.setBounds(this.geraX(), y, 100, 100); Jogo.this.lbComida6.setBounds(this.geraX(), y, 100, 100);
			Jogo.this.lbComida7.setBounds(this.geraX(), y, 100, 100); //Jogo.this.lbComida8.setBounds(Jogo.this.geraX(), y, 100, 100);
			Jogo.this.lbComida9.setBounds(this.geraX(), y, 100, 100); Jogo.this.lbComida10.setBounds(this.geraX(), y, 100, 100);
			//Jogo.this.lbComida11.setBounds(this.geraX(), y, 100, 100); Jogo.this.lbComida12.setBounds(this.geraX(), y, 100, 100);
			
			//sorteando a velocidade
			this.geraVelocidade();
			
			//AGUARDA 2,5 SEGUNDOS PARA INICIAR E MOSTRA UMA MENSAGEM
			try {Thread.sleep(200);}catch(Exception erro){}
			Jogo.this.lbPronto.setBounds(310, 170, 350, 100);
			try {Thread.sleep(1800);}catch(Exception erro){}
			Jogo.this.lbPronto.setVisible(false);
			Jogo.this.lbVai.setBounds(390, 170, 350, 100);
			try {Thread.sleep(500);}catch(Exception erro){}
			Jogo.this.lbVai.setVisible(false);
			
			while(true) {
				try{
					Thread.sleep (20);
				}catch(Exception erro) {}
				
				//verifica se o jogador ainda possui vidas
				if(Jogo.this.lbVidas1.isVisible() == false && Jogo.this.lbVidas2.isVisible() == false && Jogo.this.lbVidas3.isVisible() == false ||
						Jogo.this.getPontos() < 0) {
					JOptionPane.showMessageDialog(null, "GAME OVER!\nPONTUAÇÃO: "+Jogo.this.getPontos());
					System.exit(0);
				}
				
				//verifica a distancia da comida para o chao (580)
				if(Jogo.this.lbComida1.getY() < 580) {
					Jogo.this.lbComida1.setBounds(Jogo.this.lbComida1.getX(), Jogo.this.lbComida1.getY() + this.v1, 100, 100);
				}else if(Jogo.this.lbComida1.getY() >= 580) {
					this.contaVida();
					this.respaw(Jogo.this.lbComida1);
				}
				if(Jogo.this.lbComida2.getY() < 580) {
					Jogo.this.lbComida2.setBounds(Jogo.this.lbComida2.getX(), Jogo.this.lbComida2.getY() + this.v2, 100, 100);
				}else if(Jogo.this.lbComida2.getY() >= 580){
					this.respaw(Jogo.this.lbComida2);
				}
				if(Jogo.this.lbComida3.getY() < 580) {
					Jogo.this.lbComida3.setBounds(Jogo.this.lbComida3.getX(), Jogo.this.lbComida3.getY() + this.v3, 100, 100);
				}else if(Jogo.this.lbComida3.getY() >= 580){
					this.contaVida();
					this.respaw(Jogo.this.lbComida3);
				}
				if(Jogo.this.lbComida4.getY() < 580) {
					Jogo.this.lbComida4.setBounds(Jogo.this.lbComida4.getX(), Jogo.this.lbComida4.getY() + this.v4, 100, 100);
				}else if(Jogo.this.lbComida4.getY() >= 580){
					this.contaVida();
					this.respaw(Jogo.this.lbComida4);
				}
				if(Jogo.this.lbComida5.getY() < 580) {
					Jogo.this.lbComida5.setBounds(Jogo.this.lbComida5.getX(), Jogo.this.lbComida5.getY() + this.v5, 100, 100);
				}else if(Jogo.this.lbComida5.getY() >= 580){
					this.respaw(Jogo.this.lbComida5);
				}
				if(Jogo.this.lbComida6.getY() < 580) {
					Jogo.this.lbComida6.setBounds(Jogo.this.lbComida6.getX(), Jogo.this.lbComida6.getY() + this.v6, 100, 100);
				}else if(Jogo.this.lbComida6.getY() >= 580){
					this.contaVida();
					this.respaw(Jogo.this.lbComida6);
				}
				if(Jogo.this.lbComida7.getY() < 580) {
					Jogo.this.lbComida7.setBounds(Jogo.this.lbComida7.getX(), Jogo.this.lbComida7.getY() + this.v7, 100, 100);
				}else if(Jogo.this.lbComida7.getY() >= 580){
					this.respaw(Jogo.this.lbComida7);
				}
				
				/*if(Jogo.this.lbComida8.getY() < 580) {
					Jogo.this.lbComida8.setBounds(Jogo.this.lbComida8.getX(), Jogo.this.lbComida8.getY() + 5, 100, 100);
				}else if(Jogo.this.lbComida8.getY() >= 580){
					this.respaw(Jogo.this.lbComida8);
				}*/
				if(Jogo.this.getPontos() > 800) {
					if(Jogo.this.lbComida9.getY() < 580) {
						Jogo.this.lbComida9.setBounds(Jogo.this.lbComida9.getX(), Jogo.this.lbComida9.getY() + v9, 100, 100);
					}else if(Jogo.this.lbComida9.getY() >= 580){
						this.respaw(Jogo.this.lbComida9);
					}
					if(Jogo.this.lbComida10.getY() < 580) {
						Jogo.this.lbComida10.setBounds(Jogo.this.lbComida10.getX(), Jogo.this.lbComida10.getY() + v10, 100, 100);
					}else if(Jogo.this.lbComida10.getY() >= 580){
						this.contaVida();
						this.respaw(Jogo.this.lbComida10);
					}
				}
				/*if(Jogo.this.lbComida11.getY() < 580) {
					Jogo.this.lbComida11.setBounds(Jogo.this.lbComida11.getX(), Jogo.this.lbComida11.getY() + 5, 100, 100);
				}else if(Jogo.this.lbComida11.getY() >= 580){
					this.respaw(Jogo.this.lbComida11);
				}
				if(Jogo.this.lbComida12.getY() < 580) {
					Jogo.this.lbComida12.setBounds(Jogo.this.lbComida12.getX(), Jogo.this.lbComida12.getY() + 5, 100, 100);
				}else if(Jogo.this.lbComida12.getY() >= 580){
					this.respaw(Jogo.this.lbComida12);
				}
				*/
				
				//verificando colisoes com objetos
				if(Jogo.this.persona.colisao(Jogo.this.lbComida1)) {
					Jogo.this.setPontos(Jogo.this.getPontos() + 10);
					Jogo.this.lbpontos.setText(String.valueOf(Jogo.this.pontos));
					this.respaw(Jogo.this.lbComida1);
				}
				if(Jogo.this.persona.colisao(Jogo.this.lbComida2)) {
					Jogo.this.setPontos(Jogo.this.getPontos() - 15);
					Jogo.this.lbpontos.setText(String.valueOf(Jogo.this.pontos));
					this.respaw(Jogo.this.lbComida2);
				}
				if(Jogo.this.persona.colisao(Jogo.this.lbComida3)) {
					Jogo.this.setPontos(Jogo.this.getPontos() + 15);
					Jogo.this.lbpontos.setText(String.valueOf(Jogo.this.pontos));
					this.respaw(Jogo.this.lbComida3);
				}
				if(Jogo.this.persona.colisao(Jogo.this.lbComida4)) {
					Jogo.this.setPontos(Jogo.this.getPontos() + 20);
					Jogo.this.lbpontos.setText(String.valueOf(Jogo.this.pontos));
					this.respaw(Jogo.this.lbComida4);
				}
				if(Jogo.this.persona.colisao(Jogo.this.lbComida5)) {
					Jogo.this.setPontos(Jogo.this.getPontos() - 10);
					Jogo.this.lbpontos.setText(String.valueOf(Jogo.this.pontos));
					this.respaw(Jogo.this.lbComida5);
				}
				if(Jogo.this.persona.colisao(Jogo.this.lbComida6)) {
					Jogo.this.setPontos(Jogo.this.getPontos() + 10);
					Jogo.this.lbpontos.setText(String.valueOf(Jogo.this.pontos));
					this.respaw(Jogo.this.lbComida6);
				}
				if(Jogo.this.persona.colisao(Jogo.this.lbComida7)) {
					Jogo.this.setPontos(Jogo.this.getPontos() - 20);
					Jogo.this.lbpontos.setText(String.valueOf(Jogo.this.pontos));
					this.respaw(Jogo.this.lbComida7);
				}
				
				/*if(Jogo.this.persona.colisao(Jogo.this.lbComida8)) {
					//pontuacao
					this.respaw(Jogo.this.lbComida8);
				}*/
				if(Jogo.this.persona.colisao(Jogo.this.lbComida9)) {
					Jogo.this.setPontos(Jogo.this.getPontos() - 35);
					Jogo.this.lbpontos.setText(String.valueOf(Jogo.this.pontos));
					this.respaw(Jogo.this.lbComida9);
				}
				if(Jogo.this.persona.colisao(Jogo.this.lbComida10)) {
					Jogo.this.setPontos(Jogo.this.getPontos() + 30);
					Jogo.this.lbpontos.setText(String.valueOf(Jogo.this.pontos));
					this.respaw(Jogo.this.lbComida10);
				}
				/*if(Jogo.this.persona.colisao(Jogo.this.lbComida11)) {
					//pontuacao
					this.respaw(Jogo.this.lbComida11);
				}
				if(Jogo.this.persona.colisao(Jogo.this.lbComida12)) {
					//pontuacao
					this.respaw(Jogo.this.lbComida12);
				}*/
			}
		}
	}
	
	public static void main(String[] args) {	
		Jogo jogo = new Jogo();
		jogo.start();
	}
}