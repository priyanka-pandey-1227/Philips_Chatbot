using chatbotrepo.DAL;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace chatbotrepo
{
    public class OptionsRepository : IDataFetch<OptionsTbl>
    {
        #region Private Fields
        private readonly ChatbotEntities _context;
        #endregion

        #region Constructors
        public OptionsRepository(ChatbotEntities context)
        {
            _context = context;
        }
        #endregion

        #region Methods
   
        public OptionsTbl GetById(int id)
        {
            throw new NotImplementedException();
        }

        public OptionsTbl FindWhere(int questionid, int optionid)
        {
            var option = (from o in _context.OptionsTbls
                     where o.question_id == questionid
                     where o.option_id == optionid
                     select o).SingleOrDefault();
            return option;
        }

        ICollection<OptionsTbl> IDataFetch<OptionsTbl>.DataFetch(int id)
        {
            throw  new NotImplementedException();
        }

        public ICollection<OptionsTbl> DataFetch(int id1, int id2)
        {
            throw new NotImplementedException();
        }


        #endregion
    }

}
