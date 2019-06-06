import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Personagem extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ImageIcon personaRight = new ImageIcon(getClass().getResource("Imagens/PersonagemAndandoRIGHT.gif"));
	private ImageIcon personaLeft = new ImageIcon(getClass().getResource("Imagens/PersonagemAndandoLEFT.gif"));
	private ImageIcon personaParado = new ImageIcon(getClass().getResource("Imagens/PersonagemAndandoRIGHT.gif"));
	private ImageIcon persona = new ImageIcon(getClass().getResource("Imagens/PersonagemAndandoRIGHT.gif"));
	
	private int x;
	private int y;
	private int h;
	private int w;
	
	private int vidas;
	
	//Construtor
	public Personagem() {
		this.setIcon(this.persona);
		this.h = this.persona.getIconHeight();
		this.w = this.persona.getIconWidth();
		this.vidas = 3;
	}
	
	//metodo que verifica a colisao entre o persona e a comida
	public boolean colisao(JLabel c) {
		int aX = this.getX();
		int aY = this.getY();
		int aX2 = this.getW();
		int aY2 = this.getH();
		int ldDireitoA = (aX + aX2) - 150;
		int ldEsquerdoA = (aX)+90;
		int ldBaixoA = aY + aY2;
		int ldCimaA = (aY)+90;
		
		int bX = c.getX()-10;
		int bY = c.getY();
		int bX2 = c.getWidth()-10;
		int bY2 = c.getHeight();
		int ldDireitoB = bX + bX2;
		int ldEsquerdoB = bX;
		int ldBaixoB = bY + bY2;
		int ldCimaB = bY;
		
		boolean colidiu = false;
		boolean colisaoH = false;
		boolean colisaoV = false;
		
		//testando se ha colisao
		if(aX < bX) {
			if(ldDireitoA >= ldEsquerdoB) {
				colisaoH = true;
			}
		}else if(bX < aX) {
			if(ldDireitoB >= ldEsquerdoA) {
				colisaoH = true;
			}
		}
				
		if(aY > bY) {
			if(ldCimaA <= ldBaixoB) {
				colisaoV = true;
			}
		}else if(bY > aY) {
			if(ldCimaB <= ldBaixoA) {
				colisaoV = true;
			}
		}
				
		if(colisaoV && colisaoH) {
			colidiu = true;
		}
				
		return colidiu;
}

	//Getters e Setters
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public ImageIcon getPersonaRight() {
		return personaRight;
	}
	public void setPersonaRight(ImageIcon personaRight) {
		this.personaRight = personaRight;
	}
	public ImageIcon getPersonaLeft() {
		return personaLeft;
	}
	public void setPersonaLeft(ImageIcon personaLEFT) {
		this.personaLeft = personaLEFT;
	}
	public ImageIcon getPersonaParado() {
		return personaParado;
	}
	public void setPersonaParado(ImageIcon personaParado) {
		this.personaParado = personaParado;
	}
	public ImageIcon getPersona() {
		return persona;
	}
	public void setPersona(ImageIcon persona) {
		this.persona = persona;
	}
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
}