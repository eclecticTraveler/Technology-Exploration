using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace WeLearnLib.LazyObjTransformation
{
    //[Serializable]
    [DataContract]
    public class UserSerializable
    {
        [DataMember]
        private Decimal personId;
        [DataMember]
        private String lastName;
        [DataMember]
        private String firstName;
        [DataMember]
        private String email;
        [DataMember]
        private String gender;
        [DataMember]
        private String typeOfUser;
        [DataMember]
        private String userPicAddress;

        public UserSerializable(Decimal personId, String lastName, String firstName, String email, String gender, String typeOfUser, String userPicAddress)
        {
            this.personId = personId;
            this.lastName = lastName;
            this.firstName = firstName;
            this.email = email;
            this.gender = gender;
            this.typeOfUser = typeOfUser;
            this.userPicAddress = userPicAddress;

        }

        public Decimal getPersonId()
        {
            return personId;
        }

        public void setPersonId(Decimal personId)
        {
            this.personId = personId;
        }

        public String getLastName()
        {
            return lastName;
        }

        public void setLastName(String lastName)
        {
            this.lastName = lastName;
        }

        public String getFirstName()
        {
            return firstName;
        }

        public void setFirstName(String firstName)
        {
            this.firstName = firstName;
        }


        public String getEmail()
        {
            return email;
        }

        public void setEmail(String email)
        {
            this.email = email;
        }

        public String getGender()
        {
            return gender;
        }

        public void setGender(String gender)
        {
            this.gender = gender;
        }

        public String getTypeOfUser()
        {
            return typeOfUser;
        }

        public void setTypeOfUser(String typeOfUser)
        {
            this.typeOfUser = typeOfUser;
        }

        public String getUserPicAddress()
        {
            return userPicAddress;
        }

        public void setUserPicAddress(String userPicAddress)
        {
            this.userPicAddress = userPicAddress;
        }

    }
}
