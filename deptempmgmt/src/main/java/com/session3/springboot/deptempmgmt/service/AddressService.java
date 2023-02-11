package com.session3.springboot.deptempmgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.session3.springboot.deptempmgmt.bean.AddressBean;

import com.session3.springboot.deptempmgmt.entity.Address;

import com.session3.springboot.deptempmgmt.repository.AddressServiceInt;
@Service
public class AddressService {
	@Autowired
	private AddressServiceInt addressService;
	
	public List<AddressBean> findAllAddress()
	{
		List<Address> addList= addressService.findAll();
		List<AddressBean> beanList=new ArrayList<>();
		addList.stream().
		forEach(add->beanList.add(new AddressBean(add)));
		return beanList;
	}
	public Address addAddress(Address addr)
	{
		return addressService.save(addr);
	}
	public Address findAddressById(int id)
	{
		return addressService.findById(id).get();
	}
	public void deleteAddressById(int addrId)
	{
		addressService.deleteById(addrId);
	}


}
