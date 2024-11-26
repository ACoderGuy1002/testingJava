import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    private String room;
    private int bedTime;
    private File saves;
    private FileWriter writer;
    private boolean clothesOn;
    private String saveName;

    String classes[] = {"Fill", "Druid", "Barbarian", "Wizard", "Fighter"};
    String races[] = {"Fill", "Elf", "Human", "Dwarf", "Half-Elf"};
    String rooms[] = {"Fill", "Bedroom", "UpperHallway"};

    public RPG(){
        this.xCord = 0;
        this.yCord = 0;
        this.zCord = 0;
        this.cName = "";
        this.cClass = "";
        this.cRace = "";
        this.room = "";
        this.bedTime = 0;
        this.clothesOn = false;
        this.saveName = "";
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

    public void bedroom(Scanner s) {
        if (this.bedTime == 0) {
            System.out.println("You wake up in your bed in the town of MountainTop. It is a village situated a bit high in the mountains, and the season is currently winter. Your home is a two story cabin");
            this.room = "Bedroom";
            this.bedTime += 1;
        } else {
            System.out.println("You are now in your bedroom.");
        }
        while (this.room.equals("Bedroom")){
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

            if (action == 1){
                System.out.println("Its you!");
            }
            else if (action == 2 && this.clothesOn == false){
                System.out.println("You see that your cabinet is full of clothes, and you are currently wearing none.");
                String choice = "";
                while (choice.equals("")){
                    System.out.print("Would you like to put on some clothes? (Y or N): ");
                    if (s.hasNextInt()){
                        System.out.println("Please enter Y or N.");
                        int hold = s.nextInt();
                    }
                    else if (s.hasNext()){
                        String temp = s.next().toLowerCase();
                        if (!temp.equals("y") && !temp.equals("n")){
                            System.out.println("Please enter Y or N");
                        }
                        else {
                            choice = temp;
                        }
                    }

                }
                if (choice.equals("y") && this.clothesOn == false) {
                    System.out.println("You put on some nice, warm winter clothes. They are made out of wool and are extremely comfy.");
                    clothesOn = true;
                }
                else if (choice.equals("n") && this.clothesOn == false) {
                    System.out.println("I suppose putting on no clothes is a bold fashion statement...");
                }

            }
            else if (action == 2 && this.clothesOn == true) {
                System.out.println("...you already have clothes on.");
            }
            else if (action == 3) {
                String choice = "";
                while (choice.equals("")){
                    System.out.print("Would you like to go to the next room? (Y or N): ");
                    if (s.hasNextInt()){
                        System.out.println("Please enter Y or N");
                        int hold = s.nextInt();
                    }
                    else if (s.hasNext()) {
                        String temp = s.next().toLowerCase();
                        if (!temp.equals("y") && !temp.equals("n")){
                            System.out.println("Please enter Y or N");
                        }
                        else {
                            choice = temp;
                        }
                    }
                }

                if (choice.equals("y")){
                    if (this.clothesOn == true){
                        System.out.println("You decide to step out into your hallway...");
                    } else {
                        System.out.println("So uhhh.... you decide to step out into your hallway... wearing no clothes...");
                    }

                    this.room = "UpperHallway";
                    writeToSave();
                }
                else {
                    System.out.println("You decide to explore your room some more.");
                }
            }
        }

    }

    public String getRoom() {
        return this.room;
    }

    public void hallway(Scanner s) {
        System.out.println("You are now in your hallway. To your left, you see another door that is closed. To your right, you see a window that looks outside. In front of you, you see a staircase leading down.");
        int choice = 0;
        while (this.room.equals("UpperHallway")){
            System.out.print("Please choose either: Door (1), Window (2), Stairs (3) or Go Back (4): ");
            if (s.hasNextInt()) {
                choice = s.nextInt();
                if (choice == 1) {
                    System.out.println("You open the door, and find yourself in a bathroom. It has a toilet, sink and a shower.");
                    int bChoice = 0;
                    int toilet = 1;
                    int wash = 1;
                    while (bChoice != 4){
                        System.out.print("Please choose either: Toilet (1), Sink (2), Shower (3) or Leave the Room (4): ");
                        if (s.hasNextInt()){
                            bChoice = s.nextInt();
                            if (bChoice == 1){
                                System.out.println("You decide to use the Toilet. There is nothing interesting to note here.");
                                toilet = 0;
                            } else if (bChoice == 2) {
                                if (toilet == 0) {
                                    System.out.println("Hey look at that! You decided to wash your hands after using the Toilet!");
                                    wash = 0;
                                }
                                else {
                                    System.out.println("I mean, washing your hands couldn't hurt, right?");
                                }
                            } else if (bChoice == 3) {
                                System.out.println("You turn the shower handle, and ice starts to come out of the shower head. It is winter after all.");
                            } else if (bChoice == 4) {
                                if (toilet == 0 && wash == 1) {
                                    System.out.println("Hey buddy, perhaps you should wash your hands after using the bathroom.");
                                } else if (toilet == 0 && wash == 0) {
                                    System.out.println("Good on you for washing your hands!");
                                } else {
                                    System.out.println("You leave the bathroom. Was this really needed?");
                                }
                            } else {
                                System.out.println("So uhh... you know you should choose an option given to you... (No Decimals)");
                            }
                        }
                        else {
                            System.out.println("Please choose a number. (No decimals)");
                            String hold = s.next();
                        }
                    }
                }
                else if (choice == 2){
                    System.out.println("You look out of the window. You see many snow-covered trees, rising mountains in the distance and houses.");
                }
                else if (choice == 3){
                    System.out.println("You decide to go down the stairs...");
                    this.room = "DownStairs";
                    writeToSave();
                } else if (choice == 4) {
                    System.out.println("You decide to go back into your bedroom...");
                    this.room = "Bedroom";
                    writeToSave();
                } else if (choice != 0) {
                    System.out.println("Please choose a number within the defined parameters. (No decimals)");
                }
            }
            else if (s.hasNext()) {
                System.out.println("Please choose an option available to you");
                String hold = s.next();
            }
        }
    }

    public void downStairs(Scanner s) {
        System.out.println("");
    }

    public void createSave(Scanner s) {
        boolean saveTime = true;
        File currentDir = new File(".");
        File[] textFiles = currentDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
        try {
            while (saveTime == true){
                System.out.print("Available save files: ");
                for (File file : textFiles) {
                    System.out.print(file.getName() + ", ");
                }
                System.out.println("");
                System.out.print("Enter the name of your save! (Without .txt): ");
                if (s.hasNextInt()) {
                    System.out.println("Please enter a non-number!");
                    int hold = s.nextInt();
                } else if (s.hasNext()) {
                    this.saveName = s.next();
                    saveTime = false;
                }
            }
            this.saves = new File(this.saveName + ".txt");
            if (this.saves.createNewFile()) {
                System.out.println("Your saves is created as: " + this.saves.getName());
            } else {
                System.out.println("This save already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred...");
            e.printStackTrace();
        }
    }
    
    public void writeToSave() {
        try {
            this.writer = new FileWriter(this.saves.getName());
            this.writer.write("room=" + this.room + "\n");
            this.writer.write("xCord=" + this.xCord + "\n");
            this.writer.write("yCord=" + this.yCord + "\n");
            this.writer.write("zCord=" + this.zCord + "\n");
            this.writer.write("cName=" + this.cName + "\n");
            this.writer.write("cClass=" + this.cClass + "\n");
            this.writer.write("cRace=" + this.cRace + "\n");
            this.writer.write("hasClothes=" + this.clothesOn + "\n");
            System.out.println("Saved!");
            this.writer.close();
        } catch (IOException e) {
            System.out.println("It seems that... an error occurred.");
            e.printStackTrace();
        }
    }

    public int getSave(Scanner s) {
        boolean loadSave = false;
        boolean choose = true;
        while (choose == true){
            System.out.print("Would you like to load your save? (Y or N): ");
            if (s.hasNextInt()){
                System.out.println("Please enter Y or N");
                int hold = s.nextInt();
            } else if (s.hasNext()) {
                String load = s.next().toLowerCase();
                if (!load.equals("y") && !load.equals("n")) {
                    System.out.println("Please enter Y or N");
                } else if (load.equals("y")) {
                    System.out.println("Loading save...");
                    choose = false;
                    loadSave = true;
                } else if (load.equals("n")){
                    System.out.println("Ooooo! A new save time eh?");
                    choose = false;
                    loadSave = false;
                }
            }
        }

        if (this.saves.getName().equals("save1.txt") && this.saves.length() != 0 && loadSave == true) {
            try (BufferedReader reader = new BufferedReader(new FileReader(this.saves.getName()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("=");
                    switch (parts[0]) {
                        case "room":
                            this.room = parts[1];
                            break;
                        case "xCord":
                            this.xCord = Integer.parseInt(parts[1]);
                            break;
                        case "yCord":
                            this.yCord = Integer.parseInt(parts[1]);
                            break;
                        case "zCord":
                            this.zCord = Integer.parseInt(parts[1]);
                            break;
                        case "cName":
                            this.cName = parts[1];
                            break;
                        case "cClass":
                            this.cClass = parts[1];
                            break;
                        case "cRace":
                            this.cRace = parts[1];
                            break; 
                    }
                }
            } catch (IOException e) {
                System.out.println("Save has not been loaded... an error has occurred.");
                e.printStackTrace();
            }
            System.out.println("Save has been loaded.");
            return 1;
        } 
        else {
            return 0;
        }
    } 

    public String[] getRooms() {
        return this.rooms;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String room = "";
        RPG rpg = new RPG();
        rpg.createSave(s);
        int isSaved = rpg.getSave(s);
        if (isSaved == 0) {
            rpg.startCharacter(s);
            rpg.bedroom(s);
            room = rpg.getRoom();
        } else {
            room = rpg.getRoom();
        }
        while (!room.equals(" ")) {
            room = rpg.getRoom();
            String rooms[] = rpg.getRooms();
            if (room.equals(rooms[2])) {
                rpg.hallway(s);
            }
            else if (room.equals(rooms[1])) {
                rpg.bedroom(s);
            }
        }
    }
}