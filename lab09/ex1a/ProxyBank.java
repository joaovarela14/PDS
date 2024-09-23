public class ProxyBank extends BankAccountImpl {

    public ProxyBank(String bank, double initialDeposit) {
        super(bank, initialDeposit);
    }

    @Override
    public boolean withdraw(double amount) {
        if (Company.user == User.OWNER) {
            return super.withdraw(amount);
        } else {
            System.out.println();
        }
        return false;
    }

    @Override
    public double balance() {
        
        if (Company.user == User.OWNER)
            return super.balance();
        else
            throw new SecurityException("Access denied - balance");
    }

        
}


