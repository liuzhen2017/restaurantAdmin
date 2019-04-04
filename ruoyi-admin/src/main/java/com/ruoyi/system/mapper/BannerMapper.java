package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.Banner;

/**
 * 首頁banner 数据层
 * 
 * @author liuzhen
 * @date 2019-02-21
 */
public interface BannerMapper 
{
	/**
     * 查询首頁banner信息
     * 
     * @param id 首頁bannerID
     * @return 首頁banner信息
     */
	public Banner selectBannerById(Integer id);
	
	/**
     * 查询首頁banner列表
     * 
     * @param banner 首頁banner信息
     * @return 首頁banner集合
     */
	public List<Banner> selectBannerList(Banner banner);
	
	/**
     * 新增首頁banner
     * 
     * @param banner 首頁banner信息
     * @return 结果
     */
	public int insertBanner(Banner banner);
	
	/**
     * 修改首頁banner
     * 
     * @param banner 首頁banner信息
     * @return 结果
     */
	public int updateBanner(Banner banner);
	
	/**
     * 删除首頁banner
     * 
     * @param id 首頁bannerID
     * @return 结果
     */
	public int deleteBannerById(Integer id);
	
	/**
     * 批量删除首頁banner
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBannerByIds(String[] ids);
	
}