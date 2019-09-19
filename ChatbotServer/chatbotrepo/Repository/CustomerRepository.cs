using chatbotrepo.DAL;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace chatbotrepo
{
    public class CustomerRepository:IDataPost
    {
        #region Private Fields
        private readonly ChatbotEntities _context;
        #endregion

        #region Constructor
        public CustomerRepository(ChatbotEntities context)
        {
            _context = context;
        }
        #endregion

        #region Methods
        public int SaveCustomer(CustomersTbl customer)
        {
               _context.CustomersTbls.Add(customer);
               return  _context.SaveChanges();
        }
        #endregion
    }
}