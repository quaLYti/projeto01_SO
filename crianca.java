

import java.awt.GridLayout;


import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextPane;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

public class crianca extends Thread {
	private String nome;
	
	//private JFrame janela;
	private int bola;
	private float t_b;
	private float t_d;
	private int a,b;
	private ImageIcon crianca_b_1 = new ImageIcon(getClass().getResource("child.png"));
	private ImageIcon crianca_b_2 = new ImageIcon(getClass().getResource("cr2.png"));
	private ImageIcon crianca_quieta = new ImageIcon(getClass().getResource("cr1.png"));
	private ImageIcon crianca_quieta2 = new ImageIcon(getClass().getResource("cr_q2.png"));	
	private ImageIcon crianca_esp = new ImageIcon(getClass().getResource("cr_esp.png"));
	private ImageIcon cesta = new ImageIcon(getClass().getResource("cesto.png"));
	
	private JPanel painel1 = new JPanel(); 
	private JTextPane inf = new JTextPane();
	
	public crianca (String nome) { 
		this.nome=nome;
		
		
	}

	public void run() {
		
		nome = JOptionPane.showInputDialog("Digite o nome: ");
		
		do {
			
			bola = Integer.parseInt(JOptionPane.showInputDialog("Criança tem bola?1-nao 2-sim"));

			if (bola !=1 && bola !=2){
				System.out.println("Tipo invalido! Digite novamente!");	
			}
		
		} while (bola !=1 && bola !=2);
		
		
		t_b = Float.parseFloat(JOptionPane.showInputDialog("Tempo brincando"));
		t_d = Float.parseFloat(JOptionPane.showInputDialog("Tempo sem bola"));
		cesto.a.setText("Bolas no cesto = "+cesto.k_c);
		cesto.a.setIcon(cesta);
		frame.painel.add(cesto.a);
		frame.painel1.add(painel1);
					
		JLabel label = new JLabel();
		JLabel label2 = new JLabel();
		
		label.setBounds(10,10,100,50);
		label.setSize(60,95);
		
		inf.setSize(60,95);
		painel1.setLayout(new GridLayout(1,2));
		painel1.add(label);
		painel1.add(inf);
		painel1.setVisible(true);
		
		
		label2.setBounds(10,10,100,50);
		label2.setSize(60,95);
		
		label2.setIcon(crianca_b_2);
		
		JLabel [ ] labels = new JLabel [100];
		for (int i=0; i < labels.length; i=i+2){
		   labels[i] = new JLabel ( );
		   labels[i+1]=new JLabel();
		   labels[i].setIcon(crianca_b_1);
		   labels[i+1].setIcon(crianca_b_2);
		   labels[i].setBounds(10,10,100,50);
		   labels[i].setSize(60,95);
		   labels[i+1].setBounds(10,10,100,50);
		   labels[i+1].setSize(60,95);
		}
		JLabel [ ] labels2 = new JLabel [100];
		for (int i=0; i < labels2.length; i=i+2){
		   labels2[i] = new JLabel ( );
		   labels2[i+1]=new JLabel();
		   labels2[i].setIcon(crianca_quieta);
		   labels2[i+1].setIcon(crianca_quieta2);
		   labels2[i].setBounds(10,10,100,50);
		   labels2[i].setSize(60,95);
		   labels2[i+1].setBounds(10,10,100,50);
		   labels2[i+1].setSize(60,95);
		}

		while (true) {
			
			if (bola == 1) {
				
				try {
					if (s.full.availablePermits()==0) {
						//colocar informacao de crianca dormindo
						frame.jt.insert(this.nome+" dormiu "+"aguardando bola"+"\n",0);
						
						label.setIcon(crianca_quieta);
						inf.setText(this.nome+"\n"+"aguardando bola");
					
						painel1.add(label);
						painel1.add(inf);
						painel1.validate();
						painel1.repaint();
						frame.tela.validate();
						frame.tela.repaint();
					}
					s.full.acquire();
					s.mutex.acquire();
					
					cesto.k_c -=1;
					cesto.a.setText("Bolas no cesto = "+cesto.k_c);
					frame.painel.add(cesto.a);
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					s.mutex.release();
					s.vazio.release();
					inf.removeAll();
					painel1.remove(label);
					painel1.remove(inf);
					painel1.validate();
					painel1.repaint();
					frame.painel.validate();
					frame.painel.repaint();
					frame.tela.validate();
					frame.tela.repaint();
					bola=2;
				}
				
				
			}
			
			
			
			a=0;
			b=0;
			
			if(bola==2) {
				
				
				
				frame.jt.insert(this.nome+"  "+"brincando"+"\n",0);
				
				
				
				

				while(a<(t_b)){
					painel1.add(labels[a]);
					inf.setText(this.nome+"\n"+" com bola "+"\n"+"tempo com bola= "+this.t_b+"\n"+"tempo sem bola = "+this.t_d+"\n"+"tempo que falta= "+(t_b-a));
					painel1.add(inf);
					painel1.validate();
					painel1.repaint();
					frame.tela.validate();
					frame.tela.repaint();
					
					
					
					
					long time = System.currentTimeMillis();
					long contIteracoes = 0;
					while(System.currentTimeMillis() - time < 1000){
						contIteracoes++;
					}
				
					painel1.remove(labels[a]);
					painel1.remove(inf);
					painel1.validate();
					painel1.repaint();
					frame.tela.validate();
					frame.tela.repaint();
				
					
					
					a++;
										
				}
				
				
			
				
								
				
				try {
					if (s.vazio.availablePermits()==0) {
						//colocar informacao de crianca dormindo
						frame.jt.insert(" "+this.nome+" dormiu "+"aguardando espaço no cesto"+"\n",0);
						label.setIcon(crianca_esp);
						inf.setText(this.nome+"\n"+"aguardando "+"\n"+"espaço no cesto "+"\n");
						
						painel1.add(label);
						painel1.add(inf);
						painel1.validate();
						painel1.repaint();
						frame.tela.validate();
						frame.tela.repaint();
					}
					s.vazio.acquire();
					s.mutex.acquire();
					cesto.k_c+=1;
					cesto.a.setText("Bolas no cesto = "+cesto.k_c);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					s.mutex.release();
					s.full.release();
					painel1.remove(label);
					painel1.remove(inf);
					inf.removeAll();
					painel1.validate();
					painel1.repaint();
					frame.painel.validate();
					frame.painel.repaint();
					frame.tela.validate();
					frame.tela.repaint();
					bola=1;
				}
				
				
				
				frame.jt.insert(" "+this.nome+"  "+"quieto(a)"+"\n",0);
				
				
				
				
				
									
				
				while(b<(t_d)){
					painel1.add(labels2[b]);
					inf.setText(this.nome+"\n"+" sem bola "+"\n"+"tempo com bola= "+this.t_b+"\n"+"tempo sem bola = "+this.t_d+"\n"+"tempo que falta= "+(t_d-b));
					painel1.add(inf);
					painel1.validate();
					painel1.repaint();
					frame.tela.validate();
					frame.tela.repaint();
					
					
					
					
					long time = System.currentTimeMillis();
					long contIteracoes = 0;
					while(System.currentTimeMillis() - time < 1000){
						contIteracoes++;
					}
				
					painel1.remove(labels2[b]);
					painel1.remove(inf);
					painel1.validate();
					painel1.repaint();
					frame.tela.validate();
					frame.tela.repaint();
				
					
					
					b++;
										
				}
				
				
			}
		}
	}
}	


