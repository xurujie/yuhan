package com.yuhan.controller;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.yuhan.entities.*;
import com.yuhan.service.*;
import com.yuhan.test.RsaUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yuhan.model.OrderListShow;
import com.yuhan.util.DateUtil;

import javax.servlet.http.HttpServletRequest;

@RestController
public class OrderListController {
	@Autowired
	private OrderListService orderListService;
	@Autowired
	private ProfileService profileService;
	@Autowired
	private ExperssService experssService;
	@Autowired
	MerchandiseShowService merchandiseShowService;
	@Autowired
	private MerchandiseService merchandiseService;
	@Autowired
	PromotionService promotionService;
	StringBuffer sb ;

	
	//全部订单列表
	@RequestMapping(value = "/Order/List", method = RequestMethod.POST)
	public String balongsList(){
		sb=new StringBuffer();
		sb.append("{\"result\":\"0021\",\"msg\":\"Success\",\"data\":{\"OrderListShow\":");
	   sb.append(orderListService.findByUserId(100001));
	  sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
	    return sb.toString();

	}
	
	//
	@RequestMapping(value = "/Order/List/get1", method = RequestMethod.POST)
	public String balongsListGet1(){
		sb=new StringBuffer();
		sb.append("{\"result\":\"0022\",\"msg\":\"Success\",\"data\":{\"OrderListShow\":");
		List<OrderListShow> olss = orderListService.findByUserIdAndStatus(100001, "1");
		if(olss!=null){
		sb.append(olss);
		}
		sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
		//使用正则把中括号替换
	    /*return sb.toString().replaceAll("[\\[\\]]", "");*/
	    return sb.toString();

	}
	//
	@RequestMapping(value = "/Order/List/get2", method = RequestMethod.POST)
	public String balongsListGet2(){
		sb=new StringBuffer();
		sb.append("{\"result\":\"0023\",\"msg\":\"Success\",\"data\":{\"OrderListShow\":");
		List<OrderListShow> olss = orderListService.findByUserIdAndStatus(100001, "2");
		if(olss!=null){
		sb.append(olss);
		}
		sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
	    return sb.toString();
 
	}
	//
	@RequestMapping(value = "/Order/List/get3", method = RequestMethod.POST)
	public String balongsListGet3(){
		sb=new StringBuffer();
		sb.append("{\"result\":\"0024\",\"msg\":\"Success\",\"data\":{\"OrderListShow\":");
		List<OrderListShow> olss = orderListService.findByUserIdAndStatus(100001, "3");
		if(olss!=null){
		sb.append(olss);
		}
		sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
		
	    return sb.toString();
 
	}
	
	
	@RequestMapping(value = "/Order/List/get4", method = RequestMethod.POST)
	public String balongsListGet4(){
		sb=new StringBuffer();
		sb.append("{\"result\":\"0025\",\"msg\":\"Success\",\"data\":{\"OrderListShow\":");
		List<OrderListShow> olss = orderListService.findByUserIdAndStatus(100001, "4");
		if(olss!=null){
		sb.append(olss);
		}
		sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
	    return sb.toString();
	}
	
	
	//根据订单号查询订单信息
	@RequestMapping(value = "/Order/ById", method = RequestMethod.POST)
	public String findByOrderId(HttpServletRequest req){
		String orderNumber = req.getParameter("orderNumber");
		orderNumber =orderNumber.substring(8);
				sb=new StringBuffer();
		sb.append("{\"result\":\"0026\",\"msg\":\"Success\",\"data\":{\"OrderById\":[");
		int orderId = Integer.parseInt(orderNumber);
		OrderListShow olss = orderListService.findById(orderId);
		Profile profile = profileService.findByOrderListId(orderId);
		if(olss!=null){
			sb.append(olss);
			sb.append("],");
		sb.append(profile);

		int i = Integer.parseInt(olss.getStatus());
		System.out.println(i);
		if(i!=0&&i!=1&&i!=2){
			sb.append(",");
			sb.append(experssService.findByOrderId(orderId));
		}
		}
		sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
	    return sb.toString();
	}


	//根据提交信息来进行信息验证
	@RequestMapping(value = "/add/Order1", method = RequestMethod.POST)
	public String addOrder1(HttpServletRequest req){
		sb = new StringBuffer();
		UserInformation user = (UserInformation)req.getSession().getAttribute("user");
        int user_id = user.getId();
		String merchandiseSum =  req.getParameter("merchandiseSum");
		String merchandiseId = req.getParameter("merchandiseId");
		Merchandise merchandise =merchandiseService.findById(Integer.parseInt(merchandiseId));
        MerchandiseShow merchandiseShow =merchandiseShowService.findById(Integer.parseInt(merchandiseId));//商品信息
		Promotion byId = promotionService.findById(1);
		double price = Double.parseDouble(merchandise.getPrice());
		price = price*Double.parseDouble(merchandiseSum);//总金额
		List<Profile>  profiles=profileService.findByUserId(user_id);//收货地址
		int integral =Integer.parseInt(user.getAccount_integral());//账户积分
		double balance =Double.parseDouble(user.getBalance_account());//账户余额
		sb.append("{\"result\":\"0026\",\"msg\":\"Success\",\"data\":{");
		sb.append("\"merchandise\":"+merchandiseShow+",");
		sb.append("\"price\":\""+price+"\",");
		sb.append("\"integral\":\""+integral+"\",");
		sb.append("\"balance\":\""+balance+"\",");
		sb.append(byId+",");
		for(Profile profile :profiles){
			sb.append(profile+",");
		}
sb =sb.delete(sb.length()-1,sb.length());
		sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
		return sb.toString().replaceAll("[\\[\\]]", "");
	}



