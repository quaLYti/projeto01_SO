import java.awt.Color;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

@SuppressWarnings("serial")
public class grafDesenha extends JPanel {
    private ArrayList<Point> nodes;
    private ArrayList<Point> nodesB;
    private ArrayList<Point> nodesBE;
    private ArrayList<Point> nodesR;
    private ArrayList<Point[]> edges;
    private ArrayList<Point[]> edges2;

    public grafDesenha() {
        nodes = new ArrayList<>();
        nodesB = new ArrayList<>();
        nodesBE = new ArrayList<>();
        nodesR = new ArrayList<>();
        edges = new ArrayList<>();
        edges2 = new ArrayList<>();
    }

    public void addNode(int x, int y) {
        nodes.add(new Point(x, y));
        repaint();
    }
    
    public void addNodeB(int x, int y) {
        nodesB.add(new Point(x, y));
        repaint();
    }
    
    public void addNodeBE(int x, int y) {
        nodesBE.add(new Point(x, y));
        repaint();
    }
    
    public void addNodeR(int x, int y) {
        nodesR.add(new Point(x, y));
        repaint();
    }

    public void addEdge(int node1, int node2) {
        if (node1 < nodes.size() && node2 < nodesR.size()) {
            Point[] edge = new Point[2];
            edge[0] = nodes.get(node1);
            edge[1] = nodesR.get(node2);
            edges.add(edge);
            repaint();
        }
    }
    
    public void addEdgeDown(int node1, int node2) {
        if (node1 < nodesR.size() && node2 < nodes.size()) {
            Point[] edge = new Point[2];
            edge[0] = nodesR.get(node1);
            edge[1] = nodes.get(node2);
            edges2.add(edge);
            repaint();
        }
    }
    
    public void deleteNodeB(int nodeIndex) {
        if (nodeIndex < nodesB.size()) {
            Point node = nodesB.get(nodeIndex);
            
            // Remover arestas conectadas ao nó
            /*ArrayList<Point[]> connectedEdges = new ArrayList<>();
            for (Point[] edge : edges2) {
                if (edge[0].equals(node) || edge[1].equals(node)) {
                    connectedEdges.add(edge);
                }
            }
            edges2.removeAll(connectedEdges);*/
            
            // Remover o nó da lista nodesB
            nodesB.remove(nodeIndex);
            
            repaint();
        }
    }


    public void deleteEdge(int node1, int node2) {
        for (int i = 0; i < edges.size(); i++) {
            Point[] edge = edges.get(i);
            Point startPoint = edge[0];
            Point endPoint = edge[1];
            if ((startPoint.equals(nodes.get(node1)) && endPoint.equals(nodesR.get(node2)))
                    /*|| (startPoint.equals(nodes.get(node2)) && endPoint.equals(nodes.get(node1)))*/) {
                edges.remove(i);
                repaint();
                break;
            }
        }
    }
    
    public void deleteEdgeDown(int node1, int node2) {
        for (int i = 0; i < edges2.size(); i++) {
            Point[] edge = edges2.get(i);
            Point startPoint = edge[0];
            Point endPoint = edge[1];
            if ((startPoint.equals(nodesR.get(node1)) && endPoint.equals(nodes.get(node2)))
                    /*|| (startPoint.equals(nodes.get(node2)) && endPoint.equals(nodes.get(node1)))*/) {
                edges2.remove(i);
                repaint();
                break;
            }
        }
    }
    
    public void deleteAllEdges() {
        edges.clear();
        edges2.clear();
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        
        g2d.setColor(Color.black);
        
        g2d.setFont(new Font("calibri",Font.BOLD,20));
        g2d.drawString("Recursos",250,20);
        g2d.drawString("Processos",250,650);
        // Desenhar nós
        g2d.setColor(Color.blue);
        for (Point node : nodes) {
            g2d.fillOval(node.x - 5, node.y - 5, 10, 10);
        }
        
        g2d.setColor(Color.RED);
        for (Point node : nodesB) {
            g2d.fillOval(node.x - 5, node.y - 5, 10, 10);
        }
        
        g2d.setColor(Color.blue);
        for (Point node : nodesBE) {
            g2d.fillOval(node.x - 5, node.y - 5, 10, 10);
        }
        
        g2d.setColor(Color.blue);
        for (Point node : nodesR) {
            g2d.fillRect(node.x - 5, node.y - 5, 10, 10);
        }

        // Desenhar arestas
        g2d.setColor(Color.RED);
        for (Point[] edge : edges) {
            Point startPoint = edge[0];
            Point endPoint = edge[1];
            g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        }
        
        g2d.setColor(Color.GREEN);
        for (Point[] edge : edges2) {
            Point startPoint = edge[0];
            Point endPoint = edge[1];
            g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        }
    }
}
