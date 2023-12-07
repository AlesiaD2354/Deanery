package Zadanie8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HierarchicalMenuGUI extends JFrame {
    private JLabel menuLabel;
    private JTextArea menuTextArea;
    private JTextField userInputField;
    private MenuItem currentMenu;

    public HierarchicalMenuGUI() {
        setTitle("Hierarchical Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        menuLabel = new JLabel("Menu:");
        panel.add(menuLabel, BorderLayout.NORTH);

        menuTextArea = new JTextArea();
        menuTextArea.setEditable(false);
        panel.add(new JScrollPane(menuTextArea), BorderLayout.CENTER);

        userInputField = new JTextField();
        panel.add(userInputField, BorderLayout.SOUTH);

        add(panel);

        // Create menu items
        MenuItem root = new MenuItem("Основной");
        MenuItem item1 = new MenuItem("Элемент 1");
        MenuItem item2 = new MenuItem("Элемент 2");
        MenuItem subItem1 = new MenuItem("Подпункт 1");
        MenuItem subItem2 = new MenuItem("Подпункт 2");

        root.addSubMenu(item1);
        root.addSubMenu(item2);
        item1.addSubMenu(subItem1);
        item1.addSubMenu(subItem2);

        currentMenu = root;
        displayMenu(currentMenu);

        userInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    currentMenu = root;
                    displayMenu(currentMenu);
                    userInputField.setText("");
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    JOptionPane.showMessageDialog(null, "Программа завершена.");
                    System.exit(0);
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    handleUserInput();
                }
            }
        });
    }

    private void handleUserInput() {
        String input = userInputField.getText().trim();

        if (!input.isEmpty()) {
            try {
                int choice = Integer.parseInt(input);
                if (currentMenu.hasSubMenu() && choice > 0 && choice <= currentMenu.getSubMenu().size()) {
                    currentMenu = currentMenu.getSubMenu().get(choice - 1);
                    displayMenu(currentMenu);
                } else {
                    JOptionPane.showMessageDialog(null, "Неверный выбор!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Введите числовое значение!");
            }
        }

        userInputField.setText("");
    }

    private void displayMenu(MenuItem menuItem) {
        menuTextArea.setText(menuItem.getName() + "\n");
        if (menuItem.hasSubMenu()) {
            int index = 1;
            for (MenuItem subItem : menuItem.getSubMenu()) {
                menuTextArea.append(index + ". " + subItem.getName() + "\n");
                index++;
            }
        } else {
            menuTextArea.append("Нет подменю для расширения!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HierarchicalMenuGUI menuGUI = new HierarchicalMenuGUI();
            menuGUI.setVisible(true);
        });
    }
}

class MenuItem {
    private final String name;
    private final java.util.List<MenuItem> subMenu;

    public MenuItem(String name) {
        this.name = name;
        this.subMenu = new java.util.ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public java.util.List<MenuItem> getSubMenu() {
        return subMenu;
    }

    public void addSubMenu(MenuItem menuItem) {
        subMenu.add(menuItem);
    }

    public boolean hasSubMenu() {
        return !subMenu.isEmpty();
    }
}