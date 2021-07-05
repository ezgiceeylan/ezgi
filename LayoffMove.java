package rummy.game.domain.move;

import java.util.Objects;
import rummy.game.domain.Layoff;
import rummy.game.domain.Player;

/**
 * Represents a move where the player lays off a card from their hand.
 */
public class LayoffMove extends Move {

    private final Layoff layoff;

    public LayoffMove(Player player, Layoff layoff) {
        super(player);
        this.layoff = layoff;
    }

    public Layoff getLayoff() {
        return this.layoff;
    }

    @Override
    public LayoffMove copy() {
        return new LayoffMove(super.getPlayer(), this.layoff.copy());
    }

    @Override
    public String type() {
        return "layoff";
    }

    @Override
    public String toString() {
        return "Layoff " + layoff.getCard() + " into meld " + layoff.getMeld();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.layoff);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LayoffMove other = (LayoffMove) obj;
        return this.layoff.equals(other.layoff);
    }

}
