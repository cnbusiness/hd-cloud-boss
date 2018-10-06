package com.hd.cloud.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hd.cloud.bo.AdAdress;
import com.hd.cloud.bo.AdBo;
import com.hd.cloud.bo.AdModule;
import com.hd.cloud.bo.Advertisement;
import com.hd.cloud.dao.moment.AdvertDao;
import com.hd.cloud.service.AdvertService;
import com.hd.cloud.vo.AdModuleVo;
import com.hd.cloud.vo.AdvertVo;

@Service
public class AdvertServiceImpl implements AdvertService{
	
	@Inject
	private AdvertDao advertDao;
	
	@Override
	public List<Advertisement> getAdvertList(AdvertVo advertVo) {
		// TODO Auto-generated method stub
		return advertDao.getAdvertList(advertVo);
	}

	@Override
	public int getAdvertCount(AdvertVo advertVo) {
		// TODO Auto-generated method stub
		return advertDao.getAdvertCount(advertVo);
	}

	@Override
	@Transactional
	public void createAd(Advertisement ad) {
		advertDao.createAd(ad);
	}

	@Override
	public AdBo getAdBoById(int id) {
		// TODO Auto-generated method stub
		return advertDao.getAdBoById(id);
	}

	@Override
	public int getAdByTitle(String title, long id) {
		// TODO Auto-generated method stub
		return advertDao.getAdByAdTitle(title, id);
	}

	@Override
	@Transactional
	public void createAdModule(AdModule adModule) {
			advertDao.createAdModule(adModule);
	}

	@Override
	public int deleteAd(int id) {
		// TODO Auto-generated method stub
		return advertDao.deleteAd(id);
	}
	
	

	@Override
	public void updateAd(Advertisement ad) {
			advertDao.updateAd(ad);
	}

	@Override
	public int deleteAdAdress(int id) {
		// TODO Auto-generated method stub
		return advertDao.deleteAdAdress(id);
	}

	@Override
	public List<AdModule> getAdModuleList(AdModuleVo adModuleVo) {
		// TODO Auto-generated method stub
		return advertDao.getAdModuleList(adModuleVo);
	}

	@Override
	public int getAdModuleCount(AdModuleVo adModuleVo) {
		// TODO Auto-generated method stub
		return advertDao.getAdModuoleCount(adModuleVo);
	}

	@Override
	public void createAdAdress(AdAdress adAddress) {
		advertDao.createAdAdress(adAddress);
		
	}

	@Override
	public void updateAdAdress(AdAdress adAddress) {
		advertDao.updateAdAdress(adAddress);
		
	}



}
