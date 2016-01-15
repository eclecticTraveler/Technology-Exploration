using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.MVC_Big
{
    class ControllerBank
    {
        private ViewBank view;
        private ModelBank model;

        /// <summary>
        /// Here I receive the two instantiated objects to which I will have access to its methods without view or model ever noticing who is
        /// manipulating them. This is pretty smart because this way I can request from the view the properties needed instead of making the view to 
        /// hand it those to the controller without the controller even requesting them in the first place making the view to know about the controller and the model
        /// about the controller as well, making it tighly coupled instead of loosly coupled as I did here.
        /// </summary>
        /// <param name="view"></param>
        /// <param name="model"></param>
        public ControllerBank(ref ViewBank view, ref ModelBank model)
        {
            this.view = view;
            this.model = model;

            
        }

        /// <summary>
        /// Instead of starting from the constructor I can now have maing call this method and start the whole thing!
        /// </summary>
        public void startTransaction()
        {
            processDataToBeStored();
        }


        /// <summary>
        /// This method will call methods in view to get values from the user and then passing them to the model without both of them
        /// knowing who is behind the whole scheme!!! conspiracy theory!!
        /// </summary>
        private void processDataToBeStored()
        {
            // I know I could do all this in one line of code and I need some try and catch blocks but whatevs!
            String nameOfTransaction = view.NameOfTransactions;
            String name = view.Name;
            String socSec = view.SocSec;
            String sender = view.Sender;
            Double amount = view.Amount;


            Console.WriteLine("Controller Says: Transfering...");
            Console.WriteLine(name);
            Console.WriteLine(socSec);
            Console.WriteLine(sender);
            Console.WriteLine(amount);


            //modelBank.addToDatabase(viewBank.Name, viewBank.SocSec, viewBank.Sender, viewBank.Amount);
            // Now I am passing it to the model without model knowing who pass this values! 
            model.addToDatabase(nameOfTransaction, name, socSec, sender, amount);

            //throw new NotImplementedException();

        }


       

       

    }
}
