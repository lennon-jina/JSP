package model;

public class BbsVO {

	private String discussionId;  /** 글 아이디 */
	private String itemCode; /** 종목 코드 */
    private String title; /** 글 제목 */
    private String writerId; /** 작성자 아이디 */
    private String readCount; /**  */
    
    
    public BbsVO() {
    }


	public String getDiscussionId() {
		return discussionId;
	}


	public void setDiscussionId(String discussionId) {
		this.discussionId = discussionId;
	}


	public String getItemCode() {
		return itemCode;
	}


	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getWriterId() {
		return writerId;
	}


	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}


	public String getReadCount() {
		return readCount;
	}


	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}


	@Override
	public String toString() {
		return "BbsVO [discussionId=" + discussionId + ", itemCode=" + itemCode + ", title=" + title + ", writerId="
				+ writerId + ", readCount=" + readCount + "]";
	}
    
    
    
    
}
