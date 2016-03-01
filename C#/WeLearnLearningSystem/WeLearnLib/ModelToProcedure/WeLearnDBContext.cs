using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;
using WeLearnLib.Model;

namespace WeLearnLib.ModelToProcedure
{
    public class WeLearnDBContext : DbContext
    {
        public DbSet<User> Users { get; set; }

        /// <summary>
        /// This is where we tell the entity framework to use store procedures
        /// </summary>
        /// <param name="modelBuilder"></param>
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            // Here we are telling map this User entity to use store procedures
            modelBuilder.Entity<User>().MapToStoredProcedures();
            base.OnModelCreating(modelBuilder);
        }
    
    }
}
