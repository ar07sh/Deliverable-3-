package uno;




import java.util.ArrayList;
import java.util.Scanner;

public class UnoPlayer extends Player{


    private ArrayList<UnoCards> playercards;

    public UnoPlayer(String name) {
        super(name);
        playercards = new ArrayList<UnoCards>();
    }

    public int numberOfCards() {
        return playercards.size();
    }

    public ArrayList<UnoCards> PlayerCards(){
        return playercards;
    }


    public void pickCards(UnoCards c) {
        playercards.add(c);
    }

    public UnoCards throwCard(int c) {
        return playercards.remove(c);
    }

    public void sayUno() {
        Scanner s = new Scanner(System.in);

        if (playercards.size()==1){

            System.out.println("Uno");
            System.out.println("Press Enter...");
            s.nextLine();
        }
    }


    public void showCards() {
        String[] card = {" ----- ","|     |","|     |"," ----- "};
        String c = "";

        for(int i=0;i<card.length;i++) {
            for(int j=0;j<playercards.size();j++) {
                if(!playercards.get(j).isSpecial()) {
                    if(i==1) {
                        c = c +"| "+playercards.get(j).getColor()+" |"+" ";
                    }
                    else if(i==2) {
                        c = c + "|  "+playercards.get(j).getValue()+"  |"+" ";
                    }
                    else {
                        c = c + card[i]+" ";
                    }
                }
                else if(playercards.get(j).isSpecial()) {
                    if(i==1) {
                        c = c +"| "+"+"+playercards.get(j).getValue()+"  |"+" ";
                    }
                    else {
                        c = c + card[i]+" ";
                    }
                }
            }
            c +="\n";
        }
        System.out.print(c);
    }

    public void hideCards() {
        String[] card = {" ----- ","|     |","|     |"," ----- "};
        String c = "";

        for(int i=0;i<card.length;i++) {
            for(int j=0;j<playercards.size();j++) {
                c = c + card[i]+" ";
            }
            c+="\n";
        }

        System.out.print(c);
    }

    public boolean hasWon() {
        return playercards.size()==0;
    }

    public String toString() {
        return getPlayerID();
    }


    @Override
    public void play() {
        showCards();
    }
}

