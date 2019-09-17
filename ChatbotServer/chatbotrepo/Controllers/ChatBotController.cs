using chatbotrepo.DAL;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web.Http;
using System.Web.Mvc;

namespace chatbotrepo.Controllers
{
    public class ChatbotController : Controller
    {
        #region Private Fields
        private IDataFetch<QuestionsTbl> _question ;
        private IDataFetch<MonitorsTbl> _monitor;
        private IDataFetch<OptionsTbl> _option;
        #endregion

        #region Default Constructor
        public ChatbotController()
        {
            _question = new QuestionRepository(new ChatbotEntities());
            _option = new OptionsRepository(new ChatbotEntities());
            _monitor = new MonitorRepository(new ChatbotEntities());
        }
        #endregion

        #region Methods
        public void Get()
        {
            var QuesRow = _question.GetById(1);
            Response.Write(QuesRow.question + Environment.NewLine);
            var  list = QuesRow.OptionsTbls.ToList();
            foreach (OptionsTbl opt in list)
            {
                Response.Write(opt.option_id + ".  " + opt.option+"\n");
            }
        }

        [System.Web.Mvc.HttpPost]
        public void GetLink(OptionsTbl options)
        {
            var OptRow = _option.FindWhere(options.question_id, options.option_id);
            Response.Write(OptRow.link_id);
        }

        public void FetchQuestion(OptionsTbl o)
        {
            var QuesRow = _question.GetById(o.link_id);
            Response.Write(QuesRow.question + Environment.NewLine);
            var list = QuesRow.OptionsTbls.ToList();
            foreach (OptionsTbl opt in list)
            {
                Response.Write(opt.option_id + ".  " + opt.option + "\n");
            }
        }

        [System.Web.Http.HttpPost]
        public void MonitorFetch(OptionsTbl o)
        {
            var m = _option.FindWhere(o.question_id, o.option_id);
            var monitor = _monitor.GetById(m.monitor_id);
            Response.Write(monitor.monitor_name);
        }

  
        #endregion
    }
}
