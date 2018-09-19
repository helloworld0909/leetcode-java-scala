package com.helloworld09.leetcode.java.util;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class TreeVisualize {
    public static void draw(TreeNode root) {
        TreeFrame frame = new TreeFrame(root);

        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        TreeNode test = TreeNode.getTestTree();
        draw(test);
    }
}

class TreePanel extends JPanel {

    private TreeNode root;
    private int nodeWidth = 30;     //Width of tree node
    private int nodeHeight = 20;    //Height of tree node
    private int vGap = 50;          //vertical gap between two nodes
    private int hGap = 15;          //horizontal gap between two nodes

    private int rootY = 10;        //root node y coordinate
    private int rootX = 0;         //root node x coordinate

    private Font font = new Font("微软雅黑", Font.BOLD, 20);  //font of value strings

    private Color gridColor = Color.WHITE;      //color of node background
    private Color linkLineColor = Color.BLACK;  //color of lines
    private Color stringColor = Color.BLUE;    //color of value strings
    private Color specialLinkLineColor = Color.GREEN;   //color of special lines (node.next)

    public void setNodeWidth(int nodeWidth) {
        this.nodeWidth = nodeWidth;
    }

    public void setNodeHeight(int nodeHeight) {
        this.nodeHeight = nodeHeight;
    }

    public void setvGap(int vGap) {
        this.vGap = vGap;
    }

    public void sethGap(int hGap) {
        this.hGap = hGap;
    }

    public void setStartY(int rootY) {
        this.rootY = rootY;
    }

    public void setRootX(int rootX) {
        this.rootX = rootX;
    }

    public void setGridColor(Color gridColor) {
        this.gridColor = gridColor;
    }

    public void setLinkLineColor(Color linkLineColor) {
        this.linkLineColor = linkLineColor;
    }

    public void setStringColor(Color stringColor) {
        this.stringColor = stringColor;
    }

    private void setTree(TreeNode n) {
        root = n;
    }

    /**
     * Constructor
     *
     * @param n root of the tree
     */
    TreePanel(TreeNode n) {
        super();
        setTree(n);
    }

    @Override
    public void paintComponent(Graphics g) {
        rootX = (getWidth() - nodeWidth) / 2;
        super.paintComponent(g);
        g.setFont(font);
        drawNode(root, rootX, rootY, TreeNode.getDepth(root), g);
    }

    /**
     * Draw the tree recursively
     *
     * @param node     called tree node
     * @param x        x coordinate the node should be drawn
     * @param y        y coordinate the node should be drawn
     * @param depth    the node depth, the root corresponds to MAX_DEPTH and leaves corresponds to 1
     * @param graphics java.awt.Graphics
     */
    private void drawNode(TreeNode node, int x, int y, int depth, Graphics graphics) {
        if (node == null) {
            return;
        }

        graphics.setColor(gridColor);
        graphics.fillRect(x, y, nodeWidth, nodeHeight);

        graphics.setColor(stringColor);
        graphics.drawString(String.valueOf(node.val), x, y + nodeHeight / 2);

        int newY = y + vGap + nodeHeight;

        //Add special links for TreeLinkNode
        if (node instanceof TreeLinkNode && ((TreeLinkNode) node).getNext() != null) {
            int nextX = x + nodeWidth + hGap * (int) (Math.pow(2, depth + 1));
            graphics.setColor(specialLinkLineColor);
            graphics.drawLine(x + nodeWidth, y + nodeHeight / 2, nextX, y + nodeHeight / 2);
        }

        if (node.getLeft() != null) {
            int leftMid = x - hGap * (int) (Math.pow(2, depth - 1));
            int leftX = leftMid - nodeWidth / 2;
            graphics.setColor(linkLineColor);
            graphics.drawLine(x + nodeWidth / 2, y + nodeHeight, leftMid, newY);

            drawNode(node.getLeft(), leftX, newY, depth - 1, graphics);
        }

        if (node.getRight() != null) {
            int rightMid = x + nodeWidth + hGap * (int) (Math.pow(2, depth - 1));
            int rightX = rightMid - nodeWidth / 2;
            graphics.setColor(linkLineColor);
            graphics.drawLine(x + nodeWidth / 2, y + nodeHeight, rightMid, newY);
            drawNode(node.getRight(), rightX, newY, depth - 1, graphics);
        }
    }
}


class TreeFrame extends JFrame {

    TreeFrame(TreeNode root) {
        super("Draw a tree");
        TreePanel panel = new TreePanel(root);
        add(panel);
    }
}
