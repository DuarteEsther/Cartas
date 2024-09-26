package jogo_carta;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable,KeyListener,MouseListener{

	
	public Deck deck;
	
	public static int score =0;
	
	public static boolean pressed = false;
	public static int mx =0, my =0;
	
	public Main() {
		Sound.music.loop();
		this.setPreferredSize(new Dimension(480,480));
		this.addKeyListener(this);
		this.addMouseListener(this);
		new Spritesheet("/spritesheet_cards.png");
	
		deck = new Deck();
		
	}
	
	public void tick() {
		deck.tick();
		
	
	}
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 480, 480);
		
		deck.render(g);
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("pontos"+ score, 375, 30);
		
		bs.show();
		
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		JFrame frame = new JFrame("Cartas");
		frame.add(main);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		new Thread(main).start();
	}
	
	@Override
	public void run() {
		requestFocus();
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		pressed = true;
		mx = e.getX();
		my = e.getY();
		Sound.hurt.play();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}
