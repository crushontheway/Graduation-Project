package cn.imust.mapper;

import java.util.List;

import cn.imust.pojo.Coupon;

public interface CouponMapper {
	List<Coupon> listAll();
	Coupon getCouponById(int id);
	Coupon getCouponByS_id(int s_id);
	void deleteCouponById(int id);
	void add(Coupon coupon);
}
