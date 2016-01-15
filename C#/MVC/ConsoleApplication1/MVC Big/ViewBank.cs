using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.MVC_Big
{
    /// <summary>
    /// there are only two variables that will be reset with each time the user wants to do another transaction and that is with
    /// nameOfTransaction and amount this is due to the fact that I am using local variables and after it returns the value requested
    /// they die, they are not persistent as the private variables I have here. The rest of the private variables are not killed because 
    /// I am passing to controller an instance of this class that survives for a bigger scope than the variables I just mentioned thus
    /// making that the other private variables won't have the need to prompt the user again since they are already initialized.
    /// </summary>
    class ViewBank
    {
        private String nameOfTransaction = "";
        private String socSec = "";
        private String name = "";
        private String sender = "";
        private double amount;


        public ViewBank()
        {

        }

        public String NameOfTransactions
        {
            get
            {
                // This variable will be reseted after it goes out of scope
                // ensuring that the promping for the value to the user always happens
                // overwriting the nameOfTransaction each time since that variable has a 
                // broader scope than the one specified here thus making it survive much longer
                String _nameOfTransaction = "";
                while (_nameOfTransaction.Equals(""))
                {
                    Console.WriteLine("Insert Name of Transaction");
                    _nameOfTransaction = Console.ReadLine();
                    nameOfTransaction = _nameOfTransaction;
                }
                return nameOfTransaction;
            }
            set { nameOfTransaction = value; }
        }
        
        public String Name
        {
            get {
                while (name.Equals(""))
                {
                    Console.WriteLine("Insert Name of the account holder");
                    name = Console.ReadLine();
                }
                return name;
            }
            set { name = value; }
        }
        

        public string SocSec
        {
            get {
                while (socSec.Equals(""))
                {
                    Console.WriteLine("Insert SocialSecurity of the account holder");
                    socSec = Console.ReadLine();
                }
                return socSec;
            }
            set { socSec = value; }
        }

        public double Amount
        {
            get
            {
                String str_amount = "";
                while (str_amount.Equals(""))
                {
                    Console.WriteLine("Insert Amount to be transfered");
                    str_amount = Console.ReadLine();
                    amount = Convert.ToDouble(str_amount);
                }
                return amount;
            }
            set { amount = value; }
        }


        public String Sender
        {
            get
            {
                while (sender.Equals(""))
                {
                    Console.WriteLine("Who is sending this money?");
                    sender = Console.ReadLine();
                }
                return sender;
            }
            set { sender = value; }
        }


    }
}
