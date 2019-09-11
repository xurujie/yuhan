package com.yuhan.controller;
/*
 * 
 * 单个商品主界面
 */
import java.util.Date;
import java.util.List;

import com.yuhan.entities.MerchandiseShow;
import com.yuhan.entities.PrefectureImg;
import com.yuhan.entities.Profile;
import com.yuhan.entities.UserInformation;
import com.yuhan.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.yuhan.util.DateUtil;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MerchandiseController {
@Autowired
MerchandiseService merchandiseService;
@Autowired
PromotionService promotionService;
@Autowired 
UserInformationService userInformationService;
@Autowired
	MerchandiseShowService merchandiseShowService;
    @Autowired
    private ProfileService profileService;
@Autowired
	PrefectureImgService prefectureImgService;
 
StringBuffer sb ;
//商品详情
@RequestMapping(value = "/Merchandise/particulars", method = RequestMethod.POST)
public String balongsList(HttpServletRequest req){
	String Mid = req.getParameter("MerchandiseId");
	sb = new StringBuffer();
	sb.append("{\"result\":\"1002\",\"msg\":\"Success\",\"data\":{");
	String s= merchandiseService.findById(Integer.parseInt(Mid)).toString();
	sb.append(s+",");
	s=promotionService.findById(1).toString();
	sb.append(s);
	UserInformation userInformation =(UserInformation)req.getSession().getAttribute("user");
	if(userInformation != null){
        List<Profile> byUserId = profileService.findByUserId(userInformation.getId());
        if(byUserId.size()>0){
        sb.append(","+byUserId.get(0)+",");
        }
       sb.append("\"vip\":\""+userInformation.getYuchong_vip()+"\"");
    }

	sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
    return sb.toString();
}


	//根据类别获取推荐商品列表
	@RequestMapping(value = "/RecommendMerchandise/Type", method = RequestMethod.POST)
	public String recommendMerchandiseType(HttpServletRequest req){
		String type = req.getParameter("type");
		String first = req.getParameter("first");
		String end = req.getParameter("end");
		sb = new StringBuffer();
		sb.append("{\"result\":\"1005\",\"msg\":\"Success\",\"data\":{");
		List<MerchandiseShow>  mss= merchandiseShowService.findByRecommendType(type,Integer.parseInt(first),Integer.parseInt(end));
		System.out.println(mss);
		sb.append("\"ListArray\":[");
		for(MerchandiseShow merchandiseShow:mss){
			sb.append(merchandiseShow);
			sb.append(",");
		}
		sb=sb.deleteCharAt(sb.length()-1);

		sb.append("]");
		sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
		return sb.toString();
	}



	//根据类别获取商品列表
	@RequestMapping(value = "/Merchandise/Type", method = RequestMethod.POST)
	public String balongsType(HttpServletRequest req){
		String type = req.getParameter("type");
		String first = req.getParameter("first");
		String end = req.getParameter("end");
		sb = new StringBuffer();
		sb.append("{\"result\":\"1004\",\"msg\":\"Success\",\"data\":{");
		List<MerchandiseShow>  mss= merchandiseShowService.findByTypePaging(type,Integer.parseInt(first),Integer.parseInt(end));
		System.out.println(mss);
		sb.append("\"ListArray\":[");
		for(MerchandiseShow merchandiseShow:mss){
			sb.append(merchandiseShow);
			sb.append(",");
		}
		sb=sb.deleteCharAt(sb.length()-1);

		sb.append("]");
		sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
		return sb.toString();
	}



	//根据商品类别俩获取相应的主图
	@RequestMapping(value = "/MerchandiseImg/Type", method = RequestMethod.POST)
	public String prefectureImgType(HttpServletRequest req){
		String type = req.getParameter("type");
		sb = new StringBuffer();
		sb.append("{\"result\":\"1003\",\"msg\":\"Success\",\"data\":{\"PrefectureImgs\":{");
		List<PrefectureImg> prefectureImgs = prefectureImgService.findByType(type);
		for(PrefectureImg prefectureImg :prefectureImgs){
			sb.append(prefectureImg+",");
		}
		sb =sb.delete(sb.length()-1,sb.length());
		sb.append("}");
		sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
		return sb.toString();
	}

	//查询所有商品的品牌
	@RequestMapping(value = "/brand/Type", method = RequestMethod.POST)
	public String  brandType(HttpServletRequest req){
		sb = new StringBuffer();
		sb.append("{\"result\":\"1003\",\"msg\":\"Success\",\"data\":{\"brands\":[");
		String[] strings = merchandiseShowService.findByBrand();
        for(String s:strings){
        	sb.append("\""+s+"\",");
        }
		sb =sb.delete(sb.length()-1,sb.length());
		sb.append("],\"origins\":[");
		strings = merchandiseShowService.findByOrigin();
		for(String s:strings){
			sb.append("\""+s+"\",");
		}
        sb =sb.delete(sb.length()-1,sb.length());
sb.append("],\"suitableobjects\":[");
        strings = merchandiseShowService.findByObject();
        for(String s:strings){
            sb.append("\""+s+"\",");
        }
		sb =sb.delete(sb.length()-1,sb.length());
		sb.append("]");
		sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
		return sb.toString();
	}


}
