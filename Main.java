import java.util.Scanner;
public class Main {
    public static double initialBankroll = 0;
    public static void menu(){
        Scanner scanner;
        boolean running = true;
        System.out.println("Enter a starting bankroll:");
        scanner = new Scanner(System.in);
        double b = scanner.nextDouble();
        Stats.bankroll += b;
        initialBankroll = b;
        String input;
        while(running){
            System.out.println("");
            System.out.println("To add a session type A");
            System.out.println("To remove a session type R");
            System.out.println("To see stats type S");
            System.out.println("To quit type Q");
            scanner = new Scanner(System.in);
            input = scanner.next();
            if(input.equals("a") || input.equals("A")){
                System.out.println("Type C to add a cash game or T to add a tournament");
                scanner = new Scanner(System.in);
                input = scanner.next();
                if(input.equals("c")||input.equals("C")){
                    double buyin, cashout, bigBlind, minutesPlayed;
                    System.out.println("Buy-in: ");
                    scanner = new Scanner(System.in);
                    buyin = scanner.nextDouble();
                    System.out.println("Cashout: ");
                    scanner = new Scanner(System.in);
                    cashout = scanner.nextDouble();
                    System.out.println("What was the Big Blind?");
                    scanner = new Scanner(System.in);
                    bigBlind = scanner.nextDouble();
                    System.out.println("How long did you play in minutes?");
                    scanner = new Scanner(System.in);
                    minutesPlayed = scanner.nextDouble();
                    Stats.addCashGame(buyin,cashout,bigBlind,minutesPlayed);
                }
                if(input.equals("t") || input.equals("T")){
                    double buyin,cashout,minutesPlayed; int players;
                    System.out.println("Buy-in: ");
                    scanner = new Scanner(System.in);
                    buyin = scanner.nextDouble();
                    System.out.println("Cashout: ");
                    scanner = new Scanner(System.in);
                    cashout = scanner.nextDouble();
                    System.out.println("How many players were in the tournament?");
                    scanner = new Scanner(System.in);
                    players = scanner.nextInt();
                    System.out.println("How long did you play in minutes?");
                    scanner = new Scanner(System.in);
                    minutesPlayed = scanner.nextDouble();
                    Stats.addTournament(buyin,cashout,minutesPlayed,players);
                }
            }
            if(input.equals("r") || input.equals("R")){
                System.out.println("Type C to remove a cash game or T to remove a tournament");
                scanner = new Scanner(System.in);
                input = scanner.next();
                if(input.equals("c") || input.equals("C")){
                    System.out.println("Type L to remove the last Cash Game or I to remove a Cash Game by index");
                    scanner = new Scanner(System.in);
                    input = scanner.next();
                    if(input.equals("L") || input.equals("l")){
                        Stats.removeLastCashGame();
                    }
                    if(input.equals("i") || input.equals("I")){
                        System.out.println("Index: ");
                        int index;
                        index = scanner.nextInt();
                        Stats.removeCashGameByIndex(index);
                    }
                }
                if(input.equals("t") || input.equals("T")){
                    System.out.println("Type L to remove the last tournament or I to remove a tournament by index");
                    scanner = new Scanner(System.in);
                    input = scanner.next();
                    if(input.equals("L") || input.equals("l")){
                        Stats.removeLastTournament();
                    }
                    if(input.equals("i") || input.equals("I")){
                        System.out.println("Index: ");
                        int index;
                        index = scanner.nextInt();
                        Stats.removeTournamentByIndex(index);
                    }
                }
            }
            if(input.equals("s") || input.equals("S")){
                System.out.println("Type T to see tournament Stats");
                System.out.println("Type C to see Cash Game Stats");
                System.out.println("Type F to see a full report");
                scanner = new Scanner(System.in);
                input = scanner.next();
                if(input.equals("t")||input.equals("T")){
                    Stats.printTournamentStats();
                }
                if(input.equals("c")||input.equals("C")){
                    Stats.printCashGameStats();
                }
                if(input.equals("f")||input.equals("F")){
                    Stats.printFullReport();
                }
            }
            if(input.equals("q")||input.equals("Q")){
                running = false;
            }
        }

    }
    public static void main(String[] args) {
        menu();
    }
}
