namespace AngularTutorial.Migrations
{
    using AngularTutorial.Models;
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<AngularTutorial.Models.TodoContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        /// <summary>
        /// This method was constructed byt he Enable-Migrations and it is basically allowing us to
        /// fill and create data on the database as well as being reflected here on the view layer
        /// Then we will type "Update-Database" so that it makes those chances on the DB through the 
        /// Package Manager Console
        /// </summary>
        /// <param name="context"></param>
        protected override void Seed(AngularTutorial.Models.TodoContext context)
        {
         
            var r = new Random();
            // Createing 50 items with all the properties
            var items = Enumerable.Range(1, 50).Select(o => new Todo
            {
                DueDate = new DateTime(2015, r.Next(1, 12), r.Next(1, 28)),
                Priority = (byte)r.Next(10),
                Text = o.ToString()
            }).ToArray();
            context.Todoes.AddOrUpdate(item => new { item.Text }, items);
          
        }
    }
}
