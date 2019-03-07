package com.zanyun.org.service;

import java.util.Map;

import com.zanyun.index.model.User;
import com.zanyun.model.PageInfo;
import com.zanyun.model.Render;
import com.zanyun.model.TUser;
import com.zanyun.org.model.ZsOrg;

public interface OrgService {

	Map<String, String> zsOrgRegist(ZsOrg org);

	

	String zsFindMoney(TUser user);

	Map<String, String> zsDongleKeyBinding(ZsOrg org);

	String findzsmoney();

	

	Integer donglekeyActivation(String donglekey, String loginname,
			String password);

	PageInfo<Render> zsRenderList(ZsOrg org, User user);

}
