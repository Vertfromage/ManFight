package com.crystal;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args) {

        title();
        //User creates a Mike character, who is either Fighter or Magician.
        Character user = CharacterCreation.CreateCharacter();

        //Computer creates either Hercules the Fighter or Robert the Magician
        int randomNum = (int) (Math.random() * ((1 - 0) + 1)) + 0;
        Character opponent;
        switch (randomNum) {
            case 0:
                opponent = new Fighter("Hercules");
                break;
            case 1:
                opponent = new Magician("Robert");
                break;
            default:
                opponent = new Fighter("Hercules");
        }
        ManFight fight = new ManFight(user, opponent);
        fight.startFight();
    }

    public static void title() {
        int width = 140;
        int height = 80;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("SansSerif", Font.BOLD, 24));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("ManFight",10,30);

        for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {
                sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");
            }
            if (sb.toString().trim().isEmpty()) {
                continue;
            }
            System.out.println(sb);
        }
    }
}
