package com.hd.cloud.domain;

import java.util.List;

import com.hd.cloud.bo.PicBo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
  * @ClassName: FeedPost
  * @Description: 动态实体
  * @author yaojie yao.jie@hadoop-tech.com
  * @Company hadoop-tech
  * @date 2018年6月22日 上午10:09:24
  *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedPost {
	
	private long id;
	private int postType;// 类型,1.动态,2.话题,3.活动，4.投票5店铺预览分享
	private long topicId;// 话题id topicId
	private String content;// 内容
	private long forwardId;// 转发id forwardId
	private String title;// 标签
	private String recommend;// 推荐商品
	private double latitude;// 纬度
	private double longitude;// 经度
	private String area;// 区域
	private long cityId;// 城市id
	private int type = 0;// 动态状态 0.公开，1.好友，2.指定组员，3.指定好友
	private String groups;// 可见组id
	private String friends;// 可见好友id
	private int userItype;// 动态类型 1.用户 2.商家
	private int commentItype;// 是否可以评论 1不可评论，2可以评论
	private long company;// 公司id
	private long shopId;// 店铺
	private int shopStatus;//店铺状态
	private String address;// 地址
	private long favoriteCnt;// 点赞数
	private long commentCnt;// 评论数量
	private long browseCnt;// 浏览量
	private long storeCnt;// 收藏量
	private long shareCnt;//分享量
	private long author;// 作者
	private String picUrl;//首图片
	private int dispalyType;//显示状态：1是正常2是关闭3是屏蔽,4话题冻结状态
	private String shieldReason;//屏蔽理由
	private String createTime;// 创建时间
	private String updateTime;// 修改时间
	private long createBy;// 创建人
	private long updateBy;// 修改人
	private String activeFlag;
	private List<PicBo> list;
}
