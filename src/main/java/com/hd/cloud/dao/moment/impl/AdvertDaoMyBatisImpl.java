package com.hd.cloud.dao.moment.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.AdAdress;
import com.hd.cloud.bo.AdBo;
import com.hd.cloud.bo.AdModule;
import com.hd.cloud.bo.Advertisement;
import com.hd.cloud.dao.moment.AdvertDao;
import com.hd.cloud.dao.moment.mapper.AdvertMapper;
import com.hd.cloud.vo.AdModuleVo;
import com.hd.cloud.vo.AdvertVo;

@Repository
public class AdvertDaoMyBatisImpl implements AdvertDao{
	
	@Inject
	private AdvertMapper advertMapper;
	
	@Override
	public List<Advertisement> getAdvertList(AdvertVo advertVo) {
		// TODO Auto-generated method stub
		return advertMapper.getAdvertList(advertVo);
	}

	@Override
	public int getAdvertCount(AdvertVo advertVo) {
		// TODO Auto-generated method stub
		return advertMapper.getAdvertCount(advertVo);
	}

	@Override
	public void createAd(Advertisement advertisement) {
		advertMapper.createAd(advertisement);
		
	}

	@Override
	public void createAdAdress(AdAdress adAdress) {
		advertMapper.createAdAdress(adAdress);
		
	}

	@Override
	public AdBo getAdBoById(int id) {
		// TODO Auto-generated method stub
		return advertMapper.getAdBoById(id);
	}

	@Override
	public int getAdByAdTitle(String title, long id) {
		// TODO Auto-generated method stub
		return advertMapper.getAdByAdTitle(title,id);
	}

	@Override
	public int deleteAd(int id) {
		// TODO Auto-generated method stub
		return advertMapper.deleteAd(id);
	}

	@Override
	public void createAdModule(AdModule adModule) {
		advertMapper.createAdModule(adModule);
		
	}

	@Override
	public int updateAd(Advertisement advert) {
		// TODO Auto-generated method stub
		return advertMapper.updateAd(advert);
	}

	@Override
	public int updateAdAdress(AdAdress adAdress) {
		// TODO Auto-generated method stub
		return advertMapper.updateAdAdress(adAdress);
	}

	@Override
	public int deleteAdAdress(int id) {
		// TODO Auto-generated method stub
		return advertMapper.deleteAdAdress(id);
	}

	@Override
	public List<AdModule> getAdModuleList(AdModuleVo adModuleVo) {
		// TODO Auto-generated method stub
		return advertMapper.getAdModuleList(adModuleVo);
	}

	@Override
	public int getAdModuoleCount(AdModuleVo adModuleVo) {
		// TODO Auto-generated method stub
		return advertMapper.getAdModuoleCount(adModuleVo);
	}



}
