//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace WeLearnLib.Model
{
    using System;
    using System.Collections.Generic;
    
    public partial class User
    {
        public User()
        {
            this.Sessions = new HashSet<Session>();
            this.Workspaces = new HashSet<Workspace>();
        }
    
        public long userId { get; set; }
        public string firstName { get; set; }
        public string lastName { get; set; }
        public string email { get; set; }
        public string username { get; set; }
        public string password { get; set; }
        public string gender { get; set; }
        public string typeOfUser { get; set; }
        public string userPicAddress { get; set; }
    
        public virtual ICollection<Session> Sessions { get; set; }
        public virtual ICollection<Workspace> Workspaces { get; set; }
    }
}