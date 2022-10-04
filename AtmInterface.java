import java.util.Scanner;
class BankAccount
{
    String userName;
    String password;
    int AccNo=(int)(Math.random()*999999+1000000000);
    float Avlbalance;
    String transactionHistory = "";
    public void register()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Username:");
        this.userName = sc.nextLine();
        System.out.print("Create Password:");
        this.password = sc.nextLine();
        System.out.print("Your Account Number:"+AccNo);
        System.out.print("\n");
        System.out.println("Deposite some amount");
        this.Avlbalance=sc.nextFloat() ;
    System.out.println("Bank account successfully created! ");
    }
    public boolean login()
    {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while ( !isLogin ) {
            System.out.print("Enter Your Username to get services:");
            String Username = sc.nextLine();
            if ( Username.equals(userName) )
            {
                while ( !isLogin ) {
                    System.out.print("Enter Your Password :");
                    String Password = sc.nextLine();
                    if ( Password.equals(password) )
                    {
                        System.out.print("Login successful");
                        isLogin = true;
                    }
                    else
                    {
                        System.out.println("\nIncorrect Password");
                    }
                }
            }
            else
            {
                System.out.println("\nUsername not found");
            }
        }
        return isLogin;
    }
    public void withdraw()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to withdraw:");
        float amount = sc.nextFloat();
        try {
            if ( Avlbalance >= amount )
            {
                Avlbalance =Avlbalance-amount;
                System.out.println("Withdraw Successfully");
                System.out.println("please collect your amount");
                String str = amount+"/- Withdrawed\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else
            {
                System.out.println("\nInsufficient Balance");
            }
        }
        catch ( Exception e) {
        }
    }
    public void deposit()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter amount to deposit:");
        float amount = sc.nextFloat();
        try {
            if ( amount <= 100000) {
                Avlbalance=Avlbalance+amount;
                System.out.println("Amount Deposited Successfully");
                String str = amount+"/- deposited\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else {
                System.out.println("Sorry your Limit is only 100000");
            }
        }
        catch( Exception e) {
        }
    }
    public void transfer()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Number to transfer:");
        int recAccNo = sc.nextInt();
        System.out.print("Enter amount to transfer:");
        float amount = sc.nextFloat();
        try {
            if ( Avlbalance >= amount )
            {
                if ( amount <= 50000)
                {
                    Avlbalance=Avlbalance-amount;
                    System.out.println("\nSuccessfully Transfered to Account no: " + recAccNo);
                    String str = amount + " /- transfered to Acc number " +recAccNo+ "\n";
                    transactionHistory = transactionHistory.concat(str);
                }
                else {
                    System.out.println("\nSorry your Limit is only 50000");
                }
            }
            else
            {
                System.out.println("\nInsufficient Balance");
            }
        }
        catch ( Exception e) {
        }
    }
    public void checkBalance()
    {
        System.out.println("\nAvl Balance" +Avlbalance+ "/-");
    }
    public void transHistory()
    {
        if (transactionHistory.isEmpty() )
        {
            System.out.println("\nNo transactions are done");
        }
        else
        {
            System.out.println("\n" + transactionHistory);
        }
    }
}
public class AtmInterface
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n**********WELCOME TO ABC ATM**********\n");
        System.out.println("1.Register-kindly register to get our services");
        System.out.println("2.Exit");
        System.out.print("Enter Your Choice:");
        int n=sc.nextInt();
        switch(n)
        {
            case 1:
                BankAccount b = new BankAccount();
                b.register();
                while(true)
                {
                System.out.println("\n1.Login");
                System.out.println("2.Exit");
                System.out.print("Enter Your Choice:");
                int ch=sc.nextInt();
                switch(ch) {
                    case 1:
                        if (b.login()) {
                            System.out.println("\n");
                            System.out.println("**********WELCOME BACK**********\n");
                            boolean isFinished = false;
                            while (!isFinished) {
                                System.out.print("\n");
                                System.out.println("1.Withdraw \n2.Deposit \n3.Check Balance\n4.Transfer\n5.Transaction History \n6.Exit");
                                System.out.print("Enter Your Choice :");
                                int ch2 = sc.nextInt();
                                switch (ch2) {
                                    case 1:
                                        b.withdraw();
                                        break;
                                    case 2:
                                        b.deposit();
                                        break;
                                    case 3:
                                        b.checkBalance();
                                        break;
                                    case 4:
                                        b.transfer();
                                        break;
                                    case 5:
                                        b.transHistory();
                                        break;
                                    case 6:
                                        isFinished = true;
                                        break;
                                }
                            }
                        }
                        break;
                        case 2:
                            System.out.print("Thank you visit again!");
                            System.exit(0);
                        break;
                    default:
                        System.out.println("invalid choice");
                }
                break;
            }
            case 2:
                System.out.print("Thank you visit again!");
                System.exit(0);
                       break;
            default:
                System.out.println("invalid choice");
        }
    }
}