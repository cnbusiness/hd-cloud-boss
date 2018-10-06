package com.hd.cloud.dao.moment.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.AdAdress;
import com.hd.cloud.bo.AdBo;
import com.hd.cloud.bo.AdModule;
import com.hd.cloud.bo.Advertisement;
import com.hd.cloud.dao.moment.sql.AdvertProvider;
import com.hd.cloud.vo.AdModuleVo;
import com.hd.cloud.vo.AdvertVo;

/**
 * 
 * @ClassName AdvertMapper.java
 * @Description 广告管理
 * @author 龙威
 * @company hadoop-tech
 * @Date 2018年5月4日 上午11:47:41
 *
 */
@Mapper
public interface AdvertMapper {
	
	/**
	 * 
	 * @Title:getAdvertList
	 * @Description:广告列表
	 * @param advertVo
	 * @return List<Advertisement>
	 */
	@SelectProvider(type = AdvertProvider.class,method = "getAdvertList")
	@Results(value  = {
			@Result(property = "id",column = "ad_advert_base_bb_seq",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "desc",column = "advert_base_desc",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "title",column = "advert_base_title",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "picUrl",column = "advert_base_pic_url",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "linkItype",column = "advert_base_link_itype",javaType = int.class,jdbcType = JdbcType.TINYINT),
			@Result(property = "linkUrl",column = "advert_base_link_url",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "viewCnt",column = "advert_base_view_cnt",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "clickCnt",column = "advert_base_click_cnt",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "statusItype",column = "advert_base_status_itype",javaType = int.class,jdbcType = JdbcType.TINYINT),
			@Result(property = "clickItype",column = "advert_base_click_itype",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "adModuleName",column = "advert_module_name",javaType = String.class,jdbcType = JdbcType.VARCHAR),
	})
	List<Advertisement> getAdvertList(AdvertVo advertVo);
	
	/**
	 * 
	 * @Title:getAdvertCount
	 * @Description:总数
	 * @param advertVo
	 * @return Integer
	 */
	@SelectProvider(type = AdvertProvider.class,method = "getAdvertCount")
	Integer getAdvertCount(AdvertVo advertVo);
	
	/**
	 * 
	 * @Title:createAd
	 * @Description:创建广告
	 * @param advertisement void
	 */
	@InsertProvider(type=AdvertProvider.class,method = "createAd")
	@SelectKey(keyProperty = "id", before = false, resultType = int.class, statement = {"SELECT LAST_INSERT_ID() AS id  " })
	void createAd(Advertisement advertisement);
	
	/**
	 * 
	 * @Title:createAdAdress
	 * @Description:创建广告地址
	 * @param adAdress void
	 */
	@InsertProvider(type=AdvertProvider.class,method = "createAdAdress")
	@SelectKey(keyProperty = "id", before = false, resultType = int.class, statement = {"SELECT LAST_INSERT_ID() AS id  " })
	void createAdAdress(AdAdress adAdress);
	
	/**
	 * 
	 * @Title:getAdBoById
	 * @Description:通过ID获取广告信息
	 * @param id
	 * @return AdBo
	 */
	@SelectProvider(type=AdvertProvider.class,method="getAdBoById")
	@Results(value={
			@Result(property = "id",column = "ad_advert_base_bb_seq",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "title",column = "advert_base_title",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "desc",column = "advert_base_desc",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "picUrl",column = "advert_base_pic_url",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "linkItype",column = "advert_base_link_itype",javaType = int.class,jdbcType = JdbcType.TINYINT),
			@Result(property = "linkUrl",column = "advert_base_link_url",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "statusItype",column = "advert_base_status_itype",javaType = int.class,jdbcType = JdbcType.TINYINT),
			@Result(property = "countryCode",column = "city_dict_country_code",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "adModuleId",column = "ad_advert_module_sd_seq",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "cityId",column = "pub_city_dict_sd_seq",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "showType",column = "xadvert_module_show_itype",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "clickItype",column = "advert_base_click_itype",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "validItype",column = "advert_base_valid_itype",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "validBtime",column = "advert_base_valid_btime",javaType = Date.class,jdbcType = JdbcType.DATE),
			@Result(property = "validEtime",column = "advert_base_valid_etime",javaType = Date.class,jdbcType = JdbcType.DATE),
			@Result(property = "viewCnt",column = "advert_base_view_cnt",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "clickCnt",column = "advert_base_click_cnt",javaType = int.class,jdbcType = JdbcType.INTEGER),
	})
	AdBo getAdBoById(@Param("id") int id);
	
	/**
	 * 
	 * @Title:getAdByAdTitle
	 * @Description:验证广告是否存在
	 * @param title
	 * @param id
	 * @return int
	 */
	@Select("select count(1) from ad_advert_base_bb where ad_advert_base_bb_seq != #{id} and advert_base_title = #{title} and active_flag = 'y'")
	int getAdByAdTitle(@Param(value="title")String title,@Param(value="id") long id);
	
	/**
	 * 
	 * @Title:deleteAd
	 * @Description:删除广告
	 * @param id
	 * @return int
	 */
	@Delete("delete from ad_advert_base_bb where ad_advert_base_bb_seq=#{id}")
	int deleteAd(@Param("id") int id);
	
	/**
	 * 
	 * @Title:createAdModule
	 * @Description:创建广告模块
	 * @param adModule void
	 */
	@InsertProvider(type=AdvertProvider.class,method = "createAdModule")
	@SelectKey(keyProperty = "id", before = false, resultType = int.class, statement = {"SELECT LAST_INSERT_ID() AS id  " })
	void createAdModule(AdModule adModule);
	
	/**
	 * 
	 * @Title:deleteAdAdress
	 * @Description:删除广告地址
	 * @param id
	 * @return int
	 */
	@Delete("delete from ad_xadvert_module_city_br where ad_advert_base_bb_seq = #{id}")
	int deleteAdAdress(@Param("id") int id);
	
	/**
	 * 
	 * @Title:updateAd
	 * @Description:编辑广告
	 * @param advert
	 * @return int
	 */
	@UpdateProvider(type = AdvertProvider.class, method = "updateAd")
	int updateAd(Advertisement advert);
	
	/**
	 * 
	 * @Title:updateAdAdress
	 * @Description:编辑广告地址
	 * @param adAdress
	 * @return int
	 */
	@UpdateProvider(type = AdvertProvider.class, method = "updateAdAdress")
	int updateAdAdress(AdAdress adAdress);
	
	@SelectProvider(type = AdvertProvider.class,method = "getAdModuleList")
	@Results(value={
			@Result(property = "id",column = "ad_advert_module_sd_seq",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "moduleName",column = "advert_module_name",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "moduleRemark",column = "advert_module_desc",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "type",column = "advert_module_banner_itype",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "bannerTotals",column = "advert_module_banner_totals",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "BannerCode",column = "advert_module_internal_code",javaType = String.class,jdbcType = JdbcType.VARCHAR),
			@Result(property = "validType",column = "advert_module_valid_itype",javaType = int.class,jdbcType = JdbcType.INTEGER),
			@Result(property = "activeFlag",column = "active_flag",javaType = String.class,jdbcType = JdbcType.VARCHAR),
	})
	List<AdModule> getAdModuleList(AdModuleVo adModuleVo);
	
	@SelectProvider(type = AdvertProvider.class,method = "getAdModuleCount")
	int getAdModuoleCount(AdModuleVo adModuleVo);
	

}
