import java.util.ArrayList;
public class Stats {
    public static double bankroll;
    static double ROI, BBPH, THourly, CHourly;
    static ArrayList<CashGame> cashGames = new ArrayList<>();
    static ArrayList<Tournament> tournaments = new ArrayList<>();
    static double totalMinutesPlayed = 0, totalCashouts = 0, totalBuyins = 0;
    static double changeInBB = 0, totalMPCash = 0, cashProfit = 0;
    public static void addCashGame(double buyin, double cashout, double bigBlind, double minutesPlayed){
        CashGame cashGame = new CashGame(buyin, cashout, bigBlind, minutesPlayed);
        cashGames.add(cashGame);
    }
    public static void removeLastCashGame(){
        cashGames.remove(cashGames.size()-1);
    }
    public static void removeCashGameByIndex(int index){
        cashGames.remove(index);
    }
    public static void addTournament(double buyin, double cashout, double minutesPlayed, int players){
        Tournament tournament = new Tournament(buyin, cashout, minutesPlayed, players);
        tournaments.add(tournament);
    }
    public static void removeLastTournament(){
        tournaments.remove(tournaments.size()-1);
    }
    public static void removeTournamentByIndex(int index){
        tournaments.remove(index);
    }
    public static void getTournamentStats(){
        Tournament tournament;
        totalBuyins = 0; totalCashouts = 0; totalMinutesPlayed = 0; ROI = 0; THourly = 0;
        for(int i = 0; i < tournaments.size(); i++){
            tournament = tournaments.get(i);
            totalBuyins += tournament.b;
            totalCashouts += tournament.c;
            totalMinutesPlayed += tournament.mp;
        }
        ROI = (totalCashouts-totalBuyins)/totalBuyins;
        THourly = (totalCashouts-totalBuyins)/(totalMinutesPlayed/60);
        updateBankroll(Main.initialBankroll);
    }
    public static void printTournamentStats(){
        getTournamentStats();
        System.out.println("|Tournament Stats|");
        System.out.println("Total Profit: "+(totalCashouts-totalBuyins));
        System.out.println("ROI: "+ROI);
        System.out.println("Hourly: "+THourly);
        System.out.println("Tournaments played: "+tournaments.size());
    }
    public static void getCashGameStats(){
        CashGame cashGame;
        totalMPCash = 0; cashProfit = 0; changeInBB = 0; CHourly = 0; BBPH = 0;
        for(int i = 0; i<cashGames.size();i++){
            cashGame = cashGames.get(i);
            totalMPCash += cashGame.mp;
            cashProfit += cashGame.c - cashGame.b;
            changeInBB += cashProfit/cashGame.BB;
        }
        CHourly = cashProfit/(totalMPCash/60);
        BBPH = changeInBB/(totalMPCash/60);
        updateBankroll(Main.initialBankroll);
    }
    public static void printCashGameStats(){
        getCashGameStats();
        System.out.println("|Cash Game Stats|");
        System.out.println("Total Profit: "+cashProfit);
        System.out.println("Big Blinds per hour: "+BBPH);
        System.out.println("Hourly: "+CHourly);
        System.out.println("Hours played: "+(totalMPCash/60));
    }
    public static void printFullReport(){
        getCashGameStats();
        getTournamentStats();
        printTournamentStats();
        printCashGameStats();
        System.out.println("Bankroll: $"+bankroll);
    }
    static void updateBankroll(double initial){
        bankroll = initial;
        bankroll += cashProfit;
        bankroll += (totalCashouts-totalBuyins);
    }
}