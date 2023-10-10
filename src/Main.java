public class Main {
    public static void main(String[] args) {
        Creature ivan = new Player("ivan", 20, 25, 50, 30);
        Creature victor = new Monster("victor", 10, 10, 30, 15);
        ivan.attack(victor);
        victor.heal();
        victor.heal();
        victor.heal();
        victor.heal();
        victor.heal();
        ivan.attack(victor);
    }
}