package com.hd.cloud.dao.moment;

import java.util.List;

import com.hd.cloud.bo.AdAdress;
import com.hd.cloud.bo.AdBo;
import com.hd.cloud.bo.AdModule;
import com.hd.cloud.bo.Advertisement;
import com.hd.cloud.vo.AdModuleVo;
import com.hd.cloud.vo.AdvertVo;

public interface AdvertDao {
	
	/**
	 * 
	 * @Title:getAdvertList
	 * @Description:广告列表
	 * @param advertVo
	 * @return List<Advertisement>
	 */
	public List<Advertisement> getAdvertList(AdvertVo advertVo);
	
	/**
	 * 
	 * @Title:getAdvertCount
	 * @Description:广告列表总数
	 * @param advertVo
	 * @return int
	 */
	public int getAdvertCount(AdvertVo advertVo);
	
	/**
	 * 
	 * @Title:getAdModuleList
	 * @Description:广告模块列表
	 * @param adModuleVo
	 * @return List<AdModule>
	 */
	public List<AdModule> getAdModuleList(AdModuleVo adModuleVo);
	
	/**
	 * 
	 * @Title:getAdModuoleCount
	 * @Description:广告模块列表总数
	 * @param adModuleVo
	 * @return int
	 */
	public int getAdModuoleCount(AdModuleVo adModuleVo);
	
	/**
	 * 
	 * @Title:createAd
	 * @Description:创建广告
	 * @param advertisement void
	 */
	public void createAd(Advertisement advertisement);
	
	/**
	 * 
	 * @Title:createAdAdress
	 * @Description:创建广告地址
	 * @param adAdress void
	 */
	public void createAdAdress(AdAdress adAdress);
	
	/**
	 * 
	 * @Title:createAdModule
	 * @Description:创建广告模块
	 * @param adModule void
	 */
	public void createAdModule(AdModule adModule);
	
	/**
	 * 
	 * @Title:getAdBoById
	 * @Description:通过id查询广告详情
	 * @param id
	 * @return AdBo
	 */
	public AdBo getAdBoById(int id);
	
	/**
	 * 
	 * @Title:getAdByAdTitle
	 * @Description:验证广告是否存在
	 * @param title
	 * @param id
	 * @return int
	 */
	public int getAdByAdTitle(String title,long id);
	
	/**
	 * 
	 * @Title:updateAd
	 * @Description:修改广告
	 * @param advert
	 * @return int
	 */
	public int updateAd(Advertisement advert);
	
	/**
	 * 
	 * @Title:updateAdAdress
	 * @Description:修改广告地址
	 * @param adAdress
	 * @return int
	 */
	public int updateAdAdress(AdAdress adAdress);
	
	/**
	 * 
	 * @Title:deleteAd
	 * @Description:删除广告
	 * @param id
	 * @return int
	 */
	public int deleteAd(int id);
	
	/**
	 * 
	 * @Title:deleteAdAdress
	 * @Description:删除广告地址
	 * @param id
	 * @return int
	 */
	public int deleteAdAdress(int id );
}
