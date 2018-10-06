package com.hd.cloud.dao.moment.sql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.hd.cloud.bo.AdAdress;
import com.hd.cloud.bo.AdModule;
import com.hd.cloud.bo.Advertisement;
import com.hd.cloud.util.StringUtil;
import com.hd.cloud.vo.AdModuleVo;
import com.hd.cloud.vo.AdvertVo;
import com.hlb.cloud.util.CommonConstantUtil;

public class AdvertProvider {
	
	/**
	 * 
	 * @Title:getAdvertList
	 * @Description:获取广告列表
	 * @param advertVo
	 * @return String
	 */
	public String getAdvertList(AdvertVo advertVo){
		String sql = new SQL(){
			{
				SELECT("a.ad_advert_base_bb_seq,a.advert_base_title,a.advert_base_desc,a.advert_base_pic_url,a.advert_base_link_itype,a.advert_base_link_url,a.advert_base_view_cnt,a.advert_base_click_cnt,a.advert_base_status_itype,c.ad_advert_module_sd_seq,c.advert_module_name");
				FROM("ad_advert_base_bb a , ad_xadvert_module_city_br b ,ad_advert_module_sd c");
				WHERE("a.active_flag = 'y' and a.ad_advert_base_bb_seq=b.ad_advert_base_bb_seq and b.active_flag='y' and c.active_flag='y' and b.ad_advert_module_sd_seq = c.ad_advert_module_sd_seq");
				if(!StringUtil.isBlank(advertVo.getTitle())){
					AND();
					WHERE("a.advert_base_title LIKE CONCAT('%',#{title},'%')");
				}
				if(advertVo.getStatus()!=0){
					AND();
					WHERE("a.advert_base_status_itype = #{status}");
				}
				if(advertVo.getAdModuleId()>0){
					AND();
					WHERE("c.ad_advert_module_sd_seq = #{adModuleId}");
				}
				ORDER_BY("a.ad_advert_base_bb_seq desc limit #{offset},#{pageSize}");
			}
		}.toString();
		return sql;
	}
	
	/**
	 * 
	 * @Title:getAdvertCount
	 * @Description:获取广告列表总数
	 * @param advertVo
	 * @return String
	 */
	public String getAdvertCount(AdvertVo advertVo){
		String sql = new SQL(){
			{
				SELECT("COUNT(1)");
				FROM("ad_advert_base_bb a , ad_xadvert_module_city_br b ,ad_advert_module_sd c");
				WHERE("a.active_flag = 'y' and a.ad_advert_base_bb_seq=b.ad_advert_base_bb_seq and b.active_flag='y' and c.active_flag='y' and b.ad_advert_module_sd_seq = c.ad_advert_module_sd_seq");
				if(!StringUtil.isBlank(advertVo.getTitle())){
					AND();
					WHERE("a.advert_base_title LIKE CONCAT('%',#{title},'%')");
				}
				if(advertVo.getStatus()> 0){
					AND();
					WHERE("a.advert_base_status_itype = #{status}");
				}
				if(advertVo.getAdModuleId()>0){
					AND();
					WHERE("c.ad_advert_module_sd_seq = #{adModuleId}");
				}
			}
		}.toString();
		return sql;
	}
	
	public String getAdModuleList(AdModuleVo adModuleVo){
		String sql = new SQL(){
			{
				SELECT("ad_advert_module_sd_seq,advert_module_name,advert_module_desc,advert_module_banner_itype,advert_module_banner_totals,advert_module_internal_code,advert_module_page_btime,advert_module_page_etime,advert_module_valid_itype");
				FROM("ad_advert_module_sd");
				WHERE("active_flag = 'y'");
				ORDER_BY("ad_advert_module_sd_seq desc limit #{offset},#{pageSize}");
			}
		}.toString();
		return sql;
	}
	
