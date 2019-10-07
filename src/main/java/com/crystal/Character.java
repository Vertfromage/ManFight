package com.crystal;

public interface Character {
    void isInjured(String attack);

    boolean isDead();

    String getName();

    String getClassName();

    boolean isScared();

    void setScared(boolean scared);

    boolean kick(Character characterBeingAttacked);

    boolean punch(Character characterBeingAttacked);

    boolean headbutt(Character characterBeingAttacked);

    boolean roar(Character characterBeingAttacked);

}
