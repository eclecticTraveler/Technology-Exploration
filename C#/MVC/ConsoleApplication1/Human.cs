using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    abstract class Human
    {

        protected Human(int socSec, String name, String nationality, String enthicity)
        {
            this.socSec = socSec;
            this.name = name;
            this.nationality = nationality;
            this.enthicity = enthicity;
        }


        public String Enthicity
        {
            get { return enthicity; }
            set { enthicity = value; }
        }


        public String Nationality
        {
            get { return nationality; }
            set { nationality = value; }
        }

        public String Name
        {
            get { return name; }
            set { name = value; }
        }

        public int SocSec
        {
            get { return socSec; }
            set { socSec = value; }
        }

        protected int socSec;
        protected String name;
        protected String nationality;
        protected String enthicity;
    }
}
