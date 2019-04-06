package cn.imust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.imust.mapper.CouponMapper;
import cn.imust.pojo.Coupon;
import cn.imust.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService {
	@Autowired
	CouponMapper couponMapper;
	
	@Override
	public List<Coupon> listAll() {
		// TODO Auto-generated method stub
		return couponMapper.listAll();
	}

	@Override
	public Coupon getCouponById(int id) {
		// TODO Auto-generated method stub
		return couponMapper.getCouponById(id);
	}

	@Override
	public Coupon getCouponByS_id(int s_id) {
		// TODO Auto-generated method stub
		return couponMapper.getCouponByS_id(s_id);
	}

	@Override
	public void deleteCouponById(int id) {
		// TODO Auto-generated method stub
		couponMapper.deleteCouponById(id);
	}

	@Override
	public void add(Coupon coupon) {
		// TODO Auto-generated method stub
		couponMapper.add(coupon);
	}
	
}
