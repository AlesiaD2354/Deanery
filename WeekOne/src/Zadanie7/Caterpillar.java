package Zadanie7;

import javax.swing.*;
import java.awt.*;

public class Caterpillar extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Установка прозрачного цвета для заливки
        Color transparentWhite = new Color(255, 255, 255, 0); // Прозрачный белый
        g2d.setColor(transparentWhite);

        // Нарисовать фон с прозрачностью
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Установка цвета на черный для контура элементов гусеницы
        g2d.setColor(Color.BLACK);

        // Нарисовать 4 круга туловища с ногами (горизонтальные)
        int bodyDiameter = 50;
        int bodyX = 50;
        int bodyY = 250;

        for (int i = 0; i < 4; i++) {
            g2d.setColor(Color.BLACK);
            g2d.drawOval(bodyX, bodyY, bodyDiameter, bodyDiameter);
            g2d.setColor(Color.WHITE);
            g2d.fillOval(bodyX + 1, bodyY + 1, bodyDiameter - 1, bodyDiameter - 1);
            g2d.setColor(Color.BLACK);
            g2d.fillRect(bodyX + 10, bodyY + bodyDiameter - 5, 10, 5);
            g2d.fillRect(bodyX + 30, bodyY + bodyDiameter - 5, 10, 5);
            bodyX += bodyDiameter * 0.75;
        }

        // Нарисовать 3 круга туловища (вертикальные)
        int bodyXVertical = 168;
        int bodyYVertical = 214;

        for (int i = 0; i < 3; i++) {
            g2d.setColor(Color.BLACK);
            g2d.drawOval(bodyXVertical, bodyYVertical, bodyDiameter, bodyDiameter);
            g2d.setColor(Color.WHITE);
            g2d.fillOval(bodyXVertical + 1, bodyYVertical + 1, bodyDiameter - 1, bodyDiameter - 1);
            bodyYVertical -= bodyDiameter * 0.75;
        }

        // Добавить черные глаза в виде точек в верхний вертикальный круг туловища
        g2d.setColor(Color.BLACK);
        g2d.fillOval(185, 155, 5, 5); // Координаты для левого глаза
        g2d.fillOval(197, 155, 5, 5); // Координаты для правого глаза


        // Нарисовать улыбку в верхнем вертикальном круге туловища
        g2d.setColor(Color.BLACK);
        g2d.drawArc(183, 167, 20, 10, 190, 160);

        // Нарисовать усики над верхним вертикальным кругом туловища
        g2d.drawLine(188, 140, 180, 105); // Левый ус
        g2d.drawLine(204, 140, 210, 105); // Правый ус
        g2d.fillOval(205, 100, 10, 10); // Черная точка правого уса
        g2d.fillOval(175, 100, 10, 10); // Левая точка левого уса
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.add(new Caterpillar());
        frame.setVisible(true);
    }
}