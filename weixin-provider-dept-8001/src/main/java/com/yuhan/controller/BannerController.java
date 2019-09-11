package com.yuhan.controller;


/**
 * 主界面
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.yuhan.entities.ActivityShow;
import com.yuhan.entities.Belongs;
import com.yuhan.entities.MerchandiseShow;
import com.yuhan.service.ActivityShowService;
import com.yuhan.service.BannerService;
import com.yuhan.service.BelongsService;
import com.yuhan.service.MerchandiseShowService;
import com.yuhan.util.DateUtil;
import com.yuhan.util.ListUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class BannerController {
StringBuffer sb ;
    @Autowired
    private BannerService bannerService;
    @Autowired
    private BelongsService balongsService;
    @Autowired
    private ActivityShowService activityShowService;
    @Autowired
    private MerchandiseShowService  merchandiseShowService;

    //商品列表
    @RequestMapping(value = "/Banner/list", method = RequestMethod.GET)
    public String bannerList(HttpServletRequest req, HttpServletResponse rep) throws IOException {
    	sb = new StringBuffer();
        String sessionId = req.getSession().getId();
    	sb.append("{\"result\":\"1001\",\"msg\":\"Success\",\"data\":{\"sessionId\":\""+sessionId+"\",\"banner\":");
    	String  s= ListUtil.bannerlistToString(bannerService.list());
    	sb.append(s);
     	sb.append(",");
		sb.append("\"titlelcon1\":");
		List<Belongs> ls= new ArrayList<Belongs>();
		for(int i=1;i<=10;i++){
			ls.add(balongsService.findById(i));
		}
		s= ListUtil.belongslistToString(ls);
		sb.append(s);
		sb.append(",");
    	
    	
    	
    	sb.append("\"titlelcon2\":");
    	 ls= new ArrayList<Belongs>();
    	int[] is = {11,12,13};
    	for(int id:is){
    		ls.add(balongsService.findById(id));
    	}
    	s= ListUtil.belongslistToString(ls);
    	sb.append(s);
    	sb.append(",");
    	
    
    	
    	sb.append("\"Activitydictionaryy\":");
    	ActivityShow as = activityShowService.findByTime(DateUtil.formate(new Date(), "yyyy-MM-dd	HH:mm:ss"));
    	sb.append(as);
    	String[] ss=as.getProduct_list().split(";");
    	for(int i = 0;i<as.getSum();i++){
    		sb.append( merchandiseShowService.findById(Integer.parseInt(ss[i])));
    		sb.append(",");
    	}
    	StringBuffer sb0=sb.deleteCharAt(sb.length()-1);
    	sb=new StringBuffer(sb0);
    	sb.append("]},");
    	
    	sb.append("\"ListArray\":[");
    	List<MerchandiseShow> merchandiseShows=  merchandiseShowService.findByType("0007");
for(MerchandiseShow merchandiseShow:merchandiseShows){
	sb.append(merchandiseShow);
	sb.append(",");
}
sb0=sb.deleteCharAt(sb.length()-1);
sb=new StringBuffer(sb0);
sb.append("]");
    	sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
        return sb.toString();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @RequestMapping(value = "/Balongs/list", method = RequestMethod.GET)
    public String balongsList(){
    	sb = new StringBuffer();
    	sb.append("{\"result\":\"1002\",\"msg\":\"Success\",\"data\":{\"titleIconl\":");
    	String  s= ListUtil.belongslistToString(balongsService.list());
    	sb.append(s);
    	sb.append("},\"sign\":\"2019-08-25 10:10:10\"}");
        return sb.toString();
    }
    
    @RequestMapping(value = "/MiaoSha/list", method = RequestMethod.GET)
    public String seckillList(){
    	ActivityShow as = activityShowService.findByTime(DateUtil.formate(new Date(), "yyyy-MM-dd	HH:mm:ss"));
    	sb = new StringBuffer();
    	sb.append("{\"result\":\"1003\",\"msg\":\"Success\",\"data\":{\"activitydictionaryy\":");
 sb.append(as);
String[] ss=as.getProduct_list().split(";");
for(int i = 0;i<as.getSum();i++){
	 sb.append( merchandiseShowService.findById(Integer.parseInt(ss[i])));
	 sb.append(",");
}
    sb.append("},\"sign\":\""+DateUtil.formate(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
    return sb.toString();
    }
    @RequestMapping(value = "/tuijian/list", method = RequestMethod.GET)
    public String tuiJianList(){
    
    	sb = new StringBuffer();
    	sb.append("\"ListArray\":[");
    	List<MerchandiseShow> merchandiseShows=  merchandiseShowService.findByType("0007");
for(MerchandiseShow merchandiseShow:merchandiseShows){
	sb.append(merchandiseShow);
}sb.append("]");
   
        return sb.toString();

    }
    
    @RequestMapping(value = "/Balongs/lists", method = RequestMethod.GET)
    public String balongsLists(){
    	sb = new StringBuffer();
    	sb.append("{\"result\":\"1002\",\"msg\":\"Success\",\"data\":{\"titleIconl\":");
    	List<Belongs> ls= new ArrayList<Belongs>();
    	int[] is = {7,8,9};
    	for(int id:is){
    		ls.add(balongsService.findById(id));
    	}
    	String  s= ListUtil.belongslistToString(ls);
    	sb.append(s);
    	sb.append("},\"sign\":\"2019-08-25 10:10:10\"}");
        return sb.toString();


    }
    
    
    
    
}
