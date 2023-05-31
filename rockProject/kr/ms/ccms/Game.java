package kr.ms.ccms;

import java.util.ArrayList;
import java.util.Scanner;


public class Game {
    private Dealer dealer;
    private ArrayList<Player> players;
    private final double RATE = 0.7;

    public Game(){
        dealer = new Dealer(RATE);
        players = new ArrayList<Player>();
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        System.out.print("How many players : ");
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            System.out.print(" Player"+(i+1)+" Name : ");
            String name = sc.next();
            Player temp = new Player(new Hand(0), name, 100);
            players.add(temp);
        }
        boolean flag = true;
        while(flag){
            for(Player p : players){
                System.out.print(p.getName() + " -> Rock(0), Scissors(1), Paper(2) : ");
                int h = sc.nextInt();
                this.dealer.setHand(p);
                p.printMatch(dealer);
                System.out.println(p.getName()+" has " +p.getScore() + "$");
                if(p.getScore()<0){
                    System.out.println(p.getName()+" bankrupt!!!");
                    players.remove(p);
                    break;
                    
                }
            }
            if(players.size()==0) flag = false;
        }
    }
}
