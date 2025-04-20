/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2;

/**
 *
 * @author ivis2
 */
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import mephi.b22901.lab2.builder.*;



public class MainWindow extends JFrame {
    private JTree tree;
    private JTextArea orkInfo;
    private JProgressBar strengthBar, agilityBar, intelligenceBar, healthBar;
    private JComboBox<String> tribeComboBox, roleComboBox;
    private OrkBuilderFactory orkBuilderFactory;
    private OrcDirector orcDirector;
    private List<Ork> allOrks = new ArrayList<>();
    
    public MainWindow() {
        setTitle("Сборка Армии Орков");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        orkBuilderFactory = new OrkBuilderFactory();
        orcDirector = new OrcDirector();
        
        JPanel treePanel = new JPanel();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Армия Саурона");
        DefaultMutableTreeNode mordor = new DefaultMutableTreeNode("Мордор");
        DefaultMutableTreeNode dolGuldur = new DefaultMutableTreeNode("Дол Гулдур");
        DefaultMutableTreeNode mistyMountains = new DefaultMutableTreeNode("Мглистые Горы");
        
        root.add(mordor);
        root.add(dolGuldur);
        root.add(mistyMountains);
        
        tree = new JTree(root);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        JScrollPane treeScroll = new JScrollPane(tree);
        
        treePanel.setLayout(new BorderLayout());
        treePanel.add(treeScroll, BorderLayout.CENTER);
        
        JPanel orkInfoPanel = new JPanel();
        orkInfoPanel.setLayout(new BorderLayout());

        orkInfo = new JTextArea(10, 20);
        orkInfo.setEditable(false);
        orkInfo.setLineWrap(true);
        orkInfo.setWrapStyleWord(true);
        orkInfo.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 15));
        orkInfoPanel.add(new JScrollPane(orkInfo), BorderLayout.NORTH);

        JPanel statsPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        statsPanel.add(createStatPanel(strengthBar = new JProgressBar(0, 100), "Сила","#FF8347", "#006400"));  
        statsPanel.add(createStatPanel(agilityBar = new JProgressBar(0, 100), "Ловкость","#00FF00", "#006400"));  
        statsPanel.add(createStatPanel(intelligenceBar = new JProgressBar(0, 50), "Интеллект","#00BFFF", "#006400"));  
        statsPanel.add(createStatPanel(healthBar = new JProgressBar(0, 200), "Здоровье","#FF4000", "#006400"));  


        orkInfoPanel.add(statsPanel, BorderLayout.CENTER);
        
        JPanel controlPanel = new JPanel();
        String[] tribes = {"Мордор", "Дол Гулдур", "Мглистые Горы"};
        String[] roles = {"Базовый", "Командир", "Разведчик"};
        tribeComboBox = new JComboBox<>(tribes);
        roleComboBox = new JComboBox<>(roles);
        
        JButton createOrkButton = new JButton("Создать Орка");
        createOrkButton.setBackground(new Color(85, 107, 47)); 
        createOrkButton.setForeground(Color.WHITE);
        createOrkButton.setFont(new Font("Serif", Font.BOLD, 16));
        createOrkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createOrk();
            }
        });
        
        JButton exitButton = new JButton("Выход");
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(e -> System.exit(0));
        
        controlPanel.add(new JLabel("Племя:"));
        controlPanel.add(tribeComboBox);
        controlPanel.add(new JLabel("Роль:"));
        controlPanel.add(roleComboBox);
        controlPanel.add(createOrkButton);
        controlPanel.add(exitButton);
       
        setLayout(new BorderLayout());
        add(treePanel, BorderLayout.WEST);
        add(orkInfoPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        
        tree.addTreeSelectionListener(e -> displayOrkInfo());
    }

    private void createOrk() {
        String selectedTribe = (String) tribeComboBox.getSelectedItem();
        String selectedRole = (String) roleComboBox.getSelectedItem();

        OrkBuilder builder = orkBuilderFactory.createBuilder(selectedTribe);

        Ork ork;
        switch (selectedRole) {
            case "Командир":
                ork = orcDirector.createCommanderOrk(builder);
                break;
            case "Разведчик":
                ork = orcDirector.createScoutOrk(builder);
                break;
            default:
                ork = orcDirector.createBasicOrk(builder);
                break;
        }
        allOrks.add(ork);

        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();

        DefaultMutableTreeNode tribeNode = null;
        Enumeration<TreeNode> children = root.children();
        while (children.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) children.nextElement();
            if (node.toString().equals(selectedTribe)) {
                tribeNode = node;
                break;
            }
        }

        if (tribeNode == null) {
            JOptionPane.showMessageDialog(this, "Узел племени не найден в дереве: " + selectedTribe);
            return;
        }

        DefaultMutableTreeNode orkNode = new DefaultMutableTreeNode(ork.getName());
        tribeNode.add(orkNode);

        model.reload(tribeNode);
        tree.expandPath(new TreePath(tribeNode.getPath()));
        tree.setSelectionPath(new TreePath(orkNode.getPath()));

        displayOrkInfo(ork);
    }

    
    private void displayOrkInfo(Ork ork) {
        if (ork == null) return;

        String weaponName;
        if (ork.getWeapon() != null) {
            weaponName = ork.getWeapon().getClass().getSimpleName();
        } else {
            weaponName = "—";
        }

        String armorName;
        if (ork.getArmor() != null) {
            armorName = ork.getArmor().getClass().getSimpleName();
        } else {
            armorName = "—";
        }

        String bannerName;
        if (ork.getBanner() != null) {
            bannerName = ork.getBanner().getClass().getSimpleName();
        } else {
            bannerName = "Нет";
        }

        orkInfo.setText("Имя: " + ork.getName() + "\n" +
                        "Племя: " + ork.getTribe() + "\n" +
                        "Оружие: " + weaponName + "\n" +
                        "Броня: " + armorName + "\n" +
                        "Знамя: " + bannerName + "\n" +
                        "Сила: " + ork.getStrength() + "\n" +
                        "Ловкость: " + ork.getAgility() + "\n" +
                        "Интеллект: " + ork.getIntelligence() + "\n" +
                        "Здоровье: " + ork.getHealth());


        strengthBar.setValue(ork.getStrength());
        agilityBar.setValue(ork.getAgility());
        intelligenceBar.setValue(ork.getIntelligence());
        healthBar.setValue(ork.getHealth());
    }

    private void displayOrkInfo() {
        TreePath path = tree.getSelectionPath();
        if (path != null && path.getPathCount() > 1) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
            String orkName = node.toString();

            for (Ork ork : allOrks) {
                if (orkName.equals(ork.getName())) {
                    displayOrkInfo(ork);
                    break;
                }
            }
        }
    }

    private JPanel createStatPanel(JProgressBar bar, String labelText, String barColorHex, String textColorHex) {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    bar.setStringPainted(true);
    bar.setForeground(Color.decode(barColorHex)); 
    bar.setBackground(Color.DARK_GRAY);          
    panel.add(bar);

    JLabel label = new JLabel(labelText, SwingConstants.CENTER);
    label.setForeground(Color.decode(textColorHex)); 
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(label);

    return panel;
}




}