	//获得公钥
	@RequestMapping(value = "/publicKey", method = RequestMethod.POST)
	public String publicKey(HttpServletRequest req) throws InvalidKeySpecException, NoSuchAlgorithmException {
	    sb = new StringBuffer();
		Map<String, String> keys = RsaUnit.createKeys(1024);
		String privateKeyString = keys.get("privateKey");
		String publicKeyString =keys.get("publicKey");
        RSAPublicKey rsaPublicKey=RsaUnit.getPublicKey(publicKeyString);
        PrivateKey privateKey=RsaUnit.getPrivateKey(privateKeyString);
        String Modulus=rsaPublicKey.getModulus().toString(16);
        String Exponent=rsaPublicKey.getPublicExponent().toString(16);
		req.getSession().setAttribute("privateKey",privateKey);
        System.out.println("Modulus:"+Modulus);
        System.out.println("Exponent:"+Exponent);
		sb.append("{\"result\":\"0026\",\"msg\":\"Success\",\"data\":{");
        sb.append("\"modulus\":\""+Modulus+"\",");
		sb.append("\"exponent\":\""+Exponent+"\"");
		sb.append("},\"sign\":\""+DateUtil.formate0(new Date(), "yyyy-MM-dd	HH:mm:ss")+"\"}");
		return sb.toString();
	}


	//核实订单
	@RequestMapping(value = "/verifyOrder", method = RequestMethod.POST)
	public int verifyOrder(HttpServletRequest req) throws Exception {
		String merchandiseId =req.getParameter("merchandiseId");//商品id
		String merchandiseSum =req.getParameter("merchandiseSum");//商品数量
		String useCoupon=req.getParameter("useCoupon");//使用优惠券
		String fullDiscount =req.getParameter("fullDiscount");//满减优惠
		String usingIntegrals =req.getParameter("usingIntegrals");//使用积分
		String balanceDeduction =req.getParameter("balanceDeduction");//余额抵扣
		String mPrice =req.getParameter("mPrice");//商品成交价格
		String expressFee =req.getParameter("expressFee");//快递费用
		String sumPrice =req.getParameter("sumPrice");//总成交价格
		String receivingAddress =req.getParameter("receivingAddress");//收货地址id


        Promotion byId = promotionService.findById(1);
     /*   String 	merchandiseId =	RsaUnit.privateKeyDecode(req,"merchandiseId");
        String 	merchandiseSum =	RsaUnit.privateKeyDecode(req,"merchandiseSum");
        String 	useCoupon =	RsaUnit.privateKeyDecode(req,"useCoupon");
        String 	fullDiscount =	RsaUnit.privateKeyDecode(req,"fullDiscount");
        String 	usingIntegrals =	RsaUnit.privateKeyDecode(req,"usingIntegrals");
        String 	balanceDeduction =	RsaUnit.privateKeyDecode(req,"balanceDeduction");
        String 	mPrice =	RsaUnit.privateKeyDecode(req,"mPrice");
        String 	expressFee =	RsaUnit.privateKeyDecode(req,"expressFee");
        String 	sumPrice =	RsaUnit.privateKeyDecode(req,"sumPrice");
        String 	receivingAddress =	RsaUnit.privateKeyDecode(req,"receivingAddress");*/
        UserInformation user = (UserInformation)req.getSession().getAttribute("user");
        Merchandise merchandise =merchandiseService.findById(Integer.parseInt(merchandiseId));
        int user_id = user.getId();
		MerchandiseShow merchandiseShow =merchandiseShowService.findById(Integer.parseInt(merchandiseId));//商品信息
		double price = Double.parseDouble(merchandise.getPrice());
		price = price*Double.parseDouble(merchandiseSum);//总金额
    	price = price-(double)((int)(price/Double.parseDouble(byId.getSum())))*Double.parseDouble(byId.getSum_off());
		int integral =Integer.parseInt(user.getAccount_integral());//账户积分
		double balance =Double.parseDouble(user.getBalance_account());//账户余额
		if(integral<Integer.parseInt(usingIntegrals)){
			return 10;
		}
		if(balance<Double.parseDouble(balanceDeduction)){
			return 30;
		}
		if(price!=(double)(Double.parseDouble(usingIntegrals)/100)+Double.parseDouble(mPrice)+Double.parseDouble(balanceDeduction)){
			System.out.println(price);
			System.out.println((Double.parseDouble(usingIntegrals)/100));
			System.out.println(balanceDeduction);
			System.out.println(balanceDeduction);
			return 40;
		}

		OrderList orderList = new OrderList();
		orderList.setUser_id(user_id);
		orderList.setMerchandises_id(merchandiseId+";");
		orderList.setMerchandise_sum(merchandiseSum+";");
	    orderList.setOrder_time(Timestamp.valueOf(DateUtil.formate(new Date(),"yyyy-MM-dd HH:mm:ss")));
	    orderList.setOrderprice(mPrice);
	    orderList.setDiscountcoding(useCoupon);
	    orderList.setBalance_account(balanceDeduction);
	    orderList.setIntegral(usingIntegrals);
        orderList.setStatus("0");
	    orderList.setState(receivingAddress);
	    orderList.setDeadline(DateUtil.formateAdd30minute(new Date()));
	    orderList.setError("0");
	    int i =orderListService.addOrderList(orderList);
        /*sb = new StringBuffer();*/
return i;
	}

	//核实订单
	@RequestMapping(value = "/clearingOrder", method = RequestMethod.POST)
	public int clearingOrder(HttpServletRequest req) throws Exception {

		return  0;
	}


}
