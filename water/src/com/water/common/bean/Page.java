package com.water.common.bean;

import java.util.List;

/**
 * 
 * 类名: Page<BR>
 * 描述: 分页实体类<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月15日-上午11:11:32 <BR>
 * 
 * @version 1.0
 */
public class Page<T> {
	/** 总条数 */
	private Long totalItems;
	/** 总页数 */
	private Integer totalPages;
	/** 页码 */
	private Integer pageNo;
	/** 每页显示条数 */
	private Integer pageSize;
	/** 每页的内容 */
	private List<T> content;

	public Long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Long totalItems) {
		this.totalItems = totalItems;
	}

	public Integer getTotalPages() {
		if (totalPages == null) {
			totalPages = (int) (totalItems / pageSize);
			if (totalItems % pageSize != 0) {
				totalPages++;
			}
		}
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}


}
