using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json;



namespace ConsoleApplication1
{
    class Program
    {
        //static void Main(string[] args)
        //{

        //    Employee employee1 = new Employee(39, "Developer", 766536878, "Israel", "Mexican-Brazilian", "Latino");
        //    Employee employee2 = new Employee(25, "Sales", 456877788, "Joe", "American-USA", "Caucasian");
        //    Employee employee3 = new Employee(15, "Call Center", 789755456, "Estephano", "Italian", "Latino");

        //    List<Employee> workers = new List<Employee>();
        //    workers.Add(employee1);
        //    workers.Add(employee2);
        //    workers.Add(employee3);

        //    int size = workers.Count;

        //    SortedList s1 = new SortedList();


        //    foreach (Employee employee in workers)
        //    {
        //       int salary  =  employee.Salary;
        //       String name = employee.Name;

        //       s1.Add(name, salary);

        //    }
        //    // get a collection of keys
        //    ICollection key = s1.Keys;

        //    foreach (String k in key)
        //    {
        //        Console.WriteLine(k + ": " + "$" + s1[k] + " Dollars");
                
        //    }



        //    Employee employee4 = new Employee(80, "Developer", 766538888, "Ivan", "Brazilian", "Latino");
        //    Employee employee5 = new Employee(150, "Management", 478977788, "Boris", "Bulgarian", "Caucasian");
        //    Player player1 = new Player(78978978, "Messi", "Argentinian", "Latino", 5, "Barcelona");
        //    Player player2 = new Player(87957577, "Ronaldo", "Portuguese", "Latino", 4, "Real Madrid");

        //    // Create a list that can hold the derived classes
        //    List<Human> people = new List<Human>();
        //    people.Add(employee4);
        //    people.Add(player1);
        //    people.Add(employee5);
        //    people.Add(player2);

        //    List<Player> players = new List<Player>();
        //    List<Employee> employees = new List<Employee>();

        //    foreach (Human person in people)
        //    {
        //        if (person is Player)
        //        {
        //            String type = "This one is a Player";
        //            Console.WriteLine(type);
        //            Player p1 = (Player)person;
        //            Console.WriteLine(p1.Name);
        //            Console.WriteLine(p1.Club);
        //            players.Add(p1);
        //        }
        //        else
        //        {
        //            String type = "This one is an Employee";
        //            Console.WriteLine(type);
        //            Employee em = (Employee)person;
        //            Console.WriteLine(em.Name);
        //            Console.WriteLine(em.Salary);
        //            employees.Add(em);
        //        }
        //    }


        //    Employee employee6 = new Employee(800, "Developer", 766538888, "Kant",   "German", "Latino");
        //    Employee employee7 = new Employee(150, "Engenieer", 478977788, "Michel", "French", "Caucasian");
        //    Player player3 = new Player(78978978, "Neymar", "Brazilian", "Latino", 5, "Barcelona");
        //    Player player4 = new Player(87957577, "Luis Suarez", "Uruguay", "Latino", 4, "Barcelona");

        //    // Create a list that can hold the derived classes
        //    List<Human> persons = new List<Human>();
        //    persons.Add(employee4);
        //    persons.Add(player1);
        //    persons.Add(employee5);
        //    persons.Add(player2);
        //    persons.Add(employee6);
        //    persons.Add(player3);
        //    persons.Add(employee7);
        //    persons.Add(player4);

        //    string json = JsonConvert.SerializeObject(persons);
        //    string test = json;

        //  Console.ReadKey();
        //}
    }
}
