import java.util.Scanner;

/**
 * @author Luke Pecak
 */
public class RPG {
    
    private int xCord;
    private int yCord;
    private int zCord;
    private String cName;
    private String cClass;
    private String cRace;

    String classes[] = {"Fill", "Druid", "Barbarian", "Wizard", "Fighter"};
    String races[] = {"Fill", "Elf", "Human", "Dwarf", "Half-Elf"};
    String genericPrompts[] = {"You go Forward", "You go Backward", "You go Left", "You go Right", "You interact with: "};

    public RPG(){
        this.xCord = 0;
        this.yCord = 0;
        this.zCord = 0;
        this.cName = "";
        this.cClass = "";
        this.cRace = "";
    }

    public void characterCreator(String name, int chooseClass, int race){
        this.cName = name;

        this.cClass = this.classes[chooseClass];

        this.cRace = this.races[race];

        System.out.println("Your name is: " + this.cName + ". Your class is: " + this.cClass + ". Your race is: " + this.cRace + ".");
    }

    public void startCharacter(Scanner s){
        System.out.println("Welcome to Luke's RPG Game! This plays like any other standard (text-based) RPG game that you have played!");
        String inputName = " ";
        while (inputName.equals(" ")){
            System.out.print("To start, what is your characters name?: ");
            if (s.hasNextInt()){
                System.out.println("Please enter a non-number.");
                int holding = s.nextInt();
            }
            else {
                inputName = s.next();
            }
        }
        System.out.println("Now, you have four options for your characters class.");
        System.out.print("You have: ");
        for (int i = 1; i <= 4; i++){
            if (i != 4){
                System.out.print(this.classes[i] + ", ");
            }
            else {
                System.out.println(this.classes[i]);
            }
        }

        int inputClass = 0;
        while (inputClass == 0) {
            int tempInt = 0;
            while (tempInt == 0){
                System.out.print("Now, to enter a class, please enter a number from 1 to 4! (1 is far left, 4 is far right): ");
                if (!s.hasNextInt()){
                    System.out.println("Please enter a number (Note: No Decimals).");
                    String holding = s.next();
                }
                else {
                    tempInt = s.nextInt();
                    if (tempInt == 0) {
                        System.out.println("I am sorry, " + tempInt + " is not an option. Please choose something within the predefined boundaries.");
                    }
                }
            }
            if (tempInt <= 0 || tempInt > 4){
                System.out.println("I am sorry, " + tempInt + " is not an option. Please choose something within the predefined boundaries.");
            }
            else {
                inputClass = tempInt;
            }
        }
        System.out.println("You have chosen: " + this.classes[inputClass]);
        System.out.println("Now, you have four options for your characters race.");
        System.out.print("You have: ");
        for (int i = 1; i <= 4; i++){
            if (i != 4){
                System.out.print(this.races[i] + ", ");
            }
            else {
                System.out.println(this.races[i]);
            }
        }
        int inputRace = 0;
        while (inputRace == 0){
            int tempInt = 0;
            while (tempInt == 0){
                System.out.print("To enter a race, please enter a number from 1 to 4! (Follows same rules as choosing a class): ");
                if (!s.hasNextInt()){
                    System.out.println("Please enter a number (Note: No Decimals).");
                    String holding = s.next();
                }
                else {
                    tempInt = s.nextInt();
                    if (tempInt == 0) {
                        System.out.println("I am sorry, " + tempInt + " is not an option. Please enter something within the predefined boundaries.");
                    }
                }
            }
            if (tempInt <= 0 || tempInt > 4){
                System.out.println("I am sorry, " + tempInt + " is not an option. Please choose something within the predefined boundaries.");
            }
            else {
                inputRace = tempInt;
            }
        }
        System.out.println("You have chosen: " + this.races[inputRace]);
        characterCreator(inputName, inputClass, inputRace);
    }

    public void startGame(Scanner s) {
        System.out.println("You wake up in your bed in the town of MountainTop. It is a village situated a bit high in the mountains, and the season is currently winter. Your home is a two story cabin");
        int action = 0;
        while (action == 0){
            System.out.print("You see: A Mirror (1), A Cabinet (2), and A Door (3). Please select one to interact with: ");
            if (!s.hasNextInt()){
                System.out.println("Please choose a number. (Note: No Decimals)");
                String holding = s.next();
            }
            else {
                int tempInt = s.nextInt();
                if (tempInt < 1 || tempInt > 3){
                    System.out.println("I am sorry, " + tempInt + " is not an option. Please choose something within the predefined boundaries.");
                }
                else {
                    action = tempInt;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        RPG rpg = new RPG();
        rpg.startCharacter(s);
        rpg.startGame(s);
    }
}