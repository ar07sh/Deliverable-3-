package uno;

public class UnoCards extends Card {
    private String color;
    private int value;
    private int specialValue;
    private boolean special;

    public UnoCards(int value, String color) {
        this.color = color;
        this.value = value;
        this.specialValue = 0;
        this.special = false;
    }

    public UnoCards(int specialValue) { // constructor for special cards like +4 and +2

        this.color = "";
        this.specialValue = specialValue;
        this.value = 0;
        this.special = true;
    }

    public String getColor() {
        return this.color;
    }

    public int getValue() {
        if (!this.special) {
            return this.value;
        } else {
            return this.specialValue;
        }
    }


    public String toString() {
        String[] card = {" ----- ", "|     |", "|     |", " ----- "};
        String c = "";

        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < 1; j++) {
                if (!this.isSpecial()) {
                    if (i == 1) {
                        c = c + "| " + this.getColor() + " |" + " ";
                    } else if (i == 2) {
                        c = c + "|  " + this.getValue() + "  |" + " ";
                    } else {
                        c = c + card[i] + " ";
                    }
                } else if (this.isSpecial()) {
                    if (i == 1) {
                        c = c + "| " + "+" + this.getValue() + "  |" + " ";
                    } else {
                        c = c + card[i] + " ";
                    }
                }
            }
            c += "\n";
        }
        return c;
    }

    public boolean isSpecial() {
        return special;
    }
}
