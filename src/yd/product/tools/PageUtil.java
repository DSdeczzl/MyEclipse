package yd.product.tools;

public class PageUtil {
	private int startIndex = 1;// 起始页
	private int pageSize = 5;// 个数
	private int totalCount;// 总个数
	private int totalPage;// 总页数
	private String url;// 地址

	public PageUtil() {
		super();
	}

	public PageUtil(int startIndex, int pageSize, int totalCount,
			int totalPage, String url) {
		super();
		this.startIndex = startIndex;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getStartIndex() {
		if (totalPage == 0)
			return 0;
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		if (this.startIndex > 0)
			this.startIndex = startIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize > 0)
			this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (pageSize > 0) {
			this.totalCount = totalCount;
			totalPage = this.totalCount % pageSize == 0 ? (this.totalCount / pageSize)
					: this.totalCount / pageSize + 1;
		}
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
