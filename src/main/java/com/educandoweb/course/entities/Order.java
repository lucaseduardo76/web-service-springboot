 package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.educandoweb.course.entities.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	private Integer orderstatus;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> itens = new HashSet<>();
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	public Order() {
	}

	public Order(Long id, Instant moment, OrderStatus orderstatus, User client) {
		this.id = id;
		this.moment = moment;
		setOrderstatus(orderstatus);
		this.client = client;
	}
	
	public Double getTotal() {
		Double value = 0.0;
		for(OrderItem x : itens) {
			value += x.getSubTotal();
		}
		
		return value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}
	

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderstatus() {
		return OrderStatus.valueOf(orderstatus);
	}

	public void setOrderstatus(OrderStatus orderstatus) {
		if (orderstatus != null) {
			this.orderstatus = orderstatus.getCode();
		}

	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	
	public Set<OrderItem> getItens() {
		return itens;
	}
	
	public Payment getPayment() {
		return payment;
	}
	
	public void setPayment(Payment obj) {
		this.payment = obj;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
