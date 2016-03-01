using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace WeLearnLib.LazyObjTransformation
{
   //[Serializable()]
     [DataContract]
    public class CoursesSerializable
    {
        [DataMember]
        private String courseName;
        [DataMember]
        private String courseCode;

       public CoursesSerializable(String courseName, String courseCode)
       {
           this.courseName = courseName;
           this.courseCode = courseCode;
       }

       public String getCourseName()
       {
           return courseName;
       }

       public void setCourseName(String courseName)
       {
           this.courseName = courseName;
       }

       public String getCourseCode()
       {
           return courseCode;
       }

       public void setCourseCode(String courseCode)
       {
           this.courseCode = courseCode;
       }
    }
}
