package br.com.altec.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	//contrutoru do enum é private 
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//criar método público para acessar status
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {    //percorrendo os valores do status
			//testando o valor code
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code"); 
		
	}
}
