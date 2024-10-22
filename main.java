abstract class Pokemon {
    private String name;
    private int level;
    private String[] evolutions;
    
    public Pokemon(String name, int level, String[] evolutions) {
        this.name = name;
        this.level = level;
        this.evolutions = evolutions;
    }

    void battleBegin() {
        System.out.println("Battle Begin!");
    }
    
    abstract void attack();

    void battleCry() {
        System.out.println(name + " makes a battle cry!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        System.out.println(this.name +"'s level has increased to " + this.level);
        evolve();
    }

    public void battleResult(Pokemon opponent) {
        if (this.level > opponent.getLevel()) {
            System.out.println(opponent.getName() + " has fainted.");
            System.out.println(this.name + " has won the battle!");
        } else if (this.level < opponent.getLevel()) {
            System.out.println(this.name + " has fainted.");
            System.out.println(opponent.getName() + " has won the battle!");
        } else {
            System.out.println("It's a tie! Both Pokemon fought well.");
        }
    }
    
    public void evolve(){
        if (this.level >= 16 && this.level < 36 && !this.name.equals(evolutions[1])) {
            this.name = evolutions[1];
            System.out.println("Congratulations! " + evolutions[0] + " has evolved into " + evolutions[1] + "!");
        } else if (this.level >= 36 && !this.name.equals(evolutions[2])) {
            this.name = evolutions[2];
            System.out.println("Congratulations! " + evolutions[1] + " has evolved into " + evolutions[2] + "!");
        }
    }
}

class Bulbasaur extends Pokemon {
    private static final String[] BULBASAUR_EVOLUTIONS = {"Bulbasaur", "Ivysaur","Venusaur"};

    public Bulbasaur(String name, int level) {
        super(name, level, BULBASAUR_EVOLUTIONS);
    }

    void attack() {
        System.out.println(getName() + " uses Razor Leaf!");
    }
}

class Charmander extends Pokemon {
    private static final String[] CHARMANDER_EVOLUTIONS = {"Charmander", "Charmeleon", "Charizard"};

    public Charmander(String name, int level) {
        super(name, level, CHARMANDER_EVOLUTIONS);
    }

    void attack() {
        System.out.println(getName() + " uses Flamethrower!");
    }
}

public class Main {
    public static void main(String[] args) {
        Bulbasaur bulbasaur = new Bulbasaur("Bulbasaur", 10);
        Charmander charmander = new Charmander("Charmander", 12);
        
        bulbasaur.battleBegin();

        bulbasaur.battleCry();
        bulbasaur.attack();
        
        charmander.battleCry();
        charmander.attack();

        bulbasaur.battleResult(charmander);
        
        charmander.setLevel(16);
    }
}
