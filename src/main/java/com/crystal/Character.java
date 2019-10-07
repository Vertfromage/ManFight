package com.crystal;

public interface Character {
    void receiveDamage(String attack);

    boolean isDead();

    String getName();

    String getClassName();

    boolean isScared();

    void setScared(boolean scared);

    boolean attack(String move, Character characterBeingAttacked);
}
