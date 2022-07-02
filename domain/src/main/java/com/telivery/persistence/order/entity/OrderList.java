package com.telivery.persistence.order.entity;

import com.fasterxml.jackson.databind.ser.Serializers.Base;
import com.sun.istack.NotNull;
import com.telivery.common.domain.BaseEntity;
import com.telivery.persistence.category.entity.Category;
import com.telivery.persistence.menu.entity.Menu;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "order_list")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderList extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id")
  private Order order;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "menu_id")
  private Menu menu;

  @NotNull
  @Column(name = "total_price")
  private int totalPrice;

}
