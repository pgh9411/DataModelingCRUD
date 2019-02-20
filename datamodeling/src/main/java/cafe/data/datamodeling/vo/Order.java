package cafe.data.datamodeling.vo;

public class Order extends Account {
	private String orderDay;
	private String orderNumber;
	private String orderItemCode;
	private String orderCount;
	private String orderSum;
	public String getOrderDay() {
		return orderDay;
	}
	public void setOrderDay(String orderDay) {
		this.orderDay = orderDay;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderItemCode() {
		return orderItemCode;
	}
	public void setOrderItemCode(String orderItemCode) {
		this.orderItemCode = orderItemCode;
	}
	public String getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(String orderCount) {
		this.orderCount = orderCount;
	}
	public String getOrderSum() {
		return orderSum;
	}
	public void setOrderSum(String orderSum) {
		this.orderSum = orderSum;
	}
	@Override
	public String toString() {
		return "Order [orderDay=" + orderDay + ", orderNumber=" + orderNumber + ", orderItemCode=" + orderItemCode
				+ ", orderCount=" + orderCount + ", orderSum=" + orderSum + "]";
	}
	
	
}
