package sw.hw3;
 
import java.util.Scanner;

public class SWHW3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        mainMenu();
    }
    static void mainMenu()
    {
        int c1,c2,c3,c4;
        c1=c2=c3=c4=0;
        int[]array=new int[3];
        Player []playerArr=new Player[10];
        PlaygroundOwner []pgOwnerArr=new PlaygroundOwner[10];
        Playground []pgArr=new Playground[10];
        Request []requestArr=new Request[10];
        Scanner in = new Scanner(System.in);
        while(true)
        {
            System.out.println("main menu enter your choise number");
            System.out.println("1/ sign up new user");
            System.out.println("2/ login");
            System.out.println("3/ Exit");
            int choise= in.nextInt();
            if (choise==1)
                {
                    array=signupMenu(playerArr, pgOwnerArr,c1,c2);
                    c1=array[0];
                    c2=array[1];
                }
            else if(choise==2)
                {
                    c3=loginMenu(playerArr, pgOwnerArr, pgArr, requestArr, c1, c2, c3, c4);
                }
            else if(choise==3)
                {break;}
            else
            System.out.println("wrong choise");
        }
    }
    static int [] signupMenu(Player[]playerArr, PlaygroundOwner[]pgOwnerArr, int c1, int c2)
    {
        int[]arr=new int[2];
        arr[0]=c1;
        arr[1]=c2;
        Scanner in = new Scanner(System.in);
        System.out.println("sign up menu enter your choise number");
        System.out.println("1/ sign up new player");
        System.out.println("2/ sign up playground owner");
        int choise= in.nextInt();
        if (choise==1)
            {arr[0]=playerSignup(playerArr, c1);}
        else if(choise==2)
            {arr[1]=pgOwnerSignup(pgOwnerArr, c2);} 
        else
        {
            System.out.println("wrong choise");
            signupMenu(playerArr, pgOwnerArr,c1,c2);
        } 
        return arr;
    }
    static int playerSignup(Player[]playerArr,int c1)
        {    
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the name, password, mail, address, phone");
            String name= in.nextLine();
            String password= in.nextLine();
            String mail= in.nextLine();
            String address= in.nextLine();
            String phone= in.nextLine();
            Player temp=new Player(name, password, mail, address, phone);
            playerArr[c1]=temp;
            c1=c1+1;
            return c1;
        }
    static int pgOwnerSignup(PlaygroundOwner[]pgOwnerArr,int c2)     {    
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the name, password, mail, address, phone");
            String name= in.nextLine();
            String password= in.nextLine();
            String mail= in.nextLine();
            String address= in.nextLine();
            String phone= in.nextLine();
            PlaygroundOwner temp=new PlaygroundOwner(name, password, mail, address, phone);
            pgOwnerArr[c2]=temp;
            c2++;
            return c2;
        } 
    static int loginMenu(Player[]playerArr, PlaygroundOwner[]pgOwnerArr, Playground[]pgArr,Request[]requestArr, int c1, int c2, int c3, int c4)
    {
        int gpnumber = c3;
        Scanner in = new Scanner(System.in);
        System.out.println("login menu enter your choise number");
        System.out.println("1/ login for player");
        System.out.println("2/ login for playground owner");
        int choise= in.nextInt();
        if (choise==1)
            {playerLogin(playerArr, pgArr, requestArr, c1, c3, c4);}
        else if(choise==2)
            {gpnumber=pgOwnerLogin(pgOwnerArr, pgArr, requestArr, c2, c3, c4);} 
        else
        {
            System.out.println("wrong choise");
            loginMenu(playerArr, pgOwnerArr, pgArr ,requestArr, c1, c2, c3, c4);
        } 
        return gpnumber;
    }
    static int playerLogin(Player[]playerArr, Playground[]pgArr, Request[]requestArr, int c1, int c3, int c4)
    {
        int requestNo=c4;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the username and password");
        String name= in.nextLine();
        String password= in.nextLine();
        for(int i=0 ; i<c1 ; i++)
        {
            if(playerArr[i].getName() == name && playerArr[i].getPassword() == password)
            {
                requestNo=playerMenu(playerArr[i],pgArr, requestArr,c3, c4);  
            }
        }
        System.out.println("not found");
        playerLogin(playerArr, pgArr, requestArr, c1, c3, c4);
        return requestNo;
    }
    static int playerMenu(Player player ,Playground[]pgArr, Request[]requestArr,int c3, int c4)
    {
        int requestNo=c4;
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome "+player.getName());
        System.out.println("1/ add request");
        System.out.println("2/ see your request");
        int choise= in.nextInt();
        if(choise==1)
        {
            System.err.println("choose the playground number");
            for(int i=0; i<=c3 ;i++)
            {
                System.err.println((i+1)+" "+pgArr[i].toString());
            }
            choise=in.nextInt();
            System.err.println("enter the slot ,date");
            int slot= in.nextInt();
            String date= in.nextLine();
            Request temp=new Request(slot, date, player, pgArr[choise-1]);
            requestArr[c4]=temp;
            requestNo++;
        }
        else if(choise==2)
        {
            for(int i=0 ; i <= c4 ; i++)
            {
                if(requestArr[i].getPlayer()==player)
                {
                    System.out.println(requestArr[i].toString());
                }
                    
            }
        }
        else
        {playerMenu(player, pgArr, requestArr, c3, c4);}
        return requestNo;
    }
    static int pgOwnerLogin(PlaygroundOwner[]pgOwnerArr, Playground[]pgArr, Request[]requestArr, int c2, int c3, int c4)
    {
        int gpNumber = c3;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the username and password");
        String name= in.nextLine();
        String password= in.nextLine();
        for(int i=0 ; i<c2 ; i++)
        {
            if(pgOwnerArr[i].getName() == name && pgOwnerArr[i].getPassword() == password)
            {
                gpNumber=pgOwnerMenu(pgOwnerArr[i], pgArr, requestArr, c3, c4);  
            }
        }
        System.out.println("not found");
        pgOwnerLogin(pgOwnerArr, pgArr, requestArr, c2, c3, c4);
        return gpNumber;
    }
    static int pgOwnerMenu(PlaygroundOwner playgroundOwner, Playground[]pgArr, Request[]requestArr, int c3, int c4)
    {
        int gpnumber = c3;
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome "+playgroundOwner.getName());
        System.out.println("1/ add playground");
        System.out.println("2/ see requests");
        int choise= in.nextInt();
        if (choise==1)
            {
                gpnumber=addPlayground(playgroundOwner, pgArr, c3);
            }
        else if(choise==2)
            {
                for(int i=0;i<c4;i++)
                {
                    if(requestArr[i].getPlayground().getplaygroundOwner()==playgroundOwner)
                    {
                        System.out.println(requestArr[i].toString());
                        System.out.println("enter 1 to accept or 2 to reject");
                        int reqAnser= in.nextInt();
                        if(reqAnser==1)
                        {
                            requestArr[i].setState("accepted");
                        }
                        else if(reqAnser==2)
                        {
                            requestArr[i].setState("rejected");
                        }
                    }
                }
            } 
        return gpnumber;
    }
    static int addPlayground(PlaygroundOwner pgOwner, Playground[]pgArr, int c3)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the location, size, price");
        String location= in.nextLine();
        float size= in.nextFloat();
        float price= in.nextFloat();
        Playground temp=new Playground(location, size, price, pgOwner);
        pgArr[c3]=temp;
        c3++;
        return c3;
    } 
}
