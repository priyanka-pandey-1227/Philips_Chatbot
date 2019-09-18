using ChatbotCustomer;

using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Customers
{
    public class CustomerInfo
    {
        private readonly HttpClient client;

        public CustomerInfo(HttpClient _client)
        {
            client = _client;
        }

        public void SaveDetails( PatientMonitorCustomer customer)
        {
           Console.WriteLine("\nMay I know your name");
            customer.name = Console.ReadLine();

            Console.WriteLine("\nYour contact");
            customer.contact = Console.ReadLine();

            Console.WriteLine("\nYour hospital and address");
            customer.address = Console.ReadLine();
            Console.WriteLine("\nThank you " + customer.name + "!");

            var response3 = client.PostAsJsonAsync("http://localhost:52413/Customer/SaveCustomer", customer).Result;
            if (response3.IsSuccessStatusCode)
            {
                Console.WriteLine("We'll contact you asap.");
            }
            else
            {
                Console.WriteLine("{0} ({1})", (int)response3.StatusCode, response3.ReasonPhrase);
            }
        }

    }
}
