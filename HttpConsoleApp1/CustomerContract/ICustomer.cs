using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CustomerContract
{
    public class ICustomer
    {
        public string name { get; set; }
        public string contact { get; set; }
        public string address { get; set; }
        public string monitor { get; set; }
    }
}
