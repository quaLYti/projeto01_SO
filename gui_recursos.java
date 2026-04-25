import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;

public class gui_recursos {
	public static String usuario_recurso[]=new String[10];
	public static int possui_recurso[]=new int[10];
	public static JFrame tela_fundo;
	public static JFrame tela_grafo;
	public static grafDesenha graf = new grafDesenha();
	public static Graphics tela;
	public static JPanel painel1,painel2,painel3;// = new JPanel();
	public static JLabel label1,label2,label3,label4,label5=new JLabel();
	public static JButton button1,button2=new JButton();
	public static JTextArea jt = new JTextArea();
	public static JScrollPane scrooll = new JScrollPane(jt);
	public static int x=1;
	public static int g;
	public static int h;
	public static int[] a,b;
	public static int nextItNodeB;
	// public static desenhar d = new desenhar();//coordenadas de chegada e saida dos vertices para uso do gui
	public static int c = 0;
	//public static grafo<String> grafo1;//  = new grafo<String>();
	
}
