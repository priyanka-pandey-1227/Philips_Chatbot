﻿using chatbotrepo.DAL;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace chatbotrepo
{
    public class QuestionRepository : IDataFetch<QuestionsTbl>
    {
        #region Private Fields
        private readonly ChatbotEntities _context;
        #endregion

        #region Constructor
         public QuestionRepository(ChatbotEntities context)
        {
            _context = context;
        }
        #endregion

        #region Methods
        public QuestionsTbl GetById(int id)
        {
            var option = (from o in _context.QuestionsTbls
                          where o.question_id == id
                          select o).SingleOrDefault();
            return option;
        }

        public QuestionsTbl FindWhere(int id1, int id2)
        {
            throw new NotImplementedException();
        }

        ICollection<QuestionsTbl> IDataFetch<QuestionsTbl>.DataFetch(int id)
        {
            throw new NotImplementedException();
        }

        public ICollection<QuestionsTbl> DataFetch(int id1, int id2)
        {
            throw new NotImplementedException();
        }
        #endregion
    }
}