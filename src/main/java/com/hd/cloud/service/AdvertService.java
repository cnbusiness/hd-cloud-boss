package com.hd.cloud.service;

import java.util.List;

import com.hd.cloud.bo.AdAdress;
import com.hd.cloud.bo.AdBo;
import com.hd.cloud.bo.AdModule;
import com.hd.cloud.bo.Advertisement;
import com.hd.cloud.vo.AdModuleVo;
import com.hd.cloud.vo.AdvertVo;

public interface AdvertService {
	
	public List<Advertisement> getAdvertList(AdvertVo advertVo);
	
	public int getAdvertCount(AdvertVo advertVo);
	
	public List<AdModule>	getAdModuleList(AdModuleVo adModuleVo);
	
	public int getAdModuleCount(AdModuleVo adModuleVo);
	
	public void createAd(Advertisement ad);
	
	public void createAdAdress(AdAdress adAddress);
	
	public AdBo getAdBoById(int id);
	
	public int getAdByTitle(String title, long id);
	
	public void createAdModule(AdModule adModule);
	
	public int deleteAd(int id);
	
	public int deleteAdAdress(int id);
	
	public void updateAd(Advertisement ad);
	
	public void updateAdAdress(AdAdress adAddress);
	
}
