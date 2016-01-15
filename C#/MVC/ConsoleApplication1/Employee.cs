using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Employee : Human
    {

        public Employee(int salary, String position, int socSec, String name, String nationality, String enthicity)
            : base(socSec, name, nationality, enthicity)
        {
            this.salary = salary;
            this.position = position;
        }


        public String Position
        {
            get { return position; }
            set { position = value; }
        }
        
        public int Salary
        {
            get { return salary; }
            set { salary = value; }
        }



        private int salary;
        private String position;

        
    }
}
