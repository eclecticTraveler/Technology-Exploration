using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.MVC_Big
{
    class MVC
    {
        /// <summary>
        /// the is the best MVC I could think of
        /// it has instantiated objects of view and model. It basically makes both of them unaware that there are
        /// this classes, the only one aware is controller which has both. The nice thing about this is that in 
        /// the model and view's constructors there is no instance of controller so they don't know there is even a controller
        /// only an object requesting data so this mvc is more of a middle man rather than a forward mvc used a couple of years
        /// ago.
        /// </summary>
        /// <param name="args"></param>
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World MVC");

            // Create instance of View
            ViewBank bankView = new ViewBank();
            // Create instance Model
            ModelBank bankModel = new ModelBank();
            // Create instance Controller passing view and model
            ControllerBank bankController = new ControllerBank(ref bankView, ref bankModel);
            
            startApp(ref bankController);

           


            Console.ReadKey();
        
        }

        /// <summary>
        /// By separating passing instantiated objects and placing this variable as my new main
        /// it will make all the data persistent meaning it will have all the data without being killed
        /// because it is still in its scope, it will only reset the variables once it goes out of this 
        /// method
        /// </summary>
        /// <param name="controller"></param>
        private static void startApp(ref ControllerBank controller)
        {
            //throw new NotImplementedException();
            
            Console.WriteLine("Start Transaction? Y/N");
            String ans = Console.ReadLine();
            if (ans != "")
            {
                controller.startTransaction();
                startApp(ref controller);
            }
            
        }

      

    }
}
