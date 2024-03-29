﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net.Http;
using System.Net.Http.Headers;
using OptionTable;

namespace Initialization
{
    public class InitialClass
    {
        private readonly HttpClient client;

        public InitialClass(HttpClient _client)
        {
            client = _client;
        }

        public void PrintInitial()
        {
            client.BaseAddress = new Uri("http:" + "//localhost:52413/");

            // Add an Accept header for JSON format.    
            client.DefaultRequestHeaders.Accept.Add
                (new MediaTypeWithQualityHeaderValue("application/json"));

            HttpResponseMessage response = client.GetAsync("Chatbot/Get").Result;  // Blocking call!    
            if (response.IsSuccessStatusCode)
            {
                var products = response.Content.ReadAsStringAsync().Result;
                Console.WriteLine("Hi, I'm Elbot !!!");
                Console.WriteLine("I'm excited to help you find a product today. :D\n");
                Console.WriteLine(products);
            }
            else
            {
                Console.WriteLine("{0} ({1})", (int)response.StatusCode, response.ReasonPhrase);
            }
        }


        public string Process()
        {
            OptionTableClass p = new OptionTableClass();
            p.question_id = 1;
            p.link_id = 1;

            int temp = 1;

            while (p.link_id != 0)
            {

                Console.WriteLine("Enter an option");
                p.option_id = Int32.Parse(Console.ReadLine());

                temp = p.link_id;
                var responses = client.PostAsJsonAsync("Chatbot/GetLink", p).Result;
                if (responses.IsSuccessStatusCode)
                {
                    var op = responses.Content.ReadAsStringAsync().Result;
                    p.link_id = Int32.Parse(op);
                    p.question_id = p.link_id;
                    var response2 = client.PostAsJsonAsync("Chatbot/FetchQuestion", p).Result;
                    if (response2.IsSuccessStatusCode)
                    {
                        var question = response2.Content.ReadAsStringAsync().Result;
                        Console.WriteLine(question);
                    }
                    else
                    {
                        Console.WriteLine("{0} ({1})", (int)response2.StatusCode, response2.ReasonPhrase);
                    }

                }
                else
                    Console.Write("Error");
            }


            p.question_id = temp;
            var x = client.PostAsJsonAsync("ChatBot/MonitorFetch", p).Result;
            string monitor = x.Content.ReadAsStringAsync().Result;
            if (monitor != null)
            {
                Console.WriteLine("According to your preferences the suggested patient monitor is: " + monitor);
            }
            return monitor;
        }
    }
}
