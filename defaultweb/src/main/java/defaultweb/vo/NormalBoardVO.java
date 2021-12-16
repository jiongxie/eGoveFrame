package defaultweb.vo;

public class NormalBoardVO extends NormalBoardDefaultVO
{
	private int idx;
	private String title;
	private String content;
	private String mid;
	private String wdate;
	public int getIdx()
	{
		return idx;
	}
	public void setIdx(int idx)
	{
		this.idx = idx;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getMid()
	{
		return mid;
	}
	public void setMid(String mid)
	{
		this.mid = mid;
	}
	public String getWdate()
	{
		return wdate;
	}
	public void setWdate(String wdate)
	{
		this.wdate = wdate;
	}
	@Override
	public String toString()
	{
		return "NormalBoardVO [idx=" + idx + ", title=" + title + ", content=" + content + ", mid=" + mid + ", wdate="
				+ wdate + "]";
	}
	
	
}
