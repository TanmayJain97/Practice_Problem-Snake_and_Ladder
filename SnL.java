import java.util.*;

public class SnL {
	static int victory_flag=0;
	static int count=0;
	
	public static void main(String[] args) {
		int p1=0; int p2 = 0; 				//Initial posn.
		int countP1 = 0; int countP2 = 0;   //Roll count
		
		while (victory_flag==0) {
			System.out.println();
			System.out.println("Player 1's turn");
			p1=go(p1);					//Initiating P1 move
			countP1=countP1+count+1;
			count=0;
			if (p1==100) {
				victory_flag=1;
				break;
			}
			System.out.println();
			System.out.println("Player 2's turn");
			p2=go(p2);					//Initiating P2 move
			countP2=countP2+count+1;
			count=0;
			if (p2==100) {
				victory_flag=2;
				break;
			}
		}
		if (victory_flag==1) {
			System.out.println("Player 1 has won the game.");
		}
		else if (victory_flag==2) {
			System.out.println("Player 2 has won the game.");
		}
		System.out.println("Player 1's total moves were "+countP1);
		System.out.println("Player 2's total moves were "+countP2);
	}
	
	public static int go(int pos) {
		int move;
			//Rolling a die
			Random rand = new Random();
			int die=(rand.nextInt(6)+1);
			//System.out.println(die);
			
			//checking Snake or Ladder
			move=rand.nextInt(3);
			//System.out.println(move);
			
			//Moving to new pos
			switch(move) {
				case 1:
					if ((pos+die)>100) {		//Checking for posn>100 condition
						System.out.println("Cannot move over 100. You stay at "+pos);
						pos=go(pos);
					}else {
						pos=pos+die;  //Ladder
						System.out.println("You got a ladder and jumped to "+pos);
						count++;
						if (pos==100) {
							break;
						}
						System.out.println("You get another turn.");
						pos=go(pos);
					}
					break;
				case 2:
					if ((pos-die)<0) {			//In case of position<0 condition
						System.out.println("Cannot move below 0. You restart from 0");
						pos=0;
					}else {
						pos=pos-die;  //Snake
						System.out.println("You bit a snake and fell to "+pos);
					}
					break;
				default:                   //No Play
					System.out.println("No Play. Stay at "+pos);
			}
		return pos;
	}
	
}
