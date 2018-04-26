package com.taotao.portal.pojo;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {

    private Long recordCount;

    private List<SearchItem> itemList;
    private int pageCount;
    private int curPage;
    
    public SearchResult(){
        
    }

	public Long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}

	public List<SearchItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<SearchItem> itemList) {
		this.itemList = itemList;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
    
   

}
