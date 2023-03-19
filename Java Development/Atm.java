import java.util.*;
class BankAccount{
    String name,userName,password,accountNo;	
	float balance = 500f;	
	ArrayList<String> transactionHistory=new ArrayList<String>();

    public void register() {        
        
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Name : ");
		name = sc.nextLine();
		System.out.print("Enter Username : ");
		userName = sc.nextLine();
        while(true){
        String password2;
		System.out.print("Enter Password : ");
		password = sc.nextLine();
        System.out.print("Confirm Password : ");
        password2= sc.nextLine();
        if(password.equals(password2)==true){ 
            System.out.println("Password Confirmed ");
            break;
        }
        else{
            System.out.println("Password Not Confirmed ");
            continue;
        }
    }
		System.out.print("Enter Account Number : ");
		this.accountNo = sc.nextLine();
        System.out.println("---------------------------------");
		System.out.println("Registration completed");   
        System.out.println("---------------------------------");     
        
	}

    public boolean login(){
        Scanner sc = new Scanner(System.in);
        while(true){        
        System.out.print("Enter Username : ");
        String uname = sc.nextLine();
        if(uname.equals(userName)==true) break;
        else{
            System.out.println("Invalid Username");
            continue;
        }
    }
        while(true){
        System.out.print("Enter Password : ");
        String pssword = sc.nextLine();
        if(pssword.equals(password)==true) return true;
        else{
            System.out.println("Invalid Password");
            continue;
        }       
        
    }
    }

    public void deposit(){
        float deposit;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Amount to Deposit : ");
        deposit = sc.nextFloat();
        if(deposit<=0) System.out.println("Enter Valid Data");
        else if(deposit > 500000 ) 
         System.out.println("Deposit Capacity is 500000");
        else{            
			balance = balance + deposit;
			System.out.println("Successfully Deposited Rs " +deposit);
			String str = deposit + " Rs deposited";
			transactionHistory.add(str);
        }
    }

    public void withdraw(){
        float withdraw;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Amount to Withdraw : ");
        withdraw = sc.nextFloat();
        if(withdraw <=0 ) System.out.println("Enter Valid Data");
        else if(balance-withdraw<500)
            System.out.println("Transaction Failed\nUser must have atleast 500 in Account");            
        
        else if ( balance >= withdraw ) {            
            balance = balance - withdraw;
            System.out.println("Successfully Withdrawn Rs "+withdraw);
            String str = withdraw + " Rs Withdrawed";
            transactionHistory.add(str);
            
        }
        else System.out.println("Insufficient Balance");
        
    }

    public void balance(){
        System.out.println("\nBalance : Rs "+balance);
    }

    public void transfer(){
        String name,accnt,confirm;
        float amount;        
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Reciever UserName : ");
        name = sc.nextLine();
        System.out.print("Enter Reciever AccountNo : ");
        accnt = sc.nextLine();
        System.out.print("Enter Amount : ");
        amount = sc.nextFloat();  
        System.out.print("Confirm Transfer ? Y/N : ");   
        confirm = sc.next();             
        if(confirm.equalsIgnoreCase("y") == false ){
            System.out.println("Transaction Failed");
            return;
        }


        if(amount <=0 ) System.out.println("Enter Valid Data");
        else if(balance - amount <=500) 
             System.out.println("Insufficient Balance");
        else{
            while(true){
            if(amount>50000) System.out.println("Transfer Limit is Rs 50000");
            else{            
                balance = balance - amount;
				System.out.println("\nSuccessfully Transfered Rs "+amount+" to " + name + " (Accnt N0 : "+ accnt + ")");                
				String str = amount + " Rs transfered to " +  name + " (Accnt N0 : "+ accnt + ")";
                transactionHistory.add(str);
                break;
            }
            }
        }

    }

    public void history(){
        if ( transactionHistory.size() == 0 ){
            System.out.println("No Transactions");
            return;
        }
        else{
            System.out.println("\nTransaction History : \n");
            for(int i=0;i<(transactionHistory.size());i++)
            {
            System.out.println(transactionHistory.get(i));
            System.out.println("---------------------------------");
            }
        }

		
    }

}


class Atm{
    public static void main(String args[]){  
        int choice=0; 
        while(choice!=1){              
        Scanner sc = new Scanner(System.in);     
        System.out.println("---------ATM--------- ");
        System.out.println("1: Register");
        System.out.println("2: Exit");
        System.out.print("Enter Choice : ");        
        choice = sc.nextInt();
        if(choice == 2) break;
        if(choice!=1) System.out.println("Invalid Choice");
        }
        
        if(choice == 1){       
        BankAccount b = new BankAccount();
		b.register();
        while(true) {
            int choice2;
            Scanner sc = new Scanner(System.in);  
            System.out.println("---------------------------------");
            System.out.println("\nKindly Login");
            System.out.println("1: Login");
            System.out.println("2: Exit");
            System.out.print("Enter Choice : ");
            choice2 = sc.nextInt();
            if(choice2 == 2){
                System.out.println("\nThank You !!");
                break;
            }
            if(choice2 != 1){
                System.out.println("Invalid Choice");
                continue;
            }

            boolean check = b.login();
            if(check==true){
                while(true){
                int choice3;
                System.out.println("---------------------------------");
                System.out.println("\nWelcome User : "+b.userName);
                System.out.println("1: Deposit");
                System.out.println("2: Withdraw");
                System.out.println("3: Check Balance");
                System.out.println("4: Transfer");
                System.out.println("5: Transaction History");
                System.out.println("6: Logout");
                System.out.print("Enter Choice : ");
                choice3 = sc.nextInt();
                if(choice3 == 6){
                    System.out.println("\nLogged Out !!");
                    break;
                }
                switch(choice3){
                    case 1: b.deposit();
							break;
					case 2: b.withdraw();
							break;
					case 3: b.balance();
							break;
					case 4: b.transfer();
						    break;
					case 5: b.history();
                            break;                    
                    default: System.out.println("Invalid Choice");
                }
                
                }
               
            }
            else System.out.println("Please try Again");
        }
    }
    else System.out.println("Thank You");

    
}
}