	public String getAdModuleCount(AdModuleVo adModuleVo){
		String sql = new SQL(){
			{
				SELECT("COUNT(1)");
				FROM("ad_advert_module_sd");
				WHERE("active_flag='y'");
			}
		}.toString();
		return 	sql;
	}
	
	/**
	 * 
	 * @Title:createAd
	 * @Description:创建广告
	 * @param advertisement
	 * @return String
	 */
	public String createAd(Advertisement advertisement){
		String sql = new SQL(){
			{
				INSERT_INTO("ad_advert_base_bb");
				VALUES("city_dict_country_code","#{countryCode}");
				VALUES("advert_base_internal_code","#{internalCode}");
				VALUES("advert_base_title","#{title}");
				VALUES("advert_base_desc","#{desc}");
				VALUES("advert_base_pic_url","#{picUrl}");
				VALUES("advert_base_link_itype","#{linkItype}");
				VALUES("advert_base_link_url","#{linkUrl}");
				VALUES("pub_app_section_sd_seq","#{linkId}");
				VALUES("advert_base_file_itype","#{fileItype}");
				VALUES("advert_base_valid_itype","#{validItype}");
				VALUES("advert_base_valid_btime","#{validBtime}");
				VALUES("advert_base_valid_etime","#{validEtime}");
				VALUES("advert_base_click_itype","#{clickItype}");
				VALUES("advert_base_status_itype","#{statusItype}");
				VALUES("advert_base_view_cnt","#{viewCnt}");
				VALUES("advert_base_click_cnt","#{clickCnt}");
				VALUES("create_by","#{creater}");
				VALUES("upload_By","#{uploader}");
				VALUES("upload_time","now()");
				VALUES("create_time","now()");
				VALUES("active_flag","'"+CommonConstantUtil.ACTIVE_FLAG_Y + "'");
				
			}
		}.toString();
		return sql;
	}
	
	public String updateAd(Advertisement advert){
			String sql = new SQL(){
				{
				UPDATE("ad_advert_base_bb");
				if(!StringUtil.isBlank(advert.getCountryCode())){
					SET("city_dict_country_code = #{countryCode}");
				}
				if(!StringUtil.isBlank(advert.getTitle())){
					SET("advert_base_title = #{title}");
				}
				if(!StringUtil.isBlank(advert.getDesc())){
					SET("advert_base_desc=#{desc}");
				}
				if(!StringUtil.isBlank(advert.getPicUrl())){
					SET("advert_base_pic_url=#{picUrl}");
				}
				if(advert.getLinkItype()>0){
					SET("advert_base_link_itype = #{linkItype}");
				}
				if(!StringUtil.isBlank(advert.getLinkUrl())){
					SET("advert_base_link_url=#{linkUrl}");
				}
				if(advert.getLinkId()>=0){
					SET("pub_app_section_sd_seq=#{linkId}");
				}
				if(advert.getValidItype()>0){
					SET("advert_base_valid_itype=#{validItype}");
				}
				if(advert.getValidBtime()!=null){
					SET("advert_base_valid_btime = #{validBtime}");
				}
				if(advert.getValidEtime()!=null){
					SET("advert_base_valid_etime = #{validEtime}");
				}
				if(advert.getClickItype()>0){
					SET("advert_base_click_itype = #{clickItype}");
				}
				if(advert.getStatusItype()>0){
					SET("advert_base_status_itype=#{statusItype}");
				}
				if(!StringUtil.isBlank(advert.getActiveFlag())){
					SET("active_flag = #{activeFlag}");
				}
				SET("update_by = #{updater}");
				SET("update_time =now()");
				WHERE("ad_advert_base_bb_seq = #{id} and active_flag = 'y'");
			}		
		}.toString();
		return sql;
	}
	
