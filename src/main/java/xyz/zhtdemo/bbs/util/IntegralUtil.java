package xyz.zhtdemo.bbs.util;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import xyz.zhtdemo.bbs.entity.User_CountEnt;
import xyz.zhtdemo.bbs.enums.TradeIntegralTypesEnum;
import xyz.zhtdemo.bbs.inter.User_CountService;

@Component
public class IntegralUtil {
	@Resource
	User_CountService ucs;

	/**
	 * 获取用户交易积分数量
	 * @param uid 用户id
	 * @return
	 */
	public int getUserTradeIntegralCount(int uid) {
		User_CountEnt uce = ucs.getUserIntegralByUserId(uid);
		switch (Config.TradeIntegral) {
		case Integral1:
			return uce.getIntegral1();
		case Integral2:
			return uce.getIntegral2();
		case Integral3:
			return uce.getIntegral3();
		case Integral4:
			return uce.getIntegral4();
		case Integral5:
			return uce.getIntegral5();
		case Integral6:
			return uce.getIntegral6();
		case Integral7:
			return uce.getIntegral7();
		case Integral8:
			return uce.getIntegral8();
		}
		return 0;
	}
	/**
	 * 根据用户id增加或减少交易积分
	 * @param uid 用户id
	 * @param price 积分数
	 * @param tte 增加or减少
	 */
	public void Trade(int uid,int price,TradeIntegralTypesEnum tte){
		User_CountEnt uce = ucs.getUserIntegralByUserId(uid);
		User_CountEnt uce1=new User_CountEnt();
		uce1.setUser_id(uce.getUser_id());
		if(tte==TradeIntegralTypesEnum.increase)
		{
			switch (Config.TradeIntegral) {
			case Integral1:
				 uce1.setIntegral1(uce.getIntegral1()+price);
				 break;
			case Integral2:
				 uce1.setIntegral2(uce.getIntegral2()+price);
				 break;
			case Integral3:
				 uce1.setIntegral3(uce.getIntegral3()+price);
				 break;
			case Integral4:
				 uce1.setIntegral4(uce.getIntegral4()+price);
				 break;
			case Integral5:
				 uce1.setIntegral5(uce.getIntegral5()+price);
				 break;
			case Integral6:
				 uce1.setIntegral6(uce.getIntegral6()+price);
				 break;
			case Integral7:
				 uce1.setIntegral7(uce.getIntegral7()+price);
				 break;
			case Integral8:
				 uce1.setIntegral8(uce.getIntegral8()+price);
				 break;
			}		
		}else{
			switch (Config.TradeIntegral) {
			case Integral1:
				 uce1.setIntegral1(uce.getIntegral1()-price);
				 break;
			case Integral2:
				 uce1.setIntegral2(uce.getIntegral2()-price);
				 break;
			case Integral3:
				 uce1.setIntegral3(uce.getIntegral3()-price);
				 break;
			case Integral4:
				 uce1.setIntegral4(uce.getIntegral4()-price);
				 break;
			case Integral5:
				 uce1.setIntegral5(uce.getIntegral5()-price);
				 break;
			case Integral6:
				 uce1.setIntegral6(uce.getIntegral6()-price);
				 break;
			case Integral7:
				 uce1.setIntegral7(uce.getIntegral7()-price);
				 break;
			case Integral8:
				 uce1.setIntegral8(uce.getIntegral8()-price);
				 break;
			}	
		}
		
			
		ucs.updateUser_Count(uce1);
	}
}
