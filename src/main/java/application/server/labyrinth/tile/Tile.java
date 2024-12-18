package application.server.labyrinth.tile;

import application.server.model.Player;

public class Tile {

    private int x;
    private int y;

    private TileType type;

    private char occupation = 'f';

    public Tile() {
        // for JPA
    }

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.type = TileType.FREE;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public char getOccupation() {
        return occupation;
    }

    public void setOccupation(char occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "" + this.type.value;
    }

    public boolean isEmpty() {
        return this.type == TileType.FREE && this.occupation == 'f';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        // for JPA
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        // for JPA
    }

    public boolean hit() {

        if (this.type == TileType.DESTRUCTIBLE) {
            this.type = TileType.FREE;
            return true;
        }
        return false;

    }

    public void addPlayer(Player player) {
        this.occupation = player.getIcon();
    }
}
