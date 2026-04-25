
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


public class main {
	

	public static void main(String[] args) {
		int k= Integer.parseInt(JOptionPane.showInputDialog("Capacidade do cesto"));
		s.vazio.release(k);
		int i=0;
		
		
		
		
		frame.tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.tela.setSize(500,300);
		frame.tela.setSize(1300,800);
		frame.tela.setLayout(new GridLayout(1,3));
		//frame.jt.append("andre"+"\n");
		frame.scrooll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frame.scrooll.setPreferredSize(new Dimension(250, 250));
		frame.scrooll.setBorder(
		           BorderFactory.createCompoundBorder(
		               BorderFactory.createCompoundBorder(
		                               BorderFactory.createTitledBorder("Log"),
		                               BorderFactory.createEmptyBorder(5,5,5,5)),
		                               frame.scrooll.getBorder()));
		 JPanel painel = new  JPanel();
         
	        
	     painel.setLayout(new BoxLayout(painel,BoxLayout.PAGE_AXIS));
	     painel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	        
	     frame.jt.setAlignmentX(Component.CENTER_ALIGNMENT);
	     painel.add(Box.createVerticalStrut(10));
	     painel.add(frame.scrooll);
	     painel.add(Box.createVerticalStrut(5));
	       
	     painel.add(Box.createVerticalStrut(5));
	     frame.painel1.setLayout(new GridLayout(5,2));
	     //frame.jt.setLineWrap( true );
	        
	       
	        
		
		
		
	
		
	
		
		
		//botão
		JButton c1 = new JButton("Adicionar criança");
		c1.setBounds(100,100,120,30);
		c1.setSize(200,120);
		
		//adicionar paineis
		
		
		frame.tela.add(painel);
		frame.tela.add(frame.painel);
		frame.painel.setLayout(new BoxLayout(frame.painel,1));
		frame.painel.add(c1);
		
		frame.tela.add(frame.painel1);
		frame.painel.setVisible(true);
		frame.painel1.setVisible(true);
		frame.tela.setVisible(true);
		
		
		
		
		
		
		
		//evento
		
		c1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						
						crianca cr_1 = new crianca ("Criança");
						cr_1.start();
						
					}
				}
			
				);
		

	}
	
	
}

