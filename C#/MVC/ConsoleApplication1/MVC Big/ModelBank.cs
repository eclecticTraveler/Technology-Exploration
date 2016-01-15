using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json;

namespace ConsoleApplication1.MVC_Big
{
    class ModelBank
    {
        private SortedDictionary<String, Transaction> toDatabase;
    /// <summary>
    /// I make the sortedDictionary collection an object from the constructor so that its scope is bigger
    /// and it can now have its data persistent for much longer time.
    /// </summary>
        public ModelBank()
        {
            toDatabase = new SortedDictionary<string, Transaction>();
        }

        /// <summary>
        /// This method will create a complex object from the Transaction Bean
        /// and it will store it into the collection then it will print out into a file the content of the collection
        /// with a JSON version of what the collection holds
        /// </summary>
        /// <param name="nameOfTransaction"></param>
        /// <param name="name"></param>
        /// <param name="socSec"></param>
        /// <param name="sender"></param>
        /// <param name="amount"></param>
        public void addToDatabase(String nameOfTransaction, String name, String socSec, String sender, Double amount)
        {
           
            DateTime now = DateTime.Now;
            toDatabase.Add(nameOfTransaction, new Transaction(name, socSec, sender, amount, now));
          
            // Make it a JSON
            string json = JsonConvert.SerializeObject(toDatabase);
            
            
            // Print to a file all the content and the JSON version of the collection

            // Also this first line will delete the content of the file and place the new content, your data will be lost
            //using (System.IO.StreamWriter file =
            //    new System.IO.StreamWriter(@"C:\Users\rome\Desktop\Code Repository Arellano\C#\Melaleuca Preparation\MVC\dataAppended.txt", false))

            // This will append it to the file without deleting its content
            using (System.IO.StreamWriter file =
               new System.IO.StreamWriter(@"C:\Users\rome\Desktop\Code Repository Arellano\C#\Melaleuca Preparation\MVC\dataAppended.txt",true))
            {
                foreach (KeyValuePair<String, Transaction> transaction in toDatabase)
                {
                    file.WriteLine("---------------------");

                    file.WriteLine("[{0} {1} {2} {3} {4} {5}]", transaction.Key, transaction.Value.name, transaction.Value.socSec, transaction.Value.sender, 
                                                                transaction.Value.amount, transaction.Value.dateOfTransaction);
                    Console.WriteLine("[{0} {1} {2} {3} {4} {5}]", transaction.Key, transaction.Value.name, transaction.Value.socSec, transaction.Value.sender,
                                                                transaction.Value.amount, transaction.Value.dateOfTransaction);

                    
                }
                file.WriteLine("---------------------");
                file.WriteLine(json);

            }

        }
    }
}
