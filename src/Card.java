public class Card {
    private final int value;
    private final String type;

    public Card(int value, String type) {
        this.value = value;
        this.type = type;
    }

    public int getValue() {
        return ((value==1) ? 11 : Math.min(value,10));
    }

    @Override
    public String toString() {
        switch (value) {
            case 1 -> {return type + '-' + 'A';}
            case 11 -> {return type + '-' + "J";}
            case 12 -> {return type + '-' + "Q";}
            case 13 -> {return type + '-' + "K";}
            default -> {return type + '-' + value;}
        }
    }
}
