import java.util.Scanner;
class Vote {
    int vote;
}
class Shahin extends Vote {

}
class Trump extends Vote {

}
class Erdogan extends Vote {

}
public class VoteingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Shahin shahin = new Shahin();
        Trump trump = new Trump();
        Erdogan erdogan  = new Erdogan();
        boolean flag = true;
        String adminPass = "topsecret", pass;
        int  choose , voteing, neutral = 0;
        while(flag) {
            cls();
            System.out.println("Choose\n1. Admin login\t\t\t\t\t\t\t\t2. Vote");
            choose = scan.nextInt();
            cls();
            if(choose == 1){
                System.out.println("Admin\nEnter password : ");
                scan.nextLine();
                pass = scan.nextLine();
                cls();
                if(adminPass.equals(pass)){
                    System.out.println("Enter\n1. Stop voteing\n2. See result\n3. Continue vote");
                    choose = scan.nextInt();
                    if(choose == 1){
                        System.out.println("Shahin : "+shahin.vote);
                        System.out.println("Trump : "+trump.vote);
                        System.out.println("Erdogan :"+erdogan.vote);
                       if(trump.vote>shahin.vote && trump.vote>erdogan.vote ) {
                        System.out.println("\nWinner : Trump");
                       }
                       else if(shahin.vote>trump.vote && shahin.vote>erdogan.vote ) {
                        System.out.println("\nWinner : Shahin");
                       }
                       else if(erdogan.vote>shahin.vote && erdogan.vote>trump.vote) {
                        System.out.println("\nWinner : Erdogan");
                       }
                       else{
                        System.out.println("\nDraw");                        
                       }
                       System.out.println();
                        break;
                    }
                    else if(choose == 2){
                        System.out.println("Shahin : "+shahin.vote);
                        System.out.println("Trump : "+trump.vote);
                        System.out.println("Erdogan : "+erdogan.vote);
                        System.out.println("Press any button to continue ");
                        scan.nextLine();
                        scan.nextLine();
                        continue;
                    }
                    else{
                        continue;
                    }
                }
                else{
                    System.out.println("Wrong pssword");
                    continue;
                }

            }
            else{
                System.out.println("Choose your candidate ");
                System.out.print("1. "+shahin.getClass().getName()+"\t\t");
                System.out.print("2. "+trump.getClass().getName()+"\t\t");
                System.out.println("3. "+erdogan.getClass().getName());
                voteing = scan.nextInt();
                if(voteing == 1){
                    shahin.vote++;
                }
                else if(voteing == 2) {
                    trump.vote++;
                }
                else if(voteing == 3) {
                    erdogan.vote++;
                }
                else{
                    neutral++;
                }
            }
        }
    }
    public static void cls() {
        try{
            if(System.getProperty("os.name").contains("Windows"))
                 new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            else
                System.out.println("\033\143");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}