using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;

namespace AngularTutorial.Models
{
    public class Todo
    {
        /// <summary>
        /// What is needed to create our web API
        /// for our CRUD APP
        /// Now, create a new class for your Todo Items:
        /// </summary>
        public int Id { get; set; }
        public String Text { get; set; }

        // the ? means that it is not required meaning its optional (nullable)
        public DateTime? DueDate { get; set; }
        public int Priority { get; set; }
    }
}
