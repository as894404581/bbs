package xyz.zhtdemo.bbs.entity;

public enum IntergralEnum {
	Integral1,
	Integral2,
	Integral3,
	Integral4,
	Integral5,
	Integral6,
	Integral7,
	Integral8;
	public static boolean contains(String type){  
        for(IntergralEnum typeEnum : IntergralEnum.values()){  
            if(typeEnum.name().equals(type)){  
                return true;  
            }  
        }  
        return false;  
    }  
}
