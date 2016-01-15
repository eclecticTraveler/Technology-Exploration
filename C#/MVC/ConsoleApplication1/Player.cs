using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Player : Human
    {

        public Player(int socSec, String name, String nationality, String enthicity, int rate, String club) 
            : base(socSec,name, nationality, enthicity)
        {
            this.rate = rate;
            this.club = club; 

        }

        
        public String Club
        {
            get { return club; }
            set { club = value; }
        }
        

        public int Rate
        {
            get { return rate; }
            set { rate = value; }
        }
        

        private int rate;
        private String club;




    }

}
