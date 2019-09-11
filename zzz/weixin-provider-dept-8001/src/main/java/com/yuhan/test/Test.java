package com.yuhan.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yuhan.dao.MerchandiseShowDao;
@RestController
public class Test {

		@Autowired
		private MerchandiseShowDao msd;
		StringBuffer sb ;

		@RequestMapping(value = "/Order/List0", method = RequestMethod.GET)
		public String balongsList(){
			sb=new StringBuffer();
		sb.append(msd.findById(100100));
			/*sb.append(orderListService.findByUserIdAndStatus(100001, "1"));*/
		    return sb.toString();

		}
}
