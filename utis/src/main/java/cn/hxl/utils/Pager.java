package cn.hxl.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具类
 * @author hp
 */
public class Pager {
	private int from;		//当前页
	private int count;		//每页数
	private List list;		//每页数据
	private List lists;		//全部数据
	private int countRow;	//最大页数
	private String url;		//URL
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Pager(int from,int count,List lists) {
		this.count=count;
		this.from=(from-1)*count;
		this.lists=lists;
	}
	
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	/**
	 * 返回分页数据
	 * @return
	 */
	public List getList() {
		list = new ArrayList();
		List l = new ArrayList();
		for(int i=from;i<lists.size();i++) {
			l.add(lists.get(i));
			if(l.size()==count)
			break;
		}
		this.list.addAll(l);
		
		return list;
	}

	public List getLists() {
		return lists;
	}
	public void setLists(List lists) {
		this.lists = lists;
	}
	
	/**
	 * 返回总条数
	 * @return
	 */
	public int getSunCount() {
		return lists.size();
	}

	/**
	 * 返回最大页数
	 * @return
	 */
	public int getCountRow() {
		return lists.size()%count==0?lists.size()/count:lists.size()/count+1;
	}
	
}
