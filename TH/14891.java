import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> Gear1 = new ArrayList<>();
        ArrayList<Integer> Gear2 = new ArrayList<>();
        ArrayList<Integer> Gear3 = new ArrayList<>();
        ArrayList<Integer> Gear4 = new ArrayList<>();
        ArrayList<rotate> rotateList = new ArrayList<>();
        for (int i = 0; i <8 ; i++) {
            Gear1.add(sc.nextInt());
        }
        for (int i = 0; i <8 ; i++) {
            int b = sc.nextInt();
            Gear2.add(b);
        }
        for (int i = 0; i <8 ; i++) {
            int c = sc.nextInt();
            Gear3.add(c);
        }
        for (int i = 0; i <8 ; i++) {
            int d = sc.nextInt();
            Gear4.add(d);
        }
        int count = sc. nextInt();
        for (int i = 0; i <count ; i++) {
            int number = sc.nextInt();
            int direction = sc.nextInt();
            rotateList.add(new rotate(number,direction));
        }
        for (int i = 0; i <rotateList.size() ; i++) {
            switch(rotateList.get(i).number)
            {
                case 1:
                    if(Gear1.get(2)!=Gear2.get(7))
                    {
                        if(Gear2.get(2)!=Gear3.get(7)){
                            if(Gear3.get(2)!=Gear4.get(7)){
                                move(!rotateList.get(i).direction,Gear4);
                            }
                            move(rotateList.get(i).direction,Gear3);
                        }
                        move(!rotateList.get(i).direction,Gear2);
                    }
                    move(rotateList.get(i).direction,Gear1);
                    break;
                case 2:
                    if(Gear2.get(2)!=Gear3.get(7)){
                        if(Gear3.get(2)!=Gear4.get(7)){
                            move(!rotateList.get(i).direction,Gear4);
                        }
                        move(rotateList.get(i).direction,Gear3);
                    }
                    if(Gear1.get(2)!=Gear2.get(7))
                    {
                        move(!rotateList.get(i).direction,Gear1);
                    }
                    move(rotateList.get(i).direction,Gear2);
                    break;
                case 3:
                    if(Gear2.get(2)!=Gear3.get(7)){
                        if(Gear1.get(2)!=Gear2.get(7)){
                            move(!rotateList.get(i).direction,Gear1);
                        }
                        move(rotateList.get(i).direction,Gear2);
                    }
                    if(Gear3.get(2)!=Gear4.get(7))
                    {
                        move(!rotateList.get(i).direction,Gear4);
                    }
                    move(rotateList.get(i).direction,Gear3);
                    break;
                case 4:
                    if(Gear3.get(2)!=Gear4.get(7))
                    {
                        if(Gear2.get(2)!=Gear3.get(7)){
                            if(Gear1.get(2)!=Gear2.get(7)){
                                move(!rotateList.get(i).direction,Gear1);
                            }
                            move(rotateList.get(i).direction,Gear2);
                        }
                        move(!rotateList.get(i).direction,Gear3);
                    }
                    move(rotateList.get(i).direction,Gear4);
                    break;
            }
        }
        System.out.print(score(Gear1.get(0),Gear2.get(0),Gear3.get(0),Gear4.get(0)));
    }
    public static void move(boolean A,ArrayList<Integer> Gear){
        if(A == true){
            Gear.add(0,Gear.get(7));
            Gear.remove(8);
        }
       else
        {
            Gear.add(Gear.get(0));
            Gear.remove(0);
        }
    }
    public static int score(int a, int b, int c, int d)
    {
        int score = 0;
        if(a == 1)
            score++;
        if(b == 1)
            score = score + 2;
        if(c == 1)
            score = score + 4;
        if(d == 1)
            score = score + 8;
        return score;
    }
    public static class rotate {
        int number;
        boolean direction;

        public rotate(int number, int direction){
            this.number = number;
            if(direction == 1)
                this.direction = true;
            else
                this.direction = false;
        }
    }

}
