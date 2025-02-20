public enum Direction
{
EAST("E"),WEST("W"),SOUTH("S"),NORTH("N");
private final String sCode;

    Direction(String sCode) {
        this.sCode = sCode;
    }

    public String getSCode()
{
    return sCode;
}
}

class Test {
    public static void main(String args[]) {

    }

}