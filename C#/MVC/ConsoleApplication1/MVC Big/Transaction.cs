using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.MVC_Big
{
    /// <summary>
    /// This is what in Java be a JavaBean, it has the [Serializable] which will make this object into an stream of bites and be able to transmit or store it 
    /// into a memory, a database or a file. I don't know how useful is in this case because I am making this into a JSON string.
    /// BTW without the getters and setters I would not be able to transform it into a json string
    /// </summary>
    [Serializable]
    class Transaction
    {
        public String name { get; set; }
        public String socSec { get; set; }
        public String sender { get; set; }
        public Double amount { get; set; }
        public String dateOfTransaction { get; set; }
         

        public Transaction(String name, String socSec, String sender, Double amount, DateTime dateOfTransaction)
        {
            this.name = name;
            this.socSec = socSec;
            this.sender = sender;
            this.amount = amount;
            this.dateOfTransaction = dateOfTransaction.ToString();
        }

    }
}
