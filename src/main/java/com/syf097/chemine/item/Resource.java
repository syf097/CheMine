package com.syf097.chemine.item;

import net.minecraft.item.EnumDyeColor;

public enum Resource {
	PYSITE_CRUSHED( "pysite_crushed",4),
	SPONGEIRON("sponge_iron",3),
	FERRITE("ferrite",2),
	IRON_NORMAL("iron_normal",1),
	IRON_RAW("iron_raw",0);
	
	public final  String name;
	public final int id;
	Resource(String n ,int t){
		name=n;
		id=t;
	}
	public  static String getName(int i) {
		for(Resource r : values())
		if(r.id==i) {
			return r.name;
		}
		return null;
	}
}
