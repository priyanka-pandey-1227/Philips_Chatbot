using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net.Http;
using System.Net.Http.Headers;
using Initialization;
using ChatbotCustomer;
using Customers;

namespace HttpConsoleApp
{
    public static class Client
    {
        static void Main(string[] args)
        {
            HttpClient client = new HttpClient();

            InitialClass initialClass = new InitialClass(client);
            initialClass.PrintInitial();
            string monitorName=initialClass.Process();
 
            Console.WriteLine("\n\nPlease provide us some details to contact you later");

            PatientMonitorCustomer customer = new PatientMonitorCustomer();
            customer.monitor = monitorName;
            CustomerInfo details = new CustomerInfo(client);
            details.SaveDetails(customer);
        }
    }    
}