	/**
	 * 
	 * @Title:createAdAdress
	 * @Description:创建广告地址
	 * @param adAdress
	 * @return String
	 */
	public String createAdAdress(AdAdress adAdress){
		String sql = new SQL(){
			{
				INSERT_INTO("ad_xadvert_module_city_br");
				VALUES("ad_advert_base_bb_seq","#{adId}");
				VALUES("ad_advert_module_sd_seq","#{adModuleId}");
				VALUES("pub_city_dict_sd_seq","#{cityId}");
				VALUES("pub_city_dict_order","#{order}");
				VALUES("city_dict_country_code","#{countryCode}");
				VALUES("xadvert_module_show_itype","#{showType}");
				VALUES("create_by","#{creater}");
				VALUES("create_time","now()");
				VALUES("active_flag","'"+CommonConstantUtil.ACTIVE_FLAG_Y + "'");			
			}
		}.toString();
		return sql;
	}
	
	public String updateAdAdress(AdAdress adAdress){
		String sql = new SQL(){
			{
				UPDATE("ad_xadvert_module_city_br");
				if(adAdress.getAdModuleId()>0){
					SET("ad_advert_module_sd_seq=#{adModuleId}");
				}
				if(adAdress.getCityId()>0){
					SET("pub_city_dict_sd_seq= #{cityId}");
				}
				if(StringUtil.isBlank(adAdress.getCountryCode())){
					SET("city_dict_country_code = #{countryCode}");
				}
				if(adAdress.getShowType()>0){
					SET("xadvert_module_show_itype = #{showType}");
				}
				if(!StringUtil.isBlank(adAdress.getActiveFlag())){
					SET("active_flag = #{activeFlag}");
				}
				SET("update_by = #{updater}");
				SET("update_time =now()");
				WHERE("ad_advert_base_bb_seq = #{adId} AND active_flag = 'y'");
			}		
		}.toString();
		return sql;
	}
	
	/**
	 * 
	 * @Title:createAdModule
	 * @Description:创建广告模块
	 * @param adModule
	 * @return String
	 */
	public String createAdModule(AdModule adModule){
		String sql = new SQL(){
			{
				INSERT_INTO("ad_advert_module_sd");
				VALUES("advert_module_name","#{moduleName}");
				VALUES("advert_module_desc","#{moduleRemark}");
				VALUES("advert_module_banner_totals","#{bannerTotals}");
				VALUES("advert_module_set_itype","#{setType}");
				VALUES("advert_module_banner_itype","#{type}");
				VALUES("advert_module_internal_code","#{BannerCode}");
				VALUES("advert_module_page_btime","#{pageStartTime}");
				VALUES("advert_module_page_etime","#{pageEndTime}");
				VALUES("advert_module_valid_itype","#{validType}");
				VALUES("create_by","#{createBy}");
				VALUES("create_time","now()");
				VALUES("active_flag","'"+CommonConstantUtil.ACTIVE_FLAG_Y + "'");
			}
		}.toString();
		return sql;
	}
	
	/**
	 * 
	 * @Title:getAdBoById
	 * @Description:通过id获取广告信息
	 * @param id
	 * @return String
	 */
	public String getAdBoById(Map<String, Object> para){
		String sql = new SQL(){
			{
				SELECT("a.ad_advert_base_bb_seq,a.advert_base_desc,a.advert_base_title,a.advert_base_pic_url,a.advert_base_link_itype,a.advert_base_link_url,a.advert_base_status_itype,a.advert_base_click_itype,a.city_dict_country_code,a.advert_base_view_cnt,a.advert_base_click_cnt,a.advert_base_valid_itype,a.advert_base_valid_btime,a.advert_base_valid_etime,b.ad_advert_module_sd_seq,b.pub_city_dict_sd_seq,b.xadvert_module_show_itype");
				FROM("ad_advert_base_bb a , ad_xadvert_module_city_br b");
				WHERE(" a.ad_advert_base_bb_seq = b.ad_advert_base_bb_seq and a.active_flag='y' and b.active_flag='y' and a.ad_advert_base_bb_seq=" +para.get("id"));
			}
		}.toString();
		return sql;
	}
	

	


}
